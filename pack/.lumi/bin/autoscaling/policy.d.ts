import * as lumi from "@lumi/lumi";
export declare class Policy extends lumi.NamedResource implements PolicyArgs {
    readonly adjustmentType: string;
    readonly arn: string;
    readonly autoscalingGroupName: string;
    readonly cooldown?: number;
    readonly estimatedInstanceWarmup?: number;
    readonly metricAggregationType: string;
    readonly minAdjustmentMagnitude?: number;
    readonly minAdjustmentStep?: number;
    readonly policyName?: string;
    readonly policyType?: string;
    readonly scalingAdjustment?: number;
    readonly stepAdjustment?: {
        metricIntervalLowerBound?: string;
        metricIntervalUpperBound?: string;
        scalingAdjustment: number;
    }[];
    constructor(name: string, args: PolicyArgs);
}
export interface PolicyArgs {
    readonly adjustmentType: string;
    readonly autoscalingGroupName: string;
    readonly cooldown?: number;
    readonly estimatedInstanceWarmup?: number;
    readonly metricAggregationType?: string;
    readonly minAdjustmentMagnitude?: number;
    readonly minAdjustmentStep?: number;
    readonly policyName?: string;
    readonly policyType?: string;
    readonly scalingAdjustment?: number;
    readonly stepAdjustment?: {
        metricIntervalLowerBound?: string;
        metricIntervalUpperBound?: string;
        scalingAdjustment: number;
    }[];
}

