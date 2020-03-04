// Copyright 2016-2020, Pulumi Corporation.
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

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/applicationloadbalancing"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
	"github.com/pulumi/pulumi/sdk/go/pulumi/config"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		cfg := config.New(ctx, "aws")
		provider, err := aws.NewProvider(ctx, "prov", &aws.ProviderArgs{
			Region: pulumi.String(cfg.Require("envRegion")),
		})
		if err != nil {
			return err
		}
		providerOpts := []pulumi.ResourceOption{pulumi.Provider(provider)}

		vpc, err := ec2.NewVpc(ctx, "text", &ec2.VpcArgs{
			CidrBlock:          pulumi.String("10.10.0.0/16"),
			EnableDnsHostnames: pulumi.Bool(true),
			EnableDnsSupport:   pulumi.Bool(true),
		}, providerOpts...)
		if err != nil {
			return err
		}

		internetGateway, err := ec2.NewInternetGateway(ctx, "test", &ec2.InternetGatewayArgs{
			VpcId: vpc.ID(),
		})
		if err != nil {
			return err
		}

		routeTable, err := ec2.NewRouteTable(ctx, "test", &ec2.RouteTableArgs{
			VpcId: vpc.ID(),
			Routes: ec2.RouteTableRouteArray{
				ec2.RouteTableRouteArgs{
					CidrBlock: pulumi.String("0.0.0.0/0"),
					GatewayId: internetGateway.ID(),
				},
			},
		}, providerOpts...)
		if err != nil {
			return err
		}

		azs, err := aws.GetAvailabilityZones(ctx, &aws.GetAvailabilityZonesArgs{}, pulumi.Provider(provider))
		if err != nil {
			return err
		}

		subnet0, err := ec2.NewSubnet(ctx, "test0", &ec2.SubnetArgs{
			VpcId:               vpc.ID(),
			AvailabilityZone:    pulumi.String(azs.Names[0]),
			CidrBlock:           pulumi.String("10.10.0.0/24"),
			MapPublicIpOnLaunch: pulumi.Bool(true),
		}, providerOpts...)
		if err != nil {
			return err
		}

		subnet1, err := ec2.NewSubnet(ctx, "test1", &ec2.SubnetArgs{
			VpcId:               vpc.ID(),
			AvailabilityZone:    pulumi.String(azs.Names[1]),
			CidrBlock:           pulumi.String("10.10.1.0/24"),
			MapPublicIpOnLaunch: pulumi.Bool(true),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = ec2.NewRouteTableAssociation(ctx, "test0", &ec2.RouteTableAssociationArgs{
			SubnetId:     subnet0.ID(),
			RouteTableId: routeTable.ID(),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = ec2.NewRouteTableAssociation(ctx, "test1", &ec2.RouteTableAssociationArgs{
			SubnetId:     subnet1.ID(),
			RouteTableId: routeTable.ID(),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = applicationloadbalancing.NewLoadBalancer(ctx, "test", &applicationloadbalancing.LoadBalancerArgs{
			LoadBalancerType: pulumi.String("application"),
			Internal:         pulumi.Bool(false),
			Subnets:          pulumi.StringArray{subnet0.ID(), subnet1.ID()},
		}, providerOpts...)
		if err != nil {
			return err
		}

		return nil
	})
}
