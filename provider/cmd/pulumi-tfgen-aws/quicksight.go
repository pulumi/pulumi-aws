// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"strings"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

// We removed the `definition` property from quicksights.Template, see
// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
// But the types are still present in the schema, which pollutes the Go SDK
// specifically. This function removes those types from the schema.
func removeUnusedQuicksightTypes(pulumiPackageSpec *schema.PackageSpec) {
	var elidedTypes []string
	for tok := range pulumiPackageSpec.Types {
		if strings.Contains(tok, ":quicksight/AnalysisDefinition") ||
			strings.Contains(tok, ":quicksight/DashboardDefinition") ||
			strings.Contains(tok, ":quicksight/TemplateDefinition") {
			elidedTypes = append(elidedTypes, tok)
		}
	}
	for _, tok := range elidedTypes {
		delete(pulumiPackageSpec.Types, tok)
	}
}
