import * as lumi from "@lumi/lumi";
export declare class DomainPolicy extends lumi.NamedResource implements DomainPolicyArgs {
    readonly accessPolicies: string;
    readonly domainName: string;
    constructor(name: string, args: DomainPolicyArgs);
}
export interface DomainPolicyArgs {
    readonly accessPolicies: string;
    readonly domainName: string;
}

