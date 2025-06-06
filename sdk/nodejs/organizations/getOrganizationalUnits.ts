// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Get all direct child organizational units under a parent organizational unit. This only provides immediate children, not all children.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const org = aws.organizations.getOrganization({});
 * const ou = org.then(org => aws.organizations.getOrganizationalUnits({
 *     parentId: org.roots?.[0]?.id,
 * }));
 * ```
 */
export function getOrganizationalUnits(args: GetOrganizationalUnitsArgs, opts?: pulumi.InvokeOptions): Promise<GetOrganizationalUnitsResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:organizations/getOrganizationalUnits:getOrganizationalUnits", {
        "parentId": args.parentId,
    }, opts);
}

/**
 * A collection of arguments for invoking getOrganizationalUnits.
 */
export interface GetOrganizationalUnitsArgs {
    /**
     * Parent ID of the organizational unit.
     */
    parentId: string;
}

/**
 * A collection of values returned by getOrganizationalUnits.
 */
export interface GetOrganizationalUnitsResult {
    /**
     * List of child organizational units, which have the following attributes:
     */
    readonly children: outputs.organizations.GetOrganizationalUnitsChild[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly parentId: string;
}
/**
 * Get all direct child organizational units under a parent organizational unit. This only provides immediate children, not all children.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const org = aws.organizations.getOrganization({});
 * const ou = org.then(org => aws.organizations.getOrganizationalUnits({
 *     parentId: org.roots?.[0]?.id,
 * }));
 * ```
 */
export function getOrganizationalUnitsOutput(args: GetOrganizationalUnitsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetOrganizationalUnitsResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:organizations/getOrganizationalUnits:getOrganizationalUnits", {
        "parentId": args.parentId,
    }, opts);
}

/**
 * A collection of arguments for invoking getOrganizationalUnits.
 */
export interface GetOrganizationalUnitsOutputArgs {
    /**
     * Parent ID of the organizational unit.
     */
    parentId: pulumi.Input<string>;
}
