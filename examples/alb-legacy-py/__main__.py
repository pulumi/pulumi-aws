# Copyright 2016-2020, Pulumi Corporation.  All rights reserved.

import pulumi

from pulumi import Output
from pulumi_aws import applicationloadbalancing, get_availability_zones, ec2

vpc = ec2.Vpc('test',
    cidr_block="10.11.0.0/16",
    enable_dns_hostnames=True,
    enable_dns_support=True)

internet_gateway = ec2.InternetGateway('test',
    vpc_id=vpc.id)

route_table = ec2.RouteTable('test',
    vpc_id=vpc.id,
    routes=[ec2.RouteTableRouteArgs(
        cidr_block="0.0.0.0/0",
        gateway_id=internet_gateway.id
    )])

zones = Output.from_input(get_availability_zones())
zone_names = zones.apply(
    lambda zs: zs.names)

subnet0 = ec2.Subnet("test0",
    vpc_id=vpc.id,
    availability_zone=zone_names.apply(lambda names: names[0]),
    cidr_block="10.11.0.0/24",
    map_public_ip_on_launch=True)

subnet1 = ec2.Subnet("test1",
    vpc_id=vpc.id,
    availability_zone=zone_names.apply(lambda names: names[1]),
    cidr_block="10.11.1.0/24",
    map_public_ip_on_launch=True)

route_table_association0 = ec2.RouteTableAssociation('test0',
    subnet_id=subnet0.id,
    route_table_id=route_table.id)

route_table_association1 = ec2.RouteTableAssociation('test1',
    subnet_id=subnet1.id,
    route_table_id=route_table.id)

group = applicationloadbalancing.LoadBalancer('test',
    load_balancer_type='application',
    internal=False,
    subnets=[subnet0.id, subnet1.id])
