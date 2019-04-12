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
    export type CloudfrontMetricName =
        "Requests" | "BytesDownloaded" | "BytesUploaded" | "TotalErrorRate" |
        "4xxErrorRate" | "5xxErrorRate";

    /**
     * Creates an AWS/CloudFront metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/monitoring-using-cloudwatch.html
     * for list of all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * CloudFront metrics use the CloudFront namespace and provide metrics for two dimensions:
     *
     * 1. "DistributionId": The CloudFront ID of the distribution for which you want to display metrics.
     * 2. "Region": The region for which you want to display metrics. This value must be Global. The
     *    Region dimension is different from the region in which CloudFront metrics are stored, which is
     *    US East (N. Virginia).
     */
    export function metric(metricName: CloudfrontMetricName, change: cloudwatch.MetricChange = {} = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/ApiGateway",
            name: metricName,
            ...change,
        });
    }

    /**
     * The number of requests for all HTTP methods and for both HTTP and HTTPS requests.
     *
     * Valid Statistics: Sum
     * Units: None
     */
    export function requests(change: cloudwatch.MetricChange = {}) {
        return metric("Requests", { statistic: "Sum", unit: "None", ...change });
    }

    /**
     * The number of bytes downloaded by viewers for GET, HEAD, and OPTIONS requests.
     *
     * Valid Statistics: Sum
     * Units: None
     */
    export function bytesDownloaded(change: cloudwatch.MetricChange = {}) {
        return metric("BytesDownloaded", { statistic: "Sum", unit: "None", ...change });
    }

    /**
     * The number of bytes uploaded to your origin with CloudFront using POST and PUT requests.
     *
     * Valid Statistics: Sum
     * Units: None
     */
    export function bytesUploaded(change: cloudwatch.MetricChange = {}) {
        return metric("BytesUploaded", { statistic: "Sum", unit: "None", ...change });
    }

    /**
     * The percentage of all requests for which the HTTP status code is 4xx or 5xx.
     *
     * Valid Statistics: Average
     * Units: Percent
     */
    export function totalErrorRate(change: cloudwatch.MetricChange = {}) {
        return metric("TotalErrorRate", { statistic: "Average", unit: "Percent", ...change });
    }

    /**
     * The percentage of all requests for which the HTTP status code is 4xx.
     *
     * Valid Statistics: Average
     * Units: Percent
     */
    export function errorRate4xx(change: cloudwatch.MetricChange = {}) {
        return metric("4xxErrorRate", { statistic: "Average", unit: "Percent", ...change });
    }

    /**
     * The percentage of all requests for which the HTTP status code is 5xx.
     *
     * Valid Statistics: Average
     * Units: Percent
     */
    export function errorRate5xx(change: cloudwatch.MetricChange = {}) {
        return metric("5xxErrorRate", { statistic: "Average", unit: "Percent", ...change });
    }
}
