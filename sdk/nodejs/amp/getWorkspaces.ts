// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides the aliases, ARNs, and workspace IDs of Amazon Prometheus workspaces.
 *
 * ## Example Usage
 *
 * The following example returns all of the workspaces in a region:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.amp.getWorkspaces({});
 * ```
 *
 * The following example filters the workspaces by alias. Only the workspaces with
 * aliases that begin with the value of `aliasPrefix` will be returned:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.amp.getWorkspaces({
 *     aliasPrefix: "example",
 * });
 * ```
 */
export function getWorkspaces(args?: GetWorkspacesArgs, opts?: pulumi.InvokeOptions): Promise<GetWorkspacesResult> {
    args = args || {};

    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:amp/getWorkspaces:getWorkspaces", {
        "aliasPrefix": args.aliasPrefix,
    }, opts);
}

/**
 * A collection of arguments for invoking getWorkspaces.
 */
export interface GetWorkspacesArgs {
    /**
     * Limits results to workspaces with aliases that begin with this value.
     */
    aliasPrefix?: string;
}

/**
 * A collection of values returned by getWorkspaces.
 */
export interface GetWorkspacesResult {
    readonly aliasPrefix?: string;
    /**
     * List of aliases of the matched Prometheus workspaces.
     */
    readonly aliases: string[];
    /**
     * List of ARNs of the matched Prometheus workspaces.
     */
    readonly arns: string[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * List of workspace IDs of the matched Prometheus workspaces.
     */
    readonly workspaceIds: string[];
}
/**
 * Provides the aliases, ARNs, and workspace IDs of Amazon Prometheus workspaces.
 *
 * ## Example Usage
 *
 * The following example returns all of the workspaces in a region:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.amp.getWorkspaces({});
 * ```
 *
 * The following example filters the workspaces by alias. Only the workspaces with
 * aliases that begin with the value of `aliasPrefix` will be returned:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.amp.getWorkspaces({
 *     aliasPrefix: "example",
 * });
 * ```
 */
export function getWorkspacesOutput(args?: GetWorkspacesOutputArgs, opts?: pulumi.InvokeOptions): pulumi.Output<GetWorkspacesResult> {
    return pulumi.output(args).apply((a: any) => getWorkspaces(a, opts))
}

/**
 * A collection of arguments for invoking getWorkspaces.
 */
export interface GetWorkspacesOutputArgs {
    /**
     * Limits results to workspaces with aliases that begin with this value.
     */
    aliasPrefix?: pulumi.Input<string>;
}