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

//go:build !go && !nodejs && !python && !dotnet
// +build !go,!nodejs,!python,!dotnet

package provider

import (
	"path/filepath"
	"testing"
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
	test(t, filepath.Join("test-programs", "dynamodb-table"))
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
