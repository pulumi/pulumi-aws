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

export type CognitoMetricName =
    "CompromisedCredentialsRisk" | "AccountTakeOverRisk" | "OverrideBlock" | "Risk" | "NoRisk";

/**
 * Creates an AWS/Cognito metric with the requested [metricName]. See
 * https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-settings-viewing-advanced-security-metrics.html
 * for list of all metric-names.
 *
 * Note, individual metrics can easily be obtained without supplying the name using the other
 * [metricXXX] functions.
 *
 * Amazon Cognito publishes metrics for advanced security features to your account in Amazon
 * CloudWatch. The advanced security metrics are grouped together by risk level and also by request
 * level.
 */
export function metric(metricName: CognitoMetricName, change: cloudwatch.MetricChange = {}) {
    return new cloudwatch.Metric({
        namespace: "AWS/Cognito",
        name: metricName,
        ...change,
    });
}

/**
 * Requests where Amazon Cognito detected compromised credentials.
 */
export function metricCompromisedCredentialsRisk(change: cloudwatch.MetricChange = {}) {
    return metric("CompromisedCredentialsRisk", change);
}

/**
 * Requests where Amazon Cognito detected account take-over risk.
 */
export function metricAccountTakeOverRisk(change: cloudwatch.MetricChange = {}) {
    return metric("AccountTakeOverRisk", change);
}

/**
 * Requests that Amazon Cognito blocked because of the configuration provided by the developer.
 */
export function metricOverrideBlock(change: cloudwatch.MetricChange = {}) {
    return metric("OverrideBlock", change);
}

/**
 * Requests that Amazon Cognito marked as risky.
 */
export function metricRisk(change: cloudwatch.MetricChange = {}) {
    return metric("Risk", change);
}

/**
 * Requests where Amazon Cognito did not identify any risk.
 */
export function metricNoRisk(change: cloudwatch.MetricChange = {}) {
    return metric("NoRisk", change);
}
