// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !nodejs && !dotnet && !java
// +build !go,!yaml,!nodejs,!dotnet,!java

package provider

import (
	"bytes"
	"context"
	"fmt"
	"path/filepath"
	"strings"
	"testing"
	"time"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/require"
)

func TestRegress3196(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}
	maxDuration(3*time.Minute, t, func(t *testing.T) {
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
	ctx := context.Background()
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-2534"))
	upResult := ptest.Up()
	targetGroupArn := upResult.Outputs["targetGroupArn"].Value.(string)
	targetGroupUrn := upResult.Outputs["targetGroupUrn"].Value.(string)
	workspace := ptest.CurrentStack().Workspace()
	t.Logf("Provisioned target group with arn=%s", targetGroupArn)
	workdir := workspace.WorkDir()
	t.Logf("workdir = %s", workdir)

	exec := func(args ...string) {
		var env []string
		for k, v := range workspace.GetEnvVars() {
			env = append(env, fmt.Sprintf("%s=%s", k, v))
		}
		stdin := bytes.NewReader([]byte{})
		var arguments []string
		arguments = append(arguments, args...)
		arguments = append(arguments, "-s", ptest.CurrentStack().Name())
		s1, s2, code, err := workspace.PulumiCommand().Run(ctx, workdir, stdin, nil, nil, env, arguments...)
		t.Logf("import stdout: %s", s1)
		t.Logf("import stderr: %s", s2)
		t.Logf("code=%v", code)
		require.NoError(t, err)
	}

	exec("import", "aws:lb/targetGroup:TargetGroup", "newtg", targetGroupArn, "--yes")
	exec("state", "unprotect", strings.ReplaceAll(targetGroupUrn, "::test", "::newtg"), "--yes")
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

func maxDuration(dur time.Duration, t *testing.T, test func(t *testing.T)) {
	t.Helper()
	timeout := time.After(dur)
	done := make(chan bool)
	go func() {
		test(t)
		done <- true
	}()
	select {
	case <-timeout:
		t.Fatalf("Test timed out after %v", dur)
	case <-done:
	}
}
