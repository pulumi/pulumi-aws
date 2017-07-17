import * as lumi from "@lumi/lumi";
export declare class TaskDefinition extends lumi.NamedResource implements TaskDefinitionArgs {
    readonly arn: string;
    readonly containerDefinitions: string;
    readonly family: string;
    readonly networkMode: string;
    readonly placementConstraints?: {
        expression?: string;
        type: string;
    }[];
    readonly revision: number;
    readonly taskRoleArn?: string;
    readonly volume?: {
        hostPath?: string;
        name: string;
    }[];
    constructor(name: string, args: TaskDefinitionArgs);
}
export interface TaskDefinitionArgs {
    readonly containerDefinitions: string;
    readonly family: string;
    readonly networkMode?: string;
    readonly placementConstraints?: {
        expression?: string;
        type: string;
    }[];
    readonly taskRoleArn?: string;
    readonly volume?: {
        hostPath?: string;
        name: string;
    }[];
}

