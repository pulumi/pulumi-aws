import * as lumi from "@lumi/lumi";
export declare class Cluster extends lumi.NamedResource implements ClusterArgs {
    readonly applyImmediately: boolean;
    readonly availabilityZone: string;
    readonly availabilityZones?: string[];
    readonly azMode: string;
    readonly cacheNodes: {
        address: string;
        availabilityZone: string;
        id: string;
        port: number;
    }[];
    readonly clusterAddress: string;
    readonly clusterId: string;
    readonly configurationEndpoint: string;
    readonly engine: string;
    readonly engineVersion: string;
    readonly maintenanceWindow: string;
    readonly nodeType: string;
    readonly notificationTopicArn?: string;
    readonly numCacheNodes: number;
    readonly parameterGroupName: string;
    readonly port: number;
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
    constructor(name: string, args: ClusterArgs);
}
export interface ClusterArgs {
    readonly applyImmediately?: boolean;
    readonly availabilityZone?: string;
    readonly availabilityZones?: string[];
    readonly azMode?: string;
    readonly clusterId: string;
    readonly engine: string;
    readonly engineVersion?: string;
    readonly maintenanceWindow?: string;
    readonly nodeType: string;
    readonly notificationTopicArn?: string;
    readonly numCacheNodes: number;
    readonly parameterGroupName?: string;
    readonly port: number;
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

