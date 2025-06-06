// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing AWS EKS (Elastic Kubernetes) Cluster Versions.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({});
 * ```
 *
 * ### Filter by Cluster Type
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({
 *     clusterType: "eks",
 * });
 * ```
 *
 * ### Filter by Version Status
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({
 *     versionStatus: "STANDARD_SUPPORT",
 * });
 * ```
 */
export function getClusterVersions(args?: GetClusterVersionsArgs, opts?: pulumi.InvokeOptions): Promise<GetClusterVersionsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:eks/getClusterVersions:getClusterVersions", {
        "clusterType": args.clusterType,
        "clusterVersionsOnlies": args.clusterVersionsOnlies,
        "defaultOnly": args.defaultOnly,
        "includeAll": args.includeAll,
        "versionStatus": args.versionStatus,
    }, opts);
}

/**
 * A collection of arguments for invoking getClusterVersions.
 */
export interface GetClusterVersionsArgs {
    /**
     * Type of clusters to filter by.
     * Currently, the only valid value is `eks`.
     */
    clusterType?: string;
    clusterVersionsOnlies?: string[];
    /**
     * Whether to show only the default versions of Kubernetes supported by EKS.
     */
    defaultOnly?: boolean;
    /**
     * Whether to include all kubernetes versions in the response.
     */
    includeAll?: boolean;
    /**
     * Status of the EKS cluster versions to list.
     * Valid values are `STANDARD_SUPPORT` or `UNSUPPORTED` or `EXTENDED_SUPPORT`.
     */
    versionStatus?: string;
}

/**
 * A collection of values returned by getClusterVersions.
 */
export interface GetClusterVersionsResult {
    /**
     * Type of cluster that the version belongs to.
     */
    readonly clusterType?: string;
    readonly clusterVersions: outputs.eks.GetClusterVersionsClusterVersion[];
    readonly clusterVersionsOnlies?: string[];
    readonly defaultOnly?: boolean;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly includeAll?: boolean;
    /**
     * Status of the EKS cluster version.
     */
    readonly versionStatus?: string;
}
/**
 * Data source for managing AWS EKS (Elastic Kubernetes) Cluster Versions.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({});
 * ```
 *
 * ### Filter by Cluster Type
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({
 *     clusterType: "eks",
 * });
 * ```
 *
 * ### Filter by Version Status
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.eks.getClusterVersions({
 *     versionStatus: "STANDARD_SUPPORT",
 * });
 * ```
 */
export function getClusterVersionsOutput(args?: GetClusterVersionsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetClusterVersionsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:eks/getClusterVersions:getClusterVersions", {
        "clusterType": args.clusterType,
        "clusterVersionsOnlies": args.clusterVersionsOnlies,
        "defaultOnly": args.defaultOnly,
        "includeAll": args.includeAll,
        "versionStatus": args.versionStatus,
    }, opts);
}

/**
 * A collection of arguments for invoking getClusterVersions.
 */
export interface GetClusterVersionsOutputArgs {
    /**
     * Type of clusters to filter by.
     * Currently, the only valid value is `eks`.
     */
    clusterType?: pulumi.Input<string>;
    clusterVersionsOnlies?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Whether to show only the default versions of Kubernetes supported by EKS.
     */
    defaultOnly?: pulumi.Input<boolean>;
    /**
     * Whether to include all kubernetes versions in the response.
     */
    includeAll?: pulumi.Input<boolean>;
    /**
     * Status of the EKS cluster versions to list.
     * Valid values are `STANDARD_SUPPORT` or `UNSUPPORTED` or `EXTENDED_SUPPORT`.
     */
    versionStatus?: pulumi.Input<string>;
}
