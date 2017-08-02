// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"os"
	"path"
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi-fabric/pkg/integrationtesting"
)

func TestExamples(t *testing.T) {
	var examples []string
	region := os.Getenv("AWS_REGION")
	if region == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}
	cwd, err := os.Getwd()
	if !assert.NoError(t, err, "expected a valid working directory: %v", err) {
		return
	}
	if testing.Short() {
		examples = []string{
			path.Join(cwd, "serverless"),
		}
	} else {
		examples = []string{
			path.Join(cwd, "serverless-raw"),
			path.Join(cwd, "serverless"),
		}
	}
	options := integrationtesting.LumiProgramTestOptions{
		Config: map[string]string{
			"aws:config:region": region,
		},
		Dependencies: []string{
			"@lumi/lumirt",
			"@lumi/lumi",
			"@lumi/aws",
			"@lumi/aws-serverless",
		},
	}
	for _, ex := range examples {
		example := ex
		t.Run(example, func(t *testing.T) {
			integrationtesting.LumiProgramTest(t, example, options)
		})
	}
}
