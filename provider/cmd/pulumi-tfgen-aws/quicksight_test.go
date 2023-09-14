// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/stretchr/testify/assert"
)

func TestRemoveUnusedQuicksightTypes(t *testing.T) {
	spec := schema.PackageSpec{
		Types: map[string]schema.ComplexTypeSpec{
			// Unrelated quicksight type - keep.
			"aws:quicksight/AnalysisParameters:AnalysisParameters": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// Unrelated TemplateDefinition - keep.
			"aws:wafv2/TemplateDefinition:TemplateDefinition": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// AnalysisDefinition - elide.
			"aws:quicksight/AnalysisDefinition:AnalysisDefinition": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// Child of AnalysisDefinition - elide.
			"aws:quicksight/AnalysisDefinitionTemplateParameter:AnalysisDefinitionTemplateParameter": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// DashboardDefinition - elide.
			"aws:quicksight/DashboardDefinition:DashboardDefinition": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// Child of DashboardDefinition - elide.
			"aws:quicksight/DashboardDefinitionProperty:DashboardDefinitionProperty": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// TemplateDefinition - elide.
			"aws:quicksight/TemplateDefinition:TemplateDefinition": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
			// Child of TemplateDefinition - elide.
			"aws:quicksight/TemplateDefinitionSheetConfiguration:TemplateDefinitionSheetConfiguration": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Properties: map[string]schema.PropertySpec{},
				},
			},
		},
	}
	removeUnusedQuicksightTypes(&spec)

	// Six types elided, two remaining.
	assert.Equal(t, 2, len(spec.Types))

	// Unrelated types still present.
	_, has := spec.Types["aws:quicksight/AnalysisParameters:AnalysisParameters"]
	assert.True(t, has)
	_, has = spec.Types["aws:wafv2/TemplateDefinition:TemplateDefinition"]
	assert.True(t, has)
}
