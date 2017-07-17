import * as lumi from "@lumi/lumi";
export declare class RolePolicy extends lumi.NamedResource implements RolePolicyArgs {
    readonly rolePolicyName: string;
    readonly namePrefix?: string;
    readonly policy: string;
    readonly role: string;
    constructor(name: string, args: RolePolicyArgs);
}
export interface RolePolicyArgs {
    readonly rolePolicyName?: string;
    readonly namePrefix?: string;
    readonly policy: string;
    readonly role: string;
}

