import * as lumi from "@lumi/lumi";
export declare class NetworkInterfaceAttachment extends lumi.NamedResource implements NetworkInterfaceAttachmentArgs {
    readonly attachmentId: string;
    readonly deviceIndex: number;
    readonly instanceId: string;
    readonly networkInterfaceId: string;
    readonly status: string;
    constructor(name: string, args: NetworkInterfaceAttachmentArgs);
}
export interface NetworkInterfaceAttachmentArgs {
    readonly deviceIndex: number;
    readonly instanceId: string;
    readonly networkInterfaceId: string;
}

