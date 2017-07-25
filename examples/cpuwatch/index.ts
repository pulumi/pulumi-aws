// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@lumi/aws";
import {emailAddress} from "./config";

// enableAlarm turns on a CPU alarm for the given instance; if the CPU utilization exceeds the given threshold, an
// email will be sent to the configured email address.
export function enableAlarm(instance: aws.ec2.Instance, threshold: number): void {
    if (emailAddress === undefined) {
        throw new Error("Missing email address configuration");
    }

    let topic = new aws.sns.Topic(instance.name + "-topic", {});
    let topicSubscription = new aws.sns.TopicSubscription(instance.name + "-subscription", {
        topic: topic,
        protocol: "email",
        endpoint: emailAddress,
    });
    let alarm = new aws.cloudwatch.MetricAlarm(instance.name + "-alarm", {
        alarmActions: [ topic ],
        metricName: "CPUUtilization",
        namespace: "AWS/EC2",
        statistic: "Average",
        period: 60,
        evaluationPeriods: 3,
        threshold: threshold,
        comparisonOperator: "GreaterThanThreshold",
        dimensions: [{
            name: "InstanceId",
            value: instance,
        }],
    });
}

