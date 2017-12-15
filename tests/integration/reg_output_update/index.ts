// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("test", {
    cidrBlock: "10.10.0.0/16",
    enableDnsHostnames: true,
    enableDnsSupport: true,
});
let targetGroup = new aws.elasticloadbalancingv2.TargetGroup("test", {
    vpcId: vpc.id,
    port: 1234,
    protocol: "TCP",
    deregistrationDelay: 30,
});
