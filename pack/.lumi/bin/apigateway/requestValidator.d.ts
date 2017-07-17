import * as lumi from "@lumi/lumi";
export declare class RequestValidator extends lumi.NamedResource implements RequestValidatorArgs {
    readonly requestValidatorName?: string;
    readonly restApiId: string;
    readonly validateRequestBody?: boolean;
    readonly validateRequestParameters?: boolean;
    constructor(name: string, args: RequestValidatorArgs);
}
export interface RequestValidatorArgs {
    readonly requestValidatorName?: string;
    readonly restApiId: string;
    readonly validateRequestBody?: boolean;
    readonly validateRequestParameters?: boolean;
}

