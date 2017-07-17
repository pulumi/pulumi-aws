import * as lumi from "@lumi/lumi";
export declare class PatchGroup extends lumi.NamedResource implements PatchGroupArgs {
    readonly baselineId: string;
    readonly patchGroup: string;
    constructor(name: string, args: PatchGroupArgs);
}
export interface PatchGroupArgs {
    readonly baselineId: string;
    readonly patchGroup: string;
}

