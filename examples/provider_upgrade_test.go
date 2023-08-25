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
	jsonpb "google.golang.org/protobuf/encoding/protojson"
	"google.golang.org/protobuf/reflect/protoreflect"
	"gopkg.in/yaml.v2"

	providerRC "github.com/pulumi/pulumi-aws/provider/v6"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	// "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
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

func TestProviderUpgradeQuick(t *testing.T) {
	info := newProviderUpgradeInfo(t)

	bytes, err := os.ReadFile(info.grpcFile)
	if err != nil {
		require.NoError(t, fmt.Errorf("No pre-recorded gRPC log found, try to run "+
			"TestProviderUpgradeRecord %w", err))
	}

	eng := &mockPulumiEngine{
		provider:              providerServer(t),
		lastCheckRequestByURN: map[string]*pulumirpc.CheckRequest{},
	}

	for _, line := range strings.Split(string(bytes), "\n") {
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}
		line = ignoreStables(t, line)
		eng.replayGRPCLog(t, line)
	}
	require.NotEmptyf(t, eng.verifiedDiffResourceCounter, "Need at least one replay test")
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

		// TODO eks.Cluster fails refresh on 5.42.0
		SkipRefresh: true,
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

type mockPulumiEngine struct {
	provider                    pulumirpc.ResourceProviderServer
	lastCheckRequestByURN       map[string]*pulumirpc.CheckRequest
	verifiedDiffResourceCounter int
}

func (e *mockPulumiEngine) replayGRPCLog(t *testing.T, jsonLog string) {
	var entry jsonLogEntry
	err := json.Unmarshal([]byte(jsonLog), &entry)
	require.NoError(t, err)

	switch entry.Method {
	case "/pulumirpc.ResourceProvider/Check":
		req := unmarshalProto(t, entry.Request, new(pulumirpc.CheckRequest))
		e.recordCheck(t, req)
	case "/pulumirpc.ResourceProvider/Diff":
		req := unmarshalProto(t, entry.Request, new(pulumirpc.DiffRequest))
		e.fixupDiff(t, req)
		entry.Request = marshalProto(t, req)
		b, err := json.Marshal(entry)
		require.NoError(t, err)
		testutils.Replay(t, e.provider, string(b))
		e.verifiedDiffResourceCounter++
		t.Logf("Replayed Diff on %v", req.Urn)
	}
}

func (e *mockPulumiEngine) recordCheck(t *testing.T, checkReq *pulumirpc.CheckRequest) {
	e.lastCheckRequestByURN[checkReq.Urn] = checkReq
}

func (e *mockPulumiEngine) fixupDiff(t *testing.T, diffReq *pulumirpc.DiffRequest) {
	ctx := context.Background()
	lastCheck, ok := e.lastCheckRequestByURN[diffReq.Urn]
	require.Truef(t, ok, "Diff called for %q but there is no recent Check for this URN", diffReq.Urn)

	// Assuming here that CheckRequest does not depend on the provider version, so that replaying
	// a pre-recorded Check request from old provider on the new RC provider is reasonable.
	checkResp, err := e.provider.Check(ctx, lastCheck)
	require.NoError(t, err)

	// Emulate the real engine would be passing checked inputs into the News field of the
	// DiffRequest and then replay this updated request against the provider.
	diffReq.News = checkResp.GetInputs()
}

type jsonLogEntry struct {
	Method   string          `json:"method"`
	Request  json.RawMessage `json:"request,omitempty"`
	Response json.RawMessage `json:"response,omitempty"`
}

func unmarshalProto[T protoreflect.ProtoMessage](t *testing.T, data json.RawMessage, req T) T {
	err := jsonpb.Unmarshal([]byte(data), req)
	require.NoError(t, err)
	return req
}

func marshalProto[T protoreflect.ProtoMessage](t *testing.T, req T) json.RawMessage {
	bytes, err := jsonpb.Marshal(req)
	require.NoError(t, err)
	return bytes
}
