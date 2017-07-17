import * as lumi from "@lumi/lumi";
import { LogGroup } from "./logGroup";
export declare class LogSubscriptionFilter extends lumi.NamedResource implements LogSubscriptionFilterArgs {
    readonly destinationArn: string;
    readonly filterPattern: string;
    readonly logGroup: LogGroup;
    readonly logSubscriptionFilterName?: string;
    readonly roleArn: string;
    constructor(name: string, args: LogSubscriptionFilterArgs);
}
export interface LogSubscriptionFilterArgs {
    readonly destinationArn: string;
    readonly filterPattern: string;
    readonly logGroup: LogGroup;
    readonly logSubscriptionFilterName?: string;
    readonly roleArn?: string;
}

