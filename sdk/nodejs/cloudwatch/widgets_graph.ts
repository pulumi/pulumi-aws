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

import { MetricWidget, MetricWidgetArgs } from "./widgets_simple";

// Contains all the classes for easily making graph widgets in a dashboard.

export interface GraphMetricWidgetArgs extends MetricWidgetArgs {
    /**
     * Limits for the minimums and maximums of the y-axis.  This applies to every metric being
     * graphed, unless specific metrics override it.
     */
    yAxis?: pulumi.Input<YAxis>;
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