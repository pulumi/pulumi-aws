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


import * as cloudwatch from "../cloudwatch";

export let OneMinuteMetricsGranularity: MetricsGranularity = "1Minute";

// See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_EnableMetricsCollection.html
export type MetricsGranularity =
    "1Minute";

export let GroupMinSizeMetric: Metric = "GroupMinSize";
export let GroupMaxSizeMetric: Metric = "GroupMaxSize";
export let GroupDesiredCapacityMetric: Metric = "GroupDesiredCapacity";
export let GroupInServiceInstancesMetric: Metric = "GroupInServiceInstances";
export let GroupPendingInstances: Metric = "GroupPendingInstances";
export let GroupStandbyInstances: Metric = "GroupStandbyInstances";
export let GroupTerminatingInstances: Metric = "GroupTerminatingInstances";
export let GroupTotalInstances: Metric = "GroupTotalInstances";

// See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_EnableMetricsCollection.html
export type Metric =
    "GroupMinSize" |
    "GroupMaxSize" |
    "GroupDesiredCapacity" |
    "GroupInServiceInstances" |
    "GroupPendingInstances" |
    "GroupStandbyInstances" |
    "GroupTerminatingInstances" |
    "GroupTotalInstances";

export type AutoscalingMetricName = Metric;

/**
 * Creates an AWS/AutoScaling metric with the requested [metricName]. See
 * https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/viewing_metrics_with_cloudwatch.html for list
 * of all metric-names.
 *
 * Note, individual metrics can easily be obtained without supplying the name using the other
 * [metricXXX] functions.
 *
 * Amazon CloudWatch enables you to retrieve statistics as an ordered set of time-series data, known
 * as metrics. You can use these metrics to verify that your system is performing as expected.
 *
 * Amazon EC2 sends metrics to CloudWatch that describe your Auto Scaling instances. These metrics
 * are available for any EC2 instance, not just those in an Auto Scaling group. For more
 * information, see Instance Metrics in the Amazon EC2 User Guide for Linux Instances.
 *
 * Auto Scaling groups can send metrics to CloudWatch that describe the group itself. You must
 * enable these metrics.
 *
 * To filter the metrics for your Auto Scaling group by group name, use the "AutoScalingGroupName"
 * dimension.
 */
export function metric(metricName: AutoscalingMetricName, change: cloudwatch.MetricChange = {}) {
    return new cloudwatch.Metric({
        namespace: "AWS/AutoScaling",
        name: metricName,
        ...change,
    });
}

/**
 * The minimum size of the Auto Scaling group.
 */
export function metricGroupMinSize(change: cloudwatch.MetricChange = {}) {
    return metric("GroupMinSize", change);
}

/**
 * The maximum size of the Auto Scaling group.
 */
export function metricGroupMaxSize(change: cloudwatch.MetricChange = {}) {
    return metric("GroupMaxSize", change);
}

/**
 * The number of instances that the Auto Scaling group attempts to maintain.
 */
export function metricGroupDesiredCapacity(change: cloudwatch.MetricChange = {}) {
    return metric("GroupDesiredCapacity", change);
}

/**
 * The number of instances that are running as part of the Auto Scaling group. This metric does not
 * include instances that are pending or terminating.
 */
export function metricGroupInServiceInstances(change: cloudwatch.MetricChange = {}) {
    return metric("GroupInServiceInstances", change);
}

/**
 * The number of instances that are pending. A pending instance is not yet in service. This metric
 * does not include instances that are in service or terminating.
 */
export function metricGroupPendingInstances(change: cloudwatch.MetricChange = {}) {
    return metric("GroupPendingInstances", change);
}

/**
 * The number of instances that are in a Standby state. Instances in this state are still running
 * but are not actively in service.
 */
export function metricGroupStandbyInstances(change: cloudwatch.MetricChange = {}) {
    return metric("GroupStandbyInstances", change);
}

/**
 * The number of instances that are in the process of terminating. This metric does not include
 * instances that are in service or pending.
 */
export function metricGroupTerminatingInstances(change: cloudwatch.MetricChange = {}) {
    return metric("GroupTerminatingInstances", change);
}

/**
 * The total number of instances in the Auto Scaling group. This metric identifies the number of
 * instances that are in service, pending, and terminating.
 */
export function metricGroupTotalInstances(change: cloudwatch.MetricChange = {}) {
    return metric("GroupTotalInstances", change);
}
