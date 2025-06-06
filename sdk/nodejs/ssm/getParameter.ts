// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an SSM Parameter data source.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foo = aws.ssm.getParameter({
 *     name: "foo",
 * });
 * ```
 *
 * > **Note:** The unencrypted value of a SecureString will be stored in the raw state as plain-text.
 */
export function getParameter(args: GetParameterArgs, opts?: pulumi.InvokeOptions): Promise<GetParameterResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ssm/getParameter:getParameter", {
        "name": args.name,
        "withDecryption": args.withDecryption,
    }, opts);
}

/**
 * A collection of arguments for invoking getParameter.
 */
export interface GetParameterArgs {
    /**
     * Name of the parameter.
     */
    name: string;
    /**
     * Whether to return decrypted `SecureString` value. Defaults to `true`.
     */
    withDecryption?: boolean;
}

/**
 * A collection of values returned by getParameter.
 */
export interface GetParameterResult {
    /**
     * ARN of the parameter.
     */
    readonly arn: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Value of the parameter. **Use caution:** This value is never marked as sensitive.
     */
    readonly insecureValue: string;
    /**
     * Name of the parameter.
     */
    readonly name: string;
    /**
     * Type of the parameter. Valid types are `String`, `StringList` and `SecureString`.
     */
    readonly type: string;
    /**
     * Value of the parameter. This value is always marked as sensitive in the pulumi preview output, regardless of `type`.
     */
    readonly value: string;
    /**
     * Version of the parameter.
     */
    readonly version: number;
    readonly withDecryption?: boolean;
}
/**
 * Provides an SSM Parameter data source.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foo = aws.ssm.getParameter({
 *     name: "foo",
 * });
 * ```
 *
 * > **Note:** The unencrypted value of a SecureString will be stored in the raw state as plain-text.
 */
export function getParameterOutput(args: GetParameterOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetParameterResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ssm/getParameter:getParameter", {
        "name": args.name,
        "withDecryption": args.withDecryption,
    }, opts);
}

/**
 * A collection of arguments for invoking getParameter.
 */
export interface GetParameterOutputArgs {
    /**
     * Name of the parameter.
     */
    name: pulumi.Input<string>;
    /**
     * Whether to return decrypted `SecureString` value. Defaults to `true`.
     */
    withDecryption?: pulumi.Input<boolean>;
}
