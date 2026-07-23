// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build dotnet || all
// +build dotnet all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
)

// Keep the .NET release-verification example covered in normal CI.
func TestReleaseVerificationCs(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, filepath.Join(getCwd(t), "webserver-cs"),
		opttest.SkipInstall(),
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.DotNetReference("Pulumi.Aws", filepath.Join(getCwd(t), "..", "sdk", "dotnet")),
	)
	test.SetConfig(t, "aws:region", getEnvRegion(t))

	runExampleLifecycle(t, test, exampleLifecycleOptions{})
}
