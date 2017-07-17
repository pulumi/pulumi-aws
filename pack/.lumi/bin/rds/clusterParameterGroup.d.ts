import * as lumi from "@lumi/lumi";
export declare class ClusterParameterGroup extends lumi.NamedResource implements ClusterParameterGroupArgs {
    readonly arn: string;
    readonly description?: string;
    readonly family: string;
    readonly clusterParameterGroupName: string;
    readonly namePrefix: string;
    readonly parameter?: {
        applyMethod?: string;
        name: string;
        value: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: ClusterParameterGroupArgs);
}
export interface ClusterParameterGroupArgs {
    readonly description?: string;
    readonly family: string;
    readonly clusterParameterGroupName?: string;
    readonly namePrefix?: string;
    readonly parameter?: {
        applyMethod?: string;
        name: string;
        value: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
}

