import * as lumi from "@lumi/lumi";
export declare class Directory extends lumi.NamedResource implements DirectoryArgs {
    readonly accessUrl: string;
    readonly alias: string;
    readonly connectSettings?: {
        customerDnsIps: string[];
        customerUsername: string;
        subnetIds: string[];
        vpcId: string;
    }[];
    readonly description?: string;
    readonly dnsIpAddresses: string[];
    readonly enableSso?: boolean;
    readonly directoryName?: string;
    readonly password: string;
    readonly shortName: string;
    readonly size?: string;
    readonly type?: string;
    readonly vpcSettings?: {
        subnetIds: string[];
        vpcId: string;
    }[];
    constructor(name: string, args: DirectoryArgs);
}
export interface DirectoryArgs {
    readonly alias?: string;
    readonly connectSettings?: {
        customerDnsIps: string[];
        customerUsername: string;
        subnetIds: string[];
        vpcId: string;
    }[];
    readonly description?: string;
    readonly enableSso?: boolean;
    readonly directoryName?: string;
    readonly password: string;
    readonly shortName?: string;
    readonly size?: string;
    readonly type?: string;
    readonly vpcSettings?: {
        subnetIds: string[];
        vpcId: string;
    }[];
}

