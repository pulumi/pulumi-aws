// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"io/ioutil"
	"net/http"
	"os"
	"path"
	"testing"
	"time"

	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi/pkg/testing/integration"
)

func TestExamples(t *testing.T) {
	region := os.Getenv("AWS_REGION")
	if region == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}
	cwd, err := os.Getwd()
	if !assert.NoError(t, err, "expected a valid working directory: %v", err) {
		return
	}

	// base options shared amongst all tests.
	base := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": region,
		},
		Tracing: "https://tracing.pulumi-engineering.com/collector/api/v1/spans",
	}
	baseJS := base.With(integration.ProgramTestOptions{
		Dependencies: []string{
			"@pulumi/aws",
		},
	})

	examples := []integration.ProgramTestOptions{
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "minimal")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "express")}),
		// TODO[pulumi/pulumi#1900]: This should be the default value, every test we have causes some sort of
		// change during a `pulumi refresh` for reasons outside our control.
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "bucket"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "cloudwatch"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "logGroup"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "queue"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "stream"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "table"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "topic"), ExpectRefreshChanges: true}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "api"),
			ExtraRuntimeValidation: validateAPITest(func(body string) {
				assert.Equal(t, "Hello, world!", body)
			}),
			EditDirs: []integration.EditDir{{
				Dir:      "./api/step2",
				Additive: true,
				ExtraRuntimeValidation: validateAPITest(func(body string) {
					assert.Equal(t, "<h1>Hello world!</h1>", body)
				}),
			}},
			ExpectRefreshChanges: true,
		}),
	}

	if !testing.Short() {
		examples = append(examples, []integration.ProgramTestOptions{
			// JavaScript tests:
			baseJS.With(integration.ProgramTestOptions{
				Dir: path.Join(cwd, "webserver"),
				EditDirs: []integration.EditDir{
					// First, look up the server just created using get.  No new resources.
					createEditDir(path.Join(cwd, "webserver", "variants", "get")),
					// Next, patch the ingress rules by adding port 20: should be a quick update.
					createEditDir(path.Join(cwd, "webserver", "variants", "ssh")),
					// Now do the reverse; this basically ensures that an update that deletes a property works.
					createEditDir(path.Join(cwd, "webserver")),
					// Next patch the security group description, necessitating a full replacement of resources.
					createEditDir(path.Join(cwd, "webserver", "variants", "ssh_description")),
				},
			}),
			baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver", "variants", "zones")}),
			baseJS.With(integration.ProgramTestOptions{
				Dir: path.Join(cwd, "webserver-comp"),
				// Verify that credentials can be passed via explicit configuration
				Secrets: map[string]string{
					"aws:accessKey": os.Getenv("AWS_ACCESS_KEY_ID"),
					"aws:secretKey": os.Getenv("AWS_SECRET_ACCESS_KEY"),
				},
			}),
			baseJS.With(integration.ProgramTestOptions{
				Dir: path.Join(cwd, "serverless-raw"),
				// Two changes are known to occur during refresh of the resources in this example:
				// * `~  aws:apigateway:Method myrestapi-method updated changes: + authorizationScopes,...`
				// * `~  aws:lambda:Function mylambda-logcollector updated changes: ~ lastModified`
				ExpectRefreshChanges: true,
			}),
			baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "serverless")}),
			baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "multiple-regions")}),
			// Python tests:
			base.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver-py")}),
			// Go tests:
			base.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver-go")}),
		}...)
	}

	for _, ex := range examples {
		example := ex
		t.Run(example.Dir, func(t *testing.T) {
			integration.ProgramTest(t, &example)
		})
	}
}

func createEditDir(dir string) integration.EditDir {
	return integration.EditDir{Dir: dir, ExtraRuntimeValidation: nil}
}

func validateAPITest(isValid func(body string)) func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
	return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		var resp *http.Response
		var err error
		url := stack.Outputs["url"].(string)
		// Retry a couple times on 5xx
		for i := 0; i < 2; i++ {
			resp, err = http.Get(url + "/b")
			if !assert.NoError(t, err) {
				return
			}
			if resp.StatusCode < 500 {
				break
			}
			time.Sleep(10 * time.Second)
		}
		defer resp.Body.Close()
		body, err := ioutil.ReadAll(resp.Body)
		assert.NoError(t, err)
		isValid(string(body))
	}
}
