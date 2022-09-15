// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

export let size: aws.ec2.InstanceType = "t2.micro";

let vpc = new aws.ec2.DefaultVpc("ts-web-default-zones-vpc", {
    tags: {
        Name: "Default VPC",
    },
}, providerOpts);

let subnet = new aws.ec2.DefaultSubnet("ts-web-default-zones-subnet", {
    availabilityZone: "us-west-2a",
    tags: {
        Name: "Default subnet for us-west-2a",
    },
}, providerOpts);

let group = new aws.ec2.SecurityGroup("ts-web-secgrp-http", {
    vpcId: vpc.id,
    description: "Enable HTTP access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

// start an instance in each availability zone:
(async () => {
    let zones: string[] = (await aws.getAvailabilityZones(undefined, { ...providerOpts, async: true })).names.
        filter(x => !x.endsWith("d"));
    for (let i = 0; i < zones.length; i++) {
        let server = new aws.ec2.Instance("web-server-www-" + i, {
            availabilityZone: zones[i],
            instanceType: size,
            vpcSecurityGroupIds: [ group.id ],
            ami: getLinuxAMI(size, region),
            subnetId: subnet.id,
        }, providerOpts);
    }
})();
