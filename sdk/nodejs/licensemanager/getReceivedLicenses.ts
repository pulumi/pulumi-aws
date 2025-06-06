// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * This resource can be used to get a set of license ARNs matching a filter.
 *
 * ## Example Usage
 *
 * The following shows getting all license ARNs issued from the AWS marketplace. Providing no filter, would provide all license ARNs for the entire account.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.licensemanager.getReceivedLicenses({
 *     filters: [{
 *         name: "IssuerName",
 *         values: ["AWS/Marketplace"],
 *     }],
 * });
 * ```
 */
export function getReceivedLicenses(args?: GetReceivedLicensesArgs, opts?: pulumi.InvokeOptions): Promise<GetReceivedLicensesResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:licensemanager/getReceivedLicenses:getReceivedLicenses", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getReceivedLicenses.
 */
export interface GetReceivedLicensesArgs {
    /**
     * Custom filter block as described below.
     */
    filters?: inputs.licensemanager.GetReceivedLicensesFilter[];
}

/**
 * A collection of values returned by getReceivedLicenses.
 */
export interface GetReceivedLicensesResult {
    /**
     * List of all the license ARNs found.
     */
    readonly arns: string[];
    readonly filters?: outputs.licensemanager.GetReceivedLicensesFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
}
/**
 * This resource can be used to get a set of license ARNs matching a filter.
 *
 * ## Example Usage
 *
 * The following shows getting all license ARNs issued from the AWS marketplace. Providing no filter, would provide all license ARNs for the entire account.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.licensemanager.getReceivedLicenses({
 *     filters: [{
 *         name: "IssuerName",
 *         values: ["AWS/Marketplace"],
 *     }],
 * });
 * ```
 */
export function getReceivedLicensesOutput(args?: GetReceivedLicensesOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetReceivedLicensesResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:licensemanager/getReceivedLicenses:getReceivedLicenses", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getReceivedLicenses.
 */
export interface GetReceivedLicensesOutputArgs {
    /**
     * Custom filter block as described below.
     */
    filters?: pulumi.Input<pulumi.Input<inputs.licensemanager.GetReceivedLicensesFilterArgs>[]>;
}
