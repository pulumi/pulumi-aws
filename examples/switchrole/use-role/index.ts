import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const bucket = new aws.s3.Bucket("created-with-role", {}, providerOpts);

export const bucketArn = bucket.arn;
