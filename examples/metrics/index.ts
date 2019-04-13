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
import * as aws from "@pulumi/aws";
import * as fetch from "node-fetch";

// Examples of different types of metrics and alarms that can be set.

const topic = new aws.sns.Topic("sites-to-process-topic");
const subscription = topic.onEvent("for-each-url", async (event) => {
    const records = event.Records || [];
    for (const record of records) {
        const url = record.Sns.Message;

        console.log(`${url}: Processing`);

        // Fetch the contents at the URL
        console.log(`${url}: Getting`);
        try {
            const res = await fetch.default(url);
        } catch (err) {
            console.log(`${url}: Failed to GET`);
            return;
        }
    }
});

let alarmIndex = 0;

const funcMetric = subscription.func.metrics.duration({ unit: "Seconds" });
const funcAlarm = funcMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const topicMetric = topic.metrics.numberOfMessagesPublished();
const topicAlarm = topicMetric.createAlarm("alarm" + alarmIndex++, { threshold: 1000, evaluationPeriods: 2 });

const queue = new aws.sqs.Queue("terraform_queue", {
    delaySeconds: 90,
    maxMessageSize: 2048,
    messageRetentionSeconds: 86400,
    receiveWaitTimeSeconds: 10,
    tags: {
        Environment: "production",
    },
});

const queueMetric = queue.metrics.sentMessageSize();
const queueAlarm = queueMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const restApi = new aws.apigateway.RestApi("MyDemoAPI", {
    description: "This is my API for demonstration purposes",
  });

const restApiMetric = restApi.metrics.error5XX();
const restApiAlarm = restApiMetric.createAlarm("alarm" + alarmIndex++, { threshold: 50, evaluationPeriods: 2 });

const table = new aws.dynamodb.Table("testtable", {
    attributes: [{
        name: "id",
        type: "S",
    }],
    hashKey: "id",
    readCapacity: 5,
    writeCapacity: 5,
    streamEnabled: true,
    streamViewType: "NEW_AND_OLD_IMAGES",
});

const tableMetric = table.metrics.throttledRequests();
const tableAlarm = tableMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const bucket = new aws.s3.Bucket("b", {
    acl: "private",
    tags: {
        Environment: "Dev",
        Name: "My bucket",
    },
});

const bucketMetric = bucket.metrics.firstByteLatency({ unit: "Seconds" });
const bucketAlarm = bucketMetric.createAlarm("alarm" + alarmIndex++, { threshold: 30 , evaluationPeriods: 2 });

const ubuntu = pulumi.output(aws.getAmi({
    filters: [
        { name: "name", values: ["ubuntu/images/hvm-ssd/ubuntu-trusty-14.04-amd64-server-*"] },
        { name: "virtualization-type", values: ["hvm"] },
    ],
    mostRecent: true,
    owners: ["099720109477"], // Canonical
}));
const instance = new aws.ec2.Instance("web", {
    ami: ubuntu.apply(ubuntu => ubuntu.id),
    instanceType: "t2.micro",
    tags: {
        Name: "HelloWorld",
    },
});

const instanceMetric = instance.metrics.cpuUtilization();
const instanceAlarm = instanceMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const cluster = new aws.ecs.Cluster("foo", {});
const clusterMetric = cluster.metrics.cpuUtilization({ unit: "Percent" });
const clusterAlarm = clusterMetric.createAlarm("alarm" + alarmIndex++, { threshold: 50, evaluationPeriods: 2 });

const userPool = new aws.cognito.UserPool("pool", {});
const userPoolMetric = userPool.metrics.compromisedCredentialsRisk();
const userPoolAlarm = userPoolMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const eventRule = new aws.cloudwatch.EventRule("console", {
    description: "Capture each AWS Console Sign In",
    eventPattern: `{
  "detail-type": [
    "AWS Console Sign In via CloudTrail"
  ]
}
`,
});
const eventRuleMetric = eventRule.metrics.deadLetterInvocations();
const eventRuleAlarm = eventRuleMetric.createAlarm("alarm" + alarmIndex++, { threshold: 120, evaluationPeriods: 2 });

const logGroup = new aws.cloudwatch.LogGroup("yada", {
    tags: {
        Application: "serviceA",
        Environment: "production",
    },
});
const logGroupMetric = logGroup.metrics.incomingBytes({ unit: "Megabytes" });
const logGroupAlarm = logGroupMetric.createAlarm("alarm" + alarmIndex++, { threshold: 512, evaluationPeriods: 2 });
