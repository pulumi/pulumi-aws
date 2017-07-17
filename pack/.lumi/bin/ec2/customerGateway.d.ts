import * as lumi from "@lumi/lumi";
export declare class CustomerGateway extends lumi.NamedResource implements CustomerGatewayArgs {
    readonly bgpAsn: number;
    readonly ipAddress: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
    constructor(name: string, args: CustomerGatewayArgs);
}
export interface CustomerGatewayArgs {
    readonly bgpAsn: number;
    readonly ipAddress: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
}

