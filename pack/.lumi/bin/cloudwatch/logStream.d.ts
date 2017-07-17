import * as lumi from "@lumi/lumi";
export declare class LogStream extends lumi.NamedResource implements LogStreamArgs {
    readonly arn: string;
    readonly logGroupName: string;
    readonly logStreamName?: string;
    constructor(name: string, args: LogStreamArgs);
}
export interface LogStreamArgs {
    readonly logGroupName: string;
    readonly logStreamName?: string;
}

