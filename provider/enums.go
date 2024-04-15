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

	// Deprecated
	results = append(results, schema.EnumValueSpec{Name: "U_12tb1Metal", Value: "u-12tb1.metal", DeprecationMessage: "This instancetype has been deprecated"})
	results = append(results, schema.EnumValueSpec{Name: "U_6tb1Metal", Value: "u-6tb1.metal", DeprecationMessage: "This instancetype has been deprecated"})
	results = append(results, schema.EnumValueSpec{Name: "U_9tb1Metal", Value: "u-9tb1.metal", DeprecationMessage: "This instancetype has been deprecated"})
	results = append(results, schema.EnumValueSpec{Name: "Hs1_8XLarge", Value: "hs1.8xlarge", DeprecationMessage: "This instancetype has been deprecated"})
	results = append(results, schema.EnumValueSpec{Name: "M5as_XLarge", Value: "m5ad.xlarge", DeprecationMessage: "Has a typo, use M5ad_XLarge instead"})
	results = append(results, schema.EnumValueSpec{Name: "C7a_Metal", Value: "c7a.metal-48xl", DeprecationMessage: "Use C7a_Metal_48xl instead"})
	results = append(results, schema.EnumValueSpec{Name: "M7a_Metal", Value: "m7a.metal-48xl", DeprecationMessage: "Use M7a_Metal_48xl instead"})

	return results
}
