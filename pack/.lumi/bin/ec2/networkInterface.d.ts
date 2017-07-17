import * as lumi from "@lumi/lumi";
export declare class NetworkInterface extends lumi.NamedResource implements NetworkInterfaceArgs {
    readonly attachment: {
        attachmentId: string;
        deviceIndex: number;
        instance: string;
    }[];
    readonly description?: string;
    readonly privateIp: string;
    readonly privateIps: string[];
    readonly privateIpsCount: number;
    readonly securityGroups: string[];
    readonly sourceDestCheck?: boolean;
    readonly subnetId: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: NetworkInterfaceArgs);
}
export interface NetworkInterfaceArgs {
    readonly attachment?: {
        attachmentId: string;
        deviceIndex: number;
        instance: string;
    }[];
    readonly description?: string;
    readonly privateIp?: string;
    readonly privateIps?: string[];
    readonly privateIpsCount?: number;
    readonly securityGroups?: string[];
    readonly sourceDestCheck?: boolean;
    readonly subnetId: string;
    readonly tags?: {
        [key: string]: any;
    };
}

