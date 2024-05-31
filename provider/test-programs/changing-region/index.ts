import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const cfg = new pulumi.Config();

export const desiredRegion: string|undefined = cfg.get("desired-region");

function parseRegion(region: string|undefined): aws.Region|undefined {
    if (region === undefined) {
        return undefined;
    }
    var r: any = region;
    return r;
}

const opts: pulumi.ResourceOptions =
    desiredRegion
    ? {provider: new aws.Provider("myprovider", {region: parseRegion(desiredRegion)})}
    : {};

const queue = new aws.sqs.Queue("my-queue", {}, opts)

export const actualRegion = queue.arn.apply(x => x.split(":")[3]);
