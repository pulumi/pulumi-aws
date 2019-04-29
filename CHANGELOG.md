## 0.18.3 (Unreleased)

### Improvements

- Update to v0.17.8 of the `pulumi` dependency, including support for the new `ignoreChanges`
  resource option. [547](https://github.com/pulumi/pulumi-aws/pull/547)
- Add 'healthCheck' properties to aws.ecs.ContainerDefinition API.
- Update to v2.8.0 of the AWS Terraform Provider.

## 0.18.2 (Released April 23rd, 2019)

- Update to v2.6.0 of the AWS Terraform Provider.

## 0.18.1 (Released April 5th, 2019)

- Update to v2.4.0 of the AWS Terraform Provider.

## 0.18.0 (Released March 28th, 2019)

### Important

- Version 0.18.0 of `pulumi-aws` is now based on v2.2.0 of the AWS Terraform Provider, which has a variety of breaking changes from the previous version.

- The `defaultAction` property on `aws.elasticloadbalancingv2.Listener` and `aws.applicationloadbalancing.Listener` is now named `defaultActions` and is an array of actions.

- The output types of aws.iam.InstanceProfile::role[s] and aws.iam.RolePolicyAttachment::role is now `string` instead of `Role`, and represent the ID of the role.

- The deprecated api `aws.apigateway.x.API` has been removed.  Its replacement is in the `@pulumi/awsx` package with the name `awsx.apigateway.API`.

### Improvement

- Update to v2.2.0 of the AWS Terraform Provider.

- Fix a bug where setting a property value back to the default results in no change

### 0.17.1 (Released March 6th, 2019)

### Improvements

- Fix an issue where the Python `pulumi_aws` package was depending on an older `pulumi` package.

## 0.17.0 (Released March 5th, 2019)

### Important

Updating to v0.17.0 version of `@pulumi/pulumi`.  This is an update that will not play nicely
in side-by-side applications that pull in prior versions of this package.

See https://github.com/pulumi/pulumi/commit/7f5e089f043a70c02f7e03600d6404ff0e27cc9d for more details.

As such, we are rev'ing the minor version of the package from 0.16 to 0.17.  Recent version of `pulumi` will now detect, and warn, if different versions of `@pulumi/pulumi` are loaded into the same application.  If you encounter this warning, it is recommended you move to versions of the `@pulumi/...` packages that are compatible.  i.e. keep everything on 0.16.x until you are ready to move everything to 0.17.x.

## 0.16.10 (Released February 25th, 2019)

### Improvements

- Updated to the v1.60.0 version of the AWS Terraform Provider.

## 0.16.9 (Released February 21st, 2019)

### Improvements

- Updated to the v1.59.0 version of the AWS Terraform Provider.

## 0.16.8 (Released February 11th, 2019)

### Improvements

- Updated to the v1.58.0 version of the AWS Terraform Provider.

- Examples in the documentation comments for the Node.js SDK have improved formatting.

- Support for the `deleteBeforeReplace` resource option and improved
  delete-before-replace behaviour introduced in [Pulumi
  0.16.14](https://github.com/pulumi/pulumi/blob/master/CHANGELOG.md#01614-released-january-31st-2019).

## 0.16.7 (Released January 19th, 2019)

### Improvements

- Updated to the v1.56.0 version of the AWS Terraform Provider.

- Documentation comments for the Node.js SDK now include examples

## 0.16.6 (Released January 15th, 2019)

### Improvements

- Auto name `aws.elasticache.ReplicationGroup.replicationGroupId` (fixes [pulumi/pulumi-aws#426](https://github.com/pulumi/pulumi-aws/issues/426)).

- Fix a deprecation warning when using `aws.wafregional.ByteMatchSet` (fixes [pulumi/pulumi-aws#429](https://github.com/pulumi/pulumi-aws/issues/429)).

- Updated package constraints such that we do not depend on unreleased versions of `@pulumi/pulumi`.

- Add some more constants for EC2 instance types.  Thanks to [@BradBarnich](https://github.com/BradBarnich)!

## 0.16.5 (Released December 23rd, 2018)

### Improvements

- Updated to the v1.54.0 version of the AWS Terraform Provider.

- Changed the type of properties which were previously `aws.Tags` to allow `Output<string>` to be used as tag values.

## 0.16.4 (Released December 17th, 2018)

### Improvements

- Updated to the v1.52.0 version of the AWS Terraform Provider.

## 0.16.3 (Released December 5th, 2018)

### Major Changes

- In TypeScript, the `startingPositionTimestamp` argument for a Kinesis  `StreamEventSubscription` is now of type `string` instead of `number` to correctly reflect the API's requirement for an RFC3339 timestamp.

- AWS Gamelift resources are now in the `aws.gamelift` namespace instead of the `aws.glacier` namespace, across all languages.

- AWS GuardDuty resources are now in the `aws.guardduty` namespace instead of the `aws.glacier` namespace, across all languages.

### Improvements

- Updated to the v1.50.0 version of the AWS Terraform Provider.

## 0.16.2 (Released Novemeber 13th, 2018)

### Major Changes

- If you're using Pulumi with Python, this release removes Python 2.7 support in favor of Python 3.6 and greater.

### Improvements

- Expose the AWS JavaScript SDK from `@pulumi/aws`. After importing `@pulumi/aws` you may now access the AWS SDK as `aws.sdk`.

- Update to the v1.42.0 version of the AWS Provider.

- Add constants for `M5` and `M5d` instances.
