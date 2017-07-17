import * as lumi from "@lumi/lumi";
export declare class VolumeAttachment extends lumi.NamedResource implements VolumeAttachmentArgs {
    readonly deviceName: string;
    readonly forceDetach: boolean;
    readonly instanceId: string;
    readonly skipDestroy: boolean;
    readonly volumeId: string;
    constructor(name: string, args: VolumeAttachmentArgs);
}
export interface VolumeAttachmentArgs {
    readonly deviceName: string;
    readonly forceDetach?: boolean;
    readonly instanceId: string;
    readonly skipDestroy?: boolean;
    readonly volumeId: string;
}

