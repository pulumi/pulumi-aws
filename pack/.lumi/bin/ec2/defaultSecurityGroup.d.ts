import * as lumi from "@lumi/lumi";
export declare class DefaultSecurityGroup extends lumi.NamedResource implements DefaultSecurityGroupArgs {
    readonly egress?: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        prefixListIds?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly ingress?: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly defaultSecurityGroupName: string;
    readonly ownerId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: DefaultSecurityGroupArgs);
}
export interface DefaultSecurityGroupArgs {
    readonly egress?: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        prefixListIds?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly ingress?: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
}

