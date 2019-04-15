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

import { WidgetMetric } from "./simpleWidgets";
import * as wjson from "./widgetJson";

import * as alarm from "./metricAlarm";
import * as sns from "../sns";
import * as utils from "../utils";

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
export class Metric implements WidgetMetric {
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
     * value is 300 seconds.
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
     * The six-digit HTML hex color code to be used for this metric.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    public readonly color: pulumi.Output<string | undefined>;

    /**
     * The label to display for this metric in the graph legend. If this is not specified, the
     * metric is given an autogenerated label that distinguishes it from the other metrics in the
     * widget.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    public readonly label: pulumi.Output<string | undefined>;

    /**
     * Set this to true to have the metric appear in the graph, or false to have it be hidden. The
     * default is true.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    public readonly visible: pulumi.Output<boolean>;

    /**
     * Where on the graph to display the y-axis for this metric. The default is left.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    public readonly yAxis: pulumi.Output<"left" | "right">;

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
        this.period = utils.ifUndefined(args.period, 300).apply(validatePeriod);
        this.statistic = pulumi.all([args.statistic, args.extendedStatistic])
                               .apply(([statistic, extendedStatistic]) => validateStatistics(statistic, extendedStatistic));
        this.extendedStatistic = pulumi.output(args.extendedStatistic).apply(validateExtendedStatistic);
        this.unit = pulumi.output(args.unit);

        // Only for metrics that are placed in dashboards.
        this.color = pulumi.output(args.color);
        this.label = pulumi.output(args.label);
        this.visible = utils.ifUndefined(args.visible, true);
        this.yAxis = utils.ifUndefined(args.yAxis, "left");
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
        result = hasOwnProperty(change, "color") ? result.withColor(change.color) : result;
        result = hasOwnProperty(change, "label") ? result.withLabel(change.label) : result;
        result = hasOwnProperty(change, "visible") ? result.withVisible(change.visible) : result;
        result = hasOwnProperty(change, "yAxis") ? result.withYAxis(change.yAxis) : result;
        return result;
    }

    /**
     * Produces a new [Metric] instances with the specific [dimensions] of this instance overwritten
     * with the [dimensions] pass in as arguments.  Because this is a merging, to unset a particular
     * dimension, pass in an explicit value of `{ name: undefined }`.  To clear all dimensions, pass
     * in `undefined` for the entire argument.
     */
    public withDimensions(dimensions: pulumi.Input<Record<string, any>> | undefined) {
        return new Metric({
            ...this,
            dimensions: mergeDimensions(this.dimensions, pulumi.output(dimensions)),
        }, this.resource);
    }

    public withPeriod(period: pulumi.Input<number> | undefined) {
        return new Metric({ ...this, period }, this.resource);
    }

    public withUnit(unit: pulumi.Input<MetricUnit> | undefined) {
        return new Metric({ ...this, unit }, this.resource);
    }

    public withColor(color: pulumi.Input<string> | undefined) {
        return new Metric({ ...this, color }, this.resource);
    }

    public withLabel(label: pulumi.Input<string> | undefined) {
        return new Metric({ ...this, label }, this.resource);
    }

    public withVisible(visible: pulumi.Input<boolean> | undefined) {
        return new Metric({ ...this, visible }, this.resource);
    }

    public withYAxis(yAxis: pulumi.Input<"left" | "right"> | undefined) {
        return new Metric({ ...this, yAxis }, this.resource);
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

    /** @internal */
    public addWidgetJson(metrics: wjson.MetricJson[]): void {
        // Each single metric in the metrics array has the following format:
        // [Namespace, MetricName, [{DimensionName,DimensionValue}...] [Rendering Properties Object] ]

        const op = pulumi.output(this).apply(uw => {
            const result: (string | wjson.RenderingPropertiesJson)[] = [];

            result.push(uw.namespace)
            result.push(uw.name);

            for (const key in uw.dimensions) {
                result.push(key);
                result.push(uw.dimensions[key]);
            }

            const stat = uw.extendedStatistic !== undefined
                ? `p${uw.extendedStatistic}`
                : uw.statistic;
            const renderingProps: wjson.RenderingPropertiesJson = {
                stat,
                color: uw.color,
                label: uw.label,
                period: uw.period,
                visible: uw.visible,
                yAxis: uw.yAxis,
            };

            result.push(renderingProps);
            return result;
        });

        metrics.push(op);
    }
}

function mergeDimensions(
        oldDimensions: pulumi.Output<Record<string, any> | undefined>,
        newDimensions: pulumi.Output<Record<string, any> | undefined>) {

    return pulumi.all([oldDimensions, newDimensions]).apply(([oldDimensions, newDimensions]) => {
        if (!newDimensions) {
            // they're explicitly clearing out all dimensions.
            return undefined;
        }

        if (!oldDimensions) {
            // no old dimensions, can just use all the new dimensions passed in.
            return newDimensions;
        }

        // have both old and new.  need to overwrite all the old dimensions with whatever is in new.
        const result = { ...oldDimensions };
        for (const name in newDimensions) {
            if (newDimensions.hasOwnProperty(name)) {
                result[name] = newDimensions[name];
            }
        }

        return result;
    })
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
     * to [undefined] then the value will be set to the default (300s).
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

    /**
     * The six-digit HTML hex color code to be used for this metric.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    color?: pulumi.Input<string>;

    /**
     * The label to display for this metric in the graph legend. If this is not specified, the
     * metric is given an autogenerated label that distinguishes it from the other metrics in the
     * widget.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    label?: pulumi.Input<string>;

    /**
     * Set this to true to have the metric appear in the graph, or false to have it be hidden. The
     * default is true.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    visible?: pulumi.Input<boolean>;

    /**
     * Where on the graph to display the y-axis for this metric. The default is left.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    yAxis?: pulumi.Input<"left" | "right">;
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

    /**
     * The six-digit HTML hex color code to be used for this metric.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    color?: pulumi.Input<string>;

    /**
     * The label to display for this metric in the graph legend. If this is not specified, the
     * metric is given an autogenerated label that distinguishes it from the other metrics in the
     * widget.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    label?: pulumi.Input<string>;

    /**
     * Set this to true to have the metric appear in the graph, or false to have it be hidden. The
     * default is true.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    visible?: pulumi.Input<boolean>;

    /**
     * Where on the graph to display the y-axis for this metric. The default is left.
     *
     * Only used if this metric is displayed in a [Dashboard] with a [MetricWidget].
     */
    yAxis?: pulumi.Input<"left" | "right">;
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
