import * as lumi from "@lumi/lumi";
export declare class Listener extends lumi.NamedResource implements ListenerArgs {
    readonly arn: string;
    readonly certificateArn?: string;
    readonly defaultAction: {
        targetGroupArn: string;
        type: string;
    }[];
    readonly loadBalancerArn: string;
    readonly port: number;
    readonly protocol?: string;
    readonly sslPolicy: string;
    constructor(name: string, args: ListenerArgs);
}
export interface ListenerArgs {
    readonly certificateArn?: string;
    readonly defaultAction: {
        targetGroupArn: string;
        type: string;
    }[];
    readonly loadBalancerArn: string;
    readonly port: number;
    readonly protocol?: string;
    readonly sslPolicy?: string;
}

