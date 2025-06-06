// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about an Outposts Outpost.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.outposts.getOutpost({
 *     name: "example",
 * });
 * ```
 */
export function getOutpost(args?: GetOutpostArgs, opts?: pulumi.InvokeOptions): Promise<GetOutpostResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:outposts/getOutpost:getOutpost", {
        "arn": args.arn,
        "id": args.id,
        "name": args.name,
        "ownerId": args.ownerId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getOutpost.
 */
export interface GetOutpostArgs {
    /**
     * ARN.
     */
    arn?: string;
    /**
     * Identifier of the Outpost.
     */
    id?: string;
    /**
     * Name of the Outpost.
     */
    name?: string;
    /**
     * AWS Account identifier of the Outpost owner.
     */
    ownerId?: string;
    /**
     * The Outpost tags.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getOutpost.
 */
export interface GetOutpostResult {
    readonly arn: string;
    /**
     * Availability Zone name.
     */
    readonly availabilityZone: string;
    /**
     * Availability Zone identifier.
     */
    readonly availabilityZoneId: string;
    /**
     * The description of the Outpost.
     */
    readonly description: string;
    readonly id: string;
    /**
     * The life cycle status.
     */
    readonly lifecycleStatus: string;
    readonly name: string;
    readonly ownerId?: string;
    /**
     * The Amazon Resource Name (ARN) of the site.
     */
    readonly siteArn: string;
    /**
     * The ID of the site.
     */
    readonly siteId: string;
    /**
     * The hardware type.
     */
    readonly supportedHardwareType: string;
    /**
     * The Outpost tags.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Provides details about an Outposts Outpost.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.outposts.getOutpost({
 *     name: "example",
 * });
 * ```
 */
export function getOutpostOutput(args?: GetOutpostOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetOutpostResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:outposts/getOutpost:getOutpost", {
        "arn": args.arn,
        "id": args.id,
        "name": args.name,
        "ownerId": args.ownerId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getOutpost.
 */
export interface GetOutpostOutputArgs {
    /**
     * ARN.
     */
    arn?: pulumi.Input<string>;
    /**
     * Identifier of the Outpost.
     */
    id?: pulumi.Input<string>;
    /**
     * Name of the Outpost.
     */
    name?: pulumi.Input<string>;
    /**
     * AWS Account identifier of the Outpost owner.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * The Outpost tags.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
