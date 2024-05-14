// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

let vpc = new aws.ec2.DefaultVpc("ts-web-comp-default-vpc", {
    tags: {
        Name: "Default VPC",
    },
}, providerOpts);

let subnet = new aws.ec2.DefaultSubnet("ts-web-comp-default-subnet", {
    availabilityZone: "us-west-2a",
    tags: {
        Name: "Default subnet for us-west-2a",
    },
}, providerOpts);

let group = new aws.ec2.SecurityGroup("web-secgrp-comp", {
    vpcId: vpc.id,
    description: "Enable HTTP access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

const ami = aws.ec2.getAmiOutput({
    owners: ["amazon"],
    mostRecent: true,
    filters: [{
        name: "name",
        values: ["amzn2-ami-hvm-*-x86_64-ebs"],
    }],
});

export class Server {
    public readonly instance: aws.ec2.Instance;

    constructor(name: string, size: aws.ec2.InstanceType) {
        this.instance = new aws.ec2.Instance("web-server-" + name, {
            instanceType: size,
            vpcSecurityGroupIds: [ group.id ],
            ami: ami.id,
            subnetId: subnet.id,
        }, providerOpts);
    }
}

export class Micro extends Server {
    constructor(name: string) {
        super(name, aws.ec2.InstanceType.T2_Micro);
    }
}

export class Nano extends Server {
    constructor(name: string) {
        super(name, aws.ec2.InstanceType.T2_Nano);
    }
}
