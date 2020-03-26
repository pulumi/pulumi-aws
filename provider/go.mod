module github.com/pulumi/pulumi-aws/provider

go 1.13

require (
	github.com/hashicorp/aws-sdk-go-base v0.4.0
	github.com/hashicorp/terraform-plugin-sdk v1.7.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge v1.8.4-0.20200326020012-c5fd7318ced1
	github.com/pulumi/pulumi/sdk v0.0.0-20200325225746-80f1989600a3
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20200309122415-524e0b51e4f7
)
