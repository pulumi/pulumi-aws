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

const bucket = new aws.s3.Bucket("testbucket", {
    serverSideEncryptionConfiguration: {
        rule: {
            applyServerSideEncryptionByDefault: {
                sseAlgorithm: "AES256",
            },
        },
    },
    forceDestroy: true,
});

const queue = new aws.sqs.Queue("queue", {
    visibilityTimeoutSeconds: 300,
});

queue.onEvent("subscription", async (event) => {
    console.log("Received: " + JSON.stringify(event, null, 2));
    const awssdk = await import("aws-sdk");
    const s3 = new awssdk.S3();

    const recordFile = "lastEvent.json";

    console.log("Storing sqs message to S3.");
    await s3.putObject({
        Bucket: bucket.id.get(),
        Key: recordFile,
        Body: JSON.stringify(event),
    }).promise();
    console.log("Stored sqs message to S3.");
}, { batchSize: 1 });

export const queueUrl = queue.id;
export const bucketUrl = pulumi.interpolate `s3://${bucket.id}`;
