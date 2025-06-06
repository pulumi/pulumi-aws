// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a way to check whether default EBS encryption is enabled for your AWS account in the current AWS region.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.ebs.getEncryptionByDefault({});
 * ```
 */
export function getEncryptionByDefault(opts?: pulumi.InvokeOptions): Promise<GetEncryptionByDefaultResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ebs/getEncryptionByDefault:getEncryptionByDefault", {
    }, opts);
}

/**
 * A collection of values returned by getEncryptionByDefault.
 */
export interface GetEncryptionByDefaultResult {
    /**
     * Whether or not default EBS encryption is enabled. Returns as `true` or `false`.
     */
    readonly enabled: boolean;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
}
/**
 * Provides a way to check whether default EBS encryption is enabled for your AWS account in the current AWS region.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.ebs.getEncryptionByDefault({});
 * ```
 */
export function getEncryptionByDefaultOutput(opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetEncryptionByDefaultResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ebs/getEncryptionByDefault:getEncryptionByDefault", {
    }, opts);
}
