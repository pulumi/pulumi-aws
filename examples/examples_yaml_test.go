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
	"fmt"
	"os"
	"path/filepath"
	"sort"
	"strconv"
	"strings"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
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

type tagsType struct {
	name, token string

	// Constant properties for the primary resource under test.
	//
	// This cannot include the tags property, which will be adjusted by the test.
	properties map[string]interface{}

	// Other is a string that is inserted into the test program. It is intended to be
	// used to provision supporting resources in tests.
	other string

	// If skip is non-empty, the test will be skipped with `skip` as the given reason.
	skip string
}

type tagsStep struct {
	purpose     string
	defaultTags map[string]interface{}
	tags        map[string]interface{}
	expected    map[string]interface{}
}

func TestAccDefaultTags(t *testing.T) {
	types := []tagsType{
		// Pulumi maintains it's own version of aws:s3:Bucket in
		// `s3legacy/bucket_legacy.go`. Because we don't have any
		// terraform-provider-aws maintainers to ensure our tagging works the same
		// way as other resource's tagging, we give our own bucket special testing
		// to make sure that tags work.
		{
			name: "legacy", token: "aws:s3:Bucket",
		},

		// Both aws:cognito:UserPool and aws:s3:BucketV2 are full SDKv2 resources managed
		// by Terraform, but they have different requirements for successful tag
		// interactions. That is why we have tests for both resources.
		{
			name: "bucket", token: "aws:s3:BucketV2",
		},
		{
			skip: "This doesn't work correctly in TF. Tracked in " +
				"https://github.com/pulumi/pulumi-aws/issues/2666.",
			name: "sdkv2", token: "aws:cognito:UserPool",
			properties: map[string]interface{}{
				// aliasAttributes is necessary because otherwise we don't
				// see a clean initial refresh
				"aliasAttributes": []interface{}{"email"},
			},
		},

		// A PF resource
		{
			name: "pf", token: "aws:appconfig:Environment",
			other: `
  app:
    type: aws:appconfig:Application
    properties:
      name: pf-tags-test-app`,
			properties: map[string]interface{}{
				"applicationId": "${app.id}",
				"name":          "pf-tags-test",
			},
		},
	}

	sameAsDefault := map[string]interface{}{"__sameAsDefault": ""}
	steps := []tagsStep{
		{
			purpose: "Initial deployment without tags",
		},
		{
			purpose: "Add first default tag: `foo: bar``",
			defaultTags: map[string]interface{}{
				"foo": "bar",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Change tag `foo` value to `quux`",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Add a resource specific tag: `foo: buzz`",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			tags: map[string]interface{}{
				"fizz": "buzz",
			},
			expected: map[string]interface{}{
				"foo":  "quux",
				"fizz": "buzz",
			},
		},
		{
			purpose: "Shadow the default tag with a resource specific tag",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			tags: map[string]interface{}{
				"fizz": "buzz",
				"foo":  "bar",
			},
			expected: map[string]interface{}{
				"foo":  "bar",
				"fizz": "buzz",
			},
		},
		{
			purpose: "Drop resource specific tags",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Add new tag: `thwomp: pow`",
			defaultTags: map[string]interface{}{
				"foo":    "quux",
				"thwomp": "pow",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Remove foo tag (foo and thwomp)",
			defaultTags: map[string]interface{}{
				"thwomp": "pow",
			},
			expected: sameAsDefault,
		},
		{
			purpose:     "Don't specify any default tags (should be empty)",
			defaultTags: map[string]interface{}{},
			expected:    sameAsDefault,
		},
	}

	// Apply sameAsDefault
	for i, v := range steps {
		if v.expected == nil {
			continue
		}
		_, ok := v.expected["__sameAsDefault"]
		if !ok {
			continue
		}
		v.expected = v.defaultTags
		steps[i] = v
	}

	t.Run("generate", func(t *testing.T) {
		generateTagsTests(t, types, steps)
	})
	if t.Failed() {
		return
	}

	for _, typ := range types {
		typ := typ
		t.Run(typ.name, func(t *testing.T) {
			if reason := typ.skip; reason != "" {
				t.Skipf(reason)
			}
			dir := filepath.Join(getCwd(t), typ.name+"-default-tags-yaml")
			testTags(t, dir, steps)
		})
	}

	return
}

func testTags(t *testing.T, dir string, steps []tagsStep) {
	isNil := func(val interface{}) bool {
		if val == nil {
			return true
		}
		v, ok := val.(map[string]interface{})
		return ok && len(v) == 0
	}
	editDirs := make([]integration.EditDir, 0, len(steps))
	for i, step := range steps {
		step := step
		editDirs = append(editDirs,
			integration.EditDir{
				Dir:      filepath.Join(dir, "step"+strconv.Itoa(i)),
				Additive: true,
				ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
					stackOutputBucketTags := stackInfo.Outputs["actual"]
					// legacy returns nil initially, but sdkv2 returns
					// an empty map initially.
					if isNil(step.expected) && isNil(stackOutputBucketTags) {
						return
					}
					assert.Equal(t, step.expected, stackOutputBucketTags,
						"Unexpected stack output for step %d: %s", step, step.purpose)
				},
			})
	}

	integration.ProgramTest(t, &integration.ProgramTestOptions{
		Dir:                    dir,
		ExtraRuntimeValidation: editDirs[0].ExtraRuntimeValidation,
		EditDirs:               editDirs[1:],
		Config:                 map[string]string{"aws:region": getEnvRegion(t)},
		Quick:                  true,
		DestroyOnCleanup:       true,
	})
}

func generateTagsTests(t *testing.T, types []tagsType, steps []tagsStep) {
	template := `name: test-aws-1655-%s
runtime: yaml
description: |
  %s
resources:
  aws-provider:
    type: pulumi:providers:aws%s%s
  res:
    type: %s%s
    options:
      provider: ${aws-provider}
outputs:
  actual: ${res.tags}`

	var expandMap func(level int, v interface{}) string
	expandMap = func(level int, v interface{}) string {
		indent := "\n" + strings.Repeat("  ", level)

		var body string
		switch v := v.(type) {
		case nil:
			return ""
		case string:
			body = v
		case []interface{}:
			for _, v := range v {
				body += indent + "- " + strings.TrimSpace(expandMap(level+1, v))
			}
		case map[string]interface{}:
			sortedKeys := make([]string, len(v))
			for k := range v {
				sortedKeys = append(sortedKeys, k)
			}
			sort.Strings(sortedKeys)
			for _, k := range sortedKeys {
				v := v[k]

				val := expandMap(level+1, v)
				if val == "" {
					continue
				}
				body += indent + k + ": " + val
			}
		default:
			t.Logf("Unknown value type %T", v)
			t.FailNow()

		}

		return body
	}

	expandProps := func(props ...map[string]interface{}) string {
		a := map[string]interface{}{}
		for _, arg := range props {
			for k, v := range arg {
				a[k] = v
			}
		}

		return expandMap(2, map[string]interface{}{
			"properties": a,
		})

	}

	for _, typ := range types {
		dir := filepath.Join(getCwd(t), typ.name+"-default-tags-yaml")
		for i, p := range steps {
			path := filepath.Join(dir, fmt.Sprintf("step%d", i))
			if i == 0 {
				path = dir
			}
			body := fmt.Sprintf(template, typ.name, p.purpose,
				expandProps(map[string]interface{}{
					"defaultTags": map[string]interface{}{
						"tags": p.defaultTags,
					},
				}), typ.other, typ.token,
				expandProps(map[string]interface{}{
					"tags": p.tags,
				}, typ.properties))

			fpath := filepath.Join(path, "Pulumi.yaml")
			if os.Getenv("PULUMI_ACCEPT") == "true" {
				require.NoError(t, os.MkdirAll(path, 0700))
				require.NoError(t, os.WriteFile(fpath, []byte(body), 0600))
			} else {
				existing, err := os.ReadFile(fpath)
				if assert.NoError(t, err) {
					assert.Equal(t,
						body, string(existing))
				}
			}
		}
	}
}
