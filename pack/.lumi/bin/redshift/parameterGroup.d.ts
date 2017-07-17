import * as lumi from "@lumi/lumi";
export declare class ParameterGroup extends lumi.NamedResource implements ParameterGroupArgs {
    readonly description?: string;
    readonly family: string;
    readonly parameterGroupName?: string;
    readonly parameter?: {
        name: string;
        value: string;
    }[];
    constructor(name: string, args: ParameterGroupArgs);
}
export interface ParameterGroupArgs {
    readonly description?: string;
    readonly family: string;
    readonly parameterGroupName?: string;
    readonly parameter?: {
        name: string;
        value: string;
    }[];
}

