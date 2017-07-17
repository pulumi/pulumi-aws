import * as lumi from "@lumi/lumi";
export declare class DefaultNetworkAcl extends lumi.NamedResource implements DefaultNetworkAclArgs {
    readonly defaultNetworkAclId: string;
    readonly egress?: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
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
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly subnetIds?: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: DefaultNetworkAclArgs);
}
export interface DefaultNetworkAclArgs {
    readonly defaultNetworkAclId: string;
    readonly egress?: {
        action: string;
        cidrBlock?: string;
        fromPort: number;
        icmpCode?: number;
        icmpType?: number;
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
        protocol: string;
        ruleNo: number;
        toPort: number;
    }[];
    readonly subnetIds?: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

