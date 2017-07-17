import * as lumi from "@lumi/lumi";
export declare class LoadBalancerBackendServerPolicy extends lumi.NamedResource implements LoadBalancerBackendServerPolicyArgs {
    readonly instancePort: number;
    readonly loadBalancerName: string;
    readonly policyNames?: string[];
    constructor(name: string, args: LoadBalancerBackendServerPolicyArgs);
}
export interface LoadBalancerBackendServerPolicyArgs {
    readonly instancePort: number;
    readonly loadBalancerName: string;
    readonly policyNames?: string[];
}

