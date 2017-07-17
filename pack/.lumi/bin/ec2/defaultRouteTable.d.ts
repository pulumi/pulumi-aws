import * as lumi from "@lumi/lumi";
export declare class DefaultRouteTable extends lumi.NamedResource implements DefaultRouteTableArgs {
    readonly defaultRouteTableId: string;
    readonly propagatingVgws?: string[];
    readonly route: {
        cidrBlock?: string;
        egressOnlyGatewayId?: string;
        gatewayId?: string;
        instanceId?: string;
        ipv6CidrBlock?: string;
        natGatewayId?: string;
        networkInterfaceId?: string;
        vpcPeeringConnectionId?: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: DefaultRouteTableArgs);
}
export interface DefaultRouteTableArgs {
    readonly defaultRouteTableId: string;
    readonly propagatingVgws?: string[];
    readonly route?: {
        cidrBlock?: string;
        egressOnlyGatewayId?: string;
        gatewayId?: string;
        instanceId?: string;
        ipv6CidrBlock?: string;
        natGatewayId?: string;
        networkInterfaceId?: string;
        vpcPeeringConnectionId?: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
}

