import * as lumi from "@lumi/lumi";
export declare class Instance extends lumi.NamedResource implements InstanceArgs {
    readonly arn: string;
    readonly availabilityZone: string;
    readonly blueprintId: string;
    readonly bundleId: string;
    readonly cpuCount: number;
    readonly createdAt: string;
    readonly ipv6Address: string;
    readonly isStaticIp: boolean;
    readonly keyPairName?: string;
    readonly instanceName?: string;
    readonly privateIpAddress: string;
    readonly publicIpAddress: string;
    readonly ramSize: number;
    readonly userData?: string;
    readonly username: string;
    constructor(name: string, args: InstanceArgs);
}
export interface InstanceArgs {
    readonly availabilityZone: string;
    readonly blueprintId: string;
    readonly bundleId: string;
    readonly keyPairName?: string;
    readonly instanceName?: string;
    readonly userData?: string;
}

