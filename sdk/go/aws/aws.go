// nolint: lll
//
// Package aws offers support for all Amazon Web Services (AWS) services and their properties.
// Services are exposed as types from modules such as `ec2`, `ecs`, `lambda`, and `s3`, among many others. Using this
// package allows you to programmatically declare instances of any AWS services using infrastructure as code, which
// Pulumi then uses to drive the AWS API.
//
// If this is your first time using this package, these two resources may be helpful:
//
// * [AWS Getting Started Guide](https://pulumi.com/docs/quickstart/aws): Get up and running quickly.
// * [AWS Pulumi Setup Documentation](https://www.pulumi.com/docs/quickstart/aws/configure/): How to configure Pulumi
//     for use with your AWS account.
//
// Use the navigation below to see detailed documentation, including sample code, for each of the supported AWS services.
//
// > This provider is a derived work of the [Terraform Provider](https://github.com/terraform-providers/terraform-provider-aws)
// > distributed under [MPL 2.0](https://www.mozilla.org/en-US/MPL/2.0/). If you encounter a bug or missing feature,
// > first check the [`pulumi/pulumi-aws` repo](https://github.com/pulumi/pulumi-aws/issues); however, if that doesn't turn up
// > anything, please consult the source [`terraform-providers/terraform-provider-aws` repo](https://github.com/terraform-providers/terraform-provider-aws/issues).
package aws
