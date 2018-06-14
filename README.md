[![Build Status](https://travis-ci.com/pulumi/pulumi-aws.svg?token=eHg7Zp5zdDDJfTjY8ejq&branch=master)](https://travis-ci.com/pulumi/pulumi-aws)

# Amazon Web Services (AWS) provider

The Amazon Web Services (AWS) resource provider for Pulumi lets you use AWS resources in your cloud programs.

Install using: ```npm install @pulumi/aws```

This package is meant for use with the Pulumi CLI.  Please visit [docs.pulumi.com](https://docs.pulumi.com) for
installation instructions.

# Components

The `@pulumi/aws` package provides a strongly-typed means to create cloud applications that create
and interact closely with AWS resources.  Resources are exposed for nearly all of the AWS stack,
including (but not limited to), 'apigateway', 'cloudformation', 'EC2', 'ECS', 'iam', 'lambda', etc.
etc.

Many conveniences APIs have been added to make development easier and to help avoid mistakes using
the AWS systems.  One core convenience API added is the `lambda.createFunction` API.  This API
allows one to create an AWS lambda function directly out of a JavaScript/TypeScript function object
of the right signature.  This allows a Pulumi program to simply define a lambda using a simple
Function  within their program, while having Pulumi itself do the appropriate transformation into
the final AWS lambda Resource.  This facility can make many APIs easier to use.  For example, it
makes it much easier to define a lambda to execute when a bucket is manipulated, or a timer is fired.
See the `examples` directory or the https://github.com/pulumi/pulumi-aws-serverless project for more info.
