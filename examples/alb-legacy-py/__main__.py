# Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

import pulumi
from pulumi_aws import applicationloadbalancing, ec2, get_aws_az

vpc = ec2.Vpc('test',
    cidr_block="10.10.0.0/16",
    enable_dns_hostnames=True,
    enable_dns_support=True)

subnet0 = ec2.Subnet("test0",
    vpc_id=vpc.id,
    availability_zone=get_aws_az(0),
    cidr_block="10.10.0.0/24",
    map_public_ip_on_launch=True)

subnet1 = ec2.Subnet("test1",
    vpc_id=vpc.id,
    availability_zone=get_aws_az(1),
    cidr_block="10.10.1.0/24",
    map_public_ip_on_launch=True)

group = applicationloadbalancing.LoadBalancer('test',
    load_balancer_type='application',
    internal=False,
    subnets=[subnet0.id, subnet1.id])
