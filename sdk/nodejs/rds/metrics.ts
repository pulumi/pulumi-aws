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
    export type RdsMetricName =
        "BinLogDiskUsage" | "BurstBalance" | "CPUUtilization" | "CPUCreditUsage" | "CPUCreditBalance" |
        "DatabaseConnections" | "DiskQueueDepth" | "FailedSQLServerAgentJobsCount" |
        "FreeableMemory" | "FreeStorageSpace" | "MaximumUsedTransactionIDs" |
        "NetworkReceiveThroughput" | "NetworkTransmitThroughput" | "OldestReplicationSlotLag" |
        "ReadIOPS" | "ReadLatency" | "ReadThroughput" |
        "ReplicaLag" | "ReplicationSlotDiskUsage" | "SwapUsage" |
        "TransactionLogsDiskUsage" | "TransactionLogsGeneration" |
        "WriteIOPS" | "WriteLatency" | "WriteThroughput";

    /**
     * Creates an AWS/RDS metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/MonitoringOverview.html#monitoring-cloudwatch
     * for list of all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * You can monitor DB instances using Amazon CloudWatch, which collects and processes raw data from
     * Amazon RDS into readable, near real-time metrics. These statistics are recorded for a period of
     * two weeks, so that you can access historical information and gain a better perspective on how
     * your web application or service is performing. By default, Amazon RDS metric data is
     * automatically sent to CloudWatch in 1-minute periods.
     *
     * Amazon RDS metrics data can be filtered by using any of the following dimensions:
     * 1. "DBInstanceIdentifier": This dimension filters the data you request for a specific database
     *    instance.
     * 2. "DBClusterIdentifier": This dimension filters the data you request for a specific Amazon
     *    Aurora DB cluster.
     * 3. "DBClusterIdentifier, Role": This dimension filters the data you request for a specific Aurora
     *    DB cluster, aggregating the metric by instance role (WRITER/READER). For example, you can
     *    aggregate metrics for all READER instances that belong to a cluster.
     * 4. "DatabaseClass": This dimension filters the data you request for all instances in a database
     *    class. For example, you can aggregate metrics for all instances that belong to the database
     *    class db.m1.small
     * 5. "EngineName": This dimension filters the data you request for the identified engine name only.
     *    For example, you can aggregate metrics for all instances that have the engine name mysql.
     * 6. "SourceRegion": This dimension filters the data you request for the specified region only. For
     *    example, you can aggregate metrics for all instances in the region us-east-1.
     */
    export function metric(metricName: RdsMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/RDS",
            name: metricName,
            ...change,
        });
    }

    /**
     * The amount of disk space occupied by binary logs on the master. Applies to MySQL read replicas.
     */
    export function binLogDiskUsage(change: cloudwatch.MetricChange = {}) {
        return metric("BinLogDiskUsage", { unit: "Bytes", ...change });
    }

    /**
     * The percent of General Purpose SSD (gp2) burst-bucket I/O credits available.
     */
    export function burstBalance(change: cloudwatch.MetricChange = {}) {
        return metric("BurstBalance", { unit: "Percent", ...change });
    }

    /**
     * The percentage of CPU utilization.
     */
    export function cpuUtilization(change: cloudwatch.MetricChange = {}) {
        return metric("CPUUtilization", { unit: "Percent", ...change });
    }

    /**
     * [T2 instances] The number of CPU credits spent by the instance for CPU utilization. One CPU
     * credit equals one vCPU running at 100% utilization for one minute or an equivalent
     * combination of vCPUs, utilization, and time (for example, one vCPU running at 50% utilization
     * for two minutes or two vCPUs running at 25% utilization for two minutes).
     *
     * CPU credit metrics are available at a five-minute frequency only. If you specify a period
     * greater than five minutes, use the Sum statistic instead of the Average statistic.
     */
    export function cpuCreditUsage(change: cloudwatch.MetricChange = {}) {
        return metric("CPUCreditUsage", change);
    }

    /**
     * [T2 instances] The number of earned CPU credits that an instance has accrued since it was
     * launched or started. For T2 Standard, the CPUCreditBalance also includes the number of launch
     * credits that have been accrued.
     *
     * Credits are accrued in the credit balance after they are earned, and removed from the credit
     * balance when they are spent. The credit balance has a maximum limit, determined by the
     * instance size. Once the limit is reached, any new credits that are earned are discarded. For
     * T2 Standard, launch credits do not count towards the limit.
     *
     * The credits in the CPUCreditBalance are available for the instance to spend to burst beyond
     * its baseline CPU utilization.
     *
     * When an instance is running, credits in the CPUCreditBalance do not expire. When the instance
     * stops, the CPUCreditBalance does not persist, and all accrued credits are lost.
     *
     * CPU credit metrics are available at a five-minute frequency only.
     */
    export function cpuCreditBalance(change: cloudwatch.MetricChange = {}) {
        return metric("CPUCreditBalance", change);
    }

    /**
     * The number of database connections in use.
     */
    export function databaseConnections(change: cloudwatch.MetricChange = {}) {
        return metric("DatabaseConnections", { unit: "Count", ...change });
    }

    /**
     * The number of outstanding IOs (read/write requests) waiting to access the disk.
     */
    export function diskQueueDepth(change: cloudwatch.MetricChange = {}) {
        return metric("DiskQueueDepth", { unit: "Count", ...change });
    }

    /**
     * The number of failed SQL Server Agent jobs during the last minute.
     */
    export function failedSQLServerAgentJobsCount(change: cloudwatch.MetricChange = {}) {
        return metric("FailedSQLServerAgentJobsCount", { unit: "Count", ...change });
    }

    /**
     * The amount of available random access memory.
     */
    export function freeableMemory(change: cloudwatch.MetricChange = {}) {
        return metric("FreeableMemory", { unit: "Bytes", ...change });
    }

    /**
     * The amount of available storage space.
     */
    export function freeStorageSpace(change: cloudwatch.MetricChange = {}) {
        return metric("FreeStorageSpace", { unit: "Bytes", ...change });
    }

    /**
     * The maximum transaction ID that has been used. Applies to PostgreSQL.
     */
    export function maximumUsedTransactionIDs(change: cloudwatch.MetricChange = {}) {
        return metric("MaximumUsedTransactionIDs", { unit: "Count", ...change });
    }

    /**
     * The incoming (Receive) network traffic on the DB instance, including both customer database
     * traffic and Amazon RDS traffic used for monitoring and replication.
     */
    export function networkReceiveThroughput(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkReceiveThroughput", { unit: "Bytes/Second", ...change });
    }

    /**
     * The outgoing (Transmit) network traffic on the DB instance, including both customer database
     * traffic and Amazon RDS traffic used for monitoring and replication.
     */
    export function networkTransmitThroughput(change: cloudwatch.MetricChange = {}) {
        return metric("NetworkTransmitThroughput", { unit: "Bytes/Second", ...change });
    }

    /**
     * The lagging size of the replica lagging the most in terms of WAL data received. Applies to
     * PostgreSQL.
     */
    export function oldestReplicationSlotLag(change: cloudwatch.MetricChange = {}) {
        return metric("OldestReplicationSlotLag", { unit: "Megabytes", ...change });
    }

    /**
     * The average number of disk read I/O operations per second.
     */
    export function readIOPS(change: cloudwatch.MetricChange = {}) {
        return metric("ReadIOPS", { unit: "Count/Second", ...change });
    }

    /**
     * The average amount of time taken per disk I/O operation.
     */
    export function readLatency(change: cloudwatch.MetricChange = {}) {
        return metric("ReadLatency", { unit: "Seconds", ...change });
    }

    /**
     * The average number of bytes read from disk per second.
     */
    export function readThroughput(change: cloudwatch.MetricChange = {}) {
        return metric("ReadThroughput", { unit: "Bytes/Second", ...change });
    }

    /**
     * The amount of time a Read Replica DB instance lags behind the source DB instance. Applies to
     * MySQL, MariaDB, and PostgreSQL Read Replicas.
     */
    export function replicaLag(change: cloudwatch.MetricChange = {}) {
        return metric("ReplicaLag", { unit: "Seconds", ...change });
    }

    /**
     * The disk space used by replication slot files. Applies to PostgreSQL.
     */
    export function replicationSlotDiskUsage(change: cloudwatch.MetricChange = {}) {
        return metric("ReplicationSlotDiskUsage", { unit: "Megabytes", ...change });
    }

    /**
     * The amount of swap space used on the DB instance. This metric is not available for SQL
     * Server.
     */
    export function swapUsage(change: cloudwatch.MetricChange = {}) {
        return metric("SwapUsage", { unit: "Bytes", ...change });
    }

    /**
     * The disk space used by transaction logs. Applies to PostgreSQL.
     */
    export function transactionLogsDiskUsage(change: cloudwatch.MetricChange = {}) {
        return metric("TransactionLogsDiskUsage", { unit: "Megabytes", ...change });
    }

    /**
     * The size of transaction logs generated per second. Applies to PostgreSQL.
     */
    export function transactionLogsGeneration(change: cloudwatch.MetricChange = {}) {
        return metric("TransactionLogsGeneration", { unit: "Megabytes/Second", ...change });
    }

    /**
     * The average number of disk write I/O operations per second.
     */
    export function writeIOPS(change: cloudwatch.MetricChange = {}) {
        return metric("WriteIOPS", { unit: "Count/Second", ...change });
    }

    /**
     * The average amount of time taken per disk I/O operation.
     */
    export function writeLatency(change: cloudwatch.MetricChange = {}) {
        return metric("WriteLatency", { unit: "Seconds", ...change });
    }

    /**
     * The average number of bytes written to disk per second.
     */
    export function writeThroughput(change: cloudwatch.MetricChange = {}) {
        return metric("WriteThroughput", { unit: "Bytes/Second", ...change });
    }
}
