import * as lumi from "@lumi/lumi";
export declare class BasePathMapping extends lumi.NamedResource implements BasePathMappingArgs {
    readonly apiId: string;
    readonly basePath?: string;
    readonly domainName: string;
    readonly stageName?: string;
    constructor(name: string, args: BasePathMappingArgs);
}
export interface BasePathMappingArgs {
    readonly apiId: string;
    readonly basePath?: string;
    readonly domainName: string;
    readonly stageName?: string;
}

