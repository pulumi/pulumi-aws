// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

const size = aws.ec2.InstanceType.T2_Micro;

let vpc = new aws.ec2.DefaultVpc("ts-web-default-vpc", {
    tags: {
        Name: "Default VPC",
    },
}, providerOpts);

let subnet = new aws.ec2.DefaultSubnet("ts-web-default-subnet", {
    availabilityZone: "us-west-2a",
    tags: {
        Name: "Default subnet for us-west-2a",
    },
}, providerOpts);

let group = new aws.ec2.SecurityGroup("ts-web-secgrp-2", {
    vpcId: vpc.id,
    description: "Enable HTTP access",
    ingress: [
        { protocol: aws.ec2.ProtocolType.TCP, fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
}, providerOpts);

let server = new aws.ec2.Instance("web-server-www", {
    instanceType: size,
    vpcSecurityGroupIds: [ group.id ],
    ami: getLinuxAMI(size, region),
    subnetId: subnet.id,
}, providerOpts);

export let publicIp = server.publicIp;
export let publicDns = server.publicDns;
