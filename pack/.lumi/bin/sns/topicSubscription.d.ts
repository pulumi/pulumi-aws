import * as lumi from "@lumi/lumi";
export declare class TopicSubscription extends lumi.NamedResource implements TopicSubscriptionArgs {
    readonly arn: string;
    readonly confirmationTimeoutInMinutes?: number;
    readonly deliveryPolicy?: string;
    readonly endpoint: string;
    readonly endpointAutoConfirms?: boolean;
    readonly protocol: string;
    readonly rawMessageDelivery?: boolean;
    readonly topicArn: string;
    constructor(name: string, args: TopicSubscriptionArgs);
}
export interface TopicSubscriptionArgs {
    readonly confirmationTimeoutInMinutes?: number;
    readonly deliveryPolicy?: string;
    readonly endpoint: string;
    readonly endpointAutoConfirms?: boolean;
    readonly protocol: string;
    readonly rawMessageDelivery?: boolean;
    readonly topicArn: string;
}

