import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

// Create a log group
const logGroup = new aws.cloudwatch.LogGroup("test-logs", {
    retentionInDays: 1, // Reduced to 1 day for testing
});

// Create an SNS topic for alarm notifications
const alarmTopic = new aws.sns.Topic("alarm-topic");

// Create a Kinesis stream for log forwarding
const logStream = new aws.kinesis.Stream("log-stream", {
    shardCount: 1,
});

// Create IAM role for CloudWatch Logs to write to Kinesis
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

// Attach policy to allow writing to Kinesis
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

// Create a metric filter to count errors
const errorMetricFilter = new aws.cloudwatch.LogMetricFilter("error-count", {
    logGroupName: logGroup.name,
    pattern: "ERROR",
    metricTransformation: {
        name: "ErrorCount",
        namespace: "TestApp",
        value: "1",
    },
});

// Create an alarm based on the error count
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
    alarmActions: [alarmTopic],
    insufficientDataActions: [alarmTopic],
    okActions: [alarmTopic],
});

// Create a subscription filter to forward logs
const subscriptionFilter = new aws.cloudwatch.LogSubscriptionFilter("test-filter", {
    logGroup: logGroup,
    filterPattern: "ERROR",
    destinationArn: logStream.arn,
    roleArn: logRole.arn,
});

// Export the log group name
export const logGroupName = logGroup.name;