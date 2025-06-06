// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS OpenSearch Serverless Lifecycle Policy.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.opensearch.getServerlessLifecyclePolicy({
 *     name: "example-lifecycle-policy",
 *     type: "retention",
 * });
 * ```
 */
export function getServerlessLifecyclePolicy(args: GetServerlessLifecyclePolicyArgs, opts?: pulumi.InvokeOptions): Promise<GetServerlessLifecyclePolicyResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:opensearch/getServerlessLifecyclePolicy:getServerlessLifecyclePolicy", {
        "name": args.name,
        "type": args.type,
    }, opts);
}

/**
 * A collection of arguments for invoking getServerlessLifecyclePolicy.
 */
export interface GetServerlessLifecyclePolicyArgs {
    /**
     * Name of the policy
     */
    name: string;
    /**
     * Type of lifecycle policy. Must be `retention`.
     */
    type: string;
}

/**
 * A collection of values returned by getServerlessLifecyclePolicy.
 */
export interface GetServerlessLifecyclePolicyResult {
    /**
     * The date the lifecycle policy was created.
     */
    readonly createdDate: string;
    /**
     * Description of the policy. Typically used to store information about the permissions defined in the policy.
     */
    readonly description: string;
    readonly id: string;
    /**
     * The date the lifecycle policy was last modified.
     */
    readonly lastModifiedDate: string;
    readonly name: string;
    /**
     * JSON policy document to use as the content for the new policy.
     */
    readonly policy: string;
    /**
     * Version of the policy.
     */
    readonly policyVersion: string;
    readonly type: string;
}
/**
 * Data source for managing an AWS OpenSearch Serverless Lifecycle Policy.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.opensearch.getServerlessLifecyclePolicy({
 *     name: "example-lifecycle-policy",
 *     type: "retention",
 * });
 * ```
 */
export function getServerlessLifecyclePolicyOutput(args: GetServerlessLifecyclePolicyOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetServerlessLifecyclePolicyResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:opensearch/getServerlessLifecyclePolicy:getServerlessLifecyclePolicy", {
        "name": args.name,
        "type": args.type,
    }, opts);
}

/**
 * A collection of arguments for invoking getServerlessLifecyclePolicy.
 */
export interface GetServerlessLifecyclePolicyOutputArgs {
    /**
     * Name of the policy
     */
    name: pulumi.Input<string>;
    /**
     * Type of lifecycle policy. Must be `retention`.
     */
    type: pulumi.Input<string>;
}
