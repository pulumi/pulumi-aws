// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import { Output } from "@pulumi/pulumi";
import { getLinuxAMI } from "./linuxAmi";

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
    ami: getLinuxAMI(size),
});

// Look up the server just created, using the get method.  And then export its properties.
let server2 = aws.ec2.Instance.get("web-server-www-2", server.id);

export let publicIp: Output<string> = server2.publicIp;
export let publicDns: Output<string> = server2.publicDns;
