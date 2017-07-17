import * as lumi from "@lumi/lumi";
export declare class Cluster extends lumi.NamedResource implements ClusterArgs {
    readonly applyImmediately: boolean;
    readonly availabilityZones: string[];
    readonly backupRetentionPeriod?: number;
    readonly clusterIdentifier: string;
    readonly clusterIdentifierPrefix: string;
    readonly clusterMembers: string[];
    readonly clusterResourceId: string;
    readonly databaseName: string;
    readonly dbClusterParameterGroupName: string;
    readonly dbSubnetGroupName: string;
    readonly endpoint: string;
    readonly engine: string;
    readonly finalSnapshotIdentifier?: string;
    readonly iamDatabaseAuthenticationEnabled?: boolean;
    readonly kmsKeyId: string;
    readonly masterPassword?: string;
    readonly masterUsername: string;
    readonly port: number;
    readonly preferredBackupWindow: string;
    readonly preferredMaintenanceWindow: string;
    readonly readerEndpoint: string;
    readonly replicationSourceIdentifier?: string;
    readonly skipFinalSnapshot?: boolean;
    readonly snapshotIdentifier?: string;
    readonly storageEncrypted?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds: string[];
    constructor(name: string, args: ClusterArgs);
}
export interface ClusterArgs {
    readonly applyImmediately?: boolean;
    readonly availabilityZones?: string[];
    readonly backupRetentionPeriod?: number;
    readonly clusterIdentifier?: string;
    readonly clusterIdentifierPrefix?: string;
    readonly clusterMembers?: string[];
    readonly databaseName?: string;
    readonly dbClusterParameterGroupName?: string;
    readonly dbSubnetGroupName?: string;
    readonly finalSnapshotIdentifier?: string;
    readonly iamDatabaseAuthenticationEnabled?: boolean;
    readonly kmsKeyId?: string;
    readonly masterPassword?: string;
    readonly masterUsername?: string;
    readonly port?: number;
    readonly preferredBackupWindow?: string;
    readonly preferredMaintenanceWindow?: string;
    readonly replicationSourceIdentifier?: string;
    readonly skipFinalSnapshot?: boolean;
    readonly snapshotIdentifier?: string;
    readonly storageEncrypted?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds?: string[];
}

