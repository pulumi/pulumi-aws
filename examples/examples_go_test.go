// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build go || all
// +build go all

package examples

import (
	"path/filepath"
	"strconv"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
)

func TestAccWebserverGo(t *testing.T) {
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "webserver-go"),
		Dependencies: []string{
			"github.com/pulumi/pulumi-aws/sdk/v6",
		},
		Config: map[string]string{"aws:region": getEnvRegion(t)},
	}

	integration.ProgramTest(t, &test)
}

func TestAccDefaultTagsGo(t *testing.T) {
	getEditDir := func(step int) integration.EditDir {
		// Each step only changes the default tags on the provider
		var stepOutput map[string]interface{}
		var stepPurpose string
		switch step {
		case 0:
			stepPurpose = "Initial deployment without tags"
			stepOutput = map[string]interface{}{}
		case 1:
			stepPurpose = "Add first tag: `foo: bar``"
			stepOutput = map[string]interface{}{
				"foo": "bar",
			}
		case 2:
			stepPurpose = "Change tag `foo` value to `quux`"
			stepOutput = map[string]interface{}{
				"foo": "quux",
			}
		case 3:
			stepPurpose = "Add new tag: `thwomp: pow`"
			stepOutput = map[string]interface{}{
				"foo":    "quux",
				"thwomp": "pow",
			}
		case 4:
			stepPurpose = "Remove foo tag (foo and thwomp)"
			stepOutput = map[string]interface{}{
				"thwomp": "pow",
			}
		case 5:
			stepPurpose = "Don't specify any default tags (should be empty)"
			stepOutput = map[string]interface{}{}
		}

		return integration.EditDir{
			Dir:      filepath.Join(getCwd(t), "default-tags-yaml", "step"+strconv.Itoa(step)),
			Additive: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				stackOutputBucketTags := stackInfo.Outputs["bucketTags"].(map[string]interface{})
				assert.Equal(t, stepOutput, stackOutputBucketTags, "Unexpected stack output for step %d: %s", step, stepPurpose)
			},
		}
	}

	integration.ProgramTest(t, &integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "default-tags-yaml"),

		ExtraRuntimeValidation: getEditDir(0).ExtraRuntimeValidation,
		EditDirs: []integration.EditDir{
			getEditDir(1),
			getEditDir(2),
			getEditDir(3),
			getEditDir(4),
			// Disabling this step for now until we've resolved https://github.com/pulumi/pulumi-aws/issues/2633
			// getEditDir(5),
		},

		Config:           map[string]string{"aws:region": getEnvRegion(t)},
		Quick:            true,
		DestroyOnCleanup: true,
	})
}
