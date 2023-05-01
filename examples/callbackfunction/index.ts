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

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const role = new aws.iam.Role("role", {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal({ Service: "lambda.amazonaws.com" }),
}, providerOpts);

const policy = new aws.iam.Policy("policy", {
    policy: {
        Version: "2012-10-17",
        Statement: [{
            Action: ["s3:ListBucket"],
            Effect: "Allow",
            Resource: "arn:aws:s3:::*",
        }],
    }
});

const functions = [
    new aws.lambda.CallbackFunction("a", {
        callback: async () => ({ success: true }),
    }, providerOpts),
    new aws.lambda.CallbackFunction("b", {
        role: role,
        callback: async () => ({ success: true }),
    }, providerOpts),
    new aws.lambda.CallbackFunction("c", {
        role: role.arn,
        callback: async () => ({ success: true }),
    }, providerOpts),
    new aws.lambda.CallbackFunction("d", {
        policies: [aws.iam.ManagedPolicy.AWSLambdaBasicExecutionRole],
        callback: async () => ({ success: true }),
    }, providerOpts),
    new aws.lambda.CallbackFunction("e", {
        callbackFactory: () => {
            const ret = { success: true };
            return async () => ret;
        },
    }, providerOpts),
    new aws.lambda.CallbackFunction("f", {
        policies: { one: policy.arn },
        callback: async () => ({ success: true }),
    }, providerOpts),
];

export const arns = functions.map(f => f.arn);
