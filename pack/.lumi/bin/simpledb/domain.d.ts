import * as lumi from "@lumi/lumi";
export declare class Domain extends lumi.NamedResource implements DomainArgs {
    readonly domainName?: string;
    constructor(name: string, args: DomainArgs);
}
export interface DomainArgs {
    readonly domainName?: string;
}

