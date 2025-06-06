// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Creates a peering connection between an AWS Cloud WAN core network and an AWS Transit Gateway.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.networkmanager.TransitGatewayPeering("example", {
 *     coreNetworkId: exampleAwsccNetworkmanagerCoreNetwork.id,
 *     transitGatewayArn: exampleAwsEc2TransitGateway.arn,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_networkmanager_transit_gateway_peering` using the peering ID. For example:
 *
 * ```sh
 * $ pulumi import aws:networkmanager/transitGatewayPeering:TransitGatewayPeering example peering-444555aaabbb11223
 * ```
 */
export class TransitGatewayPeering extends pulumi.CustomResource {
    /**
     * Get an existing TransitGatewayPeering resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: TransitGatewayPeeringState, opts?: pulumi.CustomResourceOptions): TransitGatewayPeering {
        return new TransitGatewayPeering(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:networkmanager/transitGatewayPeering:TransitGatewayPeering';

    /**
     * Returns true if the given object is an instance of TransitGatewayPeering.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is TransitGatewayPeering {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === TransitGatewayPeering.__pulumiType;
    }

    /**
     * Peering Amazon Resource Name (ARN).
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The ARN of the core network.
     */
    public /*out*/ readonly coreNetworkArn!: pulumi.Output<string>;
    /**
     * The ID of a core network.
     */
    public readonly coreNetworkId!: pulumi.Output<string>;
    /**
     * The edge location for the peer.
     */
    public /*out*/ readonly edgeLocation!: pulumi.Output<string>;
    /**
     * The ID of the account owner.
     */
    public /*out*/ readonly ownerAccountId!: pulumi.Output<string>;
    /**
     * The type of peering. This will be `TRANSIT_GATEWAY`.
     */
    public /*out*/ readonly peeringType!: pulumi.Output<string>;
    /**
     * The resource ARN of the peer.
     */
    public /*out*/ readonly resourceArn!: pulumi.Output<string>;
    /**
     * Key-value tags for the peering. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The ARN of the transit gateway for the peering request.
     */
    public readonly transitGatewayArn!: pulumi.Output<string>;
    /**
     * The ID of the transit gateway peering attachment.
     */
    public /*out*/ readonly transitGatewayPeeringAttachmentId!: pulumi.Output<string>;

    /**
     * Create a TransitGatewayPeering resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: TransitGatewayPeeringArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: TransitGatewayPeeringArgs | TransitGatewayPeeringState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as TransitGatewayPeeringState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["coreNetworkArn"] = state ? state.coreNetworkArn : undefined;
            resourceInputs["coreNetworkId"] = state ? state.coreNetworkId : undefined;
            resourceInputs["edgeLocation"] = state ? state.edgeLocation : undefined;
            resourceInputs["ownerAccountId"] = state ? state.ownerAccountId : undefined;
            resourceInputs["peeringType"] = state ? state.peeringType : undefined;
            resourceInputs["resourceArn"] = state ? state.resourceArn : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["transitGatewayArn"] = state ? state.transitGatewayArn : undefined;
            resourceInputs["transitGatewayPeeringAttachmentId"] = state ? state.transitGatewayPeeringAttachmentId : undefined;
        } else {
            const args = argsOrState as TransitGatewayPeeringArgs | undefined;
            if ((!args || args.coreNetworkId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'coreNetworkId'");
            }
            if ((!args || args.transitGatewayArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'transitGatewayArn'");
            }
            resourceInputs["coreNetworkId"] = args ? args.coreNetworkId : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["transitGatewayArn"] = args ? args.transitGatewayArn : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["coreNetworkArn"] = undefined /*out*/;
            resourceInputs["edgeLocation"] = undefined /*out*/;
            resourceInputs["ownerAccountId"] = undefined /*out*/;
            resourceInputs["peeringType"] = undefined /*out*/;
            resourceInputs["resourceArn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["transitGatewayPeeringAttachmentId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(TransitGatewayPeering.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering TransitGatewayPeering resources.
 */
export interface TransitGatewayPeeringState {
    /**
     * Peering Amazon Resource Name (ARN).
     */
    arn?: pulumi.Input<string>;
    /**
     * The ARN of the core network.
     */
    coreNetworkArn?: pulumi.Input<string>;
    /**
     * The ID of a core network.
     */
    coreNetworkId?: pulumi.Input<string>;
    /**
     * The edge location for the peer.
     */
    edgeLocation?: pulumi.Input<string>;
    /**
     * The ID of the account owner.
     */
    ownerAccountId?: pulumi.Input<string>;
    /**
     * The type of peering. This will be `TRANSIT_GATEWAY`.
     */
    peeringType?: pulumi.Input<string>;
    /**
     * The resource ARN of the peer.
     */
    resourceArn?: pulumi.Input<string>;
    /**
     * Key-value tags for the peering. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The ARN of the transit gateway for the peering request.
     */
    transitGatewayArn?: pulumi.Input<string>;
    /**
     * The ID of the transit gateway peering attachment.
     */
    transitGatewayPeeringAttachmentId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a TransitGatewayPeering resource.
 */
export interface TransitGatewayPeeringArgs {
    /**
     * The ID of a core network.
     */
    coreNetworkId: pulumi.Input<string>;
    /**
     * Key-value tags for the peering. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The ARN of the transit gateway for the peering request.
     */
    transitGatewayArn: pulumi.Input<string>;
}
