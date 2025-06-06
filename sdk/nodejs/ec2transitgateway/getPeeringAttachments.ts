// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Get information on EC2 Transit Gateway Peering Attachments.
 *
 * ## Example Usage
 *
 * ### All Resources
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.ec2transitgateway.getPeeringAttachments({});
 * ```
 *
 * ### By Filter
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const filtered = aws.ec2transitgateway.getPeeringAttachments({
 *     filters: [{
 *         name: "state",
 *         values: ["pendingAcceptance"],
 *     }],
 * });
 * const unit = .map(__index => (aws.ec2transitgateway.getPeeringAttachment({
 *     id: _arg0_.ids[__index],
 * })));
 * ```
 */
export function getPeeringAttachments(args?: GetPeeringAttachmentsArgs, opts?: pulumi.InvokeOptions): Promise<GetPeeringAttachmentsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ec2transitgateway/getPeeringAttachments:getPeeringAttachments", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getPeeringAttachments.
 */
export interface GetPeeringAttachmentsArgs {
    /**
     * One or more configuration blocks containing name-values filters. Detailed below.
     */
    filters?: inputs.ec2transitgateway.GetPeeringAttachmentsFilter[];
}

/**
 * A collection of values returned by getPeeringAttachments.
 */
export interface GetPeeringAttachmentsResult {
    readonly filters?: outputs.ec2transitgateway.GetPeeringAttachmentsFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * A list of all attachments ids matching the filter. You can retrieve more information about the attachment using the [aws.ec2transitgateway.PeeringAttachment][2] data source, searching by identifier.
     */
    readonly ids: string[];
}
/**
 * Get information on EC2 Transit Gateway Peering Attachments.
 *
 * ## Example Usage
 *
 * ### All Resources
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = aws.ec2transitgateway.getPeeringAttachments({});
 * ```
 *
 * ### By Filter
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const filtered = aws.ec2transitgateway.getPeeringAttachments({
 *     filters: [{
 *         name: "state",
 *         values: ["pendingAcceptance"],
 *     }],
 * });
 * const unit = .map(__index => (aws.ec2transitgateway.getPeeringAttachment({
 *     id: _arg0_.ids[__index],
 * })));
 * ```
 */
export function getPeeringAttachmentsOutput(args?: GetPeeringAttachmentsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetPeeringAttachmentsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ec2transitgateway/getPeeringAttachments:getPeeringAttachments", {
        "filters": args.filters,
    }, opts);
}

/**
 * A collection of arguments for invoking getPeeringAttachments.
 */
export interface GetPeeringAttachmentsOutputArgs {
    /**
     * One or more configuration blocks containing name-values filters. Detailed below.
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ec2transitgateway.GetPeeringAttachmentsFilterArgs>[]>;
}
