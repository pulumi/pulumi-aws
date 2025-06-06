// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Use this data source to retrieve information about an EventBridge connection.
 *
 * > **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.cloudwatch.getEventConnection({
 *     name: "test",
 * });
 * ```
 */
export function getEventConnection(args: GetEventConnectionArgs, opts?: pulumi.InvokeOptions): Promise<GetEventConnectionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:cloudwatch/getEventConnection:getEventConnection", {
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getEventConnection.
 */
export interface GetEventConnectionArgs {
    /**
     * Name of the connection.
     */
    name: string;
}

/**
 * A collection of values returned by getEventConnection.
 */
export interface GetEventConnectionResult {
    /**
     * ARN (Amazon Resource Name) of the connection.
     */
    readonly arn: string;
    /**
     * Type of authorization specified for the connection. One of `API_KEY`,`BASIC`,`OAUTH_CLIENT_CREDENTIALS`.
     */
    readonly authorizationType: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * (Optional) Identifier of the AWS KMS customer managed key for EventBridge to use to encrypt the connection, if one has been specified.
     */
    readonly kmsKeyIdentifier: string;
    readonly name: string;
    /**
     * ARN of the secret created from the authorization parameters specified for the connection.
     */
    readonly secretArn: string;
}
/**
 * Use this data source to retrieve information about an EventBridge connection.
 *
 * > **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.cloudwatch.getEventConnection({
 *     name: "test",
 * });
 * ```
 */
export function getEventConnectionOutput(args: GetEventConnectionOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetEventConnectionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:cloudwatch/getEventConnection:getEventConnection", {
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getEventConnection.
 */
export interface GetEventConnectionOutputArgs {
    /**
     * Name of the connection.
     */
    name: pulumi.Input<string>;
}
