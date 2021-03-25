module github.com/pulumi/pulumi-aws/provider/v4

go 1.16

require (
	github.com/hashicorp/aws-sdk-go-base v0.7.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v3 v3.0.0-20210325101119-03683ad99004
	github.com/pulumi/pulumi/pkg/v3 v3.0.0-20210324220902-b543e235f01d
	github.com/pulumi/pulumi/sdk/v3 v3.0.0-20210324220902-b543e235f01d
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20210402103405-f5979773e8ba
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20210412195338-1305806c3f65
)
