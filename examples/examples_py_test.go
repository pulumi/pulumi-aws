// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
// +build python all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi/pkg/v2/testing/integration"
)

func TestAccBucketPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "bucket-py"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverPy(t *testing.T) {
	for _, dir := range []string{"webserver-py", "webserver-py-old"} {
		t.Run(dir, func(t *testing.T) {

			test := getPythonBaseOptions(t).
				With(integration.ProgramTestOptions{
					Dir: filepath.Join(getCwd(t), dir),
					// TODO[pulumi/pulumi-aws#1087]: Set RunUpdateTest to true for all tests.
					RunUpdateTest: dir != "webserver-py",
				})

			integration.ProgramTest(t, &test)
		})
	}
}

func TestAccAlbLegacyPy(t *testing.T) {
	for _, dir := range []string{"alb-legacy-py", "alb-legacy-py-old"} {
		t.Run(dir, func(t *testing.T) {
			test := getPythonBaseOptions(t).
				With(integration.ProgramTestOptions{
					Dir: filepath.Join(getCwd(t), dir),
					// TODO[pulumi/pulumi-aws#1087]: Set RunUpdateTest to true for all tests.
					RunUpdateTest: dir != "alb-legacy-py",
					EditDirs: []integration.EditDir{
						{
							Dir:             "step2",
							Additive:        true,
							ExpectNoChanges: true,
						},
					},
				})

			integration.ProgramTest(t, &test)
		})
	}
}

func TestAccAlbNewPy(t *testing.T) {
	for _, dir := range []string{"alb-new-py", "alb-new-py-old"} {
		t.Run(dir, func(t *testing.T) {
			test := getPythonBaseOptions(t).
				With(integration.ProgramTestOptions{
					Dir: filepath.Join(getCwd(t), dir),
					// TODO[pulumi/pulumi-aws#1087]: Set RunUpdateTest to true for all tests.
					RunUpdateTest: dir != "alb-new-py",
					EditDirs: []integration.EditDir{
						{
							Dir:             "step2",
							Additive:        true,
							ExpectNoChanges: true,
						},
					},
				})

			integration.ProgramTest(t, &test)
		})
	}
}

func getPythonBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	base := getBaseOptions()
	pythonBase := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			filepath.Join("..", "sdk", "python", "bin"),
		},
	})

	return pythonBase
}
