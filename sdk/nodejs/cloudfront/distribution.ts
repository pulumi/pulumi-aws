// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Creates an Amazon CloudFront web distribution.
 *
 * For information about CloudFront distributions, see the [Amazon CloudFront Developer Guide](http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html). For specific information about creating CloudFront web distributions, see the [POST Distribution](https://docs.aws.amazon.com/cloudfront/latest/APIReference/API_CreateDistribution.html) page in the Amazon CloudFront API Reference.
 *
 * > **NOTE:** CloudFront distributions take about 15 minutes to reach a deployed state after creation or modification. During this time, deletes to resources will be blocked. If you need to delete a distribution that is enabled and you do not want to wait, you need to use the `retainOnDelete` flag.
 *
 * ## Example Usage
 *
 * ### S3 Origin
 *
 * The example below creates a CloudFront distribution with an S3 origin.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const b = new aws.s3.BucketV2("b", {
 *     bucket: "mybucket",
 *     tags: {
 *         Name: "My bucket",
 *     },
 * });
 * const bAcl = new aws.s3.BucketAclV2("b_acl", {
 *     bucket: b.id,
 *     acl: "private",
 * });
 * const s3OriginId = "myS3Origin";
 * const s3Distribution = new aws.cloudfront.Distribution("s3_distribution", {
 *     origins: [{
 *         domainName: b.bucketRegionalDomainName,
 *         originAccessControlId: _default.id,
 *         originId: s3OriginId,
 *     }],
 *     enabled: true,
 *     isIpv6Enabled: true,
 *     comment: "Some comment",
 *     defaultRootObject: "index.html",
 *     loggingConfig: {
 *         includeCookies: false,
 *         bucket: "mylogs.s3.amazonaws.com",
 *         prefix: "myprefix",
 *     },
 *     aliases: [
 *         "mysite.example.com",
 *         "yoursite.example.com",
 *     ],
 *     defaultCacheBehavior: {
 *         allowedMethods: [
 *             "DELETE",
 *             "GET",
 *             "HEAD",
 *             "OPTIONS",
 *             "PATCH",
 *             "POST",
 *             "PUT",
 *         ],
 *         cachedMethods: [
 *             "GET",
 *             "HEAD",
 *         ],
 *         targetOriginId: s3OriginId,
 *         forwardedValues: {
 *             queryString: false,
 *             cookies: {
 *                 forward: "none",
 *             },
 *         },
 *         viewerProtocolPolicy: "allow-all",
 *         minTtl: 0,
 *         defaultTtl: 3600,
 *         maxTtl: 86400,
 *     },
 *     orderedCacheBehaviors: [
 *         {
 *             pathPattern: "/content/immutable/*",
 *             allowedMethods: [
 *                 "GET",
 *                 "HEAD",
 *                 "OPTIONS",
 *             ],
 *             cachedMethods: [
 *                 "GET",
 *                 "HEAD",
 *                 "OPTIONS",
 *             ],
 *             targetOriginId: s3OriginId,
 *             forwardedValues: {
 *                 queryString: false,
 *                 headers: ["Origin"],
 *                 cookies: {
 *                     forward: "none",
 *                 },
 *             },
 *             minTtl: 0,
 *             defaultTtl: 86400,
 *             maxTtl: 31536000,
 *             compress: true,
 *             viewerProtocolPolicy: "redirect-to-https",
 *         },
 *         {
 *             pathPattern: "/content/*",
 *             allowedMethods: [
 *                 "GET",
 *                 "HEAD",
 *                 "OPTIONS",
 *             ],
 *             cachedMethods: [
 *                 "GET",
 *                 "HEAD",
 *             ],
 *             targetOriginId: s3OriginId,
 *             forwardedValues: {
 *                 queryString: false,
 *                 cookies: {
 *                     forward: "none",
 *                 },
 *             },
 *             minTtl: 0,
 *             defaultTtl: 3600,
 *             maxTtl: 86400,
 *             compress: true,
 *             viewerProtocolPolicy: "redirect-to-https",
 *         },
 *     ],
 *     priceClass: "PriceClass_200",
 *     restrictions: {
 *         geoRestriction: {
 *             restrictionType: "whitelist",
 *             locations: [
 *                 "US",
 *                 "CA",
 *                 "GB",
 *                 "DE",
 *             ],
 *         },
 *     },
 *     tags: {
 *         Environment: "production",
 *     },
 *     viewerCertificate: {
 *         cloudfrontDefaultCertificate: true,
 *     },
 * });
 * ```
 *
 * ### With Failover Routing
 *
 * The example below creates a CloudFront distribution with an origin group for failover routing.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3Distribution = new aws.cloudfront.Distribution("s3_distribution", {
 *     originGroups: [{
 *         originId: "groupS3",
 *         failoverCriteria: {
 *             statusCodes: [
 *                 403,
 *                 404,
 *                 500,
 *                 502,
 *             ],
 *         },
 *         members: [
 *             {
 *                 originId: "primaryS3",
 *             },
 *             {
 *                 originId: "failoverS3",
 *             },
 *         ],
 *     }],
 *     origins: [
 *         {
 *             domainName: primary.bucketRegionalDomainName,
 *             originId: "primaryS3",
 *             s3OriginConfig: {
 *                 originAccessIdentity: _default.cloudfrontAccessIdentityPath,
 *             },
 *         },
 *         {
 *             domainName: failover.bucketRegionalDomainName,
 *             originId: "failoverS3",
 *             s3OriginConfig: {
 *                 originAccessIdentity: _default.cloudfrontAccessIdentityPath,
 *             },
 *         },
 *     ],
 *     defaultCacheBehavior: {
 *         targetOriginId: "groupS3",
 *     },
 * });
 * ```
 *
 * ### With Managed Caching Policy
 *
 * The example below creates a CloudFront distribution with an [AWS managed caching policy](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/using-managed-cache-policies.html).
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3OriginId = "myS3Origin";
 * const s3Distribution = new aws.cloudfront.Distribution("s3_distribution", {
 *     origins: [{
 *         domainName: primary.bucketRegionalDomainName,
 *         originId: "myS3Origin",
 *         s3OriginConfig: {
 *             originAccessIdentity: _default.cloudfrontAccessIdentityPath,
 *         },
 *     }],
 *     enabled: true,
 *     isIpv6Enabled: true,
 *     comment: "Some comment",
 *     defaultRootObject: "index.html",
 *     defaultCacheBehavior: {
 *         cachePolicyId: "4135ea2d-6df8-44a3-9df3-4b5a84be39ad",
 *         allowedMethods: [
 *             "GET",
 *             "HEAD",
 *             "OPTIONS",
 *         ],
 *         targetOriginId: s3OriginId,
 *     },
 *     restrictions: {
 *         geoRestriction: {
 *             restrictionType: "whitelist",
 *             locations: [
 *                 "US",
 *                 "CA",
 *                 "GB",
 *                 "DE",
 *             ],
 *         },
 *     },
 *     viewerCertificate: {
 *         cloudfrontDefaultCertificate: true,
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudFront Distributions using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:cloudfront/distribution:Distribution distribution E74FTE3EXAMPLE
 * ```
 */
export class Distribution extends pulumi.CustomResource {
    /**
     * Get an existing Distribution resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DistributionState, opts?: pulumi.CustomResourceOptions): Distribution {
        return new Distribution(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cloudfront/distribution:Distribution';

    /**
     * Returns true if the given object is an instance of Distribution.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Distribution {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Distribution.__pulumiType;
    }

    public readonly aliases!: pulumi.Output<string[] | undefined>;
    /**
     * ARN for the distribution. For example: `arn:aws:cloudfront::123456789012:distribution/EDFDVBD632BHDS5`, where `123456789012` is your AWS account ID.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Internal value used by CloudFront to allow future updates to the distribution configuration.
     */
    public /*out*/ readonly callerReference!: pulumi.Output<string>;
    public readonly comment!: pulumi.Output<string | undefined>;
    public readonly continuousDeploymentPolicyId!: pulumi.Output<string>;
    public readonly customErrorResponses!: pulumi.Output<outputs.cloudfront.DistributionCustomErrorResponse[] | undefined>;
    public readonly defaultCacheBehavior!: pulumi.Output<outputs.cloudfront.DistributionDefaultCacheBehavior>;
    public readonly defaultRootObject!: pulumi.Output<string | undefined>;
    /**
     * Domain name corresponding to the distribution. For example: `d604721fxaaqy9.cloudfront.net`.
     */
    public /*out*/ readonly domainName!: pulumi.Output<string>;
    /**
     * `true` if any of the AWS accounts listed as trusted signers have active CloudFront key pairs
     */
    public readonly enabled!: pulumi.Output<boolean>;
    /**
     * Current version of the distribution's information. For example: `E2QWRUHAPOMQZL`.
     */
    public /*out*/ readonly etag!: pulumi.Output<string>;
    /**
     * CloudFront Route 53 zone ID that can be used to route an [Alias Resource Record Set](http://docs.aws.amazon.com/Route53/latest/APIReference/CreateAliasRRSAPI.html) to. This attribute is simply an alias for the zone ID `Z2FDTNDATAQYW2`.
     */
    public /*out*/ readonly hostedZoneId!: pulumi.Output<string>;
    public readonly httpVersion!: pulumi.Output<string | undefined>;
    /**
     * Number of invalidation batches currently in progress.
     */
    public /*out*/ readonly inProgressValidationBatches!: pulumi.Output<number>;
    public readonly isIpv6Enabled!: pulumi.Output<boolean | undefined>;
    /**
     * Date and time the distribution was last modified.
     */
    public /*out*/ readonly lastModifiedTime!: pulumi.Output<string>;
    public readonly loggingConfig!: pulumi.Output<outputs.cloudfront.DistributionLoggingConfig | undefined>;
    public readonly orderedCacheBehaviors!: pulumi.Output<outputs.cloudfront.DistributionOrderedCacheBehavior[] | undefined>;
    public readonly originGroups!: pulumi.Output<outputs.cloudfront.DistributionOriginGroup[] | undefined>;
    public readonly origins!: pulumi.Output<outputs.cloudfront.DistributionOrigin[]>;
    public readonly priceClass!: pulumi.Output<string | undefined>;
    public readonly restrictions!: pulumi.Output<outputs.cloudfront.DistributionRestrictions>;
    public readonly retainOnDelete!: pulumi.Output<boolean | undefined>;
    public readonly staging!: pulumi.Output<boolean | undefined>;
    /**
     * Current status of the distribution. `Deployed` if the distribution's information is fully propagated throughout the Amazon CloudFront system.
     */
    public /*out*/ readonly status!: pulumi.Output<string>;
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * List of nested attributes for active trusted key groups, if the distribution is set up to serve private content with signed URLs.
     */
    public /*out*/ readonly trustedKeyGroups!: pulumi.Output<outputs.cloudfront.DistributionTrustedKeyGroup[]>;
    /**
     * List of nested attributes for active trusted signers, if the distribution is set up to serve private content with signed URLs.
     */
    public /*out*/ readonly trustedSigners!: pulumi.Output<outputs.cloudfront.DistributionTrustedSigner[]>;
    public readonly viewerCertificate!: pulumi.Output<outputs.cloudfront.DistributionViewerCertificate>;
    public readonly waitForDeployment!: pulumi.Output<boolean | undefined>;
    public readonly webAclId!: pulumi.Output<string | undefined>;

    /**
     * Create a Distribution resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DistributionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DistributionArgs | DistributionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DistributionState | undefined;
            resourceInputs["aliases"] = state ? state.aliases : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["callerReference"] = state ? state.callerReference : undefined;
            resourceInputs["comment"] = state ? state.comment : undefined;
            resourceInputs["continuousDeploymentPolicyId"] = state ? state.continuousDeploymentPolicyId : undefined;
            resourceInputs["customErrorResponses"] = state ? state.customErrorResponses : undefined;
            resourceInputs["defaultCacheBehavior"] = state ? state.defaultCacheBehavior : undefined;
            resourceInputs["defaultRootObject"] = state ? state.defaultRootObject : undefined;
            resourceInputs["domainName"] = state ? state.domainName : undefined;
            resourceInputs["enabled"] = state ? state.enabled : undefined;
            resourceInputs["etag"] = state ? state.etag : undefined;
            resourceInputs["hostedZoneId"] = state ? state.hostedZoneId : undefined;
            resourceInputs["httpVersion"] = state ? state.httpVersion : undefined;
            resourceInputs["inProgressValidationBatches"] = state ? state.inProgressValidationBatches : undefined;
            resourceInputs["isIpv6Enabled"] = state ? state.isIpv6Enabled : undefined;
            resourceInputs["lastModifiedTime"] = state ? state.lastModifiedTime : undefined;
            resourceInputs["loggingConfig"] = state ? state.loggingConfig : undefined;
            resourceInputs["orderedCacheBehaviors"] = state ? state.orderedCacheBehaviors : undefined;
            resourceInputs["originGroups"] = state ? state.originGroups : undefined;
            resourceInputs["origins"] = state ? state.origins : undefined;
            resourceInputs["priceClass"] = state ? state.priceClass : undefined;
            resourceInputs["restrictions"] = state ? state.restrictions : undefined;
            resourceInputs["retainOnDelete"] = state ? state.retainOnDelete : undefined;
            resourceInputs["staging"] = state ? state.staging : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["trustedKeyGroups"] = state ? state.trustedKeyGroups : undefined;
            resourceInputs["trustedSigners"] = state ? state.trustedSigners : undefined;
            resourceInputs["viewerCertificate"] = state ? state.viewerCertificate : undefined;
            resourceInputs["waitForDeployment"] = state ? state.waitForDeployment : undefined;
            resourceInputs["webAclId"] = state ? state.webAclId : undefined;
        } else {
            const args = argsOrState as DistributionArgs | undefined;
            if ((!args || args.defaultCacheBehavior === undefined) && !opts.urn) {
                throw new Error("Missing required property 'defaultCacheBehavior'");
            }
            if ((!args || args.enabled === undefined) && !opts.urn) {
                throw new Error("Missing required property 'enabled'");
            }
            if ((!args || args.origins === undefined) && !opts.urn) {
                throw new Error("Missing required property 'origins'");
            }
            if ((!args || args.restrictions === undefined) && !opts.urn) {
                throw new Error("Missing required property 'restrictions'");
            }
            if ((!args || args.viewerCertificate === undefined) && !opts.urn) {
                throw new Error("Missing required property 'viewerCertificate'");
            }
            resourceInputs["aliases"] = args ? args.aliases : undefined;
            resourceInputs["comment"] = args ? args.comment : undefined;
            resourceInputs["continuousDeploymentPolicyId"] = args ? args.continuousDeploymentPolicyId : undefined;
            resourceInputs["customErrorResponses"] = args ? args.customErrorResponses : undefined;
            resourceInputs["defaultCacheBehavior"] = args ? args.defaultCacheBehavior : undefined;
            resourceInputs["defaultRootObject"] = args ? args.defaultRootObject : undefined;
            resourceInputs["enabled"] = args ? args.enabled : undefined;
            resourceInputs["httpVersion"] = args ? args.httpVersion : undefined;
            resourceInputs["isIpv6Enabled"] = args ? args.isIpv6Enabled : undefined;
            resourceInputs["loggingConfig"] = args ? args.loggingConfig : undefined;
            resourceInputs["orderedCacheBehaviors"] = args ? args.orderedCacheBehaviors : undefined;
            resourceInputs["originGroups"] = args ? args.originGroups : undefined;
            resourceInputs["origins"] = args ? args.origins : undefined;
            resourceInputs["priceClass"] = args ? args.priceClass : undefined;
            resourceInputs["restrictions"] = args ? args.restrictions : undefined;
            resourceInputs["retainOnDelete"] = args ? args.retainOnDelete : undefined;
            resourceInputs["staging"] = args ? args.staging : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["viewerCertificate"] = args ? args.viewerCertificate : undefined;
            resourceInputs["waitForDeployment"] = args ? args.waitForDeployment : undefined;
            resourceInputs["webAclId"] = args ? args.webAclId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["callerReference"] = undefined /*out*/;
            resourceInputs["domainName"] = undefined /*out*/;
            resourceInputs["etag"] = undefined /*out*/;
            resourceInputs["hostedZoneId"] = undefined /*out*/;
            resourceInputs["inProgressValidationBatches"] = undefined /*out*/;
            resourceInputs["lastModifiedTime"] = undefined /*out*/;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["trustedKeyGroups"] = undefined /*out*/;
            resourceInputs["trustedSigners"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Distribution.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Distribution resources.
 */
export interface DistributionState {
    aliases?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ARN for the distribution. For example: `arn:aws:cloudfront::123456789012:distribution/EDFDVBD632BHDS5`, where `123456789012` is your AWS account ID.
     */
    arn?: pulumi.Input<string>;
    /**
     * Internal value used by CloudFront to allow future updates to the distribution configuration.
     */
    callerReference?: pulumi.Input<string>;
    comment?: pulumi.Input<string>;
    continuousDeploymentPolicyId?: pulumi.Input<string>;
    customErrorResponses?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionCustomErrorResponse>[]>;
    defaultCacheBehavior?: pulumi.Input<inputs.cloudfront.DistributionDefaultCacheBehavior>;
    defaultRootObject?: pulumi.Input<string>;
    /**
     * Domain name corresponding to the distribution. For example: `d604721fxaaqy9.cloudfront.net`.
     */
    domainName?: pulumi.Input<string>;
    /**
     * `true` if any of the AWS accounts listed as trusted signers have active CloudFront key pairs
     */
    enabled?: pulumi.Input<boolean>;
    /**
     * Current version of the distribution's information. For example: `E2QWRUHAPOMQZL`.
     */
    etag?: pulumi.Input<string>;
    /**
     * CloudFront Route 53 zone ID that can be used to route an [Alias Resource Record Set](http://docs.aws.amazon.com/Route53/latest/APIReference/CreateAliasRRSAPI.html) to. This attribute is simply an alias for the zone ID `Z2FDTNDATAQYW2`.
     */
    hostedZoneId?: pulumi.Input<string>;
    httpVersion?: pulumi.Input<string>;
    /**
     * Number of invalidation batches currently in progress.
     */
    inProgressValidationBatches?: pulumi.Input<number>;
    isIpv6Enabled?: pulumi.Input<boolean>;
    /**
     * Date and time the distribution was last modified.
     */
    lastModifiedTime?: pulumi.Input<string>;
    loggingConfig?: pulumi.Input<inputs.cloudfront.DistributionLoggingConfig>;
    orderedCacheBehaviors?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOrderedCacheBehavior>[]>;
    originGroups?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOriginGroup>[]>;
    origins?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOrigin>[]>;
    priceClass?: pulumi.Input<string>;
    restrictions?: pulumi.Input<inputs.cloudfront.DistributionRestrictions>;
    retainOnDelete?: pulumi.Input<boolean>;
    staging?: pulumi.Input<boolean>;
    /**
     * Current status of the distribution. `Deployed` if the distribution's information is fully propagated throughout the Amazon CloudFront system.
     */
    status?: pulumi.Input<string>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * List of nested attributes for active trusted key groups, if the distribution is set up to serve private content with signed URLs.
     */
    trustedKeyGroups?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionTrustedKeyGroup>[]>;
    /**
     * List of nested attributes for active trusted signers, if the distribution is set up to serve private content with signed URLs.
     */
    trustedSigners?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionTrustedSigner>[]>;
    viewerCertificate?: pulumi.Input<inputs.cloudfront.DistributionViewerCertificate>;
    waitForDeployment?: pulumi.Input<boolean>;
    webAclId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Distribution resource.
 */
export interface DistributionArgs {
    aliases?: pulumi.Input<pulumi.Input<string>[]>;
    comment?: pulumi.Input<string>;
    continuousDeploymentPolicyId?: pulumi.Input<string>;
    customErrorResponses?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionCustomErrorResponse>[]>;
    defaultCacheBehavior: pulumi.Input<inputs.cloudfront.DistributionDefaultCacheBehavior>;
    defaultRootObject?: pulumi.Input<string>;
    /**
     * `true` if any of the AWS accounts listed as trusted signers have active CloudFront key pairs
     */
    enabled: pulumi.Input<boolean>;
    httpVersion?: pulumi.Input<string>;
    isIpv6Enabled?: pulumi.Input<boolean>;
    loggingConfig?: pulumi.Input<inputs.cloudfront.DistributionLoggingConfig>;
    orderedCacheBehaviors?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOrderedCacheBehavior>[]>;
    originGroups?: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOriginGroup>[]>;
    origins: pulumi.Input<pulumi.Input<inputs.cloudfront.DistributionOrigin>[]>;
    priceClass?: pulumi.Input<string>;
    restrictions: pulumi.Input<inputs.cloudfront.DistributionRestrictions>;
    retainOnDelete?: pulumi.Input<boolean>;
    staging?: pulumi.Input<boolean>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    viewerCertificate: pulumi.Input<inputs.cloudfront.DistributionViewerCertificate>;
    waitForDeployment?: pulumi.Input<boolean>;
    webAclId?: pulumi.Input<string>;
}
