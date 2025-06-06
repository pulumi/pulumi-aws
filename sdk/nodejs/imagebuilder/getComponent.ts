// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about an Image Builder Component.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getComponent({
 *     arn: "arn:aws:imagebuilder:us-west-2:aws:component/amazon-cloudwatch-agent-linux/1.0.0",
 * });
 * ```
 */
export function getComponent(args: GetComponentArgs, opts?: pulumi.InvokeOptions): Promise<GetComponentResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:imagebuilder/getComponent:getComponent", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getComponent.
 */
export interface GetComponentArgs {
    /**
     * ARN of the component.
     */
    arn: string;
    /**
     * Key-value map of resource tags for the component.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getComponent.
 */
export interface GetComponentResult {
    readonly arn: string;
    /**
     * Change description of the component.
     */
    readonly changeDescription: string;
    /**
     * Data of the component.
     */
    readonly data: string;
    /**
     * Date the component was created.
     */
    readonly dateCreated: string;
    /**
     * Description of the component.
     */
    readonly description: string;
    /**
     * Encryption status of the component.
     */
    readonly encrypted: boolean;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * ARN of the Key Management Service (KMS) Key used to encrypt the component.
     */
    readonly kmsKeyId: string;
    /**
     * Name of the component.
     */
    readonly name: string;
    /**
     * Owner of the component.
     */
    readonly owner: string;
    /**
     * Platform of the component.
     */
    readonly platform: string;
    /**
     * Operating Systems (OSes) supported by the component.
     */
    readonly supportedOsVersions: string[];
    /**
     * Key-value map of resource tags for the component.
     */
    readonly tags: {[key: string]: string};
    /**
     * Type of the component.
     */
    readonly type: string;
    /**
     * Version of the component.
     */
    readonly version: string;
}
/**
 * Provides details about an Image Builder Component.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getComponent({
 *     arn: "arn:aws:imagebuilder:us-west-2:aws:component/amazon-cloudwatch-agent-linux/1.0.0",
 * });
 * ```
 */
export function getComponentOutput(args: GetComponentOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetComponentResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:imagebuilder/getComponent:getComponent", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getComponent.
 */
export interface GetComponentOutputArgs {
    /**
     * ARN of the component.
     */
    arn: pulumi.Input<string>;
    /**
     * Key-value map of resource tags for the component.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
