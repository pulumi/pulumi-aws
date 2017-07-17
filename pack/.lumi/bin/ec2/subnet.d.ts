import * as lumi from "@lumi/lumi";
export declare class Subnet extends lumi.NamedResource implements SubnetArgs {
    readonly assignIpv6AddressOnCreation?: boolean;
    readonly availabilityZone: string;
    readonly cidrBlock: string;
    readonly ipv6CidrBlock: string;
    readonly ipv6CidrBlockAssociationId: string;
    readonly mapPublicIpOnLaunch?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: SubnetArgs);
}
export interface SubnetArgs {
    readonly assignIpv6AddressOnCreation?: boolean;
    readonly availabilityZone?: string;
    readonly cidrBlock: string;
    readonly ipv6CidrBlock?: string;
    readonly mapPublicIpOnLaunch?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
}

