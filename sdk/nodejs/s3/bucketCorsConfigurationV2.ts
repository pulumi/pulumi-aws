// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an S3 bucket CORS configuration resource. For more information about CORS, go to [Enabling Cross-Origin Resource Sharing](https://docs.aws.amazon.com/AmazonS3/latest/userguide/cors.html) in the Amazon S3 User Guide.
 *
 * > **NOTE:** S3 Buckets only support a single CORS configuration. Declaring multiple `aws.s3.BucketCorsConfigurationV2` resources to the same S3 Bucket will cause a perpetual difference in configuration.
 *
 * > This resource cannot be used with S3 directory buckets.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.s3.BucketV2("example", {bucket: "mybucket"});
 * const exampleBucketCorsConfigurationV2 = new aws.s3.BucketCorsConfigurationV2("example", {
 *     bucket: example.id,
 *     corsRules: [
 *         {
 *             allowedHeaders: ["*"],
 *             allowedMethods: [
 *                 "PUT",
 *                 "POST",
 *             ],
 *             allowedOrigins: ["https://s3-website-test.domain.example"],
 *             exposeHeaders: ["ETag"],
 *             maxAgeSeconds: 3000,
 *         },
 *         {
 *             allowedMethods: ["GET"],
 *             allowedOrigins: ["*"],
 *         },
 *     ],
 * });
 * ```
 *
 * ## Import
 *
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner` separated by a comma (`,`):
 *
 * __Using `pulumi import` to import__ S3 bucket CORS configuration using the `bucket` or using the `bucket` and `expected_bucket_owner` separated by a comma (`,`). For example:
 *
 * If the owner (account ID) of the source bucket is the same account used to configure the AWS Provider, import using the `bucket`:
 *
 * ```sh
 * $ pulumi import aws:s3/bucketCorsConfigurationV2:BucketCorsConfigurationV2 example bucket-name
 * ```
 * If the owner (account ID) of the source bucket differs from the account used to configure the AWS Provider, import using the `bucket` and `expected_bucket_owner` separated by a comma (`,`):
 *
 * ```sh
 * $ pulumi import aws:s3/bucketCorsConfigurationV2:BucketCorsConfigurationV2 example bucket-name,123456789012
 * ```
 */
export class BucketCorsConfigurationV2 extends pulumi.CustomResource {
    /**
     * Get an existing BucketCorsConfigurationV2 resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: BucketCorsConfigurationV2State, opts?: pulumi.CustomResourceOptions): BucketCorsConfigurationV2 {
        return new BucketCorsConfigurationV2(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:s3/bucketCorsConfigurationV2:BucketCorsConfigurationV2';

    /**
     * Returns true if the given object is an instance of BucketCorsConfigurationV2.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is BucketCorsConfigurationV2 {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === BucketCorsConfigurationV2.__pulumiType;
    }

    /**
     * Name of the bucket.
     */
    public readonly bucket!: pulumi.Output<string>;
    /**
     * Set of origins and methods (cross-origin access that you want to allow). See below. You can configure up to 100 rules.
     */
    public readonly corsRules!: pulumi.Output<outputs.s3.BucketCorsConfigurationV2CorsRule[]>;
    /**
     * Account ID of the expected bucket owner.
     */
    public readonly expectedBucketOwner!: pulumi.Output<string | undefined>;

    /**
     * Create a BucketCorsConfigurationV2 resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: BucketCorsConfigurationV2Args, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: BucketCorsConfigurationV2Args | BucketCorsConfigurationV2State, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as BucketCorsConfigurationV2State | undefined;
            resourceInputs["bucket"] = state ? state.bucket : undefined;
            resourceInputs["corsRules"] = state ? state.corsRules : undefined;
            resourceInputs["expectedBucketOwner"] = state ? state.expectedBucketOwner : undefined;
        } else {
            const args = argsOrState as BucketCorsConfigurationV2Args | undefined;
            if ((!args || args.bucket === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bucket'");
            }
            if ((!args || args.corsRules === undefined) && !opts.urn) {
                throw new Error("Missing required property 'corsRules'");
            }
            resourceInputs["bucket"] = args ? args.bucket : undefined;
            resourceInputs["corsRules"] = args ? args.corsRules : undefined;
            resourceInputs["expectedBucketOwner"] = args ? args.expectedBucketOwner : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(BucketCorsConfigurationV2.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering BucketCorsConfigurationV2 resources.
 */
export interface BucketCorsConfigurationV2State {
    /**
     * Name of the bucket.
     */
    bucket?: pulumi.Input<string>;
    /**
     * Set of origins and methods (cross-origin access that you want to allow). See below. You can configure up to 100 rules.
     */
    corsRules?: pulumi.Input<pulumi.Input<inputs.s3.BucketCorsConfigurationV2CorsRule>[]>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a BucketCorsConfigurationV2 resource.
 */
export interface BucketCorsConfigurationV2Args {
    /**
     * Name of the bucket.
     */
    bucket: pulumi.Input<string>;
    /**
     * Set of origins and methods (cross-origin access that you want to allow). See below. You can configure up to 100 rules.
     */
    corsRules: pulumi.Input<pulumi.Input<inputs.s3.BucketCorsConfigurationV2CorsRule>[]>;
    /**
     * Account ID of the expected bucket owner.
     */
    expectedBucketOwner?: pulumi.Input<string>;
}
