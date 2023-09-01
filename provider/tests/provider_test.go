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

package test

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
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	require.NoError(t, err)
	testutils.ReplaySequence(t, p, sequence)
}

// This serves as a template for GRPC tests on pulumi-aws.
//
// This test is *not* run in CI, and is purely to serve as a local test for debugging.
func TestReplay(t *testing.T) {
	replaySequence(t, `[]`)
}

func TestRegressUnknownTags(t *testing.T) {
	repro := `
	[
	  {
	    "method": "/pulumirpc.ResourceProvider/Check",
	    "request": {
	      "urn": "urn:pulumi:p1::example-tags::eks:index:NodeGroupV2$aws:ec2/securityGroup:SecurityGroup::example-ng-tags-ng2-nodeSecurityGroup",
	      "olds": {},
	      "news": {
		"description": "Managed by Pulumi",
		"revokeRulesOnDelete": true,
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
		"vpcId": "vpc-4b82e033"
	      },
	      "randomSeed": "pm3N78209q8Aq/BJU17gDsIRv2BvC/geMb0WK/pMRQg="
	    },
	    "response": {
	      "inputs": {
		"__defaults": [
		  "name"
		],
		"description": "Managed by Pulumi",
		"name": "example-ng-tags-ng2-nodeSecurityGroup-8012419",
		"revokeRulesOnDelete": true,
		"vpcId": "vpc-4b82e033",
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9"
	      }
	    }
	  }
	]
	`
	replaySequence(t, repro)
}
