import * as lumi from "@lumi/lumi";
export declare class FlowLog extends lumi.NamedResource implements FlowLogArgs {
    readonly eniId?: string;
    readonly iamRoleArn: string;
    readonly logGroupName: string;
    readonly subnetId?: string;
    readonly trafficType: string;
    readonly vpcId?: string;
    constructor(name: string, args: FlowLogArgs);
}
export interface FlowLogArgs {
    readonly eniId?: string;
    readonly iamRoleArn: string;
    readonly logGroupName: string;
    readonly subnetId?: string;
    readonly trafficType: string;
    readonly vpcId?: string;
}

