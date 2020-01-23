// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
	"github.com/pulumi/pulumi/sdk/go/pulumi/config"
)

var region string

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		cfg := config.New(ctx, "aws")
		region = cfg.Require("envRegion")
		provider, err := aws.NewProvider(ctx, "prov", &aws.ProviderArgs{
			Region: pulumi.String(region),
		})
		if err != nil {
			return err
		}
		providerOpts := []pulumi.ResourceOption{pulumi.Provider(provider)}

		group, err := ec2.NewSecurityGroup(ctx, "web-secgrp", &ec2.SecurityGroupArgs{
			Description: pulumi.String("Enable HTTP access"),
			Ingress: ec2.SecurityGroupIngressArray{
				ec2.SecurityGroupIngressArgs{
					Protocol:   pulumi.String("tcp"),
					FromPort:   pulumi.Int(80),
					ToPort:     pulumi.Int(80),
					CidrBlocks: pulumi.StringArray{pulumi.String("0.0.0.0/0")},
				},
			},
		}, providerOpts...)
		if err != nil {
			return err
		}

		securityGroups := pulumi.StringArray{group.Name}

		webServer, err := NewMicroServer(ctx, "www", securityGroups, providerOpts...)
		if err != nil {
			return err
		}

		appServer, err := NewNanoServer(ctx, "app", securityGroups, providerOpts...)
		if err != nil {
			return err
		}

		ctx.Export("webPublicIp", webServer.Instance.PublicIp)
		ctx.Export("appPublicIp", appServer.Instance.PublicIp)
		return nil
	})
}
