import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const region = <aws.Region>config.require("envRegion");
const providerOpts = { provider: new aws.Provider("prov", { region }) };

const vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/16",
}, providerOpts);

const subnet = new aws.ec2.Subnet("subnet", {
    cidrBlock: "10.0.1.0/24",
    vpcId: vpc.id,
}, providerOpts);

const fs = new aws.efs.FileSystem("fs", {}, providerOpts);
const mountTarget = new aws.efs.MountTarget("mt", {
    fileSystemId: fs.id,
    subnetId: subnet.id,
}, providerOpts);

const size = aws.ec2.InstanceType.T2_Micro;
const instance = new aws.ec2.Instance("dummy-instance", {
    userData: pulumi.interpolate `#!/bin/bash
echo ${mountTarget.dnsName}`,
    ami: getLinuxAMI(size, region),
    instanceType: size,
}, providerOpts);

export const dnsName = instance.publicDns;
