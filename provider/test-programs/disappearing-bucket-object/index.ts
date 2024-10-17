import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const cfg = new pulumi.Config();
const b = new aws.s3.BucketV2("my-bucket", {});

if (cfg.get("bucket-object") !== "exclude") {
    const o = new aws.s3.BucketObjectv2("obj", {
        bucket: b.bucket,
        key: "index.ts",
        source: new pulumi.asset.FileAsset("index.ts"),
    });
}
