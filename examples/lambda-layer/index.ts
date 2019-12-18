// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { asset } from "@pulumi/pulumi";

const config = new pulumi.Config();
const azCount = config.getNumber("azCount") || 2;

const available = aws.getAvailabilityZones();
const mainVpc = new aws.ec2.Vpc("main", {
    cidrBlock: "10.10.0.0/16",
});
const mainSubnet: aws.ec2.Subnet[] = [];
for (let i = 0; i < azCount; i++) {
    mainSubnet.push(new aws.ec2.Subnet(`main-${i}`, {
        availabilityZone: available.names[i],
        cidrBlock: mainVpc.cidrBlock.apply(cidrBlock => {
            throw "tf2pulumi error: NYI: call to cidrsubnet";
        }),
        // cidrBlock: mainVpc.cidrBlock.apply(cidrBlock => (() => {
        //     throw "tf2pulumi error: NYI: call to cidrsubnet";
        //     return (() => { throw "NYI: call to cidrsubnet"; })();
        // })()),
        vpcId: mainVpc.id,
    }));
}