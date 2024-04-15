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
	// It's a bit suspicious to drop this suffix but that's what we did manually.
	// There is a panic below in case we find some other -xxx suffix.
	"-48xl", "",
	// Xlarge would be a wrong capitalization, and also we have 2xlarge etc.
	// So we capitalize with a replacement.
	"xlarge", "XLarge",
)

func instanceTypeName(value string) (string, error) {
	replaced := replacer.Replace(value)
	if strings.Contains(replaced, "-") {
		// Error on any dash except for the -48xl suffix
		return "", fmt.Errorf("unexpected dash in %q", value)
	}

	parts := strings.Split(replaced, ".")
	if len(parts) != 2 {
		// Error on 2+ underscores (like T4g_Nano_Odd)
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

	return results
}
