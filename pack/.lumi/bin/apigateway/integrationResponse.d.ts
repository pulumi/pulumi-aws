import * as lumi from "@lumi/lumi";
export declare class IntegrationResponse extends lumi.NamedResource implements IntegrationResponseArgs {
    readonly contentHandling?: string;
    readonly httpMethod: string;
    readonly resourceId: string;
    readonly responseParameters?: {
        [key: string]: string;
    };
    readonly responseParametersInJson?: string;
    readonly responseTemplates?: {
        [key: string]: string;
    };
    readonly restApiId: string;
    readonly selectionPattern?: string;
    readonly statusCode: string;
    constructor(name: string, args: IntegrationResponseArgs);
}
export interface IntegrationResponseArgs {
    readonly contentHandling?: string;
    readonly httpMethod: string;
    readonly resourceId: string;
    readonly responseParameters?: {
        [key: string]: string;
    };
    readonly responseParametersInJson?: string;
    readonly responseTemplates?: {
        [key: string]: string;
    };
    readonly restApiId: string;
    readonly selectionPattern?: string;
    readonly statusCode: string;
}

