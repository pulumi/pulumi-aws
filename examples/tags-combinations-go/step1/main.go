// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

package main

import (
	"encoding/json"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appconfig"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ec2"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
)

type state struct {
	DefaultTags  map[string]string `json:"defaultTags"`
	ResourceTags map[string]string `json:"resourceTags"`
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		conf := config.New(ctx, "")
		tagsState := conf.Require("state2")

		var s state

		err := json.Unmarshal([]byte(tagsState), &s)
		if err != nil {
			return err
		}

		tagsMap := pulumi.StringMap{}
		for k, v := range s.ResourceTags {
			tagsMap[k] = pulumi.String(v)
		}

		defaultTagsMap := pulumi.StringMap{}
		for k, v := range s.DefaultTags {
			defaultTagsMap[k] = pulumi.String(v)
		}

		p, err := aws.NewProvider(ctx, "prov", &aws.ProviderArgs{
			DefaultTags: aws.ProviderDefaultTagsArgs{
				Tags: defaultTagsMap,
			},
		})
		if err != nil {
			return err
		}

		vpc, err := ec2.NewVpc(ctx, "mainvpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.0.0.0/16"),
			Tags:      tagsMap,
		}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		bucket, err := s3.NewBucketV2(ctx, "bucketv2", &s3.BucketV2Args{
			Tags: tagsMap,
		}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		legacyBucket, err := s3.NewBucket(ctx, "bucketlegacy", &s3.BucketArgs{
			Tags: tagsMap,
		}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		app, err := appconfig.NewApplication(ctx, "testappconfigapp",
			&appconfig.ApplicationArgs{
				Tags: tagsMap,
			}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		ctx.Export("vpc", exportTags(vpc.Tags))
		ctx.Export("vpc-id", vpc.ID())
		ctx.Export("bucket", exportTags(bucket.Tags))
		ctx.Export("legacy-bucket", exportTags(legacyBucket.Tags))
		ctx.Export("bucket-name", bucket.Bucket)
		ctx.Export("legacy-bucket-name", legacyBucket.Bucket)
		ctx.Export("appconfig-app", exportTags(app.Tags))
		ctx.Export("appconfig-app-arn", app.Arn)

		return nil
	})
}

func exportTags(tags pulumi.StringMapOutput) pulumi.StringOutput {
	return tags.ApplyT(func(x interface{}) string {
		b, err := json.Marshal(x.(map[string]string))
		if err != nil {
			panic(err)
		}
		return string(b)
	}).(pulumi.StringOutput)
}
