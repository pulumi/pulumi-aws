// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build dotnet || all
// +build dotnet all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
)

// Keep the .NET release-verification example covered in normal CI.
func TestReleaseVerificationCs(t *testing.T) {
	test := getCSBaseOptions(t).
		With(integration.ProgramTestOptions{
			RunUpdateTest: false,
			Dir:           filepath.Join(getCwd(t), "webserver-cs"),
		})

	integration.ProgramTest(t, &test)
}

func getCSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	csharpBase := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			"Pulumi.Aws",
		},
	}

	return csharpBase
}
