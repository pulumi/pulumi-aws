// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides details about a specific EC2 Customer-Owned IP Pool.
 *
 * This data source can prove useful when a module accepts a coip pool id as
 * an input variable and needs to, for example, determine the CIDR block of that
 * COIP Pool.
 */
export function getCoipPool(args?: GetCoipPoolArgs, opts?: pulumi.InvokeOptions): Promise<GetCoipPoolResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ec2/getCoipPool:getCoipPool", {
        "filters": args.filters,
        "localGatewayRouteTableId": args.localGatewayRouteTableId,
        "poolId": args.poolId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCoipPool.
 */
export interface GetCoipPoolArgs {
    filters?: inputs.ec2.GetCoipPoolFilter[];
    /**
     * Local Gateway Route Table Id assigned to desired COIP Pool
     */
    localGatewayRouteTableId?: string;
    /**
     * ID of the specific COIP Pool to retrieve.
     */
    poolId?: string;
    /**
     * Mapping of tags, each pair of which must exactly match
     * a pair on the desired COIP Pool.
     *
     * More complex filters can be expressed using one or more `filter` sub-blocks,
     * which take the following arguments:
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getCoipPool.
 */
export interface GetCoipPoolResult {
    /**
     * ARN of the COIP pool
     */
    readonly arn: string;
    readonly filters?: outputs.ec2.GetCoipPoolFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly localGatewayRouteTableId: string;
    /**
     * Set of CIDR blocks in pool
     */
    readonly poolCidrs: string[];
    readonly poolId: string;
    readonly tags: {[key: string]: string};
}
/**
 * Provides details about a specific EC2 Customer-Owned IP Pool.
 *
 * This data source can prove useful when a module accepts a coip pool id as
 * an input variable and needs to, for example, determine the CIDR block of that
 * COIP Pool.
 */
export function getCoipPoolOutput(args?: GetCoipPoolOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetCoipPoolResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ec2/getCoipPool:getCoipPool", {
        "filters": args.filters,
        "localGatewayRouteTableId": args.localGatewayRouteTableId,
        "poolId": args.poolId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCoipPool.
 */
export interface GetCoipPoolOutputArgs {
    filters?: pulumi.Input<pulumi.Input<inputs.ec2.GetCoipPoolFilterArgs>[]>;
    /**
     * Local Gateway Route Table Id assigned to desired COIP Pool
     */
    localGatewayRouteTableId?: pulumi.Input<string>;
    /**
     * ID of the specific COIP Pool to retrieve.
     */
    poolId?: pulumi.Input<string>;
    /**
     * Mapping of tags, each pair of which must exactly match
     * a pair on the desired COIP Pool.
     *
     * More complex filters can be expressed using one or more `filter` sub-blocks,
     * which take the following arguments:
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
