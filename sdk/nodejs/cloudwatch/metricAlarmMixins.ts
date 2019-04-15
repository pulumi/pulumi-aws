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

import { MetricAlarm } from "./metricAlarm";
import { HorizontalAnnotation, WidgetAnnotation } from "./simpleWidgets";

import * as wjson from "./widgetJson";

declare module "./metricAlarm" {
    /**
     * Mixin WidgetAnnotation.addWidgetJson so that a MetricAlarm can be used in
     * [MetricWidgetArgs.annotations].  If added to [MetricWidgetArgs.annotations] it will
     * show up as a horizontal line in the graph with the description of this alarm.
     *
     * To make an actual widget that shows an alarm when this [MetricAlarm] is triggered,
     * pass this [MetricAlarm] to [MetricWidgetArgs.alarm].
     */
    interface MetricAlarm extends WidgetAnnotation {
    }
}

MetricAlarm.prototype.addWidgetJson = function(this: MetricAlarm, annotations: wjson.MetricWidgetAnnotationsJson) {
    new HorizontalAnnotation({
        aboveEdge: {
            label: this.alarmDescription,
            value: this.threshold,
        }
    }).addWidgetJson(annotations);
}

/** @internal */
export const __metricAlarmUnused = 0;