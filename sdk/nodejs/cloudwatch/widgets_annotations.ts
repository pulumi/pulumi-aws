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

import * as wjson from "./widgets_json";

// Contains all the classes for easily making 'annotations' in a "metric" widget.

/**
 * Base interface for values that can be placed inside [MetricWidgetArgs.annotations]. Instances of
 * this interface include [aws.cloudwatch.Alarm], [AlarmAnnotation], [HorizontalAnnotation] and
 * [VerticalAnnotation].
 */
export interface WidgetAnnotation {
    /** For internal use only. Only intended to be called by [MetricWidget]. */
    addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson);
}

/**
 * Adds an alarm annotation to a [MetricWidget], allowing a metric alarm to be displayed in a
 * Dashboard.
 */
export class AlarmAnnotation implements WidgetAnnotation {
    constructor(private readonly alarmArn: pulumi.Input<string>) {
    }

    /** @internal */
    public addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson) {
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
export class HorizontalAnnotation implements WidgetAnnotation {
    constructor(private readonly args: HorizontalAnnotationArgs) {
        if (args.fill && args.belowEdge) {
            throw new Error(`[args.fill] should not be provided if [args.belowEdge] is provided.`);
        }
    }

    /** @internal */
    public addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson) {
        annotations.horizontal = annotations.horizontal || [];

        const annotation: wjson.HorizontalAnnotationJson = {
            fill: this.args.fill,
            color: this.args.color,
            label: this.args.aboveEdge.label,
            value: this.args.aboveEdge.value,
            visible: this.args.visible,
            yAxis: this.args.yAxis,
        };

        annotations.horizontal.push(annotation);

        if (this.args.belowEdge) {
            annotations.horizontal.push({
                value: this.args.belowEdge.value,
                label: this.args.belowEdge.label,
            });
        }
    }
}

export interface HorizontalAnnotationArgs {
    /**
     * The metric value in the graph where the horizontal annotation line is to appear.  If
     * [belowEdge] is also provided, then this will produce a band annotation.  In that case [fill]
     * should not be provided.
     */
    aboveEdge: HorizontalEdge;

    /**
     * The lower edge when using band shading.
     */
    belowEdge?: HorizontalEdge;

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
    value: pulumi.Input<number>;

    /**
     * A string that appears on the graph next to the annotation.
     */
    label?: pulumi.Input<string>;
}

/**
 * Vertical annotations have several options for fill shading, including shading before the
 * annotation line, shading after the annotation line, and "band" shading that appears between two
 * linked annotation lines as part of a single band annotation
 */
export class VerticalAnnotation implements WidgetAnnotation {
    constructor(private readonly args: VerticalAnnotationArgs) {
        if (args.fill && args.afterEdge) {
            throw new Error(`[args.fill] should not be provided if [args.afterEdge] is provided.`);
        }
    }

    /** @internal */
    public addWidgetJson(annotations: wjson.MetricWidgetAnnotationsJson) {
        annotations.vertical = annotations.vertical || [];

        const annotation: wjson.VerticalAnnotationJson = {
            fill: this.args.fill,
            color: this.args.color,
            label: this.args.beforeEdge.label,
            value: this.args.beforeEdge.value,
            visible: this.args.visible,
        };

        annotations.vertical.push(annotation);

        if (this.args.afterEdge) {
            annotations.vertical.push({
                value: this.args.afterEdge.value,
                label: this.args.afterEdge.label,
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
    beforeEdge: VerticalEdge;

    /**
     * The ending edge when using band shading.
     */
    afterEdge?: VerticalEdge;

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