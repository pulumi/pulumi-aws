import * as lumi from "@lumi/lumi";
export declare class Service extends lumi.NamedResource implements ServiceArgs {
    readonly cluster: string;
    readonly deploymentMaximumPercent?: number;
    readonly deploymentMinimumHealthyPercent?: number;
    readonly desiredCount?: number;
    readonly iamRole?: string;
    readonly loadBalancer?: {
        containerName: string;
        containerPort: number;
        elbName?: string;
        targetGroupArn?: string;
    }[];
    readonly serviceName?: string;
    readonly placementConstraints?: {
        expression?: string;
        type: string;
    }[];
    readonly placementStrategy?: {
        field?: string;
        type: string;
    }[];
    readonly taskDefinition: string;
    constructor(name: string, args: ServiceArgs);
}
export interface ServiceArgs {
    readonly cluster?: string;
    readonly deploymentMaximumPercent?: number;
    readonly deploymentMinimumHealthyPercent?: number;
    readonly desiredCount?: number;
    readonly iamRole?: string;
    readonly loadBalancer?: {
        containerName: string;
        containerPort: number;
        elbName?: string;
        targetGroupArn?: string;
    }[];
    readonly serviceName?: string;
    readonly placementConstraints?: {
        expression?: string;
        type: string;
    }[];
    readonly placementStrategy?: {
        field?: string;
        type: string;
    }[];
    readonly taskDefinition: string;
}

