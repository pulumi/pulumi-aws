package shim

import (
	"context"

	pfprovider "github.com/hashicorp/terraform-plugin-framework/provider"
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/hashicorp/terraform-provider-aws/internal/provider"
	"github.com/hashicorp/terraform-provider-aws/internal/provider/fwprovider"
)

func NewProvider() *schema.Provider {
	prov, err := provider.New(context.Background())
	if err != nil {
		panic(err)
	}
	return prov
}

func NewPFProvider() pfprovider.Provider {
	primary, err := provider.New(context.Background())
	if err != nil {
		panic(err)
	}
	return fwprovider.New(primary)
}
