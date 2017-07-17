import * as lumi from "@lumi/lumi";
export declare class SecurityGroupRule extends lumi.NamedResource implements SecurityGroupRuleArgs {
    readonly cidrBlocks?: string[];
    readonly fromPort: number;
    readonly ipv6CidrBlocks?: string[];
    readonly prefixListIds?: string[];
    readonly protocol: string;
    readonly securityGroupId: string;
    readonly self?: boolean;
    readonly sourceSecurityGroupId: string;
    readonly toPort: number;
    readonly type: string;
    constructor(name: string, args: SecurityGroupRuleArgs);
}
export interface SecurityGroupRuleArgs {
    readonly cidrBlocks?: string[];
    readonly fromPort: number;
    readonly ipv6CidrBlocks?: string[];
    readonly prefixListIds?: string[];
    readonly protocol: string;
    readonly securityGroupId: string;
    readonly self?: boolean;
    readonly sourceSecurityGroupId?: string;
    readonly toPort: number;
    readonly type: string;
}

