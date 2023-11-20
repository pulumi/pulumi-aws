// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
//go:build python || all
// +build python all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/batch"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
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
					Dir:           filepath.Join(getCwd(t), dir),
					RunUpdateTest: true,
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
					Dir:           filepath.Join(getCwd(t), dir),
					RunUpdateTest: true,
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

func TestAccCodeBuildProjectPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "codebuild-project-py"),
			RunUpdateTest: false,
		})

	integration.ProgramTest(t, &test)
}

func TestAccFifoSqsQueuePy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "sqs-fifo-queue", "python"),
			RunUpdateTest: false,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				expect := map[string]string{
					"operatingSystemFamily": "LINUX",
					"cpuArchitecture":       "ARM64",
				}
				for k, v := range expect {
					assert.Contains(t, stack.Outputs[k].(string), v)
				}

			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccArm64JobDefinition(t *testing.T) {
	check := func(t *testing.T) {
		active := "ACTIVE"
		envRegion := getEnvRegion(t)

		sess, err := session.NewSession(&aws.Config{
			Region: &envRegion,
		})
		require.NoError(t, err)
		svc := batch.New(sess)
		input := &batch.DescribeJobDefinitionsInput{
			Status: &active,
		}

		result, err := svc.DescribeJobDefinitions(input)
		require.NoError(t, err)

		for _, jd := range result.JobDefinitions {
			rp := jd.ContainerProperties.RuntimePlatform
			require.Equal(t, "LINUX", rp.OperatingSystemFamily)
			require.Equal(t, "ARM64", rp.CpuArchitecture)
		}
	}

	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "arm64-job-definition"),
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				check(t)
			},
		})

	integration.ProgramTest(t, &test)
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
