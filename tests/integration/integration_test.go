// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package integration

import (
	"os"
	"path"
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi/pkg/testing/integration"
)

func TestRegOutputUpdate(t *testing.T) {
	region := os.Getenv("AWS_REGION")
	if region == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}
	cwd, err := os.Getwd()
	if !assert.NoError(t, err, "expected a valid working directory: %v", err) {
		return
	}

	dir := "reg_output_update"
	t.Run(dir, func(t *testing.T) {
		integration.ProgramTest(t, &integration.ProgramTestOptions{
			Config: map[string]string{
				"aws:config:region": region,
			},
			Dependencies: []string{
				"pulumi",
				"@pulumi/aws",
			},
			Dir: path.Join(cwd, dir),
			EditDirs: []integration.EditDir{
				// Trigger an update that used to fail (due to missing outputs in the Check/Diff).
				{Dir: path.Join(cwd, dir, "variants", "change_to_180"), Additive: true},
			},
		})
	})
}
