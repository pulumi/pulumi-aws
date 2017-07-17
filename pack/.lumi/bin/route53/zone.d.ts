import * as lumi from "@lumi/lumi";
export declare class Zone extends lumi.NamedResource implements ZoneArgs {
    readonly comment?: string;
    readonly delegationSetId?: string;
    readonly forceDestroy?: boolean;
    readonly zoneName?: string;
    readonly nameServers: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
    readonly vpcRegion: string;
    readonly zoneId: string;
    constructor(name: string, args: ZoneArgs);
}
export interface ZoneArgs {
    readonly comment?: string;
    readonly delegationSetId?: string;
    readonly forceDestroy?: boolean;
    readonly zoneName?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
    readonly vpcRegion?: string;
}

