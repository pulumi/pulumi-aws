// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

export let size: aws.ec2.InstanceType = "t2.micro";

let group = new aws.ec2.SecurityGroup("ts-web-secgrp-all", {
    description: "Enable HTTP and SSH access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
        { protocol: "tcp", fromPort: 22, toPort: 22, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

let server = new aws.ec2.Instance("web-server-www", {
    instanceType: size,
    securityGroups: [ group.name ],
    ami: getLinuxAMI(size, region),
}, providerOpts);
