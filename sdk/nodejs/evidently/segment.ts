// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a CloudWatch Evidently Segment resource.
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Segment("example", {
 *     name: "example",
 *     pattern: "{\"Price\":[{\"numeric\":[\">\",10,\"<=\",20]}]}",
 *     tags: {
 *         Key1: "example Segment",
 *     },
 * });
 * ```
 *
 * ### With JSON object in pattern
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Segment("example", {
 *     name: "example",
 *     pattern: `  {
 *     "Price": [
 *       {
 *         "numeric": [">",10,"<=",20]
 *       }
 *     ]
 *   }
 * `,
 *     tags: {
 *         Key1: "example Segment",
 *     },
 * });
 * ```
 *
 * ### With Description
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Segment("example", {
 *     name: "example",
 *     pattern: "{\"Price\":[{\"numeric\":[\">\",10,\"<=\",20]}]}",
 *     description: "example",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Evidently Segment using the `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:evidently/segment:Segment example arn:aws:evidently:us-west-2:123456789012:segment/example
 * ```
 */
export class Segment extends pulumi.CustomResource {
    /**
     * Get an existing Segment resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SegmentState, opts?: pulumi.CustomResourceOptions): Segment {
        return new Segment(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:evidently/segment:Segment';

    /**
     * Returns true if the given object is an instance of Segment.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Segment {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Segment.__pulumiType;
    }

    /**
     * The ARN of the segment.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The date and time that the segment is created.
     */
    public /*out*/ readonly createdTime!: pulumi.Output<string>;
    /**
     * Specifies the description of the segment.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The number of experiments that this segment is used in. This count includes all current experiments, not just those that are currently running.
     */
    public /*out*/ readonly experimentCount!: pulumi.Output<number>;
    /**
     * The date and time that this segment was most recently updated.
     */
    public /*out*/ readonly lastUpdatedTime!: pulumi.Output<string>;
    /**
     * The number of launches that this segment is used in. This count includes all current launches, not just those that are currently running.
     */
    public /*out*/ readonly launchCount!: pulumi.Output<number>;
    /**
     * A name for the segment.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The pattern to use for the segment. For more information about pattern syntax, see [Segment rule pattern syntax](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Evidently-segments.html#CloudWatch-Evidently-segments-syntax.html).
     */
    public readonly pattern!: pulumi.Output<string>;
    /**
     * Tags to apply to the segment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Segment resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SegmentArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SegmentArgs | SegmentState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SegmentState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["createdTime"] = state ? state.createdTime : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["experimentCount"] = state ? state.experimentCount : undefined;
            resourceInputs["lastUpdatedTime"] = state ? state.lastUpdatedTime : undefined;
            resourceInputs["launchCount"] = state ? state.launchCount : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["pattern"] = state ? state.pattern : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as SegmentArgs | undefined;
            if ((!args || args.pattern === undefined) && !opts.urn) {
                throw new Error("Missing required property 'pattern'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["pattern"] = args ? args.pattern : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createdTime"] = undefined /*out*/;
            resourceInputs["experimentCount"] = undefined /*out*/;
            resourceInputs["lastUpdatedTime"] = undefined /*out*/;
            resourceInputs["launchCount"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Segment.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Segment resources.
 */
export interface SegmentState {
    /**
     * The ARN of the segment.
     */
    arn?: pulumi.Input<string>;
    /**
     * The date and time that the segment is created.
     */
    createdTime?: pulumi.Input<string>;
    /**
     * Specifies the description of the segment.
     */
    description?: pulumi.Input<string>;
    /**
     * The number of experiments that this segment is used in. This count includes all current experiments, not just those that are currently running.
     */
    experimentCount?: pulumi.Input<number>;
    /**
     * The date and time that this segment was most recently updated.
     */
    lastUpdatedTime?: pulumi.Input<string>;
    /**
     * The number of launches that this segment is used in. This count includes all current launches, not just those that are currently running.
     */
    launchCount?: pulumi.Input<number>;
    /**
     * A name for the segment.
     */
    name?: pulumi.Input<string>;
    /**
     * The pattern to use for the segment. For more information about pattern syntax, see [Segment rule pattern syntax](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Evidently-segments.html#CloudWatch-Evidently-segments-syntax.html).
     */
    pattern?: pulumi.Input<string>;
    /**
     * Tags to apply to the segment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a Segment resource.
 */
export interface SegmentArgs {
    /**
     * Specifies the description of the segment.
     */
    description?: pulumi.Input<string>;
    /**
     * A name for the segment.
     */
    name?: pulumi.Input<string>;
    /**
     * The pattern to use for the segment. For more information about pattern syntax, see [Segment rule pattern syntax](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Evidently-segments.html#CloudWatch-Evidently-segments-syntax.html).
     */
    pattern: pulumi.Input<string>;
    /**
     * Tags to apply to the segment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
