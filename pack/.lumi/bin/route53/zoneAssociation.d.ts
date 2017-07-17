import * as lumi from "@lumi/lumi";
export declare class ZoneAssociation extends lumi.NamedResource implements ZoneAssociationArgs {
    readonly vpcId: string;
    readonly vpcRegion: string;
    readonly zoneId: string;
    constructor(name: string, args: ZoneAssociationArgs);
}
export interface ZoneAssociationArgs {
    readonly vpcId: string;
    readonly vpcRegion?: string;
    readonly zoneId: string;
}

