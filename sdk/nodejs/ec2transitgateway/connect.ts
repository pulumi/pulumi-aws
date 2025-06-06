// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages an EC2 Transit Gateway Connect.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2transitgateway.VpcAttachment("example", {
 *     subnetIds: [exampleAwsSubnet.id],
 *     transitGatewayId: exampleAwsEc2TransitGateway.id,
 *     vpcId: exampleAwsVpc.id,
 * });
 * const attachment = new aws.ec2transitgateway.Connect("attachment", {
 *     transportAttachmentId: example.id,
 *     transitGatewayId: exampleAwsEc2TransitGateway.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_ec2_transit_gateway_connect` using the EC2 Transit Gateway Connect identifier. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2transitgateway/connect:Connect example tgw-attach-12345678
 * ```
 */
export class Connect extends pulumi.CustomResource {
    /**
     * Get an existing Connect resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ConnectState, opts?: pulumi.CustomResourceOptions): Connect {
        return new Connect(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2transitgateway/connect:Connect';

    /**
     * Returns true if the given object is an instance of Connect.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Connect {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Connect.__pulumiType;
    }

    /**
     * The tunnel protocol. Valid values: `gre`. Default is `gre`.
     */
    public readonly protocol!: pulumi.Output<string | undefined>;
    /**
     * Key-value tags for the EC2 Transit Gateway Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Boolean whether the Connect should be associated with the EC2 Transit Gateway association default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    public readonly transitGatewayDefaultRouteTableAssociation!: pulumi.Output<boolean | undefined>;
    /**
     * Boolean whether the Connect should propagate routes with the EC2 Transit Gateway propagation default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    public readonly transitGatewayDefaultRouteTablePropagation!: pulumi.Output<boolean | undefined>;
    /**
     * Identifier of EC2 Transit Gateway.
     */
    public readonly transitGatewayId!: pulumi.Output<string>;
    /**
     * The underlaying VPC attachment
     */
    public readonly transportAttachmentId!: pulumi.Output<string>;

    /**
     * Create a Connect resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ConnectArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ConnectArgs | ConnectState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ConnectState | undefined;
            resourceInputs["protocol"] = state ? state.protocol : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["transitGatewayDefaultRouteTableAssociation"] = state ? state.transitGatewayDefaultRouteTableAssociation : undefined;
            resourceInputs["transitGatewayDefaultRouteTablePropagation"] = state ? state.transitGatewayDefaultRouteTablePropagation : undefined;
            resourceInputs["transitGatewayId"] = state ? state.transitGatewayId : undefined;
            resourceInputs["transportAttachmentId"] = state ? state.transportAttachmentId : undefined;
        } else {
            const args = argsOrState as ConnectArgs | undefined;
            if ((!args || args.transitGatewayId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'transitGatewayId'");
            }
            if ((!args || args.transportAttachmentId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'transportAttachmentId'");
            }
            resourceInputs["protocol"] = args ? args.protocol : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["transitGatewayDefaultRouteTableAssociation"] = args ? args.transitGatewayDefaultRouteTableAssociation : undefined;
            resourceInputs["transitGatewayDefaultRouteTablePropagation"] = args ? args.transitGatewayDefaultRouteTablePropagation : undefined;
            resourceInputs["transitGatewayId"] = args ? args.transitGatewayId : undefined;
            resourceInputs["transportAttachmentId"] = args ? args.transportAttachmentId : undefined;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Connect.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Connect resources.
 */
export interface ConnectState {
    /**
     * The tunnel protocol. Valid values: `gre`. Default is `gre`.
     */
    protocol?: pulumi.Input<string>;
    /**
     * Key-value tags for the EC2 Transit Gateway Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Boolean whether the Connect should be associated with the EC2 Transit Gateway association default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    transitGatewayDefaultRouteTableAssociation?: pulumi.Input<boolean>;
    /**
     * Boolean whether the Connect should propagate routes with the EC2 Transit Gateway propagation default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    transitGatewayDefaultRouteTablePropagation?: pulumi.Input<boolean>;
    /**
     * Identifier of EC2 Transit Gateway.
     */
    transitGatewayId?: pulumi.Input<string>;
    /**
     * The underlaying VPC attachment
     */
    transportAttachmentId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Connect resource.
 */
export interface ConnectArgs {
    /**
     * The tunnel protocol. Valid values: `gre`. Default is `gre`.
     */
    protocol?: pulumi.Input<string>;
    /**
     * Key-value tags for the EC2 Transit Gateway Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Boolean whether the Connect should be associated with the EC2 Transit Gateway association default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    transitGatewayDefaultRouteTableAssociation?: pulumi.Input<boolean>;
    /**
     * Boolean whether the Connect should propagate routes with the EC2 Transit Gateway propagation default route table. This cannot be configured or perform drift detection with Resource Access Manager shared EC2 Transit Gateways. Default value: `true`.
     */
    transitGatewayDefaultRouteTablePropagation?: pulumi.Input<boolean>;
    /**
     * Identifier of EC2 Transit Gateway.
     */
    transitGatewayId: pulumi.Input<string>;
    /**
     * The underlaying VPC attachment
     */
    transportAttachmentId: pulumi.Input<string>;
}
