import * as lumi from "@lumi/lumi";
export declare class MetricAlarm extends lumi.NamedResource implements MetricAlarmArgs {
    readonly actionsEnabled?: boolean;
    readonly alarmActions?: string[];
    readonly alarmDescription?: string;
    readonly alarmName: string;
    readonly comparisonOperator: string;
    readonly dimensions?: {
        [key: string]: any;
    };
    readonly evaluateLowSampleCountPercentiles: string;
    readonly evaluationPeriods: number;
    readonly extendedStatistic?: string;
    readonly insufficientDataActions?: string[];
    readonly metricName: string;
    readonly namespace: string;
    readonly okActions?: string[];
    readonly period: number;
    readonly statistic?: string;
    readonly threshold: number;
    readonly treatMissingData?: string;
    readonly unit?: string;
    constructor(name: string, args: MetricAlarmArgs);
}
export interface MetricAlarmArgs {
    readonly actionsEnabled?: boolean;
    readonly alarmActions?: string[];
    readonly alarmDescription?: string;
    readonly alarmName: string;
    readonly comparisonOperator: string;
    readonly dimensions?: {
        [key: string]: any;
    };
    readonly evaluateLowSampleCountPercentiles?: string;
    readonly evaluationPeriods: number;
    readonly extendedStatistic?: string;
    readonly insufficientDataActions?: string[];
    readonly metricName: string;
    readonly namespace: string;
    readonly okActions?: string[];
    readonly period: number;
    readonly statistic?: string;
    readonly threshold: number;
    readonly treatMissingData?: string;
    readonly unit?: string;
}

