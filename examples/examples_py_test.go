// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.
//go:build python || all
// +build python all

package examples

import (
	"bytes"
	"context"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go-v2/config"
	iamsdk "github.com/aws/aws-sdk-go-v2/service/iam"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/optnewstack"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestAccBucketPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "bucket-py"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccPolicyDocument(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "iam-policy-document", "py"),
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

func TestRegress3196(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}
	maxDuration(6*time.Minute, t, func(t *testing.T) {
		test := getPythonBaseOptions(t).
			With(integration.ProgramTestOptions{
				Quick:         true,
				SkipRefresh:   true,
				Dir:           filepath.Join("test-programs", "regress-3196"),
				ExpectFailure: true,
			})
		integration.ProgramTest(t, &test)
	})
}

func TestRegress3887(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Quick:       true,
			SkipRefresh: true,
			Dir:         filepath.Join("test-programs", "regress-3887"),
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join("test-programs", "regress-3887", "step-1"),
					Additive: true,
				},
				{
					Dir:      filepath.Join("test-programs", "regress-3887", "step-2"),
					Additive: true,
				},
			},
		})
	integration.ProgramTest(t, &test)
}

// Make sure that importing an AWS targetGroup succeeds.
func TestRegress2534(t *testing.T) {
	skipIfShort(t)
	cwd := getCwd(t)
	// We need explicit control over Python setup here because this test exercises
	// `pulumi import` end-to-end against the local provider and local SDK rather
	// than the older integration.ProgramTest harness used by most Python examples.
	ptest := pulumitest.NewPulumiTest(t, filepath.Join(cwd, "test-programs", "regress-2534"),
		opttest.SkipInstall(),
		opttest.SkipStackCreate(),
		opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
	)

	// The program under test uses `virtualenv: venv` in Pulumi.yaml, so install
	// both the generic Python deps and the local editable `sdk/python` package
	// into that same venv before creating the stack.
	setupPythonVenv(t, ptest.WorkingDir(), filepath.Join(cwd, "..", "sdk", "python"))
	ptest.NewStack(t, "test", optnewstack.EnableAutoDestroy())
	ptest.SetConfig(t, "aws:region", getEnvRegion(t))

	upResult := ptest.Up(t)
	targetGroupArn := upResult.Outputs["targetGroupArn"].Value.(string)
	targetGroupUrn := upResult.Outputs["targetGroupUrn"].Value.(string)
	workspace := ptest.CurrentStack().Workspace()
	t.Logf("Provisioned target group with arn=%s", targetGroupArn)
	workdir := workspace.WorkDir()
	t.Logf("workdir = %s", workdir)

	// Import the target group and capture the language-specific code snippet that
	// Pulumi prints. The original regression was not just "import exits non-zero";
	// it was that the generated Python code encoded invalid nested values for
	// target failover / target health state on imported target groups.
	importResult := ptest.Import(t, "aws:lb/targetGroup:TargetGroup", "newtg", targetGroupArn, "" /* providerUrn */)
	execPulumi(t, ptest, workdir, "state", "unprotect", strings.ReplaceAll(targetGroupUrn, "::test", "::newtg"), "--yes")

	t.Logf("Editing the program to add the code recommended by import")
	i := strings.Index(importResult.Stdout, "import pulumi")
	require.NotEqual(t, -1, i, "expected Python import code in pulumi import output")
	// These strings correspond to the broken import shape this regression guards:
	// phantom nested blocks like targetFailovers[0] with missing required fields.
	require.NotContains(t, importResult.Stdout, "targetFailovers[0].onDeregistration")
	require.NotContains(t, importResult.Stdout, "targetFailovers[0].onUnhealthy")
	require.NotContains(t, importResult.Stdout, "targetHealthStates[0].enableUnhealthyConnectionTermination")

	mainPy := filepath.Join(ptest.WorkingDir(), "__main__.py")
	pyBytes, err := os.ReadFile(mainPy)
	require.NoError(t, err)
	updatedPyBytes := bytes.ReplaceAll(pyBytes, []byte("# EXTRA CODE HERE"), []byte(importResult.Stdout[i:]))
	err = os.WriteFile(mainPy, updatedPyBytes, 0o600)
	require.NoError(t, err)

	// Run a follow-up preview with the generated import code in place. We do not
	// assert "no diff" here because unrelated imported defaults can still drift;
	// the assertion we care about is that preview no longer reports the old
	// invalid nested-block validation errors.
	t.Logf("Previewing the edited program")
	previewResult := ptest.Preview(t)
	t.Logf("%s", previewResult.StdOut)
	t.Logf("%s", previewResult.StdErr)
	require.NotContains(t, previewResult.StdOut, "targetFailovers[0].onDeregistration")
	require.NotContains(t, previewResult.StdOut, "targetFailovers[0].onUnhealthy")
	require.NotContains(t, previewResult.StdOut, "targetHealthStates[0].enableUnhealthyConnectionTermination")
	require.NotContains(t, previewResult.StdErr, "targetFailovers[0].onDeregistration")
	require.NotContains(t, previewResult.StdErr, "targetFailovers[0].onUnhealthy")
	require.NotContains(t, previewResult.StdErr, "targetHealthStates[0].enableUnhealthyConnectionTermination")
}

func setupPythonVenv(t *testing.T, workdir, sdkPath string) {
	t.Helper()

	venvDir := filepath.Join(workdir, "venv")
	runCmd := func(args ...string) {
		t.Helper()
		cmd := exec.Command(args[0], args[1:]...)
		cmd.Dir = workdir
		out, err := cmd.CombinedOutput()
		require.NoErrorf(t, err, "command failed: %s\n%s", strings.Join(args, " "), out)
	}

	runCmd("python3", "-m", "venv", venvDir)

	pythonBin := filepath.Join(venvDir, "bin", "python")
	runCmd(pythonBin, "-m", "pip", "install", "--upgrade", "pip")
	runCmd(pythonBin, "-m", "pip", "install", "-r", "requirements.txt")
	runCmd(pythonBin, "-m", "pip", "install", "-e", sdkPath)
}

func TestRegress4457(t *testing.T) {
	t.Skipf("TODO[pulumi/pulumi-aws#4958]")
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-4457"))
	upResult := ptest.Up(t)
	autoGroupArn := upResult.Outputs["autoGroupArn"].Value.(string)
	autoGroupUrn := upResult.Outputs["autoGroupUrn"].Value.(string)
	autoGroupName := upResult.Outputs["autoGroupName"].Value.(string)
	workspace := ptest.CurrentStack().Workspace()

	t.Logf("Provisioned autoscaling group with arn=%s and urn=%s and name=%s", autoGroupArn, autoGroupUrn, autoGroupName)
	workdir := workspace.WorkDir()
	t.Logf("workdir = %s", workdir)

	importResult := ptest.Import(t, "aws:autoscaling/group:Group", "newag", autoGroupName, "" /* providerUrn */)

	t.Logf("Editing the program to add the code recommended by import")
	i := strings.Index(importResult.Stdout, "import pulumi")
	extraCode := importResult.Stdout[i:]
	mainPy := filepath.Join(ptest.WorkingDir(), "__main__.py")
	pyBytes, err := os.ReadFile(mainPy)
	require.NoError(t, err)
	updatedPyBytes := bytes.ReplaceAll(pyBytes, []byte("# EXTRA CODE HERE"), []byte(extraCode))
	err = os.WriteFile(mainPy, updatedPyBytes, 0600)
	require.NoError(t, err)

	t.Logf("Previewing the edited program")
	previewResult := ptest.Preview(t, optpreview.ExpectNoChanges())
	t.Logf("%s", previewResult.StdOut)
	t.Logf("%s", previewResult.StdErr)
}

func getPythonBaseOptions(t *testing.T) integration.ProgramTestOptions {
	t.Helper()
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
