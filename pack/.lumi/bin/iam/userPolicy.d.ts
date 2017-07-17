import * as lumi from "@lumi/lumi";
export declare class UserPolicy extends lumi.NamedResource implements UserPolicyArgs {
    readonly userPolicyName: string;
    readonly namePrefix?: string;
    readonly policy: string;
    readonly user: string;
    constructor(name: string, args: UserPolicyArgs);
}
export interface UserPolicyArgs {
    readonly userPolicyName?: string;
    readonly namePrefix?: string;
    readonly policy: string;
    readonly user: string;
}

