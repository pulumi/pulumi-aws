// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Use this data source to get the ARN of a topic in AWS Simple Notification
 * Service (SNS). By using this data source, you can reference SNS topics
 * without having to hard code the ARNs as input.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.sns.getTopic({
 *     name: "an_example_topic",
 * });
 * ```
 */
export function getTopic(args: GetTopicArgs, opts?: pulumi.InvokeOptions): Promise<GetTopicResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:sns/getTopic:getTopic", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getTopic.
 */
export interface GetTopicArgs {
    /**
     * Friendly name of the topic to match.
     */
    name: string;
    /**
     * Map of tags for the resource.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getTopic.
 */
export interface GetTopicResult {
    /**
     * ARN of the found topic, suitable for referencing in other resources that support SNS topics.
     */
    readonly arn: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly name: string;
    /**
     * Map of tags for the resource.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Use this data source to get the ARN of a topic in AWS Simple Notification
 * Service (SNS). By using this data source, you can reference SNS topics
 * without having to hard code the ARNs as input.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.sns.getTopic({
 *     name: "an_example_topic",
 * });
 * ```
 */
export function getTopicOutput(args: GetTopicOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetTopicResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:sns/getTopic:getTopic", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getTopic.
 */
export interface GetTopicOutputArgs {
    /**
     * Friendly name of the topic to match.
     */
    name: pulumi.Input<string>;
    /**
     * Map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
