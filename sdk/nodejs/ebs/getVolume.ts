// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Use this data source to get information about an EBS volume for use in other
 * resources.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ebsVolume = aws.ebs.getVolume({
 *     mostRecent: true,
 *     filters: [
 *         {
 *             name: "volume-type",
 *             values: ["gp2"],
 *         },
 *         {
 *             name: "tag:Name",
 *             values: ["Example"],
 *         },
 *     ],
 * });
 * ```
 */
export function getVolume(args?: GetVolumeArgs, opts?: pulumi.InvokeOptions): Promise<GetVolumeResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ebs/getVolume:getVolume", {
        "filters": args.filters,
        "mostRecent": args.mostRecent,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getVolume.
 */
export interface GetVolumeArgs {
    /**
     * One or more name/value pairs to filter off of. There are
     * several valid keys, for a full reference, check out
     * [describe-volumes in the AWS CLI reference][1].
     */
    filters?: inputs.ebs.GetVolumeFilter[];
    /**
     * If more than one result is returned, use the most
     * recent volume.
     */
    mostRecent?: boolean;
    /**
     * Map of tags for the resource.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getVolume.
 */
export interface GetVolumeResult {
    /**
     * Volume ARN (e.g., arn:aws:ec2:us-east-1:123456789012:volume/vol-59fcb34e).
     */
    readonly arn: string;
    /**
     * Availability zone where the EBS volume exists.
     */
    readonly availabilityZone: string;
    /**
     * Timestamp when volume creation was initiated.
     */
    readonly createTime: string;
    /**
     * Whether the disk is encrypted.
     */
    readonly encrypted: boolean;
    readonly filters?: outputs.ebs.GetVolumeFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Amount of IOPS for the disk.
     */
    readonly iops: number;
    /**
     * ARN for the KMS encryption key.
     */
    readonly kmsKeyId: string;
    readonly mostRecent?: boolean;
    /**
     * (Optional) Specifies whether Amazon EBS Multi-Attach is enabled.
     */
    readonly multiAttachEnabled: boolean;
    /**
     * ARN of the Outpost.
     */
    readonly outpostArn: string;
    /**
     * Size of the drive in GiBs.
     */
    readonly size: number;
    /**
     * Snapshot_id the EBS volume is based off.
     */
    readonly snapshotId: string;
    /**
     * Map of tags for the resource.
     */
    readonly tags: {[key: string]: string};
    /**
     * Throughput that the volume supports, in MiB/s.
     */
    readonly throughput: number;
    /**
     * Volume ID (e.g., vol-59fcb34e).
     */
    readonly volumeId: string;
    /**
     * Type of EBS volume.
     */
    readonly volumeType: string;
}
/**
 * Use this data source to get information about an EBS volume for use in other
 * resources.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ebsVolume = aws.ebs.getVolume({
 *     mostRecent: true,
 *     filters: [
 *         {
 *             name: "volume-type",
 *             values: ["gp2"],
 *         },
 *         {
 *             name: "tag:Name",
 *             values: ["Example"],
 *         },
 *     ],
 * });
 * ```
 */
export function getVolumeOutput(args?: GetVolumeOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetVolumeResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ebs/getVolume:getVolume", {
        "filters": args.filters,
        "mostRecent": args.mostRecent,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getVolume.
 */
export interface GetVolumeOutputArgs {
    /**
     * One or more name/value pairs to filter off of. There are
     * several valid keys, for a full reference, check out
     * [describe-volumes in the AWS CLI reference][1].
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ebs.GetVolumeFilterArgs>[]>;
    /**
     * If more than one result is returned, use the most
     * recent volume.
     */
    mostRecent?: pulumi.Input<boolean>;
    /**
     * Map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
