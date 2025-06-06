// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Data source for retrieving a value from an AWS DynamoDB table.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.dynamodb.getTableItem({
 *     tableName: example.name,
 *     expressionAttributeNames: {
 *         "#P": "Percentile",
 *     },
 *     projectionExpression: "#P",
 *     key: `{
 * \x09"hashKey": {"S": "example"}
 * }
 * `,
 * });
 * ```
 */
export function getTableItem(args: GetTableItemArgs, opts?: pulumi.InvokeOptions): Promise<GetTableItemResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:dynamodb/getTableItem:getTableItem", {
        "expressionAttributeNames": args.expressionAttributeNames,
        "key": args.key,
        "projectionExpression": args.projectionExpression,
        "tableName": args.tableName,
    }, opts);
}

/**
 * A collection of arguments for invoking getTableItem.
 */
export interface GetTableItemArgs {
    expressionAttributeNames?: {[key: string]: string};
    /**
     * A map of attribute names to AttributeValue objects, representing the primary key of the item to retrieve.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only need to provide a value for the partition key. For a composite primary key, you must provide values for both the partition key and the sort key.
     *
     * The following arguments are optional:
     */
    key: string;
    /**
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * If no attribute names are specified, then all attributes are returned. If any of the requested attributes are not found, they do not appear in the result.
     */
    projectionExpression?: string;
    /**
     * The name of the table containing the requested item.
     */
    tableName: string;
}

/**
 * A collection of values returned by getTableItem.
 */
export interface GetTableItemResult {
    readonly expressionAttributeNames?: {[key: string]: string};
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * JSON representation of a map of attribute names to [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html) objects, as specified by ProjectionExpression.
     */
    readonly item: string;
    readonly key: string;
    readonly projectionExpression?: string;
    readonly tableName: string;
}
/**
 * Data source for retrieving a value from an AWS DynamoDB table.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.dynamodb.getTableItem({
 *     tableName: example.name,
 *     expressionAttributeNames: {
 *         "#P": "Percentile",
 *     },
 *     projectionExpression: "#P",
 *     key: `{
 * \x09"hashKey": {"S": "example"}
 * }
 * `,
 * });
 * ```
 */
export function getTableItemOutput(args: GetTableItemOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetTableItemResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:dynamodb/getTableItem:getTableItem", {
        "expressionAttributeNames": args.expressionAttributeNames,
        "key": args.key,
        "projectionExpression": args.projectionExpression,
        "tableName": args.tableName,
    }, opts);
}

/**
 * A collection of arguments for invoking getTableItem.
 */
export interface GetTableItemOutputArgs {
    expressionAttributeNames?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of attribute names to AttributeValue objects, representing the primary key of the item to retrieve.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only need to provide a value for the partition key. For a composite primary key, you must provide values for both the partition key and the sort key.
     *
     * The following arguments are optional:
     */
    key: pulumi.Input<string>;
    /**
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * If no attribute names are specified, then all attributes are returned. If any of the requested attributes are not found, they do not appear in the result.
     */
    projectionExpression?: pulumi.Input<string>;
    /**
     * The name of the table containing the requested item.
     */
    tableName: pulumi.Input<string>;
}
