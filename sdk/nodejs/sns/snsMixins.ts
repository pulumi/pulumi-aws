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
 * Arguments to control the topic subscription.  Currently empty, but still defined in case of
 * future need.
 */
export type TopicEventSubscriptionArgs = { };

export class TopicEventSubscription extends lambda.EventSubscription {
    public readonly topic: topic.Topic;

    /**
     * The underlying sns object created for the subscription.
     */
    public readonly subscription: topicSubscription.TopicSubscription;

    public constructor(
        name: string, topic: topic.Topic, handler: TopicEventHandler,
        args: TopicEventSubscriptionArgs = {}, opts: pulumi.ComponentResourceOptions = {}) {

        super("aws:sns:TopicEventSubscription", name, opts);

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
            topic: topic,
            protocol: "lambda",
            endpoint: this.func.arn,
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

topic.Topic.prototype.onEvent = function(this: topic.Topic, name, handler, args, opts) {
    return new TopicEventSubscription(name, this, handler, args, opts);
}
