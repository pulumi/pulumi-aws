import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const host = new aws.ec2.DedicatedHost("test-dedi-host", {
    availabilityZone: "us-west-2a",
    hostRecovery: "off",
    instanceFamily: "a1",
    autoPlacement: "on",
    tags: {
        "Foo": "bar",
    },
}, providerOpts);

export const hostId = host.id;
