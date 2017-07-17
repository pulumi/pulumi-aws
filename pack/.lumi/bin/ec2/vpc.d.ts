import * as lumi from "@lumi/lumi";
export declare class Vpc extends lumi.NamedResource implements VpcArgs {
    readonly assignGeneratedIpv6CidrBlock?: boolean;
    readonly cidrBlock: string;
    readonly defaultNetworkAclId: string;
    readonly defaultRouteTableId: string;
    readonly defaultSecurityGroupId: string;
    readonly dhcpOptionsId: string;
    readonly enableClassiclink: boolean;
    readonly enableClassiclinkDnsSupport: boolean;
    readonly enableDnsHostnames: boolean;
    readonly enableDnsSupport?: boolean;
    readonly instanceTenancy: string;
    readonly ipv6AssociationId: string;
    readonly ipv6CidrBlock: string;
    readonly mainRouteTableId: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: VpcArgs);
}
export interface VpcArgs {
    readonly assignGeneratedIpv6CidrBlock?: boolean;
    readonly cidrBlock: string;
    readonly enableClassiclink?: boolean;
    readonly enableClassiclinkDnsSupport?: boolean;
    readonly enableDnsHostnames?: boolean;
    readonly enableDnsSupport?: boolean;
    readonly instanceTenancy?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

