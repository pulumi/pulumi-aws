// Copyright 2016-2023, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//go:build nodejs || all
// +build nodejs all

package examples

// NOTE about build tags: CI does not understand yaml-specific tags yet, but splits builds per language to run on
// separate runners. This file piggy-backs on the nodejs tag so yaml tests will run on the same runner as node tests.

import (
	"os"
	"path/filepath"
	"strconv"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
)

// This test is not a proper examlpe but a test of the new capability to deploy Plugin Framework and SDKv2 based
// resources alongside each other in the same provider.
func TestAccPluginFramework(t *testing.T) {
	test := getYamlBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "plugin-framework"),
		})

	integration.ProgramTest(t, &test)
}

func getYamlBaseOptions(t *testing.T) integration.ProgramTestOptions {
	config := map[string]string{}
	_, usingProfiles := os.LookupEnv("AWS_PROFILE")
	if !usingProfiles {
		envRegion := getEnvRegion(t)
		config = map[string]string{
			"aws:region": envRegion,
		}
	}
	// Do not use baseOptions here for now as those disable refresh checking. Be extra conservative.
	return integration.ProgramTestOptions{
		Config: config,
	}
}

func TestAccDefaultTags(t *testing.T) {
	getEditDir := func(step int) integration.EditDir {
		// Each step only changes the default tags on the provider
		var stepOutput interface{}
		var stepPurpose string
		switch step {
		case 0:
			stepPurpose = "Initial deployment without tags"
			stepOutput = nil
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
				stackOutputBucketTags := stackInfo.Outputs["bucketTags"]
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
			getEditDir(5),
		},

		Config:           map[string]string{"aws:region": getEnvRegion(t)},
		Quick:            true,
		DestroyOnCleanup: true,
	})
}
