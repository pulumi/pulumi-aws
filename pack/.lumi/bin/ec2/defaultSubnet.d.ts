import * as lumi from "@lumi/lumi";
export declare class DefaultSubnet extends lumi.NamedResource implements DefaultSubnetArgs {
    readonly assignIpv6AddressOnCreation: boolean;
    readonly availabilityZone: string;
    readonly cidrBlock: string;
    readonly ipv6CidrBlock: string;
    readonly ipv6CidrBlockAssociationId: string;
    readonly mapPublicIpOnLaunch: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: DefaultSubnetArgs);
}
export interface DefaultSubnetArgs {
    readonly availabilityZone: string;
    readonly tags?: {
        [key: string]: any;
    };
}

