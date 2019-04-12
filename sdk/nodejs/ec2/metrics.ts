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

import * as cloudwatch from "../cloudwatch";

export module metrics {
    export type Ec2MetricName =
        "CPUCreditUsage" | "CPUCreditBalance" | "CPUSurplusCreditBalance" | "CPUSurplusCreditsCharged" |
        "CPUUtilization" | "DiskReadOps" | "DiskWriteOps" | "DiskReadBytes" | "DiskWriteBytes" |
        "NetworkIn" | "NetworkOut" | "NetworkPacketsIn" | "NetworkPacketsOut" |
        "StatusCheckFailed" | "StatusCheckFailed_Instance" | "StatusCheckFailed_System" |
        "EBSReadOps" | "EBSWriteOps" | "EBSReadBytes" | "EBSWriteBytes" |
        "EBSIOBalance%" | "EBSByteBalance%";

    /**
     * Creates an AWS/EC2 metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/viewing_metrics_with_cloudwatch.html for list
     * of all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * Amazon EC2 sends metrics to Amazon CloudWatch. You can use the AWS Management Console, the AWS
     * CLI, or an API to list the metrics that Amazon EC2 sends to CloudWatch. By default, each data
     * point covers the 5 minutes that follow the start time of activity for the instance. If you've
     * enabled detailed monitoring, each data point covers the next minute of activity from the start
     * time.
     *
     * You can use the following dimensions to refine the metrics returned for your instances.
     *
     * 1. "AutoScalingGroupName": This dimension filters the data you request for all instances in a
     *    specified capacity group. An Auto Scaling group is a collection of instances you define if
     *    you're using Auto Scaling. This dimension is available only for Amazon EC2 metrics when the
     *    instances are in such an Auto Scaling group. Available for instances with Detailed or Basic
     *    Monitoring enabled.
     * 2. "ImageId": This dimension filters the data you request for all instances running this Amazon
     *    EC2 Amazon Machine Image (AMI). Available for instances with Detailed Monitoring enabled.
     * 3. "InstanceId": This dimension filters the data you request for the identified instance only.
     *    This helps you pinpoint an exact instance from which to monitor data.
     * 4. "InstanceType": This dimension filters the data you request for all instances running with
     *    this specified instance type. This helps you categorize your data by the type of instance
     *    running. For example, you might compare data from an m1.small instance and an m1.large
     *    instance to determine which has the better business value for your application. Available for
     *    instances with Detailed Monitoring enabled.
     */
    function metric(metricName: Ec2MetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/EC2",
            name: metricName,
            ...change,
        });
    }

    /**
     * The number of CPU credits spent by the instance for CPU utilization. One CPU credit equals one
     * vCPU running at 100% utilization for one minute or an equivalent combination of vCPUs,
     * utilization, and time (for example, one vCPU running at 50% utilization for two minutes or two
     * vCPUs running at 25% utilization for two minutes).
     *
     * CPU credit metrics are available at a five-minute frequency only. If you specify a period greater
     * than five minutes, use the Sum statistic instead of the Average statistic.
     */
    export function cpuCreditUsage(change: cloudwatch.MetricChange = {}) {
        return metric("CPUCreditUsage", change);
    }

    /**
     * The number of earned CPU credits that an instance has accrued since it was launched or started.
     * For T2 Standard, the CPUCreditBalance also includes the number of launch credits that have been
     * accrued.
     *
     * Credits are accrued in the credit balance after they are earned, and removed from the credit
     * balance when they are spent. The credit balance has a maximum limit, determined by the instance
     * size. After the limit is reached, any new credits that are earned are discarded. For T2 Standard,
     * launch credits do not count towards the limit.
     *
     * The credits in the CPUCreditBalance are available for the instance to spend to burst beyond its
     * baseline CPU utilization.
     *
     * When an instance is running, credits in the CPUCreditBalance do not expire. When a T3 instance
     * stops, the CPUCreditBalance value persists for seven days. Thereafter, all accrued credits are
     * lost. When a T2 instance stops, the CPUCreditBalance value does not persist, and all accrued
     * credits are lost.
     *
     * CPU credit metrics are available at a five-minute frequency only.
     */
    export function cpuCreditBalance(change: cloudwatch.MetricChange = {}) {
        return metric("CPUCreditBalance", change);
    }

    /**
     * The number of surplus credits that have been spent by an unlimited instance when its
     * CPUCreditBalance value is zero.
     *
     * The CPUSurplusCreditBalance value is paid down by earned CPU credits. If the number of surplus
     * credits exceeds the maximum number of credits that the instance can earn in a 24-hour period, the
     * spent surplus credits above the maximum incur an additional charge.
     */
    export function cpuSurplusCreditBalance(change: cloudwatch.MetricChange = {}) {
        return metric("CPUSurplusCreditBalance", change);
    }

    /**
     * The number of spent surplus credits that are not paid down by earned CPU credits, and which thus
     * incur an additional charge.
     *
     * Spent surplus credits are charged when any of the following occurs:
     *
     *  * The spent surplus credits exceed the maximum number of credits that the instance can earn in a
     *    24-hour period. Spent surplus credits above the maximum are charged at the end of the hour.
     *  * The instance is stopped or terminated.
     *  * The instance is switched from unlimited to standard.
     */
    export function cpuSurplusCreditsCharged(change: cloudwatch.MetricChange = {}) {
        return metric("CPUSurplusCreditsCharged", change);
    }

    /**
     * The percentage of allocated EC2 compute units that are currently in use on the instance. This
     * metric identifies the processing power required to run an application upon a selected
     * instance.
     *
     * Depending on the instance type, tools in your operating system can show a lower percentage
     * than CloudWatch when the instance is not allocated a full processor core.
     *
     * Units: Percent
     */
    export function cpuUtilization(change: cloudwatch.MetricChange = {}) {
        return metric("CPUUtilization", { unit: "Percent", ...change });
    }

    /**
     * Completed read operations from all instance store volumes available to the instance in a
     * specified period of time.
     *
     * To calculate the average I/O operations per second (IOPS) for the period, divide the total
     * operations in the period by the number of seconds in that period.
     *
     * If there are no instance store volumes, either the value is 0 or the metric is not reported.
     *
     * Units: Count
     */
    export function diskReadOps(change: cloudwatch.MetricChange = {}) {
        return metric("DiskReadOps", { unit: "Count", ...change });
    }

    /**
     * Completed write operations to all instance store volumes available to the instance in a
     * specified period of time.
     *
     * To calculate the average I/O operations per second (IOPS) for the period, divide the total
     * operations in the period by the number of seconds in that period.
     *
     * If there are no instance store volumes, either the value is 0 or the metric is not reported.
     *
     * Units: Count
     */
    export function diskWriteOps(change: cloudwatch.MetricChange = {}) {
        return metric("DiskWriteOps", { unit: "Count", ...change });
    }

    /**
     * Bytes read from all instance store volumes available to the instance.
     *
     * This metric is used to determine the volume of the data the application reads from the hard
     * disk of the instance. This can be used to determine the speed of the application.
     *
     * The number reported is the number of bytes received during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Bytes/second. If you have
     * detailed (one-minute) monitoring, divide it by 60.
     *
     * If there are no instance store volumes, either the value is 0 or the metric is not reported.
     *
     * Units: Bytes
     */
    export function diskReadBytes(change: cloudwatch.MetricChange = {}) {
        return metric("DiskReadBytes", { unit: "Bytes", ...change });
    }

    /**
     * Bytes written to all instance store volumes available to the instance.
     *
     * This metric is used to determine the volume of the data the application writes onto the hard
     * disk of the instance. This can be used to determine the speed of the application.
     *
     * The number reported is the number of bytes received during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Bytes/second. If you have
     * detailed (one-minute) monitoring, divide it by 60.
     *
     * If there are no instance store volumes, either the value is 0 or the metric is not reported.
     *
     * Units: Bytes
     */
    export function diskWriteBytes(change: cloudwatch.MetricChange = {}) {
        return metric("DiskWriteBytes", { unit: "Bytes", ...change });
    }

    /**
     * The number of bytes received on all network interfaces by the instance. This metric
     * identifies the volume of incoming network traffic to a single instance.
     *
     * The number reported is the number of bytes received during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Bytes/second. If you have
     * detailed (one-minute) monitoring, divide it by 60.
     *
     * Units: Bytes
     */
    export function networkIn(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkIn", { unit: "Bytes", ...change });
    }

    /**
     * The number of bytes sent out on all network interfaces by the instance. This metric
     * identifies the volume of outgoing network traffic from a single instance.
     *
     * The number reported is the number of bytes sent during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Bytes/second. If you have
     * detailed (one-minute) monitoring, divide it by 60.
     *
     * Units: Bytes
     */
    export function networkOut(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkOut", { unit: "Bytes", ...change });
    }

    /**
     * The number of packets received on all network interfaces by the instance. This metric
     * identifies the volume of incoming traffic in terms of the number of packets on a single
     * instance. This metric is available for basic monitoring only.
     *
     * Units: Count
     *
     * Statistics: Minimum, Maximum, Average
     */
    export function networkPacketsIn(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkPacketsIn", { unit: "Count", ...change });
    }

    /**
     * The number of packets sent out on all network interfaces by the instance. This metric
     * identifies the volume of outgoing traffic in terms of the number of packets on a single
     * instance. This metric is available for basic monitoring only.
     *
     * Units: Count
     *
     * Statistics: Minimum, Maximum, Average
     */
    export function networkPacketsOut(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkPacketsOut", { unit: "Count", ...change });
    }

    /**
     * Reports whether the instance has passed both the instance status check and the system status
     * check in the last minute.
     *
     * This metric can be either 0 (passed) or 1 (failed).
     *
     * By default, this metric is available at a 1-minute frequency at no charge.
     *
     * Units: Count
     */
    export function statusCheckFailed(change: cloudwatch.MetricChange = {}) {
        return metric("StatusCheckFailed", { unit: "Count", ...change });
    }

    /**
     * Reports whether the instance has passed the instance status check in the last minute.
     *
     * This metric can be either 0 (passed) or 1 (failed).
     *
     * By default, this metric is available at a 1-minute frequency at no charge.
     *
     * Units: Count
     */
    export function statusCheckFailed_Instance(change: cloudwatch.MetricChange = {}) {
        return metric("StatusCheckFailed_Instance", { unit: "Count", ...change });
    }

    /**
     * Reports whether the instance has passed the system status check in the last minute.
     *
     * This metric can be either 0 (passed) or 1 (failed).
     *
     * By default, this metric is available at a 1-minute frequency at no charge.
     *
     * Units: Count
     */
    export function statusCheckFailed_System(change: cloudwatch.MetricChange = {}) {
        return metric("StatusCheckFailed_System", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * Completed read operations from all Amazon EBS volumes attached to the instance in a specified
     * period of time.
     *
     * To calculate the average read I/O operations per second (Read IOPS) for the period, divide
     * the total operations in the period by the number of seconds in that period. If you are using
     * basic (five-minute) monitoring, you can divide this number by 300 to calculate the Read IOPS.
     * If you have detailed (one-minute) monitoring, divide it by 60.
     *
     * Unit: Count
     */
    export function ebsReadOps(change: cloudwatch.MetricChange = {}) {
        return metric("EBSReadOps", { unit: "Count", ...change });
    }

    /**
     * Completed write operations to all EBS volumes attached to the instance in a specified period
     * of time.
     *
     * To calculate the average write I/O operations per second (Write IOPS) for the period, divide
     * the total operations in the period by the number of seconds in that period. If you are using
     * basic (five-minute) monitoring, you can divide this number by 300 to calculate the Write
     * IOPS. If you have detailed (one-minute) monitoring, divide it by 60.
     *
     * Unit: Count
     */
    export function ebsWriteOps(change: cloudwatch.MetricChange = {}) {
        return metric("EBSWriteOps", { unit: "Count", ...change });
    }

    /**
     * Bytes read from all EBS volumes attached to the instance in a specified period of time.
     *
     * The number reported is the number of bytes read during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Read Bytes/second. If you
     * have detailed (one-minute) monitoring, divide it by 60.
     *
     * Unit: Bytes
     */
    export function ebsReadBytes(change: cloudwatch.MetricChange = {}) {
        return metric("EBSReadBytes", { unit: "Bytes", ...change });
    }

    /**
     * Bytes written to all EBS volumes attached to the instance in a specified period of time.
     *
     * The number reported is the number of bytes written during the period. If you are using basic
     * (five-minute) monitoring, you can divide this number by 300 to find Write Bytes/second. If
     * you have detailed (one-minute) monitoring, divide it by 60.
     *
     * Unit: Bytes
     */
    export function ebsWriteBytes(change: cloudwatch.MetricChange = {}) {
        return metric("EBSWriteBytes", { unit: "Bytes", ...change });
    }

    /**
     * Available only for the smaller instance sizes. Provides information about the percentage of
     * I/O credits remaining in the burst bucket. This metric is available for basic monitoring
     * only.
     *
     * Unit: Percent
     */
    export function ebsIOBalance(change: cloudwatch.MetricChange = {}) {
        return metric("EBSIOBalance%", { unit: "Percent", ...change });
    }

    /**
     * Available only for the smaller instance sizes. Provides information about the percentage of
     * throughput credits remaining in the burst bucket. This metric is available for basic
     * monitoring only.
     *
     * Unit: Percent
     */
    export function ebsByteBalance(change: cloudwatch.MetricChange = {}) {
        return metric("EBSByteBalance%", { unit: "Percent", ...change });
    }
}
