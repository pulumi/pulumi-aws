// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage an S3 Control Bucket Policy.
 *
 * > This functionality is for managing [S3 on Outposts](https://docs.aws.amazon.com/AmazonS3/latest/dev/S3onOutposts.html). To manage S3 Bucket Policies in an AWS Partition, see the `aws.s3.BucketPolicy` resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.s3control.BucketPolicy("example", {
 *     bucket: exampleAwsS3controlBucket.arn,
 *     policy: JSON.stringify({
 *         Id: "testBucketPolicy",
 *         Statement: [{
 *             Action: "s3-outposts:PutBucketLifecycleConfiguration",
 *             Effect: "Deny",
 *             Principal: {
 *                 AWS: "*",
 *             },
 *             Resource: exampleAwsS3controlBucket.arn,
 *             Sid: "statement1",
 *         }],
 *         Version: "2012-10-17",
 *     }),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import S3 Control Bucket Policies using the Amazon Resource Name (ARN). For example:
 *
 * ```sh
 * $ pulumi import aws:s3control/bucketPolicy:BucketPolicy example arn:aws:s3-outposts:us-east-1:123456789012:outpost/op-12345678/bucket/example
 * ```
 */
export class BucketPolicy extends pulumi.CustomResource {
    /**
     * Get an existing BucketPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: BucketPolicyState, opts?: pulumi.CustomResourceOptions): BucketPolicy {
        return new BucketPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:s3control/bucketPolicy:BucketPolicy';

    /**
     * Returns true if the given object is an instance of BucketPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is BucketPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === BucketPolicy.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of the bucket.
     */
    public readonly bucket!: pulumi.Output<string>;
    /**
     * JSON string of the resource policy.
     */
    public readonly policy!: pulumi.Output<string>;

    /**
     * Create a BucketPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: BucketPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: BucketPolicyArgs | BucketPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as BucketPolicyState | undefined;
            resourceInputs["bucket"] = state ? state.bucket : undefined;
            resourceInputs["policy"] = state ? state.policy : undefined;
        } else {
            const args = argsOrState as BucketPolicyArgs | undefined;
            if ((!args || args.bucket === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bucket'");
            }
            if ((!args || args.policy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policy'");
            }
            resourceInputs["bucket"] = args ? args.bucket : undefined;
            resourceInputs["policy"] = args ? args.policy : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(BucketPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering BucketPolicy resources.
 */
export interface BucketPolicyState {
    /**
     * Amazon Resource Name (ARN) of the bucket.
     */
    bucket?: pulumi.Input<string>;
    /**
     * JSON string of the resource policy.
     */
    policy?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a BucketPolicy resource.
 */
export interface BucketPolicyArgs {
    /**
     * Amazon Resource Name (ARN) of the bucket.
     */
    bucket: pulumi.Input<string>;
    /**
     * JSON string of the resource policy.
     */
    policy: pulumi.Input<string>;
}
