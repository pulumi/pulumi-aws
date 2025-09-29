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
import * as eventRule from "./eventRuleMixins";

/**
 * Creates a CloudWatch event that will fire based on the specified schedule.  This will create
 * an EventRule which will then invoke the provided handler every time it fires.
 */
export function onSchedule(
        name: string, schedule: string,
        handler: eventRule.EventRuleEventHandler,
        args?: eventRule.EventRuleEventSubscriptionArgs,
        opts?: pulumi.ComponentResourceOptions): eventRule.EventRuleEventSubscription {
    return new eventRule.EventRuleEventSubscription(name, schedule, handler, args, opts);
}
