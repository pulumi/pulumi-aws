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

import * as utils from "../utils";

/**
 * Base type of all non-flow Widgets to place in a DashboardGrid.
 */
export abstract class SimpleWidget extends Widget {
    constructor(private readonly args: SimpleWidgetArgs) {
        super();

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

export interface TextWidgetArgs extends SimpleWidgetArgs {
    /**
     * The text to be displayed by the widget.
     */
    markdown: pulumi.Input<string>;
}

/**
 * Base type for widgets that display data from a set of [Metric]s.  See [LineGraphMetricWidget],
 * [StackedAreaGraphMetricWidget] and [SingleNumberMetricWidget] as concrete [Widget] instances for
 * displaying [Metric]s.
 */
export abstract class MetricWidget extends SimpleWidget {
    constructor(private readonly metricArgs: MetricWidgetArgs) {
        super(metricArgs);

        if (!metricArgs.annotations && !metricArgs.metrics) {
            throw new Error("[args.metrics] must be provided if [args.annotations] is not provided.");
        }

        metricArgs.annotations = metricArgs.annotations || [];
        metricArgs.metrics = metricArgs.metrics || [];
    }

    protected abstract computeView(): wjson.MetricWidgetPropertiesJson["view"];
    protected abstract computedStacked(): wjson.MetricWidgetPropertiesJson["stacked"];
    protected abstract computeYAxis(): wjson.MetricWidgetPropertiesJson["yAxis"];

    protected computeType(): wjson.MetricWidgetJson["type"] {
        return "metric";
    }

    protected computeProperties(): wjson.MetricWidgetJson["properties"] {
        const stat = pulumi.all([this.metricArgs.extendedStatistic, this.metricArgs.statistic])
                           .apply(([extendedStatistic, statistic]) => {
            if (statistic !== undefined && extendedStatistic !== undefined) {
                throw new Error("[args.statistic] and [args.extendedStatistic] cannot both be provided.");
            }

            return extendedStatistic !== undefined ? `p${extendedStatistic}` : statistic;
        });


        let annotations: wjson.MetricWidgetAnnotationsJson | undefined;
        if (this.metricArgs.annotations.length > 0) {
            annotations = {};
            for (const annotation of this.metricArgs.annotations) {
                annotation.addWidgetJson(annotations);
            }
        }

        let metrics: wjson.MetricJson[] | undefined;
        if (this.metricArgs.metrics.length > 0) {
            metrics = [];
            for (const metric of this.metricArgs.metrics) {
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
 * Base type for widets that display metrics as a graph (either a line or stacked graph).
 *
 * See https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/graph_metrics.html for more
 * details.
 */
export abstract class GraphMetricWidget extends MetricWidget {
    constructor(private readonly graphArgs: GraphMetricWidgetArgs) {
        super(graphArgs);
    }

    protected computeView(): wjson.MetricWidgetPropertiesJson["view"] {
        return "timeSeries";
    }

    protected computeYAxis(): wjson.MetricWidgetPropertiesJson["yAxis"] {
        return this.graphArgs.yAxis;
    }
}

/**
 * Displays a set of metrics as a line graph.
 */
export class LineGraphMetricWidget extends GraphMetricWidget {
    constructor(args: GraphMetricWidgetArgs) {
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
    constructor(args: GraphMetricWidgetArgs) {
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
    constructor(args: MetricWidgetArgs) {
        super(args);
    }

    protected computeView(): wjson.MetricWidgetPropertiesJson["view"] {
        return "singleValue";
    }

    protected computedStacked() {
        return false;
    }

    protected computeYAxis(): wjson.MetricWidgetPropertiesJson["yAxis"] {
        return undefined;
    }
}

export interface MetricWidgetArgs extends SimpleWidgetArgs {
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

    /**
     * A single metric widget can have up to one alarm, and multiple horizontal and vertical
     * annotations.
     *
     * An alarm annotation is required only when metrics is not specified. A horizontal or vertical
     * annotation is not required.
     *
     * Instances of this interface include [aws.cloudwatch.Alarm], [HorizontalAnnotation] and
     * [VerticalAnnotation].
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

export interface GraphMetricWidgetArgs extends MetricWidgetArgs {
    /**
     * Limits for the minimums and maximums of the y-axis.  This applies to every metric being
     * graphed, unless specific metrics override it.
     */
    yAxis?: pulumi.Input<YAxis>;
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

/**
 * Base interface for values that can be placed inside [MetricWidgetArgs.annotations].
 * Instances of this interface include [aws.cloudwatch.Alarm], [HorizontalAnnotation] and
 * [VerticalAnnotation].
 */
export interface WidgetAnnotation {
    /** For internal use only. Only intended to be called by [MetricWidget]. */
    addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson);
}

/**
 * Horizontal annotations have several options for fill shading, including shading above the
 * annotation line, shading below the annotation line, and "band" shading that appears between two
 * linked annotation lines as part of a single band annotation
 */
export class HorizontalAnnotation implements WidgetAnnotation {
    constructor(private readonly args: HorizontalAnnotationArgs) {
        if (args.fill && args.lowerEdge) {
            throw new Error(`[args.fill] should not be provided if [args.lowerEdge] is provided.`);
        }
    }

    /** @internal */
    public addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson) {
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
export class VerticalAnnotation implements WidgetAnnotation {
    constructor(private readonly args: VerticalAnnotationArgs) {
        if (args.fill && args.endEdge) {
            throw new Error(`[args.fill] should not be provided if [args.endEdge] is provided.`);
        }
    }

    /** @internal */
    public addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson) {
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

