import * as lumi from "@lumi/lumi";
export declare class VpcDhcpOptionsAssociation extends lumi.NamedResource implements VpcDhcpOptionsAssociationArgs {
    readonly dhcpOptionsId: string;
    readonly vpcId: string;
    constructor(name: string, args: VpcDhcpOptionsAssociationArgs);
}
export interface VpcDhcpOptionsAssociationArgs {
    readonly dhcpOptionsId: string;
    readonly vpcId: string;
}

