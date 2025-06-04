// Copyright 2016-2024, Pulumi Corporation. All rights reserved.

package provider

import (
	"encoding/json"
	"os"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/pkg/v3/codegen/testing/utils"
	"github.com/stretchr/testify/require"
)

const (
	schemaFile = "./cmd/pulumi-resource-aws/schema.json"
)

// NOTE: might need to re-run `make provider` to reproduce failures in this test.
func TestNoDanglingReferences(t *testing.T) {
	t.Parallel()

	// Check that minimal schema has no dangling references.
	bytes, err := os.ReadFile(schemaFile)
	require.NoError(t, err)

	var packageSpec schema.PackageSpec
	err = json.Unmarshal(bytes, &packageSpec)
	require.NoError(t, err)

	loader := schema.NewPluginLoader(utils.NewHostWithProviders(t.TempDir()))
	_, diags, err := schema.BindSpec(packageSpec, loader, schema.ValidationOptions{AllowDanglingReferences: false})
	require.NoError(t, err)

	for _, d := range diags {
		t.Logf("sev=%v summary: %s\n    detail: %s", d.Severity, d.Summary, d.Detail)
	}
	require.False(t, diags.HasErrors())
	t.Logf("Validated schema")

}
