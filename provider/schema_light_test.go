// Copyright 2016-2023, Pulumi Corporation. All rights reserved.

package provider

import (
	"encoding/json"
	"fmt"
	"os"
	"strings"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	"github.com/stretchr/testify/require"
)

func TestNoDanglingReferencesInLightSchema(t *testing.T) {
	// Keep schema-light.json up to date for the check.
	var rawSchema schema.PackageSpec
	realSchemaFile := "cmd/pulumi-resource-aws/schema.json"
	lightSchemaFile := "cmd/pulumi-resource-aws/schema-light.json"
	bytes, err := os.ReadFile(realSchemaFile)
	contract.AssertNoErrorf(err, "failed to read schema.json")
	err = json.Unmarshal(bytes, &rawSchema)
	contract.AssertNoErrorf(err, "failed to unmarshal schema.json")
	newLightSchema(rawSchema).write(lightSchemaFile)

	// Check that schema-light.json has no dangling references.
	bytes, err = os.ReadFile(lightSchemaFile)
	require.NoError(t, err)

	var data any
	err = json.Unmarshal(bytes, &data)
	require.NoError(t, err)

	seen := map[string]struct{}{}

	types := data.(map[string]any)["types"].(map[string]any)
	resources := data.(map[string]any)["resources"].(map[string]any)

	danglingRefCount := 0

	findReferences(data, func(rr any) {
		r := rr.(string)
		switch {
		case strings.HasPrefix(r, "#/types/"):
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
