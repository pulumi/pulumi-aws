// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !python && !dotnet && !java
// +build !go,!yaml,!python,!dotnet,!java

package provider

import (
	"archive/zip"
	"crypto/rand"
	"io"
	"os"
	"path/filepath"
	"testing"
	"time"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
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

func TestParallelLambdaCreation(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}

	tempFile, err := createLambdaArchive(25 * 1024 * 1024)
	require.NoError(t, err)
	defer os.Remove(tempFile)

	maxDuration(5*time.Minute, t, func(t *testing.T) {
		test := getJSBaseOptions(t).
			With(integration.ProgramTestOptions{
				Dir: filepath.Join("test-programs", "parallel-lambdas"),
				Config: map[string]string{
					"lambda:archivePath": tempFile,
				},
				// Lambdas have diffs on every update (source code hash)
				AllowEmptyPreviewChanges: true,
				SkipRefresh:              true,
			})

		integration.ProgramTest(t, &test)
	})
}

func getJSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	baseJS := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region":    "INVALID_REGION",
			"aws:envRegion": envRegion,
		},
		Dependencies: []string{
			"@pulumi/aws",
		},
	}

	return baseJS
}

func createLambdaArchive(size int64) (string, error) {
	// Create a temporary file to save the zip archive
	tempFile, err := os.CreateTemp("", "archive-*.zip")
	if err != nil {
		return "", err
	}
	defer tempFile.Close()

	// Create a new zip archive
	zipWriter := zip.NewWriter(tempFile)
	defer zipWriter.Close()

	randomDataReader := io.LimitReader(rand.Reader, size)

	// Create the index.js file for the lambda
	indexWriter, err := zipWriter.Create("index.js")
	if err != nil {
		return "", err
	}
	_, err = indexWriter.Write([]byte("const { version } = require(\"@aws-sdk/client-s3/package.json\");\n\nexports.handler = async () => ({ version });\n"))
	if err != nil {
		return "", err
	}

	randomDataWriter, err := zipWriter.Create("random.txt")
	if err != nil {
		return "", err
	}
	_, err = io.Copy(randomDataWriter, randomDataReader)
	if err != nil {
		return "", err
	}

	// Get the path of the temporary file
	archivePath, err := filepath.Abs(tempFile.Name())
	if err != nil {
		return "", err
	}

	return archivePath, nil
}
