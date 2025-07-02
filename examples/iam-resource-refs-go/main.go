// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v7/go/aws/ec2"
	"github.com/pulumi/pulumi-aws/sdk/v7/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		// Create IAM user
		user, err := iam.NewUser(ctx, "test-user", nil)
		if err != nil {
			return err
		}

		// Create IAM group
		group, err := iam.NewGroup(ctx, "test-group", nil)
		if err != nil {
			return err
		}

		// Create IAM role
		role, err := iam.NewRole(ctx, "test-role", &iam.RoleArgs{
			AssumeRolePolicy: iam.PolicyDocumentArgs{
				Version: iam.PolicyDocumentVersion_2012_10_17,
				Statement: iam.PolicyStatementArray{
					iam.PolicyStatementArgs{
						Action: pulumi.String("sts:AssumeRole"),
						Effect: iam.PolicyStatementEffectALLOW,
						Principal: iam.ServicePrincipalArgs{
							Service: pulumi.String("ec2.amazonaws.com"),
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}

		// Create instance profile
		instanceProfile, err := iam.NewInstanceProfile(ctx, "test-profile", &iam.InstanceProfileArgs{
			Role: role,
		})
		if err != nil {
			return err
		}

		// Create IAM policy
		policy, err := iam.NewPolicy(ctx, "test-policy", &iam.PolicyArgs{
			Description: pulumi.String("Test policy"),
			Policy: iam.PolicyDocumentArgs{
				Version: iam.PolicyDocumentVersion_2012_10_17,
				Statement: iam.PolicyStatementArray{
					iam.PolicyStatementArgs{
						Action:   pulumi.String("s3:ListBucket"),
						Effect:   iam.PolicyStatementEffectALLOW,
						Resource: pulumi.String("*"),
					},
				},
			},
		})
		if err != nil {
			return err
		}

		// Create role policy
		_, err = iam.NewRolePolicy(ctx, "test-role-policy", &iam.RolePolicyArgs{
			Role: role,
			Policy: iam.PolicyDocumentArgs{
				Version: iam.PolicyDocumentVersion_2012_10_17,
				Statement: iam.PolicyStatementArray{
					iam.PolicyStatementArgs{
						Action:   pulumi.String("ec2:DescribeInstances"),
						Effect:   iam.PolicyStatementEffectALLOW,
						Resource: pulumi.String("*"),
					},
				},
			},
		})
		if err != nil {
			return err
		}

		// Create role policy attachment
		_, err = iam.NewRolePolicyAttachment(ctx, "test-role-policy-attachment", &iam.RolePolicyAttachmentArgs{
			Role:      role,
			PolicyArn: policy.Arn,
		})
		if err != nil {
			return err
		}

		// Create group policy attachment
		_, err = iam.NewGroupPolicyAttachment(ctx, "test-group-policy-attachment", &iam.GroupPolicyAttachmentArgs{
			Group:     group,
			PolicyArn: policy.Arn,
		})
		if err != nil {
			return err
		}

		// Create user policy attachment
		_, err = iam.NewUserPolicyAttachment(ctx, "test-user-policy-attachment", &iam.UserPolicyAttachmentArgs{
			User:      user,
			PolicyArn: policy.Arn,
		})
		if err != nil {
			return err
		}

		// Create policy attachment
		_, err = iam.NewPolicyAttachment(ctx, "test-policy-attachment", &iam.PolicyAttachmentArgs{
			Users:     pulumi.ToArray([]any{user}),
			Roles:     pulumi.ToArray([]any{role.Name}),
			Groups:    pulumi.ToArray([]any{group.Name}),
			PolicyArn: policy.Arn,
		})
		if err != nil {
			return err
		}

		ami, err := ec2.GetAmiIds(ctx, &ec2.GetAmiIdsArgs{
			Owners: []string{"amazon"},
			Filters: []ec2.GetAmiIdsFilter{
				{

					Name:   "name",
					Values: []string{"al2023-ami-2023.*-kernel-*-x86_64"},
				},
			},
		})

		// Create launch configuration
		_, err = ec2.NewLaunchConfiguration(ctx, "test-lc", &ec2.LaunchConfigurationArgs{
			ImageId:            pulumi.String(ami.Ids[0]),
			InstanceType:       pulumi.String("t2.micro"),
			IamInstanceProfile: instanceProfile,
		})
		if err != nil {
			return err
		}

		// Create EC2 instance
		instance, err := ec2.NewInstance(ctx, "test-instance", &ec2.InstanceArgs{
			Ami:                pulumi.String(ami.Ids[0]),
			InstanceType:       pulumi.String("t2.micro"),
			IamInstanceProfile: instanceProfile,
		})
		if err != nil {
			return err
		}

		// Export instance ID
		ctx.Export("instanceId", instance.ID())

		return nil
	})
}
