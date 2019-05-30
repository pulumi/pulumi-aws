import * as aws from "@pulumi/aws";

const bucket = new aws.s3.Bucket("created-with-role");

export const bucketArn = bucket.arn;
