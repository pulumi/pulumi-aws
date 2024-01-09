// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.
package provider

import (
	"context"
	"os"
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

func test(t *testing.T, dir string, opts ...providertest.Option) {
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without AWS creds")
		return
	}
	opts = append(opts,
		providertest.WithProviderName("aws"),
		providertest.WithBaselineVersion("5.42.0"),
		providertest.WithResourceProviderServer(providerServer(t)),
	)
	ptest := providertest.NewProviderTest(dir, opts...)
	ptest.Run(t)
}

func TestUpgradeCoverage(t *testing.T) {
	providertest.ReportUpgradeCoverage(t)
}

func getEnvRegion(t *testing.T) string {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		envRegion = "us-west-2"
	}
	return envRegion
}
