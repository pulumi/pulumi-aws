# Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

from pulumi_aws import ec2
from ami import get_linux_ami

size = 't2.micro'

def main():
    group = ec2.SecurityGroup('web-secgrp',
        description='Enable HTTP access',
        ingress=[
            { 'protocol': 'tcp', 'from_port': 80, 'to_port': 80, 'cidr_blocks': ['0.0.0.0/0'] }
        ])
    server = ec2.Instance('web-server-www',
        instance_type=size,
        security_groups=[group],
        ami=get_linux_ami(size))

if __name__ == '__main__':
    main()
