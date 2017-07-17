import * as lumi from "@lumi/lumi";
export declare class Stream extends lumi.NamedResource implements StreamArgs {
    readonly arn: string;
    readonly streamName?: string;
    readonly retentionPeriod?: number;
    readonly shardCount: number;
    readonly shardLevelMetrics?: string[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: StreamArgs);
}
export interface StreamArgs {
    readonly arn?: string;
    readonly streamName?: string;
    readonly retentionPeriod?: number;
    readonly shardCount: number;
    readonly shardLevelMetrics?: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

