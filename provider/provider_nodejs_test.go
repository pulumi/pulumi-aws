// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !python && !dotnet && !java
// +build !go,!yaml,!python,!dotnet,!java

package provider

import (
	"os"
	"path/filepath"
	"testing"

	"github.com/pulumi/providertest"
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

func TestJobQueue(t *testing.T) {
	simpleNodeTest(t, filepath.Join("test-programs", "job-queue"))
}

func nodeTest(t *testing.T, dir string, opts ...providertest.Option) {
	envRegion := getEnvRegion(t)
	opts = append(opts,
		providertest.WithConfig("aws:region", "INVALID_REGION"),
		providertest.WithConfig("aws:envRegion", envRegion),
	)
	test(t, dir, opts...)
}

// This version of nodeTest does not aws:region INVALID_REGION manipulation.
func simpleNodeTest(t *testing.T, dir string, opts ...providertest.Option) {
	envRegion := getEnvRegion(t)
	opts = append(opts,
		providertest.WithConfig("aws:region", envRegion),
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
