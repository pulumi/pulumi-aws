// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

export let size: aws.ec2.InstanceType = "t2.micro";

let group = new aws.ec2.SecurityGroup("web-secgrp", {
    description: "Enable HTTP access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
});

let server = new aws.ec2.Instance("web-server-www", {
    instanceType: size,
    securityGroups: [ group.name ],
    ami: aws.ec2.getLinuxAMI(size),
});

