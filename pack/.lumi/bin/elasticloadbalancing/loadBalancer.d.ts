import * as lumi from "@lumi/lumi";
export declare class LoadBalancer extends lumi.NamedResource implements LoadBalancerArgs {
    readonly accessLogs?: {
        bucket: string;
        bucketPrefix?: string;
        enabled?: boolean;
        interval?: number;
    }[];
    readonly availabilityZones: string[];
    readonly connectionDraining?: boolean;
    readonly connectionDrainingTimeout?: number;
    readonly crossZoneLoadBalancing?: boolean;
    readonly dnsName: string;
    readonly healthCheck: {
        healthyThreshold: number;
        interval: number;
        target: string;
        timeout: number;
        unhealthyThreshold: number;
    }[];
    readonly idleTimeout?: number;
    readonly instances: string[];
    readonly internal: boolean;
    readonly listener: {
        instancePort: number;
        instanceProtocol: string;
        lbPort: number;
        lbProtocol: string;
        sslCertificateId?: string;
    }[];
    readonly loadBalancerName: string;
    readonly namePrefix?: string;
    readonly securityGroups: string[];
    readonly sourceSecurityGroup: string;
    readonly sourceSecurityGroupId: string;
    readonly subnets: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly zoneId: string;
    constructor(name: string, args: LoadBalancerArgs);
}
export interface LoadBalancerArgs {
    readonly accessLogs?: {
        bucket: string;
        bucketPrefix?: string;
        enabled?: boolean;
        interval?: number;
    }[];
    readonly availabilityZones?: string[];
    readonly connectionDraining?: boolean;
    readonly connectionDrainingTimeout?: number;
    readonly crossZoneLoadBalancing?: boolean;
    readonly healthCheck?: {
        healthyThreshold: number;
        interval: number;
        target: string;
        timeout: number;
        unhealthyThreshold: number;
    }[];
    readonly idleTimeout?: number;
    readonly instances?: string[];
    readonly internal?: boolean;
    readonly listener: {
        instancePort: number;
        instanceProtocol: string;
        lbPort: number;
        lbProtocol: string;
        sslCertificateId?: string;
    }[];
    readonly loadBalancerName?: string;
    readonly namePrefix?: string;
    readonly securityGroups?: string[];
    readonly sourceSecurityGroup?: string;
    readonly subnets?: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

