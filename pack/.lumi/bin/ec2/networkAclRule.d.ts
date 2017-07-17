import * as lumi from "@lumi/lumi";
export declare class NetworkAclRule extends lumi.NamedResource implements NetworkAclRuleArgs {
    readonly cidrBlock?: string;
    readonly egress?: boolean;
    readonly fromPort?: number;
    readonly icmpCode?: string;
    readonly icmpType?: string;
    readonly ipv6CidrBlock?: string;
    readonly networkAclId: string;
    readonly protocol: string;
    readonly ruleAction: string;
    readonly ruleNumber: number;
    readonly toPort?: number;
    constructor(name: string, args: NetworkAclRuleArgs);
}
export interface NetworkAclRuleArgs {
    readonly cidrBlock?: string;
    readonly egress?: boolean;
    readonly fromPort?: number;
    readonly icmpCode?: string;
    readonly icmpType?: string;
    readonly ipv6CidrBlock?: string;
    readonly networkAclId: string;
    readonly protocol: string;
    readonly ruleAction: string;
    readonly ruleNumber: number;
    readonly toPort?: number;
}

