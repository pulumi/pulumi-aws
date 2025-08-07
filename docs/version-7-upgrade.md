# Pulumi AWS Provider Version 7 Upgrade Guide

Version 7.0.0 of the AWS provider for Pulumi is a major release and includes changes that you need to consider when upgrading. This guide will help with that process and focuses only on changes from version 6.x to version 7.0.0. See the [Version 6 Upgrade Guide](https://www.pulumi.com/registry/packages/aws/how-to-guides/6-0-migration/) for information on upgrading from 5.x to version 6.0.0.

Upgrade topics:

<!-- mtoc-start -->

* [Prerequisites to Upgrade to v7.0.0](#prerequisites-to-upgrade-to-v700)
* [Performing the Upgrade](#performing-the-upgrade)
* [Removed Provider Arguments](#removed-provider-arguments)
* [Enhanced Region Support](#enhanced-region-support)
* [Provider role chaining](#provider-role-chaining)
* [S3 Bucket/BucketV2 Changes](#s3-bucketbucketv2-changes)
* [Tags Changes](#tags-changes)
* [Patch Related Changes](#patch-related-changes)
* [Amazon Elastic Transcoder Deprecation](#amazon-elastic-transcoder-deprecation)
* [CloudWatch Evidently Deprecation](#cloudwatch-evidently-deprecation)
* [OpsWorks Stacks Removal](#opsworks-stacks-removal)
* [SimpleDB Support Removed](#simpledb-support-removed)
* [Worklink Support Removed](#worklink-support-removed)
* [S3 Global Endpoint Deprecation](#s3-global-endpoint-deprecation)
* [Function `aws.ec2.getAmi`](#function-awsec2getami)
* [Function `aws.batch.getComputeEnvironment`](#function-awsbatchgetcomputeenvironment)
* [Function `aws.ecs.getTaskDefinition`](#function-awsecsgettaskdefinition)
* [Function `aws.ecs.getTaskExecution`](#function-awsecsgettaskexecution)
* [Function `aws.elbv2.getListenerRule`](#function-awselbv2getlistenerrule)
* [Function `aws.globalaccelerator.getAccelerator`](#function-awsglobalacceleratorgetaccelerator)
* [Function `aws.identitystore.getGroup`](#function-awsidentitystoregetgroup)
* [Function `aws.identitystore.getUser`](#function-awsidentitystoregetuser)
* [Function `aws.kms.getSecret`](#function-awskmsgetsecret)
* [Function `aws.launch.getTemplate`](#function-awslaunchgettemplate)
* [Function `aws.opensearch.getDomain`](#function-awsopensearchgetdomain)
* [Function `aws.opensearchserverless.getSecurityConfig`](#function-awsopensearchserverlessgetsecurityconfig)
* [Function `aws.quicksight.getDataSet`](#function-awsquicksightgetdataset)
* [Function `aws.getRegion`](#function-awsgetregion)
* [Function `aws.s3.getBucket`](#function-awss3getbucket)
* [Function `aws.service.getDiscoveryService`](#function-awsservicegetdiscoveryservice)
* [Function `aws.servicequotas.getTemplates`](#function-awsservicequotasgettemplates)
* [Function `aws.ssmincidents.getReplicationSet`](#function-awsssmincidentsgetreplicationset)
* [Function `aws.vpc.getEndpointService`](#function-awsvpcgetendpointservice)
* [Function `aws.vpc.getPeeringConnection`](#function-awsvpcgetpeeringconnection)
* [Resource `aws.apigateway.Account`](#resource-awsapigatewayaccount)
* [Resource `aws.apigateway.Deployment`](#resource-awsapigatewaydeployment)
* [Resource `aws.appflow.ConnectorProfile`](#resource-awsappflowconnectorprofile)
* [Resource `aws.appflow.Flow`](#resource-awsappflowflow)
* [Resource `aws.batch.ComputeEnvironment`](#resource-awsbatchcomputeenvironment)
* [Resource `aws.batch.JobQueue`](#resource-awsbatchjobqueue)
* [Resource `aws.bedrockmodel.InvocationLoggingConfiguration`](#resource-awsbedrockmodelinvocationloggingconfiguration)
* [Resource `aws.cloudformation.StackSetInstance`](#resource-awscloudformationstacksetinstance)
* [Resource `aws.cloudfront.KeyValueStore`](#resource-awscloudfrontkeyvaluestore)
* [Resource `aws.cloudfront.ResponseHeadersPolicy`](#resource-awscloudfrontresponseheaderspolicy)
* [Resource `aws.cognito.UserInGroup`](#resource-awscognitouseringroup)
* [Resource `aws.cfg.AggregateAuthorization`](#resource-awscfgaggregateauthorization)
* [Resource `aws.rds.Instance`](#resource-awsrdsinstance)
* [Resource `aws.dms.Endpoint`](#resource-awsdmsendpoint)
* [Resource `aws.directconnect.GatewayAssociation`](#resource-awsdirectconnectgatewayassociation)
* [Resource `aws.directconnect.HostedConnection`](#resource-awsdirectconnecthostedconnection)
* [Resource `aws.ecs.TaskDefinition`](#resource-awsecstaskdefinition)
* [Resource `aws.ec2.Eip`](#resource-awsec2eip)
* [Resource `aws.eks.Addon`](#resource-awseksaddon)
* [Resource `aws.eks.Cluster`](#resource-awsekscluster)
* [Resource `aws.elasticache.ReplicationGroup`](#resource-awselasticachereplicationgroup)
* [Resource `aws.elasticache.User`](#resource-awselasticacheuser)
* [Resource `aws.elasticache.UserGroup`](#resource-awselasticacheusergroup)
* [Resource `aws.ec2.FlowLog`](#resource-awsec2flowlog)
* [Resource `aws.guardduty.Detector`](#resource-awsguarddutydetector)
* [Resource `aws.guardduty.OrganizationConfiguration`](#resource-awsguarddutyorganizationconfiguration)
* [Resource `aws.ec2.Instance`](#resource-awsec2instance)
* [Resource `aws.kinesis.AnalyticsApplication`](#resource-awskinesisanalyticsapplication)
* [Resource `aws.ec2.LaunchTemplate`](#resource-awsec2launchtemplate)
* [Resource `aws.lb.Listener`](#resource-awslblistener)
* [Resource `aws.mediastore.Container`](#resource-awsmediastorecontainer)
* [Resource `aws.mediastore.ContainerPolicy`](#resource-awsmediastorecontainerpolicy)
* [Resource `aws.networkmanager.CoreNetwork`](#resource-awsnetworkmanagercorenetwork)
* [Resource `aws.opensearch.Domain`](#resource-awsopensearchdomain)
* [Resource `aws.opensearch.ServerlessSecurityConfig`](#resource-awsopensearchserverlesssecurityconfig)
* [Resource `aws.paymentcryptography.Key`](#resource-awspaymentcryptographykey)
* [Resource `aws.redshift.Cluster`](#resource-awsredshiftcluster)
* [Resource `aws.redshift.ServiceAccount`](#resource-awsredshiftserviceaccount)
* [Resource `aws.rekognition.StreamProcessor`](#resource-awsrekognitionstreamprocessor)
* [Resource `aws.resiliencehub.ResiliencyPolicy`](#resource-awsresiliencehubresiliencypolicy)
* [Resource `aws.s3.Bucket`](#resource-awss3bucket)
* [Resource `aws.sagemaker.ImageVersion`](#resource-awssagemakerimageversion)
* [Resource `aws.sagemaker.NotebookInstance`](#resource-awssagemakernotebookinstance)
* [Resource `aws.servicequotas.Template`](#resource-awsservicequotastemplate)
* [Resource `aws.ec2.SpotInstanceRequest`](#resource-awsec2spotinstancerequest)
* [Resource `aws.ssm.Association`](#resource-awsssmassociation)
* [Resource `aws.ssmincidents.ReplicationSet`](#resource-awsssmincidentsreplicationset)
* [Resource `aws.verifiedpermissions.Schema`](#resource-awsverifiedpermissionsschema)
* [Resource `aws.wafv2.WebAcl`](#resource-awswafv2webacl)
* [Node Only Changes](#node-only-changes)
* [Enum Removals](#enum-removals)

<!-- mtoc-end -->

## Prerequisites to Upgrade to v7.0.0

-> Before upgrading to version `7.0.0`, first upgrade to the latest available `6.x` version of the provider. Run `pulumi preview` and confirm that:

- Your preview completes without errors or unexpected changes.
- There are no deprecation warnings related to the changes described in this guide.

> [!NOTE]: it is also recommended that you run `pulumi up --refresh` prior to upgrading to ensure that your Pulumi state is up to date.

If you use version constraints in your package.json or requirements.txt (recommended), update them to allow the `7.x` series and run `npm install` or `pip install --upgrade` to download the new version.

### Example

**Before:**

```typescript
import * as aws from "@pulumi/aws";

// In package.json dependencies:
// "@pulumi/aws": "^6.92.0"
```

**After:**

```typescript
import * as aws from "@pulumi/aws";

// In package.json dependencies:
// "@pulumi/aws": "^7.0.0"
```

## Performing the Upgrade

After you have upgraded the AWS provider library to `v7` you need to run Pulumi with the `--refresh` and `--run-program` CLI flags. 

```console
$ pulumi up --refresh --run-program
```

- `--refresh` is necessary because the major version has some schema changes and running `--refresh` makes sure the state is migrated to the new schema so that it doesn't cause a diff to be calculated.
- `--run-program` is necessary because otherwise `--refresh` will use the old provider version to perform the refresh. `--run-program` allows refresh to use the new provider version to perform the refresh.


## Removed Provider Arguments

Remove the following from your provider configuration—they are no longer supported:

- `endpoints.opsworks` – removed following AWS OpsWorks Stacks End of Life.
- `endpoints.simpledb` and `endpoints.sdb` – removed due to the removal of Amazon SimpleDB support.
- `endpoints.worklink` – removed due to the removal of Amazon Worklink support.

## Enhanced Region Support

Version 7.0.0 adds `region` to most resources making it significantly easier to manage infrastructure across AWS Regions without requiring multiple provider configurations. See [Enhanced Region Support](./enhanced-region-support.md).

## Provider role chaining

v7 adds support for IAM role chaining by changing the `assumeRole` property to a
list that accepts multiple `assumeRole` arguments.

This feature was added to the upstream provider in the previous major version,
but since it required a breaking change in the Pulumi AWS SDK the change was
backed out.

If you are providing the `assumeRole` property on the `Provider`, you will need
to update your code. See the below example.

This (v6)

```ts
import * as aws from '@pulumi/aws';

const provider = new aws.Provider("provider", {
    assumeRole: {roleArn: baseRole.arn},
});

```

Becomes this (v7)

```ts
import * as aws from '@pulumi/aws';

const provider = new aws.Provider("provider", {
    assumeRoles: [{roleArn: baseRole.arn}],
});
```

Similarly, if you are using the `aws:assumeRole` config you will need to update it to match the new type.

**This (v6)**

```yaml
config:
  aws:assumeRole:
    roleArn: arn:aws:iam::12345678912/someRole
```

**Becomes this (v7)**
```yaml
config:
  aws:assumeRoles:
    - roleArn: arn:aws:iam::12345678912/someRole
```


## S3 Bucket/BucketV2 Changes

In `v6` of the Pulumi AWS Provider the `s3.Bucket` and `s3.BucketV2` resources represent different resource implementations. `s3.BucketV2` represents the latest version of the upstream Terraform resources, while `s3.Bucket` is a separate resource maintained by Pulumi to keep backwards compatibility with the `v4` release of the upstream Terraform Provider.

In `v7` we are taking the first step in unifying these two resources by moving the `s3.Bucket` resource to the latest upstream implementation. As a result, in `v7` both `s3.Bucket` and `s3.BucketV2` will represent the latest version of the upstream Terraform S3 Bucket resource. As part of this change, there are a couple of SDK level breaking changes to `s3.Bucket`.

- The `loggings` input property has been renamed to `logging` and the type has changed from a list to a single object.
- The `website.routingRules` now only accepts a `string` input property.

We have also introduced new Bucket configuration resources that are alternatives to their `V2` counterparts. The `V2` versions will be removed in `v8` of the Pulumi AWS Provider.

- `aws.s3.BucketAccelerateConfigurationV2` => `aws.s3.BucketAccelerateConfiguration`
- `aws.s3.BucketRequestPaymentConfigurationV2` => `aws.s3.BucketRequestPaymentConfiguration`
- `aws.s3.BucketAclV2` => `aws.s3.BucketAcl`
- `aws.s3.BucketCorsConfigurationV2` => `aws.s3.BucketCorsConfiguration`
- `aws.s3.BucketLifecycleConfigurationV2` => `aws.s3.BucketLifecycleConfiguration`
- `aws.s3.BucketLoggingV2` => `aws.s3.BucketLogging`
- `aws.s3.BucketObjectLockConfigurationV2` => `aws.s3.BucketObjectLockConfiguration`
- `aws.s3.BucketServerSideEncryptionConfigurationV2` => `aws.s3.BucketServerSideEncryptionConfiguration`
- `aws.s3.BucketVersioningV2` => `aws.s3.BucketVersioning`
- `aws.s3.BucketWebsiteConfigurationV2` => `aws.s3.BucketWebsiteConfiguration`

### Migration

In order to perform this migration first update your code to use the new resource or property names and then run pulumi with the `--refresh` and `--run-program` arguments. Make sure you have [installed](https://www.pulumi.com/docs/iac/download-install/) the latest version of the Pulumi CLI.

3. Fix any differences in property types (e.g. `Bucket.loggings` (array) to `Bucket.logging` (object))
4. Run `pulumi up --refresh --run-program`
5. Ensure there is no diff in the update. If there is, go back to step 1

[!NOTE] You may see a refresh diff as Pulumi migrates the state to the new structure, but you should not see an update diff.

#### Example

**Before (v6)**

```typescript
import * as aws from '@pulumi/aws';
const awsProvider = new aws.Provider('provider');

// Migration bucket
const migrationBucket = new aws.s3.Bucket("migrationBucket", {
    loggings: [{
        targetBucket: loggingBucket.bucket,
        targetPrefix: "/log",
    }],
    website: {
        indexDocument: "index.html",
        errorDocument: "error.html",
        routingRules: [{
          Condition: {
            KeyPrefixEquals: "docs"
          },
          Redirect: {
            ReplaceKeyPrefixWith: "documents/"
          }
        }],
    },
}, { provider: awsProvider });
```

**After (v7)**

```typescript
import * as aws from '@pulumi/aws';
const awsProvider = new aws.Provider('provider');

// Migration bucket
const migrationBucket = new aws.s3.Bucket("migrationBucket", {
    logging: {
        targetBucket: loggingBucket.bucket,
        targetPrefix: "/log",
    },
    website: {
        indexDocument: "index.html",
        errorDocument: "error.html",
        routingRules: `[{
          "Condition": {
            "KeyPrefixEquals": "docs"
          },
          "Redirect": {
            "ReplaceKeyPrefixWith": "documents/"
          }
        }]`,
    },
}, { provider: awsProvider });
```

## Tags Changes

This release some changes to the way tags work in the Pulumi AWS Provider. In v6 of the Pulumi AWS Provider we customized the tagging behavior of the provider through Pulumi level patches to the upstream Terraform provider along with other Pulumi level customizations. This resulted in tagging behavior that diverged from the upstream Terraform provider and has been difficult to maintain as the upstream Terraform provider has made changes to tagging.

In v7 we are removing the Pulumi level customizations and going back to relying on the upstream provider's tagging behavior. This should only impact you if you were previously using the `tags` property of a resource to get _all_ the tags on the resource. In v7 you will need to use the `tagsAll` property.

**Before (v6)**

```typescript
const provider = new aws.Provider('provider', {
    defaultTags: {
        tags: {
            globalTag: 'value',
        }
    }
});
const bucket = new aws.s3.Bucket('my-bucket', {
    tags: {
        resourceTag: 'value';
    }
}, { provider });

export const tags = bucket.tags; // contains _all_ tags (globalTag & resourceTag)
```

**After (v7)**

```typescript
const provider = new aws.Provider('provider', {
    defaultTags: {
        tags: {
            globalTag: 'value',
        }
    }
});
const bucket = new aws.s3.Bucket('my-bucket');

export const tags = bucket.tags; // only contains resource tags (i.e. `resourceTag`)
export const allTags = bucket.tagsAll; // contains _all_ tags (globalTag & resourceTag)
```

## Patch Related Changes

We previously had Pulumi level patches to the upstream Terraform provider to address issues/limitations that existed in the upstream provider. Several of those issues/limitations have now been addressed in the upstream Terraform provider and we are removing the Pulumi level patch. Users will need to migrate their code to use the new features.

### Resource `aws.eks.Cluster`

We are removing the `defaultAddonsToRemoves` property. This property does not exist in the upstream `terraform-provider-aws` provider and was added to workaround some limitations. Since then the upstream provider has added the `bootstrapSelfManagedAddons` field which can be used instead.

Users can replicate the behavior of `defaultAddonsToRemoves` by setting `bootstrapSelfManagedAddons` to `false` and then adding platform addons that they actually want as `aws.eks.Addon` resources.

### Function `aws.ecr.getCredentials`

The `ecr.getCredentials` function was added to address a functionality that did not exist in the upstream provider. The upstream Terraform provider now has a `aws.ecr.getAuthorizationToken` function that should be used instead.

**Before (v6)**

```typescript
const credentials = await aws.ecr.getCredentials({ registryId: registryId });
const decodedCredentials = Buffer.from(credentials.authorizationToken, "base64").toString();
const [username, password] = decodedCredentials.split(":");
if (!password || !username) {
    throw new Error("Invalid credentials");
}

```

**After (v7)**

```typescript
const credentials = await aws.ecr.getAuthorizationToken({ registryId: registryId });
const username = credentials.userName;
const password = pulumi.secret(credentials.password);
```

## Amazon Elastic Transcoder Deprecation

Amazon Elastic Transcoder will be [discontinued](https://aws.amazon.com/blogs/media/support-for-amazon-elastic-transcoder-ending-soon/) on **November 13, 2025**.

The following resources are deprecated and will be removed in a future major release:

- `aws.elastictranscoder.Pipeline`
- `aws.elastictranscoder.Preset`

Use [AWS Elemental MediaConvert](https://aws.amazon.com/blogs/media/migrating-workflows-from-amazon-elastic-transcoder-to-aws-elemental-mediaconvert/) instead.

## CloudWatch Evidently Deprecation

AWS will [end support](https://aws.amazon.com/blogs/mt/support-for-amazon-cloudwatch-evidently-ending-soon/) for CloudWatch Evidently on **October 17, 2025**.

The following resources are deprecated and will be removed in a future major release:

- `aws.evidently.Feature`
- `aws.evidently.Launch`
- `aws.evidently.Project`
- `aws.evidently.Segment`

Migrate to [AWS AppConfig Feature Flags](https://aws.amazon.com/blogs/mt/using-aws-appconfig-feature-flags/).

## OpsWorks Stacks Removal

The AWS OpsWorks Stacks service has reached [End of Life](https://docs.aws.amazon.com/opsworks/latest/userguide/stacks-eol-faqs.html). The following resources have been removed:

- `aws.opsworks.Application`
- `aws.opsworks.CustomLayer`
- `aws.opsworks.EcsClusterLayer`
- `aws.opsworks.GangliaLayer`
- `aws.opsworks.HaproxyLayer`
- `aws.opsworks.Instance`
- `aws.opsworks.JavaAppLayer`
- `aws.opsworks.MemcachedLayer`
- `aws.opsworks.MysqlLayer`
- `aws.opsworks.NodejsAppLayer`
- `aws.opsworks.Permission`
- `aws.opsworks.PhpAppLayer`
- `aws.opsworks.RailsAppLayer`
- `aws.opsworks.RdsDbInstance`
- `aws.opsworks.Stack`
- `aws.opsworks.StaticWebLayer`
- `aws.opsworks.UserProfile`

## SimpleDB Support Removed

The `aws.simpledb.Domain` resource has been removed, as the [AWS SDK for Go v2](https://docs.aws.amazon.com/sdk-for-go/v2/developer-guide/welcome.html) no longer supports Amazon SimpleDB.

## Worklink Support Removed

The following resources have been removed due to dropped support for Amazon Worklink in the [AWS SDK for Go v2](https://github.com/aws/aws-sdk-go-v2/pull/2814):

- `aws.worklink.Fleet`
- `aws.worklink.WebsiteCertificateAuthorityAssociation`

## S3 Global Endpoint Deprecation

Support for the global S3 endpoint is deprecated. This affects S3 resources in `us-east-1` (excluding directory buckets) when `s3UsEast1RegionalEndpoint` is set to `legacy`.

`s3UsEast1RegionalEndpoint` will be removed in `v8.0.0`.

To prepare:

- Remove `s3UsEast1RegionalEndpoint` from your provider configuration, **or**
- Set its value to `regional` and verify functionality.

## Function `aws.ec2.getAmi`

When using `mostRecent = true`, your configuration **must now include** an `owner` or a `filter` that identifies the image by `image-id` or `owner-id`.

- **Before (v6 and earlier):**
  Pulumi allowed this setup and showed only a warning.

- **Now (v7+):**
  Pulumi will stop with an **error** to prevent unsafe or ambiguous AMI lookups.

### How to fix it

Do one of the following:

- Add `owner`:

```typescript
aws.ec2.getAmi({
  mostRecent: true,
  owners: ['amazon']
});
```

- Or add a `filter` block that includes either `image-id` or `owner-id`:

```typescript
aws.ec2.getAmi({
  mostRecent: true,
  filters: [{
    name: "owner-id",
    values: ["123456789012"]
  }],
});
```

### Unsafe option (not recommended)

To override this check, you can set:

```typescript
allowUnsafeFilter: true
```

However, this may lead to unreliable results and should be avoided unless absolutely necessary.

## Function `aws.batch.getComputeEnvironment`

`computeEnvironmentName` has been renamed to `name`.

Update your configurations to replace any usage of `computeEnvironmentName` with `name` to use this version.

## Function `aws.ecs.getTaskDefinition`

Remove `inferenceAccelerator`—it is no longer supported. Amazon Elastic Inference reached end of life in April 2024.

## Function `aws.ecs.getTaskExecution`

Remove `inferenceAcceleratorOverrides`—it is no longer supported. Amazon Elastic Inference reached end of life in April 2024.

## Function `aws.elbv2.getListenerRule`

Treat the following as lists of objects instead of objects:

- `action.authenticateCognito`
- `action.authenticateOidc`
- `action.fixedResponse`
- `action.forward`
- `action.forward.stickiness`
- `action.redirect`
- `condition.hostHeader`
- `condition.httpHeader`
- `condition.httpRequest_method`
- `condition.pathPattern`
- `condition.queryString`
- `condition.sourceIp`

The function configuration itself does not change. However, now, include an index when referencing them. For example, update `action[0].authenticateCognito.scope` to `action[0].authenticateCognito[0].scope`.

## Function `aws.globalaccelerator.getAccelerator`

`id` is now **output only** and can no longer be set manually.
If your configuration explicitly attempts to set a value for `id`, you must remove it to avoid an error.

## Function `aws.identitystore.getGroup`

Remove `filter`—it is no longer supported. To locate a group, update your configuration to use `alternateIdentifier` instead.

## Function `aws.identitystore.getUser`

Remove `filter`—it is no longer supported.
To locate a user, update your configuration to use `alternateIdentifier` instead.

## Function `aws.kms.getSecret`

The functionality for this function was removed in **v3.0.0** and the data source will be removed in a future version.

## Function `aws.launch.getTemplate`

Remove the following—they are no longer supported:

- `elasticGpuSpecifications`: Amazon Elastic Graphics reached end of life in January 2024.
- `elasticInferenceAccelerator`: Amazon Elastic Inference reached end of life in April 2024.

## Function `aws.opensearch.getDomain`

Remove `kibanaEndpoint`—it is no longer supported. AWS OpenSearch Service no longer uses Kibana endpoints. The service now uses **Dashboards**, accessible at the `/_dashboards/` path on the domain endpoint.
For more details, refer to the [AWS OpenSearch Dashboards documentation](https://docs.aws.amazon.com/opensearch-service/latest/developerguide/dashboards.html).

## Function `aws.opensearchserverless.getSecurityConfig`

Treat `samlOptions` as a list of nested objects instead of an object. The function configuration itself does not change. However, now, include an index when referencing it. For example, update `samlOptions.sessionTimeout` to `samlOptions[0].sessionTimeout`.

## Function `aws.quicksight.getDataSet`

Remove `tagsAll`—it is no longer supported.

## Function `aws.getRegion`

`name` has been deprecated. Use `region` instead.

## Function `aws.s3.getBucket`

`bucketRegion` has been added and should be used instead of `region`, which is now used for [Enhanced Region Support](./enhanced-region-support.md).

## Function `aws.service.getDiscoveryService`

Remove `tagsAll`—it is no longer supported.

## Function `aws.servicequotas.getTemplates`

`region` has been deprecated. Use `awsRegion` instead.

## Function `aws.ssmincidents.getReplicationSet`

`region` has been deprecated. Use `regions` instead.

## Function `aws.vpc.getEndpointService`

`region` has been deprecated. Use `serviceRegion` instead.

## Function `aws.vpc.getPeeringConnection`

`region` has been deprecated. Use `requesterRegion` instead.

## Resource `aws.apigateway.Account`

Remove `resetOnDelete`—it is no longer supported. The destroy operation will now always reset the API Gateway account settings by default.

If you want to retain the previous behavior (where the account settings were not changed upon destruction), use the [`retainOnDelete` resource option](https://www.pulumi.com/docs/iac/concepts/options/retainondelete/).

## Resource `aws.apigateway.Deployment`

* Use the `aws.apigateway.Stage` resource if your configuration uses any of the following, which have been removed from the `aws.apigateway.Deployment` resource:
    - `stageName`
    - `stageDescription`
    - `canarySettings`

* `invokeUrl` and `executionArn` from `aws.apigateway.Deployment` have been removed—they are no longer supported. Use the `invokeUrl` and `executionArn` from the `aws.apigateway.Stage` resource instead.


### Migration Example

**Before (v6 and earlier, using implicit stage):**

```typescript
import * as aws from "@pulumi/aws";

const exampleDeployment = new aws.apigateway.Deployment("example", {
    restApi: exampleRestApi.id,
    stageName: "prod", // This is deprecated in newer versions
});

export const invokeUrl = exampleDeployment.invokeUrl;
export const executionArn = exampleDeployment.executionArn;
```

**After (v7+, using explicit stage):**

If your previous configuration relied on an implicitly created stage, you must now define and manage that stage explicitly using the `aws.apigateway.Stage` resource. Create a corresponding resource and import the existing stage into your configuration.

```typescript
import * as aws from "@pulumi/aws";

const exampleDeployment = new aws.apigateway.Deployment("example", {
    restApi: exampleRestApi.id,
});

const prodStage = new aws.apigateway.Stage("prod", {
    stageName: "prod",
    restApi: exampleRestApi.id,
    deployment: exampleDeployment.id,
});

export const invokeUrl = prodStage.invokeUrl;
export const executionArn = prodStage.executionArn;
```

**Import the existing stage:**

Replace `restApi` and `stageName` with your actual values:

```bash
pulumi import aws:apigateway/stage:Stage prod restApi/stageName
```

## Resource `aws.appflow.ConnectorProfile`

Importing an `aws.appflow.ConnectorProfile` resource now uses the `name` of the Connector Profile.

## Resource `aws.appflow.Flow`

Importing an `aws.appflow.Flow` resource now uses the `name` of the Flow.

## Resource `aws.batch.ComputeEnvironment`

Replace any usage of `computeEnvironmentName` with `name` and `computeEnvironmentNamePrefix` with `namePrefix` as they have been renamed.

## Resource `aws.batch.JobQueue`

Remove `computeEnvironments`—it is no longer supported.
Use `computeEnvironmentOrders` property instead. While you must update your configuration, Pulumi will upgrade states with `computeEnvironments` to `computeEnvironmentOrders`.

**Before (v6 and earlier):**

```typescript
const example = new aws.batch.JobQueue("example", {
    computeEnvironments: [exampleComputeEnvironment.arn],
    name: "patagonia",
    priority: 1,
    state: "ENABLED",
});
```

**After (v7+):**

```typescript
const example = new aws.batch.JobQueue("example", {
    computeEnvironmentOrders: [{
        computeEnvironment: exampleComputeEnvironment.arn,
        order: 0,
    }],
    name: "patagonia",
    priority: 1,
    state: "ENABLED",
});
```

## Resource `aws.bedrockmodel.InvocationLoggingConfiguration`

Treat the following as lists of object instead of an object:

- `loggingConfig`
- `loggingConfig.cloudwatchConfig`
- `loggingConfig.cloudwatchConfig.largeDataDeliveryS3Config`
- `loggingConfig.s3Config`

The resource configuration itself does not change, but you must now include an index when referencing them. For example, update `loggingConfig.cloudwatchConfig.logGroup_name` to `loggingConfig[0].cloudwatchConfig[0].logGroupName`.

## Resource `aws.cloudformation.StackSetInstance`

`region` has been deprecated. Use `stackSetInstanceRegion` instead.

## Resource `aws.cloudfront.KeyValueStore`

Use `name` to reference the resource name. `id` represents the ID value returned by the AWS API.

## Resource `aws.cloudfront.ResponseHeadersPolicy`

Do not set a value for `etag` as it is now computed only.

## Resource `aws.cognito.UserInGroup`

For the `id`, use a comma-delimited string concatenating `userPoolId`, `groupName`, and `username`. For example, in an import command, use comma-delimiting for the composite `id`.

## Resource `aws.cfg.AggregateAuthorization`

`region` has been deprecated. Use `authorizedAwsRegion` instead.

## Resource `aws.rds.Instance`

Do not use `characterSetName` with `replicateSourceDb`, `restoreToPointInTime`, `s3Import`, or `snapshotIdentifier`. The combination is no longer valid.

`name` was deprecated in `v6` and has been removed in `v7`. Use `dbName` instead.

## Resource `aws.dms.Endpoint`

`s3Settings` has been removed. Use the `aws.dms.S3Endpoint` resource rather than `s3Settings` of `aws.dms.Endpoint`.

## Resource `aws.directconnect.GatewayAssociation`

Remove `vpnGatewayId`—it is no longer supported. Use `associatedGatewayId` instead.

## Resource `aws.directconnect.HostedConnection`

`region` has been deprecated. Use `connectionRegion` instead.

## Resource `aws.ecs.TaskDefinition`

Remove `inferenceAccelerator`—it is no longer supported. Amazon Elastic Inference reached end of life in April 2024.

## Resource `aws.ec2.Eip`

Remove `vpc`—it is no longer supported. Use `domain` instead.

## Resource `aws.eks.Addon`

Remove `resolveConflicts`—it is no longer supported. Use `resolveConflictsOnCreate` and `resolveConflictsOnUpdate` instead.

## Resource `aws.eks.Cluster`

`certificateAuthorities` is no longer supported. Use `certificateAuthority` instead.

## Resource `aws.elasticache.ReplicationGroup`

* `authTokenUpdateStrategy` no longer has a default value. If `authToken` is set, it must also be explicitly configured.
* The ability to provide an uppercase `engine` value is deprecated. In `v7.0.0`, plan-time validation of `engine` will require an entirely lowercase value to match the returned value from the AWS API without diff suppression.
* See also [changes](#typenullablebool-validation-update) to `atRestEncryptionEnabled` and `autoMinorVersionUpgrade`.

## Resource `aws.elasticache.User`

The ability to provide an uppercase `engine` value is deprecated.
In `v7.0.0`, plan-time validation of `engine` will require an entirely lowercase value to match the returned value from the AWS API without diff suppression.

## Resource `aws.elasticache.UserGroup`

The ability to provide an uppercase `engine` value is deprecated.
In `v7.0.0`, plan-time validation of `engine` will require an entirely lowercase value to match the returned value from the AWS API without diff suppression.

## Resource `aws.ec2.FlowLog`

Remove `logGroupName`—it is no longer supported. Use `logDestination` instead.

## Resource `aws.guardduty.Detector`

`datasources` is deprecated.
Use the `awsGuarddutyDetectorFeature` resource instead.

## Resource `aws.guardduty.OrganizationConfiguration`

* Remove `autoEnable`—it is no longer supported.
* `autoEnableOrganizationMembers` is now required.
* `datasources` is deprecated.

## Resource `aws.ec2.Instance`

* `userData` no longer applies hashing and is now stored in clear text. **Do not include passwords or sensitive information** in `userData`, as it will be visible in plaintext. Follow [AWS Best Practices](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html) to secure your instance metadata. If you need to provide base64-encoded user data, use `userDataBase64` instead.
* Remove `cpuCoreCount` and `cpuThreadsPerCore`—they are no longer supported. Instead, use the `cpuOptions` configuration block with `coreCount` and `threadsPerCore`.

## Resource `aws.kinesis.AnalyticsApplication`

This resource is deprecated and will be removed in a future version. [Effective January 27, 2026](https://aws.amazon.com/blogs/big-data/migrate-from-amazon-kinesis-data-analytics-for-sql-to-amazon-managed-service-for-apache-flink-and-amazon-managed-service-for-apache-flink-studio/), AWS will [no longer support](https://docs.aws.amazon.com/kinesisanalytics/latest/dev/discontinuation.html) Amazon Kinesis Data Analytics for SQL. Use the `aws.kinesisanalyticsv2.Application` resource instead to manage Amazon Kinesis Data Analytics for Apache Flink applications. AWS provides guidance for migrating from [Amazon Kinesis Data Analytics for SQL Applications to Amazon Managed Service for Apache Flink Studio](https://aws.amazon.com/blogs/big-data/migrate-from-amazon-kinesis-data-analytics-for-sql-applications-to-amazon-managed-service-for-apache-flink-studio/) including [examples](https://docs.aws.amazon.com/kinesisanalytics/latest/dev/migrating-to-kda-studio-overview.html).

## Resource `aws.ec2.LaunchTemplate`

* Remove `elasticGpuSpecifications`—it is no longer supported. Amazon Elastic Graphics reached end of life in January 2024.
* Remove `elasticInferenceAccelerator`—it is no longer supported. Amazon Elastic Inference reached end of life in April 2024.
* See also [changes](#typenullablebool-validation-update) to `blockDeviceMappings.ebs.deleteOnTermination`, `blockDeviceMappings.ebs.encrypted`, `ebsOptimized`, `networkInterfaces.associateCarrierIpAddress`, `networkInterfaces.associatePublicIpAddress`, `networkInterfaces.deleteOnTermination`, and `networkInterfaces.primaryIpv6`.

## Resource `aws.lb.Listener`

* For `mutualAuthentication`, `advertiseTrustStoreCaNames`, `ignoreClientCertificateExpiry`, and `trustStoreArn` can now only be set when `mode` is `verify`.
* `trustStoreArn` is required when `mode` is `verify`.

## Resource `aws.mediastore.Container`

This resource is deprecated and will be removed in a future version. AWS has [announced](https://aws.amazon.com/blogs/media/support-for-aws-elemental-mediastore-ending-soon/) the discontinuation of AWS Elemental MediaStore, effective November 13, 2025. Users should begin transitioning to alternative solutions as soon as possible. For simple live streaming workflows, AWS recommends migrating to Amazon S3. For advanced use cases that require features such as packaging, DRM, or cross-region redundancy, consider using AWS Elemental MediaPackage.

## Resource `aws.mediastore.ContainerPolicy`

This resource is deprecated and will be removed in a future version. AWS has [announced](https://aws.amazon.com/blogs/media/support-for-aws-elemental-mediastore-ending-soon/) the discontinuation of AWS Elemental MediaStore, effective November 13, 2025. Users should begin transitioning to alternative solutions as soon as possible. For simple live streaming workflows, AWS recommends migrating to Amazon S3. For advanced use cases that require features such as packaging, DRM, or cross-region redundancy, consider using AWS Elemental MediaPackage.

## Resource `aws.networkmanager.CoreNetwork`

Remove `basePolicyRegion`—it is no longer supported. Use `basePolicyRegions` instead.

## Resource `aws.opensearch.Domain`

Remove `kibanaEndpoint`—it is no longer supported. AWS OpenSearch Service does not use Kibana endpoints (i.e., `_plugin/kibana`). Instead, OpenSearch uses Dashboards, accessible at the path `/_dashboards/` on the domain endpoint. The terminology has shifted from “Kibana” to “Dashboards.”

For more information, see the [AWS OpenSearch Dashboards documentation](https://docs.aws.amazon.com/opensearch-service/latest/developerguide/dashboards.html).

## Resource `aws.opensearch.ServerlessSecurityConfig`

Treat `samlOptions` as a list of nested blocks instead of a single-nested block. The resource configuration itself does not change. However, now, include an index when referencing it. For example, update `samlOptions.sessionTimeout` to `samlOptions[0].sessionTimeout`.

## Resource `aws.paymentcryptography.Key`

Treat the `keyAttributes` and `keyAttributes.keyModesOfUse` as lists of nested blocks instead of single-nested blocks. The resource configuration itself does not change. However, now, include an index when referencing them. For example, update `keyAttributes.keyModesOfUse.decrypt` to `keyAttributes[0].keyModesOfUse[0].decrypt`.

## Resource `aws.redshift.Cluster`

* `encrypted` now defaults to `true`.
* `publiclyAccessible` now defaults to `false`.
* Remove `snapshotCopy`—it is no longer supported. Use the `awsRedshiftSnapshotCopy` resource instead.
* Remove `logging`—it is no longer supported. Use the `awsRedshiftLogging` resource instead.
* `clusterPublicKey`, `clusterRevisionNumber`, and `endpoint` are now read only and should not be set.

## Resource `aws.redshift.ServiceAccount`

The `aws.Redshift.ServiceAccount` resource has been removed. AWS [recommends](https://docs.aws.amazon.com/redshift/latest/mgmt/db-auditing.html#db-auditing-bucket-permissions) that a [service principal name](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services) should be used instead of an AWS account ID in any relevant IAM policy.

## Resource `aws.rekognition.StreamProcessor`

Treat `regionsOfInterest.boundingBox` as a list of nested blocks instead of a single-nested block. The resource configuration itself does not change. However, now, include an index when referencing it. For example, update `regionsOfInterest[0].boundingBox.height` to `regionsOfInterest[0].boundingBox[0].height`.

## Resource `aws.resiliencehub.ResiliencyPolicy`

Treat the following as lists of objects instead of an object.

- `policy`
- `policy.az`
- `policy.hardware`
- `policy.software`
- `policy.region`

The resource configuration itself does not change. However, now, include an index when referencing them. For example, update `policy.az.rpo` to `policy[0].az[0].rpo`.

## Resource `aws.s3.Bucket`

`bucketRegion` has been added and should be used instead of `region`, which is now used for [Enhanced Region Support](enhanced-region-support.html).

## Resource `aws.sagemaker.ImageVersion`

For the `id`, use a comma-delimited string concatenating `imageName` and `version`. For example, in an import command, use comma-delimiting for the composite `id`.
Use `imageName` to reference the image name.

## Resource `aws.sagemaker.NotebookInstance`

Remove `acceleratorTypes`—it is no longer supported. Instead, use `instanceType` to use [Inferentia](https://docs.aws.amazon.com/sagemaker/latest/dg/neo-supported-cloud.html).

## Resource `aws.servicequotas.Template`

`region` has been deprecated. Use `awsRegion` instead.

## Resource `aws.ec2.SpotInstanceRequest`

Remove `blockDurationMinutes`—it is no longer supported.

## Resource `aws.ssm.Association`

Remove `instanceId`—it is no longer supported. Use `targets` instead.

## Resource `aws.ssmincidents.ReplicationSet`

`region` has been deprecated. Use `regions` instead.

## Resource `aws.verifiedpermissions.Schema`

Treat `definition` as a list of objects instead of an object. The resource configuration itself does not change. However, now, include an index when referencing it. For example, update `definition.value` to `definition[0].value`.

## Resource `aws.wafv2.WebAcl`

The default value for `rule.statement.managedRuleGroupStatement.managedRuleGroupConfigs.awsManagedRulesBotControlRuleSet.enableMachineLearning` is now `false`.
To retain the previous behavior where the argument was omitted, explicitly set the value to `true`.

## Node Only Changes

The following changes only affect users of the `nodejs` SDK.

### applicationloadbalancing

- Removed `Ipv4`
  - Use `IpAddressType.Ipv4` instead
- Removed `Dualstack`
  - Use `IpAddressType.Dualstack` instead
- Removed `ApplicationLoadBalancer`
  - Use `LoadBalancerType.Application` instead
- Removed `NetworkLoadBalancer`
  - Use `LoadBalancerType.Network` instead

### rds

- Removed `InstanceTypes.*`
  - Use `InstanceType.*` instead

- Removed `StorageTypes.Standard` 
  - Use `StorageType.Standard` instead
- Removed `StorageTypes.GP2` 
  - Use `StorageType.GP2` instead
- Removed `StorageTypes.Io1` 
  - Use `StorageType.IO1` instead

- Removed `ProvisionedEngine` 
  - Use `EngineMode.Provisioned` instead
- Removed `ServerlessEngine` 
  - Use `EngineMode.Serverless` instead
- Removed `ParallelQueryEngine` 
  - Use `EngineMode.ParallelQuery` instead
- Removed `GlobalEngine` 
  - Use `EngineMode.Global` instead

- Removed `AuroraEngine` 
  - Use `EngineType.Aurora` instead
- Removed `AuroraMysqlEngine` 
  - Use `EngineType.AuroraMysql` instead
- Removed `AuroraPostgresqlEngine` 
  - Use `EngineType.AuroraPostgresql` instead

### iam

- Removed `ManagedPolicies.*`
  - Use `ManagedPolicy.*` instead

### route53

- Removed `RecordTypes.A` 
  - Use `RecordType.A` instead
- Removed `RecordTypes.AAAA` 
  - Use `RecordType.AAAA` instead
- Removed `RecordTypes.CNAME` 
  - Use `RecordType.CNAME` instead
- Removed `RecordTypes.CAA` 
  - Use `RecordType.CAA` instead
- Removed `RecordTypes.MX` 
  - Use `RecordType.MX` instead
- Removed `RecordTypes.NAPTR` 
  - Use `RecordType.NAPTR` instead
- Removed `RecordTypes.NS` 
  - Use `RecordType.NS` instead
- Removed `RecordTypes.PTR` 
  - Use `RecordType.PTR` instead
- Removed `RecordTypes.SOA` 
  - Use `RecordType.SOA` instead
- Removed `RecordTypes.SPF` 
  - Use `RecordType.SPF` instead
- Removed `RecordTypes.SRV` 
  - Use `RecordType.SRV` instead
- Removed `RecordTypes.TXT` 
  - Use `RecordType.TXT` instead

### s3

- Removed `PrivateAcl` 
  - Use `CannedAcl.Private` instead
- Removed `PublicReadAcl` 
  - Use `CannedAcl.PublicRead` instead
- Removed `PublicReadWriteAcl` 
  - Use `CannedAcl.PublicReadWrite` instead
- Removed `AwsExecReadAcl` 
  - Use `CannedAcl.AwsExecRead` instead
- Removed `AuthenticatedReadAcl` 
  - Use `CannedAcl.AuthenticatedRead` instead
- Removed `BucketOwnerReadAcl` 
  - Use `CannedAcl.BucketOwnerRead` instead
- Removed `BucketOwnerFullControlAcl` 
  - Use `CannedAcl.BucketOwnerFullControl` instead
- Removed `LogDeliveryWriteAcl` 
  - Use `CannedAcl.LogDeliveryWrite` instead

### ec2

- Removed `InstanceTypes.*` 
  - Use `InstanceType.*` instead

- Removed `InstancePlatforms.LinuxUnixPlatform` 
  - Use `InstancePlatform.LinuxUnix` instead
- Removed `InstancePlatforms.RedHatEnterpriseLinuxPlatform` 
  - Use `InstancePlatform.RedHatEnterpriseLinux` instead
- Removed `InstancePlatforms.SuseLinuxPlatform` 
  - Use `InstancePlatform.SuseLinux` instead
- Removed `InstancePlatforms.WindowsPlatform` 
  - Use `InstancePlatform.Windows` instead
- Removed `InstancePlatforms.WindowsWithSqlServerPlatform` 
  - Use `InstancePlatform.WindowsWithSqlServer` instead
- Removed `InstancePlatforms.WindowsWithSqlServerEnterprisePlatform` 
  - Use `InstancePlatform.WindowsWithSqlServerEnterprise` instead
- Removed `InstancePlatforms.WindowsWithSqlServerStandardPlatform` 
  - Use `InstancePlatform.WindowsWithSqlServerStandard` instead
- Removed `InstancePlatforms.WindowsWithSqlServerWebPlatform` 
  - Use `InstancePlatform.WindowsWithSqlServerWeb` instead

- Removed `SpreadStrategy` 
  - Use `PlacementStrategy.Spread` instead
- Removed `ClusterStrategy` 
  - Use `PlacementStrategy.Cluster` instead

- Removed `AllProtocols` 
  - Use `ProtocolType.All` instead
- Removed `TCPProtocol` 
  - Use `ProtocolType.TCP` instead
- Removed `UDPProtocol` 
  - Use `ProtocolType.UDP` instead
- Removed `ICMPProtocol` 
  - Use `ProtocolType.ICMP` instead

- Removed `Tenancies.DefaultTenancy` 
  - Use `Tenancy.Default` instead
- Removed `Tenancies.DedicatedTenancy` 
  - Use `Tenancy.Dedicated` instead

### ecr

The `rules` input property of the `ecr.LifecyclePolicyDocument` type has changed from `ecr.PolicyRule[]` to `pulumi.Input<pulumi.Input<ecr.PolicyRule>[]>;`.

**Before (v6)**

```typescript
const result: aws.ecr.LifecyclePolicyDocument = { rules: [] };
result.rules.push({
    action: {
        type: 'expire',
    },
    rulePriority: 1,
    selection: {
        countType: 'imageCountMoreThan',
        countNumber: 3,
        tagStatus: 'any',
    },
});
```

**After (v7)**

```typescript
const result: aws.ecr.LifecyclePolicyDocument = { rules: [] };
const rules: aws.ecr.PolicyRule[] = [];
rules.push({
    action: {
        type: 'expire',
    },
    rulePriority: 1,
    selection: {
        countType: 'imageCountMoreThan',
        countNumber: 3,
        tagStatus: 'any',
    },
});
result.rules = rules;
```

### lambda

- Removed `DotnetCore2d1Runtime` 
  - Use `Runtime.DotnetCore2d1` instead
- Removed `DotnetCore3d1Runtime` 
  - Use `Runtime.DotnetCore3d1` instead
- Removed `Go1dxRuntime` 
  - Use `Runtime.Go1dx` instead
- Removed `Java8Runtime` 
  - Use `Runtime.Java8` instead
- Removed `Java11Runtime` 
  - Use `Runtime.Java11` instead
- Removed `Ruby2d5Runtime` 
  - Use `Runtime.Ruby2d5` instead
- Removed `Ruby2d7Runtime` 
  - Use `Runtime.Ruby2d7` instead
- Removed `NodeJS10dXRuntime` 
  - Use `Runtime.NodeJS10dX` instead
- Removed `NodeJS12dXRuntime` 
  - Use `Runtime.NodeJS12dX` instead
- Removed `Python2d7Runtime` 
  - Use `Runtime.Python2d7` instead
- Removed `Python3d6Runtime` 
  - Use `Runtime.Python3d6` instead
- Removed `Python3d7Runtime` 
  - Use `Runtime.Python3d7` instead
- Removed `Python3d8Runtime` 
  - Use `Runtime.Python3d8` instead
- Removed `CustomRuntime` 
  - Use `Runtime.Custom` instead

### ssm

- Removed `StringParameter`
  - Use `ParamterType.String` instead
- Removed `StringListParameter`
  - Use `ParamterType.StringList` instead
- Removed `SecureStringParameter`
  - Use `ParameterType.SecureString` instead

### region

- Removed `AFSouth1Region`
  - Use `Region.AFSouth1` instead
- Removed `APEast1Region`
  - Use `Region.AFEast1` instead
- Removed `APNortheast1Region`
  - Use `Region.AFNortheast1` instead
- Removed `APNortheast2Region`
  - Use `Region.APNortheast2` instead
- Removed `APSouth1Region`
  - Use `Region.APSouth1` instead
- Removed `APSouthEast2Region`
  - Use `Region.APSoutheast2` instead
- Removed `APSoutheast1Region`
  - Use `Region.APSoutheast1` instead
- Removed `CACentralRegion`
  - Use `Region.CACentral1` instead
- Removed `CNNorth1Region`
  - Use `Region.CNNorth1` instead
- Removed `CNNorthWest1Region`
  - Use `Region.CNNorthwest1` instead
- Removed `EUCentral1Region`
  - Use `Region.EUCentral1` instead
- Removed `EUNorth1Region`
  - Use `Region.EUNorth1` instead
- Removed `EUWest1Region`
  - Use `Region.EUWest1` instead
- Removed `EUWest2Region`
  - Use `Region.EUWest2` instead
- Removed `EUWest3Region`
  - Use `Region.EUWest3` instead
- Removed `EUSouth1Region`
  - Use `Region.EUSouth1` instead
- Removed `MESouth1Region`
  - Use `Region.MESouth1` instead
- Removed `SAEast1Region`
  - Use `Region.SAEast1` instead
- Removed `USGovEast1Region`
  - Use `Region.USGovEast1` instead
- Removed `USGovWest1Region`
  - Use `Region.USGovWest1` instead
- Removed `USEast1Region`
  - Use `Region.USEast1` instead
- Removed `USEast2Region`
  - Use `Region.USEast2` instead
- Removed `USWest1Region`
  - Use `Region.USWest1` instead
- Removed `USWest2Region`
  - Use `Region.USWest2` instead

## Enum Removals

The following enum values have been removed.

- `ec2.InstanceType.U_12TB1_METAL`
- `ec2.InstanceType.U_6TB1_METAL`
- `ec2.InstanceType.U_9TB1_METAL`
- `ec2.InstanceType.HS1_8_X_LARGE`
- `ec2.InstanceType.M5AS_X_LARGE`
- `ec2.InstanceType.C7A_METAL`
- `ec2.InstanceType.M7A_METAL`
- `ec2.InstanceType.CC2_8_X_LARGE`
- `ec2.InstanceType.G2_2_X_LARGE`
- `ec2.InstanceType.G2_8_X_LARGE`

- `ManagedPolicy.AWS_CODE_PIPELINE_READ_ONLY_ACCESS`
  - Use `ManagedPolicy.CodePipeline_ReadOnlyAccess` instead
- `ManagedPolicy.AWS_CONFIG_ROLE`
  - Use `ManagedPolicy.AWS_ConfigRole` instead
- `ManagedPolicy.AWS_DATA_PIPELINE_ROLE`
- `ManagedPolicy.AWS_ELASTIC_BEANSTALK_FULL_ACCESS`
  - Use `ManagedPolicy.AdministratorAccessAWSElasticBeanstalk` instead
- `ManagedPolicy.AWS_ELASTIC_BEANSTALK_READ_ONLY_ACCESS`
  - Use `ManagedPolicy.AWSElasticBeanstalkReadOnly` instead
- `ManagedPolicy.AWS_ELASTIC_BEANSTAK_WORKER_TIER`
  - Use `ManagedPolicy.AWSElasticBeanstalkWorkerTier` instead
- `ManagedPolicy.AWS_GREENGRASS_FULLCCESS`
  - Use `ManagedPolicy.AWSGreengrassFullAccess` instead
- `ManagedPolicy.AWS_LAMBDA_FULL_ACCESS`
  - Use `ManagedPolicy.LambdaFullAccess` instead
- `ManagedPolicy.AWS_LAMBDA_READ_ONLY_ACCESS`
  - Use `ManagedPolicy.LambdaReadOnlyAccess` instead
- `ManagedPolicy.AWS_MOBILE_HUB_FULL_ACCESS`
- `ManagedPolicy.AWS_MOBILE_HUB_READ_ONLY`
- `ManagedPolicy.AWS_MOBILE_HUB_SERVICE_USE_ONLY`
- `ManagedPolicy.AWS_OPS_WORKS_FULL_ACCESS`
  - Use `ManagedPolicy.OpsWorks_FullAccess` instead
- `ManagedPolicy.AWS_OPS_WORKS_REGISTER_CLI`
  - Use `ManagedPolicy.AWSOpsWorksRegisterCLI_EC2` or `ManagedPolicy.AWSOpsWorksRegisterCLI_OnPremises` instead
- `ManagedPolicy.AWS_OPS_WORKS_ROLE`
  - Use `ManagedPolicy.AWSOpsWorksCMServiceRole` instead
- `ManagedPolicy.AWS_QUICK_SIGHT_DESCRIBE_RD`
  - Use `ManagedPolicy.AWSQuickSightDescribeRDS` instead
- `ManagedPolicy.AMAZON_EC2_CONTAINER_SERVICE_FULL_ACCESS`
  - Use `ManagedPolicy.AmazonECSFullAccess` instead
- `ManagedPolicy.AMAZON_EC2_REPORTS_ACCESS`
- `ManagedPolicy.AMAZON_EC2_SPOT_FLEET_ROLE`
- `ManagedPolicy.AMAZON_ELASTIC_TRANSCODER_FULL_ACCESS`
  - Use `ManagedPolicy.ElasticTranscoder_FullAccess` instead
- `ManagedPolicy.AMAZON_ELASTIC_TRANSCODER_JOBS_SUBMITTER`
  - Use `ManagedPolicy.ElasticTranscoder_JobsSubmitter` instead
- `ManagedPolicy.AMAZON_ELASTIC_TRANSCODER_READ_ONLY_ACCESS`
  - Use `ManagedPolicy.ElasticTranscoder_ReadOnlyAccess` instead
- `ManagedPolicy.AMAZON_LAUNCH_WIZARD_FULLACCESS`
- `ManagedPolicy.AMAZON_MACHINE_LEARNING_ROLEFOR_REDSHIFT_DATA_SOURCE`
  - Use `ManagedPolicy.AmazonMachineLearningRoleforRedshiftDataSourceV3` instead
- `ManagedPolicy.AMAZON_SUMERIAN_FULL_ACCESS`
- `ManagedPolicy.FUSION_DEV_INTERNAL_SERVICE_ROLE_POLICY`
- `ManagedPolicy.SERVER_MIGRATION_SERVICE_ROLE`
  - Use `ManagedPolicy.AWSServerMigration_ServiceRole` instead
- `ManagedPolicy.SERVICE_CATALOG_ADMIN_FULL_ACCESS`
  - Use `ManagedPolicy.AWSServiceCatalogAdminFullAccess` instead
- `ManagedPolicy.SERVICE_CATALOG_ADMIN_READ_ONLY_ACCESS`
  - Use `ManagedPolicy.AWSServiceCatalogAdminReadOnlyAccess` instead
- `ManagedPolicy.SERVICE_CATALOG_END_USER_ACCESS`
  - Use `ManagedPolicy.AWSServiceCatalogEndUserReadOnlyAccess` instead
- `ManagedPolicy.SERVICE_CATALOG_END_USER_FULL_ACCESS`
  - Use `ManagedPolicy.AWSServiceCatalogEndUserFullAccess` instead

(Related to deprecated AWS Services)
- `ManagedPolicy.AmazonChimeFullAccess`
- `ManagedPolicy.AmazonChimeReadOnly`
- `ManagedPolicy.AmazonChimeSDK`
- `ManagedPolicy.AmazonChimeSDKMediaPipelinesServiceLinkedRolePolicy`
- `ManagedPolicy.AmazonChimeSDKMessagingServiceRolePolicy`
- `ManagedPolicy.AmazonChimeServiceRolePolicy`
- `ManagedPolicy.AmazonChimeTranscriptionServiceLinkedRolePolicy`
- `ManagedPolicy.AmazonChimeUserManagement`
- `ManagedPolicy.AmazonChimeVoiceConnectorServiceLinkedRolePolicy`
- `ManagedPolicy.AWSOpsWorksCMInstanceProfileRole`
- `ManagedPolicy.AWSOpsWorksCMServiceRole`
- `ManagedPolicy.AWSOpsWorksCloudWatchLogs`
- `ManagedPolicy.AWSOpsWorksInstanceRegistration`
- `ManagedPolicy.AWSOpsWorksRegisterCLI_EC2`
- `ManagedPolicy.AWSOpsWorksRegisterCLI_OnPremises`
- `ManagedPolicy.OpsWorks_FullAccess`
- `ManagedPolicy.WorkLinkServiceRolePolicy`
