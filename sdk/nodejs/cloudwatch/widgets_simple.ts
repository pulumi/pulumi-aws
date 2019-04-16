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

import * as config from "../config";
import * as region from "../region";

import { MetricStatistic } from "./metric";
import { Widget } from "./widget";
import { AlarmAnnotation, WidgetAnnotation } from "./widgets_annotations";
import * as wjson from "./widgets_json";

import * as utils from "../utils";

export interface SimpleWidgetArgs {
    /**
     * The width of the widget in grid units (in a 24-column grid). The default is 6.
     *
     * Valid Values: 1–24
     */
    width?: number;

    /**
     * The height of the widget in grid units. The default is 6.
     *
     * Valid Values: 1–1000
     */
    height?: number;
}

/**
 * Base type of all non-flow Widgets to place in a DashboardGrid.
 */
export abstract class SimpleWidget implements Widget {
    constructor(private readonly args: SimpleWidgetArgs) {
        if (args.width > 24) {
            throw new Error("[args.width] cannot be greater than 24.");
        }
        if (args.height > 1000) {
            throw new Error("[args.height] cannot be greater than 1000.");
        }
    }

    public width() {
        return this.args.width !== undefined ? this.args.width : 6;
    }

    public height() {
        return this.args.height !== undefined ? this.args.height : 6;
    }

    /** @internal */
    protected abstract computeType(): wjson.WidgetJson["type"];
    /** @internal */
    protected abstract computeProperties(): wjson.WidgetJson["properties"];

    /** @internal */
    public addWidgetJson(widgetJsons: wjson.WidgetJson[], xOffset: number, yOffset: number) {
        // Build the structure common to all simple widgets.  Defer to our subclasses for
        // details only they can fill in.
        widgetJsons.push({
            x: xOffset,
            y: yOffset,
            width: this.width(),
            height: this.height(),
            type: this.computeType(),
            properties: this.computeProperties(),
        });
    }
}

export interface TextWidgetArgs extends SimpleWidgetArgs {
    /**
     * The text to be displayed by the widget.
     */
    markdown: pulumi.Input<string>;
}

/**
 * Simple widget that displays a piece of text in the dashboard grid.
 */
export class TextWidget extends SimpleWidget {
    private readonly textArgs: TextWidgetArgs;

    constructor(markdown: string);
    constructor(args: TextWidgetArgs);
    constructor(markdownOrArgs: string | TextWidgetArgs) {
        const args = typeof markdownOrArgs === "string" ? { markdown: markdownOrArgs } : markdownOrArgs;
        super(args);

        this.textArgs = args;
    }

    protected computeType(): wjson.TextWidgetJson["type"] {
        return "text";
    }

    protected computeProperties(): wjson.TextWidgetJson["properties"] {
        return { markdown: this.textArgs.markdown };
    }
}

function flattenArray<T>(annotations: T | T[]) {
    return Array.isArray(annotations) ? annotations : annotations ? [annotations] : []
}

export interface MetricWidgetArgs extends SimpleWidgetArgs {
    /**
     * Used to show a graph of a single alarm.  If, instead, you want to place horizontal lines in
     * graphs to show the trigger point of an alarm, then add the alarm to [annotations] instead.
     *
     * At least one of [alarm], [annotations] or [metrics] must be supplied.
     */
    alarm?: pulumi.Input<string> | WidgetAlarm;

    /**
     * A single metric widget can have up to one alarm, and multiple horizontal and vertical
     * annotations.
     *
     * An alarm annotation is required only when metrics is not specified. A horizontal or vertical
     * annotation is not required.
     *
     * Instances of this interface include [aws.cloudwatch.Alarm], [AlarmAnnotation],
     * [HorizontalAnnotation] and [VerticalAnnotation].
     *
     * At least one of [alarm], [annotations] or [metrics] must be supplied.
     */
    annotations?: WidgetAnnotation | WidgetAnnotation[];

    /**
     * Specify a metrics array to include one or more metrics (without alarms), math expressions, or
     * search expressions. One metrics array can include 0–100 metrics and expressions.
     *
     * See [ExpressionWidgetMetric] and [Metric] to create instances that can be added to this
     * array.
     *
     * At least one of [alarm], [annotations] or [metrics] must be supplied.
     */
    metrics?: WidgetMetric | WidgetMetric[];

    /** The title to be displayed for the graph or number. */
    title?: pulumi.Input<string>;

    /**
     * The default period, in seconds, for all metrics in this widget. The period is the length of
     * time represented by one data point on the graph. This default can be overridden within each
     * metric definition. The default is 300.
     */
    period?: pulumi.Input<number>;

    /**
     * The region of the metric.  Defaults to the region of the stack if not specified.
     */
    region?: pulumi.Input<region.Region>;

    /**
     * The default statistic to be displayed for each metric in the array. This default can be
     * overridden within the definition of each individual metric in the metrics array.
     */
    statistic?: pulumi.Input<MetricStatistic>;

    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * [0.0] and [100].
     */
    extendedStatistic?: pulumi.Input<number>;
}

export interface WidgetAlarm {
    arn: pulumi.Input<string>;
}

/**
 * Base type for widgets that display data from a set of [Metric]s.  See [LineGraphMetricWidget],
 * [StackedAreaGraphMetricWidget] and [SingleNumberMetricWidget] as concrete [Widget] instances for
 * displaying [Metric]s.
 */
export abstract class MetricWidget extends SimpleWidget {
    private readonly annotations: WidgetAnnotation[];
    private readonly metrics: WidgetMetric[];

    constructor(private readonly metricArgs: MetricWidgetArgs) {
        super(metricArgs);

        this.annotations = flattenArray(metricArgs.annotations);
        this.metrics = flattenArray(metricArgs.metrics);

        // If they specified an alarm, then make an appropriate annotation that will set
        // properties.alarms.
        const alarm = metricArgs.alarm;
        if (alarm) {
            const alarmArm = pulumi.all([(<WidgetAlarm>alarm).arn, <pulumi.Input<string>>alarm])
                                   .apply(([s1, s2]) => s1 || s2);
            this.annotations.push(new AlarmAnnotation(alarmArm));
        }

        if (this.annotations.length === 0 && this.metrics.length === 0) {
            throw new Error("[args.metrics] must be provided if [args.annotations] is not provided.");
        }
    }

    protected abstract computeView(): wjson.MetricWidgetPropertiesJson["view"];
    protected abstract computedStacked(): wjson.MetricWidgetPropertiesJson["stacked"];
    protected abstract computeYAxis(): wjson.MetricWidgetPropertiesJson["yAxis"];

    protected computeType = (): wjson.MetricWidgetJson["type"] => "metric";

    protected computeProperties(): wjson.MetricWidgetJson["properties"] {
        const stat = pulumi.all([this.metricArgs.extendedStatistic, this.metricArgs.statistic])
                           .apply(([extendedStatistic, statistic]) => {
            if (statistic !== undefined && extendedStatistic !== undefined) {
                throw new Error("[args.statistic] and [args.extendedStatistic] cannot both be provided.");
            }

            return extendedStatistic !== undefined ? `p${extendedStatistic}` : statistic;
        });


        let annotations: wjson.MetricWidgetAnnotationsJson | undefined;
        if (this.annotations.length > 0) {
            annotations = {};
            for (const annotation of this.annotations) {
                annotation.addWidgetJson(annotations);
            }
        }

        let metrics: wjson.MetricJson[] | undefined;
        if (this.metrics.length > 0) {
            metrics = [];
            for (const metric of this.metrics) {
                metric.addWidgetJson(metrics);
            }
        }

        return {
            stat,
            metrics,
            annotations,
            title: this.metricArgs.title,
            period: utils.ifUndefined(this.metricArgs.period, 300).apply(p => {
                if (p % 60 !== 0) {
                    throw new Error(`Dashboard metric period must be a multiple of 60: ${p}`);
                }

                return p;
            }),
            region: utils.ifUndefined(this.metricArgs.region, config.region),
            view: this.computeView(),
            stacked: this.computedStacked(),
            yAxis: this.computeYAxis(),
        };
    }
}

/**
 * Base type for all objects that can be placed in the [metrics] array of [MetricWidgetArgs].
 *
 * See [ExpressionWidgetMetric] and [Metric] to create instances that can be added to
 * [MetricWidgetArgs.metrics].
 */
export interface WidgetMetric {
    /** For internal use only. Only intended to be called by [MetricWidget]. */
    addWidgetJson(metrics: wjson.MetricJson[]): void;
}

/**
 * Used to pass math or search expressions to a [MetricWidget].
 *
 * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/using-metric-math.html and
 * https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/using-search-expressions.html for
 * more details.
 */
export class ExpressionWidgetMetric implements WidgetMetric {
    /**
     * @param expression The math expression or search expression.
     * @param label The label to display in the graph to represent this time series.
     * @param id The id of this time series. This id can be used as part of a math expression.
     */
    constructor(private readonly expression: pulumi.Input<string>,
                private readonly label?: pulumi.Input<string>,
                private readonly id?: pulumi.Input<string>) {
    }

    /** @internal */
    addWidgetJson(metrics: wjson.MetricJson[]): void {
        const json: wjson.ExpressionMetricJson = [{
            expression: this.expression,
            label: this.label,
            id: this.id,
        }];

        metrics.push(json);
    }
}
