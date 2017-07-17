import * as lumi from "@lumi/lumi";
export declare class GroupMembership extends lumi.NamedResource implements GroupMembershipArgs {
    readonly group: string;
    readonly groupMembershipName?: string;
    readonly users: string[];
    constructor(name: string, args: GroupMembershipArgs);
}
export interface GroupMembershipArgs {
    readonly group: string;
    readonly groupMembershipName?: string;
    readonly users: string[];
}

