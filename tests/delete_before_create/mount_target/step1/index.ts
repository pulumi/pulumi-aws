import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/16",
});

const subnet = new aws.ec2.Subnet("subnet", {
    cidrBlock: "10.0.1.0/24",
    vpcId: vpc.id,
});

const fs = new aws.efs.FileSystem("fs");
const mountTarget = new aws.efs.MountTarget("mt", {
    fileSystemId: fs.id,
    subnetId: subnet.id,
});

const size: aws.ec2.InstanceType = "t2.micro";
const instance = new aws.ec2.Instance("dummy-instance", {
    userData: mountTarget.dnsName.apply((dnsName: string) => {
        return `#!/bin/bash
echo ${dnsName}`
    }),
    ami: getLinuxAMI(size),
    instanceType: size,
});

export const dnsName = instance.publicDns;
