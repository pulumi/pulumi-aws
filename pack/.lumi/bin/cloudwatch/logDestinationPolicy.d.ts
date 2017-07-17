import * as lumi from "@lumi/lumi";
export declare class LogDestinationPolicy extends lumi.NamedResource implements LogDestinationPolicyArgs {
    readonly accessPolicy: string;
    readonly destinationName: string;
    constructor(name: string, args: LogDestinationPolicyArgs);
}
export interface LogDestinationPolicyArgs {
    readonly accessPolicy: string;
    readonly destinationName: string;
}

