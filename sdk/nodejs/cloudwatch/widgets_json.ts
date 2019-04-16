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

import { YAxis } from "./widgets_graph";

// All the typings for the json blob we need to create for Dashboard.dashboardBody. We'll convert
// the right in-memory auto-laid-out system we have into these.  These typings are purely so we do
// the json conversion properly as it's very easy to screw up if using things like the 'any' type.

export interface WidgetJson {
    type: pulumi.Input<"metric" | "text">;
    x: pulumi.Input<number>;
    y: pulumi.Input<number>;
    width: pulumi.Input<number>;
    height: pulumi.Input<number>;
    properties: Record<string, any>;
}

export interface TextWidgetJson extends WidgetJson {
    type: pulumi.Input<"text">;
    properties: pulumi.Input<{ markdown: pulumi.Input<string> }>;
}

export interface MetricWidgetJson extends WidgetJson {
    type: pulumi.Input<"metric">;
    properties: pulumi.Input<MetricWidgetPropertiesJson>;
}

export interface MetricWidgetPropertiesJson {
    metrics: MetricJson[] | undefined,
    annotations: MetricWidgetAnnotationsJson | undefined;
    title: pulumi.Input<string> | undefined;
    period: pulumi.Input<number> | undefined;
    region: pulumi.Input<string>;
    stat: pulumi.Input<string>;
    view: pulumi.Input<"timeSeries" | "singleValue" | undefined>;
    stacked: pulumi.Input<boolean | undefined>;
    yAxis: pulumi.Input<YAxis> | undefined;
}

export interface MetricWidgetAnnotationsJson {
    alarms?: pulumi.Input<string>[];
    horizontal?: BaseHorizontalAnnotationJson[];
    vertical?: BaseVerticalAnnotationJson[];
}

export type MetricJson = SingleMetricJson | ExpressionMetricJson;

export type ExpressionMetricJson = [{
    expression: pulumi.Input<string>,
    label: pulumi.Input<string | undefined>,
    id: pulumi.Input<string | undefined>,
}];

export type SingleMetricJson = pulumi.Output<(string | RenderingPropertiesJson)[]>;

export interface RenderingPropertiesJson {
    color: string | undefined;
    label: string | undefined;
    period: number | undefined;
    stat: string | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

export interface BaseHorizontalAnnotationJson {
    value: pulumi.Input<number>;
    label: pulumi.Input<string | undefined>;
}

export interface HorizontalAnnotationJson extends BaseHorizontalAnnotationJson {
    color: string | undefined;
    fill: "above" | "below" | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

interface BaseVerticalAnnotationJson {
    value: pulumi.Input<string>;
    label: pulumi.Input<string | undefined>;
}

export interface VerticalAnnotationJson extends BaseVerticalAnnotationJson {
    color: string | undefined;
    fill: "before" | "after" | undefined;
    visible: boolean | undefined;
}