import * as lumi from "@lumi/lumi";
export declare class MainRouteTableAssociation extends lumi.NamedResource implements MainRouteTableAssociationArgs {
    readonly originalRouteTableId: string;
    readonly routeTableId: string;
    readonly vpcId: string;
    constructor(name: string, args: MainRouteTableAssociationArgs);
}
export interface MainRouteTableAssociationArgs {
    readonly routeTableId: string;
    readonly vpcId: string;
}

