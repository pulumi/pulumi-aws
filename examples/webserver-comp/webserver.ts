// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

let group = new aws.ec2.SecurityGroup("web-secgrp", {
    description: "Enable HTTP access",
    ingresses: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
});

export class Server {
    public readonly instance: aws.ec2.Instance;

    constructor(name: string, size: aws.ec2.InstanceType) {
        this.instance = new aws.ec2.Instance("web-server-" + name, {
            instanceType: size,
            securityGroups: [ group.name ],
            ami: aws.ec2.getLinuxAMI(size),
        });
    }
}

export class Micro extends Server {
    constructor(name: string) {
        super(name, "t2.micro");
    }
}

export class Nano extends Server {
    constructor(name: string) {
        super(name, "t2.nano");
    }
}

