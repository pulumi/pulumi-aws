import * as lumi from "@lumi/lumi";
export declare class Snapshot extends lumi.NamedResource implements SnapshotArgs {
    readonly allocatedStorage: number;
    readonly availabilityZone: string;
    readonly dbInstanceIdentifier: string;
    readonly dbSnapshotArn: string;
    readonly dbSnapshotIdentifier: string;
    readonly encrypted: boolean;
    readonly engine: string;
    readonly engineVersion: string;
    readonly iops: number;
    readonly kmsKeyId: string;
    readonly licenseModel: string;
    readonly optionGroupName: string;
    readonly port: number;
    readonly snapshotType: string;
    readonly sourceDbSnapshotIdentifier: string;
    readonly sourceRegion: string;
    readonly status: string;
    readonly storageType: string;
    readonly vpcId: string;
    constructor(name: string, args: SnapshotArgs);
}
export interface SnapshotArgs {
    readonly dbInstanceIdentifier: string;
    readonly dbSnapshotIdentifier: string;
}

