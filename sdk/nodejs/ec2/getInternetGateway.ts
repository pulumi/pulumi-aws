// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * `aws.ec2.InternetGateway` provides details about a specific Internet Gateway.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const vpcId = config.requireObject<any>("vpcId");
 * const _default = aws.ec2.getInternetGateway({
 *     filters: [{
 *         name: "attachment.vpc-id",
 *         values: [vpcId],
 *     }],
 * });
 * ```
 */
export function getInternetGateway(args?: GetInternetGatewayArgs, opts?: pulumi.InvokeOptions): Promise<GetInternetGatewayResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ec2/getInternetGateway:getInternetGateway", {
        "filters": args.filters,
        "internetGatewayId": args.internetGatewayId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getInternetGateway.
 */
export interface GetInternetGatewayArgs {
    /**
     * Custom filter block as described below.
     *
     * More complex filters can be expressed using one or more `filter` sub-blocks,
     * which take the following arguments:
     */
    filters?: inputs.ec2.GetInternetGatewayFilter[];
    /**
     * ID of the specific Internet Gateway to retrieve.
     */
    internetGatewayId?: string;
    /**
     * Map of tags, each pair of which must exactly match
     * a pair on the desired Internet Gateway.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getInternetGateway.
 */
export interface GetInternetGatewayResult {
    /**
     * ARN of the Internet Gateway.
     */
    readonly arn: string;
    readonly attachments: outputs.ec2.GetInternetGatewayAttachment[];
    readonly filters?: outputs.ec2.GetInternetGatewayFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly internetGatewayId: string;
    /**
     * ID of the AWS account that owns the internet gateway.
     */
    readonly ownerId: string;
    readonly tags: {[key: string]: string};
}
/**
 * `aws.ec2.InternetGateway` provides details about a specific Internet Gateway.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const vpcId = config.requireObject<any>("vpcId");
 * const _default = aws.ec2.getInternetGateway({
 *     filters: [{
 *         name: "attachment.vpc-id",
 *         values: [vpcId],
 *     }],
 * });
 * ```
 */
export function getInternetGatewayOutput(args?: GetInternetGatewayOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetInternetGatewayResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ec2/getInternetGateway:getInternetGateway", {
        "filters": args.filters,
        "internetGatewayId": args.internetGatewayId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getInternetGateway.
 */
export interface GetInternetGatewayOutputArgs {
    /**
     * Custom filter block as described below.
     *
     * More complex filters can be expressed using one or more `filter` sub-blocks,
     * which take the following arguments:
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ec2.GetInternetGatewayFilterArgs>[]>;
    /**
     * ID of the specific Internet Gateway to retrieve.
     */
    internetGatewayId?: pulumi.Input<string>;
    /**
     * Map of tags, each pair of which must exactly match
     * a pair on the desired Internet Gateway.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
