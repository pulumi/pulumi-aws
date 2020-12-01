// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";
import * as pulumi from "@pulumi/pulumi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const image = awsx.ecr.buildAndPushImage("basic-container", {
    context: "./app",
}, {}, providerOpts);

const role = new aws.iam.Role("demo-role", {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal({
        Service: "lambda.amazonaws.com"
    })
}, providerOpts);

const lambdaFullAccess = new aws.iam.RolePolicyAttachment("lambdaFullAccess", {
    role: role.name,
    policyArn: aws.iam.ManagedPolicies.AWSLambdaFullAccess
}, providerOpts)
const ecsFullAccess = new aws.iam.RolePolicyAttachment("ecsFullAccess", {
    role: role.name,
    policyArn: aws.iam.ManagedPolicies.AmazonEC2ContainerServiceFullAccess
}, providerOpts);

const func = new aws.lambda.Function("demo-func", {
    role: role.arn,
    imageUri: image.imageValue,
    packageType: "Image"
}, providerOpts);

export const imageUri = image.imageValue;
