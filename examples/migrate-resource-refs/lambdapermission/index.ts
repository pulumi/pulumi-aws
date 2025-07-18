import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const lambdaRole = new aws.iam.Role("lambda-role", {
    assumeRolePolicy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: "sts:AssumeRole",
            Effect: "Allow",
            Principal: {
                Service: "lambda.amazonaws.com",
            },
        }],
    }),
});

const lambdaPolicy = new aws.iam.RolePolicyAttachment("lambda-policy", {
    role: lambdaRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole",
});

const lambda = new aws.lambda.Function("test-lambda", {
    runtime: "nodejs18.x",
    handler: "index.handler",
    role: lambdaRole.arn,
    code: new pulumi.asset.AssetArchive({
        "index.js": new pulumi.asset.StringAsset(`
            exports.handler = async (event) => {
                return { message: "Hello from Lambda!" };
            };
        `),
    }),
});

const permission = new aws.lambda.Permission("test-permission", {
    action: "lambda:InvokeFunction",
    function: lambda,
    principal: "s3.amazonaws.com",
    sourceArn: "arn:aws:s3:::test-bucket"
});

export const functionName = lambda.name;