import * as lumi from "@lumi/lumi";
import { RestApi } from "./restApi";
export declare class Resource extends lumi.NamedResource implements ResourceArgs {
    readonly parentId: string;
    readonly path: string;
    readonly pathPart: string;
    readonly restApi: RestApi;
    constructor(name: string, args: ResourceArgs);
}
export interface ResourceArgs {
    readonly parentId: string;
    readonly pathPart: string;
    readonly restApi: RestApi;
}

