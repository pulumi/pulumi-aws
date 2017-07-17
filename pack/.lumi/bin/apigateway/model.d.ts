import * as lumi from "@lumi/lumi";
export declare class Model extends lumi.NamedResource implements ModelArgs {
    readonly contentType: string;
    readonly description?: string;
    readonly modelName?: string;
    readonly restApiId: string;
    readonly schema?: string;
    constructor(name: string, args: ModelArgs);
}
export interface ModelArgs {
    readonly contentType: string;
    readonly description?: string;
    readonly modelName?: string;
    readonly restApiId: string;
    readonly schema?: string;
}

