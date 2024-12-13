// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/stretchr/testify/assert"
)

func TestReplaceWafV2TypesWithRecursive(t *testing.T) {
	t.Parallel()

	spec := schema.PackageSpec{
		Types: map[string]schema.ComplexTypeSpec{
			// Root statement - keep it.
			"aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"andStatement": {
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/RuleGroupRuleStatementAndStatement:RuleGroupRuleStatementAndStatement",
							},
						},
					},
				},
			},
			// Root's AND statement - keep it, but replace its reference to root recursively.
			"aws:wafv2/RuleGroupRuleStatementAndStatement:RuleGroupRuleStatementAndStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"statements": {
							TypeSpec: schema.TypeSpec{
								Type: "array",
								Items: &schema.TypeSpec{
									Ref: "#/types/aws:wafv2/RuleGroupRuleStatementAndStatementStatement:RuleGroupRuleStatementAndStatementStatement",
								},
							},
						},
					},
				},
			},
			// Non-root statement - elide.
			"aws:wafv2/RuleGroupRuleStatementAndStatementStatement:RuleGroupRuleStatementAndStatementStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"andStatement": {
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/RuleGroupRuleStatementAndStatementStatementAndStatement:RuleGroupRuleStatementAndStatementStatementAndStatement",
							},
						},
					},
				},
			},
			// Not-root statement's child type - elide.
			"aws:wafv2/RuleGroupRuleStatementAndStatementStatementAndStatement:RuleGroupRuleStatementAndStatementStatementAndStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"statements": {
							TypeSpec: schema.TypeSpec{
								Type: "array",
								Items: &schema.TypeSpec{
									Ref: "#/types/aws:wafv2/RuleGroupRuleStatementAndStatementStatementAndStatementStatement:RuleGroupRuleStatementAndStatementStatementAndStatementStatement",
								},
							},
						},
					},
				},
			},
		},
	}
	replaceWafV2TypesWithRecursive(&spec)

	// Two types elided, two remaining.
	assert.Equal(t, 2, len(spec.Types))

	// Root statement is still present.
	statement := spec.Types["aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement"]
	assert.NotNil(t, statement)

	// Reference got re-written to the root Statement.
	andStatement := spec.Types["aws:wafv2/RuleGroupRuleStatementAndStatement:RuleGroupRuleStatementAndStatement"]
	assert.Equal(t, "#/types/aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement", andStatement.Properties["statements"].Items.Ref)
}
