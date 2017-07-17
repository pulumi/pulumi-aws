import * as lumi from "@lumi/lumi";
export declare class Cluster extends lumi.NamedResource implements ClusterArgs {
    readonly applications?: string[];
    readonly autoscalingRole?: string;
    readonly bootstrapAction?: {
        args?: string[];
        name: string;
        path: string;
    }[];
    readonly clusterState: string;
    readonly configurations?: string;
    readonly coreInstanceCount?: number;
    readonly coreInstanceType: string;
    readonly ec2Attributes?: {
        additionalMasterSecurityGroups?: string;
        additionalSlaveSecurityGroups?: string;
        emrManagedMasterSecurityGroup?: string;
        emrManagedSlaveSecurityGroup?: string;
        instanceProfile: string;
        keyName?: string;
        serviceAccessSecurityGroup?: string;
        subnetId?: string;
    }[];
    readonly keepJobFlowAliveWhenNoSteps: boolean;
    readonly logUri?: string;
    readonly masterInstanceType: string;
    readonly masterPublicDns: string;
    readonly clusterName?: string;
    readonly releaseLabel: string;
    readonly securityConfiguration?: string;
    readonly serviceRole: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly terminationProtection: boolean;
    readonly visibleToAllUsers?: boolean;
    constructor(name: string, args: ClusterArgs);
}
export interface ClusterArgs {
    readonly applications?: string[];
    readonly autoscalingRole?: string;
    readonly bootstrapAction?: {
        args?: string[];
        name: string;
        path: string;
    }[];
    readonly configurations?: string;
    readonly coreInstanceCount?: number;
    readonly coreInstanceType?: string;
    readonly ec2Attributes?: {
        additionalMasterSecurityGroups?: string;
        additionalSlaveSecurityGroups?: string;
        emrManagedMasterSecurityGroup?: string;
        emrManagedSlaveSecurityGroup?: string;
        instanceProfile: string;
        keyName?: string;
        serviceAccessSecurityGroup?: string;
        subnetId?: string;
    }[];
    readonly keepJobFlowAliveWhenNoSteps?: boolean;
    readonly logUri?: string;
    readonly masterInstanceType: string;
    readonly clusterName?: string;
    readonly releaseLabel: string;
    readonly securityConfiguration?: string;
    readonly serviceRole: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly terminationProtection?: boolean;
    readonly visibleToAllUsers?: boolean;
}

