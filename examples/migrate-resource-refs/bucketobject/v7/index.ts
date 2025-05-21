import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

// Create an S3 bucket
const bucket = new aws.s3.Bucket("test-bucket", {
    forceDestroy: true,
});

const s3Object = new aws.s3.BucketObjectv2("test-object", {
    bucket: bucket.id,
    key: "test.txt",
    source: new pulumi.asset.StringAsset("Hello, this is a test file!"),
    contentType: "text/plain",
});

export const bucketName = bucket.id;