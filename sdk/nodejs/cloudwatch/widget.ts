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

import { WidgetJson } from "./widgets_json";

/**
 * Base type for all [Widget]s that can be placed in a [DashboardGrid].
 *
 * 1. [RowWidget] and [ColumnWidget] can be used to easily flow other Widgets in a horizontal or
 *    vertical direction.
 *
 * 2. [TextWidget] can be used to add text labels easily to the grid.
 *
 * 3. [SingleNumberMetricWidget] can be used to make a widget that displays information about a
 *    [Metric] as a single number.
 *
 * 4. [LineGraphMetricWidget] and [StackedAreaGraphMetricWidget] can be used to display a series
 *    of metric values as a graph.
 */
export interface Widget {
    /**
     * The width of the widget in grid units (in a 24-column grid). The default is 6.
     *
     * Valid Values: 1–24
     *
     * Type: Integer
     */
    width(): number;

    /**
     * The height of the widget in grid units. The default is 6.
     *
     * Valid Values: 1–1000
     */
    height(): number;

    /**
     * @internal
     * Converts this widget to an appropriate JSON pojo.  The [xOffset] and [yOffset] parameters
     * specify where in the final [Dashboard] grid this [Widget] should be placed.
     */
    addWidgetJson(widgetJsons: WidgetJson[], xOffset: number, yOffset: number): void;
}
