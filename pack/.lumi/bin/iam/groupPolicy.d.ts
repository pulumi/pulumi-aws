import * as lumi from "@lumi/lumi";
export declare class GroupPolicy extends lumi.NamedResource implements GroupPolicyArgs {
    readonly group: string;
    readonly groupPolicyName: string;
    readonly namePrefix?: string;
    readonly policy: string;
    constructor(name: string, args: GroupPolicyArgs);
}
export interface GroupPolicyArgs {
    readonly group: string;
    readonly groupPolicyName?: string;
    readonly namePrefix?: string;
    readonly policy: string;
}

