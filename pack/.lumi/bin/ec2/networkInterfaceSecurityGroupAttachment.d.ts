import * as lumi from "@lumi/lumi";
export declare class NetworkInterfaceSecurityGroupAttachment extends lumi.NamedResource implements NetworkInterfaceSecurityGroupAttachmentArgs {
    readonly networkInterfaceId: string;
    readonly securityGroupId: string;
    constructor(name: string, args: NetworkInterfaceSecurityGroupAttachmentArgs);
}
export interface NetworkInterfaceSecurityGroupAttachmentArgs {
    readonly networkInterfaceId: string;
    readonly securityGroupId: string;
}

