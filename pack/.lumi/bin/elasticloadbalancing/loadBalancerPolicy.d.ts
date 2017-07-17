import * as lumi from "@lumi/lumi";
export declare class LoadBalancerPolicy extends lumi.NamedResource implements LoadBalancerPolicyArgs {
    readonly loadBalancerName: string;
    readonly policyAttribute?: {
        name?: string;
        value?: string;
    }[];
    readonly policyName: string;
    readonly policyTypeName: string;
    constructor(name: string, args: LoadBalancerPolicyArgs);
}
export interface LoadBalancerPolicyArgs {
    readonly loadBalancerName: string;
    readonly policyAttribute?: {
        name?: string;
        value?: string;
    }[];
    readonly policyName: string;
    readonly policyTypeName: string;
}

