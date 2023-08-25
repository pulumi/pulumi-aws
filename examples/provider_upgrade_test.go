// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build java || all
// +build java all

// Experimental provider upgrade tests.
//
// The objective of these tests is to make sure the provider release candidate will not generate any
// Update or Replace plans for Pulumi stacks deployed on a previous baseline version of the
// provider.
//
// Note on build flags above --^ these tests currently uses YAML only but our build workflow matrix
// does not run YAML-only test a the moment, and it splits tests by language build tag; for this
// reason the file is marked as another language so that the test runs only once.

package examples

import (
	"context"
	"encoding/json"
	"errors"
	"fmt"
	"io/fs"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"
	"gopkg.in/yaml.v2"

	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/cmdutil"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"

	providerRC "github.com/pulumi/pulumi-aws/provider/v6"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

const (
	acceptEnvVar   = "PULUMI_ACCEPT"
	providerBinary = "pulumi-resource-aws"
)

var (
	accept bool = cmdutil.IsTruthy(acceptEnvVar)
)

func TestProviderUpgradeQuick(t *testing.T) {
	// This is currently looking at Diff calls. Replaying V5 Diff calls against V6
	// provider is close but still not quite right. In the upgrade scenario we need to
	// compute hybrid Diff calls that take olds from V5 Diff calls and news from V6
	// Check, and ensure that these do not make replace plans.
	t.Skip("Skipping due to a spurious failure")

	info := newProviderUpgradeInfo(t)

	bytes, err := os.ReadFile(info.grpcFile)
	require.NoErrorf(t, err, "No pre-recorded gRPC log found, try to run TestProviderUpgradeRecord")

	n := 0
	for _, line := range strings.Split(string(bytes), "\n") {
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}

		if isDiffRecord(t, line) {
			line = ignoreStables(t, line)
			n++
			testutils.Replay(t, providerServer(t), line)
		}
	}
	require.NotEmptyf(t, n, "Need at least one replay test")
}

func TestProviderUpgradeRecord(t *testing.T) {
	if !accept {
		t.Skipf("Skipping; to record baselines set %s env var to true", acceptEnvVar)
	}
	info := newProviderUpgradeInfo(t)
	ambientProvider, _ := exec.LookPath(providerBinary)
	require.Emptyf(t, ambientProvider, "please remove the provider from PATH")
	ensureFolderExists(t, info.recordingDir)
	deleteFileIfExists(t, info.stateFile)
	deleteFileIfExists(t, info.grpcFile)
	test := info.opts.With(integration.ProgramTestOptions{
		Env: append(info.opts.Env, fmt.Sprintf("PULUMI_DEBUG_GRPC=%s", info.grpcFile)),
		ExportStateValidator: func(t *testing.T, state []byte) {
			writeFile(t, info.stateFile, state)
			t.Logf("wrote %s", info.stateFile)
		},
	})
	integration.ProgramTest(t, &test)
}

func TestProviderUpgrade(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping in -short mode")
	}
	if accept {
		t.Skipf("Skipping because %s env var is set", acceptEnvVar)
	}
	info := newProviderUpgradeInfo(t)
	t.Logf("Baseline provider version: %s", info.baselineProviderVersion)

	env := []string{}
	opts := integration.ProgramTestOptions{
		Dir: info.testCaseDir,
	}

	ambientProvider, _ := exec.LookPath(providerBinary)
	require.NotEmptyf(t, ambientProvider, "expected to find a release candidate provider "+
		"binary in PATH, try to call `make provider` and `export PATH=$PWD/bin:$PATH`")

	previewCounter := 0
	var pt *integration.ProgramTester
	test := opts.With(integration.ProgramTestOptions{
		Env: env,
		PrePulumiCommand: func(verb string) (func(err error) error, error) {
			if verb != "preview" {
				return nil, nil
			}
			previewCounter++
			if previewCounter != 2 {
				return nil, nil
			}
			t.Logf("Importing pre-recorded stateFile")
			importState(t, pt, info.stateFile)
			return nil, nil
		},
		SkipRefresh:      true,
		SkipExportImport: true,

		// TODO this test is not quite right. There's two designs for an upgrade test, a
		// preview-only one design and an full update design. This is currently neither.
		//
		// A preview-only design would import V5 state and run pulumi preview on V6 to
		// assert empty preview. To make this code behave like this we need to run
		// SkipUpdate: true but this currently messes up with stack name renaming pass that
		//
		// SkipUpdate:       true,
		//
		// A full update design would provision actual cloud infra on V5 and do a full
		// pulumi-up on V6. This can be useful if for example update plans are permitted
		// (only replaces are rejected) but we need to verify that the actual update plans
		// execute successfully or if the provider update does not touch the infra but
		// updates the state file and we need to test that.
		//
		// What this code does: provision infra on V6, then import V5 state, then do pulumi
		// up. This mostly works as a preview test, but does unnecessary "up" work.
	})
	pt = integration.ProgramTestManualLifeCycle(t, &test)
	err := pt.TestLifeCycleInitAndDestroy()
	require.NoError(t, err)
}

type providerUpgradeInfo struct {
	testCaseDir             string
	recordingDir            string
	baselineProviderVersion string
	grpcFile                string
	stateFile               string
	opts                    integration.ProgramTestOptions
}

func newProviderUpgradeInfo(t *testing.T) providerUpgradeInfo {
	info := providerUpgradeInfo{}
	info.testCaseDir = filepath.Join("testdata", "resources")
	pyaml := filepath.Join(info.testCaseDir, "Pulumi.yaml")
	v := parseProviderVersion(t, pyaml)
	info.baselineProviderVersion = v
	info.recordingDir = filepath.Join("testdata", "recorded", v, "resources")
	var err error
	info.grpcFile, err = filepath.Abs(filepath.Join(info.recordingDir, "grpc.json"))
	require.NoError(t, err)
	info.stateFile, err = filepath.Abs(filepath.Join(info.recordingDir, "state.json"))
	require.NoError(t, err)
	info.opts = integration.ProgramTestOptions{
		Dir: info.testCaseDir,
	}
	return info
}

func currentStackName(t *testing.T, pt *integration.ProgramTester) string {
	tempDir := t.TempDir()
	curStateFile := filepath.Join(tempDir, "temp-state.json")
	pt.RunPulumiCommand("stack", "export", "--file", curStateFile)
	curState := readFile(t, curStateFile)
	return parseStackName(t, curState)
}

func fixupStackName(t *testing.T, pt *integration.ProgramTester, stateFile string) string {
	tempDir := t.TempDir()
	stackName := currentStackName(t, pt)
	state := readFile(t, stateFile)
	fixedState := withUpdatedStackName(t, stackName, state)
	fixedStateFile := filepath.Join(tempDir, "fixed-state.json")
	writeFile(t, fixedStateFile, []byte(fixedState))
	return fixedStateFile
}

func importState(t *testing.T, pt *integration.ProgramTester, stateFile string) {
	fixedStateFile := fixupStackName(t, pt, stateFile)
	pt.RunPulumiCommand("stack", "import", "--file", fixedStateFile)
}

func parseStackName(t *testing.T, state string) string {
	type model struct {
		Deployment struct {
			Resources []struct {
				URN  string `json:"urn"`
				Type string `json:"type"`
			} `json:"resources"`
		} `json:"deployment"`
	}
	var m model
	err := json.Unmarshal([]byte(state), &m)
	require.NoError(t, err)
	var stackUrn string
	for _, r := range m.Deployment.Resources {
		if r.Type == "pulumi:pulumi:Stack" {
			stackUrn = r.URN
		}
	}
	require.NotEmptyf(t, stackUrn, "failed to find stack URN")
	parts := strings.Split(strings.TrimPrefix(stackUrn, "urn:pulumi:"), "::")
	require.NotEmptyf(t, parts, "failed to parse stack URN: %v", stackUrn)
	require.NotEmptyf(t, parts[0], "found empty stack URN")
	return parts[0]
}

func withUpdatedStackName(t *testing.T, newStackName string, state string) string {
	return strings.ReplaceAll(state, parseStackName(t, state), newStackName)
}

func deleteFileIfExists(t *testing.T, file string) {
	err := os.Remove(file)
	if errors.Is(err, fs.ErrNotExist) {
		return
	}
	require.NoError(t, err)
}

func writeFile(t *testing.T, file string, data []byte) {
	ensureFolderExists(t, filepath.Dir(file))
	err := os.WriteFile(file, data, 0755)
	require.NoError(t, err)
}

func readFile(t *testing.T, file string) string {
	bytes, err := os.ReadFile(file)
	require.NoError(t, err)
	return string(bytes)
}

func ensureFolderExists(t *testing.T, dir string) {
	if _, err := os.Stat(dir); os.IsNotExist(err) {
		err = os.MkdirAll(dir, 0755)
		require.NoError(t, err)
	}
}

func parseProviderVersion(t *testing.T, yamlFile string) string {
	type model struct {
		Resources struct {
			Provider struct {
				Options struct {
					Version string `yaml:"version"`
				} `yaml:"options"`
			} `yaml:"provider"`
		} `json:"resources"`
	}
	bytes, err := os.ReadFile(yamlFile)
	require.NoError(t, err)
	var m model
	yaml.Unmarshal(bytes, &m)
	require.NoError(t, err)
	v := m.Resources.Provider.Options.Version
	require.NotEmptyf(t, v, "Failed to parse Pulumi.yaml: "+
		"resources.provider.options.version is empty")
	return v
}

// Looking at Diff methods only. Other pure methods to consider utilizing are Check and
// Create,Update in preview=true mode, Configure/CheckConfig.
func isDiffRecord(t *testing.T, grpcLogEntry string) bool {
	type model struct {
		Method string `json:"method"`
	}
	var m model
	err := json.Unmarshal([]byte(grpcLogEntry), &m)
	require.NoError(t, err)
	switch m.Method {
	case "/pulumirpc.ResourceProvider/Diff":
		return true
	default:
		return false
	}
}

func ignoreStables(t *testing.T, grpcLogEntry string) string {
	var v map[string]any
	err := json.Unmarshal([]byte(grpcLogEntry), &v)
	require.NoError(t, err)
	if r, ok := v["response"]; ok {
		r := r.(map[string]any)
		if _, ok := r["stables"]; ok {
			r["stables"] = "*"
		}
	}
	out, err := json.Marshal(v)
	require.NoError(t, err)
	return string(out)
}

func providerServer(t *testing.T) pulumirpc.ResourceProviderServer {
	ctx := context.Background()
	version.Version = "0.0.1"
	info := providerRC.Provider()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, *info,
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	require.NoError(t, err)
	return p
}
