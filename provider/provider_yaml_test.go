// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
//
// Experimental provider upgrade tests.
//
// The objective of these tests is to make sure the provider release candidate will not generate any
// Update or Replace plans for Pulumi stacks deployed on a previous baseline version of the
// provider.
//
// Note on build flags above --^ these tests currently uses YAML only but our build workflow matrix
// does not run YAML-only test a the moment, and it splits tests by language build tag; for this
// reason the file is marked as another language so that the test runs only once.

//go:build !go && !nodejs && !python && !dotnet && !java
// +build !go,!nodejs,!python,!dotnet,!java

package provider

import (
	"path/filepath"
	"testing"
)

func TestBucket(t *testing.T) {
	test(t, filepath.Join("test-programs", "bucket")).Run(t)
}

func TestEKSCluster(t *testing.T) {
	test(t, filepath.Join("test-programs", "eks-cluster")).Run(t)
}

func TestRdsInstance(t *testing.T) {
	test(t, filepath.Join("test-programs", "rds-instance")).Run(t)
}

func TestRoute53ResolverEndpoint(t *testing.T) {
	test(t, filepath.Join("test-programs", "route53-resolver-endpoint")).Run(t)
}
