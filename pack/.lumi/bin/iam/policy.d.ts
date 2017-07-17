import * as lumi from "@lumi/lumi";
export declare class Policy extends lumi.NamedResource implements PolicyArgs {
    readonly arn: string;
    readonly description?: string;
    readonly policyName: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly policy: string;
    constructor(name: string, args: PolicyArgs);
}
export interface PolicyArgs {
    readonly description?: string;
    readonly policyName?: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly policy: string;
}

