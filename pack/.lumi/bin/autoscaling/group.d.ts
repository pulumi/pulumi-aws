import * as lumi from "@lumi/lumi";
export declare class Group extends lumi.NamedResource implements GroupArgs {
    readonly arn: string;
    readonly availabilityZones: string[];
    readonly defaultCooldown: number;
    readonly desiredCapacity: number;
    readonly enabledMetrics?: string[];
    readonly forceDelete?: boolean;
    readonly healthCheckGracePeriod?: number;
    readonly healthCheckType: string;
    readonly initialLifecycleHook?: {
        defaultResult: string;
        heartbeatTimeout?: number;
        lifecycleTransition: string;
        name: string;
        notificationMetadata?: string;
        notificationTargetArn?: string;
        roleArn?: string;
    }[];
    readonly launchConfiguration: string;
    readonly loadBalancers: string[];
    readonly maxSize: number;
    readonly metricsGranularity?: string;
    readonly minElbCapacity?: number;
    readonly minSize: number;
    readonly groupName: string;
    readonly namePrefix?: string;
    readonly placementGroup?: string;
    readonly protectFromScaleIn?: boolean;
    readonly suspendedProcesses?: string[];
    readonly tag?: {
        key: string;
        propagateAtLaunch: boolean;
        value: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    }[];
    readonly targetGroupArns: string[];
    readonly terminationPolicies?: string[];
    readonly vpcZoneIdentifier: string[];
    readonly waitForCapacityTimeout?: string;
    readonly waitForElbCapacity?: number;
    constructor(name: string, args: GroupArgs);
}
export interface GroupArgs {
    readonly availabilityZones?: string[];
    readonly defaultCooldown?: number;
    readonly desiredCapacity?: number;
    readonly enabledMetrics?: string[];
    readonly forceDelete?: boolean;
    readonly healthCheckGracePeriod?: number;
    readonly healthCheckType?: string;
    readonly initialLifecycleHook?: {
        defaultResult: string;
        heartbeatTimeout?: number;
        lifecycleTransition: string;
        name: string;
        notificationMetadata?: string;
        notificationTargetArn?: string;
        roleArn?: string;
    }[];
    readonly launchConfiguration: string;
    readonly loadBalancers?: string[];
    readonly maxSize: number;
    readonly metricsGranularity?: string;
    readonly minElbCapacity?: number;
    readonly minSize: number;
    readonly groupName?: string;
    readonly namePrefix?: string;
    readonly placementGroup?: string;
    readonly protectFromScaleIn?: boolean;
    readonly suspendedProcesses?: string[];
    readonly tag?: {
        key: string;
        propagateAtLaunch: boolean;
        value: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    }[];
    readonly targetGroupArns?: string[];
    readonly terminationPolicies?: string[];
    readonly vpcZoneIdentifier?: string[];
    readonly waitForCapacityTimeout?: string;
    readonly waitForElbCapacity?: number;
}

