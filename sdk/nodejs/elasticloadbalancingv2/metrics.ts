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
    export module application {
        export type ApplicationMetricName =
            "ActiveConnectionCount" |
            "ClientTLSNegotiationErrorCount" |
            "ConsumedLCUs" |
            "HTTP_Fixed_Response_Count" |
            "HTTP_Redirect_Count" |
            "HTTP_Redirect_Url_Limit_Exceeded_Count" |
            "HTTPCode_ELB_3XX_Count" |
            "HTTPCode_ELB_4XX_Count" |
            "HTTPCode_ELB_5XX_Count" |
            "HTTPCode_ELB_500_Count" |
            "HTTPCode_ELB_502_Count" |
            "HTTPCode_ELB_503_Count" |
            "HTTPCode_ELB_504_Count" |
            "IPv6ProcessedBytes" |
            "IPv6RequestCount" |
            "NewConnectionCount" |
            "ProcessedBytes" |
            "RejectedConnectionCount" |
            "RequestCount" |
            "RuleEvaluations" |

            // Target group metrics
            "HealthyHostCount" |
            "HTTPCode_Target_2XX_Count" |
            "HTTPCode_Target_3XX_Count" |
            "HTTPCode_Target_4XX_Count" |
            "HTTPCode_Target_5XX_Count" |
            "NonStickyRequestCount" |
            "RequestCountPerTarget" |
            "TargetConnectionErrorCount" |
            "TargetResponseTime" |
            "TargetTLSNegotiationErrorCount" |
            "UnHealthyHostCount";

        /**
         * Creates an AWS/ApplicationELB metric with the requested [metricName]. See
         * https://docs.aws.amazon.com/elasticloadbalancing/latest/application/load-balancer-cloudwatch-metrics.html
         * for list of all metric-names.
         *
         * Elastic Load Balancing publishes data points to Amazon CloudWatch for your load balancers
         * and your targets. CloudWatch enables you to retrieve statistics about those data points
         * as an ordered set of time-series data, known as metrics. Think of a metric as a variable
         * to monitor, and the data points as the values of that variable over time. For example,
         * you can monitor the total number of healthy targets for a load balancer over a specified
         * time period. Each data point has an associated time stamp and an optional unit of
         * measurement.
         *
         * You can use metrics to verify that your system is performing as expected. For example,
         * you can create a CloudWatch alarm to monitor a specified metric and initiate an action
         * (such as sending a notification to an email address) if the metric goes outside what you
         * consider an acceptable range.
         *
         * Elastic Load Balancing reports metrics to CloudWatch only when requests are flowing
         * through the load balancer. If there are requests flowing through the load balancer,
         * Elastic Load Balancing measures and sends its metrics in 60-second intervals. If there
         * are no requests flowing through the load balancer or no data for a metric, the metric is
         * not reported.
         *
         * To filter the metrics for your Application Load Balancer, use the following dimensions.
         * 1. "AvailabilityZone": Filters the metric data by Availability Zone.
         * 2. "LoadBalancer": Filters the metric data by load balancer. Specify the load balancer
         *    using `LoadBalancer.arnSuffix`.
         * 3. "TargetGroup": Filters the metric data by target group. Specify the target group using
         *    `TargetGroup.arnSuffix`.
         */
        function metric(metricName: ApplicationMetricName, change: cloudwatch.MetricChange = {} = {}) {
            return new cloudwatch.Metric({
                namespace: "AWS/ApplicationELB",
                name: metricName,
                ...change,
            });
        }

        /**
         * The total number of concurrent TCP connections active from clients to the load balancer
         * and from the load balancer to targets. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions LoadBalancer
         */
        export function activeConnectionCount(change: cloudwatch.MetricChange = {}) {
            return metric("ActiveConnectionCount", { statistic: "Sum", ...change });
        }

        /**
         * The number of TLS connections initiated by the client that did not establish a session
         * with the load balancer. Possible causes include a mismatch of ciphers or protocols.
         * Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: AvailabilityZone, LoadBalancer
         */
        export function clientTLSNegotiationErrorCount(change: cloudwatch.MetricChange = {}) {
            return metric("ClientTLSNegotiationErrorCount", { statistic: "Sum",...change });
        }

        /**
         * The number of load balancer capacity units (LCU) used by your load balancer. You pay for
         * the number of LCUs that you use per hour. For more information, see Elastic Load
         * Balancing Pricing. Reporting criteria: Always reported
         *
         * Statistics: All
         *
         * Dimensions: LoadBalancer
         */
        export function consumedLCUs(change: cloudwatch.MetricChange = {}) {
            return metric("ConsumedLCUs", { ...change });
        }

        /**
         * The number of fixed-response actions that were successful. Reporting criteria: There is a
         * nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function httpFixedResponseCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTP_Fixed_Response_Count", { statistic: "Sum", ...change });
        }

        /**
         * The number of redirect actions that were successful. Reporting criteria: There is a
         * nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function httpRedirectCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTP_Redirect_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of redirect actions that couldn't be completed because the URL in the response
         * location header is larger than 8K. Reporting criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function httpRedirectUrlLimitExceededCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTP_Redirect_Url_Limit_Exceeded_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 3XX redirection codes that originate from the load balancer. Reporting
         * criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function httpCodeELB3XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_3XX_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 4XX client error codes that originate from the load balancer. Client
         * errors are generated when requests are malformed or incomplete. These requests have not
         * been received by the target. This count does not include any response codes generated by
         * the targets. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer
         */
        export function httpCodeELB4XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_4XX_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 5XX server error codes that originate from the load balancer. This
         * count does not include any response codes generated by the targets. Reporting criteria:
         * There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer
         */
        export function httpCodeELB5XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_5XX_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 500 error codes that originate from the load balancer.
         *
         * Reporting criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         */
        export function httpCodeELB500Count(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_500_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 502 error codes that originate from the load balancer. Reporting
         * criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         */
        export function httpCodeELB502Count(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_502_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 503 error codes that originate from the load balancer. Reporting
         * criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         */
        export function httpCodeELB503Count(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_503_Count", { statistic: "Sum",...change });
        }

        /**
         * The number of HTTP 504 error codes that originate from the load balancer. Reporting
         * criteria: There is a nonzero value
         *
         * Statistics: The only meaningful statistic is Sum.
         */
        export function httpCodeELB504Count(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_ELB_504_Count", { statistic: "Sum",...change });
        }

        /**
         * The total number of bytes processed by the load balancer over IPv6. Reporting criteria:
         * There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function ipv6ProcessedBytes(change: cloudwatch.MetricChange = {}) {
            return metric("IPv6ProcessedBytes", { statistic: "Sum",...change });
        }

        /**
         * The number of IPv6 requests received by the load balancer. Reporting criteria: There is a
         * nonzero value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function ipv6RequestCount(change: cloudwatch.MetricChange = {}) {
            return metric("IPv6RequestCount", { statistic: "Sum",...change });
        }

        /**
         * The total number of new TCP connections established from clients to the load balancer and
         * from the load balancer to targets. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function newConnectionCount(change: cloudwatch.MetricChange = {}) {
            return metric("NewConnectionCount", { statistic: "Sum",...change });
        }

        /**
         * The total number of bytes processed by the load balancer over IPv4 and IPv6. Reporting
         * criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function processedBytes(change: cloudwatch.MetricChange = {}) {
            return metric("ProcessedBytes", { statistic: "Sum",...change });
        }

        /**
         * The number of connections that were rejected because the load balancer had reached its
         * maximum number of connections. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer
         */
        export function rejectedConnectionCount(change: cloudwatch.MetricChange = {}) {
            return metric("RejectedConnectionCount", { statistic: "Sum",...change });
        }

        /**
         * The number of requests processed over IPv4 and IPv6. This count includes only the
         * requests with a response generated by a target of the load balancer. Reporting criteria:
         * Always reported
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function requestCount(change: cloudwatch.MetricChange = {}) {
            return metric("RequestCount", { statistic: "Sum",...change });
        }

        /**
         * The number of rules processed by the load balancer given a request rate averaged over an
         * hour. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer
         */
        export function ruleEvaluations(change: cloudwatch.MetricChange = {}) {
            return metric("RuleEvaluations", { statistic: "Sum",...change });
        }

        /**
         * The number of targets that are considered healthy. Reporting criteria: Reported if health
         * checks are enabled
         *
         * Statistics: The most useful statistics are Average, Minimum, and Maximum.
         *
         * Dimensions:          TargetGroup, LoadBalancer TargetGroup, AvailabilityZone,
         * LoadBalancer
         */
        export function healthyHostCount(change: cloudwatch.MetricChange = {}) {
            return metric("HealthyHostCount", { ...change });
        }

        /**
         * The number of HTTP response codes generated by the targets. This does not include any
         * response codes generated by the load balancer. Reporting criteria: There is a nonzero
         * value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function httpCodeTarget2XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_Target_2XX_Count", { statistic: "Sum", ...change });
        }

        /**
         * The number of HTTP response codes generated by the targets. This does not include any
         * response codes generated by the load balancer. Reporting criteria: There is a nonzero
         * value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function httpCodeTarget3XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_Target_3XX_Count", { statistic: "Sum", ...change });
        }

        /**
         * The number of HTTP response codes generated by the targets. This does not include any
         * response codes generated by the load balancer. Reporting criteria: There is a nonzero
         * value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function httpCodeTarget4XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_Target_4XX_Count", { statistic: "Sum", ...change });
        }

        /**
         * The number of HTTP response codes generated by the targets. This does not include any
         * response codes generated by the load balancer. Reporting criteria: There is a nonzero
         * value
         *
         * Statistics: The most useful statistic is Sum. Note that Minimum, Maximum, and Average all
         * return 1.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function httpCodeTarget5XXCount(change: cloudwatch.MetricChange = {}) {
            return metric("HTTPCode_Target_5XX_Count", { statistic: "Sum", ...change });
        }

        /**
         * The number of requests where the load balancer chose a new target because it couldn't use
         * an existing sticky session. For example, the request was the first request from a new
         * client and no stickiness cookie was presented, a stickiness cookie was presented but it
         * did not specify a target that was registered with this target group, the stickiness
         * cookie was malformed or expired, or an internal error prevented the load balancer from
         * reading the stickiness cookie. Reporting criteria: Stickiness is enabled on the target
         * group.
         *
         * Statistics: The only meaningful statistic is Sum.
         */
        export function nonStickyRequestCount(change: cloudwatch.MetricChange = {}) {
            return metric("NonStickyRequestCount", { statistic: "Sum",...change });
        }

        /**
         * The average number of requests received by each target in a target group. You must
         * specify the target group using the TargetGroup dimension. This metric does not apply if
         * the target is a Lambda function. Reporting criteria: Always reported
         *
         * Statistics: The only valid statistic is Sum. Note that this represents the average not
         * the sum.
         *
         * Dimensions: TargetGroup TargetGroup, LoadBalancer
         */
        export function requestCountPerTarget(change: cloudwatch.MetricChange = {}) {
            return metric("RequestCountPerTarget", { statistic: "Sum",...change });
        }

        /**
         * The number of connections that were not successfully established between the load
         * balancer and target. This metric does not apply if the target is a Lambda function.
         * Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function targetConnectionErrorCount(change: cloudwatch.MetricChange = {}) {
            return metric("TargetConnectionErrorCount", { statistic: "Sum",...change });
        }

        /**
         * The time elapsed, in seconds, after the request leaves the load balancer until a response
         * from the target is received. This is equivalent to the target_processing_time field in
         * the access logs. Reporting criteria: There is a nonzero value
         *
         * Statistics: The most useful statistics are Average and pNN.NN (percentiles).
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function targetResponseTime(change: cloudwatch.MetricChange = {}) {
            return metric("TargetResponseTime", { ...change });
        }

        /**
         * The number of TLS connections initiated by the load balancer that did not establish a
         * session with the target. Possible causes include a mismatch of ciphers or protocols. This
         * metric does not apply if the target is a Lambda function. Reporting criteria: There is a
         * nonzero value
         *
         * Statistics: The most useful statistic is Sum.
         *
         * Dimensions: LoadBalancer AvailabilityZone, LoadBalancer TargetGroup, LoadBalancer
         * TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function targetTLSNegotiationErrorCount(change: cloudwatch.MetricChange = {}) {
            return metric("TargetTLSNegotiationErrorCount", { statistic: "Sum",...change });
        }

        /**
         * The number of targets that are considered unhealthy. Reporting criteria: Reported if
         * health checks are enabled
         *
         * Statistics: The most useful statistics are Average, Minimum, and Maximum.
         *
         * Dimensions: TargetGroup, LoadBalancer TargetGroup, AvailabilityZone, LoadBalancer
         */
        export function unHealthyHostCount(change: cloudwatch.MetricChange = {}) {
            return metric("UnHealthyHostCount", { ...change });
        }
    }
}
