import * as lumi from "@lumi/lumi";
export declare class SnapshotCreateVolumePermission extends lumi.NamedResource implements SnapshotCreateVolumePermissionArgs {
    readonly accountId: string;
    readonly snapshotId: string;
    constructor(name: string, args: SnapshotCreateVolumePermissionArgs);
}
export interface SnapshotCreateVolumePermissionArgs {
    readonly accountId: string;
    readonly snapshotId: string;
}

