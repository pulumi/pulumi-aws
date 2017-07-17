import * as lumi from "@lumi/lumi";
export declare class SpotDatafeedSubscription extends lumi.NamedResource implements SpotDatafeedSubscriptionArgs {
    readonly bucket: string;
    readonly prefix?: string;
    constructor(name: string, args: SpotDatafeedSubscriptionArgs);
}
export interface SpotDatafeedSubscriptionArgs {
    readonly bucket: string;
    readonly prefix?: string;
}

