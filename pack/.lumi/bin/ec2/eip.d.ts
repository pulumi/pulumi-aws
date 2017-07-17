import * as lumi from "@lumi/lumi";
export declare class Eip extends lumi.NamedResource implements EipArgs {
    readonly allocationId: string;
    readonly associateWithPrivateIp?: string;
    readonly associationId: string;
    readonly domain: string;
    readonly instance: string;
    readonly networkInterface: string;
    readonly privateIp: string;
    readonly publicIp: string;
    readonly vpc: boolean;
    constructor(name: string, args: EipArgs);
}
export interface EipArgs {
    readonly associateWithPrivateIp?: string;
    readonly instance?: string;
    readonly networkInterface?: string;
    readonly vpc?: boolean;
}

