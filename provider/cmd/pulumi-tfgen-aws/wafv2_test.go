// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

// The logical model this test exercises:
//
// A WAFv2 Rule matches traffic through a single top-level Statement. A
// Statement is either a *leaf* (e.g. ByteMatchStatement, SqliMatchStatement,
// ManagedRuleGroupStatement, RateBasedStatement) or a *logical* statement that
// combines other statements:
//
//   - AndStatement / OrStatement combine an array of child statements  ->  `statements`
//   - NotStatement negates a single child statement                    ->  `statement`
//
// So a rule expresses a boolean tree, for example:
//
//   AND( ByteMatch(...), NOT( GeoMatch(...) ), OR( SizeConstraint(...), Sqli(...) ) )
//
// This nesting is unbounded, but Terraform cannot represent recursive schema
// types, so upstream brute-forces a finite ladder of distinct types, one per
// depth level:
//
//   RuleStatement
//     -> RuleStatementAndStatement
//          -> RuleStatementAndStatementStatement
//               -> RuleStatementAndStatementStatementAndStatement
//                    -> ... (a few levels deep, then it stops)
//
// replaceWafV2TypesWithRecursive collapses that ladder back into genuine
// recursion: every descendant's `statement`/`statements` reference is rewritten
// to point at the nearest recursive root, and the now-unreachable intermediate
// ladder types are deleted. The two roots are RuleGroupRuleStatement and
// WebAclRuleStatement.
//
// Scope-down statements are the exception. A ManagedRuleGroupStatement or
// RateBasedStatement carries an optional `scopeDownStatement`, but AWS only
// allows that subtree to contain leaf/logical statements -- it may NOT nest
// another managed-rule-group, rate-based, or rule-group-reference statement.
// So the recursion inside a scope-down block must loop back to the
// `...ScopeDownStatement` node (its own restricted root), not to the unrestricted
// WebAclRuleStatement root. Rewriting it to the full root would let the generated
// SDKs accept e.g. a ManagedRuleGroupStatement inside a scope-down AndStatement,
// which the provider schema cannot decode and which AWS rejects at deploy time.
//
// The fixture below builds a minimal slice of that type graph -- both roots, a
// couple of ladder levels to be elided, a parent type that references a root via
// a scalar `statement`, the Plugin Framework NOT shape, and a managed-rule-group
// scope-down subtree -- and asserts the projection rewrites and elides exactly
// the right types.
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
							Description: "Statements to combine.",
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
	assert.Equal(t, "Statements to combine.", andStatement.Properties["statements"].Description)

	scopeDownNotStatement := spec.Types["aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementNotStatement"]
	assert.Equal(t, "#/types/aws:wafv2/WebAclRuleStatementManagedRuleGroupStatementScopeDownStatement:WebAclRuleStatementManagedRuleGroupStatementScopeDownStatement", scopeDownNotStatement.Properties["statement"].Ref)
	assert.Equal(t, "Scope-down statement to negate.", scopeDownNotStatement.Properties["statement"].Description)

	notStatement := spec.Types["aws:wafv2/WebAclRuleStatementNotStatement:WebAclRuleStatementNotStatement"]
	assert.Equal(t, "#/types/aws:wafv2/WebAclRuleStatement:WebAclRuleStatement", notStatement.Properties["statement"].Ref)
	assert.Equal(t, "Single statement to negate.", notStatement.Properties["statement"].Description)
	assert.NotContains(t, spec.Types, "aws:wafv2/WebAclRuleStatementNotStatementStatement:WebAclRuleStatementNotStatementStatement")
}
