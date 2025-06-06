// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS Timestream Write Table.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.timestreamwrite.getTable({
 *     databaseName: testAwsTimestreamwriteDatabase.databaseName,
 *     name: testAwsTimestreamwriteTable.tableName,
 * });
 * ```
 */
export function getTable(args: GetTableArgs, opts?: pulumi.InvokeOptions): Promise<GetTableResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:timestreamwrite/getTable:getTable", {
        "databaseName": args.databaseName,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getTable.
 */
export interface GetTableArgs {
    /**
     * Name of the Timestream database.
     */
    databaseName: string;
    /**
     * Name of the Timestream table.
     */
    name: string;
}

/**
 * A collection of values returned by getTable.
 */
export interface GetTableResult {
    /**
     * ARN that uniquely identifies the table.
     */
    readonly arn: string;
    /**
     * Time that table was created.
     */
    readonly creationTime: string;
    /**
     * Name of database.
     */
    readonly databaseName: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Last time table was updated.
     */
    readonly lastUpdatedTime: string;
    /**
     * Object containing the following attributes to desribe magnetic store writes.
     */
    readonly magneticStoreWriteProperties: outputs.timestreamwrite.GetTableMagneticStoreWriteProperty[];
    /**
     * Name of the table.
     */
    readonly name: string;
    /**
     * Object containing the following attributes to describe the retention duration for the memory and magnetic stores.
     */
    readonly retentionProperties: outputs.timestreamwrite.GetTableRetentionProperty[];
    /**
     * Object containing the following attributes to describe the schema of the table.
     */
    readonly schemas: outputs.timestreamwrite.GetTableSchema[];
    /**
     * Current state of table.
     */
    readonly tableStatus: string;
}
/**
 * Data source for managing an AWS Timestream Write Table.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.timestreamwrite.getTable({
 *     databaseName: testAwsTimestreamwriteDatabase.databaseName,
 *     name: testAwsTimestreamwriteTable.tableName,
 * });
 * ```
 */
export function getTableOutput(args: GetTableOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetTableResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:timestreamwrite/getTable:getTable", {
        "databaseName": args.databaseName,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getTable.
 */
export interface GetTableOutputArgs {
    /**
     * Name of the Timestream database.
     */
    databaseName: pulumi.Input<string>;
    /**
     * Name of the Timestream table.
     */
    name: pulumi.Input<string>;
}
