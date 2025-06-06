// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * This data source can be used to fetch information about a specific
 * IAM policy.
 *
 * ## Example Usage
 *
 * ### By ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getPolicy({
 *     arn: "arn:aws:iam::123456789012:policy/UsersManageOwnCredentials",
 * });
 * ```
 *
 * ### By Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getPolicy({
 *     name: "test_policy",
 * });
 * ```
 */
export function getPolicy(args?: GetPolicyArgs, opts?: pulumi.InvokeOptions): Promise<GetPolicyResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:iam/getPolicy:getPolicy", {
        "arn": args.arn,
        "name": args.name,
        "pathPrefix": args.pathPrefix,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getPolicy.
 */
export interface GetPolicyArgs {
    /**
     * ARN of the IAM policy.
     * Conflicts with `name` and `pathPrefix`.
     */
    arn?: string;
    /**
     * Name of the IAM policy.
     * Conflicts with `arn`.
     */
    name?: string;
    /**
     * Prefix of the path to the IAM policy.
     * Defaults to a slash (`/`).
     * Conflicts with `arn`.
     */
    pathPrefix?: string;
    /**
     * Key-value mapping of tags for the IAM Policy.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getPolicy.
 */
export interface GetPolicyResult {
    /**
     * ARN of the policy.
     */
    readonly arn: string;
    /**
     * Number of entities (users, groups, and roles) that the policy is attached to.
     */
    readonly attachmentCount: number;
    /**
     * Description of the policy.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly name: string;
    /**
     * Path to the policy.
     */
    readonly path: string;
    readonly pathPrefix?: string;
    /**
     * Policy document of the policy.
     */
    readonly policy: string;
    /**
     * Policy's ID.
     */
    readonly policyId: string;
    /**
     * Key-value mapping of tags for the IAM Policy.
     */
    readonly tags: {[key: string]: string};
}
/**
 * This data source can be used to fetch information about a specific
 * IAM policy.
 *
 * ## Example Usage
 *
 * ### By ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getPolicy({
 *     arn: "arn:aws:iam::123456789012:policy/UsersManageOwnCredentials",
 * });
 * ```
 *
 * ### By Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getPolicy({
 *     name: "test_policy",
 * });
 * ```
 */
export function getPolicyOutput(args?: GetPolicyOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetPolicyResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:iam/getPolicy:getPolicy", {
        "arn": args.arn,
        "name": args.name,
        "pathPrefix": args.pathPrefix,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getPolicy.
 */
export interface GetPolicyOutputArgs {
    /**
     * ARN of the IAM policy.
     * Conflicts with `name` and `pathPrefix`.
     */
    arn?: pulumi.Input<string>;
    /**
     * Name of the IAM policy.
     * Conflicts with `arn`.
     */
    name?: pulumi.Input<string>;
    /**
     * Prefix of the path to the IAM policy.
     * Defaults to a slash (`/`).
     * Conflicts with `arn`.
     */
    pathPrefix?: pulumi.Input<string>;
    /**
     * Key-value mapping of tags for the IAM Policy.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
