import * as lumi from "@lumi/lumi";
export declare class Attachment extends lumi.NamedResource implements AttachmentArgs {
    readonly albTargetGroupArn?: string;
    readonly autoscalingGroupName: string;
    readonly elb?: string;
    constructor(name: string, args: AttachmentArgs);
}
export interface AttachmentArgs {
    readonly albTargetGroupArn?: string;
    readonly autoscalingGroupName: string;
    readonly elb?: string;
}

