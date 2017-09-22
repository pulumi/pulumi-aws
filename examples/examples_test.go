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
	base := integration.LumiProgramTestOptions{
		Config: map[string]string{
			"aws:config:region": region,
		},
		Dependencies: []string{
			"pulumi",
			"@pulumi/aws",
		},
	}

	examples := []integration.LumiProgramTestOptions{
		base.With(integration.LumiProgramTestOptions{Dir: path.Join(cwd, "minimal")}),
	}
	if !testing.Short() {
		examples = append(examples, []integration.LumiProgramTestOptions{
			base.With(integration.LumiProgramTestOptions{
				Dir: path.Join(cwd, "webserver"),
				EditDirs: []string{
					// First just patch the ingress rules by adding port 20: should be a quick update.
					path.Join(cwd, "webserver", "variants", "ssh"),
					// Now do the reverse; this basically ensures that an update that deletes a property works.
					path.Join(cwd, "webserver"),
					// Next patch the security group description, necessitating a full replacement of resources.
					path.Join(cwd, "webserver", "variants", "ssh_description"),
				},
			}),
			base.With(integration.LumiProgramTestOptions{Dir: path.Join(cwd, "webserver-comp")}),
			base.With(integration.LumiProgramTestOptions{Dir: path.Join(cwd, "beanstalk")}),
			base.With(integration.LumiProgramTestOptions{Dir: path.Join(cwd, "serverless-raw")}),
			base.With(integration.LumiProgramTestOptions{Dir: path.Join(cwd, "serverless")}),
		}...)
	}

	for _, ex := range examples {
		example := ex
		t.Run(example.Dir, func(t *testing.T) {
			integration.LumiProgramTest(t, example)
		})
	}
}
