module github.com/pulumi/pulumi-aws/provider/v5

go 1.16

require (
	github.com/hashicorp/aws-sdk-go-base v1.1.0
	github.com/hashicorp/terraform-provider-aws/shim v0.0.0
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v3 v3.21.1-0.20220422074135-be182c2bda8d
	github.com/pulumi/pulumi/pkg/v3 v3.30.0
	github.com/pulumi/pulumi/sdk/v3 v3.30.0
)

replace (
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20211230170131-3a7c83bfab87
	github.com/hashicorp/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20220421115245-697526a3c5f6
	github.com/hashicorp/terraform-provider-aws/shim => ./shim
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
)
