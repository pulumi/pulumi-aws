// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Use this data source to get information about a DB Snapshot for use when provisioning DB instances
 *
 * > **NOTE:** This data source does not apply to snapshots created on Aurora DB clusters.
 * See the `aws.rds.ClusterSnapshot` data source for DB Cluster snapshots.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const prod = new aws.rds.Instance("prod", {
 *     allocatedStorage: 10,
 *     engine: "mysql",
 *     engineVersion: "5.6.17",
 *     instanceClass: aws.rds.InstanceType.T2_Micro,
 *     dbName: "mydb",
 *     username: "foo",
 *     password: "bar",
 *     dbSubnetGroupName: "my_database_subnet_group",
 *     parameterGroupName: "default.mysql5.6",
 * });
 * const latestProdSnapshot = aws.rds.getSnapshotOutput({
 *     dbInstanceIdentifier: prod.identifier,
 *     mostRecent: true,
 * });
 * // Use the latest production snapshot to create a dev instance.
 * const dev = new aws.rds.Instance("dev", {
 *     instanceClass: aws.rds.InstanceType.T2_Micro,
 *     dbName: "mydbdev",
 *     snapshotIdentifier: latestProdSnapshot.apply(latestProdSnapshot => latestProdSnapshot.id),
 * });
 * ```
 */
export function getSnapshot(args?: GetSnapshotArgs, opts?: pulumi.InvokeOptions): Promise<GetSnapshotResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:rds/getSnapshot:getSnapshot", {
        "dbInstanceIdentifier": args.dbInstanceIdentifier,
        "dbSnapshotIdentifier": args.dbSnapshotIdentifier,
        "includePublic": args.includePublic,
        "includeShared": args.includeShared,
        "mostRecent": args.mostRecent,
        "snapshotType": args.snapshotType,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSnapshot.
 */
export interface GetSnapshotArgs {
    /**
     * Returns the list of snapshots created by the specific db_instance
     */
    dbInstanceIdentifier?: string;
    /**
     * Returns information on a specific snapshot_id.
     */
    dbSnapshotIdentifier?: string;
    /**
     * Set this value to true to include manual DB snapshots that are public and can be
     * copied or restored by any AWS account, otherwise set this value to false. The default is `false`.
     */
    includePublic?: boolean;
    /**
     * Set this value to true to include shared manual DB snapshots from other
     * AWS accounts that this AWS account has been given permission to copy or restore, otherwise set this value to false.
     * The default is `false`.
     */
    includeShared?: boolean;
    /**
     * If more than one result is returned, use the most
     * recent Snapshot.
     */
    mostRecent?: boolean;
    /**
     * Type of snapshots to be returned. If you don't specify a SnapshotType
     * value, then both automated and manual snapshots are returned. Shared and public DB snapshots are not
     * included in the returned results by default. Possible values are, `automated`, `manual`, `shared`, `public` and `awsbackup`.
     */
    snapshotType?: string;
    /**
     * Mapping of tags, each pair of which must exactly match
     * a pair on the desired DB snapshot.
     *
     * > **NOTE:** One of either `dbInstanceIdentifier` or `dbSnapshotIdentifier` is required.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getSnapshot.
 */
export interface GetSnapshotResult {
    /**
     * Allocated storage size in gigabytes (GB).
     */
    readonly allocatedStorage: number;
    /**
     * Name of the Availability Zone the DB instance was located in at the time of the DB snapshot.
     */
    readonly availabilityZone: string;
    readonly dbInstanceIdentifier?: string;
    /**
     * ARN for the DB snapshot.
     */
    readonly dbSnapshotArn: string;
    readonly dbSnapshotIdentifier?: string;
    /**
     * Whether the DB snapshot is encrypted.
     */
    readonly encrypted: boolean;
    /**
     * Name of the database engine.
     */
    readonly engine: string;
    /**
     * Version of the database engine.
     */
    readonly engineVersion: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly includePublic?: boolean;
    readonly includeShared?: boolean;
    /**
     * Provisioned IOPS (I/O operations per second) value of the DB instance at the time of the snapshot.
     */
    readonly iops: number;
    /**
     * ARN for the KMS encryption key.
     */
    readonly kmsKeyId: string;
    /**
     * License model information for the restored DB instance.
     */
    readonly licenseModel: string;
    readonly mostRecent?: boolean;
    /**
     * Provides the option group name for the DB snapshot.
     */
    readonly optionGroupName: string;
    /**
     * Provides the time when the snapshot was taken, in Universal Coordinated Time (UTC). Doesn't change when the snapshot is copied.
     */
    readonly originalSnapshotCreateTime: string;
    readonly port: number;
    /**
     * Provides the time when the snapshot was taken, in Universal Coordinated Time (UTC). Changes for the copy when the snapshot is copied.
     */
    readonly snapshotCreateTime: string;
    readonly snapshotType?: string;
    /**
     * DB snapshot ARN that the DB snapshot was copied from. It only has value in case of cross customer or cross region copy.
     */
    readonly sourceDbSnapshotIdentifier: string;
    /**
     * Region that the DB snapshot was created in or copied from.
     */
    readonly sourceRegion: string;
    /**
     * Status of this DB snapshot.
     */
    readonly status: string;
    /**
     * Storage type associated with DB snapshot.
     */
    readonly storageType: string;
    readonly tags: {[key: string]: string};
    /**
     * ID of the VPC associated with the DB snapshot.
     */
    readonly vpcId: string;
}
/**
 * Use this data source to get information about a DB Snapshot for use when provisioning DB instances
 *
 * > **NOTE:** This data source does not apply to snapshots created on Aurora DB clusters.
 * See the `aws.rds.ClusterSnapshot` data source for DB Cluster snapshots.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const prod = new aws.rds.Instance("prod", {
 *     allocatedStorage: 10,
 *     engine: "mysql",
 *     engineVersion: "5.6.17",
 *     instanceClass: aws.rds.InstanceType.T2_Micro,
 *     dbName: "mydb",
 *     username: "foo",
 *     password: "bar",
 *     dbSubnetGroupName: "my_database_subnet_group",
 *     parameterGroupName: "default.mysql5.6",
 * });
 * const latestProdSnapshot = aws.rds.getSnapshotOutput({
 *     dbInstanceIdentifier: prod.identifier,
 *     mostRecent: true,
 * });
 * // Use the latest production snapshot to create a dev instance.
 * const dev = new aws.rds.Instance("dev", {
 *     instanceClass: aws.rds.InstanceType.T2_Micro,
 *     dbName: "mydbdev",
 *     snapshotIdentifier: latestProdSnapshot.apply(latestProdSnapshot => latestProdSnapshot.id),
 * });
 * ```
 */
export function getSnapshotOutput(args?: GetSnapshotOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSnapshotResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:rds/getSnapshot:getSnapshot", {
        "dbInstanceIdentifier": args.dbInstanceIdentifier,
        "dbSnapshotIdentifier": args.dbSnapshotIdentifier,
        "includePublic": args.includePublic,
        "includeShared": args.includeShared,
        "mostRecent": args.mostRecent,
        "snapshotType": args.snapshotType,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSnapshot.
 */
export interface GetSnapshotOutputArgs {
    /**
     * Returns the list of snapshots created by the specific db_instance
     */
    dbInstanceIdentifier?: pulumi.Input<string>;
    /**
     * Returns information on a specific snapshot_id.
     */
    dbSnapshotIdentifier?: pulumi.Input<string>;
    /**
     * Set this value to true to include manual DB snapshots that are public and can be
     * copied or restored by any AWS account, otherwise set this value to false. The default is `false`.
     */
    includePublic?: pulumi.Input<boolean>;
    /**
     * Set this value to true to include shared manual DB snapshots from other
     * AWS accounts that this AWS account has been given permission to copy or restore, otherwise set this value to false.
     * The default is `false`.
     */
    includeShared?: pulumi.Input<boolean>;
    /**
     * If more than one result is returned, use the most
     * recent Snapshot.
     */
    mostRecent?: pulumi.Input<boolean>;
    /**
     * Type of snapshots to be returned. If you don't specify a SnapshotType
     * value, then both automated and manual snapshots are returned. Shared and public DB snapshots are not
     * included in the returned results by default. Possible values are, `automated`, `manual`, `shared`, `public` and `awsbackup`.
     */
    snapshotType?: pulumi.Input<string>;
    /**
     * Mapping of tags, each pair of which must exactly match
     * a pair on the desired DB snapshot.
     *
     * > **NOTE:** One of either `dbInstanceIdentifier` or `dbSnapshotIdentifier` is required.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
