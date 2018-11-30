
## 0.16.3 (unreleased)

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
