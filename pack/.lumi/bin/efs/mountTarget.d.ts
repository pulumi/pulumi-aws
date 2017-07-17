import * as lumi from "@lumi/lumi";
export declare class MountTarget extends lumi.NamedResource implements MountTargetArgs {
    readonly dnsName: string;
    readonly fileSystemId: string;
    readonly ipAddress: string;
    readonly networkInterfaceId: string;
    readonly securityGroups: string[];
    readonly subnetId: string;
    constructor(name: string, args: MountTargetArgs);
}
export interface MountTargetArgs {
    readonly fileSystemId: string;
    readonly ipAddress?: string;
    readonly securityGroups?: string[];
    readonly subnetId: string;
}

