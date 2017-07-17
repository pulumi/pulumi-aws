import * as lumi from "@lumi/lumi";
export declare class LaunchConfiguration extends lumi.NamedResource implements LaunchConfigurationArgs {
    readonly associatePublicIpAddress?: boolean;
    readonly ebsBlockDevice: {
        deleteOnTermination?: boolean;
        deviceName: string;
        encrypted: boolean;
        iops: number;
        snapshotId: string;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly ebsOptimized: boolean;
    readonly enableMonitoring?: boolean;
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly iamInstanceProfile?: string;
    readonly imageId: string;
    readonly instanceType: string;
    readonly keyName: string;
    readonly launchConfigurationName: string;
    readonly namePrefix?: string;
    readonly placementTenancy?: string;
    readonly rootBlockDevice: {
        deleteOnTermination?: boolean;
        iops: number;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly securityGroups?: string[];
    readonly spotPrice?: string;
    readonly userData?: string;
    readonly vpcClassicLinkId?: string;
    readonly vpcClassicLinkSecurityGroups?: string[];
    constructor(name: string, args: LaunchConfigurationArgs);
}
export interface LaunchConfigurationArgs {
    readonly associatePublicIpAddress?: boolean;
    readonly ebsBlockDevice?: {
        deleteOnTermination?: boolean;
        deviceName: string;
        encrypted: boolean;
        iops: number;
        snapshotId: string;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly ebsOptimized?: boolean;
    readonly enableMonitoring?: boolean;
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly iamInstanceProfile?: string;
    readonly imageId: string;
    readonly instanceType: string;
    readonly keyName?: string;
    readonly launchConfigurationName?: string;
    readonly namePrefix?: string;
    readonly placementTenancy?: string;
    readonly rootBlockDevice?: {
        deleteOnTermination?: boolean;
        iops: number;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly securityGroups?: string[];
    readonly spotPrice?: string;
    readonly userData?: string;
    readonly vpcClassicLinkId?: string;
    readonly vpcClassicLinkSecurityGroups?: string[];
}

