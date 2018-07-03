# Contributing to Pulumi

Do you want to hack on Pulumi?  Awesome!  We are so happy to have you.

Please refer to the [main Pulumi repo](https://github.com/pulumi/pulumi/)'s [CONTRIBUTING.md file](
https://github.com/pulumi/pulumi/blob/master/CONTRIBUTING.md) for details on how to do so.

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
