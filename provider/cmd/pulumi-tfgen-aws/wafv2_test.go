// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
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
			// A parent type references the root through a scalar statement property.
			"aws:wafv2/WebAclRule:WebAclRule": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"statement": {
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/WebAclRuleStatement:WebAclRuleStatement",
							},
						},
					},
				},
			},
			// A second root statement type using the Plugin Framework NOT shape.
			"aws:wafv2/WebAclRuleStatement:WebAclRuleStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"notStatement": {
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/WebAclRuleStatementNotStatement:WebAclRuleStatementNotStatement",
							},
						},
					},
				},
			},
			// Plugin Framework NOT statements use a scalar statement property.
			"aws:wafv2/WebAclRuleStatementNotStatement:WebAclRuleStatementNotStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"statement": {
							Description: "Single statement to negate.",
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/WebAclRuleStatementNotStatementStatement:WebAclRuleStatementNotStatementStatement",
							},
						},
					},
				},
			},
			// The non-root NOT statement type is elided by the recursive projection.
			"aws:wafv2/WebAclRuleStatementNotStatementStatement:WebAclRuleStatementNotStatementStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"byteMatchStatement": {},
					},
				},
			},
			// New logical scope-down branches use scalar Plugin Framework NOT statements.
			"aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"notStatement": {
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement",
							},
						},
					},
				},
			},
			"aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"statement": {
							Description: "Scope-down statement to negate.",
							TypeSpec: schema.TypeSpec{
								Ref: "#/types/aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatementStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatementStatement",
							},
						},
					},
				},
			},
			"aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatementStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatementStatement": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{
						"byteMatchStatement": {},
					},
				},
			},
		},
	}
	replaceWafV2TypesWithRecursive(&spec)

	// Four types elided, seven remaining.
	assert.Len(t, spec.Types, 7)

	// Parent and root statement types are still present.
	assert.Contains(t, spec.Types, "aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement")
	assert.Contains(t, spec.Types, "aws:wafv2/WebAclRuleStatement:WebAclRuleStatement")
	webACLRule := spec.Types["aws:wafv2/WebAclRule:WebAclRule"]
	assert.Equal(t, "#/types/aws:wafv2/WebAclRuleStatement:WebAclRuleStatement", webACLRule.Properties["statement"].Ref)

	// Array and scalar references are re-written to their root statements.
	andStatement := spec.Types["aws:wafv2/RuleGroupRuleStatementAndStatement:RuleGroupRuleStatementAndStatement"]
	assert.Equal(t, "#/types/aws:wafv2/RuleGroupRuleStatement:RuleGroupRuleStatement", andStatement.Properties["statements"].Items.Ref)

	scopeDownNotStatement := spec.Types["aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement"]
	assert.Equal(t, "#/types/aws:wafv2/WebAclRuleStatement:WebAclRuleStatement", scopeDownNotStatement.Properties["statement"].Ref)
	assert.Equal(t, "Scope-down statement to negate.", scopeDownNotStatement.Properties["statement"].Description)

	notStatement := spec.Types["aws:wafv2/WebAclRuleStatementNotStatement:WebAclRuleStatementNotStatement"]
	assert.Equal(t, "#/types/aws:wafv2/WebAclRuleStatement:WebAclRuleStatement", notStatement.Properties["statement"].Ref)
	assert.Equal(t, "Single statement to negate.", notStatement.Properties["statement"].Description)
	assert.NotContains(t, spec.Types, "aws:wafv2/WebAclRuleStatementNotStatementStatement:WebAclRuleStatementNotStatementStatement")
}
