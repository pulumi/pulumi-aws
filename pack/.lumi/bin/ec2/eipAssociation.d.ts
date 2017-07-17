import * as lumi from "@lumi/lumi";
export declare class EipAssociation extends lumi.NamedResource implements EipAssociationArgs {
    readonly allocationId: string;
    readonly allowReassociation?: boolean;
    readonly instanceId: string;
    readonly networkInterfaceId: string;
    readonly privateIpAddress: string;
    readonly publicIp: string;
    constructor(name: string, args: EipAssociationArgs);
}
export interface EipAssociationArgs {
    readonly allocationId?: string;
    readonly allowReassociation?: boolean;
    readonly instanceId?: string;
    readonly networkInterfaceId?: string;
    readonly privateIpAddress?: string;
    readonly publicIp?: string;
}

