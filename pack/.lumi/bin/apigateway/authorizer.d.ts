import * as lumi from "@lumi/lumi";
export declare class Authorizer extends lumi.NamedResource implements AuthorizerArgs {
    readonly authorizerCredentials?: string;
    readonly authorizerResultTtlInSeconds?: number;
    readonly authorizerUri: string;
    readonly identitySource?: string;
    readonly identityValidationExpression?: string;
    readonly authorizerName?: string;
    readonly restApiId: string;
    readonly type?: string;
    constructor(name: string, args: AuthorizerArgs);
}
export interface AuthorizerArgs {
    readonly authorizerCredentials?: string;
    readonly authorizerResultTtlInSeconds?: number;
    readonly authorizerUri: string;
    readonly identitySource?: string;
    readonly identityValidationExpression?: string;
    readonly authorizerName?: string;
    readonly restApiId: string;
    readonly type?: string;
}

