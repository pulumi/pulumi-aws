import * as lumi from "@lumi/lumi";
export declare class ClusterInstance extends lumi.NamedResource implements ClusterInstanceArgs {
    readonly applyImmediately: boolean;
    readonly autoMinorVersionUpgrade?: boolean;
    readonly clusterIdentifier: string;
    readonly dbParameterGroupName: string;
    readonly dbSubnetGroupName: string;
    readonly endpoint: string;
    readonly identifier: string;
    readonly identifierPrefix: string;
    readonly instanceClass: string;
    readonly kmsKeyId: string;
    readonly monitoringInterval?: number;
    readonly monitoringRoleArn: string;
    readonly port: number;
    readonly preferredBackupWindow: string;
    readonly preferredMaintenanceWindow: string;
    readonly promotionTier?: number;
    readonly publiclyAccessible?: boolean;
    readonly storageEncrypted: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly writer: boolean;
    constructor(name: string, args: ClusterInstanceArgs);
}
export interface ClusterInstanceArgs {
    readonly applyImmediately?: boolean;
    readonly autoMinorVersionUpgrade?: boolean;
    readonly clusterIdentifier: string;
    readonly dbParameterGroupName?: string;
    readonly dbSubnetGroupName?: string;
    readonly identifier?: string;
    readonly identifierPrefix?: string;
    readonly instanceClass: string;
    readonly monitoringInterval?: number;
    readonly monitoringRoleArn?: string;
    readonly preferredBackupWindow?: string;
    readonly preferredMaintenanceWindow?: string;
    readonly promotionTier?: number;
    readonly publiclyAccessible?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
}

