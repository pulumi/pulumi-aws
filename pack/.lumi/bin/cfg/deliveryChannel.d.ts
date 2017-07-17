import * as lumi from "@lumi/lumi";
export declare class DeliveryChannel extends lumi.NamedResource implements DeliveryChannelArgs {
    readonly deliveryChannelName?: string;
    readonly s3BucketName: string;
    readonly s3KeyPrefix?: string;
    readonly snapshotDeliveryProperties?: {
        deliveryFrequency?: string;
    }[];
    readonly snsTopicArn?: string;
    constructor(name: string, args: DeliveryChannelArgs);
}
export interface DeliveryChannelArgs {
    readonly deliveryChannelName?: string;
    readonly s3BucketName: string;
    readonly s3KeyPrefix?: string;
    readonly snapshotDeliveryProperties?: {
        deliveryFrequency?: string;
    }[];
    readonly snsTopicArn?: string;
}

