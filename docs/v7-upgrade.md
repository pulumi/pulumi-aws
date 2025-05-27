# [WIP] v7 Upgrade

## Breaking Changes

### Provider role chaining

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

### Bucket/BucketV2 Changes

As part of this major version upgrade we are removing the old `Bucket` resource
and are renaming `BucketV2` to `Bucket`. This change should simplify things for
users and make it easier to understand which bucket resources to use. There will
now only be one version of bucket resources without any version information.

As part of this change there will be breaking changes in the Bucket SDKs
that fall into two categories.

1. Renamed resources. Users will need to update their code to rename the
   resource to the new name (e.g. `BucketV2` => `Bucket`)
2. MaxItemsOne changes. Fields that were previously (in v6) lists that only
   accepted a single item have been changed to no longer be lists. For example,
   the `serverSideEncryptionConfigurations` field on `BucketV2` was a list that
   only accepted a single configuration item. This is now
   `serverSideEncryptionConfiguration`.
 
TODO[pulumi/pulumi-aws#5524]
See the upgrade guide for more detailed information.

#### MaxItemsOne Changes

The following input properties have changed from a list of properties to a
single property.

- `loggings` => `logging`
- `replicationConfigurations` => `replicationConfiguration`
  - `rules`
    - `destinations` => `destination`
      - `replicationTimes` => `replicationTime`
      - `accessControlTranslations` => `accessControlTranslation`
    - `filters` => `filter`
    - `sourceSelectionCriterias` => `sourceSelectionCriteria`
      - `sseKmsEncryptedObjects` => `sseKmsEncryptedObjects` (list to object)
- `serverSideEncryptionConfigurations` => `serverSideEncryptionConfiguration`
  - `rules` => `rule`
    - `applyServerSideEncryptionByDefaults` => `applyServerSideEncryptionByDefault`
- `versionings` => `versioning`
- `website` => `websites`
- `lifecycleRules`
  - `noncurrentVersionExpirations` => `noncurrentVersionExpiration`
  - `expirations` => `expiration`

#### Renamed Resources

- `aws:s3/bucketAccelerateConfigurationV2:BucketAccelerateConfigurationV2` => `s3/bucketAccelerateConfiguration.BucketAccelerateConfiguration`
- `aws:s3/bucketRequestPaymentConfigurationV2:BucketRequestPaymentConfigurationV2` => `s3/bucketRequestPaymentConfiguration.BucketRequestPaymentConfiguration`
- `aws:s3/bucketAclV2:BucketAclV2` => `s3/bucketAcl.BucketAcl`
- `aws:s3/bucketCorsConfigurationV2:BucketCorsConfigurationV2` => `s3/bucketCorsConfiguration.BucketCorsConfiguration`
- `aws:s3/bucketLifecycleConfigurationV2:BucketLifecycleConfigurationV2` => `s3/bucketLifecycleConfiguration.BucketLifecycleConfiguration`
- `aws:s3/bucketLoggingV2:BucketLoggingV2` => `s3/bucketLogging.BucketLogging`
- `aws:s3/bucketObjectLockConfigurationV2:BucketObjectLockConfigurationV2` => `s3/bucketObjectLockConfiguration.BucketObjectLockConfiguration`
- `aws:s3/bucketServerSideEncryptionConfigurationV2:BucketServerSideEncryptionConfigurationV2` => `s3/bucketServerSideEncryptionConfiguration.BucketServerSideEncryptionConfiguration`
- `aws:s3/bucketV2:BucketV2` => `s3/bucket:Bucket`
- `aws:s3/bucketVersioningV2:BucketVersioningV2` => `s3/bucketVersioning.BucketVersioning`
- `aws:s3/bucketWebsiteConfigurationV2:BucketWebsiteConfigurationV2` => `s3/bucketWebsiteConfiguration.BucketWebsiteConfiguration`


### Resource Deprecations

Upstream has removed the following deprecated resources:

- "aws:config/endpoints:endpoints": properties:
    - `🟡` "opsworks" missing
    - `🟡` "sdb" missing
    - `🟡` "simpledb" missing
    - `🟡` "worklink" missing

- "aws:index/ProviderEndpoint:ProviderEndpoint": properties:
    - `🟡` "opsworks" missing
    - `🟡` "sdb" missing
    - `🟡` "simpledb" missing
    - `🟡` "worklink" missing

#### chime
- `🔴` "aws:chime/voiceConnectorOrganization:VoiceConnectorOrganization" missing
- `🔴` "aws:chime/VoiceConnectorOrganizationRoute:VoiceConnectorOrganizationRoute" missing

#### directoryservice
- `🔴` "aws:directoryservice/conditionalForwader:ConditionalForwader" missing
- `🔴` "aws:directoryservice/logService:LogService" missing

#### Gamelift
- `🔴` "aws:gamelift/matchmakingConfiguration:MatchmakingConfiguration" missing
- `🔴` "aws:gamelift/matchmakingRuleSet:MatchmakingRuleSet" missing

#### opsworks
- `🔴` "aws:opsworks/application:Application" missing
- `🔴` "aws:opsworks/customLayer:CustomLayer" missing
- `🔴` "aws:opsworks/ecsClusterLayer:EcsClusterLayer" missing
- `🔴` "aws:opsworks/gangliaLayer:GangliaLayer" missing
- `🔴` "aws:opsworks/haproxyLayer:HaproxyLayer" missing
- `🔴` "aws:opsworks/instance:Instance" missing
- `🔴` "aws:opsworks/javaAppLayer:JavaAppLayer" missing
- `🔴` "aws:opsworks/memcachedLayer:MemcachedLayer" missing
- `🔴` "aws:opsworks/mysqlLayer:MysqlLayer" missing
- `🔴` "aws:opsworks/nodejsAppLayer:NodejsAppLayer" missing
- `🔴` "aws:opsworks/permission:Permission" missing
- `🔴` "aws:opsworks/phpAppLayer:PhpAppLayer" missing
- `🔴` "aws:opsworks/railsAppLayer:RailsAppLayer" missing
- `🔴` "aws:opsworks/rdsDbInstance:RdsDbInstance" missing
- `🔴` "aws:opsworks/stack:Stack" missing
- `🔴` "aws:opsworks/staticWebLayer:StaticWebLayer" missing
- `🔴` "aws:opsworks/userProfile:UserProfile" missing

#### simpledb

- `🔴` "aws:simpledb/domain:Domain" missing

#### worklink

- `🔴` "aws:worklink/fleet:Fleet" missing
- `🔴` "aws:worklink/websiteCertificateAuthorityAssociation:WebsiteCertificateAuthorityAssociation" missing

#### Elastic Inference

- `🔴` "aws:ecs/TaskDefinitionInferenceAccelerator:TaskDefinitionInferenceAccelerator" missing
- `🔴` "aws:ecs/getTaskDefinitionInferenceAccelerator:getTaskDefinitionInferenceAccelerator" missing
- `🟡` "aws:ecs/getTaskExecutionOverrides:getTaskExecutionOverrides": properties: "inferenceAcceleratorOverrides" missing
- `🔴` "aws:ecs/getTaskExecutionOverridesInferenceAcceleratorOverride:getTaskExecutionOverridesInferenceAcceleratorOverride" missing


### Behavior Changes

Upstream has made the following behavioral changes to resources.

#### `aws:apigateway/account:Account`

`aws_apigateway_account` - We will update the behavior of the so that deleting it
will always reset account settings. As part of this change, we will also remove
the reset_on_delete attribute, which was introduced as a temporary workaround to
avoid breaking changes.
[#40043](https://github.com/hashicorp/terraform-provider-aws/issues/40043)

- "aws:apigateway/account:Account":
    - `🟡` inputs: "resetOnDelete" missing
    - `🟡` properties: "resetOnDelete" missing output "resetOnDelete"

#### aws_redshift_cluster

`aws_redshift_cluster` - We will update the aws_redshift_cluster resource to align
with AWS's changes to default public accessibility settings. As of January 10,
2025, AWS disabled public accessibility by default for newly provisioned
Redshift clusters. Currently, the provider sets a default value of true rather
than leaving the attribute unset to inherit AWS's default, which is both
inconsistent with best practices and unsafe. We will remove this default so that
new clusters follow AWS's intended behavior. Additionally, we will correct the
attribute types for cluster_public_key, cluster_revision_number, and endpoint,
which are currently marked as Optional, Computed but should be Computed only, as
they are set by AWS and cannot be configured by the user.[#41041](https://github.com/hashicorp/terraform-provider-aws/issues/41041),
[#41044](https://github.com/hashicorp/terraform-provider-aws/issues/41044)

- "aws:redshift/cluster:Cluster":
    - inputs:
        - `🟡` "clusterPublicKey" missing
        - `🟡` "clusterRevisionNumber" missing
        - `🟡` "endpoint" missing
        - `🟡` "logging" missing
        - `🟡` "snapshotCopy" missing
    - properties:
        - `🟡` "logging" missing output "logging"
        - `🟡` "snapshotCopy" missing output "snapshotCopy"

#### aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy

`aws_cloudfront_response_headers_policy` - We will update the behavior of the
resource to make the etag attribute computed and read-only. We will also
document the attribute to clarify its purpose. [#38244](https://github.com/hashicorp/terraform-provider-aws/issues/38244)

- `🟡` "aws:cloudfront/responseHeadersPolicy:ResponseHeadersPolicy": inputs: "etag" missing

#### aws:globalaccelerator/getAccelerator:getAccelerator

`aws_globalaccelerator_accelerator` - We will update the data source so that the
id attribute is no longer settable. Currently, users can provide a value for id,
but it is ignored and does not influence the data source’s behavior. This change
aligns with common patterns in Terraform, where id is typically a read-only
attribute reflecting a resource’s actual identifier. [#39236](https://github.com/hashicorp/terraform-provider-aws/issues/39236)

- `🟡` "aws:globalaccelerator/getAccelerator:getAccelerator": inputs: "id" missing input "id"

### Tags Changes

This release some changes to the way tags work in the Pulumi AWS Provider. In v6
of the Pulumi AWS Provider we customized the tagging behavior of the provider
through Pulumi level patches to the upstream Terraform provider along with other
Pulumi level customizations. This resulted in tagging behavior that diverged
from the upstream Terraform provider and has been difficult to maintain as the
upstream Terraform provider has made changes to tagging.

In v7 we are removing the Pulumi level customizations and going back to relying
on the upstream provider's tagging behavior.

### Patch Related Changes

We have created several Pulumi level patches to the upstream Terraform provider
to address issues/limitations that existed in the upstream provider. Several of
those issues/limitations have now been addressed in the upstream Terraform
provider and we are removing the Pulumi level patch. Users will need to migrate
their code to use the new features.

- [ ] TODO: explain why removing patches is a good thing overall

#### EKS Cluster

We are removing the `defaultAddonsToRemoves` property. This property does not
exist in the upstream `terraform-provider-aws` provider and was added to
workaround some limitations. Since then the upstream provider has added the
`bootstrapSelfManagedAddons` field which can be used instead.

Users can replicate the behavior of `defaultAddonsToRemoves` by setting
`bootstrapSelfManagedAddons` to `false` and then adding platform addons that
they actually want as `aws.eks.Addon` resources.

TODO[pulumi/pulumi-aws#5525]
See the upgrade guide for more details.

- "aws:eks/cluster:Cluster":
    - `🟡` inputs: "defaultAddonsToRemoves" missing
    - properties:
        - `🟡` "certificateAuthority" type changed from "#/types/aws:eks/ClusterCertificateAuthority:ClusterCertificateAuthority" to "array":
            - `🟡` items had no type but now has &{Type: Ref:#/types/aws:eks/ClusterCertificateAuthority:ClusterCertificateAuthority AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
        - `🟡` "defaultAddonsToRemoves" missing output "defaultAddonsToRemoves"

#### ECR GetCredentials function

The `ecr.getCredentials` function was added to address a functionality that did
not exist in the upstream provider. The upstream Terraform provider now has a
`aws.ecr.getAuthorizationToken` function that should be used instead.

TODO[pulumi/pulumi-aws#5526
See the upgrade guide for more information.

- `🔴` "aws:ecr/getCredentials:getCredentials" missing

### Deprecated in v6 removed in v7

The following properties were deprecated in v6 and are removed in v7

#### ApiGateway

`aws_apigateway_deployment` - Remove stage_name, stage_description, canary_settings attributes [#39958](https://github.com/hashicorp/terraform-provider-aws/issues/39958)
TODO[pulumi/pulumi-aws#5516]
See the migration guide for more information.

- "aws:apigateway/deployment:Deployment":
    - inputs:
        - `🟡` "canarySettings" missing
        - `🟡` "stageDescription" missing
        - `🟡` "stageName" missing
    - properties:
        - `🟡` "canarySettings" missing output "canarySettings"
        - `🟡` "executionArn" missing output "executionArn"
        - `🟡` "invokeUrl" missing output "invokeUrl"
        - `🟡` "stageDescription" missing output "stageDescription"
        - `🟡` "stageName" missing output "stageName"

#### aws batch [#40751](https://github.com/hashicorp/terraform-provider-aws/pull/40751)/[#37943](https://github.com/hashicorp/terraform-provider-aws/issues/37943)


- "aws:batch/computeEnvironment:ComputeEnvironment":
    - inputs:
        - `🟡` "computeEnvironmentName" missing
        - `🟡` "computeEnvironmentNamePrefix" missing
    - properties:
        - `🟡` "computeEnvironmentName" missing output "computeEnvironmentName"
        - `🟡` "computeEnvironmentNamePrefix" missing output "computeEnvironmentNamePrefix"
- "aws:batch/getComputeEnvironment:getComputeEnvironment": inputs:
    - `🟡` "computeEnvironmentName" missing input "computeEnvironmentName"
    - `🟢` required: "name" input has changed to Required
- "aws:batch/jobQueue:JobQueue":
    - `🟡` inputs: "computeEnvironments" missing
    - `🟡` properties: "computeEnvironments" missing output "computeEnvironments"

#### Others

##### Resource Properties

- "aws:directconnect/gatewayAssociation:GatewayAssociation":
    - `🟡` inputs: "vpnGatewayId" missing
    - `🟡` properties: "vpnGatewayId" missing output "vpnGatewayId"
- "aws:dms/endpoint:Endpoint":
    - `🟡` inputs: "s3Settings" missing
    - `🟡` properties: "s3Settings" missing output "s3Settings"
- "aws:ec2/eip:Eip":
    - `🟡` inputs: "vpc" missing
    - `🟡` properties: "vpc" missing output "vpc"
- "aws:ec2/flowLog:FlowLog":
    - `🟡` inputs: "logGroupName" missing
    - `🟡` properties: "logGroupName" missing output "logGroupName"
- "aws:ec2/instance:Instance":
    - inputs:
        - `🟡` "cpuCoreCount" missing
        - `🟡` "cpuThreadsPerCore" missing
    - properties:
        - `🟡` "cpuCoreCount" missing output "cpuCoreCount"
        - `🟡` "cpuThreadsPerCore" missing output "cpuThreadsPerCore"
    - `🟢` required: "userData" property is no longer Required
- "aws:ec2/launchTemplate:LaunchTemplate":
    - inputs:
        - `🟡` "elasticGpuSpecifications" missing
        - `🟡` "elasticInferenceAccelerator" missing
    - properties:
        - `🟡` "elasticGpuSpecifications" missing output "elasticGpuSpecifications"
        - `🟡` "elasticInferenceAccelerator" missing output "elasticInferenceAccelerator"
- "aws:ec2/spotInstanceRequest:SpotInstanceRequest":
    - inputs:
        - `🟡` "blockDurationMinutes" missing
        - `🟡` "cpuCoreCount" missing
        - `🟡` "cpuThreadsPerCore" missing
    - properties:
        - `🟡` "blockDurationMinutes" missing output "blockDurationMinutes"
        - `🟡` "cpuCoreCount" missing output "cpuCoreCount"
        - `🟡` "cpuThreadsPerCore" missing output "cpuThreadsPerCore"
    - `🟢` required: "userData" property is no longer Required
- "aws:ecs/taskDefinition:TaskDefinition":
    - `🟡` inputs: "inferenceAccelerators" missing
    - `🟡` properties: "inferenceAccelerators" missing output "inferenceAccelerators"
- "aws:eks/addon:Addon":
    - `🟡` inputs: "resolveConflicts" missing
    - `🟡` properties: "resolveConflicts" missing output "resolveConflicts"
- "aws:guardduty/organizationConfiguration:OrganizationConfiguration":
    - `🟡` inputs: "autoEnable" missing
    - `🟡` properties: "autoEnable" missing output "autoEnable"
    - `🟢` required inputs: "autoEnableOrganizationMembers" input has changed to Required
- "aws:lex/v2modelsSlotType:V2modelsSlotType":
    - inputs:
        - `🟡` "compositeSlotTypeSetting" missing
        - `🟡` "externalSourceSetting" missing
        - `🟡` "slotTypeValues" type changed from "#/types/aws:lex/V2modelsSlotTypeSlotTypeValues:V2modelsSlotTypeSlotTypeValues" to "array":
            - `🟡` items had no type but now has &{Type: Ref:#/types/aws:lex/V2modelsSlotTypeSlotTypeValue:V2modelsSlotTypeSlotTypeValue AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
    - properties:
        - `🟡` "compositeSlotTypeSetting" missing output "compositeSlotTypeSetting"
        - `🟡` "externalSourceSetting" missing output "externalSourceSetting"
        - `🟡` "slotTypeValues" type changed from "#/types/aws:lex/V2modelsSlotTypeSlotTypeValues:V2modelsSlotTypeSlotTypeValues" to "array":
            - `🟡` items had no type but now has &{Type: Ref:#/types/aws:lex/V2modelsSlotTypeSlotTypeValue:V2modelsSlotTypeSlotTypeValue AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
- "aws:networkmanager/coreNetwork:CoreNetwork":
    - `🟡` inputs: "basePolicyRegion" missing
    - `🟡` properties: "basePolicyRegion" missing output "basePolicyRegion"
- `🟡` "aws:opensearch/domain:Domain": properties: "kibanaEndpoint" missing output "kibanaEndpoint"
- "aws:paymentcryptography/key:Key":
    - `🟡` inputs: "keyAttributes" type changed from "#/types/aws:paymentcryptography/KeyKeyAttributes:KeyKeyAttributes" to "array":
        - `🟡` items had no type but now has &{Type: Ref:#/types/aws:paymentcryptography/KeyKeyAttribute:KeyKeyAttribute AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
    - `🟡` properties: "keyAttributes" type changed from "#/types/aws:paymentcryptography/KeyKeyAttributes:KeyKeyAttributes" to "array":
        - `🟡` items had no type but now has &{Type: Ref:#/types/aws:paymentcryptography/KeyKeyAttribute:KeyKeyAttribute AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
- "aws:s3/bucket:Bucket":
    - inputs:
        - `🟡` "arn" missing
        - `🟡` "hostedZoneId" missing
        - `🟡` "loggings" missing
        - `🟡` "websiteDomain" missing
        - `🟡` "websiteEndpoint" missing
    - `🟡` properties: "loggings" missing output "loggings"
- "aws:sagemaker/notebookInstance:NotebookInstance":
    - `🟡` inputs: "acceleratorTypes" missing
    - `🟡` properties: "acceleratorTypes" missing output "acceleratorTypes"
- "aws:securitylake/subscriber:Subscriber":
    - `🟡` inputs: "source" missing
    - `🟡` properties: "source" missing output "source"
- "aws:ssm/association:Association":
    - `🟡` inputs: "instanceId" missing
    - `🟡` properties: "instanceId" missing output "instanceId"

##### Function properties

- `🟡` "aws:identitystore/getGroup:getGroup": inputs: "filter" missing input "filter"
- `🟡` "aws:identitystore/getUser:getUser": inputs: "filter" missing input "filter"
- `🟡` "aws:opensearch/getServerlessSecurityConfig:getServerlessSecurityConfig": inputs: "samlOptions" type changed from "#/types/aws:opensearch/getServerlessSecurityConfigSamlOptions:getServerlessSecurityConfigSamlOptions" to "array":
    - `🟡` items had no type but now has &{Type: Ref:#/types/aws:opensearch/getServerlessSecurityConfigSamlOption:getServerlessSecurityConfigSamlOption AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
- `🟡` "aws:quicksight/getDataSet:getDataSet": inputs: "tagsAll" missing input "tagsAll"
- `🟡` "aws:servicediscovery/getService:getService": inputs: "tagsAll" missing input "tagsAll"

##### Functions

- `🔴` "aws:ec2/getVpcIamPool:getVpcIamPool" missing
- `🔴` "aws:ec2/getVpcIamPoolCidrs:getVpcIamPoolCidrs" missing
- `🔴` "aws:ec2/getVpcIamPools:getVpcIamPools" missing
- `🔴` "aws:quicksight/getAnalysis:getAnalysis" missing
- `🔴` "aws:redshift/getServiceAccount:getServiceAccount" missing
- `🔴` "aws:vpc/getVpcEndpointAssociations:getVpcEndpointAssociations" missing

##### Types

- `🔴` "aws:redshift/ClusterLogging:ClusterLogging" missing
- `🔴` "aws:gamelift/MatchmakingConfigurationGameProperty:MatchmakingConfigurationGameProperty" missing
- `🔴` "aws:dms/EndpointS3Settings:EndpointS3Settings" missing
- `🔴` "aws:ec2/LaunchTemplateElasticGpuSpecification:LaunchTemplateElasticGpuSpecification" missing
- `🔴` "aws:ec2/LaunchTemplateElasticInferenceAccelerator:LaunchTemplateElasticInferenceAccelerator" missing
- `🔴` "aws:ec2/getLaunchTemplateElasticGpuSpecification:getLaunchTemplateElasticGpuSpecification" missing
- `🔴` "aws:ec2/getLaunchTemplateElasticInferenceAccelerator:getLaunchTemplateElasticInferenceAccelerator" missing

### MaxItemsOne Type Change

- Some are due to [Disallow use of SingleNestedBlock](https://github.com/hashicorp/terraform-provider-aws/issues/35813)

- `🟡` "aws:batch/JobDefinitionEksPropertiesPodProperties:JobDefinitionEksPropertiesPodProperties": properties: "containers" type changed from "#/types/aws:batch/JobDefinitionEksPropertiesPodPropertiesContainers:JobDefinitionEksPropertiesPodPropertiesContainers" to "array":
    - `🟡` items had no type but now has &{Type: Ref:#/types/aws:batch/JobDefinitionEksPropertiesPodPropertiesContainer:JobDefinitionEksPropertiesPodPropertiesContainer AdditionalProperties:<nil> Items:<nil> OneOf:[] Discriminator:<nil> Plain:false}
- `🔴` "aws:batch/JobDefinitionEksPropertiesPodPropertiesContainers:JobDefinitionEksPropertiesPodPropertiesContainers" missing
- `🔴` "aws:batch/JobDefinitionEksPropertiesPodPropertiesContainersEnv:JobDefinitionEksPropertiesPodPropertiesContainersEnv" missing
- `🔴` "aws:batch/JobDefinitionEksPropertiesPodPropertiesContainersResources:JobDefinitionEksPropertiesPodPropertiesContainersResources" missing
- `🔴` "aws:batch/JobDefinitionEksPropertiesPodPropertiesContainersSecurityContext:JobDefinitionEksPropertiesPodPropertiesContainersSecurityContext" missing
- `🔴` "aws:batch/JobDefinitionEksPropertiesPodPropertiesContainersVolumeMount:JobDefinitionEksPropertiesPodPropertiesContainersVolumeMount" missing
- `🔴` "aws:identitystore/getGroupFilter:getGroupFilter" missing
- `🔴` "aws:identitystore/getUserFilter:getUserFilter" missing
- "aws:lb/getListenerRuleAction:getListenerRuleAction": properties:
    - `🟡` "authenticateCognito" missing
    - `🟡` "authenticateOidc" missing
    - `🟡` "fixedResponse" missing
    - `🟡` "forward" missing
    - `🟡` "redirect" missing
- `🟡` "aws:lb/getListenerRuleActionForward:getListenerRuleActionForward": properties: "stickiness" missing
- "aws:lb/getListenerRuleCondition:getListenerRuleCondition": properties:
    - `🟡` "hostHeader" missing
    - `🟡` "httpHeader" missing
    - `🟡` "httpRequestMethod" missing
    - `🟡` "pathPattern" missing
    - `🟡` "queryString" missing
    - `🟡` "sourceIp" missing
- `🟡` "aws:lex/V2modelsSlotTypeExternalSourceSetting:V2modelsSlotTypeExternalSourceSetting": properties: "grammarSlotTypeSetting" missing
- `🟡` "aws:lex/V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSetting:V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSetting": properties: "source" missing
- `🔴` "aws:lex/V2modelsSlotTypeSlotTypeValues:V2modelsSlotTypeSlotTypeValues" missing
- `🔴` "aws:lex/V2modelsSlotTypeSlotTypeValuesSampleValue:V2modelsSlotTypeSlotTypeValuesSampleValue" missing
- `🔴` "aws:lex/V2modelsSlotTypeSlotTypeValuesSynonym:V2modelsSlotTypeSlotTypeValuesSynonym" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupMessage:V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupMessage": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariation:V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariation": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupVariation:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupVariation": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessage:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessage": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupVariation:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupVariation": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessage:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessage": properties: "customPayloads" missing
- `🟡` "aws:lex/V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupVariation:V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupVariation": properties: "customPayloads" missing
- `🔴` "aws:opensearch/getServerlessSecurityConfigSamlOptions:getServerlessSecurityConfigSamlOptions" missing
- `🔴` "aws:paymentcryptography/KeyKeyAttributes:KeyKeyAttributes" missing
- `🔴` "aws:paymentcryptography/KeyKeyAttributesKeyModesOfUse:KeyKeyAttributesKeyModesOfUse" missing
- `🔴` "aws:quicksight/getAnalysisPermission:getAnalysisPermission" missing
- `🔴` "aws:redshift/ClusterSnapshotCopy:ClusterSnapshotCopy" missing
- `🟢` "aws:rekognition/StreamProcessorRegionsOfInterest:StreamProcessorRegionsOfInterest": required: "boundingBox" property has changed to Required
- "aws:sagemaker/AppImageConfigKernelGatewayImageConfig:AppImageConfigKernelGatewayImageConfig":
    - `🟡` properties: "kernelSpec" missing
    - required:
        - `🟢` "kernelSpec" property is no longer Required
        - `🟢` "kernelSpecs" property has changed to Required
- "aws:wafv2/WebAclAssociationConfigRequestBody:WebAclAssociationConfigRequestBody": properties:
    - `🟡` "apiGateways" missing
    - `🟡` "appRunnerServices" missing
    - `🟡` "cloudfronts" missing
    - `🟡` "cognitoUserPools" missing
    - `🟡` "verifiedAccessInstances" missing


