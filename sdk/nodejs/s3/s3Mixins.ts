// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as pulumi from "@pulumi/pulumi"
import { Bucket } from "./bucket";
import { BucketNotification } from "./bucketNotification";
import * as lambda from "../lambda"

import * as utils from "../utils";

/**
 * Arguments to help customize a notification subscription for a bucket.
 */
export interface CommonBucketSubscriptionArgs {
    /**
     * An optional prefix to filter down notifications.  See
     * aws.s3.BucketNotification.lambdaFunctions for more details.
     */
    filterPrefix?: string;

    /**
     * An optional suffix to filter down notifications.  See
     * aws.s3.BucketNotification.lambdaFunctions for more details.
     */
    filterSuffix?: string;
}

export interface BucketEventSubscriptionArgs extends CommonBucketSubscriptionArgs {
    /**
     * Events to subscribe to. For example: "[s3:ObjectCreated:*]".  Cannot be empty.
     */
    events: string[];
}

/**
 * Arguments to specifically control a subscription to 'ObjectCreated' notifications on a bucket.If
 * more events than just 'ObjectCreated' events are desired, the 'subscribe' function should be used
 * instead.
 */
export interface ObjectCreatedSubscriptionArgs extends CommonBucketSubscriptionArgs {
    // The type of event to listen for.  '*' is the default if not provided.
    event?: "*" | "Put" | "Post" | "Copy" | "CompleteMultipartUpload";
}

/**
 * Arguments to specifically control a subscription to 'ObjectRemoved' notifications on a bucket. If
 * more events than just 'ObjectRemoved' events are desired, the 'subscribe' function should be used
 * instead.
 */
export interface ObjectRemovedSubscriptionArgs extends CommonBucketSubscriptionArgs {
    // The type of event to listen for.  '*' is the default if not provided.
    event?: "*" | "Delete" | "DeleteMarkerCreated";
}

// See https://docs.aws.amazon.com/AmazonS3/latest/dev/notification-content-structure.html.
export interface BucketEvent {
    Records?: BucketRecord[];
}

export interface BucketRecord {
    eventVersion: string;
    eventSource: string;
    awsRegion: string;
    eventTime: string;
    eventName: string;
    userIdentity: {
        principalId: string;
    };
    requestParameters: {
        sourceIPAddress: string;
    };
    responseElements: {
        "x-amz-request-id": string;
        "x-amz-id-2": string;
    };
    s3: {
        s3SchemaVersion: string;
        configurationId: string;
        bucket: {
            name: string;
            ownerIdentity: {
                principalId: string;
            },
            arn: string;
        };
        object: {
            key: string;
            size: number;
            eTag: string;
            versionId?: string;
            sequencer: string;
        };
    };
}

export type BucketEventHandler = lambda.EventHandler<BucketEvent, void>;

interface SubscriptionInfo {
    name: string;
    events: string[];
    filterPrefix?: string;
    filterSuffix?: string;
    lambdaFunctionArn: pulumi.Output<string>;
    permission: lambda.Permission;

    provider: pulumi.ProviderResource;
}

let bucketSubscriptionInfos = new Map<Bucket, SubscriptionInfo[]>();

/**
 * A component corresponding to a single underlying aws.s3.BucketNotification created for a bucket.
 * Note: due to the AWS requirement that all notifications for a bucket be defined at once, the
 * actual aws.s3.BucketNotification instances will only be created once the pulumi program runs to
 * completion and all subscriptions have been heard about.
 */
export class BucketEventSubscription extends lambda.EventSubscription {
    public readonly bucket: Bucket;

    public constructor(
        name: string, bucket: Bucket, handler: BucketEventHandler,
        args: BucketEventSubscriptionArgs, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the queue. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:s3:BucketEventSubscription", name, {
            parent: bucket,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const parentOpts = { parent: this };
        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            function: this.func.name,
            action: "lambda:InvokeFunction",
            principal: "s3.amazonaws.com",
            sourceArn: bucket.arn,
        }, parentOpts);

        // We must create only a single BucketNotification per Bucket per AWS API limitations.  See
        // https://github.com/terraform-providers/terraform-provider-aws/issues/1715.  So we push
        // the subscription information here, and then actually create the BucketNotification if
        // needed on process `beforeExit`.
        let subscriptions = bucketSubscriptionInfos.get(bucket);
        if (!subscriptions) {
            subscriptions = [];
            bucketSubscriptionInfos.set(bucket, subscriptions);
        }

        subscriptions.push({
            name: name,
            events: args.events,
            filterPrefix: args.filterPrefix,
            filterSuffix: args.filterSuffix,
            lambdaFunctionArn: this.func.arn,
            permission: this.permission,

            // See https://github.com/pulumi/pulumi/issues/2262 for full details.
            //
            // pulumi.Resource does not set the provider for a *custom* resource if the parent is
            // another *custom* resource. This is problematic as that BucketNotification has to
            // agree with the Bucket on their provider so that things like 'region' are properly
            // shared between the two.  As a temporary workaround we explicitly pull the provider
            // out of the parent bucket and pass it along. We use the "aws::" form as we know that
            // Resource will pull off the "aws" portion to grab that provider.
            provider: this.getProvider("aws::")!,
        });

        this.bucket = bucket;

        this.registerOutputs();
    }
}

process.on("beforeExit", () => {
    const copy = bucketSubscriptionInfos;

    // Since we are generating more work on the event loop, we will cause `beforeExit` to be invoked again.
    // Make sure to clear out eh pending subscriptions array so that we don't try to apply them again.
    bucketSubscriptionInfos = new Map();

    for (const [bucket, subscriptions] of copy) {
        const permissions = subscriptions.map(s => s.permission);

        // See https://github.com/pulumi/pulumi/issues/2262 for full details.
        //
        // We just use the provider for the first subscription here.  In the future we will be able
        // to grab the provider from the bucket, which acts as our single logical parent.
        const opts = { parent: bucket, dependsOn: permissions, provider: subscriptions[0].provider };

        const _ = new BucketNotification(subscriptions[0].name, {
            bucket: bucket.id,
            lambdaFunctions: subscriptions.map(subscription => ({
                events: subscription.events,
                filterPrefix: subscription.filterPrefix,
                filterSuffix: subscription.filterSuffix,
                lambdaFunctionArn: subscription.lambdaFunctionArn,
            })),
        }, opts);
    }
});

// Mixin event handling functionality onto Bucket.
declare module "./bucket" {
    interface Bucket {
        /**
         * Creates a new subscription to events fired from this Bucket to the handler provided,
         * along with options to control the behavior of the subscription.  The handler will be
         * called whenever a matching [s3.Object] is created.
         */
        onObjectCreated(
            name: string, handler: BucketEventHandler,
            args?: ObjectCreatedSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): BucketEventSubscription;

        /**
         * Creates a new subscription to events fired from this Bucket to the handler provided,
         * along with options to control the behavior of the subscription.  The handler will be
         * called whenever an matching [s3.Object] is removed.
         */
        onObjectRemoved(
            name: string, handler: BucketEventHandler,
            args?: ObjectRemovedSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): BucketEventSubscription;

        /**
         * Creates a new subscription to events fired from this Bucket to the handler provided,
         * along with options to control the behavior of the subscription.  This function should be
         * used when full control over the subscription is wanted, and other helpers (like
         * onObjectCreated/onObjectRemoved) are not sufficient.
         */
        onEvent(
            name: string, handler: BucketEventHandler,
            args: BucketEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): BucketEventSubscription;
    }
}

Bucket.prototype.onObjectCreated = function (this: Bucket, name, handler, args, opts) {
    args = args || {};
    args.event = args.event || "*";

    const argsCopy = {
        filterPrefix: args.filterPrefix,
        filterSuffix: args.filterSuffix,
        events: ["s3:ObjectCreated:" + args.event],
    };

    return this.onEvent(name, handler, argsCopy, opts);
}

Bucket.prototype.onObjectRemoved = function (this: Bucket, name, handler, args, opts) {
    args = args || {};
    args.event = args.event || "*";

    const argsCopy = {
        filterPrefix: args.filterPrefix,
        filterSuffix: args.filterSuffix,
        events: ["s3:ObjectRemoved:" + args.event],
    };

    return this.onEvent(name, handler, argsCopy, opts);
}

Bucket.prototype.onEvent = function (this: Bucket, name, handler, args, opts) {
    return new BucketEventSubscription(name, this, handler, args, opts);
}
