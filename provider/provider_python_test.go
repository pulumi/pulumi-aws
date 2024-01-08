// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !nodejs && !dotnet && !java
// +build !go,!yaml,!nodejs,!dotnet,!java

package provider

import (
	"path/filepath"
	"testing"
	"time"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
)

func TestRegress3196(t *testing.T) {
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

func getPythonBaseOptions(t *testing.T) integration.ProgramTestOptions {
	t.Helper()
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
	}
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
