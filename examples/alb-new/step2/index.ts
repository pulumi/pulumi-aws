// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const vpc = new aws.ec2.Vpc('test', {
    cidrBlock: "10.12.0.0/16",
    enableDnsHostnames: true,
    enableDnsSupport: true,
}, providerOpts)

const internet_gateway = new aws.ec2.InternetGateway('test', {
    vpcId: vpc.id,
}, providerOpts);

const route_table = new aws.ec2.RouteTable('test', {
    vpcId: vpc.id,
    routes: [{
        "cidrBlock": "0.0.0.0/0",
        "gatewayId": internet_gateway.id
    }],
}, providerOpts);

const subnet0 =new aws.ec2.Subnet("test0", {
    vpcId: vpc.id,
    availabilityZone: aws.getAvailabilityZones(undefined, providerOpts).then(azs => azs.names[0]),
    cidrBlock: "10.12.0.0/24",
    mapPublicIpOnLaunch: true,
}, providerOpts);

const subnet1 = new aws.ec2.Subnet("test1", {
    vpcId: vpc.id,
    availabilityZone: aws.getAvailabilityZones(undefined, providerOpts).then(azs => azs.names[1]),
    cidrBlock: "10.12.1.0/24",
    mapPublicIpOnLaunch: true,
}, providerOpts);

const route_table_association0 = new aws.ec2.RouteTableAssociation('test0', {
    subnetId: subnet0.id,
    routeTableId: route_table.id,
}, providerOpts);

const route_table_association1 = new aws.ec2.RouteTableAssociation('test1', {
    subnetId: subnet1.id,
    routeTableId: route_table.id,
}, providerOpts);

// switching to 'lb' should not cause the load balancer to be recreated.
const group = new aws.lb.LoadBalancer('test', {
    loadBalancerType: 'application',
    internal: false,
    subnets: [subnet0.id, subnet1.id],
}, providerOpts);
