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
    export type AcmpcaMetricName =
        "CRLGenerated" | "MisconfiguredCRLBucket" | "Time" | "Success" | "Failure";

    /**
     * Creates an AWS/ACMPrivateCA metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaCloudWatch.html for list of all
     * metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     */
    export function metric(metricName: AcmpcaMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/ACMPrivateCA",
            name: metricName,
            ...change,
        });
    }

    /**
     * A certificate revocation list (CRL) was generated. This metric applies only to a private CA.
     */
    export function crlGenerated(change?: cloudwatch.MetricChange) {
        return metric("CRLGenerated", change);
    }

    /**
     * The S3 bucket specified for the CRL is not correctly configured. Check the bucket policy. This
     * metric applies only to a private CA.
     */
    export function misconfiguredCRLBucket(change?: cloudwatch.MetricChange) {
        return metric("MisconfiguredCRLBucket", change);
    }

    /**
     * The time at which the certificate was issued. This metric applies only to the
     * [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html)
     * operation.
     */
    export function time(change?: cloudwatch.MetricChange) {
        return metric("Time", change);
    }

    /**
     * Specifies whether a certificate was successfully issued. This metric applies only to the
     * IssueCertificate operation.
     */
    export function success(change?: cloudwatch.MetricChange) {
        return metric("Success", change);
    }

    /**
     * Indicates that an operation failed. This metric applies only to the IssueCertificate operation.
     */
    export function failure(change?: cloudwatch.MetricChange) {
        return metric("Failure", change);
    }
}
