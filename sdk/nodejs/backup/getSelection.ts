// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Use this data source to get information on an existing backup selection.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.backup.getSelection({
 *     planId: exampleAwsBackupPlan.id,
 *     selectionId: "selection-id-example",
 * });
 * ```
 */
export function getSelection(args: GetSelectionArgs, opts?: pulumi.InvokeOptions): Promise<GetSelectionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:backup/getSelection:getSelection", {
        "planId": args.planId,
        "selectionId": args.selectionId,
    }, opts);
}

/**
 * A collection of arguments for invoking getSelection.
 */
export interface GetSelectionArgs {
    /**
     * Backup plan ID associated with the selection of resources.
     */
    planId: string;
    /**
     * Backup selection ID.
     */
    selectionId: string;
}

/**
 * A collection of values returned by getSelection.
 */
export interface GetSelectionResult {
    /**
     * ARN of the IAM role that AWS Backup uses to authenticate when restoring and backing up the target resource. See the [AWS Backup Developer Guide](https://docs.aws.amazon.com/aws-backup/latest/devguide/access-control.html#managed-policies) for additional information about using AWS managed policies or creating custom policies attached to the IAM role.
     */
    readonly iamRoleArn: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Display name of a resource selection document.
     */
    readonly name: string;
    readonly planId: string;
    /**
     * An array of strings that either contain Amazon Resource Names (ARNs) or match patterns of resources to assign to a backup plan..
     */
    readonly resources: string[];
    readonly selectionId: string;
}
/**
 * Use this data source to get information on an existing backup selection.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.backup.getSelection({
 *     planId: exampleAwsBackupPlan.id,
 *     selectionId: "selection-id-example",
 * });
 * ```
 */
export function getSelectionOutput(args: GetSelectionOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSelectionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:backup/getSelection:getSelection", {
        "planId": args.planId,
        "selectionId": args.selectionId,
    }, opts);
}

/**
 * A collection of arguments for invoking getSelection.
 */
export interface GetSelectionOutputArgs {
    /**
     * Backup plan ID associated with the selection of resources.
     */
    planId: pulumi.Input<string>;
    /**
     * Backup selection ID.
     */
    selectionId: pulumi.Input<string>;
}
