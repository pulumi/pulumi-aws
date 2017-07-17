import * as lumi from "@lumi/lumi";
export declare class LoadBalancer extends lumi.NamedResource implements LoadBalancerArgs {
    readonly accessLogs?: {
        bucket: string;
        enabled?: boolean;
        prefix?: string;
    }[];
    readonly arn: string;
    readonly arnSuffix: string;
    readonly dnsName: string;
    readonly enableDeletionProtection?: boolean;
    readonly idleTimeout?: number;
    readonly internal: boolean;
    readonly ipAddressType: string;
    readonly loadBalancerName: string;
    readonly namePrefix?: string;
    readonly securityGroups: string[];
    readonly subnets: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    readonly zoneId: string;
    constructor(name: string, args: LoadBalancerArgs);
}
export interface LoadBalancerArgs {
    readonly accessLogs?: {
        bucket: string;
        enabled?: boolean;
        prefix?: string;
    }[];
    readonly enableDeletionProtection?: boolean;
    readonly idleTimeout?: number;
    readonly internal?: boolean;
    readonly ipAddressType?: string;
    readonly loadBalancerName?: string;
    readonly namePrefix?: string;
    readonly securityGroups?: string[];
    readonly subnets: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

