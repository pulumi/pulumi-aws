module github.com/pulumi/pulumi-aws/provider/v3

go 1.14

require (
	github.com/hashicorp/aws-sdk-go-base v0.6.0
	github.com/hashicorp/terraform-plugin-sdk v1.14.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v2 v2.10.4
	github.com/pulumi/pulumi/pkg/v2 v2.11.3-0.20201007154447-8da5c7532001
	github.com/pulumi/pulumi/sdk/v2 v2.11.3-0.20201007154447-8da5c7532001
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20200910230100-328eb4ff41df
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20201007202230-c55a1eb33f6a
)
