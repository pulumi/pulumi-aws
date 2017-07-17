import * as lumi from "@lumi/lumi";
export declare class Alias extends lumi.NamedResource implements AliasArgs {
    readonly arn: string;
    readonly aliasName?: string;
    readonly namePrefix?: string;
    readonly targetKeyId: string;
    constructor(name: string, args: AliasArgs);
}
export interface AliasArgs {
    readonly aliasName?: string;
    readonly namePrefix?: string;
    readonly targetKeyId: string;
}

