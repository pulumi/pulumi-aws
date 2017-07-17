import * as lumi from "@lumi/lumi";
export declare class Trigger extends lumi.NamedResource implements TriggerArgs {
    readonly configurationId: string;
    readonly repositoryName: string;
    readonly trigger: {
        branches?: string[];
        customData?: string;
        destinationArn: string;
        events: string[];
        name: string;
    }[];
    constructor(name: string, args: TriggerArgs);
}
export interface TriggerArgs {
    readonly repositoryName: string;
    readonly trigger: {
        branches?: string[];
        customData?: string;
        destinationArn: string;
        events: string[];
        name: string;
    }[];
}

