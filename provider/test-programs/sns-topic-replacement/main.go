package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sns"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		conf := config.New(ctx, "")
		providerName := conf.Require("providerName")

		// Create an AWS provider
		provider, err := aws.NewProvider(ctx, providerName, &aws.ProviderArgs{})
		if err != nil {
			return err
		}

		topicName := conf.Require("topicName")

		// Create an SNS Topic using the above created AWS provider
		_, err = sns.NewTopic(
			ctx,
			topicName,
			&sns.TopicArgs{Name: pulumi.StringPtrFromPtr(&topicName)},
			pulumi.Provider(provider),
			// pulumi.DeleteBeforeReplace(true),
		)
		if err != nil {
			return err
		}

		return nil
	})
}
