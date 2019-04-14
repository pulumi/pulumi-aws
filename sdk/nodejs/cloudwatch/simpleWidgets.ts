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
        const json: wjson.WidgetJson = {
            type: this.computeType(),
            x: xOffset,
            y: yOffset,
            width: this.width(),
            height: this.height(),
            properties: this.computeProperties(),
        };

        widgetJsons.push(json);
    }

    /**
     *
    type: "metric" | "text";
    x: number;
    y: number;
    width: number;
    height: number;
    properties: Record<string, any>;
     */
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
    markdown: string;
}

/**
 * Base type for widgets that display data from a set of [Metric]s.
 */
export abstract class MetricWidget extends SimpleWidget {
    constructor(private readonly metricArgs: MetricWidgetArgs) {
        super(metricArgs);

        if (metricArgs.statistic !== undefined && metricArgs.extendedStatistic !== undefined) {
            throw new Error("[args.statistic] and [args.extendedStatistic] cannot both be provided.");
        }
    }

    protected abstract computeView(): "timeSeries" | "singleValue";
    protected abstract computedStacked(): boolean;

    protected computeType(): wjson.MetricWidgetJson["type"] {
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

        return {
            stat,
            annotations,
            title: this.metricArgs.title,
            period: this.metricArgs.period !== undefined ? this.metricArgs.period : 300,
            region: this.metricArgs.region || config.region;
            view: this.computeView(),
            stacked: this.computedStacked(),
            yAxis: this.metricArgs.yAxis,
        };
    }

    /*
        metrics: MetricJson[] | undefined,
    annotations: {
        alarms: pulumi.Input<string>[] | undefined,
        horizontal: BaseHorizontalAnnotationJson[] | undefined,
        vertical: BaseVerticalAnnotationJson[] | undefined,
    } | undefined;
    period: number | undefined;
    region: string;
    stat: string;
    view: "timeSeries" | "singleValue" | undefined;
    stacked: boolean | undefined;
    yAxis: yAxisJson | undefined;
    */
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

    // public addWidgetJsons(widgetJsons: wjson.WidgetJson[], xOffset: number, yOffset: number) {
    //     const json: wjson.TimeSeriesMetricWidgetJson = {
    //         type: "metric",
    //         ...this.dimensions(xOffset, yOffset),
    //         properties: {
    //             view: "timeSeries",
    //             stacked: false,
    //         },
    //     };

    //     widgetJsons.push(json);
    // }
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

    // public addWidgetJsons(widgetJsons: wjson.WidgetJson[], xOffset: number, yOffset: number) {
    //     const json: wjson.TimeSeriesMetricWidgetJson = {
    //         type: "metric",
    //         ...this.dimensions(xOffset, yOffset),
    //         properties: {
    //             view: "timeSeries",
    //             stacked: true,
    //         },
    //     };

    //     widgetJsons.push(json);
    // }
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

    /** The region of the metric. */
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
     * if [fill] is ["band"] this will have shading between the values of [upperEdge] and
     * [lowerEdge].  [lowerEdge] is required in this case.
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

