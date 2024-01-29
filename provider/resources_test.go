package provider

import (
	"context"
	"testing"

	"github.com/pulumi/providertest/replay"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/assert"
)

func TestParseDuration(t *testing.T) {
	for _, v := range []string{
		"1",
		"60",
		"3600",
		"86400",
		"1s",
		"60s",
		"3600s",
	} {
		valid := resource.PropertyMap{
			"durationSeconds": resource.NewStringProperty(v),
		}
		d, err := durationFromConfig(valid, "durationSeconds")
		assert.NoError(t, err)
		assert.NotNil(t, d)
	}
}

func TestHasNonComputedTagsAndTagsAllOptimized(t *testing.T) {
	p := Provider()
	p.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
		actual := hasNonComputedTagsAndTagsAllOptimized(key, value)
		expected := hasNonComputedTagsAndTagsAll(key, value)
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)
	for rn, r := range upstreamProvider.SDKV2Provider.ResourcesMap {
		if r.SchemaFunc != nil {
			res, ok := p.P.ResourcesMap().GetOk(rn)
			if ok {
				v := hasNonComputedTagsAndTagsAll(rn, res)
				t.Logf("Should cache %v: %s", v, rn)
			}
		}
	}
}

func TestHasOptionalOrRequiredNamePropertyOptimized(t *testing.T) {
	p := Provider()
	p.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
		actual := hasOptionalOrRequiredNameProperty(p.P, key)
		expected := hasOptionalOrRequiredNamePropertyOptimized(p.P, key)
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)
	for rn, r := range upstreamProvider.SDKV2Provider.ResourcesMap {
		if r.SchemaFunc != nil {
			v := hasOptionalOrRequiredNameProperty(p.P, rn)
			t.Logf("Should cache %v: %s", v, rn)
		}
	}
}

func TestImportMissingRefreshSchedule(t *testing.T) {
	replay.ReplaySequence(t, providerServer(t), `
[
  {
    "method": "/pulumirpc.ResourceProvider/Configure",
    "request": {
      "variables": {
        "aws:config:region": "eu-central-1",
        "aws:config:skipCredentialsValidation": "false",
        "aws:config:skipMetadataApiCheck": "true",
        "aws:config:skipRegionValidation": "true"
      },
      "args": {
        "region": "eu-central-1",
        "skipCredentialsValidation": "false",
        "skipMetadataApiCheck": "true",
        "skipRegionValidation": "true",
        "version": "6.18.2"
      },
      "acceptSecrets": true,
      "acceptResources": true,
      "sendsOldInputs": true,
      "sendsOldInputsToDelete": true
    },
    "response": {
      "supportsPreview": true
    },
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    }
  },
  {
    "method": "/pulumirpc.ResourceProvider/Read",
    "request": {
      "id": "616138583583,f97a0c01-e04c-4919-9edd-dacb36b72be8,5dac165c-ba31-407d-a3a3-8852b9af1f4b",
      "urn": "urn:pulumi:dev::ts::aws:quicksight/refreshSchedule:RefreshSchedule::example2",
      "properties": {}
    },
    "response": {
      "properties": {},
      "inputs": {}
    },
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    }
  }
]`)
}
