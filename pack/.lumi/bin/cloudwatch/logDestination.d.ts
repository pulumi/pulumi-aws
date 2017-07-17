import * as lumi from "@lumi/lumi";
export declare class LogDestination extends lumi.NamedResource implements LogDestinationArgs {
    readonly arn: string;
    readonly logDestinationName?: string;
    readonly roleArn: string;
    readonly targetArn: string;
    constructor(name: string, args: LogDestinationArgs);
}
export interface LogDestinationArgs {
    readonly logDestinationName?: string;
    readonly roleArn: string;
    readonly targetArn: string;
}

