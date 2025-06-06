// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * `aws.route53.ResolverFirewallDomainList` Retrieves the specified firewall domain list.
 *
 * This data source allows to retrieve details about a specific a Route 53 Resolver DNS Firewall domain list.
 *
 * ## Example Usage
 *
 * The following example shows how to get a firewall domain list from its ID.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getResolverFirewallDomainList({
 *     firewallDomainListId: "rslvr-fdl-example",
 * });
 * ```
 */
export function getResolverFirewallDomainList(args: GetResolverFirewallDomainListArgs, opts?: pulumi.InvokeOptions): Promise<GetResolverFirewallDomainListResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:route53/getResolverFirewallDomainList:getResolverFirewallDomainList", {
        "firewallDomainListId": args.firewallDomainListId,
    }, opts);
}

/**
 * A collection of arguments for invoking getResolverFirewallDomainList.
 */
export interface GetResolverFirewallDomainListArgs {
    /**
     * The ID of the domain list.
     */
    firewallDomainListId: string;
}

/**
 * A collection of values returned by getResolverFirewallDomainList.
 */
export interface GetResolverFirewallDomainListResult {
    /**
     * The Amazon Resource Name (ARN) of the firewall domain list.
     */
    readonly arn: string;
    /**
     * The date and time that the domain list was created, in Unix time format and Coordinated Universal Time (UTC).
     */
    readonly creationTime: string;
    /**
     * A unique string defined by you to identify the request.
     */
    readonly creatorRequestId: string;
    /**
     * The number of domain names that are specified in the domain list.
     */
    readonly domainCount: number;
    readonly firewallDomainListId: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * The owner of the list, used only for lists that are not managed by you.
     */
    readonly managedOwnerName: string;
    /**
     * The date and time that the domain list was last modified, in Unix time format and Coordinated Universal Time (UTC).
     */
    readonly modificationTime: string;
    /**
     * The name of the domain list.
     */
    readonly name: string;
    /**
     * The status of the domain list.
     */
    readonly status: string;
    /**
     * Additional information about the status of the list, if available.
     */
    readonly statusMessage: string;
}
/**
 * `aws.route53.ResolverFirewallDomainList` Retrieves the specified firewall domain list.
 *
 * This data source allows to retrieve details about a specific a Route 53 Resolver DNS Firewall domain list.
 *
 * ## Example Usage
 *
 * The following example shows how to get a firewall domain list from its ID.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getResolverFirewallDomainList({
 *     firewallDomainListId: "rslvr-fdl-example",
 * });
 * ```
 */
export function getResolverFirewallDomainListOutput(args: GetResolverFirewallDomainListOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetResolverFirewallDomainListResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:route53/getResolverFirewallDomainList:getResolverFirewallDomainList", {
        "firewallDomainListId": args.firewallDomainListId,
    }, opts);
}

/**
 * A collection of arguments for invoking getResolverFirewallDomainList.
 */
export interface GetResolverFirewallDomainListOutputArgs {
    /**
     * The ID of the domain list.
     */
    firewallDomainListId: pulumi.Input<string>;
}
