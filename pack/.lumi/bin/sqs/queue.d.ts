import * as lumi from "@lumi/lumi";
export declare class Queue extends lumi.NamedResource implements QueueArgs {
    readonly arn: string;
    readonly contentBasedDeduplication?: boolean;
    readonly delaySeconds?: number;
    readonly fifoQueue?: boolean;
    readonly kmsDataKeyReusePeriodSeconds: number;
    readonly kmsMasterKeyId?: string;
    readonly maxMessageSize?: number;
    readonly messageRetentionSeconds?: number;
    readonly queueName: string;
    readonly namePrefix?: string;
    readonly policy: string;
    readonly receiveWaitTimeSeconds?: number;
    readonly redrivePolicy?: string;
    readonly visibilityTimeoutSeconds?: number;
    constructor(name: string, args: QueueArgs);
}
export interface QueueArgs {
    readonly contentBasedDeduplication?: boolean;
    readonly delaySeconds?: number;
    readonly fifoQueue?: boolean;
    readonly kmsDataKeyReusePeriodSeconds?: number;
    readonly kmsMasterKeyId?: string;
    readonly maxMessageSize?: number;
    readonly messageRetentionSeconds?: number;
    readonly queueName?: string;
    readonly namePrefix?: string;
    readonly policy?: string;
    readonly receiveWaitTimeSeconds?: number;
    readonly redrivePolicy?: string;
    readonly visibilityTimeoutSeconds?: number;
}

