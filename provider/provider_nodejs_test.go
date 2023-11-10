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

//go:build !go && !yaml && !python && !dotnet && !java
// +build !go,!yaml,!python,!dotnet,!java

package provider

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/providertest"
	"os"
)

func TestLambdaLayerNew(t *testing.T) {
	nodeTest(t, filepath.Join("..", "examples", "lambda-layer-new"))
}

func TestCloudWatch(t *testing.T) {
	nodeTest(t, filepath.Join("..", "examples", "cloudwatch"))
}

func TestLogGroup(t *testing.T) {
	nodeTest(t, filepath.Join("..", "examples", "logGroup"))
}

func TestQueue(t *testing.T) {
	nodeTest(t, filepath.Join("..", "examples", "queue"))
}

func TestRoute53(t *testing.T) {
	nodeTest(t, filepath.Join("..", "examples", "route53"))
}

func nodeTest(t *testing.T, dir string, opts ...providertest.Option) {
	envRegion := getEnvRegion(t)
	opts = append(opts,
		providertest.WithConfig("aws:region", "INVALID_REGION"),
		providertest.WithConfig("aws:envRegion", envRegion),
	)
	test(t, dir, opts...)
}

func getEnvRegion(t *testing.T) string {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		envRegion = "us-west-2"
	}
	return envRegion
}
