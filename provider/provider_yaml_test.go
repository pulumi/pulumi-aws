// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !nodejs && !python && !dotnet
// +build !go,!nodejs,!python,!dotnet

package provider

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/providertest"
)

func TestBucket(t *testing.T) {
	test(t, filepath.Join("test-programs", "bucket"))
}

func TestEKSCluster(t *testing.T) {
	test(t, filepath.Join("test-programs", "eks-cluster"))
}

func TestRdsInstance(t *testing.T) {
	test(t, filepath.Join("test-programs", "rds-instance"))
}

func TestRoute53ResolverEndpoint(t *testing.T) {
	test(t, filepath.Join("test-programs", "route53-resolver-endpoint"))
}

func TestSnsTopic(t *testing.T) {
	test(t, filepath.Join("test-programs", "sns-topic"))
}

func TestApiGatewayIntegrationResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-integrationresponse"))
}

func TestApiGatewayMethodResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-methodreponse"))
}

func TestApiGatewayResource(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource"))
}

func TestApiGatewayResourceResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource-response"))
}

func TestCloudwatchEventRule(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-eventrule"))
}

func TestCloudwatchLogGroup(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-loggroup"))
}

func TestDynamoTable(t *testing.T) {
	test(t, filepath.Join("test-programs", "dynamodb-table"),
		providertest.WithDiffValidation(providertest.NoReplacements()))
}

func TestEcrLifecyclePolicy(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-lifecyclepolicy"))
}

func TestEcrRepository(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-repository"))
}

func TestIamInstanceProfile(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-instanceprofile"))
}

func TestIamOpenIDConnectProvider(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-openidconnectprovider"))
}

func TestKmsKey(t *testing.T) {
	test(t, filepath.Join("test-programs", "kms-key"))
}

func TestSecretsManagerSecret(t *testing.T) {
	test(t, filepath.Join("test-programs", "secretsmanager-secret"))
}

func TestEC2Networking(t *testing.T) {
	test(t, filepath.Join("test-programs", "ec2-networking"))
}

func TestECSService(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecs-service"))
}

func TestIAMUser(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-user"))
}

func TestLB(t *testing.T) {
	test(t, filepath.Join("test-programs", "lb"))
}

func TestACM(t *testing.T) {
	t.Skip("Blocked by https://github.com/pulumi/pulumi-aws/issues/3617")
	test(t, filepath.Join("test-programs", "acm"))
}

func TestBucketObj(t *testing.T) {
	test(t, filepath.Join("test-programs", "bucket-obj"))
}

func TestSubnetGroup(t *testing.T) {
	test(t, filepath.Join("test-programs", "subnet-group"))
}

func TestEC2Instance(t *testing.T) {
	test(t, filepath.Join("test-programs", "ec2-instance"))
}

func TestCloudfrontDistribution(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudfront-distribution"))
}

func TestSecretVersion(t *testing.T) {
	test(t, filepath.Join("test-programs", "secretversion"))
}
