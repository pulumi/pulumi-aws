import * as lumi from "@lumi/lumi";
export declare class EventSourceMapping extends lumi.NamedResource implements EventSourceMappingArgs {
    readonly batchSize?: number;
    readonly enabled?: boolean;
    readonly eventSourceArn: string;
    readonly functionArn: string;
    readonly functionName: string;
    readonly lastModified: string;
    readonly lastProcessingResult: string;
    readonly startingPosition: string;
    readonly state: string;
    readonly stateTransitionReason: string;
    readonly uuid: string;
    constructor(name: string, args: EventSourceMappingArgs);
}
export interface EventSourceMappingArgs {
    readonly batchSize?: number;
    readonly enabled?: boolean;
    readonly eventSourceArn: string;
    readonly functionName: string;
    readonly startingPosition: string;
}

