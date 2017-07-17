import * as lumi from "@lumi/lumi";
export declare class RouteTableAssociation extends lumi.NamedResource implements RouteTableAssociationArgs {
    readonly routeTableId: string;
    readonly subnetId: string;
    constructor(name: string, args: RouteTableAssociationArgs);
}
export interface RouteTableAssociationArgs {
    readonly routeTableId: string;
    readonly subnetId: string;
}

