import * as lumi from "@lumi/lumi";
export declare class TargetGroup extends lumi.NamedResource implements TargetGroupArgs {
    readonly arn: string;
    readonly arnSuffix: string;
    readonly deregistrationDelay?: number;
    readonly healthCheck: {
        healthyThreshold?: number;
        interval?: number;
        matcher?: string;
        path?: string;
        port?: string;
        protocol?: string;
        timeout?: number;
        unhealthyThreshold?: number;
    }[];
    readonly targetGroupName: string;
    readonly namePrefix?: string;
    readonly port: number;
    readonly protocol: string;
    readonly stickiness: {
        cookieDuration?: number;
        enabled?: boolean;
        type: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: TargetGroupArgs);
}
export interface TargetGroupArgs {
    readonly deregistrationDelay?: number;
    readonly healthCheck?: {
        healthyThreshold?: number;
        interval?: number;
        matcher?: string;
        path?: string;
        port?: string;
        protocol?: string;
        timeout?: number;
        unhealthyThreshold?: number;
    }[];
    readonly targetGroupName?: string;
    readonly namePrefix?: string;
    readonly port: number;
    readonly protocol: string;
    readonly stickiness?: {
        cookieDuration?: number;
        enabled?: boolean;
        type: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
}

