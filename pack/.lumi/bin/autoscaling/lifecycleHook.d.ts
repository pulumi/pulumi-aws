import * as lumi from "@lumi/lumi";
export declare class LifecycleHook extends lumi.NamedResource implements LifecycleHookArgs {
    readonly autoscalingGroupName: string;
    readonly defaultResult: string;
    readonly heartbeatTimeout?: number;
    readonly lifecycleTransition: string;
    readonly lifecycleHookName?: string;
    readonly notificationMetadata?: string;
    readonly notificationTargetArn?: string;
    readonly roleArn?: string;
    constructor(name: string, args: LifecycleHookArgs);
}
export interface LifecycleHookArgs {
    readonly autoscalingGroupName: string;
    readonly defaultResult?: string;
    readonly heartbeatTimeout?: number;
    readonly lifecycleTransition: string;
    readonly lifecycleHookName?: string;
    readonly notificationMetadata?: string;
    readonly notificationTargetArn?: string;
    readonly roleArn?: string;
}

