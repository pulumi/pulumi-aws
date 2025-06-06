// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an S3 bucket request payment configuration resource. For more information, see [Requester Pays Buckets](https://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html).
 *
 * > **NOTE:** Destroying an `aws.s3.BucketRequestPaymentConfigurationV2` resource resets the bucket's `payer` to the S3 default: the bucket owner.
 *
 * > This resource cannot be used with S3 directory buckets.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.s3.BucketRequestPaymentConfigurationV2("example", {
 *     bucket: exampleAwsS3Bucket.id,
 *     payer: "Requester",
 * });
 * ```
 *
 * ## Import
 *
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner` separated by a comma (`,`):
 *
 * __Using `pulumi import` to import__ S3 bucket request payment configuration using the `bucket` or using the `bucket` and `expected_bucket_owner` separated by a comma (`,`). For example:
 *
 * If the owner (account ID) of the source bucket is the same account used to configure the AWS Provider, import using the `bucket`:
 *
 * ```sh
 * $ pulumi import aws:s3/bucketRequestPaymentConfigurationV2:BucketRequestPaymentConfigurationV2 example bucket-name
 * ```
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner` separated by a comma (`,`):
 *
 * ```sh
 * $ pulumi import aws:s3/bucketRequestPaymentConfigurationV2:BucketRequestPaymentConfigurationV2 example bucket-name,123456789012
 * ```
 */
export class BucketRequestPaymentConfigurationV2 extends pulumi.CustomResource {
    /**
     * Get an existing BucketRequestPaymentConfigurationV2 resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: BucketRequestPaymentConfigurationV2State, opts?: pulumi.CustomResourceOptions): BucketRequestPaymentConfigurationV2 {
        return new BucketRequestPaymentConfigurationV2(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:s3/bucketRequestPaymentConfigurationV2:BucketRequestPaymentConfigurationV2';

    /**
     * Returns true if the given object is an instance of BucketRequestPaymentConfigurationV2.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is BucketRequestPaymentConfigurationV2 {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === BucketRequestPaymentConfigurationV2.__pulumiType;
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
     * Specifies who pays for the download and request fees. Valid values: `BucketOwner`, `Requester`.
     */
    public readonly payer!: pulumi.Output<string>;

    /**
     * Create a BucketRequestPaymentConfigurationV2 resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: BucketRequestPaymentConfigurationV2Args, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: BucketRequestPaymentConfigurationV2Args | BucketRequestPaymentConfigurationV2State, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as BucketRequestPaymentConfigurationV2State | undefined;
            resourceInputs["bucket"] = state ? state.bucket : undefined;
            resourceInputs["expectedBucketOwner"] = state ? state.expectedBucketOwner : undefined;
            resourceInputs["payer"] = state ? state.payer : undefined;
        } else {
            const args = argsOrState as BucketRequestPaymentConfigurationV2Args | undefined;
            if ((!args || args.bucket === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bucket'");
            }
            if ((!args || args.payer === undefined) && !opts.urn) {
                throw new Error("Missing required property 'payer'");
            }
            resourceInputs["bucket"] = args ? args.bucket : undefined;
            resourceInputs["expectedBucketOwner"] = args ? args.expectedBucketOwner : undefined;
            resourceInputs["payer"] = args ? args.payer : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(BucketRequestPaymentConfigurationV2.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering BucketRequestPaymentConfigurationV2 resources.
 */
export interface BucketRequestPaymentConfigurationV2State {
    /**
     * Name of the bucket.
     */
    bucket?: pulumi.Input<string>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
    /**
     * Specifies who pays for the download and request fees. Valid values: `BucketOwner`, `Requester`.
     */
    payer?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a BucketRequestPaymentConfigurationV2 resource.
 */
export interface BucketRequestPaymentConfigurationV2Args {
    /**
     * Name of the bucket.
     */
    bucket: pulumi.Input<string>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
    /**
     * Specifies who pays for the download and request fees. Valid values: `BucketOwner`, `Requester`.
     */
    payer: pulumi.Input<string>;
}
