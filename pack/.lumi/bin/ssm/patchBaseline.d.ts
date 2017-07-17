import * as lumi from "@lumi/lumi";
export declare class PatchBaseline extends lumi.NamedResource implements PatchBaselineArgs {
    readonly approvalRule?: {
        approveAfterDays: number;
        patchFilter: {
            key: string;
            values: string[];
        }[];
    }[];
    readonly approvedPatches?: string[];
    readonly description?: string;
    readonly globalFilter?: {
        key: string;
        values: string[];
    }[];
    readonly patchBaselineName?: string;
    readonly rejectedPatches?: string[];
    constructor(name: string, args: PatchBaselineArgs);
}
export interface PatchBaselineArgs {
    readonly approvalRule?: {
        approveAfterDays: number;
        patchFilter: {
            key: string;
            values: string[];
        }[];
    }[];
    readonly approvedPatches?: string[];
    readonly description?: string;
    readonly globalFilter?: {
        key: string;
        values: string[];
    }[];
    readonly patchBaselineName?: string;
    readonly rejectedPatches?: string[];
}

