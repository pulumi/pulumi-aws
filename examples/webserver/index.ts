// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { Output } from "@pulumi/pulumi";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

const size = aws.ec2.InstanceType.T2_Micro;

let group = new aws.ec2.SecurityGroup("web-secgrp-2", {
    description: "Enable HTTP access",
    ingress: [
        { protocol: aws.ec2.TCPProtocol, fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

let server = new aws.ec2.Instance("web-server-www", {
    instanceType: size,
    securityGroups: [ group.name ],
    ami: getLinuxAMI(size, region),
}, providerOpts);

export let publicIp = server.publicIp;
export let publicDns = server.publicDns;
