// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Use this data source to get information on an existing backup report plan.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.backup.getReportPlan({
 *     name: "my_example_backup_report_plan_name",
 * });
 * ```
 */
export function getReportPlan(args: GetReportPlanArgs, opts?: pulumi.InvokeOptions): Promise<GetReportPlanResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:backup/getReportPlan:getReportPlan", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getReportPlan.
 */
export interface GetReportPlanArgs {
    /**
     * Backup report plan name.
     */
    name: string;
    /**
     * Metadata that you can assign to help organize the report plans you create.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getReportPlan.
 */
export interface GetReportPlanResult {
    /**
     * ARN of the backup report plan.
     */
    readonly arn: string;
    /**
     * Date and time that a report plan is created, in Unix format and Coordinated Universal Time (UTC).
     */
    readonly creationTime: string;
    /**
     * Deployment status of a report plan. The statuses are: `CREATE_IN_PROGRESS` | `UPDATE_IN_PROGRESS` | `DELETE_IN_PROGRESS` | `COMPLETED`.
     */
    readonly deploymentStatus: string;
    /**
     * Description of the report plan.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly name: string;
    /**
     * An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
     */
    readonly reportDeliveryChannels: outputs.backup.GetReportPlanReportDeliveryChannel[];
    /**
     * An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
     */
    readonly reportSettings: outputs.backup.GetReportPlanReportSetting[];
    /**
     * Metadata that you can assign to help organize the report plans you create.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Use this data source to get information on an existing backup report plan.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.backup.getReportPlan({
 *     name: "my_example_backup_report_plan_name",
 * });
 * ```
 */
export function getReportPlanOutput(args: GetReportPlanOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetReportPlanResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:backup/getReportPlan:getReportPlan", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getReportPlan.
 */
export interface GetReportPlanOutputArgs {
    /**
     * Backup report plan name.
     */
    name: pulumi.Input<string>;
    /**
     * Metadata that you can assign to help organize the report plans you create.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
