import * as lumi from "@lumi/lumi";
export declare class EventSubscription extends lumi.NamedResource implements EventSubscriptionArgs {
    readonly customerAwsId: string;
    readonly enabled?: boolean;
    readonly eventCategories?: string[];
    readonly eventSubscriptionName?: string;
    readonly snsTopic: string;
    readonly sourceIds?: string[];
    readonly sourceType?: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: EventSubscriptionArgs);
}
export interface EventSubscriptionArgs {
    readonly enabled?: boolean;
    readonly eventCategories?: string[];
    readonly eventSubscriptionName?: string;
    readonly snsTopic: string;
    readonly sourceIds?: string[];
    readonly sourceType?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

