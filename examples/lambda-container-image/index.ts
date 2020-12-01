// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";

const image = awsx.ecr.buildAndPushImage("basic-container", {
    context: "./app",
});

const role = new aws.iam.Role("demo-role", {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal({
        Service: "lambda.amazonaws.com"
    })
});

const lambdaFullAccess = new aws.iam.RolePolicyAttachment("lambdaFullAccess", {
    role: role.name,
    policyArn: aws.iam.ManagedPolicies.AWSLambdaFullAccess
})
const ecsFullAccess = new aws.iam.RolePolicyAttachment("ecsFullAccess", {
    role: role.name,
    policyArn: aws.iam.ManagedPolicies.AmazonEC2ContainerServiceFullAccess
});

const func = new aws.lambda.Function("demo-func", {
    role: role.arn,
    imageUri: image.imageValue,
});

export const imageUri = image.imageValue;
