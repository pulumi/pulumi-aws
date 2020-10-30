module github.com/pulumi/pulumi-aws/provider/v3

go 1.15

require (
	github.com/hashicorp/aws-sdk-go-base v0.7.0
	github.com/hashicorp/terraform-plugin-sdk v1.14.0 // indirect
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v2 v2.11.1-0.20201020163502-64cff1e50894
	github.com/pulumi/pulumi/pkg/v2 v2.12.1-0.20201019222817-89c956d18942
	github.com/pulumi/pulumi/sdk/v2 v2.12.0
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20200910230100-328eb4ff41df
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20201030111810-846d2ca92b29
)
