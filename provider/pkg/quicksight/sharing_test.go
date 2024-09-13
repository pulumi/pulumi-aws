package quicksight

import (
	"context"
	"encoding/json"
	"os"
	"testing"

	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	sdkv2 "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim/sdk-v2"
	"github.com/stretchr/testify/require"
)

// This is not a test but an entry point to recompute suggested sharing.
func TestUpdateQuicksightSharing(t *testing.T) {
	t.Skip("Not a test")
	ctx := context.Background()
	up, err := awsShim.NewUpstreamProvider(ctx)
	require.NoError(t, err)
	p := sdkv2.NewProvider(up.SDKV2Provider)
	confirmedSharing, err := readSharedTypesFile("shared-types.json")
	require.NoError(t, err)

	newSharing := detectSharing(confirmedSharing, p)

	for _, sh := range newSharing.Sharing {
		t.Logf("%s: %d", sh.Location.String(), len(sh.Similar))
	}

	newBytes, err := json.MarshalIndent(newSharing.rootsOnly(), "", "  ")
	require.NoError(t, err)
	err = os.WriteFile("shared-types-detected.json", newBytes, 0600)
	require.NoError(t, err)

	newBytes2, err := json.MarshalIndent(newSharing.rewritesOnly(), "", "  ")
	require.NoError(t, err)
	err = os.WriteFile("shared-types-rewrites.json", newBytes2, 0600)
	require.NoError(t, err)
}
