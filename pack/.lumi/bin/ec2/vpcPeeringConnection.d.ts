import * as lumi from "@lumi/lumi";
export declare class VpcPeeringConnection extends lumi.NamedResource implements VpcPeeringConnectionArgs {
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
    constructor(name: string, args: VpcPeeringConnectionArgs);
}
export interface VpcPeeringConnectionArgs {
    readonly accepter?: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly autoAccept?: boolean;
    readonly peerOwnerId?: string;
    readonly peerVpcId: string;
    readonly requester?: {
        allowClassicLinkToRemoteVpc?: boolean;
        allowRemoteVpcDnsResolution?: boolean;
        allowVpcToRemoteClassicLink?: boolean;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
}

