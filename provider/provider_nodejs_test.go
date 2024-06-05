// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !python && !dotnet && !java
// +build !go,!yaml,!python,!dotnet,!java

package provider

import (
	"os"
	"path/filepath"
	"testing"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/stretchr/testify/require"
)

func TestLambdaLayerNewUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("..", "examples", "lambda-layer-new"), nodeProviderUpgradeOpts())
}

func TestCloudWatchUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("..", "examples", "cloudwatch"), nodeProviderUpgradeOpts())
}

func TestLogGroupUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("..", "examples", "logGroup"), nodeProviderUpgradeOpts())
}

func TestQueueUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("..", "examples", "queue"), nodeProviderUpgradeOpts())
}

func TestRoute53Upgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("..", "examples", "route53"), nodeProviderUpgradeOpts())
}

func TestJobQueueUpgrade(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.setEnvRegion = false
	opts.region = "us-west-2" // has to match the snapshot-recorded region
	opts.extraOpts = []opttest.Option{
		opttest.Env("PULUMI_ENABLE_PLAN_RESOURCE_CHANGE", "true"),
	}
	testProviderUpgrade(t, filepath.Join("test-programs", "job-queue"), opts)
}

func nodeProviderUpgradeOpts() *testProviderUpgradeOptions {
	return &testProviderUpgradeOptions{
		linkNodeSDK:  true,
		installDeps:  true,
		setEnvRegion: true,
	}
}

func TestRegress3094(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-3094")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	upResult := test.Up()
	t.Logf("#%v", upResult.Summary)
}

func TestRegress3835(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-3835")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	result := test.Preview()
	t.Logf("#%v", result.ChangeSummary)
}

func TestChangingRegion(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "changing-region")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}

	t.Run("default provider", func(t *testing.T) {
		test := pulumitest.NewPulumiTest(t, dir, options...)
		for _, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig("aws:region", region)
			res := test.Up()
			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})

	t.Run("explicit provider", func(t *testing.T) {
		test := pulumitest.NewPulumiTest(t, dir, options...)
		for _, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig("desired-region", region)
			res := test.Up()
			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})
}

func TestRegressAttributeMustBeWholeNumber(t *testing.T) {
	// pulumi/pulumi-terraform-bridge#1940
	skipIfShort(t)
	dir := filepath.Join("test-programs", "ec2-string-for-int")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	result := test.Preview()
	t.Logf("#%v", result.ChangeSummary)
}
