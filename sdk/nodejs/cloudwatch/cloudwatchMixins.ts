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

import * as sns from "../sns";
import * as utils from "../utils";

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

/**
 * Metrics are the fundamental concept in CloudWatch. A metric represents a time-ordered set of data
 * points that are published to CloudWatch. Think of a metric as a variable to monitor, and the data
 * points as representing the values of that variable over time. For example, the CPU usage of a
 * particular EC2 instance is one metric provided by Amazon EC2. The data points themselves can come
 * from any application or business activity from which you collect data.
 *
 * AWS services send metrics to CloudWatch, and you can send your own custom metrics to CloudWatch.
 * You can add the data points in any order, and at any rate you choose. You can retrieve statistics
 * about those data points as an ordered set of time-series data.
 *
 * Metrics exist only in the region in which they are created. Metrics cannot be deleted, but they
 * automatically expire after 15 months if no new data is published to them. Data points older than
 * 15 months expire on a rolling basis; as new data points come in, data older than 15 months is
 * dropped.
 *
 * Metrics are uniquely defined by a name, a namespace, and zero or more dimensions. Each data point
 * in a metric has a time stamp, and (optionally) a unit of measure. You can retrieve statistics
 * from CloudWatch for any metric.
 *
 * see https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch_concepts.html#Metric
 * for more details.
 */
export class Metric {
    /**
     * The name for this metric. See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    metricName: pulumi.Output<string>;
    /**
     * The dimensions for this metric.  For the list of available dimensions see the AWS documentation
     * [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    dimensions: pulumi.Output<Record<string, any> | undefined>;
    /**
     * The namespace for this metric. See docs for the
     * [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    namespace: pulumi.Output<string>;
    /**
     * The period in seconds over which the specified [statistic] is applied.  Must be in multiples
     * of 60. Periods are defined in numbers of seconds, and valid values for period are 1, 5, 10,
     * 30, or any multiple of 60. For example, to specify a period of six minutes, use 360 as the
     * period value. You can adjust how the data is aggregated by varying the length of the period.
     * A period can be as short as one second or as long as one day (86,400 seconds). The default
     * value is 60 seconds.
     *
     * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch_concepts.html
     * for more details.
     */
    period: pulumi.Output<number>;
    /**
     * The statistic to apply to the alarm's associated metric. Either of the following is
     * supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`.
     *
     * Defaults to [Average] if unspecified.
     */
    statistic: pulumi.Output<MetricStatistic>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * [0.0] and [100].
     */
    extendedStatistic: pulumi.Output<number | undefined>;
    /**
     * The unit for this metric.
     *
     * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
     */
    unit: pulumi.Output<MetricUnit | undefined>;

    /**
     * @param resource Optional resource this is a metric for.  This is only used for parenting
     * purposes.  i.e. if an [Alarm] is created from this [Metric], then [resource] will be used as
     * the parent of the alarm by default.
     */
    constructor(args: MetricArgs, resource?: pulumi.Resource) {
        this.metricName = pulumi.output(args.metricName);
        this.dimensions = pulumi.output(args.dimensions);
        this.namespace = pulumi.output(args.namespace);
        this.period = utils.ifUndefined(args.period, 60).apply(period => {
            // valid values for period are 1, 5, 10, 30, or any multiple of 60
            if (period !== 1 && period !== 5 && period !== 10 && period !== 30 && period % 60 !== 0) {
                throw new Error("Valid values for [args.period] are 1, 5, 10, 30, or any multiple of 60");
            }

            return period;
        });
        this.statistic = pulumi.all([args.statistic, args.extendedStatistic])
                               .apply(([statistic, extendedStatistic]) => {
                                   if (statistic === undefined && extendedStatistic === undefined) {
                                       return "Average";
                                   }

                                   return statistic;
                               });
        this.extendedStatistic = pulumi.output(args.extendedStatistic);
        this.unit = pulumi.output(args.unit);
    }
}

export interface MetricArgs {
    /**
     * The name for this metric. See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    metricName?: pulumi.Input<string>;
    /**
     * The dimensions for this metric.  For the list of available dimensions see the AWS documentation
     * [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    dimensions?: pulumi.Input<Record<string, any>>;
    /**
     * The namespace for this metric. See docs for the
     * [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    namespace?: pulumi.Input<string>;
    /**
     * The period in seconds over which the specified `stat` is applied.  Must be in multiples of 60.
     * Default to [300] if unspecified.
     */
    period?: pulumi.Input<number>;
    /**
     * The statistic to apply to the alarm's associated metric. Either of the following is
     * supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`
     */
    statistic?: pulumi.Input<MetricStatistic>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * [0.0] and [100].
     */
    extendedStatistic?: pulumi.Input<number>;
    /**
     * The unit for this metric.
     *
     * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
     */
    unit?: pulumi.Input<MetricUnit>;
}

export type MetricStatistic = "SampleCount" | "Average" | "Sum" | "Minimum" | "Maximum";
export type MetricUnit =
    "Seconds"       | "Microseconds"        | "Milliseconds"        |
    "Bytes"         | "Kilobytes"           | "Megabytes"           | "Gigabytes"           | "Terabytes"           |
    "Bits"          | "Kilobits"            | "Megabits"            | "Gigabits"            | "Terabits"            |
    "Percent"       | "Count"               |
    "Bytes/Second"  | "Kilobytes/Second"    | "Megabytes/Second"    | "Gigabytes/Second"    | "Terabytes/Second"    |
    "Bits/Second"   | "Kilobits/Second"     | "Megabits/Second"     | "Gigabits/Second"     | "Terabits/Second"     |
    "Count/Second"  | "None";
