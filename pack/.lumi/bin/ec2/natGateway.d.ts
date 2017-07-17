import * as lumi from "@lumi/lumi";
export declare class NatGateway extends lumi.NamedResource implements NatGatewayArgs {
    readonly allocationId: string;
    readonly networkInterfaceId: string;
    readonly privateIp: string;
    readonly publicIp: string;
    readonly subnetId: string;
    constructor(name: string, args: NatGatewayArgs);
}
export interface NatGatewayArgs {
    readonly allocationId: string;
    readonly networkInterfaceId?: string;
    readonly privateIp?: string;
    readonly publicIp?: string;
    readonly subnetId: string;
}

