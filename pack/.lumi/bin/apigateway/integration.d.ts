import * as lumi from "@lumi/lumi";
import { Resource } from "./resource";
import { RestApi } from "./restApi";
export declare class Integration extends lumi.NamedResource implements IntegrationArgs {
    readonly cacheKeyParameters?: string[];
    readonly cacheNamespace: string;
    readonly contentHandling?: string;
    readonly credentials?: string;
    readonly httpMethod: string;
    readonly integrationHttpMethod?: string;
    readonly passthroughBehavior: string;
    readonly requestParameters?: {
        [key: string]: string;
    };
    readonly requestParametersInJson?: string;
    readonly requestTemplates?: {
        [key: string]: string;
    };
    readonly resource: Resource;
    readonly restApi: RestApi;
    readonly type: string;
    readonly uri?: string;
    constructor(name: string, args: IntegrationArgs);
}
export interface IntegrationArgs {
    readonly cacheKeyParameters?: string[];
    readonly cacheNamespace?: string;
    readonly contentHandling?: string;
    readonly credentials?: string;
    readonly httpMethod: string;
    readonly integrationHttpMethod?: string;
    readonly passthroughBehavior?: string;
    readonly requestParameters?: {
        [key: string]: string;
    };
    readonly requestParametersInJson?: string;
    readonly requestTemplates?: {
        [key: string]: string;
    };
    readonly resource: Resource;
    readonly restApi: RestApi;
    readonly type: string;
    readonly uri?: string;
}

