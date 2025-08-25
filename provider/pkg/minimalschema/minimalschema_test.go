// Copyright 2016-2024, Pulumi Corporation. All rights reserved.

package minimalschema

import (
	"encoding/json"
	"fmt"
	"os"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"
)

const (
	minimalSchemaFile = "../../cmd/pulumi-resource-aws/schema-minimal.json"
)

// NOTE: might need to re-run `make provider` to reproduce failures in this test.
func TestNoDanglingReferencesInLightSchema(t *testing.T) {
	t.Parallel()

	// Check that minimal schema has no dangling references.
	bytes, err := os.ReadFile(minimalSchemaFile)
	require.NoError(t, err)

	var data any
	err = json.Unmarshal(bytes, &data)
	require.NoError(t, err)

	seen := map[string]struct{}{}

	types := data.(map[string]any)["types"].(map[string]any)
	resources := data.(map[string]any)["resources"].(map[string]any)

	danglingRefCount := 0
	totalCount := 0

	findReferences(data, func(reference any) {
		refName := reference.(string)
		switch {
		case strings.HasPrefix(refName, "#/types/"):
			totalCount++
			clean := strings.TrimPrefix(refName, "#/types/")
			if _, ok := types[clean]; !ok {
				if _, ok := seen[clean]; !ok {
					_, isRes := resources[clean]
					danglingRefCount++
					t.Logf("Dangling reference: %v (isRes=%v)", clean, isRes)
				}
				seen[clean] = struct{}{}
			}
		case refName == "pulumi.json#/Any" ||
			refName == "pulumi.json#/Asset" ||
			refName == "pulumi.json#/Archive":
			// Ignore known special type references.
			return
		// This special form is needed to register Call() methods on an explicit provider.
		// It is not considered a dangling reference.
		case refName == "#/provider":
			return
		default:
			require.Fail(t, fmt.Sprintf("Unexpected type reference kind: %q", refName))
		}
	})

	t.Logf("Checked %d references", totalCount)
	require.Equalf(t, 0, danglingRefCount, "Found at least 1 dangling reference")
}

func findReferences(schemaData any, found func(reference any)) {
	switch data := schemaData.(type) {
	case map[string]any:
		if reference, ok := data["$ref"]; ok {
			found(reference)
		}

		for _, value := range data {
			findReferences(value, found)
		}
	case []any:
		for _, value := range data {
			findReferences(value, found)
		}
	default:

	}
}
