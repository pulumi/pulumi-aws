import * as lumi from "@lumi/lumi";
export declare class Notification extends lumi.NamedResource implements NotificationArgs {
    readonly bucket: string;
    readonly lambdaFunction?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        lambdaFunctionArn?: string;
    }[];
    readonly queue?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        queueArn: string;
    }[];
    readonly topic?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        topicArn: string;
    }[];
    constructor(name: string, args: NotificationArgs);
}
export interface NotificationArgs {
    readonly bucket: string;
    readonly lambdaFunction?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        lambdaFunctionArn?: string;
    }[];
    readonly queue?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        queueArn: string;
    }[];
    readonly topic?: {
        events: string[];
        filterPrefix?: string;
        filterSuffix?: string;
        id: string;
        topicArn: string;
    }[];
}

