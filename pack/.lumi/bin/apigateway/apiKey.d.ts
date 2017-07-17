import * as lumi from "@lumi/lumi";
export declare class ApiKey extends lumi.NamedResource implements ApiKeyArgs {
    readonly createdDate: string;
    readonly description?: string;
    readonly enabled?: boolean;
    readonly lastUpdatedDate: string;
    readonly apiKeyName?: string;
    readonly stageKey?: {
        restApiId: string;
        stageName: string;
    }[];
    readonly value: string;
    constructor(name: string, args: ApiKeyArgs);
}
export interface ApiKeyArgs {
    readonly description?: string;
    readonly enabled?: boolean;
    readonly apiKeyName?: string;
    readonly stageKey?: {
        restApiId: string;
        stageName: string;
    }[];
    readonly value?: string;
}

