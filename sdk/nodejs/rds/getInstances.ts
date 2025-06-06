// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for listing RDS Database Instances.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getInstances({
 *     filters: [{
 *         name: "db-instance-id",
 *         values: ["my-database-id"],
 *     }],
 * });
 * ```
 *
 * ### Using tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getInstances({
 *     tags: {
 *         Env: "test",
 *     },
 * });
 * ```
 */
export function getInstances(args?: GetInstancesArgs, opts?: pulumi.InvokeOptions): Promise<GetInstancesResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:rds/getInstances:getInstances", {
        "filters": args.filters,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getInstances.
 */
export interface GetInstancesArgs {
    /**
     * Configuration block(s) used to filter instances with AWS supported attributes, such as `engine`, `db-cluster-id` or `db-instance-id` for example. Detailed below.
     */
    filters?: inputs.rds.GetInstancesFilter[];
    /**
     * Map of tags, each pair of which must exactly match a pair on the desired instances.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getInstances.
 */
export interface GetInstancesResult {
    readonly filters?: outputs.rds.GetInstancesFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * ARNs of the matched RDS instances.
     */
    readonly instanceArns: string[];
    /**
     * Identifiers of the matched RDS instances.
     */
    readonly instanceIdentifiers: string[];
    readonly tags: {[key: string]: string};
}
/**
 * Data source for listing RDS Database Instances.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getInstances({
 *     filters: [{
 *         name: "db-instance-id",
 *         values: ["my-database-id"],
 *     }],
 * });
 * ```
 *
 * ### Using tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getInstances({
 *     tags: {
 *         Env: "test",
 *     },
 * });
 * ```
 */
export function getInstancesOutput(args?: GetInstancesOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetInstancesResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:rds/getInstances:getInstances", {
        "filters": args.filters,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getInstances.
 */
export interface GetInstancesOutputArgs {
    /**
     * Configuration block(s) used to filter instances with AWS supported attributes, such as `engine`, `db-cluster-id` or `db-instance-id` for example. Detailed below.
     */
    filters?: pulumi.Input<pulumi.Input<inputs.rds.GetInstancesFilterArgs>[]>;
    /**
     * Map of tags, each pair of which must exactly match a pair on the desired instances.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
