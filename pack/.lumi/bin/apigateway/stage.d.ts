import * as lumi from "@lumi/lumi";
import { Deployment } from "./deployment";
import { RestApi } from "./restApi";
export declare class Stage extends lumi.NamedResource implements StageArgs {
    readonly cacheClusterEnabled?: boolean;
    readonly cacheClusterSize?: string;
    readonly clientCertificateId?: string;
    readonly deployment: Deployment;
    readonly description?: string;
    readonly documentationVersion?: string;
    readonly restApi: RestApi;
    readonly stageName: string;
    readonly variables?: {
        [key: string]: any;
    };
    constructor(name: string, args: StageArgs);
}
export interface StageArgs {
    readonly cacheClusterEnabled?: boolean;
    readonly cacheClusterSize?: string;
    readonly clientCertificateId?: string;
    readonly deployment: Deployment;
    readonly description?: string;
    readonly documentationVersion?: string;
    readonly restApi: RestApi;
    readonly stageName: string;
    readonly variables?: {
        [key: string]: any;
    };
}

