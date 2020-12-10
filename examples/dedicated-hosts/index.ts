import * as aws from "@pulumi/aws";

const host = new aws.ec2.DedicatedHost("test-dedi-host", {
    availabilityZone: "us-west-2a",
    hostRecovery: "off",
    instanceFamily: "a1",
    autoPlacement: "on",
    tags: {
        "Foo": "bar",
    },
});

export const hostId = host.id;
