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

    protected abstract computeType(): "text" | "metric";
    protected abstract computeProperties(): Record<string, any>;

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

        return {
            stat,
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

    // public addWidgetJsons(widgetJsons: wjson.WidgetJson[], xOffset: number, yOffset: number) {
    //     const json: wjson.SingleValueMetricWidgetJson = {
    //         type: "metric",
    //         x: xOffset,
    //         y: yOffset,
    //         width: this.width(),
    //         height: this.height(),
    //         properties: {
    //             view: "singleValue",
    //         },
    //     };

    //     widgetJsons.push(json);
    // }
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
}

export interface SingleNumberMetricWidgetArgs extends MetricWidgetArgs {
    yAxis?: never;
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

