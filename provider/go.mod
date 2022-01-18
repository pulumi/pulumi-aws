module github.com/pulumi/pulumi-aws/provider/v4

go 1.16

require (
	github.com/hashicorp/aws-sdk-go-base v1.0.0
	github.com/hashicorp/terraform-provider-aws/shim v0.0.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v3 v3.11.0
	github.com/pulumi/pulumi/pkg/v3 v3.17.0
	github.com/pulumi/pulumi/sdk/v3 v3.17.0
)

replace (
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20210629210550-59d24255d71f
	github.com/hashicorp/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20220121160414-9b658a2e6262
	github.com/hashicorp/terraform-provider-aws/shim => ./shim
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
)
