import * as pulumi from "@pulumi/pulumi";
import * as archive from "@pulumi/archive";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const imported_lambda_name = config.get("lambda_name");
const imported_lambda_role = config.get("lambda_role");

const runtime = config.get("runtime");

const assumeRole = aws.iam.getPolicyDocument({
    statements: [{
        effect: "Allow",
        principals: [{
            type: "Service",
            identifiers: ["lambda.amazonaws.com"],
        }],
        actions: ["sts:AssumeRole"],
    }],
});
const iamForLambda = new aws.iam.Role("iamForLambda", {assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json)});
const lambda = archive.getFile({
    type: "zip",
    sourceFile: "lambda.js",
    outputPath: "lambda_function_payload.zip",
});

const testLambda = new aws.lambda.Function("testLambda", {
    name: imported_lambda_name,
    code: new pulumi.asset.FileArchive("lambda_function_payload.zip"),
    role: imported_lambda_role || iamForLambda.arn,
    handler: "index.test",
    runtime: runtime || "nodejs18.x",
    environment: {
        variables: {
            foo: "bar",
        },
    },
}, imported_lambda_name ? {
    import: imported_lambda_name, ignoreChanges: ["code", "filename", "s3_bucket", "source_code_hash", "image_uri"]
} : undefined);

export const lambda_name = testLambda.name;
export const lambda_role = testLambda.role;