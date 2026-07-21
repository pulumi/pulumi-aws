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
		typeName := strings.Split(tok, ":")[2]
		// The recursive structures look like these currently:
		// RuleStatement has a few properties like
		// AndStatement, OrStatement, NotStatement, all of separate types.
		// AND and OR types have a `statements` array that points to the next
		// layer of statement types. Plugin Framework NOT types instead have
		// a scalar `statement` property. Both should point to the top-level
		// statement type recursively.
		var oldRef string
		propertyName := ""
		property, hasStatements := ts.Properties["statements"]
		if hasStatements {
			contract.Assertf(property.Items != nil, "statements property must be an array")
			oldRef = property.Items.Ref
			propertyName = "statements"
		} else if statementProperty, has := ts.Properties["statement"]; has {
			contract.Assertf(statementProperty.Ref != "", "statement property must reference a type")
			property = statementProperty
			oldRef = statementProperty.Ref
			propertyName = "statement"
		} else {
			continue
		}
		for _, rule := range rootStatementTypes {
			// Parent types also have a scalar `statement` property that references the
			// root. Only descendants participate in the recursive replacement.
			if !strings.HasPrefix(typeName, rule) || typeName == rule {
				continue
			}

			// Add the currently referenced type to the list to be elided.
			// Example of a reference:
			// #/types/aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement
			refType := strings.Split(oldRef, ":")[2]
			elidedRefs = append(elidedRefs, refType)

			// Build a reference to the nearest recursive statement type. Scope-down
			// logical statements recurse within their restricted statement set rather
			// than exposing root-only managed, rate-based, or rule-group statements.
			recursiveType := rule
			const scopeDownStatement = "ScopeDownStatement"
			if rule == "WebAclRuleStatement" {
				if index := strings.Index(typeName, scopeDownStatement); index >= 0 {
					recursiveType = typeName[:index+len(scopeDownStatement)]
				}
			}
			ref := fmt.Sprintf("#/types/aws:wafv2/%s:%[1]s", recursiveType)
			if propertyName == "statements" {
				ts.Properties[propertyName] = schema.PropertySpec{
					Description: property.Description,
					TypeSpec: schema.TypeSpec{
						Type: "array",
						Items: &schema.TypeSpec{
							Ref: ref,
						},
					},
				}
			} else {
				ts.Properties[propertyName] = schema.PropertySpec{
					Description: property.Description,
					TypeSpec: schema.TypeSpec{
						Ref: ref,
					},
				}
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
