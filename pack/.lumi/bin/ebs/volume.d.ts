import * as lumi from "@lumi/lumi";
export declare class Volume extends lumi.NamedResource implements VolumeArgs {
    readonly availabilityZone: string;
    readonly encrypted: boolean;
    readonly iops: number;
    readonly kmsKeyId: string;
    readonly size: number;
    readonly snapshotId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
    constructor(name: string, args: VolumeArgs);
}
export interface VolumeArgs {
    readonly availabilityZone: string;
    readonly encrypted?: boolean;
    readonly iops?: number;
    readonly kmsKeyId?: string;
    readonly size?: number;
    readonly snapshotId?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type?: string;
}

