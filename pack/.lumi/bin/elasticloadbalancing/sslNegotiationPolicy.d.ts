import * as lumi from "@lumi/lumi";
export declare class SslNegotiationPolicy extends lumi.NamedResource implements SslNegotiationPolicyArgs {
    readonly attribute?: {
        name: string;
        value: string;
    }[];
    readonly lbPort: number;
    readonly loadBalancer: string;
    readonly sslNegotiationPolicyName?: string;
    constructor(name: string, args: SslNegotiationPolicyArgs);
}
export interface SslNegotiationPolicyArgs {
    readonly attribute?: {
        name: string;
        value: string;
    }[];
    readonly lbPort: number;
    readonly loadBalancer: string;
    readonly sslNegotiationPolicyName?: string;
}

