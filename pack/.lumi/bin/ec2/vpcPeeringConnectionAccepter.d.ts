import * as lumi from "@lumi/lumi";
export declare class VpcPeeringConnectionAccepter extends lumi.NamedResource implements VpcPeeringConnectionAccepterArgs {
    readonly acceptStatus: string;
    readonly accepter: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly autoAccept?: boolean;
    readonly peerOwnerId: string;
    readonly peerVpcId: string;
    readonly requester: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    readonly vpcPeeringConnectionId: string;
    constructor(name: string, args: VpcPeeringConnectionAccepterArgs);
}
export interface VpcPeeringConnectionAccepterArgs {
    readonly accepter?: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly autoAccept?: boolean;
    readonly requester?: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcPeeringConnectionId: string;
}

