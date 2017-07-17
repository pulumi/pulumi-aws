import * as lumi from "@lumi/lumi";
export declare class EventDestination extends lumi.NamedResource implements EventDestinationArgs {
    readonly cloudwatchDestination?: {
        defaultValue: string;
        dimensionName: string;
        valueSource: string;
    }[];
    readonly configurationSetName: string;
    readonly enabled?: boolean;
    readonly kinesisDestination?: {
        roleArn: string;
        streamArn: string;
    }[];
    readonly matchingTypes: string[];
    readonly eventDestinationName?: string;
    constructor(name: string, args: EventDestinationArgs);
}
export interface EventDestinationArgs {
    readonly cloudwatchDestination?: {
        defaultValue: string;
        dimensionName: string;
        valueSource: string;
    }[];
    readonly configurationSetName: string;
    readonly enabled?: boolean;
    readonly kinesisDestination?: {
        roleArn: string;
        streamArn: string;
    }[];
    readonly matchingTypes: string[];
    readonly eventDestinationName?: string;
}

