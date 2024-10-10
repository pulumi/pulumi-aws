// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !nodejs && !dotnet && !java
// +build !go,!yaml,!nodejs,!dotnet,!java

package provider

import (
	"bytes"
	"os"
	"path/filepath"
	"strings"
	"testing"
	"time"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/stretchr/testify/require"
)

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
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-2534"))
	upResult := ptest.Up(t)
	targetGroupArn := upResult.Outputs["targetGroupArn"].Value.(string)
	targetGroupUrn := upResult.Outputs["targetGroupUrn"].Value.(string)
	workspace := ptest.CurrentStack().Workspace()
	t.Logf("Provisioned target group with arn=%s", targetGroupArn)
	workdir := workspace.WorkDir()
	t.Logf("workdir = %s", workdir)

	execPulumi(t, ptest, workdir, "import", "aws:lb/targetGroup:TargetGroup", "newtg", targetGroupArn, "--yes")
	execPulumi(t, ptest, workdir, "state", "unprotect", strings.ReplaceAll(targetGroupUrn, "::test", "::newtg"), "--yes")
}

func TestRegress4457(t *testing.T) {
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
