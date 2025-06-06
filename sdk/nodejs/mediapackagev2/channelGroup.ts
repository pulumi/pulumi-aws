// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Creates an AWS Elemental MediaPackage Version 2 Channel Group.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.mediapackagev2.ChannelGroup("example", {
 *     name: "example",
 *     description: "channel group for example channels",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Elemental MediaPackage Version 2 Channel Group using the channel group's `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:mediapackagev2/channelGroup:ChannelGroup example example
 * ```
 */
export class ChannelGroup extends pulumi.CustomResource {
    /**
     * Get an existing ChannelGroup resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ChannelGroupState, opts?: pulumi.CustomResourceOptions): ChannelGroup {
        return new ChannelGroup(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:mediapackagev2/channelGroup:ChannelGroup';

    /**
     * Returns true if the given object is an instance of ChannelGroup.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ChannelGroup {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ChannelGroup.__pulumiType;
    }

    /**
     * The ARN of the channel
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A description of the channel group
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The egress domain of the channel group
     */
    public /*out*/ readonly egressDomain!: pulumi.Output<string>;
    /**
     * A unique identifier naming the channel group
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a ChannelGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: ChannelGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ChannelGroupArgs | ChannelGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ChannelGroupState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["egressDomain"] = state ? state.egressDomain : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ChannelGroupArgs | undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["egressDomain"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ChannelGroup.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ChannelGroup resources.
 */
export interface ChannelGroupState {
    /**
     * The ARN of the channel
     */
    arn?: pulumi.Input<string>;
    /**
     * A description of the channel group
     */
    description?: pulumi.Input<string>;
    /**
     * The egress domain of the channel group
     */
    egressDomain?: pulumi.Input<string>;
    /**
     * A unique identifier naming the channel group
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a ChannelGroup resource.
 */
export interface ChannelGroupArgs {
    /**
     * A description of the channel group
     */
    description?: pulumi.Input<string>;
    /**
     * A unique identifier naming the channel group
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
