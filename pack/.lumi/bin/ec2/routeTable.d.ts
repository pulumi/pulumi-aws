import * as lumi from "@lumi/lumi";
export declare class RouteTable extends lumi.NamedResource implements RouteTableArgs {
    readonly propagatingVgws: string[];
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
    constructor(name: string, args: RouteTableArgs);
}
export interface RouteTableArgs {
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
    readonly vpcId: string;
}

