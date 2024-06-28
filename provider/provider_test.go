// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
package provider

import (
	"encoding/json"
	"fmt"
	"os"
	"path/filepath"
	"testing"
	"time"

	"github.com/pulumi/providertest"
	"github.com/pulumi/providertest/optproviderupgrade"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/optnewstack"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
	"github.com/stretchr/testify/assert"
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

type testProviderCodeChangesOptions struct {
	region               string
	firstProgram         []byte
	secondProgram        []byte
	firstProgramOptions  []opttest.Option
	secondProgramOptions []opttest.Option
}

// testProviderCodeChanges tests two different runs of a pulumi program. This allow you to run
// pulumi up with an initial program, change the code of the program and then run another pulumi command
func testProviderCodeChanges(t *testing.T, opts *testProviderCodeChangesOptions) *pulumitest.PulumiTest {
	skipIfShort(t)
	t.Parallel()
	t.Helper()

	workdir := t.TempDir()
	cacheDir := filepath.Join("testdata", "recorded", "TestProviderUpgrade", t.Name())
	err := os.MkdirAll(cacheDir, 0755)
	assert.NoError(t, err)
	stackExportFile := filepath.Join(cacheDir, "stack.json")

	err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), opts.firstProgram, 0o600)
	require.NoError(t, err)

	options := []opttest.Option{
		opttest.SkipInstall(),
		opttest.NewStackOptions(optnewstack.DisableAutoDestroy()),
	}
	for _, o := range opts.firstProgramOptions {
		options = append(options, o)
	}

	pt := pulumitest.NewPulumiTest(t, workdir, options...)
	region := "us-east-2"
	if opts != nil && opts.region != "" {
		region = opts.region
	}
	pt.SetConfig("aws:region", region)

	var export *apitype.UntypedDeployment
	export, err = tryReadStackExport(stackExportFile)
	if err != nil {
		pt.Up()
		grptLog := pt.GrpcLog()
		grpcLogPath := filepath.Join(cacheDir, "grpc.json")
		pt.T().Logf("writing grpc log to %s", grpcLogPath)
		grptLog.WriteTo(grpcLogPath)

		e := pt.ExportStack()
		export = &e
		err = writeStackExport(stackExportFile, export, true)
		assert.NoError(t, err)
	}

	secondOptions := []opttest.Option{
		opttest.SkipInstall(),
		opttest.NewStackOptions(optnewstack.EnableAutoDestroy()),
	}
	for _, o := range opts.secondProgramOptions {
		secondOptions = append(secondOptions, o)
	}
	err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), opts.secondProgram, 0o600)
	require.NoError(t, err)
	secondTest := pulumitest.NewPulumiTest(t, workdir, secondOptions...)
	secondTest.SetConfig("aws:region", region)
	secondTest.ImportStack(*export)

	return secondTest
}

// pulumiUpWithSnapshot will only run the up portion of the test if the plan has changed since the
// last time the test was run.
//
// This should be used when the plan is a good representation of what you are testing. Sometimes
// there are issues where the plan is consistent, but the apply fails. In those cases a snapshot test is not
// a good fit.
func pulumiUpWithSnapshot(t *testing.T, pulumiTest *pulumitest.PulumiTest) {
	workdir := os.TempDir()
	cwd, err := os.Getwd()
	assert.NoError(t, err)
	cacheDir := filepath.Join(cwd, "testdata", "recorded", "TestProviderUpgrade", t.Name())
	planFile := filepath.Join(cacheDir, "plan.json")
	if ok, _ := exists(planFile); ok {
		err := os.MkdirAll(cacheDir, 0755)
		assert.NoError(t, err)
		tmpPlanFile := filepath.Join(workdir, "plan.json")

		pulumiTest.Preview(optpreview.Plan(tmpPlanFile))

		if equal := planEqual(t, planFile, tmpPlanFile); equal {
			return
		}

		pulumiTest.T().Log("Plan is not equal, re-running up")
	}
	pulumiTest.Preview(optpreview.Plan(planFile))
	upResult := pulumiTest.Up(optup.Plan(planFile))
	fmt.Printf("stdout: %s \n", upResult.StdOut)
	fmt.Printf("stderr: %s \n", upResult.StdErr)
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

// writeStackExport writes the stack export to the given path creating any directories needed.
func writeStackExport(path string, snapshot *apitype.UntypedDeployment, overwrite bool) error {
	if snapshot == nil {
		return fmt.Errorf("stack export must not be nil")
	}
	dir := filepath.Dir(path)
	err := os.MkdirAll(dir, 0755)
	if err != nil {
		return err
	}
	stackBytes, err := json.MarshalIndent(snapshot, "", "  ")
	if err != nil {
		return err
	}
	pathExists, err := exists(path)
	if err != nil {
		return err
	}
	if pathExists && !overwrite {
		return fmt.Errorf("stack export already exists at %s", path)
	}
	return os.WriteFile(path, stackBytes, 0644)
}

// tryReadStackExport reads a stack export from the given file path.
// If the file does not exist, returns nil, nil.
func tryReadStackExport(path string) (*apitype.UntypedDeployment, error) {
	stackBytes, err := os.ReadFile(path)
	if err != nil {
		return nil, fmt.Errorf("failed to read stack export at %s: %v", path, err)
	}
	var stackExport apitype.UntypedDeployment
	err = json.Unmarshal(stackBytes, &stackExport)
	if err != nil {
		return nil, fmt.Errorf("failed to unmarshal stack export at %s: %v", path, err)
	}
	return &stackExport, nil
}

func exists(filePath string) (bool, error) {
	_, err := os.Stat(filePath)
	switch {
	case err == nil:
		return true, nil
	case !os.IsNotExist(err):
		return false, err
	}
	return false, nil
}

// cleanPlan removes fields that change every time, i.e. 'time' or 'seed'
func cleanPlan(t *testing.T, plan map[string]interface{}) map[string]interface{} {
	t.Helper()
	if val, exists := plan["resourcePlans"]; exists {
		resourcePlans := val.(map[string]interface{})
		for _, v := range resourcePlans {
			resourcePlan := v.(map[string]interface{})
			delete(resourcePlan, "seed")
		}
	}

	if val, exists := plan["manifest"]; exists {
		manifest := val.(map[string]interface{})
		delete(manifest, "time")
		delete(manifest, "version")
		delete(manifest, "magic")
	}

	return plan
}

func readPlan(t *testing.T, planPath string) map[string]interface{} {
	t.Helper()
	var firstData map[string]interface{}

	firstFile, err := os.ReadFile(planPath)
	assert.NoError(t, err)

	err = json.Unmarshal(firstFile, &firstData)
	assert.NoError(t, err)
	firstData = cleanPlan(t, firstData)

	return firstData
}

// planEqual asserts that two plans are equal
func planEqual(t *testing.T, firstPlan, secondPlan string) bool {
	t.Helper()
	firstPlanData := readPlan(t, firstPlan)
	secondPlanData := readPlan(t, secondPlan)

	return assert.Equal(t, firstPlanData, secondPlanData)
}
