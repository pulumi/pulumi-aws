import * as lumi from "@lumi/lumi";
export declare class VpnGatewayRoutePropagation extends lumi.NamedResource implements VpnGatewayRoutePropagationArgs {
    readonly routeTableId: string;
    readonly vpnGatewayId: string;
    constructor(name: string, args: VpnGatewayRoutePropagationArgs);
}
export interface VpnGatewayRoutePropagationArgs {
    readonly routeTableId: string;
    readonly vpnGatewayId: string;
}

