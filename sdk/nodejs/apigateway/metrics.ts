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
import { RestApi } from "./restApi";

export module metrics {
    export type ApigatewayMetricName =
        "4XXError" | "5XXError" | "CacheHitCount" | "CacheMissCount" |
        "Count" | "IntegrationLatency" | "Latency";

    /**
     * Creates an AWS/ApiGateway metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-metrics-and-dimensions.html
     * for list of all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * You can use the dimensions in the following table to filter API Gateway metrics.
     *
     * 1. "ApiName": Filters API Gateway metrics for an API of the specified API name.
     * 2. "ApiName, Method, Resource, Stage": Filters API Gateway metrics for an API method of the
     *    specified API, stage, resource, and method.
     *
     *    API Gateway will not send such metrics unless you have explicitly enabled detailed CloudWatch
     *    metrics. You can do this in the console by selecting Enable CloudWatch Metrics under a stage
     *    Settings tab. Alternatively, you can call the stage:update action of the API Gateway REST API
     *    to update the metricsEnabled property to true.
     *
     *    Enabling such metrics will incur additional charges to your account. For pricing information,
     *    see Amazon CloudWatch Pricing.
     * 3. "ApiName, Stage": Filters API Gateway metrics for an API stage of the specified API and stage.
     */
    export function metric(metricName: ApigatewayMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/ApiGateway",
            name: metricName,
            ...change,
        });
    }

    /**
     * The number of client-side errors captured in a specified period.
     *
     * The Sum statistic represents this metric, namely, the total count of the 4XXError errors in the
     * given period. The Average statistic represents the 4XXError error rate, namely, the total count
     * of the 4XXError errors divided by the total number of requests during the period. The denominator
     * corresponds to the Count metric (below).
     *
     * Unit: Count
     */
    export function error4XX(change: cloudwatch.MetricChange = {}) {
        return metric("4XXError", { unit: "Count", ...change });
    }

    /**
     * The number of server-side errors captured in a given period.
     *
     * The Sum statistic represents this metric, namely, the total count of the 5XXError errors in the
     * given period. The Average statistic represents the 5XXError error rate, namely, the total count
     * of the 5XXError errors divided by the total number of requests during the period. The denominator
     * corresponds to the Count metric (below).
     *
     * Unit: Count
     */
    export function error5XX(change: cloudwatch.MetricChange = {}) {
        return metric("5XXError", { unit: "Count", ...change });
    }

    /**
     * The number of requests served from the API cache in a given period.
     *
     * The Sum statistic represents this metric, namely, the total count of the cache hits in the
     * specified period. The Average statistic represents the cache hit rate, namely, the total count of
     * the cache hits divided by the total number of requests during the period. The denominator
     * corresponds to the Count metric (below).
     */
    export function cacheHitCount(change: cloudwatch.MetricChange = {}) {
        return metric("CacheHitCount", { unit: "Count", ...change });
    }

    /**
     * The number of requests served from the back end in a given period, when API caching is enabled.
     *
     * The Sum statistic represents this metric, namely, the total count of the cache misses in the
     * specified period. The Average statistic represents the cache miss rate, namely, the total count
     * of the cache hits divided by the total number of requests during the period. The denominator
     * corresponds to the Count metric (below).
     *
     * Unit: Count
     */
    export function cacheMissCount(change: cloudwatch.MetricChange = {}) {
        return metric("CacheMissCount", { unit: "Count", ...change });
    }

    /**
     * The total number API requests in a given period.
     *
     * The SampleCount statistic represents this metric.
     *
     * Unit: Count
     */
    export function count(change: cloudwatch.MetricChange = {}) {
        return metric("Count", { unit: "Count", ...change });
    }

    /**
     * The time between when API Gateway relays a request to the back end and when it receives a
     * response from the back end.
     *
     * Unit: Milliseconds
     */
    export function integrationLatency(change: cloudwatch.MetricChange = {}) {
        return metric("IntegrationLatency", { unit: "Milliseconds", ...change });
    }

    /**
     * The time between when API Gateway receives a request from a client and when it returns a response
     * to the client. The latency includes the integration latency and other API Gateway overhead.
     *
     * Unit: Milliseconds
     */
    export function latency(change: cloudwatch.MetricChange = {}) {
        return metric("Latency", { unit: "Milliseconds", ...change });
    }
}

declare module "./restApi" {
    interface RestApi {
        /**
         * Direct access to create metrics for this specific [apigateway.RestApi].
         */
        metrics: {
            /**
             * The number of client-side errors captured in a specified period.
             *
             * The Sum statistic represents this metric, namely, the total count of the 4XXError errors in the
             * given period. The Average statistic represents the 4XXError error rate, namely, the total count
             * of the 4XXError errors divided by the total number of requests during the period. The denominator
             * corresponds to the Count metric (below).
             *
             * Unit: Count
             */
            error4XX(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of server-side errors captured in a given period.
             *
             * The Sum statistic represents this metric, namely, the total count of the 5XXError errors in the
             * given period. The Average statistic represents the 5XXError error rate, namely, the total count
             * of the 5XXError errors divided by the total number of requests during the period. The denominator
             * corresponds to the Count metric (below).
             *
             * Unit: Count
             */
            error5XX(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of requests served from the API cache in a given period.
             *
             * The Sum statistic represents this metric, namely, the total count of the cache hits in the
             * specified period. The Average statistic represents the cache hit rate, namely, the total count of
             * the cache hits divided by the total number of requests during the period. The denominator
             * corresponds to the Count metric (below).
             */
            cacheHitCount(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of requests served from the back end in a given period, when API caching is enabled.
             *
             * The Sum statistic represents this metric, namely, the total count of the cache misses in the
             * specified period. The Average statistic represents the cache miss rate, namely, the total count
             * of the cache hits divided by the total number of requests during the period. The denominator
             * corresponds to the Count metric (below).
             *
             * Unit: Count
             */
            cacheMissCount(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The total number API requests in a given period.
             *
             * The SampleCount statistic represents this metric.
             *
             * Unit: Count
             */
            count(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The time between when API Gateway relays a request to the back end and when it receives a
             * response from the back end.
             *
             * Unit: Milliseconds
             */
            integrationLatency(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The time between when API Gateway receives a request from a client and when it returns a response
             * to the client. The latency includes the integration latency and other API Gateway overhead.
             *
             * Unit: Milliseconds
             */
            latency(change?: cloudwatch.MetricChange): cloudwatch.Metric;
        }
    }
}

// All instance metrics just make a normal AWS/ApiGateway metric, except with the ApiName
// dimension set to this RestApi's name.

function getMetric(
    api: RestApi, change: cloudwatch.MetricChange,
    moduleFunction: (change: cloudwatch.MetricChange) => cloudwatch.Metric) {

    return moduleFunction({ dimensions: { ApiName: api.name } }).with(change);
}

Object.defineProperty(RestApi.prototype, "metrics", {
    get: function (this: RestApi) {
        const _this = this;
        return {
            error4XX: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.error4XX),
            error5XX: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.error5XX),
            cacheHitCount: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.cacheHitCount),
            cacheMissCount: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.cacheMissCount),
            count: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.count),
            integrationLatency: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.integrationLatency),
            latency: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.latency),
        }
    }
});
