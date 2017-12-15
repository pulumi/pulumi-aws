// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("test", {
    cidrBlock: "10.10.0.0/16",
    enableDnsHostnames: true,
    enableDnsSupport: true,
});

// Change the target group's deregistrationDelay from 30 to 180.  This will trigger an update where we need to
// ensure the output properties from the initial creation are applied, else a Check/Diff failure would occur.

let targetGroup = new aws.elasticloadbalancingv2.TargetGroup("test", {
    vpcId: vpc.id,
    port: 1234,
    protocol: "TCP",
    deregistrationDelay: 180,
});
