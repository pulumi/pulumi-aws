// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !python && !dotnet && !java
// +build !go,!yaml,!python,!dotnet,!java

package provider

import (
	"archive/zip"
	"context"
	"crypto/rand"
	"encoding/json"
	"io"
	"os"
	"path/filepath"
	"testing"
	"time"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/elb"
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

func TestRegress4079(t *testing.T) {
	skipIfShort(t)
	ctx := context.Background()
	dir := filepath.Join("test-programs", "regress-4079")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)

	test.SetConfig("targetGroupCount", "2")
	r1 := test.Up()
	t.Logf("Stdout: %v", r1.StdOut)
	t.Logf("Stderr: %v", r1.StdErr)

	listenerARN := r1.Outputs["listenerARN"].Value.(string)
	err = elb.ModifyListenerDefaultActions(ctx, listenerARN, func(as []elb.Action) []elb.Action {
		r := []elb.Action{}
		for _, a := range as {
			b := a
			t.Logf("BEFORE: len(ForwardConfig.TargetGroups)=%d", len(b.ForwardConfig.TargetGroups))
			b.ForwardConfig.TargetGroups = []elb.TargetGroupTuple{
				b.ForwardConfig.TargetGroups[0],
			}
			t.Logf("AFTER: len(ForwardConfig.TargetGroups)=%d", len(b.ForwardConfig.TargetGroups))
			r = append(r, b)
		}
		return r
	})
	require.NoError(t, err)

	rr := test.Refresh()
	t.Logf("Stdout: %v", rr.StdOut)
	t.Logf("Stderr: %v", rr.StdErr)

	refreshedState := test.ExportStack()

	type resource struct {
		Type    string         `json:"type"`
		Outputs map[string]any `json:"outputs"`
	}
	type deployment struct {
		Resources []resource `json:"resources"`
	}
	var data deployment
	err = json.Unmarshal(refreshedState.Deployment, &data)
	require.NoError(t, err)

	for _, r := range data.Resources {
		if r.Type != "aws:lb/listener:Listener" {
			continue
		}
		defaultAction1 := r.Outputs["defaultActions"].([]any)[0].(map[string]any)
		t.Logf("defaultActions includes: %#v", defaultAction1)
		require.NotNil(t, defaultAction1["forward"], "forward should be set in defaultActions")
		require.Emptyf(t, defaultAction1["targetGroupArn"], "targetGroupArn should be empty in defaultActions")
	}
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

func TestRegress4128(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:         filepath.Join("test-programs", "regress-4128"),
			SkipRefresh: true,
		},
		)
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
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
