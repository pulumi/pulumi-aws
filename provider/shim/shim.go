package shim

import (
	"context"

	pfprovider "github.com/hashicorp/terraform-plugin-framework/provider"
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/hashicorp/terraform-provider-aws/internal/provider"
	"github.com/hashicorp/terraform-provider-aws/internal/provider/fwprovider"
)

type UpstreamProvider struct {
	SDKV2Provider           *schema.Provider
	PluginFrameworkProvider pfprovider.Provider
}

func NewUpstreamProvider(ctx context.Context) (UpstreamProvider, error) {
	primary, err := provider.New(ctx)
	if err != nil {
		return UpstreamProvider{}, err
	}
	pf := fwprovider.New(primary)
	return UpstreamProvider{
		SDKV2Provider:           primary,
		PluginFrameworkProvider: pf,
	}, nil
}
