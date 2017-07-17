import * as lumi from "@lumi/lumi";
export declare class AmiFromInstance extends lumi.NamedResource implements AmiFromInstanceArgs {
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
    readonly ephemeralBlockDevice: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly amiId: string;
    readonly imageLocation: string;
    readonly kernelId: string;
    readonly manageEbsSnapshots: boolean;
    readonly amiFromInstanceName?: string;
    readonly ramdiskId: string;
    readonly rootDeviceName: string;
    readonly snapshotWithoutReboot?: boolean;
    readonly sourceInstanceId: string;
    readonly sriovNetSupport: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly virtualizationType: string;
    constructor(name: string, args: AmiFromInstanceArgs);
}
export interface AmiFromInstanceArgs {
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
    readonly ephemeralBlockDevice?: {
        deviceName: string;
        virtualName: string;
    }[];
    readonly amiFromInstanceName?: string;
    readonly snapshotWithoutReboot?: boolean;
    readonly sourceInstanceId: string;
    readonly tags?: {
        [key: string]: any;
    };
}

