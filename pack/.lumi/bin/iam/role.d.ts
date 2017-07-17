import * as lumi from "@lumi/lumi";
export declare class Role extends lumi.NamedResource implements RoleArgs {
    readonly arn: string;
    readonly assumeRolePolicy: string;
    readonly createDate: string;
    readonly description?: string;
    readonly forceDetachPolicies?: boolean;
    readonly roleName: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly uniqueId: string;
    constructor(name: string, args: RoleArgs);
}
export interface RoleArgs {
    readonly assumeRolePolicy: string;
    readonly description?: string;
    readonly forceDetachPolicies?: boolean;
    readonly roleName?: string;
    readonly namePrefix?: string;
    readonly path?: string;
}

