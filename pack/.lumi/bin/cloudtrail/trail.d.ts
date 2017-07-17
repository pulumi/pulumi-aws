import * as lumi from "@lumi/lumi";
export declare class Trail extends lumi.NamedResource implements TrailArgs {
    readonly arn: string;
    readonly cloudWatchLogsGroupArn?: string;
    readonly cloudWatchLogsRoleArn?: string;
    readonly enableLogFileValidation?: boolean;
    readonly enableLogging?: boolean;
    readonly homeRegion: string;
    readonly includeGlobalServiceEvents?: boolean;
    readonly isMultiRegionTrail?: boolean;
    readonly kmsKeyId?: string;
    readonly trailName?: string;
    readonly s3BucketName: string;
    readonly s3KeyPrefix?: string;
    readonly snsTopicName?: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: TrailArgs);
}
export interface TrailArgs {
    readonly cloudWatchLogsGroupArn?: string;
    readonly cloudWatchLogsRoleArn?: string;
    readonly enableLogFileValidation?: boolean;
    readonly enableLogging?: boolean;
    readonly includeGlobalServiceEvents?: boolean;
    readonly isMultiRegionTrail?: boolean;
    readonly kmsKeyId?: string;
    readonly trailName?: string;
    readonly s3BucketName: string;
    readonly s3KeyPrefix?: string;
    readonly snsTopicName?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

