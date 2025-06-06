// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides details about a specific VPC NAT Gateway.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = aws.ec2.getNatGateway({
 *     subnetId: _public.id,
 * });
 * ```
 *
 * ### With tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = aws.ec2.getNatGateway({
 *     subnetId: _public.id,
 *     tags: {
 *         Name: "gw NAT",
 *     },
 * });
 * ```
 */
export function getNatGateway(args?: GetNatGatewayArgs, opts?: pulumi.InvokeOptions): Promise<GetNatGatewayResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ec2/getNatGateway:getNatGateway", {
        "filters": args.filters,
        "id": args.id,
        "state": args.state,
        "subnetId": args.subnetId,
        "tags": args.tags,
        "vpcId": args.vpcId,
    }, opts);
}

/**
 * A collection of arguments for invoking getNatGateway.
 */
export interface GetNatGatewayArgs {
    /**
     * Custom filter block as described below.
     *
     * The arguments of this data source act as filters for querying the available
     * NAT Gateways in the current Region. The given filters must match exactly one
     * NAT Gateway whose data will be exported as attributes.
     */
    filters?: inputs.ec2.GetNatGatewayFilter[];
    /**
     * ID of the specific NAT Gateway to retrieve.
     */
    id?: string;
    /**
     * State of the NAT Gateway (pending | failed | available | deleting | deleted ).
     */
    state?: string;
    /**
     * ID of subnet that the NAT Gateway resides in.
     */
    subnetId?: string;
    /**
     * Map of tags, each pair of which must exactly match
     * a pair on the desired NAT Gateway.
     */
    tags?: {[key: string]: string};
    /**
     * ID of the VPC that the NAT Gateway resides in.
     */
    vpcId?: string;
}

/**
 * A collection of values returned by getNatGateway.
 */
export interface GetNatGatewayResult {
    /**
     * ID of the EIP allocated to the selected NAT Gateway.
     */
    readonly allocationId: string;
    /**
     * The association ID of the Elastic IP address that's associated with the NAT Gateway. Only available when `connectivityType` is `public`.
     */
    readonly associationId: string;
    /**
     * Connectivity type of the NAT Gateway.
     */
    readonly connectivityType: string;
    readonly filters?: outputs.ec2.GetNatGatewayFilter[];
    readonly id: string;
    /**
     * The ID of the ENI allocated to the selected NAT Gateway.
     */
    readonly networkInterfaceId: string;
    /**
     * Private IP address of the selected NAT Gateway.
     */
    readonly privateIp: string;
    /**
     * Public IP (EIP) address of the selected NAT Gateway.
     */
    readonly publicIp: string;
    /**
     * Secondary allocation EIP IDs for the selected NAT Gateway.
     */
    readonly secondaryAllocationIds: string[];
    /**
     * The number of secondary private IPv4 addresses assigned to the selected NAT Gateway.
     */
    readonly secondaryPrivateIpAddressCount: number;
    /**
     * Secondary private IPv4 addresses assigned to the selected NAT Gateway.
     */
    readonly secondaryPrivateIpAddresses: string[];
    readonly state: string;
    readonly subnetId: string;
    readonly tags: {[key: string]: string};
    readonly vpcId: string;
}
/**
 * Provides details about a specific VPC NAT Gateway.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = aws.ec2.getNatGateway({
 *     subnetId: _public.id,
 * });
 * ```
 *
 * ### With tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = aws.ec2.getNatGateway({
 *     subnetId: _public.id,
 *     tags: {
 *         Name: "gw NAT",
 *     },
 * });
 * ```
 */
export function getNatGatewayOutput(args?: GetNatGatewayOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetNatGatewayResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ec2/getNatGateway:getNatGateway", {
        "filters": args.filters,
        "id": args.id,
        "state": args.state,
        "subnetId": args.subnetId,
        "tags": args.tags,
        "vpcId": args.vpcId,
    }, opts);
}

/**
 * A collection of arguments for invoking getNatGateway.
 */
export interface GetNatGatewayOutputArgs {
    /**
     * Custom filter block as described below.
     *
     * The arguments of this data source act as filters for querying the available
     * NAT Gateways in the current Region. The given filters must match exactly one
     * NAT Gateway whose data will be exported as attributes.
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ec2.GetNatGatewayFilterArgs>[]>;
    /**
     * ID of the specific NAT Gateway to retrieve.
     */
    id?: pulumi.Input<string>;
    /**
     * State of the NAT Gateway (pending | failed | available | deleting | deleted ).
     */
    state?: pulumi.Input<string>;
    /**
     * ID of subnet that the NAT Gateway resides in.
     */
    subnetId?: pulumi.Input<string>;
    /**
     * Map of tags, each pair of which must exactly match
     * a pair on the desired NAT Gateway.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ID of the VPC that the NAT Gateway resides in.
     */
    vpcId?: pulumi.Input<string>;
}
