import * as lumi from "@lumi/lumi";
export declare class StaticIp extends lumi.NamedResource implements StaticIpArgs {
    readonly arn: string;
    readonly ipAddress: string;
    readonly staticIpName?: string;
    readonly supportCode: string;
    constructor(name: string, args: StaticIpArgs);
}
export interface StaticIpArgs {
    readonly staticIpName?: string;
}

