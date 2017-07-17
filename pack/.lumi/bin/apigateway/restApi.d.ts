import * as lumi from "@lumi/lumi";
export declare class RestApi extends lumi.NamedResource implements RestApiArgs {
    readonly binaryMediaTypes?: string[];
    readonly createdDate: string;
    readonly description?: string;
    readonly restApiName?: string;
    readonly rootResourceId: string;
    constructor(name: string, args: RestApiArgs);
}
export interface RestApiArgs {
    readonly binaryMediaTypes?: string[];
    readonly description?: string;
    readonly restApiName?: string;
}

