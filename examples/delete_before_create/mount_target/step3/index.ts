import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: config.require("envRegion") }) };

const vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/16",
},providerOpts);

const subnet = new aws.ec2.Subnet("subnet", {
    cidrBlock: "10.0.3.0/24", // <- changing the subnet cidrBlock triggers replacement
    vpcId: vpc.id,            //    which triggers the DBR replacement of MountTarget
                              //    this time, though, the instance is deleted and not replaced later
}, providerOpts);

const fs = new aws.efs.FileSystem("fs", {}, providerOpts);
const mountTarget = new aws.efs.MountTarget("mt", {
    fileSystemId: fs.id,
    subnetId: subnet.id,
}, providerOpts);

export const dns = mountTarget.dnsName;
