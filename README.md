[![Actions Status](https://github.com/pulumi/pulumi-aws/workflows/master/badge.svg)](https://github.com/pulumi/pulumi-aws/actions)
[![Slack](http://www.pulumi.com/images/docs/badges/slack.svg)](https://slack.pulumi.com)
[![NPM version](https://badge.fury.io/js/%40pulumi%2Faws.svg)](https://www.npmjs.com/package/@pulumi/aws)
[![Python version](https://badge.fury.io/py/pulumi-aws.svg)](https://pypi.org/project/pulumi-aws)
[![NuGet version](https://badge.fury.io/nu/pulumi.aws.svg)](https://badge.fury.io/nu/pulumi.aws)
[![PkgGoDev](https://pkg.go.dev/badge/github.com/pulumi/pulumi-aws/sdk/v4/go)](https://pkg.go.dev/github.com/pulumi/pulumi-aws/sdk/v4/go)
[![License](https://img.shields.io/npm/l/%40pulumi%2Fpulumi.svg)](https://github.com/pulumi/pulumi-aws/blob/master/LICENSE)

# Amazon Web Services (AWS) provider

The Amazon Web Services (AWS) resource provider for Pulumi lets you use AWS resources in your cloud programs. To use
this package, please [install the Pulumi CLI first](https://pulumi.com/). For a streamlined Pulumi walkthrough, including language runtime installation and AWS configuration, click "Get Started" below.

<div>
    <a href="https://www.pulumi.com/docs/get-started/aws" title="Get Started">
       <img src="https://www.pulumi.com/images/get-started.svg?" width="120">
    </a>
</div>

## Installing

This package is available in many languages in the standard packaging formats.

### Node.js (Java/TypeScript)

To use from JavaScript or TypeScript in Node.js, install using either `npm`:

    $ npm install @pulumi/aws

or `yarn`:

    $ yarn add @pulumi/aws

### Python

To use from Python, install using `pip`:

    $ pip install pulumi_aws

### Go

To use from Go, use `go get` to grab the latest version of the library

    $ go get github.com/pulumi/pulumi-aws/sdk/v4

### .NET

To use from .NET, install using `dotnet add package`:

    $ dotnet add package Pulumi.Aws

## Concepts

The `@pulumi/aws` package provides a strongly-typed means to create cloud applications that create and interact closely
with AWS resources.  Resources are exposed for the entirety of AWS resources and their properties, including (but not
limited to), 'apigateway', 'cloudformation', 'EC2', 'ECS', 'iam', 'lambda', etc.  Many convenience APIs have also been
added to make development easier and to help avoid common mistakes, and to get stronger typing.

### Serverless Functions

The `aws.serverless.Function` class allows you to create an AWS lambda function directly out of a JavaScript/TypeScript
function object of the right signature.  This allows a Pulumi program to simply define a lambda using a simple lambda in
the language of choice, while having Pulumi itself do the appropriate transformation into the final AWS Lambda resource.

This makes many APIs easier to use, such as defining a Lambda to execute when an S3 Bucket is manipulated,
or a CloudWatch timer is fired.  To see some examples of this in action, please refer to the `examples/` directory.

The [pulumi/pulumi-cloud](https://github.com/pulumi/pulumi-cloud) repo offer higher level abstractions that build on top
of this underlying capability.

## Configuration

The following configuration points are available:

- `aws:region` - (Required) This is the AWS region.

- `aws:accessKey` - (Optional) This is the AWS access key. It can also be sourced from the 
  `AWS_ACCESS_KEY_ID` environment variable, or via a shared credentials file if `aws:profile` is specified.
- `aws:secretKey` - (Optional) This is the AWS secret key. It can also be sourced from the
  `AWS_SECRET_ACCESS_KEY` environment variable, or via a shared credentials file if `aws:profile` is specified.
- `aws:profile` - (Optional) This is the AWS profile name as set in the shared credentials file.
- `aws:sharedCredentialsFile` - (Optional) This is the path to the shared credentials file. If this is not set and
  `aws:profile` is specified, `~/.aws/credentials` will be used.
- `aws:token` - (Optional) Session token for validating temporary credentials. Typically provided after successful
  identity federation or Multi-Factor Authentication (MFA) login. With MFA login, this is the session token provided
  afterward, not the 6 digit MFA code used to get temporary credentials. It can also be sourced from the 
  `AWS_SESSION_TOKEN` environment variable.
- `aws:maxRetries` - (Optional) This is the maximum number of times an API call is retried, in the case where requests
  are being throttled or experiencing transient failures. The delay between the subsequent API calls increases
  exponentially. If omitted, the default value is `25`.
- `aws:allowedAccountIds` - (Optional)  List of allowed AWS account IDs to prevent you from mistakenly using an incorrect
  one. Conflicts with `aws:forbiddenAccountIds`.
- `aws:forbiddenAccountIds` - (Optional) List of forbidden AWS account IDs to prevent you from mistakenly using the wrong
  one. Conflicts with `aws:allowedAccountIds`.
- `aws:assumeRole` - (Optional) Supports the following (optional) arguments:
  `durationSections`: Number of seconds to restrict the assume role session duration.
  `externalId`: External identifier to use when assuming the role.
  `policy`: IAM Policy JSON describing further restricting permissions for the IAM Role being assumed.
  `policyArns`: Set of Amazon Resource Names (ARNs) of IAM Policies describing further restricting permissions for the role.
  `roleArn`: Amazon Resource Name (ARN) of the IAM Role to assume.
  `sessionName`: Session name to use when assuming the role.
  `tags`: Map of assume role session tags.
- `aws:insecure` - (Optional) Explicitly allow the provider to perform "insecure" SSL requests. If omitted, the default value is `false`.
- `aws:skipCredentialsValidation` - (Optional) Skip the credentials validation via the STS API. Useful for AWS API implementations that do not have STS available or implemented. Default value is `true`.
- `aws:skipGetEc2Platforms` - (Optional) Skip getting the supported EC2 platforms. Used by users that don't have ec2:DescribeAccountAttributes permissions. Default value is `true`.
- `aws:skipRegionValidation` - (Optional) Skip validation of provided region name. Useful for AWS-like implementations that use their own region names or to bypass the validation for regions that aren't publicly available yet. Default value is `true`.
- `aws:skipRequestionAccountId` - (Optional) Skip requesting the account ID. Useful for AWS API implementations that do not have the IAM, STS API, or metadata API. Default value is `false`. When specified, the use of ARNs is compromised as there is no accountID available to construct the ARN.
- `aws:skipMetadataApiCheck` - (Optional) Skip the AWS Metadata API check. Useful for AWS API implementations that do not have a metadata API endpoint. This provider from authenticating via the Metadata API by default. You may need to use other authentication methods like static credentials, configuration variables, or environment variables. Default is `true`.
- `aws:s3ForcePathStyle` - (Optional) Set this to true to force the request to use path-style addressing, i.e., `http://s3.amazonaws.com/BUCKET/KEY`. By default, the S3 client will use virtual hosted bucket addressing, `http://BUCKET.s3.amazonaws.com/KEY`, when possible. Specific to the Amazon S3 service. Default is `false`.

### Authenticating pulumi-aws via EC2 Instance Metadata?

As of pulumi-aws v3.28.1, the default behaviour for the provider [was changed](https://github.com/pulumi/pulumi-aws/blob/master/CHANGELOG.md#3281-2021-02-10) to disable MetadataApiCheck by default. This means,
you need to do either of the following

1. When using the default provider:
```
pulumi config set aws:skipMetadataApiCheck false
```

2. When using a named provider
```typescript
const myProvider = new aws.Provider("named-provider", {
  // other config
  skipMetadataApiCheck: false,
});
```

```csharp
var provider = new Aws.Provider("named-provider", new Aws.ProviderArgs
{
  // other config
  SkipMetadataApiCheck = false,
});
```

```go
provider, err := aws.NewProvider(ctx, "named-provider", &aws.ProviderArgs{
    // other config
    SkipMetadataApiCheck: pulumi.Bool(false),
})
```

```python
provider = pulumi_aws.Provider('named-provider', skip_metadata_api_check=False)
```

## Reference

For further information, please visit [the AWS provider docs](https://www.pulumi.com/docs/intro/cloud-providers/aws)
or for detailed reference documentation, please visit [the API docs](https://www.pulumi.com/docs/reference/pkg/aws).
