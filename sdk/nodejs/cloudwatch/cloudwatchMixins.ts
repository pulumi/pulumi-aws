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

import * as alarm from "./metricAlarm";
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
     * Optional resource this is a metric for.  Used only for parenting purposes when making new alarms.
     */
    public readonly resource: pulumi.Resource | undefined;
    /**
     * The name for this metric. See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly name: pulumi.Output<string>;
    /**
     * The dimensions for this metric.  For the list of available dimensions see the AWS documentation
     * [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly dimensions: pulumi.Output<Record<string, any> | undefined>;
    /**
     * The namespace for this metric. See docs for the
     * [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly namespace: pulumi.Output<string>;
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
    public readonly period: pulumi.Output<number>;
    /**
     * The statistic to apply to the alarm's associated metric. Either of the following is
     * supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`.
     *
     * Defaults to [Average] if [statistic] and [extendedStatistic] is unspecified.
     */
    public readonly statistic: pulumi.Output<MetricStatistic>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * [0.0] and [100].
     */
    public readonly extendedStatistic: pulumi.Output<number | undefined>;
    /**
     * The unit for this metric.
     *
     * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
     */
    public readonly unit: pulumi.Output<MetricUnit | undefined>;

    /**
     * @param resource Optional resource this is a metric for.  This is only used for parenting
     * purposes.  i.e. if an [Alarm] is created from this [Metric], then [resource] will be used as
     * the parent of the alarm by default.
     */
    constructor(args: MetricArgs, resource?: pulumi.Resource) {
        this.resource = resource;
        this.name = pulumi.output(args.name);
        this.dimensions = pulumi.output(args.dimensions);
        this.namespace = pulumi.output(args.namespace);
        this.period = utils.ifUndefined(args.period, 60).apply(validatePeriod);
        this.statistic = pulumi.all([args.statistic, args.extendedStatistic])
                               .apply(([statistic, extendedStatistic]) => validateStatistics(statistic, extendedStatistic));
        this.extendedStatistic = pulumi.output(args.extendedStatistic).apply(validateExtendedStatistic);
        this.unit = pulumi.output(args.unit);
    }

    public with(change: MetricChange | undefined) {
        if (!change) {
            return this;
        }

        let result: Metric = this;
        result = hasOwnProperty(change, "dimensions") ? result.withDimensions(change.dimensions) : result;
        result = hasOwnProperty(change, "period") ? result.withPeriod(change.period) : result;
        result = hasOwnProperty(change, "statistic") ? result.withStatistic(change.statistic) : result;
        result = hasOwnProperty(change, "extendedStatistic") ? result.withExtendedStatistic(change.extendedStatistic) : result;
        result = hasOwnProperty(change, "unit") ? result.withUnit(change.unit) : result;
        return result;
    }

    public withDimensions(dimensions: pulumi.Input<Record<string, any>> | undefined) {
        return new Metric({
            ...this,
            dimensions,
        }, this.resource);
    }

    public withPeriod(period: pulumi.Input<number> | undefined) {
        return new Metric({
            ...this,
            period,
        }, this.resource);
    }

    public withUnit(unit: pulumi.Input<MetricUnit> | undefined) {
        return new Metric({
            ...this,
            unit,
        }, this.resource);
    }

    public withStatistic(statistic: pulumi.Input<MetricStatistic> | undefined) {
        // If they're supplying a statistic, then we want to clear out extendedStatistic.
        return new Metric({
            ...this,
            statistic,
            extendedStatistic: pulumi.output([statistic, this.extendedStatistic])
                                     .apply(([statistic, extendedStatistic]) =>
                                        statistic !== undefined ? undefined : extendedStatistic),
        }, this.resource);
    }

    public withExtendedStatistic(extendedStatistic: pulumi.Input<number> | undefined) {
        // If they're supplying an extendedStatistic, then we want to clear out statistic.
        return new Metric({
            ...this,
            statistic: pulumi.output([this.statistic, extendedStatistic])
                             .apply(([statistic, extendedStatistic]) =>
                                extendedStatistic !== undefined ? undefined : statistic),
            extendedStatistic,
        }, this.resource);
    }

    public createAlarm(name: string, args: AlarmArgs, opts: pulumi.CustomResourceOptions = {}) {
        const comparisonOperator = utils.ifUndefined(args.comparisonOperator, "GreaterThanOrEqualToThreshold");
        return new alarm.MetricAlarm(name, {
            ...args,

            comparisonOperator,
            actionsEnabled: utils.ifUndefined(args.actionsEnabled, true),
            alarmDescription: computeDescription(this, args, comparisonOperator),
            treatMissingData: utils.ifUndefined(args.treatMissingData, "missing"),

            dimensions: this.dimensions,
            extendedStatistic: this.extendedStatistic.apply(s => s === undefined ? undefined : `p${s}`),
            metricName: this.name,
            namespace: this.namespace,
            period: this.period,
            statistic: this.statistic,
            unit: this.unit,
        }, { parent: this.resource, ...opts });
    }
}

function hasOwnProperty<T>(obj: T, key: keyof T) {
    return obj.hasOwnProperty(key);
}

function computeDescription(metric: Metric, args: AlarmArgs, comparisonOperator: pulumi.Output<AlarmComparisonOperator>): pulumi.Output<string> {
    return pulumi.all([metric, args, comparisonOperator])
                 .apply(([metric, args, comparisonOperator]) => {
        if (args.alarmDescription !== undefined) {
            return args.alarmDescription;
        }

        const time = args.evaluationPeriods * metric.period;
        return `${metric.name} ${comparisonOperator} ${args.threshold} in the last ${time}s`;
    })
}

function validatePeriod(period: number) {
    // valid values for period are 1, 5, 10, 30, or any multiple of 60
    if (period !== 1 && period !== 5 && period !== 10 && period !== 30 && period % 60 !== 0) {
        throw new Error("Valid values for [args.period] are 1, 5, 10, 30, or any multiple of 60");
    }

    return period;
}

function validateStatistics(statistic: MetricStatistic, extendedStatistic: number) {
    if (statistic === undefined && extendedStatistic === undefined) {
        return "Average";
    }

    if (statistic !== undefined && extendedStatistic !== undefined) {
        throw new Error("Only provide one of [args.statistic] and [args.extendedStatistic]")
    }

    return statistic;
}

function validateExtendedStatistic(extendedStatistic: number) {
    if (extendedStatistic !== undefined) {
        if (extendedStatistic < 0 || extendedStatistic > 100) {
                throw new Error("[args.extendedStatistic] must be between 0 and 100.")
        }

        return extendedStatistic;
    }
}

/**
 * Interface for all the parts of a metric that can be changed.
 */
export interface MetricChange {
    /**
     * The new dimension for this metric.  If this object is missing this property, then no change
     * will be made.  However, if the property is there by set to [undefined] then the value will be
     * cleared.
     */
    dimensions?: pulumi.Input<Record<string, any>>;
    /**
     * The new period in seconds over which the specified `stat` is applied.  If this object is
     * missing this property, then no change will be made.  However, if the property is there by set
     * to [undefined] then the value will be set to the default.
     */
    period?: pulumi.Input<number>;
    /**
     * The new statistic to apply to the alarm's associated metric.  If this object is missing this
     * property, then no change will be made.  However, if the property is there by set to
     * [undefined] then the value will be set to the default.
     */
    statistic?: pulumi.Input<MetricStatistic>;
    /**
     * The new percentile statistic for the metric associated with the alarm.  If this object is
     * missing this property, then no change will be made.  However, if the property is there by set
     * to [undefined] then the value will be set to the default.
     */
    extendedStatistic?: pulumi.Input<number>;
    /**
     * The new unit for this metric.   If this object is missing this property, then no change will
     * be made.  However, if the property is there by set to [undefined] then the value will be set
     * to the default.
     */
    unit?: pulumi.Input<MetricUnit>;
}

export type AlarmComparisonOperator =
    "GreaterThanOrEqualToThreshold" | "GreaterThanThreshold" |
    "LessThanThreshold" | "LessThanOrEqualToThreshold";

export interface AlarmArgs {
    /**
     * Indicates whether or not actions should be executed during any changes to the alarm's state.
     * Defaults to `true`.
     */
    actionsEnabled?: pulumi.Input<boolean>;
    /**
     * The list of actions to execute when this alarm transitions into an ALARM state from any other
     * state. Each action is specified as an Amazon Resource Name (ARN).
     */
    alarmActions?: pulumi.Input<pulumi.Input<string | sns.Topic>[]>;
    /**
     * The description for the alarm.
     */
    alarmDescription?: pulumi.Input<string>;
    /**
     * The descriptive name for the alarm. This name must be unique within the user's AWS account
     */
    name?: pulumi.Input<string>;
    /**
     * The arithmetic operation to use when comparing the specified Statistic and Threshold. The
     * specified Statistic value is used as the first operand. Either of the following is supported:
     * `GreaterThanOrEqualToThreshold`, `GreaterThanThreshold`, `LessThanThreshold`,
     * `LessThanOrEqualToThreshold`.
     *
     * Defaults to [GreaterThanOrEqualToThreshold] if unspecified.
     */
    comparisonOperator?: pulumi.Input<AlarmComparisonOperator>;
    /**
     * The number of datapoints that must be breaching to trigger the alarm.
     */
    datapointsToAlarm?: pulumi.Input<number>;
    /**
     * Used only for alarms based on percentiles. If you specify `ignore`, the alarm state will not
     * change during periods with too few data points to be statistically significant. If you
     * specify `evaluate` or omit this parameter, the alarm will always be evaluated and possibly
     * change state no matter how many data points are available. The following values are
     * supported: `ignore`, and `evaluate`.
     */
    evaluateLowSampleCountPercentiles?: pulumi.Input<"ignore" | "evaluate">;
    /**
     * The number of periods over which data is compared to the specified threshold.
     */
    evaluationPeriods: pulumi.Input<number>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * p0.0 and p100.
     */
    extendedStatistic?: pulumi.Input<string>;
    /**
     * The list of actions to execute when this alarm transitions into an INSUFFICIENT_DATA state
     * from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    insufficientDataActions?: pulumi.Input<pulumi.Input<string | sns.Topic>[]>;
    /**
     * Enables you to create an alarm based on a metric math expression. You may specify at most 20.
     */
    metricQueries?: pulumi.Input<pulumi.Input<{ expression?: pulumi.Input<string>, id: pulumi.Input<string>, label?: pulumi.Input<string>, metric?: pulumi.Input<{ dimensions?: pulumi.Input<{[key: string]: any}>, metricName: pulumi.Input<string>, namespace?: pulumi.Input<string>, period: pulumi.Input<number>, stat: pulumi.Input<string>, unit?: pulumi.Input<string> }>, returnData?: pulumi.Input<boolean> }>[]>;
    /**
     * The list of actions to execute when this alarm transitions into an OK state from any other
     * state. Each action is specified as an Amazon Resource Name (ARN).
     */
    okActions?: pulumi.Input<pulumi.Input<string | sns.Topic>[]>;
    /**
     * The value against which the specified statistic is compared.
     */
    threshold: pulumi.Input<number>;
    /**
     * Sets how this alarm is to handle missing data points. The following values are supported:
     * `missing`, `ignore`, `breaching` and `notBreaching`. Defaults to `missing`.
     */
    treatMissingData?: pulumi.Input<"missing" | "ignore" | "breaching" | "notBreaching">;
}

export interface MetricArgs {
    /**
     * The name for this metric. See docs for
     * [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    name?: pulumi.Input<string>;
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

// actual cloudwatch events (that cloudwatch sends to itself)

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
export function logMetric(metricName: CloudwatchLogMetricName, change: MetricChange = {} = {}) {
    return new Metric({
        namespace: "AWS/Logs",
        name: metricName,
        ...change,
    });
}

/**
 * The volume of log events in uncompressed bytes uploaded to CloudWatch Logs. When used with the
 * LogGroupName dimension, this is the volume of log events in uncompressed bytes uploaded to the
 * log group.
 */
export function metricIncomingBytes(change: MetricChange = {}) {
    return logMetric("IncomingBytes", { statistic: "Sum", unit: "Bytes", ...change });
}

/**
 * The number of log events uploaded to CloudWatch Logs. When used with the LogGroupName dimension,
 * this is the number of log events uploaded to the log group.
 */
export function metricIncomingLogEvents(change: MetricChange = {}) {
    return logMetric("IncomingLogEvents", { statistic: "Sum", unit: "None", ...change });
}

/**
 * The volume of log events in compressed bytes forwarded to the subscription destination.
 */
export function metricForwardedBytes(change: MetricChange = {}) {
    return logMetric("ForwardedBytes", { statistic: "Sum", unit: "Bytes", ...change });
}

/**
 * The number of log events forwarded to the subscription destination.
 */
export function metricForwardedLogEvents(change: MetricChange = {}) {
    return logMetric("ForwardedLogEvents", { statistic: "Sum", unit: "None", ...change });
}

/**
 * The number of log events for which CloudWatch Logs received an error when forwarding data to the
 * subscription destination.
 */
export function metricDeliveryErrors(change: MetricChange = {}) {
    return logMetric("DeliveryErrors", { statistic: "Sum", unit: "None", ...change });
}

/**
 * The number of log events for which CloudWatch Logs was throttled when forwarding data to the
 * subscription destination.
 */
export function metricDeliveryThrottling(change: MetricChange = {}) {
    return logMetric("DeliveryThrottling", { statistic: "Sum", unit: "None", ...change });
}