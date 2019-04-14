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

import { YAxis } from "./simpleWidgets";

export interface WidgetJson {
    type: "metric" | "text";
    x: number;
    y: number;
    width: number;
    height: number;
    properties: Record<string, any>;
}

export interface TextWidgetJson extends WidgetJson {
    type: "text";
    properties: { markdown: string };
}

export interface MetricWidgetJson extends WidgetJson {
    type: "metric";
    properties: MetricWidgetPropertiesJson;
}

export interface MetricWidgetPropertiesJson {
    metrics: MetricJson[] | undefined,
    annotations: MetricWidgetAnnotationsJson | undefined;
    title: string | undefined;
    period: number | undefined;
    region: string;
    stat: string;
    view: "timeSeries" | "singleValue" | undefined;
    stacked: boolean | undefined;
    yAxis: YAxis | undefined;
}

export interface MetricWidgetAnnotationsJson {
    alarms?: pulumi.Input<string>[];
    horizontal?: BaseHorizontalAnnotationJson[];
    vertical?: BaseVerticalAnnotationJson[];
}

// interface TimeSeriesMetricWidgetPropertiesJson extends MetricWidgetPropertiesJson {
//     view: "timeSeries";
// }

// interface SingleValueMetricWidgetPropertiesJson extends MetricWidgetPropertiesJson {
//     view: "singleValue";
// }

// export interface TimeSeriesMetricWidgetJson extends MetricWidgetJson {
//     properties: TimeSeriesMetricWidgetPropertiesJson;
// }

// export interface SingleValueMetricWidgetJson extends MetricWidgetJson {
//     properties: SingleValueMetricWidgetPropertiesJson;
// }

export type MetricJson = SingleMetricJson | ExpressionMetricJson;

export type ExpressionMetricJson = [{ expression: string, label: string | undefined, id: string | undefined }];

export type SingleMetricJson = (string | RenderingPropertiesJson)[];

interface RenderingPropertiesJson {
    color: string | undefined;
    label: string | undefined;
    period: number | undefined;
    stat: string | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

export interface BaseHorizontalAnnotationJson {
    value: number;
    label: string | undefined;
}

export interface HorizontalAnnotationJson extends BaseHorizontalAnnotationJson {
    color: string | undefined;
    fill: "above" | "below" | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

interface BaseVerticalAnnotationJson {
    value: string;
    label: string | undefined;
}

export interface VerticalAnnotationJson extends BaseVerticalAnnotationJson {
    color: string | undefined;
    fill: "before" | "after" | undefined;
    visible: boolean | undefined;
}