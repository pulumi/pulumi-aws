// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides information about a MemoryDB ACL.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.memorydb.getAcl({
 *     name: "my-acl",
 * });
 * ```
 */
export function getAcl(args: GetAclArgs, opts?: pulumi.InvokeOptions): Promise<GetAclResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:memorydb/getAcl:getAcl", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getAcl.
 */
export interface GetAclArgs {
    /**
     * Name of the ACL.
     */
    name: string;
    /**
     * Map of tags assigned to the ACL.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getAcl.
 */
export interface GetAclResult {
    /**
     * ARN of the ACL.
     */
    readonly arn: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * The minimum engine version supported by the ACL.
     */
    readonly minimumEngineVersion: string;
    readonly name: string;
    /**
     * Map of tags assigned to the ACL.
     */
    readonly tags: {[key: string]: string};
    /**
     * Set of MemoryDB user names included in this ACL.
     */
    readonly userNames: string[];
}
/**
 * Provides information about a MemoryDB ACL.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.memorydb.getAcl({
 *     name: "my-acl",
 * });
 * ```
 */
export function getAclOutput(args: GetAclOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetAclResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:memorydb/getAcl:getAcl", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getAcl.
 */
export interface GetAclOutputArgs {
    /**
     * Name of the ACL.
     */
    name: pulumi.Input<string>;
    /**
     * Map of tags assigned to the ACL.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
