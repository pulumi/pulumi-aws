// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v7/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		iam.NewRole(ctx, "test-role", &iam.RoleArgs{
			AssumeRolePolicy: iam.PolicyDocumentArgs{
				Version: iam.PolicyDocumentVersion_2012_10_17,
				Statement: iam.PolicyStatementArray{
					iam.PolicyStatementArgs{
						Action: pulumi.String("sts:AssumeRole"),
						Effect: iam.PolicyStatementEffectALLOW,
						Principal: iam.ServicePrincipalArgs{
							Service: pulumi.String("lambda.amazonaws.com"),
						},
					},
				},
			},
		})

		return nil
	})
}
