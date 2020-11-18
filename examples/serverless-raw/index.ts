// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { asset } from "@pulumi/pulumi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

let region = config.require("envRegion");

///////////////////
// Lambda Function
///////////////////
let policy = {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": "sts:AssumeRole",
            "Principal": {
                "Service": "lambda.amazonaws.com",
            },
            "Effect": "Allow",
            "Sid": "",
        },
    ],
};

let role = new aws.iam.Role("mylambda-role", {
    assumeRolePolicy: JSON.stringify(policy),
}, providerOpts);
let fullAccess = new aws.iam.RolePolicyAttachment("mylambda-access", {
    role: role,
    policyArn: aws.iam.ManagedPolicy.AWSLambdaFullAccess,
}, providerOpts);
let lambda = new aws.lambda.Function("mylambda", {
    code: new asset.AssetArchive({
        "index.js": new asset.StringAsset(
            "exports.handler = (e, c, cb) => cb(null, {statusCode: 200, body: 'Hello, world!'});",
        ),
    }),
    role: role.arn,
    handler: "index.handler",
    runtime: aws.lambda.NodeJS12dXRuntime,
}, providerOpts);

///////////////////
// Logging
///////////////////
let logGroup = new aws.cloudwatch.LogGroup("/aws/lambda/mylambda", {
    retentionInDays: 7,
}, providerOpts);

let logcollector = new aws.lambda.Function("mylambda-logcollector", {
    code: new asset.AssetArchive({
        "index.js": new asset.StringAsset(
            "exports.handler = (e, c, cb) => console.log(e);",
        ),
    }),
    role: role.arn,
    handler: "index.handler",
    runtime: aws.lambda.NodeJS12dXRuntime,
}, providerOpts);

let permission = new aws.lambda.Permission("logcollector-permission", {
    action: "lambda:InvokeFunction",
    principal: "logs." + region + ".amazonaws.com",
    sourceArn: pulumi.interpolate`${logGroup.arn}:*`,
    function: logcollector,
}, providerOpts);

let logSubscription = new aws.cloudwatch.LogSubscriptionFilter("logsubscription", {
    destinationArn: logcollector.arn,
    logGroup: logGroup,
    filterPattern: "",
}, providerOpts);

///////////////////
// DynamoDB Table
///////////////////
let music = new aws.dynamodb.Table("music", {
    attributes: [
        { name: "Album", type: "S" },
        { name: "Artist", type: "S" },
    ],
    hashKey: "Album",
    rangeKey: "Artist",
    readCapacity: 1,
    writeCapacity: 1,
}, providerOpts);

///////////////////
// APIGateway RestAPI
///////////////////

// The following creates a REST API equivalent to the following Swagger specification:
//
//    {
//      swagger: "2.0",
//      info: { title: "myrestapi", version: "1.0" },
//      paths: {
//        "/bambam": {
//          "x-amazon-apigateway-any-method": {
//            "x-amazon-apigateway-integration": {
//              uri: ,
//              passthroughBehavior: "when_no_match",
//              httpMethod: "POST",
//              type: "aws_proxy",
//            },
//          },
//        },
//      },
//    };

let restApi = new aws.apigateway.RestApi("myrestapi", {}, providerOpts);

let resource = new aws.apigateway.Resource("myrestapi-resource", {
    restApi: restApi,
    pathPart: "bambam",
    parentId: restApi.rootResourceId!,
}, providerOpts);

let method = new aws.apigateway.Method("myrestapi-method", {
    restApi: restApi,
    resourceId: resource.id,
    httpMethod: "ANY",
    authorization: "NONE",
}, providerOpts);

let integration = new aws.apigateway.Integration("myrestapi-integration", {
    restApi: restApi,
    resourceId: resource.id,
    httpMethod: "ANY",
    type: "AWS_PROXY",
    integrationHttpMethod: "POST",
    passthroughBehavior: "WHEN_NO_MATCH",
    uri: pulumi.interpolate `arn:aws:apigateway:${region}:lambda:path/2015-03-31/functions/${lambda.arn}/invocations`,
}, { dependsOn: [method], provider: providerOpts.provider });

let deployment = new aws.apigateway.Deployment("myrestapi-deployment-prod", {
    restApi: restApi,
    description: "my deployment",
    stageName: "prod",
}, { dependsOn: [integration], provider: providerOpts.provider });
