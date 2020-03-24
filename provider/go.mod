module github.com/pulumi/pulumi-aws/provider

go 1.13

require (
	github.com/hashicorp/aws-sdk-go-base v0.4.0
	github.com/hashicorp/terraform-plugin-sdk v1.8.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge v1.8.4-0.20200324171222-47e4398e2b4b
	github.com/pulumi/pulumi/sdk v0.0.0-20200322194843-61928f04e052
	github.com/terraform-providers/terraform-provider-aws v1.60.0
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/pulumi/pulumi-terraform-bridge => ../../pulumi-terraform-bridge
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20200309122415-524e0b51e4f7
)
