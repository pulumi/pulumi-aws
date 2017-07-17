import * as lumi from "@lumi/lumi";
export declare class InstanceGroup extends lumi.NamedResource implements InstanceGroupArgs {
    readonly clusterId: string;
    readonly ebsConfig?: {
        iops?: number;
        size: number;
        type: string;
        volumesPerInstance?: number;
    }[];
    readonly ebsOptimized?: boolean;
    readonly instanceCount?: number;
    readonly instanceType: string;
    readonly instanceGroupName?: string;
    readonly runningInstanceCount: number;
    readonly status: string;
    constructor(name: string, args: InstanceGroupArgs);
}
export interface InstanceGroupArgs {
    readonly clusterId: string;
    readonly ebsConfig?: {
        iops?: number;
        size: number;
        type: string;
        volumesPerInstance?: number;
    }[];
    readonly ebsOptimized?: boolean;
    readonly instanceCount?: number;
    readonly instanceType: string;
    readonly instanceGroupName?: string;
}

