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

export abstract class Widget {
    /**
     * The width of the widget in grid units (in a 24-column grid). The default is 6.
     *
     * Valid Values: 1–24
     *
     * Type: Integer
     */
    abstract width(): number;

    /**
     * The height of the widget in grid units. The default is 6.
     *
     * Valid Values: 1–1000
     */
    abstract height(): number;

    /**
     * Converts this widget to an appropriate JSON pojo.  The [xOffset] and [yOffset] parameters
     * specify where in the final [Dashboard] grid this [Widget] should be placed.
     */
    public abstract addWidgetJsons(widgetJsons: WidgetJson[], xOffset: number, yOffset: number): void;
}

interface WidgetDimension {
    /** x-position of this widget, relative to the x-position of its container. */
    relativeX: number;
    /** y-position of this widget, relative to the y-position of its container. */
    relativeY: number;
    width: number;
    height: number;
}

/**
 * A sequence of widgets flowing either horizontally or vertically.  Widgets flowing horizontally
 * must wrap after 24 grid columns.  There is no effective vertical limit on widgets flowing
 * vertically.
 */
export abstract class FlowWidget extends Widget {
    protected readonly widgets: Widget[] = [];

    // Do not access any of these variables directly.  They should only be accessed through their
    // respective getters.

    private _width: number | undefined;
    private _height: number | undefined;
    private _widgetDimensions: Map<Widget, WidgetDimension> | undefined;

    constructor(...widgets: Widget[]) {
        super();
        for (const widget of widgets) {
            this.addWidget(widget);
        }
    }

    public addWidget(widget: Widget) {
        this.widgets.push(widget);

        // clear out the cached information about the widgets.  we'll recompute it the next time
        // it's needed.
        this._widgetDimensions = undefined;
        this._height = undefined;
        this._width = undefined;
    }

    protected abstract computeWidgetDimensions(): Map<Widget, WidgetDimension>;

    public width() {
        this.ensureWidthAndHeight();
        return this._width!;
    }

    public height() {
        this.ensureWidthAndHeight();
        return this._height!;
    }

    private ensureWidthAndHeight() {
        if (this._width === undefined) {
            let width = 0;
            let height = 0;

            for (const [_, dimension] of this.getWidgetDimensions()) {
                // The width of the sequence is the rightmost grid column of all of the widgets in
                // the sequence.
                width = Math.max(width, dimension.relativeX + dimension.width);

                // The height of the sequence is the bottommost grid column of all the widgets in
                // the sequence.
                height = Math.max(height, dimension.relativeY + dimension.height);
            }

            this._width = width;
            this._height = height;
        }
    }

    /**
     * Gets the dimensions of all the Widgets in this sequence.  `x`, `width` and `height` will all
     * be correct.  `y` will be relative the position of this vertical point of this sequence in the
     * [Dashboard] grid. In other words, the first widget will be at the [x,y] point [0,0].  This
     * `x` grid coordinate is correct in the final [Dashboard].  But the `y` coordinate will have to
     * be adjusted accordingly.
     */
    protected getWidgetDimensions(): Map<Widget, WidgetDimension> {
        if (!this._widgetDimensions) {
            this._widgetDimensions = this.computeWidgetDimensions();
        }

        return this._widgetDimensions;
    }

    /** @internal */
    public addWidgetJsons(widgetJsons: WidgetJson[], xOffset: number, yOffset: number) {
        for (const [widget, dimension] of this.getWidgetDimensions()) {
            widget.addWidgetJsons(widgetJsons, xOffset + dimension.relativeX, yOffset + dimension.relativeY);
        }
    }
}

/**
 * Represents a vertical sequence of [Widget]s in the [Dashboard].  There is no limit on how long
 * this sequence will be.
 *
 * The final width of this widget will be the width of the largest item in the column. The final
 * height of this widget will be the sum of all the heights of all the widgets in the column.
 */
export class ColumnWidget extends FlowWidget {
    constructor(...widgets: Widget[]) {
        super(...widgets);
    }

    protected computeWidgetDimensions(): Map<Widget, WidgetDimension> {
        const result = new Map<Widget, WidgetDimension>();

        let currentY = 0;
        for (const widget of this.widgets) {
            const widgetHeight = widget.height();
            const widgetWidth = widget.width();

            // In a vertical flow, there is no wraparound.  So all subwidgets start at the same
            // x-position as their parent.  Each is placed below the last though.  So the relativeY
            // keeps getting incremented by the height of the last widget we added.
            result.set(widget, { relativeX: 0, relativeY: currentY, width: widgetWidth, height: widgetHeight });
            currentY += widgetHeight;
        }

        return result;
    }
}

/**
 * Represents a horizontal sequence of [Widget]s in the [Dashboard].  Widgets are laid out
 * horizontally in the grid until it would go past the max width of 24 columns.  When that happens,
 * the widgets will wrap to the next available grid row.
 *
 * Rows must start in the leftmost grid column.
 *
 * The final width of this widget will be the furthest column that a widget is placed at prior to
 * wrapping. The final height of this widget will be the bottommost row that a widget is placed at.
 */
export class RowWidget extends FlowWidget {
    constructor(...widgets: Widget[]) {
        super(...widgets);
    }

    protected computeWidgetDimensions(): Map<Widget, WidgetDimension> {
        const result = new Map<Widget, WidgetDimension>();

        const maxWidth = 24;

        let height = 0;
        let currentY = 0;
        let currentX = 0;
        for (const widget of this.widgets) {
            const widgetHeight = widget.height();
            const widgetWidth = widget.width();

            if (widgetWidth > maxWidth) {
                throw new Error(`Widget width cannot be greater than ${maxWidth}.`);
            }

            // If this widget would go past 24 grid columns then wrap around.
            if (currentX + widgetWidth > maxWidth) {
                currentX = 0;
                currentY = height;
            }

            height = Math.max(height, currentY + widgetHeight);
            result.set(widget, { relativeX: currentX, relativeY: currentY, width: widgetWidth, height: widgetHeight });

            currentX += widgetWidth;
        }

        return result;
    }

    /** @internal */
    public addWidgetJsons(widgetJsons: WidgetJson[], xOffset: number, yOffset: number) {
        if (xOffset !== 0) {
            throw new Error(`A HorizontalWidgetSequence must be placed in the leftmost grid column: ${xOffset}`);
        }

        return super.addWidgetJsons(widgetJsons, xOffset, yOffset);
    }
}

export class TextWidget extends Widget {
    private readonly args: TextWidgetArgs;

    constructor(markdown: string);
    constructor(args: TextWidgetArgs);
    constructor(markdownOrArgs: string | TextWidgetArgs) {
        super();

        this.args = typeof markdownOrArgs === "string" ? { markdown: markdownOrArgs } : markdownOrArgs;
    }

    public width() {
        return this.args.width !== undefined ? this.args.width : 6;
    }

    public height() {
        return this.args.height !== undefined ? this.args.height : 6;
    }

    public addWidgetJsons(widgetJsons: WidgetJson[], xOffset: number, yOffset: number) {
        const json: TextWidgetJson = {
            type: "text",
            x: xOffset,
            y: yOffset,
            width: this.width(),
            height: this.height(),
            properties: {
                markdown: this.args.markdown,
            },
        };

        widgetJsons.push(json);
    }
}

export interface TextWidgetArgs {
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

    /**
     * The text to be displayed by the widget.
     */
    markdown: string;
}

export interface WidgetJson {
    type: "metric" | "text";
    x: number;
    y: number;
    width: number;
    height: number;
    properties: Record<string, any>;
}

interface TextWidgetJson extends WidgetJson {
    type: "text";
    properties: { markdown: string };
}

interface MetricWidgetJson extends WidgetJson {
    type: "metric";
    properties: {
        metrics: MetricJson[] | undefined,
        annotations: {
            alarms: pulumi.Input<string>[] | undefined,
            horizontal: HorizontalAnnotationJsonBase[] | undefined,
            vertical: VerticalAnnotationJsonBase[] | undefined,
        } | undefined;
        title: string | undefined;
        period: number | undefined;
        region: string;
        stat: string;
        view: "timeSeries" | "singleValue" | undefined;
        stacked: boolean | undefined;
        yAxis: yAxisJson | undefined;
    };
}

type MetricJson = SingleMetricJson | ExpressionMetricJson;

type ExpressionMetricJson = [{ expression: string, label: string | undefined, id: string | undefined }];

type SingleMetricJson = (string | RenderingProperties)[];

interface RenderingProperties {
    color: string | undefined;
    label: string | undefined;
    period: number | undefined;
    stat: string | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

interface HorizontalAnnotationJsonBase {
    value: number;
    label: string | undefined;
}

interface HorizontalAnnotationJson extends HorizontalAnnotationJsonBase {
    color: string | undefined;
    fill: string | undefined;
    visible: boolean | undefined;
    yAxis: "right" | "left" | undefined;
}

interface VerticalAnnotationJsonBase {
    value: string;
    label: string | undefined;
}

interface VerticalAnnotationJson extends VerticalAnnotationJsonBase {
    color: string | undefined;
    fill: string | undefined;
    visible: boolean | undefined;
}

interface yAxisJson {
    left:  { min: number | undefined, max: number | undefined } | undefined;
    right: { min: number | undefined, max: number | undefined } | undefined;
}

interface AlarmWidgetJson extends MetricWidgetJson {

}