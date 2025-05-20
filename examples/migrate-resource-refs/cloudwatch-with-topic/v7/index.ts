import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const logGroup = new aws.cloudwatch.LogGroup("test-logs", {
    retentionInDays: 1, // Reduced to 1 day for testing
});

const alarmTopic = new aws.sns.Topic("alarm-topic");

const alarmSubscription = new aws.sns.TopicSubscription("alarm-subscription", {
    topic: alarmTopic.id,
    protocol: "http",
    endpoint: "http://example.com",
});

const logStream = new aws.kinesis.Stream("log-stream", {
    shardCount: 1,
});

const logRole = new aws.iam.Role("log-role", {
    assumeRolePolicy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: "sts:AssumeRole",
            Effect: "Allow",
            Principal: {
                Service: "logs.amazonaws.com",
            },
        }],
    }),
});

const logPolicy = new aws.iam.RolePolicy("log-policy", {
    role: logRole.id,
    policy: logStream.arn.apply(arn => JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Effect: "Allow",
            Action: [
                "kinesis:PutRecord",
                "kinesis:PutRecords"
            ],
            Resource: arn,
        }],
    })),
});

const errorMetricFilter = new aws.cloudwatch.LogMetricFilter("error-count", {
    logGroupName: logGroup.name,
    pattern: "ERROR",
    metricTransformation: {
        name: "ErrorCount",
        namespace: "TestApp",
        value: "1",
    },
});

const errorAlarm = new aws.cloudwatch.MetricAlarm("error-alarm", {
    name: "error-count-alarm",
    comparisonOperator: "GreaterThanThreshold",
    evaluationPeriods: 1,
    metricName: "ErrorCount",
    namespace: "TestApp",
    period: 60,
    statistic: "Sum",
    threshold: 1, // Reduced threshold for easier testing
    alarmDescription: "This metric monitors error count",
    alarmActions: [alarmTopic.id],
    insufficientDataActions: [alarmTopic.id],
    okActions: [alarmTopic.id],
});

const subscriptionFilter = new aws.cloudwatch.LogSubscriptionFilter("test-filter", {
    logGroup: logGroup.name,
    filterPattern: "ERROR",
    destinationArn: logStream.arn,
    roleArn: logRole.arn,
});

export const logGroupName = logGroup.name;