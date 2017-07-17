import * as lumi from "@lumi/lumi";
export declare class StaticIpAttachment extends lumi.NamedResource implements StaticIpAttachmentArgs {
    readonly instanceName: string;
    readonly staticIpName: string;
    constructor(name: string, args: StaticIpAttachmentArgs);
}
export interface StaticIpAttachmentArgs {
    readonly instanceName: string;
    readonly staticIpName: string;
}

