import * as lumi from "@lumi/lumi";
export declare class LogGroup extends lumi.NamedResource implements LogGroupArgs {
    readonly arn: string;
    readonly logGroupName: string;
    readonly namePrefix?: string;
    readonly retentionInDays?: number;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: LogGroupArgs);
}
export interface LogGroupArgs {
    readonly logGroupName?: string;
    readonly namePrefix?: string;
    readonly retentionInDays?: number;
    readonly tags?: {
        [key: string]: any;
    };
}

