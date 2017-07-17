import * as lumi from "@lumi/lumi";
export declare class DelegationSet extends lumi.NamedResource implements DelegationSetArgs {
    readonly nameServers: string[];
    readonly referenceName?: string;
    constructor(name: string, args: DelegationSetArgs);
}
export interface DelegationSetArgs {
    readonly referenceName?: string;
}

