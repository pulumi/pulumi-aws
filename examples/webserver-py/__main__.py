# Copyright 2016-2020, Pulumi Corporation.  All rights reserved.

import pulumi
from pulumi_aws import ec2
from ami import get_linux_ami

size = ec2.InstanceType.T2_MICRO

group = ec2.SecurityGroup('web-secgrp',
    description='Enable HTTP access',
    ingress=[
        ec2.SecurityGroupIngressArgs(protocol='tcp', from_port=80, to_port=80, cidr_blocks=['0.0.0.0/0'])
    ])
server = ec2.Instance('web-server-www',
    instance_type=size,
    security_groups=[group.name],
    ami=get_linux_ami(size))

pulumi.export('public_ip', server.public_ip)
pulumi.export('public_dns', server.public_dns)
