import * as lumi from "@lumi/lumi";
export declare class Parameter extends lumi.NamedResource implements ParameterArgs {
    readonly keyId?: string;
    readonly parameterName?: string;
    readonly overwrite?: boolean;
    readonly type: string;
    readonly value: string;
    constructor(name: string, args: ParameterArgs);
}
export interface ParameterArgs {
    readonly keyId?: string;
    readonly parameterName?: string;
    readonly overwrite?: boolean;
    readonly type: string;
    readonly value: string;
}

