import * as lumi from "@lumi/lumi";
export declare class Attachment extends lumi.NamedResource implements AttachmentArgs {
    readonly elb: string;
    readonly instance: string;
    constructor(name: string, args: AttachmentArgs);
}
export interface AttachmentArgs {
    readonly elb: string;
    readonly instance: string;
}

