// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

package tests

import (
	"encoding/json"
	"errors"
	"fmt"
	"io/fs"
	"os"
	"path/filepath"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"
	"gopkg.in/yaml.v2"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
)

var (
	accept bool = os.Getenv("PULUMI_ACCEPT") != ""
)

// Recording works, but how do we test state import?
func TestProviderUpgrade(t *testing.T) {
	testCaseDir := filepath.Join("testdata", "resources")
	awsVersion := parseProviderVersion(t, filepath.Join(testCaseDir, "Pulumi.yaml"))
	recordingDir := filepath.Join("testdata", "recorded", awsVersion, "resources")

	grpcFile, err := filepath.Abs(filepath.Join(recordingDir, "grpc.json"))
	require.NoError(t, err)

	stateFile, err := filepath.Abs(filepath.Join(recordingDir, "state.json"))
	require.NoError(t, err)

	env := []string{}
	opts := integration.ProgramTestOptions{
		Dir: testCaseDir,
	}

	if accept {
		ensureFolderExists(t, recordingDir)
		deleteFileIfExists(t, stateFile)
		deleteFileIfExists(t, grpcFile)
		env = append(env, fmt.Sprintf("PULUMI_DEBUG_GRPC=%s", grpcFile))
		test := opts.With(integration.ProgramTestOptions{
			Dir: testCaseDir,
			Env: env,
			ExportStateValidator: func(t *testing.T, state []byte) {
				writeFile(t, stateFile, state)
				t.Logf("wrote %s", stateFile)
			},
		})
		integration.ProgramTest(t, &test)
		return
	}

	previewCounter := 0
	var pt *integration.ProgramTester
	test := opts.With(integration.ProgramTestOptions{
		Dir: testCaseDir,
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
			importState(t, pt, stateFile)
			return nil, nil
		},
		SkipRefresh:      true,
		SkipExportImport: true,
	})
	pt = integration.ProgramTestManualLifeCycle(t, &test)
	err = pt.TestLifeCycleInitAndDestroy()
	require.NoError(t, err)
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

func assertMatchesJsonFileContents(t *testing.T, jsonData []byte, expectedFile string) {
	if accept {
		ensureFolderExists(t, filepath.Dir(expectedFile))
		err := os.WriteFile(expectedFile, jsonData, 0755)
		require.NoError(t, err)
		return
	}
	require.JSONEq(t, readFile(t, expectedFile), string(jsonData))
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
