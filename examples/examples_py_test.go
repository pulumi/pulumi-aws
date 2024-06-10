// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build python || all
// +build python all

package examples

import (
	"context"
	"os"
	"path/filepath"
	"testing"

	"github.com/aws/aws-sdk-go-v2/config"
	iamsdk "github.com/aws/aws-sdk-go-v2/service/iam"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
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

func TestAccCodeBuildProjectPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "codebuild-project-py"),
			RunUpdateTest: false,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccFifoSqsQueuePy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "sqs-fifo-queue", "python"),
			RunUpdateTest: false,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.Contains(t, stack.Outputs["name"].(string), ".fifo")
			},
		})

	integration.ProgramTest(t, &test)
}

func TestSecretManagerPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "secretmanager"),
		})

	integration.ProgramTest(t, &test)
}

func TestRegress3905(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(getCwd(t), "regress-3905"),
			ExpectRefreshChanges: true, // JobDefinition.retry_strategy is suffering from a perma diff if the dict is empty. This is caused by the upstream provider ignoring empty object types
		})

	integration.ProgramTest(t, &test)
}

func TestRegress4031(t *testing.T) {
	iamClient := configureIAMClient(t)
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "regress-4031"),
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				roleName := stack.Outputs["roleName"].(string)
				rolePolicies, err := iamClient.ListRolePolicies(context.TODO(), &iamsdk.ListRolePoliciesInput{
					RoleName: &roleName,
				})

				assert.NoError(t, err, "failed to get policies of role %s", roleName)
				// Should have two inline policies called "bucket1" and "bucket2"
				assert.Contains(t, rolePolicies.PolicyNames, "bucket1")
				assert.Contains(t, rolePolicies.PolicyNames, "bucket2")
			},
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join(getCwd(t), "regress-4031", "step1"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
						roleName := stack.Outputs["roleName"].(string)
						rolePolicies, err := iamClient.ListRolePolicies(context.TODO(), &iamsdk.ListRolePoliciesInput{
							RoleName: &roleName,
						})

						assert.NoError(t, err, "failed to get policies of role %s", roleName)
						assert.Empty(t, rolePolicies.PolicyNames)
					},
				},
			},
		})

	integration.ProgramTest(t, &test)
}

func getPythonBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	pythonBase := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			filepath.Join("..", "sdk", "python", "bin"),
		},
	}

	return pythonBase
}

func configureIAMClient(t *testing.T) *iamsdk.Client {
	loadOpts := []func(*config.LoadOptions) error{}
	if p, ok := os.LookupEnv("AWS_PROFILE"); ok {
		loadOpts = append(loadOpts, config.WithSharedConfigProfile(p))
	}
	if r, ok := os.LookupEnv("AWS_REGION"); ok {
		loadOpts = append(loadOpts, config.WithRegion(r))
	}
	cfg, err := config.LoadDefaultConfig(context.TODO(), loadOpts...)
	assert.NoErrorf(t, err, "failed to load AWS config")
	return iamsdk.NewFromConfig(cfg)
}
