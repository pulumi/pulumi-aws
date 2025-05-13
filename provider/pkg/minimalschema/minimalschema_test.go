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
	minimalSchemaFile = "../../cmd/pulumi-resource-aws/schema.json"
)

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

	findReferences(data, func(rr any) {
		r := rr.(string)
		switch {
		case strings.HasPrefix(r, "#/types/"):
			totalCount++
			clean := strings.TrimPrefix(r, "#/types/")
			if _, ok := types[clean]; !ok {
				if _, s := seen[clean]; !s {
					_, isRes := resources[clean]
					danglingRefCount++
					t.Logf("Dangling reference: %v (isRes=%v)", clean, isRes)
				}
				seen[clean] = struct{}{}
			}
		case r == "pulumi.json#/Any" ||
			r == "pulumi.json#/Asset" ||
			r == "pulumi.json#/Archive":
			// Ignore known special type references.
			return
		default:
			require.Fail(t, fmt.Sprintf("Unexpected type reference kind: %q", r))
		}
	})

	t.Logf("Checked %d references", totalCount)
	require.Equalf(t, 0, danglingRefCount, "Found at least 1 dangling reference")
}

func findReferences(x any, found func(r any)) {
	switch x := x.(type) {
	case map[string]any:
		if r, ok := x["$ref"]; ok {
			found(r)
		}

		for _, v := range x {
			findReferences(v, found)
		}
	case []any:
		for _, v := range x {
			findReferences(v, found)
		}
	default:

	}
}
