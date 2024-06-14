// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"fmt"
	"strings"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// WafV2 has two problematic resources with massive schemas.
// Because TF can't represent recursive schema types, they brute-force
// generated approximations of recursive types a few layers down. Example:
// https://github.com/hashicorp/terraform-provider-aws/blob/5c5ab41aad82960be2dc8f0ed201098e260cd07a/internal/service/wafv2/schemas.go#L45
// This leads to massive SDK sizes on Pulumi size.
// Pulumi does support recursive types. The code below is a heuristic
// to find all references to all Statement types and replace those
// references with a reference to the single top-level Statement types.
func replaceWafV2TypesWithRecursive(pulumiPackageSpec *schema.PackageSpec) {
	rootStatementTypes := []string{"RuleGroupRuleStatement", "WebAclRuleStatement"}

	// We'll collect all referenced types that we replace with the root
	// type, so that we could remove all of elided types and their children.
	var elidedRefs []string
	for tok, ts := range pulumiPackageSpec.Types {
		// Skip everything except WafV2 types.
		if !strings.Contains(tok, ":wafv2/") {
			continue
		}
		// The recursive structures look like these currently:
		// RuleStatement has a few properties like
		// AndStatement, OrStatement, NotStatement, all of separate types.
		// Each of those types has a property `statements` that point
		// to the next layer of statement types, but should actually point
		// to the top one recursively.
		// So, we find all the `statements` properties (continue if not found).
		var oldRef string
		if prop, has := ts.Properties["statements"]; has {
			contract.Assertf(prop.TypeSpec.Items != nil, "statements property must be an array")
			oldRef = prop.TypeSpec.Items.Ref
		} else {
			continue
		}
		// Add the currently referenced type to the list to be elided.
		// Example of a reference:
		// #/types/aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement
		refType := strings.Split(oldRef, ":")[2]
		elidedRefs = append(elidedRefs, refType)
		// Get the current type name.
		typeName := strings.Split(tok, ":")[2]
		for _, rule := range rootStatementTypes {
			if !strings.HasPrefix(typeName, rule) {
				continue
			}
			// Build a reference to the root RuleStatement type and replace the property.
			ref := fmt.Sprintf("#/types/aws:wafv2/%s:%[1]s", rule)
			ts.Properties["statements"] = schema.PropertySpec{
				Description: "The statements to combine.",
				TypeSpec: schema.TypeSpec{
					Type: "array",
					Items: &schema.TypeSpec{
						Ref: ref,
					},
				},
			}
		}
	}

	// We collected a list of types `elidedRefs` that used to be referenced
	// by other types, but aren't anymore because we replaced them with
	// top-level references.
	// We want to remove all those types from the schema, and also we want
	// to remove all their subtypes. TF types are unidirectional, and our
	// naming is very predictable, so all the subtypes' names start with
	// the parent type name.
	// Loop through all types again and collect the ones that start with
	// one of the elided reference type.
	var elidedTypes []string
	for tok := range pulumiPackageSpec.Types {
		if !strings.Contains(tok, "wafv2") {
			continue
		}
		for _, ref := range elidedRefs {
			if strings.Contains(tok, ref) {
				elidedTypes = append(elidedTypes, tok)
				break
			}
		}
	}

	// Now remove all elided types from the schema.
	for _, tok := range elidedTypes {
		delete(pulumiPackageSpec.Types, tok)
	}
}
