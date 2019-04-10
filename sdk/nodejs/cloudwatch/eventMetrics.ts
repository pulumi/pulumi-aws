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
import { Metric, MetricChange } from "./metric";

export type CloudwatchEventMetricName =
    "DeadLetterInvocations" | "Invocations" | "FailedInvocations" | "TriggeredRules" |
    "MatchedEvents" | "ThrottledRules";

/**
 * CloudWatch Events sends metrics to Amazon CloudWatch every minute.
 *
 * Creates an AWS/Events metric with the requested [metricName]. See
 * https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/CloudWatch-Events-Monitoring-CloudWatch-Metrics.html
 * for list of all metric-names.
 *
 * Note, individual metrics can easily be obtained without supplying the name using the other
 * [metricXXX] functions.
 *
 * All of these metrics use Count as the unit, so Sum and SampleCount are the most useful
 * statistics.
 *
 * CloudWatch Events metrics have one dimension:
 * 1. "RuleName": Filters the available metrics by rule name.
 */
export function eventMetric(metricName: CloudwatchEventMetricName, change: MetricChange = {} = {}) {
    return new Metric({
        namespace: "AWS/Events",
        name: metricName,
        ...change,
    });
}

/**
 * Measures the number of times a rule’s target is not invoked in response to an event. This
 * includes invocations that would result in triggering the same rule again, causing an infinite
 * loop.
 */
export function metricDeadLetterInvocations(change: MetricChange = {}) {
    return eventMetric("DeadLetterInvocations", { unit: "Count", ...change });
}

/**
 * Measures the number of times a target is invoked for a rule in response to an event. This
 * includes successful and failed invocations, but does not include throttled or retried attempts
 * until they fail permanently. It does not include DeadLetterInvocations.
 *
 * Note: CloudWatch Events only sends this metric to CloudWatch if it has a non-zero value.
 */
export function metricInvocations(change: MetricChange = {}) {
    return eventMetric("Invocations", { unit: "Count", ...change });
}

/**
 * Measures the number of invocations that failed permanently. This does not include invocations
 * that are retried, or that succeeded after a retry attempt. It also does not count failed
 * invocations that are counted in DeadLetterInvocations.
 */
export function metricFailedInvocations(change: MetricChange = {}) {
    return eventMetric("FailedInvocations", { unit: "Count", ...change });
}

/**
 * Measures the number of triggered rules that matched with any event.
 */
export function metricTriggeredRules(change: MetricChange = {}) {
    return eventMetric("TriggeredRules", { unit: "Count", ...change });
}

/**
 * Measures the number of events that matched with any rule.
 */
export function metricMatchedEvents(change: MetricChange = {}) {
    return eventMetric("MatchedEvents", { unit: "Count", ...change });
}

/**
 * Measures the number of triggered rules that are being throttled.
 */
export function metricThrottledRules(change: MetricChange = {}) {
    return eventMetric("ThrottledRules", { unit: "Count", ...change });
}
