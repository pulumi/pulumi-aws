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
    export type DynamodbMetricName =
        "ConditionalCheckFailedRequests" | "ConsumedReadCapacityUnits" | "ConsumedWriteCapacityUnits" |
        "OnlineIndexConsumedWriteCapacity" | "OnlineIndexPercentageProgress" | "OnlineIndexThrottleEvents" |
        "PendingReplicationCount" | "ProvisionedReadCapacityUnits" | "ProvisionedWriteCapacityUnits" |
        "ReadThrottleEvents" | "ReplicationLatency" | "ReturnedBytes" |
        "ReturnedItemCount" | "ReturnedRecordsCount" | "SuccessfulRequestLatency" |
        "SystemErrors" | "TimeToLiveDeletedItemCount" | "ThrottledRequests" |
        "UserErrors" | "WriteThrottleEvents";

    /**
     * Creates an AWS/DynamoDB metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html for list
     * of all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * The metrics for DynamoDB are qualified by the values for the account, table name, global
     * secondary index name, or operation. You can use the CloudWatch console to retrieve DynamoDB data
     * along any of the dimensions in the table below.
     *
     * 1. "GlobalSecondaryIndexName": This dimension limits the data to a global secondary index on a
     *    table. If you specify GlobalSecondaryIndexName, you must also specify TableName
     * 2. "Operation": This dimension limits the data to one of the following DynamoDB operations: *
     *        PutItem * DeleteItem * UpdateItem * GetItem * BatchGetItem * Scan * Query * BatchWriteItem
     *        In addition, you can limit the data to the following Amazon DynamoDB Streams operation: *
     *        GetRecords
     * 3. "ReceivingRegion": This dimension limits the data to a particular AWS region. It is used with
     *    metrics originating from replica tables within a DynamoDB global table.
     * 4. "StreamLabel": This dimension limits the data to a specific stream label. It is used with
     *    metrics originating from Amazon DynamoDB Streams GetRecords operations.
     * 5. "TableName": This dimension limits the data to a specific table. This value can be any table
     *    name in the current region and the current AWS account.
     */
    export function metric(metricName: DynamodbMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/DynamoDB",
            name: metricName,
            ...change,
        });
    }

    /**
     * The number of failed attempts to perform conditional writes. The PutItem, UpdateItem, and
     * DeleteItem operations let you provide a logical condition that must evaluate to true before
     * the operation can proceed. If this condition evaluates to false,
     * ConditionalCheckFailedRequests is incremented by one.
     *
     * Note: A failed conditional write will result in an HTTP 400 error (Bad Request). These events
     * are reflected in the ConditionalCheckFailedRequests metric, but not in the UserErrors metric.
     *
     * Units: Count
     * Dimensions: TableName
     * Valid Statistics: Minimum, Maximum, Average, SampleCount, Sum
     */
    export function conditionalCheckFailedRequests(change: cloudwatch.MetricChange = {}) {
        return metric("ConditionalCheckFailedRequests", { unit: "Count", ...change });
    }

    /**
     * The number of read capacity units consumed over the specified time period, so you can track
     * how much of your provisioned throughput is used. You can retrieve the total consumed read
     * capacity for a table and all of its global secondary indexes, or for a particular global
     * secondary index. For more information, see Provisioned Throughput in Amazon DynamoDB.
     *
     * Note: Use the Sum statistic to calculate the consumed throughput. For example, get the Sum
     * value over a span of one minute, and divide it by the number of seconds in a minute (60) to
     * calculate the average ConsumedReadCapacityUnits per second (recognizing that this average
     * will not highlight any large but brief spikes in read activity that occurred during that
     * minute). You can compare the calculated value to the provisioned throughput value you provide
     * DynamoDB.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum – Minimum number of read capacity units consumed by any individual request to the
     *   table or index.
     * * Maximum – Maximum number of read capacity units consumed by any individual request to the
     *   table or index.
     * * Average – Average per-request read capacity consumed.
     * * Sum – Total read capacity units consumed. This is the most useful statistic for the
     *   ConsumedReadCapacityUnits metric.
     * * SampleCount – Number of requests to DynamoDB that consumed read capacity.
     */
    export function consumedReadCapacityUnits(change: cloudwatch.MetricChange = {}) {
        return metric("ConsumedReadCapacityUnits", { unit: "Count", ...change });
    }

    /**
     * The number of write capacity units consumed over the specified time period, so you can track
     * how much of your provisioned throughput is used. You can retrieve the total consumed write
     * capacity for a table and all of its global secondary indexes, or for a particular global
     * secondary index. For more information, see Provisioned Throughput in Amazon DynamoDB.
     *
     * Note: Use the Sum statistic to calculate the consumed throughput. For example, get the Sum
     * value over a span of one minute, and divide it by the number of seconds in a minute (60) to
     * calculate the average ConsumedWriteCapacityUnits per second (recognizing that this average
     * will not highlight any large but brief spikes in write activity that occurred during that
     * minute). You can compare the calculated value to the provisioned throughput value you provide
     * DynamoDB.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     *
     * * Minimum – Minimum number of write capacity units consumed by any individual request to the
     *   table or index.
     * * Maximum – Maximum number of write capacity units consumed by any individual request to the
     *   table or index.
     * * Average – Average per-request write capacity consumed.
     * * Sum – Total write capacity units consumed. This is the most useful statistic for the
     *   ConsumedWriteCapacityUnits metric.
     * * SampleCount – Number of requests to DynamoDB that consumed write capacity.
     */
    export function consumedWriteCapacityUnits(change: cloudwatch.MetricChange = {}) {
        return metric("ConsumedWriteCapacityUnits", { unit: "Count", ...change });
    }

    /**
     * The number of write capacity units consumed when adding a new global secondary index to a
     * table. If the write capacity of the index is too low, incoming write activity during the
     * backfill phase might be throttled; this can increase the time it takes to create the index.
     * You should monitor this statistic while the index is being built to determine whether the
     * write capacity of the index is underprovisioned.
     *
     * You can adjust the write capacity of the index using the UpdateTable operation, even while
     * the index is still being built.
     *
     * Note that the ConsumedWriteCapacityUnits metric for the index does not include the write
     * throughput consumed during index creation.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function onlineIndexConsumedWriteCapacity(change: cloudwatch.MetricChange = {}) {
        return metric("OnlineIndexConsumedWriteCapacity", { unit: "Count", ...change });
    }

    /**
     * The percentage of completion when a new global secondary index is being added to a table.
     * DynamoDB must first allocate resources for the new index, and then backfill attributes from the
     * table into the index. For large tables, this process might take a long time. You should monitor
     * this statistic to view the relative progress as DynamoDB builds the index.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function onlineIndexPercentageProgress(change: cloudwatch.MetricChange = {}) {
        return metric("OnlineIndexPercentageProgress", { unit: "Count", ...change });
    }

    /**
     * The number of write throttle events that occur when adding a new global secondary index to a
     * table. These events indicate that the index creation will take longer to complete, because
     * incoming write activity is exceeding the provisioned write throughput of the index.
     *
     * You can adjust the write capacity of the index using the UpdateTable operation, even while the
     * index is still being built.
     *
     * Note that the WriteThrotttleEvents metric for the index does not include any throttle events that
     * occur during index creation.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function onlineIndexThrottleEvents(change: cloudwatch.MetricChange = {}) {
        return metric("OnlineIndexThrottleEvents", { unit: "Count", ...change });
    }

    /**
     * (This metric is for DynamoDB global tables.) The number of item updates that are written to
     * one replica table, but that have not yet been written to another replica in the global table.
     *
     * Units: Count
     *
     * Dimensions: TableName, ReceivingRegion
     *
     * Valid Statistics:
     * * Average
     * * Sample Count
     * * Sum
     */
    export function pendingReplicationCount(change: cloudwatch.MetricChange = {}) {
        return metric("PendingReplicationCount", { unit: "Count", ...change });
    }

    /**
     * The number of provisioned read capacity units for a table or a global secondary index. The
     * TableName dimension returns the ProvisionedReadCapacityUnits for the table, but not for any
     * global secondary indexes. To view ProvisionedReadCapacityUnits for a global secondary index,
     * you must specify both TableName and GlobalSecondaryIndex.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum – Lowest setting for provisioned read capacity. If you use UpdateTable to increase
     *   read capacity, this metric shows the lowest value of provisioned ReadCapacityUnits during
     *   this time period.
     * * Maximum – Highest setting for provisioned read capacity. If you use UpdateTable to decrease
     *   read capacity, this metric shows the highest value of provisioned ReadCapacityUnits during
     *   this time period.
     * * Average – Average provisioned read capacity. The ProvisionedReadCapacityUnits metric is
     *   published at five-minute intervals. Therefore, if you rapidly adjust the provisioned read
     *   capacity units, this statistic might not reflect the true average.
     */
    export function provisionedReadCapacityUnits(change: cloudwatch.MetricChange = {}) {
        return metric("ProvisionedReadCapacityUnits", { unit: "Count", ...change });
    }

    /**
     * The number of provisioned write capacity units for a table or a global secondary index
     *
     * The TableName dimension returns the ProvisionedWriteCapacityUnits for the table, but not for
     * any global secondary indexes. To view ProvisionedWriteCapacityUnits for a global secondary
     * index, you must specify both TableName and GlobalSecondaryIndex.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Minimum – Lowest setting for provisioned write capacity. If you use UpdateTable to increase
     *   write capacity, this metric shows the lowest value of provisioned WriteCapacityUnits during
     *   this time period.
     * * Maximum – Highest setting for provisioned write capacity. If you use UpdateTable to
     *   decrease write capacity, this metric shows the highest value of provisioned
     *   WriteCapacityUnits during this time period.
     * * Average – Average provisioned write capacity. The ProvisionedWriteCapacityUnits metric is
     *   published at five-minute intervals. Therefore, if you rapidly adjust the provisioned write
     *   capacity units, this statistic might not reflect the true average.
     */
    export function provisionedWriteCapacityUnits(change: cloudwatch.MetricChange = {}) {
        return metric("ProvisionedWriteCapacityUnits", { unit: "Count", ...change });
    }

    /**
     * Requests to DynamoDB that exceed the provisioned read capacity units for a table or a global
     * secondary index.
     *
     * A single request can result in multiple events. For example, a BatchGetItem that reads 10
     * items is processed as ten GetItem events. For each event, ReadThrottleEvents is incremented
     * by one if that event is throttled. The ThrottledRequests metric for the entire BatchGetItem
     * is not incremented unless all ten of the GetItem events are throttled.
     *
     * The TableName dimension returns the ReadThrottleEvents for the table, but not for any global
     * secondary indexes. To view ReadThrottleEvents for a global secondary index, you must specify
     * both TableName and GlobalSecondaryIndex.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * SampleCount
     * * Sum
     */
    export function readThrottleEvents(change: cloudwatch.MetricChange = {}) {
        return metric("ReadThrottleEvents", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * (This metric is for DynamoDB global tables.) The elapsed time between an updated item
     * appearing in the DynamoDB stream for one replica table, and that item appearing in another
     * replica in the global table.
     *
     * Units: Milliseconds
     *
     * Dimensions: TableName, ReceivingRegion
     *
     * Valid Statistics:
     * * Average
     * * Minimum
     * * Maximum
     */
    export function replicationLatency(change: cloudwatch.MetricChange = {}) {
        return metric("ReplicationLatency", { unit: "Milliseconds", ...change });
    }

    /**
     * The number of bytes returned by GetRecords operations (Amazon DynamoDB Streams) during the
     * specified time period.
     *
     * Units: Bytes
     *
     * Dimensions: Operation, StreamLabel, TableName
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function returnedBytes(change: cloudwatch.MetricChange = {}) {
        return metric("ReturnedBytes", { unit: "Bytes", ...change });
    }

    /**
     * The number of items returned by Query or Scan operations during the specified time period.
     *
     * Note that the number of items returned is not necessarily the same as the number of items
     * that were evaluated. For example, suppose you requested a Scan on a table that had 100 items,
     * but specified a FilterExpression that narrowed the results so that only 15 items were
     * returned. In this case, the response from Scan would contain a ScanCount of 100 and a Count
     * of 15 returned items.
     *
     * Units: Count
     *
     * Dimensions: TableName, Operation
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function returnedItemCount(change: cloudwatch.MetricChange = {}) {
        return metric("ReturnedItemCount", { unit: "Count", ...change });
    }

    /**
     * The number of stream records returned by GetRecords operations (Amazon DynamoDB Streams)
     * during the specified time period.
     *
     * Units: Count
     *
     * Dimensions: Operation, StreamLabel, TableName
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     * * Sum
     */
    export function returnedRecordsCount(change: cloudwatch.MetricChange = {}) {
        return metric("ReturnedRecordsCount", { unit: "Count", ...change });
    }

    /**
     * Successful requests to DynamoDB or Amazon DynamoDB Streams during the specified time period.
     * SuccessfulRequestLatency can provide two different kinds of information:
     *
     *  The elapsed time for successful requests (Minimum, Maximum, Sum, or Average). The number of
     *  successful requests (SampleCount).
     *
     * SuccessfulRequestLatency reflects activity only within DynamoDB or Amazon DynamoDB Streams,
     * and does not take into account network latency or client-side activity.
     *
     * Units: Milliseconds
     *
     * Dimensions: TableName, Operation
     *
     * Valid Statistics:
     * * Minimum
     * * Maximum
     * * Average
     * * SampleCount
     */
    export function successfulRequestLatency(change: cloudwatch.MetricChange = {}) {
        return metric("SuccessfulRequestLatency", { unit: "Milliseconds", ...change });
    }

    /**
     * Requests to DynamoDB or Amazon DynamoDB Streams that generate an HTTP 500 status code during
     * the specified time period. An HTTP 500 usually indicates an internal service error.
     *
     * Units: Count
     *
     * Dimensions: All dimensions
     *
     * Valid Statistics:
     * * Sum
     * * SampleCount
     */
    export function systemErrors(change: cloudwatch.MetricChange = {}) {
        return metric("SystemErrors", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * The number of items deleted by Time To Live (TTL) during the specified time period. This
     * metric helps you monitor the rate of TTL deletions on your table.
     *
     * Units: Count
     *
     * Dimensions: TableName
     *
     * Valid Statistics:
     * * Sum
     */
    export function timeToLiveDeletedItemCount(change: cloudwatch.MetricChange = {}) {
        return metric("TimeToLiveDeletedItemCount", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * Requests to DynamoDB that exceed the provisioned throughput limits on a resource (such as a
     * table or an index).
     *
     * ThrottledRequests is incremented by one if any event within a request exceeds a provisioned
     * throughput limit. For example, if you update an item in a table with global secondary
     * indexes, there are multiple events—a write to the table, and a write to each index. If one or
     * more of these events are throttled, then ThrottledRequests is incremented by one.
     *
     * Note: In a batch request (BatchGetItem or BatchWriteItem), ThrottledRequests is only
     * incremented if every request in the batch is throttled.
     *
     * If any individual request within the batch is throttled, one of the following metrics is
     * incremented:
     *
     *  * ReadThrottleEvents – For a throttled GetItem event within BatchGetItem.
     *  * WriteThrottleEvents – For a throttled PutItem or DeleteItem event within BatchWriteItem.
     *
     * To gain insight into which event is throttling a request, compare ThrottledRequests with the
     * ReadThrottleEvents and WriteThrottleEvents for the table and its indexes.
     *
     * Note: A throttled request will result in an HTTP 400 status code. All such events are
     * reflected in the ThrottledRequests metric, but not in the UserErrors metric.
     *
     * Units: Count
     *
     * Dimensions: TableName, Operation
     *
     * Valid Statistics:
     * * Sum
     * * SampleCount
     */
    export function throttledRequests(change: cloudwatch.MetricChange = {}) {
        return metric("ThrottledRequests", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * Requests to DynamoDB or Amazon DynamoDB Streams that generate an HTTP 400 status code during
     * the specified time period. An HTTP 400 usually indicates a client-side error such as an
     * invalid combination of parameters, attempting to update a nonexistent table, or an incorrect
     * request signature.
     *
     * All such events are reflected in the UserErrors metric, except for the following:
     *
     *  * ProvisionedThroughputExceededException – See the ThrottledRequests metric in this section.
     *  * ConditionalCheckFailedException – See the ConditionalCheckFailedRequests metric in this
     *    section.
     *
     * UserErrors represents the aggregate of HTTP 400 errors for DynamoDB or Amazon DynamoDB
     * Streams requests for the current region and the current AWS account.
     *
     * Units: Count
     *
     * Valid Statistics:
     * * Sum
     * * SampleCount
     */
    export function userErrors(change: cloudwatch.MetricChange = {}) {
        return metric("UserErrors", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * Requests to DynamoDB that exceed the provisioned write capacity units for a table or a global
     * secondary index.
     *
     * A single request can result in multiple events. For example, a PutItem request on a table
     * with three global secondary indexes would result in four events—the table write, and each of
     * the three index writes. For each event, the WriteThrottleEvents metric is incremented by one
     * if that event is throttled. For single PutItem requests, if any of the events are throttled,
     * ThrottledRequests is also incremented by one. For BatchWriteItem, the ThrottledRequests
     * metric for the entire BatchWriteItem is not incremented unless all of the individual PutItem
     * or DeleteItem events are throttled.
     *
     * The TableName dimension returns the WriteThrottleEvents for the table, but not for any global
     * secondary indexes. To view WriteThrottleEvents for a global secondary index, you must specify
     * both TableName and GlobalSecondaryIndex.
     *
     * Units: Count
     *
     * Dimensions: TableName, GlobalSecondaryIndexName
     *
     * Valid Statistics:
     * * Sum
     * * SampleCount
     */
    export function writeThrottleEvents(change: cloudwatch.MetricChange = {}) {
        return metric("WriteThrottleEvents", { statistic: "Sum", unit: "Count", ...change });
    }
}
