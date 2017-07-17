import * as lumi from "@lumi/lumi";
export declare class Topic extends lumi.NamedResource implements TopicArgs {
    readonly arn: string;
    readonly deliveryPolicy?: string;
    readonly displayName?: string;
    readonly topicName?: string;
    readonly policy: string;
    constructor(name: string, args: TopicArgs);
}
export interface TopicArgs {
    readonly deliveryPolicy?: string;
    readonly displayName?: string;
    readonly topicName?: string;
    readonly policy?: string;
}

