import * as lumi from "@lumi/lumi";
export declare class Alias extends lumi.NamedResource implements AliasArgs {
    readonly arn: string;
    readonly description?: string;
    readonly functionName: string;
    readonly functionVersion: string;
    readonly aliasName?: string;
    constructor(name: string, args: AliasArgs);
}
export interface AliasArgs {
    readonly description?: string;
    readonly functionName: string;
    readonly functionVersion: string;
    readonly aliasName?: string;
}

