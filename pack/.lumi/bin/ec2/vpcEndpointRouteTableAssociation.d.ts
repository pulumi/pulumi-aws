import * as lumi from "@lumi/lumi";
export declare class VpcEndpointRouteTableAssociation extends lumi.NamedResource implements VpcEndpointRouteTableAssociationArgs {
    readonly routeTableId: string;
    readonly vpcEndpointId: string;
    constructor(name: string, args: VpcEndpointRouteTableAssociationArgs);
}
export interface VpcEndpointRouteTableAssociationArgs {
    readonly routeTableId: string;
    readonly vpcEndpointId: string;
}

