# Copyright 2016-2020, Pulumi Corporation.  All rights reserved.

import pulumi
from pulumi_aws import ec2
from ami import get_linux_ami

vpc = ec2.DefaultVpc("py-web-default-vpc", tags={
    "Name": "Default VPC",
})

subnet = ec2.DefaultSubnet("py-web-default-subnet",
    availability_zone="us-west-2a",
    tags={
     "Name": "Default subnet for us-west-2a",
    })


size = ec2.InstanceType.T2_MICRO

group = ec2.SecurityGroup('py-web-secgrp',
    vpc_id=vpc.id,
    description='Enable HTTP access',
    ingress=[
        ec2.SecurityGroupIngressArgs(protocol='tcp', from_port=80, to_port=80, cidr_blocks=['0.0.0.0/0'])
    ])
server = ec2.Instance('web-server-www',
    instance_type=size,
    vpc_security_group_ids=[group.id],
    ami=get_linux_ami(size),
    subnet_id=subnet.id)

pulumi.export('public_ip', server.public_ip)
pulumi.export('public_dns', server.public_dns)
