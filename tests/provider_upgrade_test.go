// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

package tests

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

	providerRC "github.com/pulumi/pulumi-aws/provider/v5"
	"github.com/pulumi/pulumi-aws/provider/v5/pkg/version"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"
)

const (
	acceptEnvVar   = "PULUMI_ACCEPT"
	providerBinary = "pulumi-resource-aws"
)

var (
	accept bool = os.Getenv(acceptEnvVar) != ""
)

func TestProviderUpdateQuick(t *testing.T) {
	info := newProviderUpgradeInfo(t)

	bytes, err := os.ReadFile(info.grpcFile)
	if err != nil {
		require.NoError(t, fmt.Errorf("No pre-recorded gRPC log found, try to run TestProviderUpgradeRecord %w", err))
	}

	n := 0
	for _, line := range strings.Split(string(bytes), "\n") {
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}

		// This is currently looking at Diff calls. Replaying V5 Diff calls against V6
		// provider is close but still not quite right. In the upgrade scenario we need to
		// compute hybrid Diff calls that take olds from V5 Diff calls and news from V6
		// Check, and ensure that these do not make replace plans.
		if isPureMethod(t, line) {
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
	return
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
	info.baselineProviderVersion = parseProviderVersion(t, filepath.Join(info.testCaseDir, "Pulumi.yaml"))
	info.recordingDir = filepath.Join("testdata", "recorded", info.baselineProviderVersion, "resources")
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

func importState(t *testing.T, pt *integration.ProgramTester, stateFile string) {
	tempDir := t.TempDir()
	newStateFile := filepath.Join(tempDir, "new-state.json")
	pt.RunPulumiCommand("stack", "export", "--file", newStateFile)
	stackName := parseStackName(t, readFile(t, newStateFile))
	fixedState := withUpdatedStackName(t, stackName, readFile(t, stateFile))
	fixedStateFile := filepath.Join(tempDir, "fixed-state.json")
	writeFile(t, fixedStateFile, []byte(fixedState))
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

func isPureMethod(t *testing.T, grpcLogEntry string) bool {
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

	return tfbridge.NewProvider(ctx, nil, "aws", version.Version, info.P, info, nil)
}
