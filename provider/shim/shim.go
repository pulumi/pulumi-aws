package shim

import (
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/hashicorp/terraform-provider-aws/internal/conns"
	"github.com/hashicorp/terraform-provider-aws/internal/provider"
)

func NewProvider() *schema.Provider {
	return provider.Provider()
}

type AWSClient struct {
	*conns.AWSClient
}

func GetAWSClient(meta interface{}) AWSClient {
	return AWSClient{meta.(*conns.AWSClient)}
}
