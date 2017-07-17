import * as lumi from "@lumi/lumi";
export declare class ProxyProtocolPolicy extends lumi.NamedResource implements ProxyProtocolPolicyArgs {
    readonly instancePorts: string[];
    readonly loadBalancer: string;
    constructor(name: string, args: ProxyProtocolPolicyArgs);
}
export interface ProxyProtocolPolicyArgs {
    readonly instancePorts: string[];
    readonly loadBalancer: string;
}

