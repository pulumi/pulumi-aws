import * as lumi from "@lumi/lumi";
export declare class Ami extends lumi.NamedResource implements AmiArgs {
    readonly architecture?: string;
    readonly description?: string;
    readonly ebsBlockDevice: {
        deleteOnTermination?: boolean;
        deviceName: string;
        encrypted?: boolean;
        iops?: number;
        snapshotId?: string;
        volumeSize: number;
        volumeType?: string;
    }[];
    readonly ephemeralBlockDevice: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly amiId: string;
    readonly imageLocation: string;
    readonly kernelId?: string;
    readonly manageEbsSnapshots: boolean;
    readonly amiName?: string;
    readonly ramdiskId?: string;
    readonly rootDeviceName?: string;
    readonly sriovNetSupport?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly virtualizationType?: string;
    constructor(name: string, args: AmiArgs);
}
export interface AmiArgs {
    readonly architecture?: string;
    readonly description?: string;
    readonly ebsBlockDevice?: {
        deleteOnTermination?: boolean;
        deviceName: string;
        encrypted?: boolean;
        iops?: number;
        snapshotId?: string;
        volumeSize: number;
        volumeType?: string;
    }[];
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly imageLocation?: string;
    readonly kernelId?: string;
    readonly amiName?: string;
    readonly ramdiskId?: string;
    readonly rootDeviceName?: string;
    readonly sriovNetSupport?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly virtualizationType?: string;
}

