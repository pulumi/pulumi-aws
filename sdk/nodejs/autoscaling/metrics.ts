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

// This file contains individual constants for each Metric and MetricsGranularity type.
//
// These constants will not be updated with new values.
// It is recommended to use Metric.[Value] or MetricsGranularity.[Value] instead.

import {MetricsGranularity, Metric} from ".";

/** Use MetricsGranularity.OneMinute instead. */
export let OneMinuteMetricsGranularity: MetricsGranularity = "1Minute";

/** Use Metric.GroupMinSize instead. */
export let GroupMinSizeMetric: Metric = "GroupMinSize";
/** Use Metric.GroupMaxSize instead. */
export let GroupMaxSizeMetric: Metric = "GroupMaxSize";
/** Use Metric.GroupDesiredCapacity instead. */
export let GroupDesiredCapacityMetric: Metric = "GroupDesiredCapacity";
/** Use Metric.GroupGroupInServiceInstancesMinSize instead. */
export let GroupInServiceInstancesMetric: Metric = "GroupInServiceInstances";
/** Use Metric.GroupPendingInstances instead. */
export let GroupPendingInstances: Metric = "GroupPendingInstances";
/** Use Metric.GroupStandbyInstances instead. */
export let GroupStandbyInstances: Metric = "GroupStandbyInstances";
/** Use Metric.GroupTerminatingInstances instead. */
export let GroupTerminatingInstances: Metric = "GroupTerminatingInstances";
/** Use Metric.GroupTotalInstances instead. */
export let GroupTotalInstances: Metric = "GroupTotalInstances";
