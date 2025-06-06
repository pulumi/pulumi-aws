// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an S3 bucket Object Lock configuration resource. For more information about Object Locking, go to [Using S3 Object Lock](https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock.html) in the Amazon S3 User Guide.
 *
 * > This resource can be used enable Object Lock for **new** and **existing** buckets.
 *
 * > This resource cannot be used with S3 directory buckets.
 *
 * ## Example Usage
 *
 * ### Object Lock configuration for new or existing buckets
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.s3.BucketV2("example", {bucket: "mybucket"});
 * const exampleBucketVersioningV2 = new aws.s3.BucketVersioningV2("example", {
 *     bucket: example.id,
 *     versioningConfiguration: {
 *         status: "Enabled",
 *     },
 * });
 * const exampleBucketObjectLockConfigurationV2 = new aws.s3.BucketObjectLockConfigurationV2("example", {
 *     bucket: example.id,
 *     rule: {
 *         defaultRetention: {
 *             mode: "COMPLIANCE",
 *             days: 5,
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner`, separated by a comma (`,`). For example:
 *
 * __Using `pulumi import`__, import an S3 bucket Object Lock Configuration using one of two forms. If the owner (account ID) of the source bucket is the same account used to configure the AWS Provider, import using the `bucket`. For example:
 *
 * ```sh
 * $ pulumi import aws:s3/bucketObjectLockConfigurationV2:BucketObjectLockConfigurationV2 example bucket-name
 * ```
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner`, separated by a comma (`,`). For example:
 *
 * ```sh
 * $ pulumi import aws:s3/bucketObjectLockConfigurationV2:BucketObjectLockConfigurationV2 example bucket-name,123456789012
 * ```
 */
export class BucketObjectLockConfigurationV2 extends pulumi.CustomResource {
    /**
     * Get an existing BucketObjectLockConfigurationV2 resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: BucketObjectLockConfigurationV2State, opts?: pulumi.CustomResourceOptions): BucketObjectLockConfigurationV2 {
        return new BucketObjectLockConfigurationV2(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:s3/bucketObjectLockConfigurationV2:BucketObjectLockConfigurationV2';

    /**
     * Returns true if the given object is an instance of BucketObjectLockConfigurationV2.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is BucketObjectLockConfigurationV2 {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === BucketObjectLockConfigurationV2.__pulumiType;
    }

    /**
     * Name of the bucket.
     */
    public readonly bucket!: pulumi.Output<string>;
    /**
     * Account ID of the expected bucket owner.
     */
    public readonly expectedBucketOwner!: pulumi.Output<string | undefined>;
    /**
     * Indicates whether this bucket has an Object Lock configuration enabled. Defaults to `Enabled`. Valid values: `Enabled`.
     */
    public readonly objectLockEnabled!: pulumi.Output<string | undefined>;
    /**
     * Configuration block for specifying the Object Lock rule for the specified object. See below.
     */
    public readonly rule!: pulumi.Output<outputs.s3.BucketObjectLockConfigurationV2Rule | undefined>;
    /**
     * This argument is deprecated and no longer needed to enable Object Lock.
     * To enable Object Lock for an existing bucket, you must first enable versioning on the bucket and then enable Object Lock. For more details on versioning, see the `aws.s3.BucketVersioningV2` resource.
     */
    public readonly token!: pulumi.Output<string | undefined>;

    /**
     * Create a BucketObjectLockConfigurationV2 resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: BucketObjectLockConfigurationV2Args, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: BucketObjectLockConfigurationV2Args | BucketObjectLockConfigurationV2State, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as BucketObjectLockConfigurationV2State | undefined;
            resourceInputs["bucket"] = state ? state.bucket : undefined;
            resourceInputs["expectedBucketOwner"] = state ? state.expectedBucketOwner : undefined;
            resourceInputs["objectLockEnabled"] = state ? state.objectLockEnabled : undefined;
            resourceInputs["rule"] = state ? state.rule : undefined;
            resourceInputs["token"] = state ? state.token : undefined;
        } else {
            const args = argsOrState as BucketObjectLockConfigurationV2Args | undefined;
            if ((!args || args.bucket === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bucket'");
            }
            resourceInputs["bucket"] = args ? args.bucket : undefined;
            resourceInputs["expectedBucketOwner"] = args ? args.expectedBucketOwner : undefined;
            resourceInputs["objectLockEnabled"] = args ? args.objectLockEnabled : undefined;
            resourceInputs["rule"] = args ? args.rule : undefined;
            resourceInputs["token"] = args?.token ? pulumi.secret(args.token) : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        const secretOpts = { additionalSecretOutputs: ["token"] };
        opts = pulumi.mergeOptions(opts, secretOpts);
        super(BucketObjectLockConfigurationV2.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering BucketObjectLockConfigurationV2 resources.
 */
export interface BucketObjectLockConfigurationV2State {
    /**
     * Name of the bucket.
     */
    bucket?: pulumi.Input<string>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
    /**
     * Indicates whether this bucket has an Object Lock configuration enabled. Defaults to `Enabled`. Valid values: `Enabled`.
     */
    objectLockEnabled?: pulumi.Input<string>;
    /**
     * Configuration block for specifying the Object Lock rule for the specified object. See below.
     */
    rule?: pulumi.Input<inputs.s3.BucketObjectLockConfigurationV2Rule>;
    /**
     * This argument is deprecated and no longer needed to enable Object Lock.
     * To enable Object Lock for an existing bucket, you must first enable versioning on the bucket and then enable Object Lock. For more details on versioning, see the `aws.s3.BucketVersioningV2` resource.
     */
    token?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a BucketObjectLockConfigurationV2 resource.
 */
export interface BucketObjectLockConfigurationV2Args {
    /**
     * Name of the bucket.
     */
    bucket: pulumi.Input<string>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
    /**
     * Indicates whether this bucket has an Object Lock configuration enabled. Defaults to `Enabled`. Valid values: `Enabled`.
     */
    objectLockEnabled?: pulumi.Input<string>;
    /**
     * Configuration block for specifying the Object Lock rule for the specified object. See below.
     */
    rule?: pulumi.Input<inputs.s3.BucketObjectLockConfigurationV2Rule>;
    /**
     * This argument is deprecated and no longer needed to enable Object Lock.
     * To enable Object Lock for an existing bucket, you must first enable versioning on the bucket and then enable Object Lock. For more details on versioning, see the `aws.s3.BucketVersioningV2` resource.
     */
    token?: pulumi.Input<string>;
}
