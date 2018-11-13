// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	awsconfig "github.com/pulumi/pulumi-aws/sdk/go/aws/config"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
)

const size = "t2.micro"

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		group, err := ec2.NewSecurityGroup(ctx, "web-secgrp-2", &ec2.SecurityGroupArgs{
			Description: "Enable HTTP access",
			Ingress: []map[string]interface{}{
				{
					"protocol":   "tcp",
					"fromPort":   80,
					"toPort":     80,
					"cidrBlocks": []string{"0.0.0.0/0"},
				},
			},
		})
		if err != nil {
			return err
		}

		server, err := ec2.NewInstance(ctx, "web-server-www", &ec2.InstanceArgs{
			InstanceType: size,
			SecurityGroups: group.Name().Apply(func(name string) (interface{}, error) {
				return []interface{}{name}, nil
			}),
			Ami: getLinuxAMI(awsconfig.GetRegion(ctx), size),
		})
		if err != nil {
			return err
		}

		ctx.Export("publicIp", server.PublicIp())
		ctx.Export("publicDns", server.PublicDns())
		return nil
	})
}
