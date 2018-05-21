import * as aws from "@pulumi/aws";
import { asset } from "@pulumi/pulumi";
let region = aws.config.requireRegion();

// Shamelessly stolen from examples/serverless-raw

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
});
let fullAccess = new aws.iam.RolePolicyAttachment("mylambda-access", {
    role: role,
    policyArn: aws.iam.AWSLambdaFullAccess,
});
let lambda = new aws.lambda.Function("mylambda", {
    code: new asset.AssetArchive({
        "index.js": new asset.StringAsset(
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
    name: "replaceme-again",
    retentionInDays: 7,
});

let logcollector = new aws.lambda.Function("mylambda-logcollector", {
    code: new asset.AssetArchive({
        "index.js": new asset.StringAsset(
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
