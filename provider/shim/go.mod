module github.com/hashicorp/terraform-provider-aws/shim

go 1.16

require (
	github.com/hashicorp/terraform-plugin-sdk/v2 v2.10.1
	github.com/hashicorp/terraform-provider-aws v1.60.1-0.20211105002759-77bad27d9f23
)

replace github.com/hashicorp/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20220121160414-9b658a2e6262
