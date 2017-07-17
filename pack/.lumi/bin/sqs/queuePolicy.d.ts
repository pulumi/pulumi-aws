import * as lumi from "@lumi/lumi";
export declare class QueuePolicy extends lumi.NamedResource implements QueuePolicyArgs {
    readonly policy: string;
    readonly queueUrl: string;
    constructor(name: string, args: QueuePolicyArgs);
}
export interface QueuePolicyArgs {
    readonly policy: string;
    readonly queueUrl: string;
}

