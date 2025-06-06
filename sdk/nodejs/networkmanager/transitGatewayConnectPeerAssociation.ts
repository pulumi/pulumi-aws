// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Associates a transit gateway Connect peer with a device, and optionally, with a link.
 * If you specify a link, it must be associated with the specified device.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.networkmanager.TransitGatewayConnectPeerAssociation("example", {
 *     globalNetworkId: exampleAwsNetworkmanagerGlobalNetwork.id,
 *     deviceId: exampleAwsNetworkmanagerDevice.id,
 *     transitGatewayConnectPeerArn: exampleAwsEc2TransitGatewayConnectPeer.arn,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_networkmanager_transit_gateway_connect_peer_association` using the global network ID and customer gateway ARN. For example:
 *
 * ```sh
 * $ pulumi import aws:networkmanager/transitGatewayConnectPeerAssociation:TransitGatewayConnectPeerAssociation example global-network-0d47f6t230mz46dy4,arn:aws:ec2:us-west-2:123456789012:transit-gateway-connect-peer/tgw-connect-peer-12345678
 * ```
 */
export class TransitGatewayConnectPeerAssociation extends pulumi.CustomResource {
    /**
     * Get an existing TransitGatewayConnectPeerAssociation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: TransitGatewayConnectPeerAssociationState, opts?: pulumi.CustomResourceOptions): TransitGatewayConnectPeerAssociation {
        return new TransitGatewayConnectPeerAssociation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:networkmanager/transitGatewayConnectPeerAssociation:TransitGatewayConnectPeerAssociation';

    /**
     * Returns true if the given object is an instance of TransitGatewayConnectPeerAssociation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is TransitGatewayConnectPeerAssociation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === TransitGatewayConnectPeerAssociation.__pulumiType;
    }

    /**
     * The ID of the device.
     */
    public readonly deviceId!: pulumi.Output<string>;
    /**
     * The ID of the global network.
     */
    public readonly globalNetworkId!: pulumi.Output<string>;
    /**
     * The ID of the link.
     */
    public readonly linkId!: pulumi.Output<string | undefined>;
    /**
     * The Amazon Resource Name (ARN) of the Connect peer.
     */
    public readonly transitGatewayConnectPeerArn!: pulumi.Output<string>;

    /**
     * Create a TransitGatewayConnectPeerAssociation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: TransitGatewayConnectPeerAssociationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: TransitGatewayConnectPeerAssociationArgs | TransitGatewayConnectPeerAssociationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as TransitGatewayConnectPeerAssociationState | undefined;
            resourceInputs["deviceId"] = state ? state.deviceId : undefined;
            resourceInputs["globalNetworkId"] = state ? state.globalNetworkId : undefined;
            resourceInputs["linkId"] = state ? state.linkId : undefined;
            resourceInputs["transitGatewayConnectPeerArn"] = state ? state.transitGatewayConnectPeerArn : undefined;
        } else {
            const args = argsOrState as TransitGatewayConnectPeerAssociationArgs | undefined;
            if ((!args || args.deviceId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deviceId'");
            }
            if ((!args || args.globalNetworkId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'globalNetworkId'");
            }
            if ((!args || args.transitGatewayConnectPeerArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'transitGatewayConnectPeerArn'");
            }
            resourceInputs["deviceId"] = args ? args.deviceId : undefined;
            resourceInputs["globalNetworkId"] = args ? args.globalNetworkId : undefined;
            resourceInputs["linkId"] = args ? args.linkId : undefined;
            resourceInputs["transitGatewayConnectPeerArn"] = args ? args.transitGatewayConnectPeerArn : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(TransitGatewayConnectPeerAssociation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering TransitGatewayConnectPeerAssociation resources.
 */
export interface TransitGatewayConnectPeerAssociationState {
    /**
     * The ID of the device.
     */
    deviceId?: pulumi.Input<string>;
    /**
     * The ID of the global network.
     */
    globalNetworkId?: pulumi.Input<string>;
    /**
     * The ID of the link.
     */
    linkId?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Connect peer.
     */
    transitGatewayConnectPeerArn?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a TransitGatewayConnectPeerAssociation resource.
 */
export interface TransitGatewayConnectPeerAssociationArgs {
    /**
     * The ID of the device.
     */
    deviceId: pulumi.Input<string>;
    /**
     * The ID of the global network.
     */
    globalNetworkId: pulumi.Input<string>;
    /**
     * The ID of the link.
     */
    linkId?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Connect peer.
     */
    transitGatewayConnectPeerArn: pulumi.Input<string>;
}
