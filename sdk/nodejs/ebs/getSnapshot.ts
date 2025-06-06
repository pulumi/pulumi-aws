// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Use this data source to get information about an EBS Snapshot for use when provisioning EBS Volumes
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ebsVolume = aws.ebs.getSnapshot({
 *     mostRecent: true,
 *     owners: ["self"],
 *     filters: [
 *         {
 *             name: "volume-size",
 *             values: ["40"],
 *         },
 *         {
 *             name: "tag:Name",
 *             values: ["Example"],
 *         },
 *     ],
 * });
 * ```
 */
export function getSnapshot(args?: GetSnapshotArgs, opts?: pulumi.InvokeOptions): Promise<GetSnapshotResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ebs/getSnapshot:getSnapshot", {
        "filters": args.filters,
        "mostRecent": args.mostRecent,
        "owners": args.owners,
        "restorableByUserIds": args.restorableByUserIds,
        "snapshotIds": args.snapshotIds,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSnapshot.
 */
export interface GetSnapshotArgs {
    /**
     * One or more name/value pairs to filter off of. There are
     * several valid keys, for a full reference, check out
     * [describe-snapshots in the AWS CLI reference][1].
     */
    filters?: inputs.ebs.GetSnapshotFilter[];
    /**
     * If more than one result is returned, use the most recent snapshot.
     */
    mostRecent?: boolean;
    /**
     * Returns the snapshots owned by the specified owner id. Multiple owners can be specified.
     */
    owners?: string[];
    /**
     * One or more AWS accounts IDs that can create volumes from the snapshot.
     */
    restorableByUserIds?: string[];
    /**
     * Returns information on a specific snapshot_id.
     */
    snapshotIds?: string[];
    /**
     * Map of tags for the resource.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getSnapshot.
 */
export interface GetSnapshotResult {
    /**
     * ARN of the EBS Snapshot.
     */
    readonly arn: string;
    /**
     * The data encryption key identifier for the snapshot.
     */
    readonly dataEncryptionKeyId: string;
    /**
     * Description for the snapshot
     */
    readonly description: string;
    /**
     * Whether the snapshot is encrypted.
     */
    readonly encrypted: boolean;
    readonly filters?: outputs.ebs.GetSnapshotFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * ARN for the KMS encryption key.
     */
    readonly kmsKeyId: string;
    readonly mostRecent?: boolean;
    /**
     * ARN of the Outpost on which the snapshot is stored.
     */
    readonly outpostArn: string;
    /**
     * Value from an Amazon-maintained list (`amazon`, `aws-marketplace`, `microsoft`) of snapshot owners.
     */
    readonly ownerAlias: string;
    /**
     * AWS account ID of the EBS snapshot owner.
     */
    readonly ownerId: string;
    readonly owners?: string[];
    readonly restorableByUserIds?: string[];
    /**
     * Snapshot ID (e.g., snap-59fcb34e).
     */
    readonly snapshotId: string;
    readonly snapshotIds?: string[];
    /**
     * Time stamp when the snapshot was initiated.
     */
    readonly startTime: string;
    /**
     * Snapshot state.
     */
    readonly state: string;
    /**
     * Storage tier in which the snapshot is stored.
     */
    readonly storageTier: string;
    /**
     * Map of tags for the resource.
     */
    readonly tags: {[key: string]: string};
    /**
     * Volume ID (e.g., vol-59fcb34e).
     */
    readonly volumeId: string;
    /**
     * Size of the drive in GiBs.
     */
    readonly volumeSize: number;
}
/**
 * Use this data source to get information about an EBS Snapshot for use when provisioning EBS Volumes
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ebsVolume = aws.ebs.getSnapshot({
 *     mostRecent: true,
 *     owners: ["self"],
 *     filters: [
 *         {
 *             name: "volume-size",
 *             values: ["40"],
 *         },
 *         {
 *             name: "tag:Name",
 *             values: ["Example"],
 *         },
 *     ],
 * });
 * ```
 */
export function getSnapshotOutput(args?: GetSnapshotOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSnapshotResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ebs/getSnapshot:getSnapshot", {
        "filters": args.filters,
        "mostRecent": args.mostRecent,
        "owners": args.owners,
        "restorableByUserIds": args.restorableByUserIds,
        "snapshotIds": args.snapshotIds,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSnapshot.
 */
export interface GetSnapshotOutputArgs {
    /**
     * One or more name/value pairs to filter off of. There are
     * several valid keys, for a full reference, check out
     * [describe-snapshots in the AWS CLI reference][1].
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ebs.GetSnapshotFilterArgs>[]>;
    /**
     * If more than one result is returned, use the most recent snapshot.
     */
    mostRecent?: pulumi.Input<boolean>;
    /**
     * Returns the snapshots owned by the specified owner id. Multiple owners can be specified.
     */
    owners?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * One or more AWS accounts IDs that can create volumes from the snapshot.
     */
    restorableByUserIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Returns information on a specific snapshot_id.
     */
    snapshotIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
