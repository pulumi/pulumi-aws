// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
package provider

import (
	"os"
	"path/filepath"
	"testing"
	"time"

	"github.com/pulumi/providertest"
	"github.com/pulumi/providertest/optproviderupgrade"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/stretchr/testify/require"
)

func TestUpgradeCoverage(t *testing.T) {
	providertest.ReportUpgradeCoverage(t)
}

func getEnvRegion(t *testing.T) string {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		envRegion = "us-west-2"
	}
	return envRegion
}

type testProviderUpgradeOptions struct {
	baselineVersion string
	linkNodeSDK     bool
	installDeps     bool
	setEnvRegion    bool
	region          string
	extraOpts       []opttest.Option
}

func skipIfShort(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without credentials")
	}

}
func testProviderUpgrade(t *testing.T, dir string, opts *testProviderUpgradeOptions) {
	skipIfShort(t)
	t.Parallel()
	t.Helper()
	var (
		providerName    string = "aws"
		baselineVersion string = "5.42.0"
	)
	if opts != nil && opts.baselineVersion != "" {
		baselineVersion = opts.baselineVersion
	}
	cwd, err := os.Getwd()
	require.NoError(t, err)
	options := []opttest.Option{
		opttest.DownloadProviderVersion(providerName, baselineVersion),
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
	}
	if opts == nil || !opts.installDeps {
		options = append(options, opttest.SkipInstall())
	}
	if opts != nil && opts.linkNodeSDK {
		options = append(options, opttest.YarnLink("@pulumi/aws"))
	}
	if opts != nil {
		options = append(options, opts.extraOpts...)
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	if opts != nil && opts.setEnvRegion {
		test.SetConfig("aws:region", "INVALID_REGION")
		test.SetConfig("aws:envRegion", getEnvRegion(t))
	}
	if opts != nil && opts.region != "" {
		test.SetConfig("aws:region", opts.region)
	}
	result := providertest.PreviewProviderUpgrade(
		test, providerName, baselineVersion, optproviderupgrade.DisableAttach(),
	)
	assertpreview.HasNoReplacements(t, result)
}

func pulumiTest(t *testing.T, dir string, opts ...opttest.Option) *pulumitest.PulumiTest {
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without AWS creds")
		return nil
	}
	cwd, err := os.Getwd()
	if err != nil {
		t.Error(err)
	}
	opts = append(opts, opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")))
	ptest := pulumitest.NewPulumiTest(t, dir, opts...)
	return ptest
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
