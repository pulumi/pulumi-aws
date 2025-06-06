// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Retrieve metadata information about a Secrets Manager secret. To retrieve a secret value, see the `aws.secretsmanager.SecretVersion` data source.
 *
 * ## Example Usage
 *
 * ### ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const by_arn = aws.secretsmanager.getSecret({
 *     arn: "arn:aws:secretsmanager:us-east-1:123456789012:secret:example-123456",
 * });
 * ```
 *
 * ### Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const by_name = aws.secretsmanager.getSecret({
 *     name: "example",
 * });
 * ```
 */
export function getSecret(args?: GetSecretArgs, opts?: pulumi.InvokeOptions): Promise<GetSecretResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:secretsmanager/getSecret:getSecret", {
        "arn": args.arn,
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSecret.
 */
export interface GetSecretArgs {
    /**
     * ARN of the secret to retrieve.
     */
    arn?: string;
    /**
     * Name of the secret to retrieve.
     */
    name?: string;
    /**
     * Tags of the secret.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getSecret.
 */
export interface GetSecretResult {
    /**
     * ARN of the secret.
     */
    readonly arn: string;
    /**
     * Created date of the secret in UTC.
     */
    readonly createdDate: string;
    /**
     * Description of the secret.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Key Management Service (KMS) Customer Master Key (CMK) associated with the secret.
     */
    readonly kmsKeyId: string;
    /**
     * Last updated date of the secret in UTC.
     */
    readonly lastChangedDate: string;
    readonly name: string;
    /**
     * Resource-based policy document that's attached to the secret.
     */
    readonly policy: string;
    /**
     * Tags of the secret.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Retrieve metadata information about a Secrets Manager secret. To retrieve a secret value, see the `aws.secretsmanager.SecretVersion` data source.
 *
 * ## Example Usage
 *
 * ### ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const by_arn = aws.secretsmanager.getSecret({
 *     arn: "arn:aws:secretsmanager:us-east-1:123456789012:secret:example-123456",
 * });
 * ```
 *
 * ### Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const by_name = aws.secretsmanager.getSecret({
 *     name: "example",
 * });
 * ```
 */
export function getSecretOutput(args?: GetSecretOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSecretResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:secretsmanager/getSecret:getSecret", {
        "arn": args.arn,
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSecret.
 */
export interface GetSecretOutputArgs {
    /**
     * ARN of the secret to retrieve.
     */
    arn?: pulumi.Input<string>;
    /**
     * Name of the secret to retrieve.
     */
    name?: pulumi.Input<string>;
    /**
     * Tags of the secret.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
