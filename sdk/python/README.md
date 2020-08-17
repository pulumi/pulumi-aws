[![Actions Status](https://github.com/pulumi/pulumi-aws/workflows/master/badge.svg)](https://github.com/pulumi/pulumi-aws/actions)
[![Slack](http://www.pulumi.com/images/docs/badges/slack.svg)](https://slack.pulumi.com)
[![NPM version](https://badge.fury.io/js/%40pulumi%2Faws.svg)](https://www.npmjs.com/package/@pulumi/aws)
[![Python version](https://badge.fury.io/py/pulumi-aws.svg)](https://pypi.org/project/pulumi-aws)
[![NuGet version](https://badge.fury.io/nu/pulumi.aws.svg)](https://badge.fury.io/nu/pulumi.aws)
[![PkgGoDev](https://pkg.go.dev/badge/github.com/pulumi/pulumi-aws/sdk/v3/go)](https://pkg.go.dev/github.com/pulumi/pulumi-aws/sdk/v3/go)
[![License](https://img.shields.io/npm/l/%40pulumi%2Fpulumi.svg)](https://github.com/pulumi/pulumi-aws/blob/master/LICENSE)

# Amazon Web Services (AWS) provider

The Amazon Web Services (AWS) resource provider for Pulumi lets you use AWS resources in your cloud programs. To use
this package, please [install the Pulumi CLI first](https://pulumi.io/). For a streamlined Pulumi walkthrough, including language runtime installation and AWS configuration, click "Get Started" below.

<div>
    <a href="https://www.pulumi.com/docs/get-started/aws" title="Get Started">
       <img src="https://www.pulumi.com/images/get-started.svg" width="120">
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

    $ go get github.com/pulumi/pulumi-aws/sdk/v2/go/...

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

## Reference

For further information, please visit [the AWS provider docs](https://www.pulumi.com/docs/intro/cloud-providers/aws)
or for detailed reference documentation, please visit [the API docs](https://www.pulumi.com/docs/reference/pkg/aws).
