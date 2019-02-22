// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import { getLinuxAMI } from "./linuxAmi";

export let size: aws.ec2.InstanceType = "t2.micro";

let group = new aws.ec2.SecurityGroup("web-secgrp", {
    description: "Enable HTTP access",
    ingress: [
        { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
    ],
});

// start an instance in each availability zone:
(async () => {
    let zones: string[] = (await aws.getAvailabilityZones()).names.
        filter(x => !x.endsWith("d"));
    for (let i = 0; i < zones.length; i++) {
        let server = new aws.ec2.Instance("web-server-www-" + i, {
            availabilityZone: zones[i],
            instanceType: size,
            securityGroups: [ group.name ],
            ami: getLinuxAMI(size),
        });
    }
})();
