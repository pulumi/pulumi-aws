import * as lumi from "@lumi/lumi";
export declare class SpotFleetRequest extends lumi.NamedResource implements SpotFleetRequestArgs {
    readonly allocationStrategy?: string;
    readonly clientToken: string;
    readonly excessCapacityTerminationPolicy?: string;
    readonly iamFleetRole: string;
    readonly launchSpecification: {
        ami: string;
        associatePublicIpAddress?: boolean;
        availabilityZone: string;
        ebsBlockDevice: {
            deleteOnTermination?: boolean;
            deviceName: string;
            encrypted: boolean;
            iops: number;
            snapshotId: string;
            volumeSize: number;
            volumeType: string;
        }[];
        ebsOptimized?: boolean;
        ephemeralBlockDevice: {
            deviceName: string;
            virtualName: string;
        }[];
        iamInstanceProfile?: string;
        instanceType: string;
        keyName: string;
        monitoring?: boolean;
        placementGroup: string;
        placementTenancy?: string;
        rootBlockDevice: {
            deleteOnTermination?: boolean;
            iops: number;
            volumeSize: number;
            volumeType: string;
        }[];
        spotPrice?: string;
        subnetId: string;
        userData?: string;
        vpcSecurityGroupIds: string[];
        weightedCapacity?: string;
    }[];
    readonly replaceUnhealthyInstances?: boolean;
    readonly spotPrice: string;
    readonly spotRequestState: string;
    readonly targetCapacity: number;
    readonly terminateInstancesWithExpiration?: boolean;
    readonly validFrom?: string;
    readonly validUntil?: string;
    constructor(name: string, args: SpotFleetRequestArgs);
}
export interface SpotFleetRequestArgs {
    readonly allocationStrategy?: string;
    readonly excessCapacityTerminationPolicy?: string;
    readonly iamFleetRole: string;
    readonly launchSpecification: {
        ami: string;
        associatePublicIpAddress?: boolean;
        availabilityZone: string;
        ebsBlockDevice: {
            deleteOnTermination?: boolean;
            deviceName: string;
            encrypted: boolean;
            iops: number;
            snapshotId: string;
            volumeSize: number;
            volumeType: string;
        }[];
        ebsOptimized?: boolean;
        ephemeralBlockDevice: {
            deviceName: string;
            virtualName: string;
        }[];
        iamInstanceProfile?: string;
        instanceType: string;
        keyName: string;
        monitoring?: boolean;
        placementGroup: string;
        placementTenancy?: string;
        rootBlockDevice: {
            deleteOnTermination?: boolean;
            iops: number;
            volumeSize: number;
            volumeType: string;
        }[];
        spotPrice?: string;
        subnetId: string;
        userData?: string;
        vpcSecurityGroupIds: string[];
        weightedCapacity?: string;
    }[];
    readonly replaceUnhealthyInstances?: boolean;
    readonly spotPrice: string;
    readonly targetCapacity: number;
    readonly terminateInstancesWithExpiration?: boolean;
    readonly validFrom?: string;
    readonly validUntil?: string;
}

