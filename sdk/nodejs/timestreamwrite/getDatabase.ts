// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS Timestream Write Database.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.timestreamwrite.getDatabase({
 *     name: "database-example",
 * });
 * ```
 */
export function getDatabase(args: GetDatabaseArgs, opts?: pulumi.InvokeOptions): Promise<GetDatabaseResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:timestreamwrite/getDatabase:getDatabase", {
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getDatabase.
 */
export interface GetDatabaseArgs {
    name: string;
}

/**
 * A collection of values returned by getDatabase.
 */
export interface GetDatabaseResult {
    /**
     * The ARN that uniquely identifies this database.
     */
    readonly arn: string;
    /**
     * Creation time of database.
     */
    readonly createdTime: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * The ARN of the KMS key used to encrypt the data stored in the database.
     */
    readonly kmsKeyId: string;
    /**
     * Last time database was updated.
     */
    readonly lastUpdatedTime: string;
    readonly name: string;
    /**
     * Total number of tables in the Timestream database.
     */
    readonly tableCount: number;
}
/**
 * Data source for managing an AWS Timestream Write Database.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.timestreamwrite.getDatabase({
 *     name: "database-example",
 * });
 * ```
 */
export function getDatabaseOutput(args: GetDatabaseOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetDatabaseResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:timestreamwrite/getDatabase:getDatabase", {
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getDatabase.
 */
export interface GetDatabaseOutputArgs {
    name: pulumi.Input<string>;
}
