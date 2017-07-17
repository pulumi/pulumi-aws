import * as lumi from "@lumi/lumi";
export declare class Snapshot extends lumi.NamedResource implements SnapshotArgs {
    readonly dataEncryptionKeyId: string;
    readonly description?: string;
    readonly encrypted: boolean;
    readonly kmsKeyId: string;
    readonly ownerAlias: string;
    readonly ownerId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly volumeId: string;
    readonly volumeSize: number;
    constructor(name: string, args: SnapshotArgs);
}
export interface SnapshotArgs {
    readonly description?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly volumeId: string;
}

