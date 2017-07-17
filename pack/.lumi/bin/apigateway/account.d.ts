import * as lumi from "@lumi/lumi";
export declare class Account extends lumi.NamedResource implements AccountArgs {
    readonly cloudwatchRoleArn?: string;
    readonly throttleSettings: {
        burstLimit: number;
        rateLimit: number;
    }[];
    constructor(name: string, args: AccountArgs);
}
export interface AccountArgs {
    readonly cloudwatchRoleArn?: string;
}

