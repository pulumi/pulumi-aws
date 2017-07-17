import * as lumi from "@lumi/lumi";
export declare class FirehoseDeliveryStream extends lumi.NamedResource implements FirehoseDeliveryStreamArgs {
    readonly arn: string;
    readonly destination: string;
    readonly destinationId: string;
    readonly elasticsearchConfiguration?: {
        bufferingInterval?: number;
        bufferingSize?: number;
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        domainArn: string;
        indexName: string;
        indexRotationPeriod?: string;
        retryDuration?: number;
        roleArn: string;
        s3BackupMode?: string;
        typeName?: string;
    }[];
    readonly firehoseDeliveryStreamName?: string;
    readonly redshiftConfiguration?: {
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        clusterJdbcurl: string;
        copyOptions?: string;
        dataTableColumns?: string;
        dataTableName: string;
        password: string;
        retryDuration?: number;
        roleArn: string;
        username: string;
    }[];
    readonly s3Configuration: {
        bucketArn: string;
        bufferInterval?: number;
        bufferSize?: number;
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        compressionFormat?: string;
        kmsKeyArn?: string;
        prefix?: string;
        roleArn: string;
    }[];
    readonly versionId: string;
    constructor(name: string, args: FirehoseDeliveryStreamArgs);
}
export interface FirehoseDeliveryStreamArgs {
    readonly arn?: string;
    readonly destination: string;
    readonly destinationId?: string;
    readonly elasticsearchConfiguration?: {
        bufferingInterval?: number;
        bufferingSize?: number;
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        domainArn: string;
        indexName: string;
        indexRotationPeriod?: string;
        retryDuration?: number;
        roleArn: string;
        s3BackupMode?: string;
        typeName?: string;
    }[];
    readonly firehoseDeliveryStreamName?: string;
    readonly redshiftConfiguration?: {
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        clusterJdbcurl: string;
        copyOptions?: string;
        dataTableColumns?: string;
        dataTableName: string;
        password: string;
        retryDuration?: number;
        roleArn: string;
        username: string;
    }[];
    readonly s3Configuration: {
        bucketArn: string;
        bufferInterval?: number;
        bufferSize?: number;
        cloudwatchLoggingOptions: {
            enabled?: boolean;
            logGroupName?: string;
            logStreamName?: string;
        }[];
        compressionFormat?: string;
        kmsKeyArn?: string;
        prefix?: string;
        roleArn: string;
    }[];
    readonly versionId?: string;
}

