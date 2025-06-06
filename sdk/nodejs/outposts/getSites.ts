// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about multiple Outposts Sites.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const all = aws.outposts.getSites({});
 * ```
 */
export function getSites(opts?: pulumi.InvokeOptions): Promise<GetSitesResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:outposts/getSites:getSites", {
    }, opts);
}

/**
 * A collection of values returned by getSites.
 */
export interface GetSitesResult {
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Set of Outposts Site identifiers.
     */
    readonly ids: string[];
}
/**
 * Provides details about multiple Outposts Sites.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const all = aws.outposts.getSites({});
 * ```
 */
export function getSitesOutput(opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSitesResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:outposts/getSites:getSites", {
    }, opts);
}
