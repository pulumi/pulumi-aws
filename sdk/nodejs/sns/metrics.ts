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

import { Topic } from "./topic";

export module metrics {
    export type SnsMetricName =
        "NumberOfMessagesPublished" | "NumberOfNotificationsDelivered" |
        "NumberOfNotificationsFailed" | "NumberOfNotificationsFilteredOut" |
        "NumberOfNotificationsFilteredOut-NoMessageAttributes" |
        "NumberOfNotificationsFilteredOut-InvalidAttributes" |
        "PublishSize" | "SMSMonthToDateSpentUSD" | "SMSSuccessRate";

    /**
     * Creates an AWS/SNS metric with the requested [metricName]. See
     * https://docs.aws.amazon.com/sns/latest/dg/sns-monitoring-using-cloudwatch.html for list of
     * all metric-names.
     *
     * Note, individual metrics can easily be obtained without supplying the name using the other
     * [metricXXX] functions.
     *
     * Amazon SNS and CloudWatch are integrated so you can collect, view, and analyze metrics for
     * every active Amazon SNS notification. Once you have configured CloudWatch for Amazon SNS, you
     * can gain better insight into the performance of your Amazon SNS topics, push notifications,
     * and SMS deliveries. For example, you can set an alarm to send you an email notification if a
     * specified threshold is met for an Amazon SNS metric, such as NumberOfNotificationsFailed.
     *
     * The metrics you configure with CloudWatch for your Amazon SNS topics are automatically
     * collected and pushed to CloudWatch every five minutes. These metrics are gathered on all
     * topics that meet the CloudWatch guidelines for being active. A topic is considered active by
     * CloudWatch for up to six hours from the last activity (i.e., any API call) on the topic.
     *
     * Amazon Simple Notification Service sends the following dimensions to CloudWatch:
     *
     * 1. "Application": Filters on application objects, which represent an app and device
     *    registered with one of the supported push notification services, such as APNS and FCM.
     * 2. "Application,Platform": Filters on application and platform objects, where the platform
     *    objects are for the supported push notification services, such as APNS and FCM.
     * 3. "Country": Filters on the destination country or region of an SMS message. The country or
     *    region is represented by its ISO 3166-1 alpha-2 code.
     * 4. "Platform": Filters on platform objects for the push notification services, such as APNS
     *    and FCM.
     * 5. "TopicName": Filters on Amazon SNS topic names.
     * 6. "SMSType": Filters on the message type of SMS message. Can be "promotional" or
     *    "transactional".
     */
    export function metric(metricName: SnsMetricName, change: cloudwatch.MetricChange = {}) {
        return new cloudwatch.Metric({
            namespace: "AWS/SNS",
            name: metricName,
            ...change,
        });
    }

    /**
     * The number of messages published to your Amazon SNS topics.
     *
     * Units: Count
     *
     * Valid Statistics: Sum
     */
    export function numberOfMessagesPublished(change: cloudwatch.MetricChange = {}) {
        return metric("NumberOfMessagesPublished", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * The number of messages successfully delivered from your Amazon SNS topics to subscribing
     * endpoints.
     *
     * For a delivery attempt to succeed, the endpoint's subscription must accept the message. A
     * subscription accepts a message if a.) it lacks a filter policy or b.) its filter policy
     * includes attributes that match those assigned to the message. If the subscription rejects the
     * message, the delivery attempt isn't counted for this metric.
     *
     * Units: Count
     *
     * Valid Statistics: Sum
     */
    export function numberOfNotificationsDelivered(change: cloudwatch.MetricChange = {}) {
        return metric("NumberOfNotificationsDelivered", { statistic: "Sum", unit: "Count", ...change });
    }

    /**
     * The number of messages that Amazon SNS failed to deliver.
     *
     * For Amazon SQS, email, SMS, or mobile push endpoints, the metric increments by 1 when Amazon
     * SNS stops attempting message deliveries. For HTTP or HTTPS endpoints, the metric includes
     * every failed delivery attempt, including retries that follow the initial attempt. For all
     * other endpoints, the count increases by 1 when the message fails to deliver (regardless of
     * the number of attempts).
     *
     * This metric does not include messages that were rejected by subscription filter policies.
     *
     * Units: Count
     *
     * Valid Statistics: Sum, Average
     */
    export function numberOfNotificationsFailed(change: cloudwatch.MetricChange = {}) {
        return metric("NumberOfNotificationsFailed", { unit: "Count", ...change });
    }

    /**
     * The number of messages that were rejected by subscription filter policies because the
     * messages have no attributes.
     *
     * Units: Count
     *
     * Valid Statistics: Sum, Average
     */
    export function numberOfNotificationsFilteredOut_NoMessageAttributes(change: cloudwatch.MetricChange = {}) {
        return metric("NumberOfNotificationsFilteredOut-NoMessageAttributes", { unit: "Count", ...change });
    }

    /**
     * The number of messages that were rejected by subscription filter policies because the
     * messages' attributes are invalid – for example, because the attribute JSON is incorrectly
     * formatted.
     *
     * Units: Count
     *
     * Valid Statistics: Sum, Average
     */
    export function numberOfNotificationsFilteredOut_InvalidAttributes(change: cloudwatch.MetricChange = {}) {
        return metric("NumberOfNotificationsFilteredOut-InvalidAttributes", { unit: "Count", ...change });
    }

    /**
     * The number of database connections in use.
     *
     * Units: Bytes
     *
     * Valid Statistics: Minimum, Maximum, Average and Count
     */
    export function publishSize(change: cloudwatch.MetricChange = {}) {
        return metric("PublishSize", { unit: "Bytes", ...change });
    }

    /**
     * The charges you have accrued since the start of the current calendar month for sending SMS
     * messages.
     *
     * You can set an alarm for this metric to know when your month-to-date charges are close to the
     * monthly SMS spend limit for your account. When Amazon SNS determines that sending an SMS
     * message would incur a cost that exceeds this limit, it stops publishing SMS messages within
     * minutes.
     *
     * Valid Statistics: Maximum
     */
    export function smsMonthToDateSpentUSD(change: cloudwatch.MetricChange = {}) {
        return metric("SMSMonthToDateSpentUSD", { statistic: "Maximum", ...change });
    }

    /**
     * The rate of successful SMS message deliveries.
     *
     * Units: Count
     *
     * Valid Statistics: Sum, Average, Data Samples
     */
    export function smsSuccessRate(change: cloudwatch.MetricChange = {}) {
        return metric("SMSSuccessRate", { unit: "Count", ...change });
    }
}

declare module "./topic" {
    interface Topic {
        /**
         * Direct access to create metrics for this specific [sns.Topic].
         */
        metrics: {
            /**
             * The number of messages published to your Amazon SNS topics.
             *
             * Units: Count
             *
             * Valid Statistics: Sum
             */
            numberOfMessagesPublished(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of messages successfully delivered from your Amazon SNS topics to subscribing
             * endpoints.
             *
             * For a delivery attempt to succeed, the endpoint's subscription must accept the message. A
             * subscription accepts a message if a.) it lacks a filter policy or b.) its filter policy
             * includes attributes that match those assigned to the message. If the subscription rejects the
             * message, the delivery attempt isn't counted for this metric.
             *
             * Units: Count
             *
             * Valid Statistics: Sum
             */
            numberOfNotificationsDelivered(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of messages that Amazon SNS failed to deliver.
             *
             * For Amazon SQS, email, SMS, or mobile push endpoints, the metric increments by 1 when Amazon
             * SNS stops attempting message deliveries. For HTTP or HTTPS endpoints, the metric includes
             * every failed delivery attempt, including retries that follow the initial attempt. For all
             * other endpoints, the count increases by 1 when the message fails to deliver (regardless of
             * the number of attempts).
             *
             * This metric does not include messages that were rejected by subscription filter policies.
             *
             * Units: Count
             *
             * Valid Statistics: Sum, Average
             */
            numberOfNotificationsFailed(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of messages that were rejected by subscription filter policies because the
             * messages have no attributes.
             *
             * Units: Count
             *
             * Valid Statistics: Sum, Average
             */
            numberOfNotificationsFilteredOut_NoMessageAttributes(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of messages that were rejected by subscription filter policies because the
             * messages' attributes are invalid – for example, because the attribute JSON is incorrectly
             * formatted.
             *
             * Units: Count
             *
             * Valid Statistics: Sum, Average
             */
            numberOfNotificationsFilteredOut_InvalidAttributes(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The number of database connections in use.
             *
             * Units: Bytes
             *
             * Valid Statistics: Minimum, Maximum, Average and Count
             */
            publishSize(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The charges you have accrued since the start of the current calendar month for sending SMS
             * messages.
             *
             * You can set an alarm for this metric to know when your month-to-date charges are close to the
             * monthly SMS spend limit for your account. When Amazon SNS determines that sending an SMS
             * message would incur a cost that exceeds this limit, it stops publishing SMS messages within
             * minutes.
             *
             * Valid Statistics: Maximum
             */
            smsMonthToDateSpentUSD(change?: cloudwatch.MetricChange): cloudwatch.Metric;

            /**
             * The rate of successful SMS message deliveries.
             *
             * Units: Count
             *
             * Valid Statistics: Sum, Average, Data Samples
             */
            smsSuccessRate(change?: cloudwatch.MetricChange): cloudwatch.Metric;
        }
    }
}

// All instance metrics just make a normal AWS/SNS metric, except with the TopicName
// dimension set to this Topic's name.

function getMetric(
    topic: Topic, change: cloudwatch.MetricChange,
    moduleFunction: (change: cloudwatch.MetricChange) => cloudwatch.Metric) {

    return moduleFunction({ dimensions: { TopicName: topic.name } }).with(change);
}

Object.defineProperty(Topic.prototype, "metrics", {
    get: function (this: Topic) {
        const _this = this;
        return {
            numberOfMessagesPublished: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.numberOfMessagesPublished),
            numberOfNotificationsDelivered: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.numberOfNotificationsDelivered),
            numberOfNotificationsFailed: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.numberOfNotificationsFailed),
            numberOfNotificationsFilteredOut_NoMessageAttributes: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.numberOfNotificationsFilteredOut_NoMessageAttributes),
            numberOfNotificationsFilteredOut_InvalidAttributes: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.numberOfNotificationsFilteredOut_InvalidAttributes),
            publishSize: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.publishSize),
            smsMonthToDateSpentUSD: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.smsMonthToDateSpentUSD),
            smsSuccessRate: (change: cloudwatch.MetricChange) => getMetric(_this, change, metrics.smsSuccessRate),
        }
    }
});
