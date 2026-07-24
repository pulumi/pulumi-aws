// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"math/rand"
	"os"
	"testing"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/pulumi/sdk/v3/go/auto"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optrefresh"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
)

func skipIfShort(t *testing.T) {
	if testing.Short() {
		t.Skip("skipping long-running test in short mode")
	}
}

func getEnvRegion(t *testing.T) string {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}

	return envRegion
}

func getCwd(t *testing.T) string {
	cwd, err := os.Getwd()
	if err != nil {
		t.FailNow()
	}

	return cwd
}

var letterRunes = []rune("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

func randomString(length int) string {
	b := make([]rune, length)
	for i := range b {
		b[i] = letterRunes[rand.Intn(len(letterRunes))]
	}
	return string(b)
}

type exampleLifecycleOptions struct {
	skipRefresh              bool
	allowEmptyPreviewChanges bool
	allowEmptyUpdateChanges  bool
	validate                 func(*testing.T, *pulumitest.PulumiTest, auto.UpResult)
}

// runExampleLifecycle preserves the standard checks previously provided implicitly by
// ProgramTest. Tests with materially different lifecycles should call pulumitest directly.
func runExampleLifecycle(
	t *testing.T,
	test *pulumitest.PulumiTest,
	opts exampleLifecycleOptions,
) auto.UpResult {
	t.Helper()

	test.Preview(t, optpreview.Diff())
	test.Up(t)

	state := test.ExportStack(t)
	test.ImportStack(t, state)

	previewOpts := []optpreview.Option{optpreview.Diff()}
	if !opts.allowEmptyPreviewChanges {
		previewOpts = append(previewOpts, optpreview.ExpectNoChanges())
	}
	test.Preview(t, previewOpts...)

	upOpts := []optup.Option{}
	if !opts.allowEmptyUpdateChanges {
		upOpts = append(upOpts, optup.ExpectNoChanges())
	}
	result := test.Up(t, upOpts...)

	if opts.validate != nil {
		opts.validate(t, test, result)
	}
	if !opts.skipRefresh {
		test.Refresh(t, optrefresh.ExpectNoChanges())
	}

	return result
}
