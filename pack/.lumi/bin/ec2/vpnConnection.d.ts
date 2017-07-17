import * as lumi from "@lumi/lumi";
export declare class VpnConnection extends lumi.NamedResource implements VpnConnectionArgs {
    readonly customerGatewayConfiguration: string;
    readonly customerGatewayId: string;
    readonly routes: {
        destinationCidrBlock: string;
        source: string;
        state: string;
    }[];
    readonly staticRoutesOnly: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly tunnel1Address: string;
    readonly tunnel1BgpAsn: string;
    readonly tunnel1BgpHoldtime: number;
    readonly tunnel1CgwInsideAddress: string;
    readonly tunnel1PresharedKey: string;
    readonly tunnel1VgwInsideAddress: string;
    readonly tunnel2Address: string;
    readonly tunnel2BgpAsn: string;
    readonly tunnel2BgpHoldtime: number;
    readonly tunnel2CgwInsideAddress: string;
    readonly tunnel2PresharedKey: string;
    readonly tunnel2VgwInsideAddress: string;
    readonly type: string;
    readonly vgwTelemetry: {
        acceptedRouteCount: number;
        lastStatusChange: string;
        outsideIpAddress: string;
        status: string;
        statusMessage: string;
    }[];
    readonly vpnGatewayId: string;
    constructor(name: string, args: VpnConnectionArgs);
}
export interface VpnConnectionArgs {
    readonly customerGatewayConfiguration?: string;
    readonly customerGatewayId: string;
    readonly routes?: {
        destinationCidrBlock: string;
        source: string;
        state: string;
    }[];
    readonly staticRoutesOnly?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
    readonly vgwTelemetry?: {
        acceptedRouteCount: number;
        lastStatusChange: string;
        outsideIpAddress: string;
        status: string;
        statusMessage: string;
    }[];
    readonly vpnGatewayId: string;
}

