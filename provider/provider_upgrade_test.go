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
	"path/filepath"
	"testing"

	"github.com/stretchr/testify/require"

	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"

	ptest "github.com/pulumi/providertest"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

// Check that no update or replace plans are generated for select resources when upgrading stacks
// from a baseline version of the provider to the current version.
//
// To run in Quick mode (no cloud):
//
//	go test -run 'TestProviderUpgrade/.*/Quick'
//
// To run in PreviewOnly mode, configure cloud credentials and run:
//
//	go test -run 'TestProviderUpgrade/.*/PreviewOnly'
//
// To re-record baselines, configure cloud credentials and run something like this:
//
//	PULUMI_ACCEPT=1 go test -run TestProviderUpgrade/bucket
//
// You can also use built-in -short flag when unit-testing, which only runs the Quick mode.
//
//	go test -short
//
// To change the baseline version, edit testdata/resources/Pulumi.yaml provider.options.version, and
// re-record baselines.
func TestProviderUpgrade(t *testing.T) {

	type testCase struct {
		program string
	}

	testCases := []testCase{
		{"bucket"},
		{"eks-cluster"},
		{"rds-instance"},
		{"route53-resolver-endpoint"},
	}

	test := func(t *testing.T, tc testCase) {
		ptest.VerifyUpgrade(t).
			WithProviderName("aws").
			WithBaselineVersion("5.42.0").
			WithProgram(filepath.Join("test-programs", tc.program)).
			WithResourceProviderServer(providerServer(t)).
			// Updating from the current baseline version generates an Update plan on
			// the provider, but not any of the resources. There are ProgramTest options
			// like AllowEmptyPreviewChanges that would allow the test to pass, but they
			// stop detecting resource Updates which is not acceptable. Perpahs there is
			// a way to AllowEmptyPreviewChanges in combination with manual gRPC log
			// checks to get to check only resources, and not the provider for upgrades.
			//
			// In the meanwhile verification relies on TestProviderUpgradeQuick
			// in-memory test.
			Skip(ptest.UpgradeTestMode_PreviewOnly,
				"TODO[pulumi/pulumi-aws#2722] skip because of "+
					"Updates on explicit provider").
			Run()

	}

	for _, tc := range testCases {
		tc := tc
		t.Run(tc.program, func(t *testing.T) {
			test(t, tc)
		})
	}
}

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
