import * as lumi from "@lumi/lumi";
export declare class Domain extends lumi.NamedResource implements DomainArgs {
    readonly accessPolicies: string;
    readonly advancedOptions: {
        [key: string]: any;
    };
    readonly arn: string;
    readonly clusterConfig: {
        dedicatedMasterCount?: number;
        dedicatedMasterEnabled?: boolean;
        dedicatedMasterType?: string;
        instanceCount?: number;
        instanceType?: string;
        zoneAwarenessEnabled?: boolean;
    }[];
    readonly domainId: string;
    readonly domainName: string;
    readonly ebsOptions: {
        ebsEnabled: boolean;
        iops?: number;
        volumeSize?: number;
        volumeType: string;
    }[];
    readonly elasticsearchVersion?: string;
    readonly endpoint: string;
    readonly snapshotOptions?: {
        automatedSnapshotStartHour: number;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: DomainArgs);
}
export interface DomainArgs {
    readonly accessPolicies?: string;
    readonly advancedOptions?: {
        [key: string]: any;
    };
    readonly clusterConfig?: {
        dedicatedMasterCount?: number;
        dedicatedMasterEnabled?: boolean;
        dedicatedMasterType?: string;
        instanceCount?: number;
        instanceType?: string;
        zoneAwarenessEnabled?: boolean;
    }[];
    readonly domainName: string;
    readonly ebsOptions?: {
        ebsEnabled: boolean;
        iops?: number;
        volumeSize?: number;
        volumeType: string;
    }[];
    readonly elasticsearchVersion?: string;
    readonly snapshotOptions?: {
        automatedSnapshotStartHour: number;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
}

