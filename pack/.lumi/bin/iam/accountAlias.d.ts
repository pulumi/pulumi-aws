import * as lumi from "@lumi/lumi";
export declare class AccountAlias extends lumi.NamedResource implements AccountAliasArgs {
    readonly accountAlias: string;
    constructor(name: string, args: AccountAliasArgs);
}
export interface AccountAliasArgs {
    readonly accountAlias: string;
}

