// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
//
// Experimental provider upgrade tests.
//
// The objective of these tests is to make sure the provider release candidate will not generate any
// Update or Replace plans for Pulumi stacks deployed on a previous baseline version of the
// provider.
//
// Note on build flags above --^ these tests currently uses YAML only but our build workflow matrix
// does not run YAML-only test a the moment, and it splits tests by language build tag; for this
// reason the file is marked as another language so that the test runs only once.

//go:build !go && !nodejs && !python && !dotnet && !java
// +build !go,!nodejs,!python,!dotnet,!java

package provider

import (
	"path/filepath"
	"testing"
)

// func TestBucket(t *testing.T) {
// 	test(t, filepath.Join("test-programs", "bucket")).Run(t)
// }

// func TestEKSCluster(t *testing.T) {
// 	test(t, filepath.Join("test-programs", "eks-cluster")).Run(t)
// }

// func TestRdsInstance(t *testing.T) {
// 	test(t, filepath.Join("test-programs", "rds-instance")).Run(t)
// }

// func TestRoute53ResolverEndpoint(t *testing.T) {
// 	test(t, filepath.Join("test-programs", "route53-resolver-endpoint")).Run(t)
// }

// func TestSnsTopic(t *testing.T) {
// 	test(t, filepath.Join("test-programs", "sns-topic")).Run(t)
// }

func TestApiGatewayIntegrationResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-integrationresponse")).Run(t)
}

func TestApiGatewayMethodResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-methodreponse")).Run(t)
}

func TestApiGatewayResource(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource")).Run(t)
}

func TestApiGatewayResourceResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource-response")).Run(t)
}

func TestCloudwatchEventRule(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-eventrule")).Run(t)
}

func TestCloudwatchLogGroup(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-loggroup")).Run(t)
}

func TestDynamoTable(t *testing.T) {
	test(t, filepath.Join("test-programs", "dynamodb-table")).Run(t)
}

func TestEcrLifecyclePolicy(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-lifecyclepolicy")).Run(t)
}

func TestEcrRepository(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-repository")).Run(t)
}

func TestIamInstanceProfile(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-instanceprofile")).Run(t)
}

func TestIamOpenIDConnectProvider(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-openidconnectprovider")).Run(t)
}

func TestKmsKey(t *testing.T) {
	test(t, filepath.Join("test-programs", "kms-key")).Run(t)
}

func TestSecretsManagerSecret(t *testing.T) {
	test(t, filepath.Join("test-programs", "secretsmanager-secret")).Run(t)
}
