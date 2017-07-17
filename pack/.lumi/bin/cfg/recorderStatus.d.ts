import * as lumi from "@lumi/lumi";
export declare class RecorderStatus extends lumi.NamedResource implements RecorderStatusArgs {
    readonly isEnabled: boolean;
    readonly recorderStatusName?: string;
    constructor(name: string, args: RecorderStatusArgs);
}
export interface RecorderStatusArgs {
    readonly isEnabled: boolean;
    readonly recorderStatusName?: string;
}

