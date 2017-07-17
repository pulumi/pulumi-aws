import * as lumi from "@lumi/lumi";
export declare class Schedule extends lumi.NamedResource implements ScheduleArgs {
    readonly arn: string;
    readonly autoscalingGroupName: string;
    readonly desiredCapacity: number;
    readonly endTime: string;
    readonly maxSize: number;
    readonly minSize: number;
    readonly recurrence: string;
    readonly scheduledActionName: string;
    readonly startTime: string;
    constructor(name: string, args: ScheduleArgs);
}
export interface ScheduleArgs {
    readonly autoscalingGroupName: string;
    readonly desiredCapacity?: number;
    readonly endTime?: string;
    readonly maxSize?: number;
    readonly minSize?: number;
    readonly recurrence?: string;
    readonly scheduledActionName: string;
    readonly startTime?: string;
}

