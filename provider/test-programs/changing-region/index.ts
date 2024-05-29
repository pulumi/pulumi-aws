import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const cfg = new pulumi.Config();
const reg: aws.Region = cfg.require("desired-region");

const awsProvider = new aws.Provider("myprovider", {
    region: reg,
});

const queue = new aws.sqs.Queue("my-queue", {}, { provider: awsProvider })

export const desiredRegion = reg;
export const actualRegion = queue.arn.apply(x => x.split(":")[3]);
