import * as lumi from "@lumi/lumi";
export declare class ParameterGroup extends lumi.NamedResource implements ParameterGroupArgs {
    readonly arn: string;
    readonly description?: string;
    readonly family: string;
    readonly parameterGroupName: string;
    readonly namePrefix: string;
    readonly parameter?: {
        applyMethod?: string;
        name: string;
        value: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: ParameterGroupArgs);
}
export interface ParameterGroupArgs {
    readonly description?: string;
    readonly family: string;
    readonly parameterGroupName?: string;
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

