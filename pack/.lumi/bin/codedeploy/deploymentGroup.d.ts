import * as lumi from "@lumi/lumi";
export declare class DeploymentGroup extends lumi.NamedResource implements DeploymentGroupArgs {
    readonly alarmConfiguration?: {
        alarms?: string[];
        enabled?: boolean;
        ignorePollAlarmFailure?: boolean;
    }[];
    readonly appName: string;
    readonly autoRollbackConfiguration?: {
        enabled?: boolean;
        events?: string[];
    }[];
    readonly autoscalingGroups?: string[];
    readonly deploymentConfigName?: string;
    readonly deploymentGroupName: string;
    readonly ec2TagFilter?: {
        key?: string;
        type?: string;
        value?: string;
    }[];
    readonly onPremisesInstanceTagFilter?: {
        key?: string;
        type?: string;
        value?: string;
    }[];
    readonly serviceRoleArn: string;
    readonly triggerConfiguration?: {
        triggerEvents: string[];
        triggerName: string;
        triggerTargetArn: string;
    }[];
    constructor(name: string, args: DeploymentGroupArgs);
}
export interface DeploymentGroupArgs {
    readonly alarmConfiguration?: {
        alarms?: string[];
        enabled?: boolean;
        ignorePollAlarmFailure?: boolean;
    }[];
    readonly appName: string;
    readonly autoRollbackConfiguration?: {
        enabled?: boolean;
        events?: string[];
    }[];
    readonly autoscalingGroups?: string[];
    readonly deploymentConfigName?: string;
    readonly deploymentGroupName: string;
    readonly ec2TagFilter?: {
        key?: string;
        type?: string;
        value?: string;
    }[];
    readonly onPremisesInstanceTagFilter?: {
        key?: string;
        type?: string;
        value?: string;
    }[];
    readonly serviceRoleArn: string;
    readonly triggerConfiguration?: {
        triggerEvents: string[];
        triggerName: string;
        triggerTargetArn: string;
    }[];
}

