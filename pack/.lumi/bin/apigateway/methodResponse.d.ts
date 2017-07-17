import * as lumi from "@lumi/lumi";
export declare class MethodResponse extends lumi.NamedResource implements MethodResponseArgs {
    readonly httpMethod: string;
    readonly resourceId: string;
    readonly responseModels?: {
        [key: string]: string;
    };
    readonly responseParameters?: {
        [key: string]: boolean;
    };
    readonly responseParametersInJson?: string;
    readonly restApiId: string;
    readonly statusCode: string;
    constructor(name: string, args: MethodResponseArgs);
}
export interface MethodResponseArgs {
    readonly httpMethod: string;
    readonly resourceId: string;
    readonly responseModels?: {
        [key: string]: string;
    };
    readonly responseParameters?: {
        [key: string]: boolean;
    };
    readonly responseParametersInJson?: string;
    readonly restApiId: string;
    readonly statusCode: string;
}

