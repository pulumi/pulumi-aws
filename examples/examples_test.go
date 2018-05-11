// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"os"
	"path"
	"testing"

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
			"@pulumi/pulumi",
			"@pulumi/aws",
		},
	})

	examples := []integration.ProgramTestOptions{
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "minimal")}),
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

			// TODO[pulumi/pulumi-aws#198]: disabled due to what seem to be transient failures from AWS.
			// baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "beanstalk")}),

			baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "serverless-raw")}),
			baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "serverless")}),
			// Python tests:
			base.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver-py")}),
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
