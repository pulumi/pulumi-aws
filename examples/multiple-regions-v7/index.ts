// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const size = aws.ec2.InstanceType.T2_Micro;
const amiParamName = "/aws/service/ami-amazon-linux-latest/amzn-ami-hvm-x86_64-ebs";

const provider = new aws.Provider('provider-us-west-2', {
    region: 'us-west-2',
}, { aliases: [{name: 'provider-us-east-1'}]});
function createServer(region?: aws.Region): aws.ec2.Instance {
    const amiParam = aws.ssm.getParameter({
        name: amiParamName,
        region,
    }, { provider });

    let vpc = new aws.ec2.DefaultVpc(`ts-multiple-regions-default-vpc-${region ?? 'us-west-2'}`, {
        region,
        tags: {
            Name: "Default VPC",
        },
    }, { provider });

    let subnet = new aws.ec2.DefaultSubnet(`ts-multiple-regions-default-subnet-${region ?? 'us-west-2'}`, {
        region,
        availabilityZone: `${region ?? 'us-west-2'}a`,
        tags: {
            Name: `Default subnet for ${region ?? 'us-west-2'}a`,
        },
    }, { provider });

    const group = new aws.ec2.SecurityGroup(`secgrp-${region ?? 'us-west-2'}`, {
        region,
        vpcId: vpc.id,
        description: "Enable HTTP access",
        ingress: [
            { protocol: "tcp", fromPort: 80, toPort: 80, cidrBlocks: ["0.0.0.0/0"] },
        ],
    }, { provider });

    return new aws.ec2.Instance(`web-server-www-${region ?? 'us-west-2'}`, {
        region,
        instanceType: size,
        vpcSecurityGroupIds: [ group.id ],
        ami: amiParam.then(p => p.value),
        subnetId: subnet.id,
    }, { provider });
}

const west2Server = createServer();
const east1Server = createServer("us-east-1");

export const servers = {
    'us-east-1': {
        publicDns: east1Server.publicDns,
        publicIp: east1Server.publicIp,
    },
    'us-west-2': {
        publicDns: west2Server.publicDns,
        publicIp: west2Server.publicIp,

    }

}
