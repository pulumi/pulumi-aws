import * as lumi from "@lumi/lumi";
export declare class DomainIdentity extends lumi.NamedResource implements DomainIdentityArgs {
    readonly arn: string;
    readonly domain: string;
    readonly verificationToken: string;
    constructor(name: string, args: DomainIdentityArgs);
}
export interface DomainIdentityArgs {
    readonly domain: string;
}

