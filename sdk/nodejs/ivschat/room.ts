// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS IVS (Interactive Video) Chat Room.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ivschat.Room("example", {name: "tf-room"});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IVS (Interactive Video) Chat Room using the ARN. For example:
 *
 * ```sh
 * $ pulumi import aws:ivschat/room:Room example arn:aws:ivschat:us-west-2:326937407773:room/GoXEXyB4VwHb
 * ```
 */
export class Room extends pulumi.CustomResource {
    /**
     * Get an existing Room resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RoomState, opts?: pulumi.CustomResourceOptions): Room {
        return new Room(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ivschat/room:Room';

    /**
     * Returns true if the given object is an instance of Room.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Room {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Room.__pulumiType;
    }

    /**
     * ARN of the Room.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * List of Logging Configuration
     * ARNs to attach to the room.
     */
    public readonly loggingConfigurationIdentifiers!: pulumi.Output<string[] | undefined>;
    /**
     * Maximum number of characters in a single
     * message. Messages are expected to be UTF-8 encoded and this limit applies
     * specifically to rune/code-point count, not number of bytes.
     */
    public readonly maximumMessageLength!: pulumi.Output<number>;
    /**
     * Maximum number of messages per
     * second that can be sent to the room (by all clients).
     */
    public readonly maximumMessageRatePerSecond!: pulumi.Output<number>;
    /**
     * Configuration information for optional
     * review of messages.
     */
    public readonly messageReviewHandler!: pulumi.Output<outputs.ivschat.RoomMessageReviewHandler | undefined>;
    /**
     * Room name.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Room resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: RoomArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RoomArgs | RoomState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RoomState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["loggingConfigurationIdentifiers"] = state ? state.loggingConfigurationIdentifiers : undefined;
            resourceInputs["maximumMessageLength"] = state ? state.maximumMessageLength : undefined;
            resourceInputs["maximumMessageRatePerSecond"] = state ? state.maximumMessageRatePerSecond : undefined;
            resourceInputs["messageReviewHandler"] = state ? state.messageReviewHandler : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as RoomArgs | undefined;
            resourceInputs["loggingConfigurationIdentifiers"] = args ? args.loggingConfigurationIdentifiers : undefined;
            resourceInputs["maximumMessageLength"] = args ? args.maximumMessageLength : undefined;
            resourceInputs["maximumMessageRatePerSecond"] = args ? args.maximumMessageRatePerSecond : undefined;
            resourceInputs["messageReviewHandler"] = args ? args.messageReviewHandler : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Room.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Room resources.
 */
export interface RoomState {
    /**
     * ARN of the Room.
     */
    arn?: pulumi.Input<string>;
    /**
     * List of Logging Configuration
     * ARNs to attach to the room.
     */
    loggingConfigurationIdentifiers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Maximum number of characters in a single
     * message. Messages are expected to be UTF-8 encoded and this limit applies
     * specifically to rune/code-point count, not number of bytes.
     */
    maximumMessageLength?: pulumi.Input<number>;
    /**
     * Maximum number of messages per
     * second that can be sent to the room (by all clients).
     */
    maximumMessageRatePerSecond?: pulumi.Input<number>;
    /**
     * Configuration information for optional
     * review of messages.
     */
    messageReviewHandler?: pulumi.Input<inputs.ivschat.RoomMessageReviewHandler>;
    /**
     * Room name.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a Room resource.
 */
export interface RoomArgs {
    /**
     * List of Logging Configuration
     * ARNs to attach to the room.
     */
    loggingConfigurationIdentifiers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Maximum number of characters in a single
     * message. Messages are expected to be UTF-8 encoded and this limit applies
     * specifically to rune/code-point count, not number of bytes.
     */
    maximumMessageLength?: pulumi.Input<number>;
    /**
     * Maximum number of messages per
     * second that can be sent to the room (by all clients).
     */
    maximumMessageRatePerSecond?: pulumi.Input<number>;
    /**
     * Configuration information for optional
     * review of messages.
     */
    messageReviewHandler?: pulumi.Input<inputs.ivschat.RoomMessageReviewHandler>;
    /**
     * Room name.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
