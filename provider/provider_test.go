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

package provider

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/pulumi/providertest"
	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func providerServer(t *testing.T) pulumirpc.ResourceProviderServer {
	ctx := context.Background()
	version.Version = "0.0.1"
	info := Provider()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, *info,
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	require.NoError(t, err)
	return p
}

func test(t *testing.T, dir string, opts ...providertest.Option) *providertest.ProviderTest {
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without AWS creds")
	}
	opts = append(opts,
		providertest.WithProviderName("aws"),
		providertest.WithBaselineVersion("5.42.0"),
		providertest.WithResourceProviderServer(providerServer(t)),
	)
	return providertest.NewProviderTest(dir, opts...)
}
