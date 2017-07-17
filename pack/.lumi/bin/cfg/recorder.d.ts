import * as lumi from "@lumi/lumi";
export declare class Recorder extends lumi.NamedResource implements RecorderArgs {
    readonly recorderName?: string;
    readonly recordingGroup: {
        allSupported?: boolean;
        includeGlobalResourceTypes?: boolean;
        resourceTypes?: string[];
    }[];
    readonly roleArn: string;
    constructor(name: string, args: RecorderArgs);
}
export interface RecorderArgs {
    readonly recorderName?: string;
    readonly recordingGroup?: {
        allSupported?: boolean;
        includeGlobalResourceTypes?: boolean;
        resourceTypes?: string[];
    }[];
    readonly roleArn: string;
}

