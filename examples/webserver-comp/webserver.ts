// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: config.require("envRegion") }) };

let group = new aws.ec2.SecurityGroup("web-secgrp", {
    description: "Enable HTTP access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

export class Server {
    public readonly instance: aws.ec2.Instance;

    constructor(name: string, size: aws.ec2.InstanceType) {
        this.instance = new aws.ec2.Instance("web-server-" + name, {
            instanceType: size,
            securityGroups: [ group.name ],
            ami: getLinuxAMI(size),
        }, providerOpts);
    }
}

export class Micro extends Server {
    constructor(name: string) {
        super(name, aws.ec2.InstanceTypes.T2_Micro);
    }
}

export class Nano extends Server {
    constructor(name: string) {
        super(name, aws.ec2.InstanceTypes.T2_Nano);
    }
}

