package shim

import (
	"context"
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/hashicorp/terraform-provider-aws/internal/provider"
)

func NewProvider() *schema.Provider {
	prov, _ := provider.New(context.Background())
	return prov
}
