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

import { EventRule } from "./eventRule";
import { LogGroup } from "./logGroup";

export module metrics {
    export module events {
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
        function metric(metricName: CloudwatchEventMetricName, change: MetricChange = {} = {}) {
            return new Metric({
                namespace: "AWS/Events",
                name: metricName,
                ...change,
            });
        }

        /**
         * Measures the number of times a rule’s target is not invoked in response to an event. This
         * includes invocations that would result in triggering the same rule again, causing an
         * infinite loop.
         *
         * Valid Dimensions: RuleName
         * Units: Count
         */
        export function deadLetterInvocations(change: MetricChange = {}) {
            return metric("DeadLetterInvocations", { unit: "Count", ...change });
        }

        /**
         * Measures the number of times a target is invoked for a rule in response to an event. This
         * includes successful and failed invocations, but does not include throttled or retried attempts
         * until they fail permanently. It does not include DeadLetterInvocations.
         *
         * Note: CloudWatch Events only sends this metric to CloudWatch if it has a non-zero value.
         *
         * Valid Dimensions: RuleName
         * Units: Count
         */
        export function invocations(change: MetricChange = {}) {
            return metric("Invocations", { unit: "Count", ...change });
        }

        /**
         * Measures the number of invocations that failed permanently. This does not include invocations
         * that are retried, or that succeeded after a retry attempt. It also does not count failed
         * invocations that are counted in DeadLetterInvocations.
         *
         * Valid Dimensions: RuleName
         * Units: Count
         */
        export function failedInvocations(change: MetricChange = {}) {
            return metric("FailedInvocations", { unit: "Count", ...change });
        }

        /**
         * Measures the number of triggered rules that matched with any event.
         *
         * Valid Dimensions: RuleName
         * Units: Count
         */
        export function triggeredRules(change: MetricChange = {}) {
            return metric("TriggeredRules", { unit: "Count", ...change });
        }

        /**
         * Measures the number of events that matched with any rule.
         *
         * Valid Dimensions: None
         * Units: Count
         */
        export function matchedEvents(change: MetricChange = {}) {
            return metric("MatchedEvents", { unit: "Count", ...change });
        }

        /**
         * Measures the number of triggered rules that are being throttled.
         *
         * Valid Dimensions: RuleName
         * Units: Count
         */
        export function throttledRules(change: MetricChange = {}) {
            return metric("ThrottledRules", { unit: "Count", ...change });
        }
    }

    export module logs {
        export type CloudwatchLogMetricName =
            "IncomingBytes" | "IncomingLogEvents" | "ForwardedBytes" | "ForwardedLogEvents" |
            "DeliveryErrors" | "DeliveryThrottling";

        /**
         * CloudWatch Logs sends metrics to Amazon CloudWatch every minute.
         *
         * Creates an AWS/Logs metric with the requested [metricName]. See
         * https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CloudWatch-Logs-Monitoring-CloudWatch-Metrics.html
         * for list of all metric-names.
         *
         * Note, individual metrics can easily be obtained without supplying the name using the other
         * [metricXXX] functions.
         *
         * The dimensions that you can use with CloudWatch Logs metrics are:
         * 1. "LogGroupName": The name of the CloudWatch Logs log group for which to display metrics.
         * 2. "DestinationType": The subscription destination for the CloudWatch Logs data, which can be AWS
         *    Lambda, Amazon Kinesis Data Streams, or Amazon Kinesis Data Firehose.
         * 3. "FilterName": The name of the subscription filter that is forwarding data from the log group
         *    to the destination. The subscription filter name is automatically converted by CloudWatch to
         *    ASCII and any unsupported characters get replaced with a question mark (?).
         */
        function metric(metricName: CloudwatchLogMetricName, change: MetricChange = {} = {}) {
            return new Metric({
                namespace: "AWS/Logs",
                name: metricName,
                ...change,
            });
        }

        /**
         * The volume of log events in uncompressed bytes uploaded to CloudWatch Logs. When used
         * with the LogGroupName dimension, this is the volume of log events in uncompressed bytes
         * uploaded to the log group.
         *
         * Valid Dimensions: LogGroupName
         * Valid Statistic: Sum
         * Units: Bytes
         */
        export function incomingBytes(change: MetricChange = {}) {
            return metric("IncomingBytes", { statistic: "Sum", unit: "Bytes", ...change });
        }

        /**
         * The number of log events uploaded to CloudWatch Logs. When used with the LogGroupName dimension,
         * this is the number of log events uploaded to the log group.
         *
         * Valid Dimensions: LogGroupName
         * Valid Statistic: Sum
         * Units: None
         */
        export function incomingLogEvents(change: MetricChange = {}) {
            return metric("IncomingLogEvents", { statistic: "Sum", unit: "None", ...change });
        }

        /**
         * The volume of log events in compressed bytes forwarded to the subscription destination.
         *
         * Valid Dimensions: LogGroupName, DestinationType, FilterName
         * Valid Statistic: Sum
         * Units: Bytes
         */
        export function forwardedBytes(change: MetricChange = {}) {
            return metric("ForwardedBytes", { statistic: "Sum", unit: "Bytes", ...change });
        }

        /**
         * The number of log events forwarded to the subscription destination.
         *
         * Valid Dimensions: LogGroupName, DestinationType, FilterName
         * Valid Statistic: Sum
         * Units: None
         */
        export function forwardedLogEvents(change: MetricChange = {}) {
            return metric("ForwardedLogEvents", { statistic: "Sum", unit: "None", ...change });
        }

        /**
         * The number of log events for which CloudWatch Logs received an error when forwarding data to the
         * subscription destination.
         *
         * Valid Dimensions: LogGroupName, DestinationType, FilterName
         * Valid Statistic: Sum
         * Units: None
         */
        export function deliveryErrors(change: MetricChange = {}) {
            return metric("DeliveryErrors", { statistic: "Sum", unit: "None", ...change });
        }

        /**
         * The number of log events for which CloudWatch Logs was throttled when forwarding data to the
         * subscription destination.
         *
         * Valid Dimensions: LogGroupName, DestinationType, FilterName
         * Valid Statistic: Sum
         * Units: None
         */
        export function deliveryThrottling(change: MetricChange = {}) {
            return metric("DeliveryThrottling", { statistic: "Sum", unit: "None", ...change });
        }
    }
}

declare module "./eventRule" {
    interface EventRule {
        /**
         * Direct access to create metrics for this specific [cloudwatch.EventRule].
         */
        metrics: {
            /**
             * Measures the number of times a rule’s target is not invoked in response to an event. This
             * includes invocations that would result in triggering the same rule again, causing an
             * infinite loop.
             *
             * Units: Count
             */
            deadLetterInvocations(change?: MetricChange): Metric;

            /**
             * Measures the number of times a target is invoked for a rule in response to an event. This
             * includes successful and failed invocations, but does not include throttled or retried attempts
             * until they fail permanently. It does not include DeadLetterInvocations.
             *
             * Note: CloudWatch Events only sends this metric to CloudWatch if it has a non-zero value.
             *
             * Units: Count
             */
            invocations(change?: MetricChange): Metric;

            /**
             * Measures the number of invocations that failed permanently. This does not include invocations
             * that are retried, or that succeeded after a retry attempt. It also does not count failed
             * invocations that are counted in DeadLetterInvocations.
             *
             * Units: Count
             */
            failedInvocations(change?: MetricChange): Metric;

            /**
             * Measures the number of triggered rules that matched with any event.
             *
             * Units: Count
             */
            triggeredRules(change?: MetricChange): Metric;

            /**
             * Measures the number of triggered rules that are being throttled.
             *
             * Units: Count
             */
            throttledRules(change?: MetricChange): Metric;
        }
    }
}

// All instance metrics just make a normal AWS/Events metric, except with the RuleName set
// correctly.

Object.defineProperty(EventRule.prototype, "metrics", {
    get: function (this: EventRule) {
        const dimensions = { dimensions: { RuleName: this.name } };
        const result = {};
        for (const name in metrics.events) {
            result[name] = (change: MetricChange) => metrics.events[name](dimensions).with(change);
        }
        return result;
    }
});

declare module "./logGroup" {
    interface LogGroup {
        /**
         * Direct access to create metrics for this specific [cloudwatch.LogGroup].
         */
        metrics: {
            /**
             * The volume of log events in uncompressed bytes uploaded to CloudWatch Logs. When used
             * with the LogGroupName dimension, this is the volume of log events in uncompressed bytes
             * uploaded to the log group.
             *
             * Valid Statistic: Sum
             * Units: Bytes
             */
            incomingBytes(change?: MetricChange): Metric;

            /**
             * The number of log events uploaded to CloudWatch Logs. When used with the LogGroupName dimension,
             * this is the number of log events uploaded to the log group.
             *
             * Valid Statistic: Sum
             * Units: None
             */
            incomingLogEvents(change?: MetricChange): Metric;

            /**
             * The volume of log events in compressed bytes forwarded to the subscription destination.
             *
             * Additional Dimensions: DestinationType, FilterName
             * Valid Statistic: Sum
             * Units: Bytes
             */
            forwardedBytes(change?: MetricChange): Metric;

            /**
             * The number of log events forwarded to the subscription destination.
             *
             * Additional Dimensions: DestinationType, FilterName
             * Valid Statistic: Sum
             * Units: None
             */
            forwardedLogEvents(change?: MetricChange): Metric;

            /**
             * The number of log events for which CloudWatch Logs received an error when forwarding data to the
             * subscription destination.
             *
             * Additional Dimensions: DestinationType, FilterName
             * Valid Statistic: Sum
             * Units: None
             */
            deliveryErrors(change?: MetricChange): Metric;

            /**
             * The number of log events for which CloudWatch Logs was throttled when forwarding data to the
             * subscription destination.
             *
             * Additional Dimensions: DestinationType, FilterName
             * Valid Statistic: Sum
             * Units: None
             */
            deliveryThrottling(change?: MetricChange): Metric;
        }
    }
}

// All instance metrics just make a normal AWS/Logs metric, except with the LogGroupName set
// appropriate.

Object.defineProperty(LogGroup.prototype, "metrics", {
    get: function (this: LogGroup) {
        const dimensions = { dimensions: { LogGroupName: this.name } };
        const result = {};
        for (const name in metrics.logs) {
            result[name] = (change: MetricChange) => metrics.logs[name](dimensions).with(change);
        }
        return result;
    }
});
