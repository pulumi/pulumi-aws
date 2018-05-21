import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/16",
});

const subnet = new aws.ec2.Subnet("subnet", {
    cidrBlock: "10.0.2.0/24", // <- changing the subnet cidrBlock triggers replacement
    vpcId: vpc.id,            //    which triggers the DBR replacement of MountTarget
});

const fs = new aws.efs.FileSystem("fs");
const mountTarget = new aws.efs.MountTarget("mt", {
    fileSystemId: fs.id,
    subnetId: subnet.id,
});

const size: aws.ec2.InstanceType = "t2.micro";
const instance = new aws.ec2.Instance("dummy-instance", {
    userData: mountTarget.dnsName.apply(dnsName => {
        return `#!/bin/bash
echo ${dnsName}`
    }),
    ami: getLinuxAMI(size),
    instanceType: size,
});

export const dnsName = instance.publicDns;
