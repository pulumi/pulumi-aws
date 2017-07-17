import * as lumi from "@lumi/lumi";
export declare class LogMetricFilter extends lumi.NamedResource implements LogMetricFilterArgs {
    readonly logGroupName: string;
    readonly metricTransformation: {
        name: string;
        namespace: string;
        value: string;
    }[];
    readonly logMetricFilterName?: string;
    readonly pattern: string;
    constructor(name: string, args: LogMetricFilterArgs);
}
export interface LogMetricFilterArgs {
    readonly logGroupName: string;
    readonly metricTransformation: {
        name: string;
        namespace: string;
        value: string;
    }[];
    readonly logMetricFilterName?: string;
    readonly pattern: string;
}

