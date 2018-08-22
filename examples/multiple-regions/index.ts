// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

let size: aws.ec2.InstanceType = "t2.micro";
let amiParamName = "/aws/service/ami-amazon-linux-latest/amzn-ami-hvm-x86_64-ebs";

function createServer(region: aws.Region): aws.ec2.Instance {
    const provider = new aws.Provider(`provider-${region}`, { region: region });

    const amiParam = aws.ssm.getParameter({ name: amiParamName }, { provider: provider });

    const group = new aws.ec2.SecurityGroup(`secgrp-${region}`, {
        description: "Enable HTTP access",
        ingress: [
            { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
        ],
    }, { provider: provider });

    return new aws.ec2.Instance(`web-server-www-${region}`, {
        instanceType: size,
        securityGroups: [ group.name ],
        ami: amiParam.then(p => p.value ),
    }, { provider: provider });
}

export const servers: any = {};
for (const region of [ aws.config.region, "us-east-1" ]) {
    const server = createServer(<aws.Region>region);
    servers[region] = { publicIp: server.publicIp, publicDns: server.publicDns };
}
