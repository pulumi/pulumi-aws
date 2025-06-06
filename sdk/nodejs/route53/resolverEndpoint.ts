// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Route 53 Resolver endpoint resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foo = new aws.route53.ResolverEndpoint("foo", {
 *     name: "foo",
 *     direction: "INBOUND",
 *     resolverEndpointType: "IPV4",
 *     securityGroupIds: [
 *         sg1.id,
 *         sg2.id,
 *     ],
 *     ipAddresses: [
 *         {
 *             subnetId: sn1.id,
 *         },
 *         {
 *             subnetId: sn2.id,
 *             ip: "10.0.64.4",
 *         },
 *     ],
 *     protocols: [
 *         "Do53",
 *         "DoH",
 *     ],
 *     tags: {
 *         Environment: "Prod",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import  Route 53 Resolver endpoints using the Route 53 Resolver endpoint ID. For example:
 *
 * ```sh
 * $ pulumi import aws:route53/resolverEndpoint:ResolverEndpoint foo rslvr-in-abcdef01234567890
 * ```
 */
export class ResolverEndpoint extends pulumi.CustomResource {
    /**
     * Get an existing ResolverEndpoint resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ResolverEndpointState, opts?: pulumi.CustomResourceOptions): ResolverEndpoint {
        return new ResolverEndpoint(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/resolverEndpoint:ResolverEndpoint';

    /**
     * Returns true if the given object is an instance of ResolverEndpoint.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ResolverEndpoint {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ResolverEndpoint.__pulumiType;
    }

    /**
     * ARN of the Route 53 Resolver endpoint.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Direction of DNS queries to or from the Route 53 Resolver endpoint.
     * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
     * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
     */
    public readonly direction!: pulumi.Output<string>;
    /**
     * ID of the VPC that you want to create the resolver endpoint in.
     */
    public /*out*/ readonly hostVpcId!: pulumi.Output<string>;
    /**
     * Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
     * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
     */
    public readonly ipAddresses!: pulumi.Output<outputs.route53.ResolverEndpointIpAddress[]>;
    /**
     * Friendly name of the Route 53 Resolver endpoint.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Protocols you want to use for the Route 53 Resolver endpoint.
     * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
     */
    public readonly protocols!: pulumi.Output<string[]>;
    /**
     * Endpoint IP type. This endpoint type is applied to all IP addresses.
     * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
     */
    public readonly resolverEndpointType!: pulumi.Output<string>;
    /**
     * ID of one or more security groups that you want to use to control access to this VPC.
     */
    public readonly securityGroupIds!: pulumi.Output<string[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a ResolverEndpoint resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ResolverEndpointArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ResolverEndpointArgs | ResolverEndpointState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ResolverEndpointState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["direction"] = state ? state.direction : undefined;
            resourceInputs["hostVpcId"] = state ? state.hostVpcId : undefined;
            resourceInputs["ipAddresses"] = state ? state.ipAddresses : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["protocols"] = state ? state.protocols : undefined;
            resourceInputs["resolverEndpointType"] = state ? state.resolverEndpointType : undefined;
            resourceInputs["securityGroupIds"] = state ? state.securityGroupIds : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ResolverEndpointArgs | undefined;
            if ((!args || args.direction === undefined) && !opts.urn) {
                throw new Error("Missing required property 'direction'");
            }
            if ((!args || args.ipAddresses === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ipAddresses'");
            }
            if ((!args || args.securityGroupIds === undefined) && !opts.urn) {
                throw new Error("Missing required property 'securityGroupIds'");
            }
            resourceInputs["direction"] = args ? args.direction : undefined;
            resourceInputs["ipAddresses"] = args ? args.ipAddresses : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["protocols"] = args ? args.protocols : undefined;
            resourceInputs["resolverEndpointType"] = args ? args.resolverEndpointType : undefined;
            resourceInputs["securityGroupIds"] = args ? args.securityGroupIds : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["hostVpcId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ResolverEndpoint.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ResolverEndpoint resources.
 */
export interface ResolverEndpointState {
    /**
     * ARN of the Route 53 Resolver endpoint.
     */
    arn?: pulumi.Input<string>;
    /**
     * Direction of DNS queries to or from the Route 53 Resolver endpoint.
     * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
     * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
     */
    direction?: pulumi.Input<string>;
    /**
     * ID of the VPC that you want to create the resolver endpoint in.
     */
    hostVpcId?: pulumi.Input<string>;
    /**
     * Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
     * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
     */
    ipAddresses?: pulumi.Input<pulumi.Input<inputs.route53.ResolverEndpointIpAddress>[]>;
    /**
     * Friendly name of the Route 53 Resolver endpoint.
     */
    name?: pulumi.Input<string>;
    /**
     * Protocols you want to use for the Route 53 Resolver endpoint.
     * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
     */
    protocols?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Endpoint IP type. This endpoint type is applied to all IP addresses.
     * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
     */
    resolverEndpointType?: pulumi.Input<string>;
    /**
     * ID of one or more security groups that you want to use to control access to this VPC.
     */
    securityGroupIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a ResolverEndpoint resource.
 */
export interface ResolverEndpointArgs {
    /**
     * Direction of DNS queries to or from the Route 53 Resolver endpoint.
     * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
     * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
     */
    direction: pulumi.Input<string>;
    /**
     * Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
     * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
     */
    ipAddresses: pulumi.Input<pulumi.Input<inputs.route53.ResolverEndpointIpAddress>[]>;
    /**
     * Friendly name of the Route 53 Resolver endpoint.
     */
    name?: pulumi.Input<string>;
    /**
     * Protocols you want to use for the Route 53 Resolver endpoint.
     * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
     */
    protocols?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Endpoint IP type. This endpoint type is applied to all IP addresses.
     * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
     */
    resolverEndpointType?: pulumi.Input<string>;
    /**
     * ID of one or more security groups that you want to use to control access to this VPC.
     */
    securityGroupIds: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
