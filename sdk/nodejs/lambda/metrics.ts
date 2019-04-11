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
    export type LambdaMetricName =
        "Invocations" | "Errors" | "DeadLetterErrors" | "Duration" | "Throttles" | "IteratorAge" |
        "ConcurrentExecutions" | "UnreservedConcurrentExecutions";

    /**
     * Creates an AWS/Lambda metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/lambda/latest/dg/monitoring-functions-metrics.html for list of
     * all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * You can use the following dimensions to refine the metrics returned for your Lambda
     * functions:
     *
     * 1. "FunctionName". Filters the metric data by Lambda function.
     * 2. "Resource". Filters the metric data by Lambda function resource, such as function version
     *    or alias.
     * 3. "ExecutedVersion". Filters the metric data by Lambda function versions. This only applies
     *    to alias invocations.
     */
    export function metric(metricName: LambdaMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/Lambda",
            name: metricName,
            ...change,
        });
    }

    /**
     * Measures the number of times a function is invoked in response to an event or invocation API
     * call. This replaces the deprecated RequestCount metric. This includes successful and failed
     * invocations, but does not include throttled attempts. This equals the billed requests for the
     * function. Note that AWS Lambda only sends these metrics to CloudWatch if they have a nonzero
     * value.
     */
    export function invocations(change: cloudwatch.MetricChange) {
        return metric("Invocations", { unit: "Count", ...change });
    }

    /**
     * Measures the number of invocations that failed due to errors in the function (response code
     * 4XX). This replaces the deprecated ErrorCount metric. Failed invocations may trigger a retry
     * attempt that succeeds. This includes:
     *
     * * Handled exceptions (for example, context.fail(error))
     * * Unhandled exceptions causing the code to exit
     * * Out of memory exceptions
     * * Timeouts
     * * Permissions errors
     *
     * This does not include invocations that fail due to invocation rates exceeding default
     * concurrent limits (error code 429) or failures due to internal service errors (error code
     * 500).
     */
    export function errors(change?: cloudwatch.MetricChange) {
        return metric("Errors", { unit: "Count", ...change });
    }

    /**
     * Incremented when Lambda is unable to write the failed event payload to your configured Dead
     * Letter Queues. This could be due to the following:
     *
     * * Permissions errors
     * * Throttles from downstream services
     * * Misconfigured resources
     * * Timeouts
     */
    export function deadLetterErrors(change?: cloudwatch.MetricChange) {
        return metric("DeadLetterErrors", { unit: "Count", ...change });
    }

    /**
     * Measures the elapsed wall clock time from when the function code starts executing as a result
     * of an invocation to when it stops executing. The maximum data point value possible is the
     * function timeout configuration. The billed duration will be rounded up to the nearest 100
     * millisecond. Note that AWS Lambda only sends these metrics to CloudWatch if they have a
     * nonzero value.
     */
    export function duration(change?: cloudwatch.MetricChange) {
        return metric("Duration", { unit: "Milliseconds", ...change });
    }

    /**
     * Measures the number of Lambda function invocation attempts that were throttled due to
     * invocation rates exceeding the customer’s concurrent limits (error code 429). Failed
     * invocations may trigger a retry attempt that succeeds.
     */
    export function throttles(change?: cloudwatch.MetricChange) {
        return metric("Throttles", { unit: "Count", ...change });
    }

    /**
     * Emitted for stream-based invocations only (functions triggered by an Amazon DynamoDB stream
     * or Kinesis stream). Measures the age of the last record for each batch of records processed.
     * Age is the difference between the time Lambda received the batch, and the time the last
     * record in the batch was written to the stream.
     */
    export function iteratorAge(change?: cloudwatch.MetricChange) {
        return metric("IteratorAge", { unit: "Milliseconds", ...change });
    }

    /**
     * Emitted as an aggregate metric for all functions in the account, and for functions that have
     * a custom concurrency limit specified. Not applicable for versions or aliases. Measures the
     * sum of concurrent executions for a given function at a given point in time. Must be viewed as
     * an average metric if aggregated across a time period.
     */
    export function concurrentExecutions(change?: cloudwatch.MetricChange) {
        return metric("ConcurrentExecutions", { unit: "Count", ...change });
    }

    /**
     * Emitted as an aggregate metric for all functions in the account only. Not applicable for
     * functions, versions, or aliases. Represents the sum of the concurrency of the functions that
     * do not have a custom concurrency limit specified. Must be viewed as an average metric if
     * aggregated across a time period.
     */
    export function unreservedConcurrentExecutions(change?: cloudwatch.MetricChange) {
        return metric("UnreservedConcurrentExecutions", { unit: "Count", ...change });
    }
}
