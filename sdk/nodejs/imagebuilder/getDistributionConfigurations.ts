// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Use this data source to get the ARNs and names of Image Builder Distribution Configurations matching the specified criteria.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getDistributionConfigurations({
 *     filters: [{
 *         name: "name",
 *         values: ["example"],
 *     }],
 * });
 * ```
 */
export function getDistributionConfigurations(args?: GetDistributionConfigurationsArgs, opts?: pulumi.InvokeOptions): Promise<GetDistributionConfigurationsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:imagebuilder/getDistributionConfigurations:getDistributionConfigurations", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getDistributionConfigurations.
 */
export interface GetDistributionConfigurationsArgs {
    /**
     * Configuration block(s) for filtering. Detailed below.
     */
    filters?: inputs.imagebuilder.GetDistributionConfigurationsFilter[];
}

/**
 * A collection of values returned by getDistributionConfigurations.
 */
export interface GetDistributionConfigurationsResult {
    /**
     * Set of ARNs of the matched Image Builder Distribution Configurations.
     */
    readonly arns: string[];
    readonly filters?: outputs.imagebuilder.GetDistributionConfigurationsFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Set of names of the matched Image Builder Distribution Configurations.
     */
    readonly names: string[];
}
/**
 * Use this data source to get the ARNs and names of Image Builder Distribution Configurations matching the specified criteria.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getDistributionConfigurations({
 *     filters: [{
 *         name: "name",
 *         values: ["example"],
 *     }],
 * });
 * ```
 */
export function getDistributionConfigurationsOutput(args?: GetDistributionConfigurationsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetDistributionConfigurationsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:imagebuilder/getDistributionConfigurations:getDistributionConfigurations", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getDistributionConfigurations.
 */
export interface GetDistributionConfigurationsOutputArgs {
    /**
     * Configuration block(s) for filtering. Detailed below.
     */
    filters?: pulumi.Input<pulumi.Input<inputs.imagebuilder.GetDistributionConfigurationsFilterArgs>[]>;
}
