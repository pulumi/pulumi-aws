import * as lumi from "@lumi/lumi";
export declare class ConfgurationSet extends lumi.NamedResource implements ConfgurationSetArgs {
    readonly confgurationSetName?: string;
    constructor(name: string, args: ConfgurationSetArgs);
}
export interface ConfgurationSetArgs {
    readonly confgurationSetName?: string;
}

