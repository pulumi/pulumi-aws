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
	stepOutputs := []map[string]interface{}{
		{},
		{
			"foo": "bar",
		},
		{
			"foo": "quux",
		},
		{
			"foo":    "quux",
			"thwomp": "pow",
		},
		{},
	}

	editDirs := []integration.EditDir{}
	for i, stepOutput := range stepOutputs {
		i := i
		stepOutput := stepOutput
		editDirs = append(editDirs, integration.EditDir{
			Dir:      filepath.Join(getCwd(t), "default-tags-yaml", "step"+strconv.Itoa(i)),
			Additive: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				stackOutputBucketTags := stackInfo.Outputs["bucketTags"].(map[string]interface{})
				assert.Equal(t, stepOutput, stackOutputBucketTags, "Unexpected stack output for step %d", i)
			},
		})
	}

	integration.ProgramTest(t, &integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "default-tags-yaml"),

		ExtraRuntimeValidation: editDirs[0].ExtraRuntimeValidation,
		EditDirs:               editDirs[1:],

		Config:           map[string]string{"aws:region": getEnvRegion(t)},
		Quick:            true,
		DestroyOnCleanup: true,
	})

}
