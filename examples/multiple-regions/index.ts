// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const size = aws.ec2.InstanceType.T2_Micro;
const amiParamName = "/aws/service/ami-amazon-linux-latest/amzn-ami-hvm-x86_64-ebs";

function createServer(region: aws.Region): aws.ec2.Instance {
    const provider = new aws.Provider(`provider-${region}`, { region });

    const amiParam = aws.ssm.getParameter({ name: amiParamName }, { provider });

    let vpc = new aws.ec2.DefaultVpc(`ts-multiple-regions-default-vpc-${region}`, {
        tags: {
            Name: "Default VPC",
        },
    }, { provider });

    let subnet = new aws.ec2.DefaultSubnet(`ts-multiple-regions-default-subnet-${region}`, {
        availabilityZone: `${region}a`,
        tags: {
            Name: `Default subnet for ${region}a`,
        },
    }, { provider });

    const group = new aws.ec2.SecurityGroup(`secgrp-${region}`, {
        vpcId: vpc.id,
        description: "Enable HTTP access",
        ingress: [
            { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
        ],
    }, { provider });

    return new aws.ec2.Instance(`web-server-www-${region}`, {
        instanceType: size,
        vpcSecurityGroupIds: [ group.id ],
        ami: amiParam.then(p => p.value),
        subnetId: subnet.id,
    }, { provider });
}

export const servers: any = {};
for (const region of [ "us-west-2", "us-east-1" ]) {
    const server = createServer(<aws.Region>region);
    servers[region] = { publicIp: server.publicIp, publicDns: server.publicDns };
}
