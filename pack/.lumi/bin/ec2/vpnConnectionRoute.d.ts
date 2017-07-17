import * as lumi from "@lumi/lumi";
export declare class VpnConnectionRoute extends lumi.NamedResource implements VpnConnectionRouteArgs {
    readonly destinationCidrBlock: string;
    readonly vpnConnectionId: string;
    constructor(name: string, args: VpnConnectionRouteArgs);
}
export interface VpnConnectionRouteArgs {
    readonly destinationCidrBlock: string;
    readonly vpnConnectionId: string;
}

