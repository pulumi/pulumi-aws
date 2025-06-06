// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * > **Note:** There is only a single subscription allowed per account.
 *
 * To help you understand the charges for your Spot instances, Amazon EC2 provides a data feed that describes your Spot instance usage and pricing.
 * This data feed is sent to an Amazon S3 bucket that you specify when you subscribe to the data feed.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = new aws.s3.BucketV2("default", {bucket: "tf-spot-datafeed"});
 * const defaultSpotDatafeedSubscription = new aws.ec2.SpotDatafeedSubscription("default", {
 *     bucket: _default.id,
 *     prefix: "my_subdirectory",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import a Spot Datafeed Subscription using the word `spot-datafeed-subscription`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/spotDatafeedSubscription:SpotDatafeedSubscription mysubscription spot-datafeed-subscription
 * ```
 */
export class SpotDatafeedSubscription extends pulumi.CustomResource {
    /**
     * Get an existing SpotDatafeedSubscription resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SpotDatafeedSubscriptionState, opts?: pulumi.CustomResourceOptions): SpotDatafeedSubscription {
        return new SpotDatafeedSubscription(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/spotDatafeedSubscription:SpotDatafeedSubscription';

    /**
     * Returns true if the given object is an instance of SpotDatafeedSubscription.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SpotDatafeedSubscription {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SpotDatafeedSubscription.__pulumiType;
    }

    /**
     * The Amazon S3 bucket in which to store the Spot instance data feed.
     */
    public readonly bucket!: pulumi.Output<string>;
    /**
     * Path of folder inside bucket to place spot pricing data.
     */
    public readonly prefix!: pulumi.Output<string | undefined>;

    /**
     * Create a SpotDatafeedSubscription resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SpotDatafeedSubscriptionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SpotDatafeedSubscriptionArgs | SpotDatafeedSubscriptionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SpotDatafeedSubscriptionState | undefined;
            resourceInputs["bucket"] = state ? state.bucket : undefined;
            resourceInputs["prefix"] = state ? state.prefix : undefined;
        } else {
            const args = argsOrState as SpotDatafeedSubscriptionArgs | undefined;
            if ((!args || args.bucket === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bucket'");
            }
            resourceInputs["bucket"] = args ? args.bucket : undefined;
            resourceInputs["prefix"] = args ? args.prefix : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SpotDatafeedSubscription.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SpotDatafeedSubscription resources.
 */
export interface SpotDatafeedSubscriptionState {
    /**
     * The Amazon S3 bucket in which to store the Spot instance data feed.
     */
    bucket?: pulumi.Input<string>;
    /**
     * Path of folder inside bucket to place spot pricing data.
     */
    prefix?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SpotDatafeedSubscription resource.
 */
export interface SpotDatafeedSubscriptionArgs {
    /**
     * The Amazon S3 bucket in which to store the Spot instance data feed.
     */
    bucket: pulumi.Input<string>;
    /**
     * Path of folder inside bucket to place spot pricing data.
     */
    prefix?: pulumi.Input<string>;
}
