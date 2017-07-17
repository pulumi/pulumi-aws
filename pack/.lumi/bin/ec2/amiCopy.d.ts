import * as lumi from "@lumi/lumi";
export declare class AmiCopy extends lumi.NamedResource implements AmiCopyArgs {
    readonly architecture: string;
    readonly description?: string;
    readonly ebsBlockDevice: {
        deleteOnTermination: boolean;
        deviceName: string;
        encrypted: boolean;
        iops: number;
        snapshotId: string;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly encrypted?: boolean;
    readonly ephemeralBlockDevice: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly amiId: string;
    readonly imageLocation: string;
    readonly kernelId: string;
    readonly kmsKeyId: string;
    readonly manageEbsSnapshots: boolean;
    readonly amiCopyName?: string;
    readonly ramdiskId: string;
    readonly rootDeviceName: string;
    readonly sourceAmiId: string;
    readonly sourceAmiRegion: string;
    readonly sriovNetSupport: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly virtualizationType: string;
    constructor(name: string, args: AmiCopyArgs);
}
export interface AmiCopyArgs {
    readonly description?: string;
    readonly ebsBlockDevice?: {
        deleteOnTermination: boolean;
        deviceName: string;
        encrypted: boolean;
        iops: number;
        snapshotId: string;
        volumeSize: number;
        volumeType: string;
    }[];
    readonly encrypted?: boolean;
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly kmsKeyId?: string;
    readonly amiCopyName?: string;
    readonly sourceAmiId: string;
    readonly sourceAmiRegion: string;
    readonly tags?: {
        [key: string]: any;
    };
}

