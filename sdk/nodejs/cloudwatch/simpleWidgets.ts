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
import { Widget } from "./widgets";
import * as wjson from "./widgetJson";

/**
 * Base type of all non-flow Widgets to place in a DashboardGrid.
 */
export abstract class SimpleWidget extends Widget {
    constructor(private readonly args: SimpleWidgetArgs) {
        super();
    }

    public width() {
        return this.args.width !== undefined ? this.args.width : 6;
    }

    public height() {
        return this.args.height !== undefined ? this.args.height : 6;
    }

    /** @internal */
    protected abstract computeType(): "text" | "metric";
    /** @internal */
    protected abstract computeProperties(): Record<string, any>;

    /** @internal */
    public addWidgetJsons(widgetJsons: wjson.WidgetJson[], xOffset: number, yOffset: number) {
        widgetJsons.push({
            type: this.computeType(),
            x: xOffset,
            y: yOffset,
            width: this.width(),
            height: this.height(),
            properties: this.computeProperties(),
        });
    }
}

export interface SimpleWidgetArgs {
    /**
     * The width of the widget in grid units (in a 24-column grid). The default is 6.
     *
     * Valid Values: 1–24
     *
     * Type: Integer
     */
    width?: number;

    /**
     * The height of the widget in grid units. The default is 6.
     *
     * Valid Values: 1–1000
     */
    height?: number;
}

export class TextWidget extends SimpleWidget {
    private readonly textArgs: TextWidgetArgs;

    constructor(markdown: string);
    constructor(args: TextWidgetArgs);
    constructor(markdownOrArgs: string | TextWidgetArgs) {
        const args = typeof markdownOrArgs === "string" ? { markdown: markdownOrArgs } : markdownOrArgs;
        super(args);

        this.textArgs = args;
    }

    protected computeType(): "text" {
        return "text";
    }

    protected computeProperties(): wjson.TextWidgetJson["properties"] {
        return { markdown: this.textArgs.markdown };
    }
}

export interface TextWidgetArgs extends SimpleWidgetArgs {
    /**
     * The text to be displayed by the widget.
     */
    markdown: string;
}

/**
 * Base type for widgets that display data from a set of [Metric]s.  See [LineGraphMetricWidget],
 * [StackedAreaGraphMetricWidget] and [SingleNumberMetricWidget] as concrete [Widget] instances for
 * displaying [Metric]s.
 */
export abstract class MetricWidget extends SimpleWidget {
    constructor(private readonly metricArgs: MetricWidgetArgs) {
        super(metricArgs);

        if (metricArgs.statistic !== undefined && metricArgs.extendedStatistic !== undefined) {
            throw new Error("[args.statistic] and [args.extendedStatistic] cannot both be provided.");
        }

        if (!metricArgs.annotations && !metricArgs.metrics) {
            throw new Error("[args.metrics] must be provided if [args.annotations] is not provided.");
        }
    }

    protected abstract computeView(): "timeSeries" | "singleValue";
    protected abstract computedStacked(): boolean;

    protected computeType(): "metric" {
        return "metric";
    }

    protected computeProperties(): wjson.MetricWidgetJson["properties"] {
        const stat = this.metricArgs.extendedStatistic !== undefined
            ? `p${this.metricArgs.extendedStatistic}`
            : this.metricArgs.statistic;

        let annotations: wjson.MetricWidgetAnnotationsJson | undefined;
        if (this.metricArgs.annotations && this.metricArgs.annotations.length > 0) {
            annotations = {};
            for (const annotation of this.metricArgs.annotations) {
                annotation.addWidgetJsons(annotations);
            }
        }

        let metrics: wjson.MetricJson[] | undefined;
        if (this.metricArgs.metrics && this.metricArgs.metrics.length > 0) {
            metrics = [];
            for (const metric of this.metricArgs.metrics) {
                metric.addWidgetJsons(metrics);
            }
        }

        return {
            stat,
            metrics,
            annotations,
            title: this.metricArgs.title,
            period: this.metricArgs.period !== undefined ? this.metricArgs.period : 300,
            region: this.metricArgs.region || config.region,
            view: this.computeView(),
            stacked: this.computedStacked(),
            yAxis: this.metricArgs.yAxis,
        };
    }
}

/**
 * Base type for widets that display metrics as a graph (either a line or stacked graph).
 */
export abstract class GraphMetricWidget extends MetricWidget {
    constructor(args: GraphMetricWidgetArgs) {
        super(args);
    }

    protected computeView(): "timeSeries" {
        return "timeSeries";
    }
}

/**
 * Displays a set of metrics as a line graph.
 */
export class LineGraphMetricWidget extends GraphMetricWidget {
    constructor(args: LineGraphMetricWidgetArgs) {
        super(args);
    }

    protected computedStacked() {
        return false;
    }
}

/**
 * Displays a set of metrics as a stacked area graph.
 */
export class StackedAreaGraphMetricWidget extends GraphMetricWidget {
    constructor(args: StackedAreaGraphMetricWidgetArgs) {
        super(args);
    }

    protected computedStacked() {
        return true;
    }
}

/**
 * Displays a set of metrics as a single number.
 */
export class SingleNumberMetricWidget extends MetricWidget {
    constructor(args: SingleNumberMetricWidgetArgs) {
        super(args);
    }

    protected computeView(): "singleValue" {
        return "singleValue";
    }

    protected computedStacked() {
        return false;
    }
}

export interface MetricWidgetArgs extends SimpleWidgetArgs {
    /** The title to be displayed for the graph or number. */
    title?: string;

    /**
     * The default period, in seconds, for all metrics in this widget. The period is the length of
     * time represented by one data point on the graph. This default can be overridden within each
     * metric definition. The default is 300.
     */
    period?: number;

    /**
     * The region of the metric.  Defaults to the region of the stack if not specified.
     */
    region?: region.Region;

    /**
     * The default statistic to be displayed for each metric in the array. This default can be
     * overridden within the definition of each individual metric in the metrics array.
     */
    statistic?: MetricStatistic;

    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between
     * [0.0] and [100].
     */
    extendedStatistic?: pulumi.Input<number>;

    /**
     * Limits for the minimums and maximums of the y-axis.  This applies to every metric being
     * graphed, unless specific metrics override it.
     */
    yAxis?: YAxis;

    /**
     * A single metric widget can have up to one alarm, and multiple horizontal and vertical
     * annotations.
     *
     * An alarm annotation is required only when metrics is not specified. A horizontal or vertical
     * annotation is not required.
     */
    annotations?: WidgetAnnotation[];

    /**
     * Specify a metrics array to include one or more metrics (without alarms), math expressions, or
     * search expressions. One metrics array can include 0–100 metrics and expressions.
     *
     * See [ExpressionWidgetMetric] and [Metric] to create instances that can be added to this
     * array.
     */
    metrics?: WidgetMetric[];
}

/**
 * Base type for all objects that can be placed in the [metrics] array of [MetricWidgetArgs].
 *
 * See [ExpressionWidgetMetric] and [Metric] to create instances that can be added to
 * [MetricWidgetArgs.metrics].
 */
export abstract class WidgetMetric {
    /** @internal */
    abstract addWidgetJsons(metrics: wjson.MetricJson[]): void;
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
    constructor(private readonly expression: string,
                private readonly label?: string,
                private readonly id?: string) {
    }

    addWidgetJsons(metrics: wjson.MetricJson[]): void {
        const json: wjson.ExpressionMetricJson = [{
            expression: this.expression,
            label: this.label,
            id: this.id,
        }];

        metrics.push(json);
    }
}

export abstract class WidgetAnnotation {
    /** @internal */
    public abstract addWidgetJsons(annotations: wjson.MetricWidgetAnnotationsJson);
}

export class AlarmAnnotation extends WidgetAnnotation {
    constructor(private readonly alarmArn: pulumi.Input<string>) {
        super();
    }

    public addWidgetJsons(annotations: wjson.MetricWidgetAnnotationsJson) {
        if (annotations.alarms && annotations.alarms.length >= 1) {
            throw new Error("Widget can only have a maximum of one alarm annotation.");
        }

        annotations.alarms = [this.alarmArn];
    }
}

/**
 * Horizontal annotations have several options for fill shading, including shading above the
 * annotation line, shading below the annotation line, and "band" shading that appears between two
 * linked annotation lines as part of a single band annotation
 */
export class HorizontalAnnotation extends WidgetAnnotation {
    constructor(private readonly args: HorizontalAnnotationArgs) {
        super();
        if (args.fill && args.lowerEdge) {
            throw new Error(`[args.fill] should not be provided if [args.lowerEdge] is provided.`);
        }
    }

    public addWidgetJsons(annotations: wjson.MetricWidgetAnnotationsJson) {
        annotations.horizontal = annotations.horizontal || [];

        const annotation: wjson.HorizontalAnnotationJson = {
            fill: this.args.fill,
            color: this.args.color,
            label: this.args.upperEdge.label,
            value: this.args.upperEdge.value,
            visible: this.args.visible,
            yAxis: this.args.yAxis,
        };

        annotations.horizontal.push(annotation);

        if (this.args.lowerEdge) {
            annotations.horizontal.push({
                value: this.args.lowerEdge.value,
                label: this.args.lowerEdge.label,
            });
        }
    }
}

export interface HorizontalAnnotationArgs {
    /**
     * The metric value in the graph where the horizontal annotation line is to appear.  If
     * [lowerEdge] is also provided, then this will produce a band annotation.  In that case [fill]
     * should not be provided.
     */
    upperEdge: HorizontalEdge;

    /**
     * The lower edge when using band shading.
     */
    lowerEdge?: HorizontalEdge;

    /**
     * The six-digit HTML hex color code to be used for the annotation. This color is used for both
     * the annotation line and the fill shading.
     */
    color?: string;

    /**
     * How to use fill shading with the annotation. Valid values are above for shading above the
     * annotation, below for shading below the annotation. If fill is omitted, there is no shading.
     *
     * The exception is an annotation with band shading (in which case [lowerEdge] is provided).
     * These annotations always have shading between the two values, and any value for fill is
     * ignored.
     */
    fill?: "above" | "below";

    /**
     * Set this to true to have the annotation appear in the graph, or false to have it be hidden.
     * The default is true.
     */
    visible?: boolean;

    /**
     * If the graph includes multiple metrics, specifies whether the numbers in Value refer to the
     * metric associated with the left Y-axis or the right Y-axis, . Valid values are right and
     * left.
     */
    yAxis?: "left" | "right";
}

export interface HorizontalEdge {
    /**
     * The metric value in the graph where the horizontal annotation line is to appear. On a band
     * shading annotation, the two values for Value define the upper and lower edges of the band.
     *
     * On a graph with horizontal annotations, the graph is scaled so that all visible horizontal
     * annotations appear on the graph.
     */
    value: number;

    /**
     * A string that appears on the graph next to the annotation.
     */
    label?: string;
}

/**
 * Vertical annotations have several options for fill shading, including shading before the
 * annotation line, shading after the annotation line, and "band" shading that appears between two
 * linked annotation lines as part of a single band annotation
 */
export class VerticalAnnotation extends WidgetAnnotation {
    constructor(private readonly args: VerticalAnnotationArgs) {
        super();
        if (args.fill && args.endEdge) {
            throw new Error(`[args.fill] should not be provided if [args.endEdge] is provided.`);
        }
    }

    public addWidgetJsons(annotations: wjson.MetricWidgetAnnotationsJson) {
        annotations.vertical = annotations.vertical || [];

        const annotation: wjson.VerticalAnnotationJson = {
            fill: this.args.fill,
            color: this.args.color,
            label: this.args.beginningEdge.label,
            value: this.args.beginningEdge.value,
            visible: this.args.visible,
        };

        annotations.vertical.push(annotation);

        if (this.args.endEdge) {
            annotations.vertical.push({
                value: this.args.endEdge.value,
                label: this.args.endEdge.label,
            });
        }
    }
}

/**
 * For each vertical annotation, you can choose to have fill shading before the annotation, after
 * it, or between two vertical lines that are linked as a single band annotation.
 */
export interface VerticalAnnotationArgs {
    /**
     * The metric value in the graph where the vertical annotation line is to appear.  If
     * [endEdge] is also provided, then this will produce a band annotation.  In that case [fill]
     * should not be provided.
     */
    beginningEdge: VerticalEdge;

    /**
     * The ending edge when using band shading.
     */
    endEdge?: VerticalEdge;

    /**
     * The six-digit HTML hex color code to be used for the annotation. This color is used for both
     * the annotation line and the fill shading.
     */
    color?: string;

    /**
     * How to use fill shading with the annotation. Valid values are before for shading before the
     * annotation, after for shading after the annotation. If fill is omitted, there is no shading.
     *
     * The exception is an annotation with band shading. These annotations always have shading
     * between the two values, and any value for [fill] is ignored.
     */
    fill?: "before" | "after";

    /**
     * Set this to true to have the annotation appear in the graph, or false to have it be hidden.
     * The default is true.
     */
    visible?: boolean;
}

export interface HorizontalEdge {
    /**
     * The metric value in the graph where the horizontal annotation line is to appear. On a band
     * shading annotation, the two values for Value define the upper and lower edges of the band.
     *
     * On a graph with horizontal annotations, the graph is scaled so that all visible horizontal
     * annotations appear on the graph.
     */
    value: number;

    /**
     * A string that appears on the graph next to the annotation.
     */
    label?: string;
}

export interface VerticalEdge {
    /**
     * The date and time in the graph where the vertical annotation line is to appear. On a band
     * shading annotation, the two values for Value define the beginning and ending edges of the
     * band.
     *
     * On a graph with vertical annotations, the graph is scaled so that all visible vertical
     * annotations appear on the graph.
     *
     * This is defined as a string in ISO 8601 format. For more information, see ISO 8601.
     */
    value: string;

    /**
     * A string that appears on the graph next to the annotation.
     */
    label?: string;
}

export interface SingleNumberMetricWidgetArgs extends MetricWidgetArgs {
    yAxis?: never;
}

export interface GraphMetricWidgetArgs extends MetricWidgetArgs {
}

export interface LineGraphMetricWidgetArgs extends GraphMetricWidgetArgs {
}

export interface StackedAreaGraphMetricWidgetArgs extends GraphMetricWidgetArgs {
}

export interface YAxis {
    /** Optional min and max settings for the left Y-axis.  */
    left?: MinMax;

    /** Optional min and max settings for the right Y-axis. */
    right?: MinMax;
}

export interface MinMax {
    /** The minimum value for this Y-axis */
    min?: number;
    /** The maximum value for this Y-axis */
    max?: number;
}

