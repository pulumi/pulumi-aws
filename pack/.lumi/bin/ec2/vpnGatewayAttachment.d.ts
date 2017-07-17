import * as lumi from "@lumi/lumi";
export declare class VpnGatewayAttachment extends lumi.NamedResource implements VpnGatewayAttachmentArgs {
    readonly vpcId: string;
    readonly vpnGatewayId: string;
    constructor(name: string, args: VpnGatewayAttachmentArgs);
}
export interface VpnGatewayAttachmentArgs {
    readonly vpcId: string;
    readonly vpnGatewayId: string;
}

