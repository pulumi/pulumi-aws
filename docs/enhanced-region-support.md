# Enhanced Region Support

Version 7.0.0 of the Pulumi AWS Provider adds `region` to most resources making it significantly easier to manage infrastructure across AWS Regions without requiring multiple provider configurations.

- [What's new](#whats-new)
- [What's not changing](#whats-not-changing)
- [Can I use `region` in every resource?](#can-i-use-region-in-every-resource)
- [Why make this change](#why-make-this-change)
- [How `region` works](#how-region-works)
- [Migrating from multiple provider configurations](#migrating-from-multiple-provider-configurations)
- [Before and after examples using `region`](#before-and-after-examples-using-region)
- [Non–region-aware resources](#non-region-aware-resources)


## What's new

As of v7.0.0, most existing resources and data sources are now [Region-aware](#nonregion-aware-resources), meaning they support a new top-level `region`. This allows you to manage a resource in a Region different from the one specified in the provider configuration without requiring multiple provider definitions. See [How `region` works](#how-region-works) for details.

For example, if your provider is configured for `us-east-1`, you can now manage a VPC in `us-west-2` without defining an additional provider:

```typescript
import * as aws from "@pulumi/aws";

const peer = new aws.ec2.Vpc("peer", {
    region: "us-west-2",
    cidrBlock: "10.1.0.0/16",
});
```

## What's _not_ changing

_Pre-v7.0.0 configurations that use provider configurations per Region remain valid in v7.0.0 and are not deprecated._

You can still define the Region at the provider level using any of the existing methods—for example, through the AWS [config file](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html), [provider configuration](https://www.pulumi.com/registry/packages/aws/installation-configuration/#configuration), [environment variables](https://www.pulumi.com/registry/packages/aws/installation-configuration/#set-credentials-as-environment-variables), [shared configuration files](https://www.pulumi.com/registry/packages/aws/installation-configuration/#create-a-shared-credentials-file), or explicitly using the `provider`'s [`region`](https://www.pulumi.com/registry/packages/aws/installation-configuration/#configuration-options).

## Can I use `region` in every resource?

No. While most resources are now Region-aware, there are exceptions. These include a few resources that already had a `region` and resources that are inherently global. See [Non–region-aware resources](#nonregion-aware-resources).

## Why make this change

Before version 7.0.0, managing infrastructure across multiple Regions required a separate provider configuration for each Region. This approach led to complex and repetitive configurations, especially for large infrastructures—AWS currently operates in [36 Regions](https://aws.amazon.com/about-aws/global-infrastructure/), with more announced. Additionally, each provider configuration adds overhead in terms of memory and compute resources.

See the [examples](#before-and-after-examples-using-region) below for a comparison of configurations before and after introducing `region`.

## How `region` works

The new top-level `region` is _Optional_, and defaults to the Region specified in the provider configuration. Its value is validated to ensure it belongs to the configured [partition](https://docs.aws.amazon.com/whitepapers/latest/aws-fault-isolation-boundaries/partitions.html). **Changing the value of `region` will force resource replacement.**

To [import](https://www.pulumi.com/docs/iac/adopting-pulumi/import/) a resource in a specific Region, append `@<region>` to the [import ID](https://www.pulumi.com/docs/iac/adopting-pulumi/import/#how-resource-import-works)—for example:

```sh
pulumi import aws:ec2/vpc:Vpc test_vpc vpc-a01106c2@eu-west-1
```

## Migrating from multiple provider configurations

To migrate from a separate provider configuration for each Region to a single provider configuration and per-resource `region` values you must ensure that Pulumi state is refreshed:

1. Upgrade to v7.0.0 following the upgrade guide.
2. Modify the affected resource configurations, replacing the [`provider` resource option](https://www.pulumi.com/docs/iac/concepts/options/provider/) with a `region` argument
3. Run Pulumi with refresh -- `pulumi up --refresh`

## Before and after examples using `region`

### Cross-region VPC peering

<details>
<summary>Before, Pre-v7.0.0</summary>
<p>

```typescript
import * as aws from "@pulumi/aws";

// Configure the default provider for us-east-1
const awsProvider = new aws.Provider("aws", {
    region: "us-east-1",
});

// Configure an additional provider for us-west-2
const awsPeerProvider = new aws.Provider("aws-peer", {
    region: "us-west-2",
});

const main = new aws.ec2.Vpc("main", {
    cidrBlock: "10.0.0.0/16",
}, { provider: awsProvider });

const peer = new aws.ec2.Vpc("peer", {
    cidrBlock: "10.1.0.0/16",
}, { provider: awsPeerProvider });

const peerIdentity = aws.getCallerIdentity({}, { provider: awsPeerProvider });

// Requester's side of the connection.
const peerConnection = new aws.ec2.VpcPeeringConnection("peer", {
    vpcId: main.id,
    peerVpcId: peer.id,
    peerOwnerId: peerIdentity.then(identity => identity.accountId),
    peerRegion: "us-west-2",
    autoAccept: false,
}, { provider: awsProvider });

// Accepter's side of the connection.
const peerAccepter = new aws.ec2.VpcPeeringConnectionAccepter("peer", {
    vpcPeeringConnectionId: peerConnection.id,
    autoAccept: true,
}, { provider: awsPeerProvider });
```

</p>
</details>

<details>
<summary>After, v7.0.0+</summary>
<p>

```typescript
import * as aws from "@pulumi/aws";

// Configure the provider for us-east-1
const awsProvider = new aws.Provider("aws", {
    region: "us-east-1",
});

const main = new aws.ec2.Vpc("main", {
    cidrBlock: "10.0.0.0/16",
}, { provider: awsProvider });

const peer = new aws.ec2.Vpc("peer", {
    region: "us-west-2",
    cidrBlock: "10.1.0.0/16",
}, { provider: awsProvider });

// Requester's side of the connection.
const peerConnection = new aws.ec2.VpcPeeringConnection("peer", {
    vpcId: main.id,
    peerVpcId: peer.id,
    peerRegion: "us-west-2",
    autoAccept: false,
}, { provider: awsProvider });

// Accepter's side of the connection.
const peerAccepter = new aws.ec2.VpcPeeringConnectionAccepter("peer", {
    region: "us-west-2",
    vpcPeeringConnectionId: peerConnection.id,
    autoAccept: true,
}, { provider: awsProvider });
```

</p>
</details>

### KMS replica key

<details>
<summary>Before, Pre-v7.0.0</summary>
<p>

```typescript
import * as aws from "@pulumi/aws";

// Configure primary provider for us-east-1
const awsPrimaryProvider = new aws.Provider("aws-primary", {
    region: "us-east-1",
});

// Configure default provider for us-west-2
const awsProvider = new aws.Provider("aws", {
    region: "us-west-2",
});

const primary = new aws.kms.Key("primary", {
    description: "Multi-Region primary key",
    deletionWindowInDays: 30,
    multiRegion: true,
}, { provider: awsPrimaryProvider });

const replica = new aws.kms.ReplicaKey("replica", {
    description: "Multi-Region replica key",
    deletionWindowInDays: 7,
    primaryKeyArn: primary.arn,
}, { provider: awsProvider });
```

</p>
</details>

<details>
<summary>After, v7.0.0</summary>
<p>

```typescript

import * as aws from "@pulumi/aws";

// Configure provider for us-west-2
const awsProvider = new aws.Provider("aws", {
    region: "us-west-2",
});

const primary = new aws.kms.Key("primary", {
    region: "us-east-1",
    description: "Multi-Region primary key",
    deletionWindowInDays: 30,
    multiRegion: true,
}, { provider: awsProvider });

const replica = new aws.kms.ReplicaKey("replica", {
    description: "Multi-Region replica key",
    deletionWindowInDays: 7,
    primaryKeyArn: primary.arn,
}, { provider: awsProvider });
```

</p>
</details>

### S3 bucket replication configuration

<details>
<summary>Before, Pre-v7.0.0</summary>
<p>

```typescript
import * as aws from "@pulumi/aws";

// Configure default provider for eu-west-1
const awsProvider = new aws.Provider("aws", {
    region: "eu-west-1",
});

// Configure central provider for eu-central-1
const awsCentralProvider = new aws.Provider("aws-central", {
    region: "eu-central-1",
});

const assumeRoleDocument = aws.iam.getPolicyDocument({
    statements: [{
        effect: "Allow",
        principals: [{
            type: "Service",
            identifiers: ["s3.amazonaws.com"],
        }],
        actions: ["sts:AssumeRole"],
    }],
});

const replicationRole = new aws.iam.Role("replication", {
    assumeRolePolicy: assumeRoleDocument.then(doc => doc.json),
}, { provider: awsProvider });

const destination = new aws.s3.Bucket("destination", {
}, { provider: awsProvider });

const source = new aws.s3.Bucket("source", {
}, { provider: awsCentralProvider });

const replicationPolicyDocument = aws.iam.getPolicyDocument({
    statements: [
        {
            effect: "Allow",
            actions: [
                "s3:GetReplicationConfiguration",
                "s3:ListBucket",
            ],
            resources: [source.arn],
        },
        {
            effect: "Allow",
            actions: [
                "s3:GetObjectVersionForReplication",
                "s3:GetObjectVersionAcl",
                "s3:GetObjectVersionTagging",
            ],
            resources: [source.arn.apply(arn => `${arn}/*`)],
        },
        {
            effect: "Allow",
            actions: [
                "s3:ReplicateObject",
                "s3:ReplicateDelete",
                "s3:ReplicateTags",
            ],
            resources: [destination.arn.apply(arn => `${arn}/*`)],
        },
    ],
});

const replicationPolicy = new aws.iam.Policy("replication", {
    policy: replicationPolicyDocument.then(doc => doc.json),
}, { provider: awsProvider });

const replicationPolicyAttachment = new aws.iam.RolePolicyAttachment("replication", {
    role: replicationRole.name,
    policyArn: replicationPolicy.arn,
}, { provider: awsProvider });

const destinationVersioning = new aws.s3.BucketVersioningV2("destination", {
    bucket: destination.id,
    versioningConfiguration: {
        status: "Enabled",
    },
}, { provider: awsProvider });

const sourceBucketAcl = new aws.s3.BucketAclV2("source-bucket-acl", {
    bucket: source.id,
    acl: "private",
}, { provider: awsCentralProvider });

const sourceVersioning = new aws.s3.BucketVersioningV2("source", {
    bucket: source.id,
    versioningConfiguration: {
        status: "Enabled",
    },
}, { provider: awsCentralProvider });

const replication = new aws.s3.BucketReplicationConfig("replication", {
    // Must have bucket versioning enabled first
    dependsOn: [sourceVersioning],
    role: replicationRole.arn,
    bucket: source.id,
    rules: [{
        id: "examplerule",
        filter: {
            prefix: "example",
        },
        status: "Enabled",
        destination: {
            bucket: destination.arn,
            storageClass: "STANDARD",
        },
    }],
}, { provider: awsCentralProvider });
```

</p>
</details>

<details>
<summary>After, v7.0.0</summary>
<p>

```typescript
import * as aws from "@pulumi/aws";

// Configure provider for eu-west-1
const awsProvider = new aws.Provider("aws", {
    region: "eu-west-1",
});

const assumeRoleDocument = aws.iam.getPolicyDocument({
    statements: [{
        effect: "Allow",
        principals: [{
            type: "Service",
            identifiers: ["s3.amazonaws.com"],
        }],
        actions: ["sts:AssumeRole"],
    }],
});

const replicationRole = new aws.iam.Role("replication", {
    assumeRolePolicy: assumeRoleDocument.then(doc => doc.json),
}, { provider: awsProvider });

const destination = new aws.s3.Bucket("destination", {
}, { provider: awsProvider });

const source = new aws.s3.Bucket("source", {
    region: "eu-central-1",
}, { provider: awsProvider });

const replicationPolicyDocument = aws.iam.getPolicyDocument({
    statements: [
        {
            effect: "Allow",
            actions: [
                "s3:GetReplicationConfiguration",
                "s3:ListBucket",
            ],
            resources: [source.arn],
        },
        {
            effect: "Allow",
            actions: [
                "s3:GetObjectVersionForReplication",
                "s3:GetObjectVersionAcl",
                "s3:GetObjectVersionTagging",
            ],
            resources: [source.arn.apply(arn => `${arn}/*`)],
        },
        {
            effect: "Allow",
            actions: [
                "s3:ReplicateObject",
                "s3:ReplicateDelete",
                "s3:ReplicateTags",
            ],
            resources: [destination.arn.apply(arn => `${arn}/*`)],
        },
    ],
});

const replicationPolicy = new aws.iam.Policy("replication", {
    policy: replicationPolicyDocument.then(doc => doc.json),
}, { provider: awsProvider });

const replicationPolicyAttachment = new aws.iam.RolePolicyAttachment("replication", {
    role: replicationRole.name,
    policyArn: replicationPolicy.arn,
}, { provider: awsProvider });

const destinationVersioning = new aws.s3.BucketVersioning("destination", {
    bucket: destination.id,
    versioningConfiguration: {
        status: "Enabled",
    },
}, { provider: awsProvider });

const sourceBucketAcl = new aws.s3.BucketAcl("source-bucket-acl", {
    region: "eu-central-1",
    bucket: source.id,
    acl: "private",
}, { provider: awsProvider });

const sourceVersioning = new aws.s3.BucketVersioning("source", {
    region: "eu-central-1",
    bucket: source.id,
    versioningConfiguration: {
        status: "Enabled",
    },
}, { provider: awsProvider });

const replication = new aws.s3.BucketReplicationConfig("replication", {
    region: "eu-central-1",
    // Must have bucket versioning enabled first
    dependsOn: [sourceVersioning],
    role: replicationRole.arn,
    bucket: source.id,
    rules: [{
        id: "examplerule",
        filter: {
            prefix: "example",
        },
        status: "Enabled",
        destination: {
            bucket: destination.arn,
            storageClass: "STANDARD",
        },
    }],
}, { provider: awsProvider });
```

</p>
</details>

## Non-region-aware resources

This section lists resources that are not Region-aware--meaning `region` has not been added to them.

Some resources, such as [IAM and STS](https://docs.aws.amazon.com/IAM/latest/UserGuide/programming.html#IAMEndpoints) are [global](https://docs.aws.amazon.com/whitepapers/latest/aws-fault-isolation-boundaries/global-services.html) and exist in all Regions within a partition.

Other resources are not Region-aware because they already had a top-level `region`, are inherently global, or because adding `region` would not be appropriate for other reasons.

### Resources deprecating `region`

The following regional resources and data sources had a top-level `region` prior to version 7.0.0. It is now deprecated and will be replaced in a future version to support the new Region-aware behavior.

* `aws.cloudformation.StackSetInstance` resource
* `aws.config.AggregateAuthorization` resource
* `aws.directconnect.HostedConnection` resource
* `aws.getRegion` function
* `aws.s3.getBucket` function
* `aws.servicequotas.Template` resource
* `aws.servicequotas.getTemplates` function
* `aws.ssmincidents.ReplicationSet` resource and `aws.ssmincidents.getReplicationSet` function
* `aws.ec2.getVpcEndpointService` function
* `aws.ec2.getVpcPeeringConnection` function

### Global services

All resources for the following services are considered _global_:

* Account Management (`aws.organizations.*`)
* Billing (`aws.billing.*`)
* Billing and Cost Management Data Exports (`aws.bcmdataexports.*`)
* Budgets (`aws.budgets.*`)
* CloudFront (`aws.cloudfront.*` and `aws.cloudfrontkeyvaluestore.*`)
* Cost Explorer (`aws.ce.*`)
* Cost Optimization Hub (`aws.costoptimizationhub.*`)
* Cost and Usage Report (`aws.cur.*`)
* Global Accelerator (`aws.globalaccelerator.*`)
* IAM (`aws.iam.*`, `aws.rolesanywhere.*` and `aws.getCallerIdentity`)
* Network Manager (`aws.networkmanager.*`)
* Organizations (`aws.organizations.*`)
* Price List (`aws.pricing.*`)
* Route 53 (`aws.route53.*` and `aws.route53domains.*`)
* Route 53 ARC (`aws.route53recoverycontrolconfig.*` and `aws.route53recoveryreadiness.*`)
* Shield Advanced (`aws.shield.*`)
* User Notifications (`aws.notifications.*`)
* User Notifications Contacts (`aws.notificationscontacts.*`)
* WAF Classic (`aws.waf.*`)

### Global resources in regional services

Some regional services have a subset of resources that are global:

| Service | Type | Name |
|---|---|---|
| Backup | Resource | `aws.backup.GlobalSettings` |
| Chime SDK Voice | Resource | `aws.chimesdkvoice.GlobalSettings` |
| CloudTrail | Resource | `aws.cloudtrail.OrganizationDelegatedAdminAccount` |
| Direct Connect | Resource | `aws.directconnect.Gateway` |
| Direct Connect | Function | `aws.directconnect.getGateway` |
| EC2 | Resource | `aws.ec2.ImageBlockPublicAccess` |
| Firewall Manager | Resource | `aws.fms.AdminAccount` |
| IPAM | Resource | `aws.ec2.VpcIpamOrganizationAdminAccount` |
| QuickSight | Resource | `aws.quicksight.AccountSettings` |
| Resource Access Manager | Resource | `aws.ram.SharingWithOrganization` |
| S3 | Function | `aws.s3.getCanonicalUserId` |
| S3 | Resource | `aws.s3.AccountPublicAccessBlock` |
| S3 | Function | `aws.s3.getAccountPublicAccessBlock` |
| Service Catalog | Resource | `aws.servicecatalog.OrganizationsAccess` |

### Meta data sources

The `aws.getDefaultTags`, `aws.getPartition`, and `aws.getRegions` functions are effectively global.

`region` of the `aws.getArn` function stays as-is.

### Policy Document Data Sources

Some data sources convert data into JSON policy documents and are effectively global:

* `aws.cloudwatch.getLogDataProtectionPolicyDocument`
* `aws.ecr.getLifecyclePolicyDocument`
