// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Retrieve information about a firewall policy.
 *
 * ## Example Usage
 *
 * ### Find firewall policy by name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     name: firewallPolicyName,
 * });
 * ```
 *
 * ### Find firewall policy by ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     arn: firewallPolicyArn,
 * });
 * ```
 *
 * ### Find firewall policy by name and ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     arn: firewallPolicyArn,
 *     name: firewallPolicyName,
 * });
 * ```
 *
 * AWS Network Firewall does not allow multiple firewall policies with the same name to be created in an account. It is possible, however, to have multiple firewall policies available in a single account with identical `name` values but distinct `arn` values, e.g. firewall policies shared via a [Resource Access Manager (RAM) share][1]. In that case specifying `arn`, or `name` and `arn`, is recommended.
 *
 * > **Note:** If there are multiple firewall policies in an account with the same `name`, and `arn` is not specified, the default behavior will return the firewall policy with `name` that was created in the account.
 */
export function getFirewallPolicy(args?: GetFirewallPolicyArgs, opts?: pulumi.InvokeOptions): Promise<GetFirewallPolicyResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:networkfirewall/getFirewallPolicy:getFirewallPolicy", {
        "arn": args.arn,
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getFirewallPolicy.
 */
export interface GetFirewallPolicyArgs {
    /**
     * ARN of the firewall policy.
     */
    arn?: string;
    /**
     * Descriptive name of the firewall policy.
     *
     * One or more of these arguments is required.
     */
    name?: string;
    /**
     * Key-value tags for the firewall policy.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getFirewallPolicy.
 */
export interface GetFirewallPolicyResult {
    readonly arn?: string;
    /**
     * Description of the firewall policy.
     */
    readonly description: string;
    /**
     * The [policy][2] for the specified firewall policy.
     */
    readonly firewallPolicies: outputs.networkfirewall.GetFirewallPolicyFirewallPolicy[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly name?: string;
    /**
     * Key-value tags for the firewall policy.
     */
    readonly tags: {[key: string]: string};
    /**
     * Token used for optimistic locking.
     */
    readonly updateToken: string;
}
/**
 * Retrieve information about a firewall policy.
 *
 * ## Example Usage
 *
 * ### Find firewall policy by name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     name: firewallPolicyName,
 * });
 * ```
 *
 * ### Find firewall policy by ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     arn: firewallPolicyArn,
 * });
 * ```
 *
 * ### Find firewall policy by name and ARN
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.networkfirewall.getFirewallPolicy({
 *     arn: firewallPolicyArn,
 *     name: firewallPolicyName,
 * });
 * ```
 *
 * AWS Network Firewall does not allow multiple firewall policies with the same name to be created in an account. It is possible, however, to have multiple firewall policies available in a single account with identical `name` values but distinct `arn` values, e.g. firewall policies shared via a [Resource Access Manager (RAM) share][1]. In that case specifying `arn`, or `name` and `arn`, is recommended.
 *
 * > **Note:** If there are multiple firewall policies in an account with the same `name`, and `arn` is not specified, the default behavior will return the firewall policy with `name` that was created in the account.
 */
export function getFirewallPolicyOutput(args?: GetFirewallPolicyOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetFirewallPolicyResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:networkfirewall/getFirewallPolicy:getFirewallPolicy", {
        "arn": args.arn,
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getFirewallPolicy.
 */
export interface GetFirewallPolicyOutputArgs {
    /**
     * ARN of the firewall policy.
     */
    arn?: pulumi.Input<string>;
    /**
     * Descriptive name of the firewall policy.
     *
     * One or more of these arguments is required.
     */
    name?: pulumi.Input<string>;
    /**
     * Key-value tags for the firewall policy.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
