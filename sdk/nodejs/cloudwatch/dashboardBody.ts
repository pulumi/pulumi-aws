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

import * as utils from "../utils";

import { Widget } from "./widgets";
import { WidgetJson } from "./widgetJson";
import { ColumnWidget, RowWidget } from "./flowWidgets";

/**
 * [Dashboard]s are represented by a grid of columns 24 wide, with an unlimited number of rows.
 *
 * Each [Widget] in the [Dashboard] have a specific width/height in terms of grid units.
 */
export class DashboardBody {
    /**
     * Name of the dashboard.  If not provided, will be set to the name of the pulumi resource
     * created for the acutal aws.cloudwatch.Dashboard.
     */
    public readonly name: pulumi.Output<string | undefined>;

    public readonly start: pulumi.Output<string | undefined>;
    public readonly end: pulumi.Output<string | undefined>;
    public readonly periodOverride: pulumi.Output<"auto" | "inherit" | undefined>;

    private readonly rows: RowWidget[] = [];

    /**
     * Constructs a [DashboardGrid] out of [Widget]s.  If any of these Widgets are [RowWidget]s.
     * then these will be treated as a sequence of rows to add to the grid.  Otherwise, this will
     * be treated as a single row to add to the grid.
     */
    constructor(args: DashboardBodyArgs = {}) {
        this.name = pulumi.output(args.name);
        this.start = pulumi.output(args.start);
        this.end = pulumi.output(args.end);
        this.periodOverride = pulumi.output(args.periodOverride);

        const widgets = args.widgets || [];
        if (widgets.length > 0) {
            const firstWidgetIsRow = widgets[0] instanceof RowWidget;
            for (let i = 1; i < widgets.length; i++) {
                const currentWidgetIsRow = widgets[i] instanceof RowWidget;
                if (firstWidgetIsRow !== currentWidgetIsRow) {
                    throw new Error("All widgets must either be RowWidgets or none of them must be.");
                }
            }

            if (firstWidgetIsRow) {
                this.addRows(...<RowWidget[]>widgets);
            }
            else {
                this.addWidgets(...widgets);
            }
        }
    }

    /**
     * Creates a [RowWidget] from the supplied [Widget]s and adds that single row to the grid.
     */
    public addWidgets(...widgets: Widget[]) {
        this.addRow(new RowWidget(...widgets));
    }

    /**
     * Creates a [RowWidget] containing the single supplied [Widget] and adds that single row to the
     * grid.
     */
    public addWidget(widget: Widget) {
        this.addRow(new RowWidget(widget));
    }

    /**
     * Adds the provided rows to the grid.
     */
    public addRows(...rows: RowWidget[]) {
        for (const row of rows) {
            this.addRow(row);
        }
    }
    /**
     * Adds the provided row to the grid.
     */
    public addRow(row: RowWidget) {
        this.rows.push(row);
    }

    /** @internal */
    public toDashboardJson(): pulumi.Output<DashboardJson> {
        const widgetJsons: WidgetJson[] = [];
        new ColumnWidget(...this.rows).addWidgetJson(widgetJsons, /*xOffset:*/ 0, /*yOffset:*/0);

        const op = pulumi.output({
            start: this.start,
            end: this.end,
            periodOverride: this.periodOverride,
            widgets: widgetJsons,
        });

        return op;
    }
}

export interface DashboardBodyArgs {
    /**
     * The name of the dashboard.
     */
    name?: pulumi.Input<string>;

    /**
     * The end of the time range to use for each widget on the dashboard when the dashboard loads.
     * If you specify a value for end, you must also specify a value for start. For each of these
     * values, specify an absolute time in the ISO 8601 format. For example,
     * 2018-12-17T06:00:00.000Z.
     */
    end?: pulumi.Input<string>;

    /**
     * The start of the time range to use for each widget on the dashboard.
     *
     * You can specify start without specifying end to specify a relative time range that ends with
     * the current time. In this case, the value of start must begin with -P, and you can use M, H,
     * D, W and M as abbreviations for minutes, hours, days, weeks and months. For example, -PT8H
     * shows the last 8 hours and -P3M shows the last three months.
     *
     * You can also use start along with an end field, to specify an absolute time range. When
     * specifying an absolute time range, use the ISO 8601 format. For example,
     * 2018-12-17T06:00:00.000Z.
     *
     * If you omit start, the dashboard shows the default time range when it loads.
    */
    start?: pulumi.Input<string>;

    /**
     * Use this field to specify the period for the graphs when the dashboard loads. Specifying auto
     * causes the period of all graphs on the dashboard to automatically adapt to the time range of
     * the dashboard. Specifying inherit ensures that the period set for each graph is always
     * obeyed.
     */
    periodOverride?: pulumi.Input<"auto" | "inherit">;

    /**
     * Widgets to initially add to the [DashboardBody].  If any of these are [RowWidgets] this will
     * be treated as a sequence of rows.  If not, then this will be treated as a sequence of widgets
     * to make a single row out of.
     */
    widgets?: Widget[];
}

interface DashboardJson {
    end?: string;
    start?: string;
    periodOverride?: "auto" | "inherit";
    widgets?: WidgetJson[];
}