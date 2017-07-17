import * as lumi from "@lumi/lumi";
export declare class NetworkAcl extends lumi.NamedResource implements NetworkAclArgs {
    readonly egress: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
        ipv6CidrBlock?: string;
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly ingress: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
        ipv6CidrBlock?: string;
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly subnetId?: string;
    readonly subnetIds: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: NetworkAclArgs);
}
export interface NetworkAclArgs {
    readonly egress?: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
        ipv6CidrBlock?: string;
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly ingress?: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
        ipv6CidrBlock?: string;
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly subnetId?: string;
    readonly subnetIds?: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
}

