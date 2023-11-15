package provider

import (
	"context"
	"testing"

	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	"github.com/stretchr/testify/require"
)

func Test2971(t *testing.T) {
	replay(t, `[
  {
    "method": "/pulumirpc.ResourceProvider/Diff",
    "request": {
      "id": "nat-0bb7eabb49215fdd1",
      "urn": "urn:pulumi:dev::ts::aws:ec2/natGateway:NatGateway::ng",
      "olds": {
        "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":600000000000,\"delete\":1800000000000,\"update\":600000000000}}",
        "allocationId": "eipalloc-0e4c6a756ffd7c2b2",
        "associationId": "eipassoc-0fc75443d075f1968",
        "connectivityType": "public",
        "id": "nat-0bb7eabb49215fdd1",
        "networkInterfaceId": "eni-030b23dbe84977c26",
        "privateIp": "172.31.141.8",
        "publicIp": "35.167.220.21",
        "secondaryAllocationIds": [],
        "secondaryPrivateIpAddressCount": 0,
        "secondaryPrivateIpAddresses": [],
        "subnetId": "subnet-0b4f9fb1df1543b07",
        "tags": {},
        "tagsAll": {}
      },
      "news": {
        "__defaults": [
          "connectivityType"
        ],
        "allocationId": "eipalloc-0e4c6a756ffd7c2b2",
        "connectivityType": "public",
        "secondaryAllocationIds": [
          "eipalloc-0d4ec395e8e49a91e"
        ],
        "subnetId": "subnet-0b4f9fb1df1543b07"
      },
      "oldInputs": {
        "__defaults": [
          "connectivityType"
        ],
        "allocationId": "eipalloc-0e4c6a756ffd7c2b2",
        "connectivityType": "public",
        "subnetId": "subnet-0b4f9fb1df1543b07"
      }
    },
    "response": {
      "stables": "*",
      "changes": "DIFF_SOME",
      "diffs": [
        "secondaryAllocationIds"
      ],
      "detailedDiff": {
        "secondaryAllocationIds[0]": {}
      },
      "replaces": [
        "__meta"
      ],
      "hasDetailedDiff": true
    },
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    }
  }
]`)
}

func replay(t *testing.T, sequence string) {
	info := *Provider()
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
