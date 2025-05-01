// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

package main

import (
	"encoding/json"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appconfig"
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
		testIdent := conf.Require("testIdent")

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

		bucket, err := s3.NewBucketV2(ctx, "bucketv2"+testIdent, &s3.BucketV2Args{
			Tags: tagsMap,
		}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		app, err := appconfig.NewApplication(ctx, "testappconfigapp"+testIdent,
			&appconfig.ApplicationArgs{
				Tags: tagsMap,
			}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		env, err := appconfig.NewEnvironment(ctx, "testappconfigenv"+testIdent, &appconfig.EnvironmentArgs{
			ApplicationId: app.ID(),
			Tags:          tagsMap,
		}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		getEnv, err := appconfig.GetEnvironment(ctx, "get-testappconfigenv"+testIdent, env.ID(), &appconfig.EnvironmentState{}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		getBucket, err := s3.GetBucketV2(ctx, "get-bucketv2"+testIdent, bucket.ID(), &s3.BucketV2State{}, pulumi.Provider(p))
		if err != nil {
			return err
		}

		ctx.Export("bucket", exportTags(bucket.Tags))
		ctx.Export("get-bucket", exportTags(getBucket.Tags))
		ctx.Export("bucket-name", bucket.Bucket)
		ctx.Export("appconfig-app", exportTags(app.Tags))
		ctx.Export("appconfig-app-arn", app.Arn)
		ctx.Export("appconfig-env", exportTags(env.Tags))
		ctx.Export("get-appconfig-env", exportTags(getEnv.Tags))
		ctx.Export("appconfig-env-arn", env.Arn)

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
