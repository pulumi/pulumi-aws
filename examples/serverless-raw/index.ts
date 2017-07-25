// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@lumi/aws";
import * as lumi from "@lumi/lumi";
import { jsonStringify } from "@lumi/lumirt";
let region = aws.config.requireRegion();

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
    assumeRolePolicy: jsonStringify(policy),
});
let fullAccess = new aws.iam.RolePolicyAttachment("mylambda-access", {
    role: role,
    policyArn: aws.iam.AWSLambdaFullAccess,
});
let lambda = new aws.lambda.Function("mylambda", {
    code: new lumi.asset.AssetArchive({
        "index.js": new lumi.asset.String(
            "exports.handler = (e, c, cb) => cb(null, {statusCode: 200, body: 'Hello, world!'});",
        ),
    }),
    role: role.arn,
    handler: "index.handler",
    runtime: aws.lambda.NodeJS6d10Runtime,
});

///////////////////
// Logging
///////////////////
let logGroup = new aws.cloudwatch.LogGroup("/aws/lambda/mylambda", {
    retentionInDays: 7,
});

let logcollector = new aws.lambda.Function("mylambda-logcollector", {
    code: new lumi.asset.AssetArchive({
        "index.js": new lumi.asset.String(
            "exports.handler = (e, c, cb) => console.log(e);",
        ),
    }),
    role: role.arn,
    handler: "index.handler",
    runtime: aws.lambda.NodeJS6d10Runtime,
});

let permission = new aws.lambda.Permission("logcollector-permission", {
    action: "lambda:InvokeFunction",
    principal: "logs." + region + ".amazonaws.com",
    sourceArn: logGroup.arn,
    function: logcollector,
});

let logSubscription = new aws.cloudwatch.LogSubscriptionFilter("logsubscription", {
    destinationArn: logcollector.arn,
    logGroup: logGroup,
    filterPattern: "",
});

///////////////////
// DynamoDB Table
///////////////////
let music = new aws.dynamodb.Table("music", {
    attribute: [
        { name: "Album", type: "S" },
        { name: "Artist", type: "S" },
    ],
    hashKey: "Album",
    rangeKey: "Artist",
    readCapacity: 1,
    writeCapacity: 1,
});

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

let restApi = new aws.apigateway.RestApi("myrestapi", {});

let resource = new aws.apigateway.Resource("myrestapi-resource", {
    restApi: restApi,
    pathPart: "bambam",
    parentId: restApi.rootResourceId!,
});

let method = new aws.apigateway.Method("myrestapi-method", {
    restApi: restApi,
    resourceId: resource.id,
    httpMethod: "ANY",
    authorization: "NONE",
});

let integration = new aws.apigateway.Integration("myrestapi-integration", {
    restApi: restApi,
    resourceId: resource.id,
    httpMethod: "ANY",
    type: "AWS_PROXY",
    integrationHttpMethod: "POST",
    passthroughBehavior: "WHEN_NO_MATCH",
    uri: "arn:aws:apigateway:" + region + ":lambda:path/2015-03-31/functions/" + lambda.arn + "/invocations",
});

let deployment = new aws.apigateway.Deployment("myrestapi-deployment-prod", {
    restApi: restApi,
    description: "my deployment",
    stageName: "prod",
});

