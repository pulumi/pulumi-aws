// Copyright 2016-2023, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package provider

import (
	"context"
	"testing"

	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	"github.com/stretchr/testify/require"

	aws "github.com/pulumi/pulumi-aws/provider/v6"
	version "github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func init() {
	version.Version = "6.0.0"
}

func replaySequence(t *testing.T, sequence string) {
	info := *aws.Provider()
	ctx := context.Background()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, info,
		[]byte("{}"), /* We leave the schema blank. This will result in incorrect calls to
		   GetSchema, but otherwise does not effect the provider. */
	)(nil)
	require.NoError(t, err)
	testutils.ReplaySequence(t, p, sequence)
}

// Repro https://github.com/pulumi/pulumi-aws/issues/2633
func TestRegression2633(t *testing.T) {
	t.Run("changed tags",
		func(t *testing.T) { replaySequence(t, regress2633(true)) })
	t.Run("removed tags",
		func(t *testing.T) { replaySequence(t, regress2633(false)) })
}

func regress2633(hasTags bool) string {
	var args, vars string
	if hasTags {
		args = "\n" + `"defaultTags": "{\"tags\":{\"foo\":\"buzz\"}}",`
		vars = "\n" + `"aws:config:defaultTags": "{\"tags\":{\"foo\":\"buzz\"}}",`
	}
	return `[
  {
    "method": "/pulumirpc.ResourceProvider/Configure",
    "request": {
      "variables": {` + vars + `
        "aws:config:region": "us-west-2",
        "aws:config:skipCredentialsValidation": "false",
        "aws:config:skipMetadataApiCheck": "true",
        "aws:config:skipRegionValidation": "true"
      },
      "args": {` + args + `
        "region": "us-west-2",
        "skipCredentialsValidation": "false",
        "skipMetadataApiCheck": "true",
        "skipRegionValidation": "true"
      },
      "acceptSecrets": true,
      "acceptResources": true,
      "sendsOldInputs": true
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
    "method": "/pulumirpc.ResourceProvider/Diff",
    "request": {
      "id": "b-350b1e9",
      "urn": "urn:pulumi:test::secret-random-yaml::aws:s3/bucket:Bucket::b",
      "olds": {
        "accelerationStatus": "",
        "acl": "private",
        "arn": "arn:aws:s3:::b-350b1e9",
        "bucket": "b-350b1e9",
        "bucketDomainName": "b-350b1e9.s3.amazonaws.com",
        "bucketRegionalDomainName": "b-350b1e9.s3.us-west-2.amazonaws.com",
        "corsRules": [],
        "forceDestroy": false,
        "grants": [],
        "hostedZoneId": "Z3BJ6K6RIION7M",
        "id": "b-350b1e9",
        "lifecycleRules": [],
        "loggings": [],
        "objectLockConfiguration": null,
        "region": "us-west-2",
        "replicationConfiguration": null,
        "requestPayer": "BucketOwner",
        "serverSideEncryptionConfiguration": {
          "rule": {
            "applyServerSideEncryptionByDefault": {
              "kmsMasterKeyId": "",
              "sseAlgorithm": "AES256"
            },
            "bucketKeyEnabled": false
          }
        },
        "tags": {},
        "tagsAll": {
          "foo": "bar"
        },
        "versioning": {
          "enabled": false,
          "mfaDelete": false
        },
        "website": null
      },
      "news": {
        "__defaults": [
          "acl",
          "bucket",
          "forceDestroy"
        ],
        "acl": "private",
        "bucket": "b-350b1e9",
        "forceDestroy": false
      },
      "oldInputs": {
        "__defaults": [
          "acl",
          "bucket",
          "forceDestroy"
        ],
        "acl": "private",
        "bucket": "b-350b1e9",
        "forceDestroy": false
      }
    },
    "response": {
      "stables": "*",
      "changes": "DIFF_SOME",
      "hasDetailedDiff": true
    },
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    }
  }
]`
}
