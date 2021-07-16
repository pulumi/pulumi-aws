module github.com/pulumi/pulumi-aws/provider/v4

go 1.16

require (
	github.com/hashicorp/aws-sdk-go-base v0.7.1
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pulumi/pulumi-terraform-bridge/v3 v3.4.1-0.20210714215802-5020116ac4e6
	github.com/pulumi/pulumi/pkg/v3 v3.7.1-0.20210714212650-083fc64ff547
	github.com/pulumi/pulumi/sdk/v3 v3.7.1-0.20210714111852-eb8e1585c3b7
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20191010190908-1261a98537f2
)

replace (
	github.com/hashicorp/terraform-plugin-sdk/v2 => github.com/pulumi/terraform-plugin-sdk/v2 v2.0.0-20210402103405-f5979773e8ba
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v1.38.1-0.20210709102402-badaf9536d8b
)

replace github.com/pulumi/pulumi/pkg/v3 => ../../pulumi/pkg

replace github.com/pulumi/pulumi/sdk/v3 => ../../pulumi/sdk
