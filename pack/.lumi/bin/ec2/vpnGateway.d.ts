import * as lumi from "@lumi/lumi";
export declare class VpnGateway extends lumi.NamedResource implements VpnGatewayArgs {
    readonly availabilityZone?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: VpnGatewayArgs);
}
export interface VpnGatewayArgs {
    readonly availabilityZone?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
}

