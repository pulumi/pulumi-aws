// Copyright 2016-2024, Pulumi Corporation.

package provider

import (
	_ "embed"
	"fmt"
	"strings"

	"github.com/pulumi/pulumi/pkg/v3/codegen/cgstrings"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

var replacer = strings.NewReplacer(
	// Replace dashes with underscores.
	"-", "_",
	// Xlarge would be a wrong capitalization, and also we have 2xlarge etc.
	// So we capitalize with a replacement.
	"xlarge", "XLarge",
)

func instanceTypeName(value string) (string, error) {
	replaced := replacer.Replace(value)
	parts := strings.Split(replaced, ".")
	if len(parts) != 2 {
		// Error on 2+ dots (like t4g.nano.odd)
		return "", fmt.Errorf("too many dots in %q", value)
	}
	for i, part := range parts {
		parts[i] = cgstrings.UppercaseFirst(part)
	}
	return strings.Join(parts, "_"), nil
}

//go:embed instance-types.txt
var instanceTypesTxt string

func instanceTypes() []schema.EnumValueSpec {
	values := strings.Split(instanceTypesTxt, "\n")

	results := []schema.EnumValueSpec{}
	for _, v := range values {
		if v == "" {
			continue
		}
		name, err := instanceTypeName(v)
		if err != nil {
			panic(err)
		}
		results = append(results, schema.EnumValueSpec{Value: v, Name: name})
	}

	return results
}
