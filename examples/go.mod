module github.com/pulumi/pulumi-aws/examples

go 1.13

require (
	github.com/pulumi/pulumi-aws/sdk v0.0.0-00010101000000-000000000000
	github.com/pulumi/pulumi/sdk v0.0.0-20200322194843-61928f04e052
)

replace github.com/pulumi/pulumi-aws/sdk => ../sdk
