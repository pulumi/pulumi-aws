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

import * as pulumi from "@pulumi/pulumi";
import * as lambda from "../lambda";
import * as topic from "./topic";
import * as topicSubscription from "./topicSubscription";

import * as utils from "../utils";

export interface TopicEvent {
    Records: TopicRecord[];
}

export interface TopicRecord {
    EventVersion: string;
    EventSubscriptionArn: string;
    EventSource: string;
    Sns: SNSItem;
}

export interface SNSItem {
    SignatureVersion: string;
    Timestamp: string;
    Signature: string;
    SigningCertUrl: string;
    MessageId: string;
    Message: string;
    MessageAttributes: { [key: string]: SNSMessageAttribute };
    Type: string;
    UnsubscribeUrl: string;
    TopicArn: string;
    Subject: string;
}

export interface SNSMessageAttribute {
    Type: string;
    Value: string;
}

export type TopicEventHandler = lambda.EventHandler<TopicEvent, void>;

/**
 * Arguments to control the topic subscription.
 */
export type TopicEventSubscriptionArgs = {
    /**
     * Integer indicating number of minutes to wait in retrying mode for fetching subscription arn before marking it as failure. Only applicable for http and https protocols. Default is `1`.
     */
    confirmationTimeoutInMinutes?: pulumi.Input<number>;
    /**
    * JSON String with the delivery policy (retries, backoff, etc.) that will be used in the subscription - this only applies to HTTP/S subscriptions. Refer to the [SNS docs](https://docs.aws.amazon.com/sns/latest/dg/DeliveryPolicies.html) for more details.
    */
    deliveryPolicy?: pulumi.Input<string>;
    /**
     * Whether the endpoint is capable of [auto confirming subscription](http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.html#SendMessageToHttp.prepare) (e.g., PagerDuty). Default is `false`.
     */
    endpointAutoConfirms?: pulumi.Input<boolean>;
    /**
     * JSON String with the filter policy that will be used in the subscription to filter messages seen by the target resource. Refer to the [SNS docs](https://docs.aws.amazon.com/sns/latest/dg/message-filtering.html) for more details.
     */
    filterPolicy?: pulumi.Input<string>;
    /**
     * Whether the `filterPolicy` applies to `MessageAttributes` (default) or `MessageBody`.
     */
    filterPolicyScope?: pulumi.Input<string>;
    /**
     * Whether to enable raw message delivery (the original message is directly passed, not wrapped in JSON with the original message in the message property). Default is `false`.
     */
    rawMessageDelivery?: pulumi.Input<boolean>;
     /**
     * JSON String with the redrive policy that will be used in the subscription. Refer to the [SNS docs](https://docs.aws.amazon.com/sns/latest/dg/sns-dead-letter-queues.html#how-messages-moved-into-dead-letter-queue) for more details.
     */
     redrivePolicy?: pulumi.Input<string>;
};

export class TopicEventSubscription extends lambda.EventSubscription {
    public readonly topic: topic.Topic;

    /**
     * The underlying sns object created for the subscription.
     */
    public readonly subscription: topicSubscription.TopicSubscription;

    public constructor(
        name: string, topic: topic.Topic, handler: TopicEventHandler,
        args: TopicEventSubscriptionArgs = {}, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the topic. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:sns:TopicEventSubscription", name, {
            parent: topic,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        this.topic = topic;

        const parentOpts = { parent: this };
        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            action: "lambda:invokeFunction",
            function: this.func,
            principal: "sns.amazonaws.com",
            sourceArn: topic.id,
        }, parentOpts);

        this.subscription = new topicSubscription.TopicSubscription(name, {
            topic: topic.id,
            protocol: "lambda",
            endpoint: this.func.arn,
            confirmationTimeoutInMinutes: args.confirmationTimeoutInMinutes,
            deliveryPolicy: args.deliveryPolicy,
            endpointAutoConfirms: args.endpointAutoConfirms,
            filterPolicy: args.filterPolicy,
            filterPolicyScope: args.filterPolicyScope,
            rawMessageDelivery: args.rawMessageDelivery,
            redrivePolicy: args.redrivePolicy,
        }, parentOpts);

        this.registerOutputs();
    }
}

declare module "./topic" {
    interface Topic {
        /**
         * Creates a new subscription to events fired from this Topic to the handler provided, along
         * with options to control the behavior of the subscription.
         */
        onEvent(
            name: string, handler: TopicEventHandler,
            args?: TopicEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): TopicEventSubscription;
    }
}

topic.Topic.prototype.onEvent = function (this: topic.Topic, name, handler, args, opts) {
    return new TopicEventSubscription(name, this, handler, args, opts);
}
