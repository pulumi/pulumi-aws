// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS VPC Lattice Service.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.vpclattice.getService({
 *     name: "example",
 * });
 * ```
 */
export function getService(args?: GetServiceArgs, opts?: pulumi.InvokeOptions): Promise<GetServiceResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:vpclattice/getService:getService", {
        "name": args.name,
        "serviceIdentifier": args.serviceIdentifier,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceArgs {
    /**
     * Service name.
     */
    name?: string;
    /**
     * ID or Amazon Resource Name (ARN) of the service.
     */
    serviceIdentifier?: string;
    /**
     * List of tags associated with the service.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getService.
 */
export interface GetServiceResult {
    /**
     * ARN of the service.
     */
    readonly arn: string;
    /**
     * Type of IAM policy. Either `NONE` or `AWS_IAM`.
     */
    readonly authType: string;
    /**
     * Amazon Resource Name (ARN) of the certificate.
     */
    readonly certificateArn: string;
    /**
     * Custom domain name of the service.
     */
    readonly customDomainName: string;
    /**
     * List of objects with DNS names.
     */
    readonly dnsEntries: outputs.vpclattice.GetServiceDnsEntry[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly name: string;
    readonly serviceIdentifier: string;
    /**
     * Status of the service.
     */
    readonly status: string;
    /**
     * List of tags associated with the service.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Data source for managing an AWS VPC Lattice Service.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.vpclattice.getService({
 *     name: "example",
 * });
 * ```
 */
export function getServiceOutput(args?: GetServiceOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetServiceResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:vpclattice/getService:getService", {
        "name": args.name,
        "serviceIdentifier": args.serviceIdentifier,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceOutputArgs {
    /**
     * Service name.
     */
    name?: pulumi.Input<string>;
    /**
     * ID or Amazon Resource Name (ARN) of the service.
     */
    serviceIdentifier?: pulumi.Input<string>;
    /**
     * List of tags associated with the service.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
