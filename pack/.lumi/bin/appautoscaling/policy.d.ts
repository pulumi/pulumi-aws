import * as lumi from "@lumi/lumi";
export declare class Policy extends lumi.NamedResource implements PolicyArgs {
    readonly adjustmentType: string;
    readonly alarms?: string[];
    readonly arn: string;
    readonly cooldown: number;
    readonly metricAggregationType: string;
    readonly minAdjustmentMagnitude?: number;
    readonly policyName?: string;
    readonly policyType?: string;
    readonly resourceId: string;
    readonly scalableDimension: string;
    readonly serviceNamespace: string;
    readonly stepAdjustment?: {
        metricIntervalLowerBound?: string;
        metricIntervalUpperBound?: string;
        scalingAdjustment: number;
    }[];
    constructor(name: string, args: PolicyArgs);
}
export interface PolicyArgs {
    readonly adjustmentType: string;
    readonly alarms?: string[];
    readonly cooldown: number;
    readonly metricAggregationType: string;
    readonly minAdjustmentMagnitude?: number;
    readonly policyName?: string;
    readonly policyType?: string;
    readonly resourceId: string;
    readonly scalableDimension: string;
    readonly serviceNamespace: string;
    readonly stepAdjustment?: {
        metricIntervalLowerBound?: string;
        metricIntervalUpperBound?: string;
        scalingAdjustment: number;
    }[];
}

