// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an AWS Elemental MediaPackage Channel.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const kittens = new aws.mediapackage.Channel("kittens", {
 *     channelId: "kitten-channel",
 *     description: "A channel dedicated to amusing videos of kittens.",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Media Package Channels using the channel ID. For example:
 *
 * ```sh
 * $ pulumi import aws:mediapackage/channel:Channel kittens kittens-channel
 * ```
 */
export class Channel extends pulumi.CustomResource {
    /**
     * Get an existing Channel resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ChannelState, opts?: pulumi.CustomResourceOptions): Channel {
        return new Channel(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:mediapackage/channel:Channel';

    /**
     * Returns true if the given object is an instance of Channel.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Channel {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Channel.__pulumiType;
    }

    /**
     * The ARN of the channel
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A unique identifier describing the channel
     */
    public readonly channelId!: pulumi.Output<string>;
    /**
     * A description of the channel
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * A single item list of HLS ingest information
     */
    public /*out*/ readonly hlsIngests!: pulumi.Output<outputs.mediapackage.ChannelHlsIngest[]>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Channel resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ChannelArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ChannelArgs | ChannelState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ChannelState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["channelId"] = state ? state.channelId : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["hlsIngests"] = state ? state.hlsIngests : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ChannelArgs | undefined;
            if ((!args || args.channelId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'channelId'");
            }
            resourceInputs["channelId"] = args ? args.channelId : undefined;
            resourceInputs["description"] = (args ? args.description : undefined) ?? "Managed by Pulumi";
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["hlsIngests"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Channel.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Channel resources.
 */
export interface ChannelState {
    /**
     * The ARN of the channel
     */
    arn?: pulumi.Input<string>;
    /**
     * A unique identifier describing the channel
     */
    channelId?: pulumi.Input<string>;
    /**
     * A description of the channel
     */
    description?: pulumi.Input<string>;
    /**
     * A single item list of HLS ingest information
     */
    hlsIngests?: pulumi.Input<pulumi.Input<inputs.mediapackage.ChannelHlsIngest>[]>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a Channel resource.
 */
export interface ChannelArgs {
    /**
     * A unique identifier describing the channel
     */
    channelId: pulumi.Input<string>;
    /**
     * A description of the channel
     */
    description?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
