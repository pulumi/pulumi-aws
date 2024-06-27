// Copyright 2016-2023, Pulumi Corporation.

package main

import (
	"context"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfgen/unrec"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
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
	if err := unrec.SimplifyRecursiveTypes(context.Background(), pulumiPackageSpec); err != nil {
		panic(err)
	}
}
