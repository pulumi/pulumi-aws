import * as lumi from "@lumi/lumi";
export declare class ReplicationGroup extends lumi.NamedResource implements ReplicationGroupArgs {
    readonly applyImmediately: boolean;
    readonly autoMinorVersionUpgrade?: boolean;
    readonly automaticFailoverEnabled?: boolean;
    readonly availabilityZones?: string[];
    readonly clusterMode?: {
        numNodeGroups: number;
        replicasPerNodeGroup: number;
    }[];
    readonly configurationEndpointAddress: string;
    readonly engine?: string;
    readonly engineVersion: string;
    readonly maintenanceWindow: string;
    readonly nodeType: string;
    readonly notificationTopicArn?: string;
    readonly numberCacheClusters: number;
    readonly parameterGroupName: string;
    readonly port: number;
    readonly primaryEndpointAddress: string;
    readonly replicationGroupDescription: string;
    readonly replicationGroupId: string;
    readonly securityGroupIds: string[];
    readonly securityGroupNames: string[];
    readonly snapshotArns?: string[];
    readonly snapshotName?: string;
    readonly snapshotRetentionLimit?: number;
    readonly snapshotWindow: string;
    readonly subnetGroupName: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: ReplicationGroupArgs);
}
export interface ReplicationGroupArgs {
    readonly applyImmediately?: boolean;
    readonly autoMinorVersionUpgrade?: boolean;
    readonly automaticFailoverEnabled?: boolean;
    readonly availabilityZones?: string[];
    readonly clusterMode?: {
        numNodeGroups: number;
        replicasPerNodeGroup: number;
    }[];
    readonly engine?: string;
    readonly engineVersion?: string;
    readonly maintenanceWindow?: string;
    readonly nodeType: string;
    readonly notificationTopicArn?: string;
    readonly numberCacheClusters?: number;
    readonly parameterGroupName?: string;
    readonly port: number;
    readonly replicationGroupDescription: string;
    readonly replicationGroupId: string;
    readonly securityGroupIds?: string[];
    readonly securityGroupNames?: string[];
    readonly snapshotArns?: string[];
    readonly snapshotName?: string;
    readonly snapshotRetentionLimit?: number;
    readonly snapshotWindow?: string;
    readonly subnetGroupName?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

