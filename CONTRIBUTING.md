# Contributing to the Pulumi ecosystem

Do you want to contribute to Pulumi? Awesome! We are so happy to have you.
We have a few tips and housekeeping items to help you get up and running.

## Code of Conduct

Please make sure to read and observe our [Code of Conduct](./CODE-OF-CONDUCT.md)

## Community Expectations

Please read about our [contribution guidelines here.](https://github.com/pulumi/pulumi/blob/master/CONTRIBUTING.md#communications)

## Setting up your development environment

This repository holds the source code for the [Pulumi AWS provider](https://www.pulumi.com/registry/packages/aws/). The Provider SDK code in this repository is generated via the [Pulumi Terraform Bridge](https://github.com/pulumi/pulumi-terraform-bridge), so keep that in mind as you work in this repository.

### Pulumi prerequisites

Please refer to the [main Pulumi repo](https://github.com/pulumi/pulumi/)'s [CONTRIBUTING.md file](
https://github.com/pulumi/pulumi/blob/master/CONTRIBUTING.md#developing) for details on how to get set up with Pulumi.

## Committing Generated Code

Code generated for Pulumi SDKs should be checked in as part of the pull request containing a
particular change. To generate code after making changes, run `make` from the root of this
repository.

If a large number of seemingly-unrelated diffs are produced by `make` (for example, lots of changes
to comments unrelated to the change you are making), ensure that the latest dependencies for the
provider are installed by running `make ensure` in the root of the repository.

## Running Integration Tests

The examples and integration tests in this repository will create and destroy real AWS
cloud resources while running. Before running these tests, make sure that you have
[configured Pulumi with AWS](https://pulumi.io/install/aws.html) successfully once before.

The only additional step you need to take to run tests in this repo is to set the
`AWS_REGION` environment variable to the region you'd like to create test resources in.
The integration tests do try to clean up after themselves by deleting everything that was
created, but in the event of bugs or test failures you may need to go into the AWS Console
and delete resources yourself.

Once you have set `AWS_REGION` and configured your AWS credentials, `make test_all` will run all integration tests.
