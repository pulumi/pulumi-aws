import * as lumi from "@lumi/lumi";
export declare class ListenerPolicy extends lumi.NamedResource implements ListenerPolicyArgs {
    readonly loadBalancerName: string;
    readonly loadBalancerPort: number;
    readonly policyNames?: string[];
    constructor(name: string, args: ListenerPolicyArgs);
}
export interface ListenerPolicyArgs {
    readonly loadBalancerName: string;
    readonly loadBalancerPort: number;
    readonly policyNames?: string[];
}

