module github.com/pulumi/pulumi-aws/provider/v2

go 1.14

require (
	github.com/hashicorp/aws-sdk-go-base v0.4.0
	github.com/hashicorp/terraform-plugin-sdk v1.13.1
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v2 v2.4.1-0.20200611172440-d3f6b9ed94d9
	github.com/pulumi/pulumi/sdk/v2 v2.4.0
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20200616201417-ed844a7bd9d5
)
