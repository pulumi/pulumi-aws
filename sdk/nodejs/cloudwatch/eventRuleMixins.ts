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
import * as eventRule from "./eventRule";
import * as eventTarget from "./eventTarget";

import * as utils from "../utils";

/**
 * Arguments to control the event rule subscription.  Currently empty, but still defined in case of
 * future need.
 */
export interface EventRuleEventSubscriptionArgs {
}

export interface EventRuleEvent {
    // aws version.
    version: string;

    // The 12-digit number identifying an AWS account.
    account: string;

    // Identifies the AWS region where the event originated.
    region: string;

    // Identifies, in combination with the source field, the fields and values that appear in the
    // detail field.
    "detail-type": string;

    // Identifies the service that sourced the event. All events sourced from within AWS begin with
    // "aws." Customer-generated events can have any value here, as long as it doesn't begin with
    // "aws." We recommend the use of Java package-name style reverse domain-name strings.
    source: string;

    // The event timestamp, which can be specified by the service originating the event. If the
    // event spans a time interval, the service might choose to report the start time, so this value
    // can be noticeably before the time the event is actually received.
    time: string;

    // A unique value is generated for every event. This can be helpful in tracing events as they
    // move through rules to targets, and are processed.
    id: string;

    // This JSON array contains ARNs that identify resources that are involved in the event.
    // Inclusion of these ARNs is at the discretion of the service. For example, Amazon EC2 instance
    // state-changes include Amazon EC2 instance ARNs, Auto Scaling events include ARNs for both
    // instances and Auto Scaling groups, but API calls with AWS CloudTrail do not include resource
    // ARNs.
    resources: string[];

    // A JSON object, whose content is at the discretion of the service originating the event.
    detail: Record<string, any>;
}

export type EventRuleEventHandler = lambda.EventHandler<EventRuleEvent, void>;

export class EventRuleEventSubscription extends lambda.EventSubscription {
    public readonly eventRule: eventRule.EventRule;
    public readonly target: eventTarget.EventTarget;

    public constructor(
        name: string, eventRuleOrSchedule: eventRule.EventRule | string, handler: EventRuleEventHandler,
        args?: EventRuleEventSubscriptionArgs, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the eventRule. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        const parent = typeof eventRuleOrSchedule === "string" ? undefined : eventRuleOrSchedule;
        super("aws:cloudwatch:EventRuleEventSubscription", name, {
            parent: parent,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const parentOpts = { parent: this };
        if (typeof eventRuleOrSchedule === "string") {
            this.eventRule = new eventRule.EventRule(name, {
                scheduleExpression: eventRuleOrSchedule
            },
                parentOpts);
        }
        else {
            this.eventRule = eventRuleOrSchedule;
        }

        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            action: "lambda:invokeFunction",
            function: this.func,
            principal: "events.amazonaws.com",
            sourceArn: this.eventRule.arn.apply(x => x!),
        }, parentOpts);

        this.target = new eventTarget.EventTarget(name, {
            rule: this.eventRule.name,
            arn: this.func.arn.apply(x => x!),
            targetId: name,
            eventBusName: this.eventRule.eventBusName.apply(x => x!),
        }, parentOpts);

        this.registerOutputs();
    }
}

// Mixin helpers to create lambda triggers directly from an event rule event.

declare module "./eventRule" {
    interface EventRule {
        /**
         * Creates a new subscription to events fired from this EventRule to the handler provided, along
         * with options to control the behavior of the subscription.
         */
        onEvent(name: string, handler: EventRuleEventHandler,
            args?: EventRuleEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): EventRuleEventSubscription;
    }
}

eventRule.EventRule.prototype.onEvent = function (this: eventRule.EventRule, name, handler, args, opts) {
    return new EventRuleEventSubscription(name, this, handler, args, opts);
}
