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

// This file contains four categories of exports:
//
//     1) A union type, MetricsGranularity, that accepts any valid metrics granularity
//     2) Individual constants for each such metrics granularity
//     3) A union type, Metric, that accepts any valid metrics type
//     4) Individual constants for each such metric type
//
// These give a better developer experience and are just sugared strings.

import {MetricsGranularity, Metric} from ".";

// @deprecated Use MetricsGranularity.OneMinute instead.
export let OneMinuteMetricsGranularity: MetricsGranularity = "1Minute";

// @deprecated Use Metric.GroupMinSize instead.
export let GroupMinSizeMetric: Metric = "GroupMinSize";
// @deprecated Use Metric.GroupMaxSize instead.
export let GroupMaxSizeMetric: Metric = "GroupMaxSize";
// @deprecated Use Metric.GroupDesiredCapacity instead.
export let GroupDesiredCapacityMetric: Metric = "GroupDesiredCapacity";
// @deprecated Use Metric.GroupGroupInServiceInstancesMinSize instead.
export let GroupInServiceInstancesMetric: Metric = "GroupInServiceInstances";
// @deprecated Use Metric.GroupPendingInstances instead.
export let GroupPendingInstances: Metric = "GroupPendingInstances";
// @deprecated Use Metric.GroupStandbyInstances instead.
export let GroupStandbyInstances: Metric = "GroupStandbyInstances";
// @deprecated Use Metric.GroupTerminatingInstances instead.
export let GroupTerminatingInstances: Metric = "GroupTerminatingInstances";
// @deprecated Use Metric.GroupTotalInstances instead.
export let GroupTotalInstances: Metric = "GroupTotalInstances";
