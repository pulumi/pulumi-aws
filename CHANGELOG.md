CHANGELOG
=========

## HEAD (Unreleased)
___NULL___


## 0.18.3 (2019-06-21)
* Update to pulumi-terraform@3635bed3a5 which stops maps containing `.` being treated as nested maps.
* Upgrade to v2.16.0 of the AWS Terraform Provider

## 0.18.12 (2019-06-20)
* Update the list of supported Lambda function versions.
* Add module containing constants for `aws.rds.InstanceTypes`

## 0.18.11 (2019-06-17)

* Fix an issue where the pulumi_aws Python package would fail to install install in some cases

## 0.18.10 (2019-06-13)

Note: new constants may cause existing code to break due to the types being narrower in TypeScript.
If you run into issues, you can cast to the specific type (i.e. `<EngineType>someStr`) if the TypeScript
compiler complains.

* Upgrade to v2.15.0 of the AWS Terraform Provider
* Add module containing constants for ALB IpAddressType and LoadBalancer type
* Add module containing constants for Aurora-based RDS Cluster `EngineType` and `EngineMode`
* Add module containing constants for EC2 Seurity Group Protocols
* Add module containing constants for Route53 record types
* Add module containing constants for `aws.ec2.InstancePlatforms`, and marked existing InstancePlatform constants as deprecated
* Add module containing constants for `aws.ec2.InstanceTypes`, and marked existing InstanceType constants as deprecated
* Add module containing constants for `aws.ec2.Tenancies`, and marked existing Tenancy constants as deprecated
* Add module containing constants for `aws.iam.ManagedPolicies`, and marked existing managed policy constants as deprecated
* Add module containing constants for `aws.iam.Principals`, and marked existing managed Principal constants as deprecated
* Add the ability to pass a `PolicyDocument` to the `policy` field in `aws.iam.Policy`
* Add the ability to pass a `PolicyDocument` to the `policy` field in `aws.s3.Bucket`
* Subscription resources will now be parented by default by the resource they were created off of.
  This has been implemented using 'aliases' so this will not have any effect on existing stacks.

---

## 0.18.8 (2019-06-06)
* Add TypeScript type guards for each resource class ([7ace3e9b5f](https://github.com/pulumi/pulumi-terraform/commit/7ace3e9b5f2dcd4692b029ba4b80360582d7949a))
* Update to v2.14.0 of the AWS Terraform provider

## 0.18.7 (2019-05-31)
* Add an enumeration for SSM Parameter Types
* Fix a bug where `AWS_PROFILE` and the `~/.aws/config` files were not honoured for provider configuration
* Update to v2.13.0 of the AWS Terraform provider

## 0.18.6 (2019-05-24)
* Update to v2.12.0 of the AWS Terraform provider

## 0.18.5 (2019-05-22)
* Update the Pulumi-Terraform bridge, fixing an issue where all resources were marked as needing recreation in some cases

## 0.18.4 (2019-05-21)
* Add support for the AWS Lambda Custom Runtime: `aws.lambda.CustomRuntime`
* Update to v2.11.0 of the AWS Terraform provider
* Increase create timeout for an `aws.eks.Cluster` to 30 minutes
* Add a constant for the Node.js 10.x lambda runtime

## 0.18.3 (2019-04-29)
* Update the dependent version of the `pulumi` dependency to v0.17.8, adding support for the `ignoreChanges` option on resources
* Add `healthCheck` properties to the `aws.ecs.ContainerDefinition` API
* Update to v2.8.0 of the AWS Terraform provider

## 0.18.2 (2019-04-23)
* Update to v2.6.0 of the AWS Terraform provider

## 0.18.1 (2019-04-05)
* Update to v2.4.0 of the AWS Terraform provider

## 0.18.0 (2019-03-28)
* Update to v2.2.0 of the AWS Terraform provider
* BREAKING: Version 0.18.0 of the AWS Pulumi provider is now based on v2.2.0 of the AWS Terraform provider, which has a variety of breaking changes from the previous version
* BREAKING: Rename `defaultAction` property on `aws.elasticloadbalancingv2.Listener` and `aws.applicationloadbalancing.Listener` to `defaultActions` and allow an array of values.
* BREAKING: Change output types of `aws.iam.InstanceProfile::role` and `aws.iam.RolePolicyAttachment::role` to `string` instead of `Role`, representing the ID of the role
* BREAKING: Remove deprecated `aws.apigateway.x.API`. It is replaced with `awsx.apigateway.API` in the `@pulumi/pulumi-awsx` package
* Fix a bug where setting a property value back to a default value results in no change

## 0.17.1 (2019-03-06)
* Depend on the latest `pulumi` package in the `pulumi_gcp` Python SDK

## 0.17.0 (2019-03-05)
* Depend on the latest version of the `pulumi` SDK
* BREAKING: This version of the AWS provider will not work side-by-side with previous versions

## 0.16.10 (2019-02-25)
* Update to v1.60.0 of the AWS Terraform provider

## 0.16.9 (2019-02-21)
* Update to v1.59.0 of the AWS Terraform provider

## 0.16.8 (2019-02-11)
* Update to v1.58.0 of the AWS Terraform provider
* Improve the formatting of documentation comments in the Node.js SDK
* Add support for the `deleteBeforeReplace` resource option and improved delete-before-replace behaviour introduced in Pulumi v0.16.14

## 0.16.7 (2019-01-19)
* Update to v1.56.0 of the AWS Terraform provider
* Add documentation comments to the Node.js SDK

## 0.16.6 (2019-01-15)
* Auto name `aws.elasticache.ReplicationGroup.replicationGroupId` resources
* Fix a deprecation warning when using `aws.wafregional.ByteMatchSet` resources
* Update package constraints to avoid depending on unreleased versions of `@pulumi/pulumi`
* Add constants for more EC2 instance types (thanks @BradBarnich!)

## 0.16.5 (2018-12-23)
* Update to v1.54.0 of the AWS Terraform provider
* Change the type of properties previously typed as `aws.Tag` to allow `Output<string>` to be used as Tag values

## 0.16.4 (2019-12-17)
* Update to v1.52.0 of the AWS Terraform provider

## 0.16.3 (2019-12-05)
* Update to v1.50.0 of the AWS Terraform provider
* Change the type of the `startingPositionTimestamp` argument for a Kinesis `StreamEventSubscription` to `string` instead of `number` to correctly reflect the API requirement for an RFC3339 timestamp.
* Move AWS Gamelift resources to the `aws.gamelift` namespace instead of the `aws.glacier` namespace
* Move AWS GuardDuty resources to the `aws.guardduty` namespace instead of the `aws.glacier` namespace

## 0.16.2 (2019-11-13)
* Add constants for the `M5` and `M5d` instance types
* Update to v1.42.0 of the AWS Terraform provider
* Expose the AWS JavaScript SDK from `@pulumi/aws`. After importing `@pulumi/aws` the SDK can be accessed via `aws.sdk`
* Support Python 3.6 and higher, instead of only Python 3.7

