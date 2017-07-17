import * as lumi from "@lumi/lumi";
export declare class EventTarget extends lumi.NamedResource implements EventTargetArgs {
    readonly arn: string;
    readonly ecsTarget?: {
        taskCount?: number;
        taskDefinitionArn: string;
    }[];
    readonly input?: string;
    readonly inputPath?: string;
    readonly roleArn?: string;
    readonly rule: string;
    readonly runCommandTargets?: {
        key: string;
        values: string[];
    }[];
    readonly targetId: string;
    constructor(name: string, args: EventTargetArgs);
}
export interface EventTargetArgs {
    readonly arn: string;
    readonly ecsTarget?: {
        taskCount?: number;
        taskDefinitionArn: string;
    }[];
    readonly input?: string;
    readonly inputPath?: string;
    readonly roleArn?: string;
    readonly rule: string;
    readonly runCommandTargets?: {
        key: string;
        values: string[];
    }[];
    readonly targetId?: string;
}

