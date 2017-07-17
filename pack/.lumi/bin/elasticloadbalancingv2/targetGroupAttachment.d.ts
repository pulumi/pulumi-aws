import * as lumi from "@lumi/lumi";
export declare class TargetGroupAttachment extends lumi.NamedResource implements TargetGroupAttachmentArgs {
    readonly port?: number;
    readonly targetGroupArn: string;
    readonly targetId: string;
    constructor(name: string, args: TargetGroupAttachmentArgs);
}
export interface TargetGroupAttachmentArgs {
    readonly port?: number;
    readonly targetGroupArn: string;
    readonly targetId: string;
}

