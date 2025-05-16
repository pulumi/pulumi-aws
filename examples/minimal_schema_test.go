// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.
//go:build nodejs || all
// +build nodejs all

package examples

import (
	"bytes"
	"encoding/json"
	"os"
	"os/exec"
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/pkg/v3/codegen/testing/utils"
	"github.com/stretchr/testify/require"
)

func TestMinimalSchema(t *testing.T) {
	var buf bytes.Buffer
	schemaSource := filepath.Join("..", "bin", "pulumi-resource-aws")
	t.Logf("pulumi package get-schema %s", schemaSource)
	cmd := exec.Command("pulumi", "package", "get-schema", schemaSource)
	cmd.Env = append(os.Environ(), "PULUMI_AWS_MINIMAL_SCHEMA=true")
	cmd.Stdout = &buf
	err := cmd.Run()
	cmd.Stderr = os.Stderr
	if err != nil {
		t.Logf("%s", buf.String())
		require.NoError(t, err)
	}
	var packageSpec schema.PackageSpec
	err = json.Unmarshal(buf.Bytes(), &packageSpec)
	require.NoError(t, err)
	t.Logf("Parsed minimal schema")
	loader := schema.NewPluginLoader(utils.NewHostWithProviders(t.TempDir()))
	_, diags, err := schema.BindSpec(packageSpec, loader, schema.ValidationOptions{
		AllowDanglingReferences: true,
	})
	require.NoError(t, err)
	for _, d := range diags {
		t.Logf("sev=%v summary: %s\n    detail: %s", d.Severity, d.Summary, d.Detail)
	}
	require.False(t, diags.HasErrors())
	t.Logf("Validated minimal schema")
}
