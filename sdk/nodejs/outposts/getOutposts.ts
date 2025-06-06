// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about multiple Outposts.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.outposts.getOutposts({
 *     siteId: id,
 * });
 * ```
 */
export function getOutposts(args?: GetOutpostsArgs, opts?: pulumi.InvokeOptions): Promise<GetOutpostsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:outposts/getOutposts:getOutposts", {
        "availabilityZone": args.availabilityZone,
        "availabilityZoneId": args.availabilityZoneId,
        "ownerId": args.ownerId,
        "siteId": args.siteId,
    }, opts);
}

/**
 * A collection of arguments for invoking getOutposts.
 */
export interface GetOutpostsArgs {
    /**
     * Availability Zone name.
     */
    availabilityZone?: string;
    /**
     * Availability Zone identifier.
     */
    availabilityZoneId?: string;
    /**
     * AWS Account identifier of the Outpost owner.
     */
    ownerId?: string;
    /**
     * Site identifier.
     */
    siteId?: string;
}

/**
 * A collection of values returned by getOutposts.
 */
export interface GetOutpostsResult {
    /**
     * Set of Amazon Resource Names (ARNs).
     */
    readonly arns: string[];
    readonly availabilityZone: string;
    readonly availabilityZoneId: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Set of identifiers.
     */
    readonly ids: string[];
    readonly ownerId: string;
    readonly siteId: string;
}
/**
 * Provides details about multiple Outposts.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.outposts.getOutposts({
 *     siteId: id,
 * });
 * ```
 */
export function getOutpostsOutput(args?: GetOutpostsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetOutpostsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:outposts/getOutposts:getOutposts", {
        "availabilityZone": args.availabilityZone,
        "availabilityZoneId": args.availabilityZoneId,
        "ownerId": args.ownerId,
        "siteId": args.siteId,
    }, opts);
}

/**
 * A collection of arguments for invoking getOutposts.
 */
export interface GetOutpostsOutputArgs {
    /**
     * Availability Zone name.
     */
    availabilityZone?: pulumi.Input<string>;
    /**
     * Availability Zone identifier.
     */
    availabilityZoneId?: pulumi.Input<string>;
    /**
     * AWS Account identifier of the Outpost owner.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * Site identifier.
     */
    siteId?: pulumi.Input<string>;
}
