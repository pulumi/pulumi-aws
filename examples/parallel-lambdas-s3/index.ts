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
import * as std from "@pulumi/std";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const assumeRole = aws.iam.getPolicyDocument({
    statements: [{
        effect: "Allow",
        principals: [{
            type: "Service",
            identifiers: ["lambda.amazonaws.com"],
        }],
        actions: ["sts:AssumeRole"],
    }],
}, providerOpts);
const role = new aws.iam.Role("parallel-iam-role", {
    assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json)
}, providerOpts);

const bucket = new aws.s3.BucketV2("lambda-code-storage", {
    forceDestroy: true,
}, providerOpts);

const versioning = new aws.s3.BucketVersioningV2("lambda-code-storage", {
    bucket: bucket.id,
    versioningConfiguration: {
        status: "Enabled",
    },
}, providerOpts);

for (let i = 0; i < 50; i++) {
    const lambdaCode = new aws.s3.BucketObjectv2(`lambda-zip-${i}`, {
        bucket: bucket.bucket,
        key: `lambda-${i}.zip`,
        source: new pulumi.asset.FileAsset("lambda.zip"),
        sourceHash: std.filesha256({
            input: "lambda.zip",
        }).then(invoke => invoke.result),
    }, {...providerOpts, dependsOn: [versioning]});

    new aws.lambda.Function(`lambda-${i}`, {
        role: role.arn,
        handler: "index.handler",
        runtime: "nodejs20.x",
        s3Bucket: bucket.bucket,
        s3Key: lambdaCode.key,
        s3ObjectVersion: lambdaCode.versionId,
    }, {
        ...providerOpts,
        ignoreChanges: ["replacementSecurityGroupIds"],
    });
}
