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
import * as iam from "../iam";
import * as lambda from "../lambda";
import * as queue from "./queue";

import * as utils from "../utils";

export interface QueueEvent {
    Records: QueueRecord[];
}

export interface QueueRecord {
    messageId: string;
    receiptHandle: string;
    body: string;
    attributes: {
        ApproximateReceiveCount: string;
        SentTimestamp: string;
        SenderId: string;
        ApproximateFirstReceiveTimestamp: string;
    };
    messageAttributes: Record<string, any>;
    md5OfBody: string;
    eventSource: string;
    eventSourceARN: string;
    awsRegion: string;
}

export type QueueEventHandler = lambda.EventHandler<QueueEvent, void>;

/**
 * Arguments to control the sqs subscription.
 */
export type QueueEventSubscriptionArgs = {
    /**
     * The largest number of records that AWS Lambda will retrieve. The maximum batch size supported
     * by Amazon Simple Queue Service is up to 10 queue messages per batch. The default setting is
     * 10.
     *
     * See https://docs.aws.amazon.com/lambda/latest/dg/with-sqs.html for more details.
     */
    batchSize?: number;
 };

export class QueueEventSubscription extends lambda.EventSubscription {
    public readonly queue: queue.Queue;

    /**
     * The underlying sns object created for the subscription.
     */
    public readonly eventSourceMapping: lambda.EventSourceMapping;

    public constructor(
        name: string, queue: queue.Queue, handler: QueueEventHandler,
        args: QueueEventSubscriptionArgs = {}, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the queue. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:sqs:QueueEventSubscription", name, {
            parent: queue,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const parentOpts = { parent: this };
        this.func = createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            action: "lambda:*",
            function: this.func,
            principal: "sqs.amazonaws.com",
            sourceArn: queue.arn,
        }, parentOpts);

        this.eventSourceMapping = new lambda.EventSourceMapping(name, {
            batchSize: args.batchSize,
            enabled: true,
            eventSourceArn: queue.arn,
            functionName: this.func.name,
        }, parentOpts);

        this.queue = queue;

        this.registerOutputs();
    }
}

function createFunctionFromEventHandler(
    name: string, handler: QueueEventHandler, opts?: pulumi.CustomResourceOptions): lambda.Function {

    if (handler instanceof Function) {
        return new lambda.CallbackFunction(name, {
            callback: handler,
            policies: [iam.ManagedPolicy.AWSLambdaFullAccess, iam.ManagedPolicy.AmazonSQSFullAccess]
        } , opts);
    }
    else {
        return handler;
    }
}

declare module "./queue" {
    interface Queue {
        /**
         * Creates a new subscription to events fired from this Queue to the handler provided, along
         * with options to control the behavior of the subscription.
         */
        onEvent(
            name: string, handler: QueueEventHandler,
            args?: QueueEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): QueueEventSubscription;
    }
}

queue.Queue.prototype.onEvent = function(this: queue.Queue, name, handler, args, opts) {
    return new QueueEventSubscription(name, this, handler, args, opts);
}
