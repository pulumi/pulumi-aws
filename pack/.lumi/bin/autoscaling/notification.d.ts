import * as lumi from "@lumi/lumi";
export declare class Notification extends lumi.NamedResource implements NotificationArgs {
    readonly groupNames: string[];
    readonly notifications: string[];
    readonly topicArn: string;
    constructor(name: string, args: NotificationArgs);
}
export interface NotificationArgs {
    readonly groupNames: string[];
    readonly notifications: string[];
    readonly topicArn: string;
}

