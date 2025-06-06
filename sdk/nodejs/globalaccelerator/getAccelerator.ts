// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides information about a Global Accelerator accelerator.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const acceleratorArn = config.get("acceleratorArn") || "";
 * const acceleratorName = config.get("acceleratorName") || "";
 * const example = aws.globalaccelerator.getAccelerator({
 *     arn: acceleratorArn,
 *     name: acceleratorName,
 * });
 * ```
 */
export function getAccelerator(args?: GetAcceleratorArgs, opts?: pulumi.InvokeOptions): Promise<GetAcceleratorResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:globalaccelerator/getAccelerator:getAccelerator", {
        "arn": args.arn,
        "id": args.id,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getAccelerator.
 */
export interface GetAcceleratorArgs {
    /**
     * Full ARN of the Global Accelerator.
     */
    arn?: string;
    id?: string;
    /**
     * Unique name of the Global Accelerator.
     *
     * > **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence.
     */
    name?: string;
}

/**
 * A collection of values returned by getAccelerator.
 */
export interface GetAcceleratorResult {
    readonly arn: string;
    readonly attributes: outputs.globalaccelerator.GetAcceleratorAttribute[];
    readonly dnsName: string;
    readonly dualStackDnsName: string;
    readonly enabled: boolean;
    readonly hostedZoneId: string;
    readonly id: string;
    readonly ipAddressType: string;
    readonly ipSets: outputs.globalaccelerator.GetAcceleratorIpSet[];
    readonly name: string;
    readonly tags: {[key: string]: string};
}
/**
 * Provides information about a Global Accelerator accelerator.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const acceleratorArn = config.get("acceleratorArn") || "";
 * const acceleratorName = config.get("acceleratorName") || "";
 * const example = aws.globalaccelerator.getAccelerator({
 *     arn: acceleratorArn,
 *     name: acceleratorName,
 * });
 * ```
 */
export function getAcceleratorOutput(args?: GetAcceleratorOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetAcceleratorResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:globalaccelerator/getAccelerator:getAccelerator", {
        "arn": args.arn,
        "id": args.id,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getAccelerator.
 */
export interface GetAcceleratorOutputArgs {
    /**
     * Full ARN of the Global Accelerator.
     */
    arn?: pulumi.Input<string>;
    id?: pulumi.Input<string>;
    /**
     * Unique name of the Global Accelerator.
     *
     * > **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence.
     */
    name?: pulumi.Input<string>;
}
