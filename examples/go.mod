module github.com/pulumi/pulumi-aws/examples

go 1.13

require (
	github.com/aws/aws-sdk-go v1.29.30
	github.com/pulumi/pulumi-aws/sdk v0.0.0-00010101000000-000000000000
	github.com/pulumi/pulumi/pkg v0.0.0-20200325225746-80f1989600a3
	github.com/pulumi/pulumi/sdk v0.0.0-20200325225746-80f1989600a3
	github.com/stretchr/testify v1.5.1
)

replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v12.4.3+incompatible
	github.com/pulumi/pulumi-aws/sdk => ../sdk
)
