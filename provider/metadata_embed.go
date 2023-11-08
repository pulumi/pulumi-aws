//go:build !hack

package provider

import (
	_ "embed"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

//go:embed cmd/pulumi-resource-aws/bridge-metadata.json
var metadata []byte

func newMetadataInfo() *tfbridge.MetadataInfo {
	return tfbridge.NewProviderMetadata(metadata)
}


func providerHooks(prov *tfbridge.ProviderInfo) {
	prov.SetAutonaming(255, "-")
	prov.MustApplyAutoAliases()
}
