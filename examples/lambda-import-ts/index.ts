import * as pulumi from "@pulumi/pulumi";
import * as archive from "@pulumi/archive";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const imported_lambda_name = config.get("lambda_name");
const imported_lambda_role = config.get("lambda_role");
const lambdaRegion = config.get("lambda_region");

const runtime = config.get("runtime");

const provider = new aws.Provider('aws', {
    region: aws.config.requireRegion(),
});

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
const iamForLambda = new aws.iam.Role(
    "iamForLambda",
    {
        assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json),
    },
    {
        provider,
        import: imported_lambda_role,
    }
);
const lambda = archive.getFile({
    type: "zip",
    sourceFile: "lambda.js",
    outputPath: "lambda_function_payload.zip",
});

const opts: pulumi.CustomResourceOptions = {
    provider,
}
if (imported_lambda_name) {
    opts.import = imported_lambda_name;
    opts.ignoreChanges = ["code", "filename", "s3_bucket", "source_code_hash", "image_uri"];
}
const testLambda = new aws.lambda.Function("testLambda", {
    region: lambdaRegion,
    // name: imported_lambda_name,
    code: imported_lambda_name ? undefined : new pulumi.asset.FileArchive("lambda_function_payload.zip"),
    role: iamForLambda.arn,
    handler: "index.test",
    runtime: runtime || "nodejs18.x",
    environment: {
        variables: {
            foo: "bar",
        },
    },
}, opts);

export const lambda_name = testLambda.name;
export const lambda_role = iamForLambda.name
