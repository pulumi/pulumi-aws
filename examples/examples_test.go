// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"io"
	"math/rand"
	"net/http"
	"os"
	"testing"
	"time"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optrefresh"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
	"github.com/stretchr/testify/assert"
)

func createEditDir(dir string) integration.EditDir {
	return integration.EditDir{Dir: dir, ExtraRuntimeValidation: nil}
}

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

func validateAPITest(isValid func(body string)) func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
	return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		var resp *http.Response
		var err error
		url := stack.Outputs["url"].(string)
		// Retry a couple times on 5xx
		for i := 0; i < 5; i++ {
			resp, err = http.Get(url)
			if !assert.NoError(t, err) {
				return
			}
			if resp.StatusCode < 500 {
				break
			}
			time.Sleep(10 * time.Second)
		}
		defer resp.Body.Close()
		body, err := io.ReadAll(resp.Body)
		assert.NoError(t, err)
		isValid(string(body))
	}
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
	skipRefresh bool
	validate    func(*testing.T, *pulumitest.PulumiTest, auto.UpResult)
}

// runExampleLifecycle preserves the standard checks previously provided implicitly by
// integration.ProgramTest. Tests with materially different lifecycles should call pulumitest directly.
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

	test.Preview(t, optpreview.Diff(), optpreview.ExpectNoChanges())
	result := test.Up(t, optup.ExpectNoChanges())

	if opts.validate != nil {
		opts.validate(t, test, result)
	}
	if !opts.skipRefresh {
		test.Refresh(t, optrefresh.ExpectNoChanges())
	}

	return result
}

// A lot of tests do not currently refresh cleanly. The work to root cause each tests has not been
// done yet but the common causes are listed here:
//
// TODO[pulumi/pulumi-aws#2246] specifically affects overlays such as bucket.onObjectCreated; may be worked around
// TODO[pulumi/pulumi#6235]
// TODO[pulumi/pulumi-terraform-bridge#1595]
func skipRefresh(opts *integration.ProgramTestOptions) {
	opts.SkipRefresh = true
}
