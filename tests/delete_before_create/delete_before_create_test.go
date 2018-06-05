// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"os"
	"path"
	"testing"

	"github.com/pulumi/pulumi/pkg/testing/integration"
	"github.com/stretchr/testify/assert"
)

func TestMountTarget(t *testing.T) {
	region := os.Getenv("AWS_REGION")
	if region == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}
	cwd, err := os.Getwd()
	if !assert.NoError(t, err, "expected a valid working directory: %v", err) {
		return
	}

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
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "mount_target", "step1"),
			EditDirs: []integration.EditDir{
				{
					Dir:      "step2",
					Additive: true,
				},
				{
					Dir:      "step3",
					Additive: true,
				},
			},
		}),
	}

	for _, ex := range examples {
		example := ex
		t.Run(example.Dir, func(t *testing.T) {
			integration.ProgramTest(t, &example)
		})
	}
}
