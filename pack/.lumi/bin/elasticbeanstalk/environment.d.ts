import * as lumi from "@lumi/lumi";
export declare class Environment extends lumi.NamedResource implements EnvironmentArgs {
    readonly allSettings: {
        name: string;
        namespace: string;
        resource?: string;
        value: string;
    }[];
    readonly application: string;
    readonly autoscalingGroups: string[];
    readonly cname: string;
    readonly cnamePrefix: string;
    readonly description?: string;
    readonly instances: string[];
    readonly launchConfigurations: string[];
    readonly loadBalancers: string[];
    readonly environmentName?: string;
    readonly pollInterval?: string;
    readonly queues: string[];
    readonly setting?: {
        name: string;
        namespace: string;
        resource?: string;
        value: string;
    }[];
    readonly solutionStackName: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly templateName?: string;
    readonly tier?: string;
    readonly triggers: string[];
    readonly versionLabel: string;
    readonly waitForReadyTimeout?: string;
    constructor(name: string, args: EnvironmentArgs);
}
export interface EnvironmentArgs {
    readonly application: string;
    readonly cnamePrefix?: string;
    readonly description?: string;
    readonly environmentName?: string;
    readonly pollInterval?: string;
    readonly setting?: {
        name: string;
        namespace: string;
        resource?: string;
        value: string;
    }[];
    readonly solutionStackName?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly templateName?: string;
    readonly tier?: string;
    readonly versionLabel?: string;
    readonly waitForReadyTimeout?: string;
}

