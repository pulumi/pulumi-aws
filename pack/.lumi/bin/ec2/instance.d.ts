import * as lumi from "@lumi/lumi";
import { InstanceType } from "./instanceType";
export declare class Instance extends lumi.NamedResource implements InstanceArgs {
    readonly ami: string;
    readonly associatePublicIpAddress: boolean;
    readonly availabilityZone: string;
    readonly disableApiTermination?: boolean;
    readonly ebsBlockDevice: {
        deleteOnTermination?: boolean;
        deviceName: string;
        encrypted: boolean;
        iops: number;
        snapshotId: string;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly ebsOptimized?: boolean;
    readonly ephemeralBlockDevice: {
        deviceName: string;
        noDevice?: boolean;
        virtualName?: string;
    }[];
    readonly iamInstanceProfile?: string;
    readonly instanceInitiatedShutdownBehavior?: string;
    readonly instanceState: string;
    readonly instanceType: InstanceType;
    readonly ipv6AddressCount: number;
    readonly ipv6Addresses: string[];
    readonly keyName: string;
    readonly monitoring?: boolean;
    readonly networkInterface: {
        deleteOnTermination?: boolean;
        deviceIndex: number;
        networkInterfaceId: string;
    }[];
    readonly networkInterfaceId: string;
    readonly placementGroup: string;
    readonly primaryNetworkInterfaceId: string;
    readonly privateDns: string;
    readonly privateIp: string;
    readonly publicDns: string;
    readonly publicIp: string;
    readonly rootBlockDevice: {
        deleteOnTermination?: boolean;
        iops: number;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly securityGroups: string[];
    readonly sourceDestCheck?: boolean;
    readonly subnetId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly tenancy: string;
    readonly userData?: string;
    readonly volumeTags: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds: string[];
    constructor(name: string, args: InstanceArgs);
}
export interface InstanceArgs {
    readonly ami: string;
    readonly associatePublicIpAddress?: boolean;
    readonly availabilityZone?: string;
    readonly disableApiTermination?: boolean;
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
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        noDevice?: boolean;
        virtualName?: string;
    }[];
    readonly iamInstanceProfile?: string;
    readonly instanceInitiatedShutdownBehavior?: string;
    readonly instanceType: InstanceType;
    readonly ipv6AddressCount?: number;
    readonly ipv6Addresses?: string[];
    readonly keyName?: string;
    readonly monitoring?: boolean;
    readonly networkInterface?: {
        deleteOnTermination?: boolean;
        deviceIndex: number;
        networkInterfaceId: string;
    }[];
    readonly placementGroup?: string;
    readonly privateIp?: string;
    readonly rootBlockDevice?: {
        deleteOnTermination?: boolean;
        iops: number;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly securityGroups?: string[];
    readonly sourceDestCheck?: boolean;
    readonly subnetId?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly tenancy?: string;
    readonly userData?: string;
    readonly volumeTags?: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds?: string[];
}

