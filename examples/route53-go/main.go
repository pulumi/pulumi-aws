// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/route53"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
	"github.com/pulumi/pulumi/sdk/go/pulumi/config"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		cfg := config.New(ctx, "aws")
		region := cfg.Require("envRegion")
		provider, err := aws.NewProvider(ctx, "prov", &aws.ProviderArgs{
			Region: pulumi.String(region),
		})
		if err != nil {
			return err
		}
		providerOpts := []pulumi.ResourceOption{pulumi.Provider(provider)}

		zone, err := route53.NewZone(ctx, "example.com", &route53.ZoneArgs{}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = route53.NewRecord(ctx, "www-dev", &route53.RecordArgs{
			Name:          pulumi.String("www"),
			Records:       pulumi.StringArray{pulumi.String("dev.example.com")},
			SetIdentifier: pulumi.String("dev"),
			Ttl:           pulumi.Int(5),
			Type:          pulumi.String("CNAME"),
			WeightedRoutingPolicies: route53.RecordWeightedRoutingPolicyArray{
				route53.RecordWeightedRoutingPolicyArgs{Weight: pulumi.Int(10)},
			},
			ZoneId: zone.ZoneId,
		}, providerOpts...)
		if err != nil {
			return err
		}

		return nil
	})
}
