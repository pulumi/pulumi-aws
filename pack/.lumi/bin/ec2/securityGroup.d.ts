import * as lumi from "@lumi/lumi";
export declare class SecurityGroup extends lumi.NamedResource implements SecurityGroupArgs {
    readonly description?: string;
    readonly egress: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        prefixListIds?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly ingress: {
        cidrBlocks?: string[];
        fromPort: number;
        ipv6CidrBlocks?: string[];
        protocol: string;
        securityGroups?: string[];
        self?: boolean;
        toPort: number;
    }[];
    readonly securityGroupName: string;
    readonly namePrefix?: string;
    readonly ownerId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: SecurityGroupArgs);
}
export interface SecurityGroupArgs {
    readonly description?: string;
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
    readonly securityGroupName?: string;
    readonly namePrefix?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
}

