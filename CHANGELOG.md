CHANGELOG
=========

## HEAD (Unreleased)
* Add ManagedPolicies.AWSXRayDaemonWriteAccess

---

## 2.13.1 (2020-07-22)
* Update `aws.Tags` interface to reflect changes from version `2.10.0`

## 2.13.0 (2020-07-10)
* Upgrade to v2.70.0 of the AWS Terraform Provider

## 2.12.0 (2020-07-06)
* Upgrade to v2.69.0 of the AWS Terraform Provider
  ** Please Note the following **
  * `ec2.CustomerGateway.bgpAsn` has changed from an `int` to `string` to allow 4-byte ASNs
* Add `C5A` instance type family to `aws.ec2.InstanceTypes`.
* Add the ability to specify aws.queue.QueuePolicy `policy` as iam.PolicyDocument

## 2.11.0 (2020-06-26)
* Upgrade to v2.68.0 of the AWS Terraform Provider

## 2.10.1 (2020-06-24)
* Ensure `autoscaling.Group.Tag` and `autoscaling.Group.Tags` do not panic due to their underlying types in the Terraform schema

## 2.10.0 (2020-06-23)
* Upgrade to v2.67.0 of the AWS Terraform Provider
  ** Please Note the following **
  * The use of maps when specifying `tags` has changed to be a map that can only contain string values
  * `apigateway.state.variables` has changed to be a map that can only contain string values
  * `budgets.budget.costFilters`  has changed to be a map that can only contain string values
  * `cloudformation.stack.parameters` has been changed to a map  that can only contain string values
  * `cloudwatch.metricAlarm.dimensions`  has changed to be a map that can only contain string values
  * `cognito.identityProvider.providerDetails`  has changed to be a map that can only contain string values
  * `dml.lifecyclePolicy.targetTags`  has changed to be a map that can only contain string values
  * `elastictranscoder.preset.videoCodecOptions`  has changed to be a map that can only contain string values
  * `elasticsearch.domain.advancedOptions`  has changed to be a map that can only contain string values
  * `glue.connection.connectionProperties`  has changed to be a map that can only contain string values
  * `glue.job.defaultArguments`  has changed to be a map that can only contain string values
  * `iot.thing.attributes`  has changed to be a map that can only contain string values
  * `lb.listener.*.authenticationRequestExtraParams`  has changed to be a map that can only contain string values
  * `lb.listenerRule.*.authenticationRequestExtraParams`  has changed to be a map that can only contain string values
  * `sagemaker.model.*.environment`  has changed to be a map that can only contain string values
  * `ec2.spotInstanceRequest.*.volumeTags`  has changed to be a map that can only contain string values
  * `ssm.association.parameters`  has changed to be a map that can only contain string values

## 2.9.1 (2020-06-16)
* Adding support for EFS configuration in AWS Lambda Functions

## 2.9.0 (2020-06-12)
* Upgrade to v2.66.0 of the AWS Terraform Provider

## 2.8.0 (2020-06-05)
* Upgrade to v2.65.0 of the AWS Terraform Provider

## 2.7.0 (2020-06-02)
* Upgrade to v2.64.0 of the AWS Terraform Provider

## 2.6.1 (2020-05-28)
* Upgrade to Pulumi v2.3.0
* Upgrade to pulumi-terraform-bridge v2.4.0

## 2.6.0 (2020-05-22)
* Upgrade to pulumi-terraform-bridge v2.3.3
* Add ManagedPolicies.AmazonRDSDataFullAccess
* Add ManagedPolicies.AmazonSSMManagedInstanceCore
* Add ManagedPolicies.AWSCodeDeployRoleForECS
* Upgrade to v2.63.0 of the AWS Terraform Provider

## 2.5.0 (2020-05-19)
* Upgrade to v2.62.0 of the AWS Terraform Provider

## 2.4.0 (2020-05-11)
* Upgrade to pulumi-terraform-bridge v2.3.1
* Upgrade to v2.61.0 of the AWS Terraform Provider
  ** Please Note: **
  * `aws.ssm.Document` `permissions` has changed to be a map
  * `aws.cognito.IdentityPoolRoleAttachment` `roles` has changed to be a map

## 2.3.0 (2020-05-04)
* Upgrade to pulumi-terraform-bridge v2.2.0
* Add new region Milan eu-south-1
* Upgrade to v2.60.0 of the AWS Terraform Provider

## 2.2.0 (2020-04-29)
* Add new region South Africa (Cape Town) af-south-1
* Add ManagedPolicies.AmazonEC2SpotFleetTaggingRole
* Add Principals.BatchPrincipal
* Add Principals.SpotFleetPrincipal
* Switch deprecated Buffer constructor to Buffer.from in LogGroup.onDecodedEvent
* Update `dynamodb.TableEventSubscriptionArgs` to include latest Lambda Event Source Mapping parameters
* Update `kinesis.TableEventSubscriptionArgs` to include latest Lambda Event Source Mapping parameters
* Upgrade to pulumi-terraform-bridge v2.1.0
* Regenerate datasource examples to be async

## 2.1.0 (2020-04-20)
* Remove deprecated IAM Policy types and ec2 InstanceTypes
* Upgrade to v2.58.0 of the AWS Terraform Provider

## 2.0.0 (2020-04-16)
* Upgrade to v2.0.0 of Pulumi
* Upgrade to v2.0.0 of pulumi-terraform-bridge

## 1.31.0 (2020-04-13)
* Add support for DotNet 3.1 Lambda Runtime
* Upgrade to v2.57.0 of the AWS Terraform Provider

## 1.30.0 (2020-04-03)
* Upgrade to v2.56.0 of the AWS Terraform Provider

## v1.29.0 (2020-03-30)
* Upgrade to v2.55.0 of the AWS Terraform Provider
* Upgrade to Pulumi v1.13.1

## v1.28.0 (2020-03-27)
* Add deprecation message for `ec2.Instance` `SecurityGroups` - the messages will be added
  for dotnet and typescript languages
* Upgrade to v2.53.0 of the AWS Terraform Provider
* Upgrade to pulumi-terraform-bridge v1.8.4

## 1.27.0 (2020-03-13)
* Upgrade to Pulumi v1.12.1
* Upgrade to pulumi-terraform-bridge v1.8.2

## 1.26.0 (2020-03-11)
* Avoid storing config from the environment into the state.
  [#894](https://github.com/pulumi/pulumi-aws/pull/894)

## 1.25.0 (2020-03-09)
* Upgrade to v2.52.0 of the AWS Terraform Provider
* Ensure that resource types are primitive types and move any
  existing direct type references to be AltTypes

## 1.24.0 (2020-03-03)
* Upgrade to v2.51.0 of the AWS Terraform Provider

## 1.23.0 (2020-02-21)
* Add support for Ruby 2.7 Lambda Runtime
* Upgrade to v2.50.0 of the AWS Terraform Provider

## 1.22.0 (2020-02-14)
* Read standard AWS environment variables for configuration
* Upgrade to v2.49.0 of the AWS Terraform Provider

## 1.21.0 (2020-02-07)
* Upgrade to v2.48.0 of the AWS Terraform Provider
* Changing the autonaming prefix of `aws.iot.TopicRule` name parameter

## 1.20.0 (2020-01-31)
* Upgrade to v2.47.0 of the AWS Terraform Provider

## 1.19.0 (2020-01-29)
* Support `awsfirelens` in `ecs.Container`
* Upgrade to v2.46.0 of the AWS Terraform Provider
* Upgrade to v1.6.4 of the pulumi-terraform-bridge

## 1.18.0 (2020-01-13)
* Stop auto-naming the `name` property of `aws.route53.Record` since it must be the literal domain
  name of the record.  This is a breaking change for code which relied on the auto-naming, but such
  code was almost certainly not behaving as intended (registering incorrect domain names).
  [#842](https://github.com/pulumi/pulumi-aws/pull/842)
* Upgrade to v2.44.0 of the AWS Terraform Provider

## 1.17.0 (2019-12-19)
* Default Lambda NodeJS usage to Node JS 12.x
  **Please Note:** Existing lambdas will stay on their specified version. Users need to explicitly create a replacement to move them
* Autoname the `nodeGroupName` property of `aws.eks.NodeGroup`
* Upgrade to v2.43.0 of the AWS Terraform Provider

## 1.16.0 (2019-12-16)
* Upgrade to v2.42.0 of the AWS Terraform Provider

## 1.15.0 (2019-12-12)
* Upgrade to v1.5.2 of pulumi-terraform-bridge
* Namespace names in .NET SDK are adjusted to PascalCase
([#819](https://github.com/pulumi/pulumi-aws/pull/819)).

## 1.14.1 (2019-12-04)
* Handle additional `InvalidParameterException: Error in role params` error during creation for IAM eventual consistency

## 1.14.0 (2019-12-04)
* Upgrade to v2.41.0 of the AWS Terraform Provider

## 1.13.0 (2019-12-02)
* Allow `iam.GroupPolicyAttachment` to pass the `group` as a name or an `iam.Group`
* Allow `iam.UserPolicyAttachment` to pass the `user` as a name or an `iam.User`
* Allow `iam.PolicyAttachment` to pass the `users`, `roles` or `groups` as strings or their iam type equivalents
* Upgrade to v1.4.3 of pulumi-terraform-bridge

## 1.12.0 (2019-11-27)
* Enforce `appsync.Function`, `glue.CatalogTable` and `glue.CatalogDatabase` to adhere to AWS naming conventions
* Upgrade to v2.40.0 of the AWS Terraform Provider

## 1.11.0 (2019-11-25)
* Adding an EOL deprecation message to NodeJS 8.x Lambda Runtime
* Adding support for NodeJS12 Lambda Runtime
* Update `ContainerDefinition` to latest ECS schema
* Upgrade to v1.4.2 of pulumi-terraform-bridge
* Upgrade to v2.39.0 of the AWS Terraform Provider

## 1.10.0 (2019-11-19)
* Upgrade to v2.38.0 of the AWS Terraform Provider

## 1.9.0 (2019-11-16)
* Upgrade to v2.36.0 of the AWS Terraform Provider
* Upgrade to support go 1.13.x

## 1.8.0 (2019-11-07)
* Update default `descriptions` for several resources to `Managed by Pulumi`.
* Add a **preview** .NET SDK.

## 1.7.0 (2019-10-17)
* Upgrade to v2.33.0 of the AWS Terraform Provider

## 1.6.0 (2019-10-11)
* Upgrade to v2.32.0 of the AWS Terraform Provider

## 1.5.0 (2019-10-03)
* Regenerate SDK against tf2pulumi 0.6.0
* Upgrade to v2.31.0 of the AWS Terraform Provider

## 1.4.0 (2019-09-27)
* Upgrade to v2.30.0 of the AWS Terraform provider.

## 1.3.0 (2019-09-24)
* Add CodeBuild principal
* Upgrade to v2.29.0 of the AWS Terraform provider.

## 1.2.1 (2019-09-12)
* Upgrade to v2.28.1 of the AWS Terraform provider.

## 1.2.0 (2019-09-12)
* Upgrade to 1.0 of pulumi SDK
* Upgrade to v2.28.0 of the AWS Terraform provider.

## 1.1.0 (2019-09-06)
* Upgrade to v2.27.0 of the AWS Terraform provider
* Upgrade to pulumi-terraform ed0b5c29ed

## 1.0.0 (2019-09-03)
* Use 1.0 version of Pulumi dependency

## 1.0.0-rc.2 (2019-08-30)
* Upgrade to v2.26.0 of the AWS Terraform Provider

## 1.0.0-rc.1 (2019-08-28)
* Update to pulumi-terraform@3f206601e7

## 1.0.0-beta.3 (2019-08-26)
* Update pulumi-terraform reference to 58c7473d0
* Use 1.0-beta versions of python dependencies

## 1.0.0-beta.2 (2019-08-23)
* Add support for `t3a` instance types
* Add support for RDS T3 instance types
* Allow IAM Policy Document `Condition`s to be arrays as well as scalars
* Upgrade to pulumi-terraform@14e049b09d
* Update `aws.ecs.ContainerDefinition` to latest supported JSON schema
* Upgrade to v2.25.0 of the AWS Terraform Provider

## 1.0.0-beta.1 (2019-08)
* No significant changes

## 0.18.27 (2019-08-09)
* Update to pulumi-terraform 9db2fc93cd
* Update to v2.23.0 of the AWS Terraform Provider

## 0.18.26 (2019-08-05)
* Upgrade to v2.22.0 of the AWS Terraform Provider.
* Rename `aws.ses.Confguration` to `aws.ses.Configuration`.
  This includes an alias to keep compatibility with existing code

## 0.18.25 (2019-07-30)
* Upgrade to pulumi-terraform 6bcafb609d
* Upgrade to v2.21.1 of the AWS Terraform Provider.
* Add support for RepositoryCredentials in ECS container definitions.

## 0.18.24 (2019-07-29)
* Change PolicyDocument helper to allow passing of outputs from other resources
* Update pulumi-terraform to fdafc00b3f
* Several modules have been renamed to better align with their terraform equivalents.  The existing
  modules are still available, but will be deprecated and removed in the future. 'Aliases' have been
  used to ensure that moving to the new modules will not result in any changes to existing
  resources.  The renamed modules are:
  * `applicationloadbalancing -> alb`
  * `elasticloadbalancing     -> elb`
  * `elasticloadbalancingv2   -> lb`

## 0.18.23 (2019-07-19)
* Upgrade to pulumi-terraform@98fabcf506

## 0.18.22 (2019-07-19)
* Add ECR LifecyclePolicy Document Type.
* Upgrade to v2.20.0 of the AWS Terraform Provider.

## 0.18.21 (2019-07-12)
* Add Lambda runtime constants to the Go SDK.
* Add module containing constants for RDS DB Instance StorageType.
* Upgrade to v2.19.0 of the AWS Terraform Provider.

## 0.18.20 (2019-07-09)
* Fix detailed diffs with nested computed values.

## 0.18.19 (2019-07-08)
* Communicate detailed information about the difference between a resource's desired and actual state during a Pulumi update

## 0.18.18 (2019-07-05)
* Upgrade to v2.18.0 of the AWS Terraform Provider

## 0.18.17 (2019-07-05)
* Add the ability for Route53 record types to use a string *or* a RecordType constant

## 0.18.16 (2019-06-28)
* Upgrade to v2.17.0 of the AWS Terraform Provider

## 0.18.15 (2019-06-26)
* BREAKING: The `filename` parameter of `aws.lambda.layerVersion` has been renamed to `code`.
  We can now pass an `AssetArchive` to this parameter as follows:
  ```
  code: new asset.AssetArchive({
    "index.js": new asset.StringAsset(
        "exports.handler = (e, c, cb) => cb(null, {statusCode: 200, body: 'Hello, world!'});",
    ),
  })
  ```
* Add the ability to specify `elastic_search_*` `access_policies` as iam.PolicyDocument
* Add the ability to pass a `RoutingRule` array to the `routingRules` field in `aws.s3.Bucket`'s `website` field
* Add the ability to specify ecr_repository `policy` as iam.PolicyDocument

## 0.18.14 (2019-06-24)
* Update to v0.17.20 of @pulumi/pulumi.  This pulls in a fix related to crashing with aliases.

## 0.18.13 (2019-06-21)
* Update to pulumi-terraform@3635bed3a5 which stops maps containing `.` being treated as nested maps.
* Upgrade to v2.16.0 of the AWS Terraform Provider

## 0.18.12 (2019-06-20)
* Update the list of supported Lambda function versions.
* Add module containing constants for `aws.rds.InstanceTypes`

## 0.18.11 (2019-06-17)
* Fix an issue where the pulumi_aws Python package would fail to install in some cases

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

## 0.16.1 (2018-10-23)
* Update to the v1.14.0 version of the AWS Provider [pulumi/pulumi-aws#355](https://github.com/pulumi/pulumi-aws/pull/355)
* Add definitions for S3 Canned ACLs [pulumi/pulumi-aws#351](https://github.com/pulumi/pulumi-aws/pull/355)
* Add serverless methods to Kinesis streams [pulumi/pulumi-aws#345](https://github.com/pulumi/pulumi-aws/pull/345)

## 0.16.0 (2018-10-15)
* Moved all `@pulumi/aws-serverless` features down into `@pulumi/aws`.  Event handlers are now available as methods like `bucket.onObjectCreated` from instances of `aws.s3.Bucket` and all other Lambda event sources.  In addition, the `aws.apigateway.x.API` type is available for simple construction of API Gateways directly in the `@pulumi/aws` package.
* Added richer typing for many EC2 and Autoscaling resources.  Thanks to [@jen20](https://github.com/jen20)! [pulumi/pulumi-aws#323](https://github.com/pulumi/pulumi-aws/pull/323) [pulumi/pulumi-aws#324](https://github.com/pulumi/pulumi-aws/pull/324)
* Adopted `v1.38.0` of the AWS Terraform Provider. [pulumi/pulumi-aws#341](https://github.com/pulumi/pulumi-aws/pull/341)

## 0.15.1 (2018-09-11)
* Add dotnetcore2.1 as a runtime for AWS lambdas (thanks to **[@Jtango18](https://github.com/Jtango18)**!). [pulumi/pulumi-aws#302](https://github.com/pulumi/pulumi-aws/pull/302)
* Expose 'factory functions' from pulumi-aws. [pulumi/pulumi-aws#304](https://github.com/pulumi/pulumi-aws/pull/304)
* Use stronger IAM doc types. [pulumi/pulumi-aws#311](https://github.com/pulumi/pulumi-aws/pull/311)
* Auto-name aws.elasticache.Cluster#clusterId, [pulumi/pulumi-aws#313](https://github.com/pulumi/pulumi-aws/pull/313)

## 0.15.0 (2018-08-13)
* Adopted `terraform-provider-aws` version 1.30.0, with new support for Amazon Neptune, AWS Storage Gateway, Amazon Macie, and much more.

## 0.14.5 (2018-07-20)
* Only apply AutoName to inputs ([pulumi/pulumi-aws#265](https://github.com/pulumi/pulumi-aws/pull/265)). Terraform properties named `name` but are not inputs do not have auto naming applied to them.
* Switch package inclusion from whitelist to blacklist ([pulumi/pulumi-aws#268](https://github.com/pulumi/pulumi-aws/pull/265)). When serializing a lambda, default to including all dependencies listed in the dependencies section of package.json (and their transitive dependencies) except for all `@pulumi/*` packages. Previously we tried to infer the set of packages by doing a more detailed analysis of the lambda implementation, but this failed in somewhat common cases.
* Fix null ref when walking packages ([pulumi/pulumi-aws#280](https://github.com/pulumi/pulumi-aws/pull/280)). Fix some issues that could arise when serializing lambdas when a dependent package had no dependencies itself.
* Add autoscaling NotificationType union and overlay ([pulumi/pulumi-aws#251](https://github.com/pulumi/pulumi/pull/251)). Provide a more strongly typed experience for setting autoscaling notification types. Special thanks to [@jen20](https://github.com/jen20) for this improvement.
* Add iam.assumeRolePolicyForPrincipal function ([pulumi/pulumi-aws#273](https://github.com/pulumi/pulumi-aws/pull/273)). Add some helpers for authoring policy documents to assume a role. Special thanks to [@jen20](https://github.com/jen20) for this improvement.
* Add `environment` to `aws.serverless.Function` ([pulumi/pulumi-aws#254](https://github.com/pulumi/pulumi-aws/pull/254). Expose the underlying `Environment` property to allow setting environment variables visible at runtime of a function when using `aws.serverless.Function`. Special thanks to [@jen20](https://github.com/jen20) for this improvement.
* Override role on RolePolicy to accept a Role ([pulumi/pulumi-aws#278](https://github.com/pulumi/pulumi-aws/pull/278)). When constructing a `RolePolicy` object, allow the `Role` object to set as an argument instead of just a string which is the ARN of the role to use. Special thanks to [@jen20](https://github.com/jen20) for this improvement.
* Add the .js extension to our generate closure code file. ([pulumi/pulumi-aws#279](https://github.com/pulumi/pulumi-aws/pull/279)). Ensure the generated code uploaded to AWS has a `.js` extension when building a lambda function. This allows the code for the lambda to be viewed in the AWS console.

## 0.14.2 (2018-07-03)
* The result of calls to data sources now include an `id` property. Special thanks to [@Frassle](https://github.com/Frassle) for adding this support in [pulumi/pulumi-terraform#189](https://github.com/pulumi/pulumi-terraform/pull/189).
* Adopt [v1.26.0](https://github.com/terraform-providers/terraform-provider-aws/blob/master/CHANGELOG.md#1260-july-04-2018) of the AWS Terraform Provider.

## 0.13.0 (2018-05-19)
* Allow passing an existing `Role` to `serverless.Function` ([pulumi/pulumi-aws#210](https://github.com/pulumi/pulumi-aws/pull/210)). FunctionOptions now includes a `Role` property, for scenarios where you wish to use an existing `Role` or share one across multiple Lambda functions.
* (**Breaking**) Support configuring the paths to include in `serverless.Function` ([pulumi/pulumi-aws#210](https://github.com/pulumi/pulumi-aws/pull/210)). Previously, all files in the directory would be included in the Lambda deployment package. With this change, only the generated `__index.js` and `./node_modules` are included by default. To add other files, use the new `includePaths` property in FunctionOptions.
* (**Breaking**) Rename `aws.s3.Bucket#websites` to the singular `aws.s3.Bucket#website`. ([pulumi/pulumi-aws#207](https://github.com/pulumi/pulumi-aws/pull/207)). Since this property contains only one element, it has been renamed to `website` (singular) and is no longer an array property.
