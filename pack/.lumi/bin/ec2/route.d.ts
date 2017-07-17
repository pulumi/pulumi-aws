import * as lumi from "@lumi/lumi";
export declare class Route extends lumi.NamedResource implements RouteArgs {
    readonly destinationCidrBlock?: string;
    readonly destinationIpv6CidrBlock?: string;
    readonly destinationPrefixListId: string;
    readonly egressOnlyGatewayId: string;
    readonly gatewayId: string;
    readonly instanceId: string;
    readonly instanceOwnerId: string;
    readonly natGatewayId: string;
    readonly networkInterfaceId: string;
    readonly origin: string;
    readonly routeTableId: string;
    readonly state: string;
    readonly vpcPeeringConnectionId?: string;
    constructor(name: string, args: RouteArgs);
}
export interface RouteArgs {
    readonly destinationCidrBlock?: string;
    readonly destinationIpv6CidrBlock?: string;
    readonly egressOnlyGatewayId?: string;
    readonly gatewayId?: string;
    readonly instanceId?: string;
    readonly natGatewayId?: string;
    readonly networkInterfaceId?: string;
    readonly routeTableId: string;
    readonly vpcPeeringConnectionId?: string;
}

