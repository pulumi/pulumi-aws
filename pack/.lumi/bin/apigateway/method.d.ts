import * as lumi from "@lumi/lumi";
export declare class Method extends lumi.NamedResource implements MethodArgs {
    readonly apiKeyRequired?: boolean;
    readonly authorization: string;
    readonly authorizerId?: string;
    readonly httpMethod: string;
    readonly requestModels?: {
        [key: string]: string;
    };
    readonly requestParameters?: {
        [key: string]: boolean;
    };
    readonly requestParametersInJson?: string;
    readonly requestValidatorId?: string;
    readonly resourceId: string;
    readonly restApiId: string;
    constructor(name: string, args: MethodArgs);
}
export interface MethodArgs {
    readonly apiKeyRequired?: boolean;
    readonly authorization: string;
    readonly authorizerId?: string;
    readonly httpMethod: string;
    readonly requestModels?: {
        [key: string]: string;
    };
    readonly requestParameters?: {
        [key: string]: boolean;
    };
    readonly requestParametersInJson?: string;
    readonly requestValidatorId?: string;
    readonly resourceId: string;
    readonly restApiId: string;
}

