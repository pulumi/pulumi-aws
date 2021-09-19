module github.com/pulumi/pulumi-aws/provider/v4

go 1.16

require (
	github.com/hashicorp/aws-sdk-go-base v0.7.1
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v3 v3.7.0
	github.com/pulumi/pulumi/pkg/v3 v3.12.0
	github.com/pulumi/pulumi/sdk/v3 v3.12.0
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20210629210550-59d24255d71f
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20210919140801-9f75bddc51fd
)
