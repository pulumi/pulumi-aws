//go:build hack

package provider

import "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"

var MetadataInfo *tfbridge.MetadataInfo

func newMetadataInfo() *tfbridge.MetadataInfo {
	return MetadataInfo
}

func providerHooks(prov *tfbridge.ProviderInfo) {
}
