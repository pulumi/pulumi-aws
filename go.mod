module github.com/pulumi/pulumi-aws

go 1.12

require (
	github.com/Azure/go-autorest/autorest v0.8.0 // indirect
	github.com/Azure/go-autorest/autorest/azure/auth v0.1.0 // indirect
	github.com/Azure/go-autorest/autorest/to v0.2.0 // indirect
	github.com/Azure/go-autorest/autorest/validation v0.1.0 // indirect
	github.com/aws/aws-sdk-go v1.25.4
	github.com/hashicorp/aws-sdk-go-base v0.3.0
	github.com/hashicorp/terraform v0.12.7
	github.com/mitchellh/go-homedir v1.1.0
	github.com/pkg/errors v0.8.1
	github.com/pulumi/pulumi v1.0.0
	github.com/pulumi/pulumi-terraform v0.18.4-0.20191008205225-9db6126b0421
	github.com/stretchr/testify v1.4.0
	github.com/terraform-providers/terraform-provider-aws v0.0.0-20190406034810-72b780bca0d3
)

replace (
	git.apache.org/thrift.git => github.com/apache/thrift v0.12.0
	github.com/Azure/azure-sdk-for-go => github.com/Azure/azure-sdk-for-go v31.1.0+incompatible
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/Nvveen/Gotty => github.com/ijc25/Gotty v0.0.0-20170406111628-a8b993ba6abd
	github.com/golang/glog => github.com/pulumi/glog v0.0.0-20180820174630-7eaa6ffb71e4
	github.com/hashicorp/vault => github.com/hashicorp/vault v1.2.0
	github.com/terraform-providers/terraform-provider-aws => github.com/pulumi/terraform-provider-aws v0.0.0-20191003151636-122b5969558d
)

replace github.com/pulumi/pulumi-terraform => ../pulumi-terraform/
