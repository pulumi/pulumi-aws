import * as lumi from "@lumi/lumi";
export declare class MethodSettings extends lumi.NamedResource implements MethodSettingsArgs {
    readonly methodPath: string;
    readonly restApiId: string;
    readonly settings: {
        cacheDataEncrypted?: boolean;
        cacheTtlInSeconds?: number;
        cachingEnabled?: boolean;
        dataTraceEnabled?: boolean;
        loggingLevel?: string;
        metricsEnabled?: boolean;
        requireAuthorizationForCacheControl?: boolean;
        throttlingBurstLimit?: number;
        throttlingRateLimit?: number;
        unauthorizedCacheControlHeaderStrategy?: string;
    }[];
    readonly stageName: string;
    constructor(name: string, args: MethodSettingsArgs);
}
export interface MethodSettingsArgs {
    readonly methodPath: string;
    readonly restApiId: string;
    readonly settings: {
        cacheDataEncrypted?: boolean;
        cacheTtlInSeconds?: number;
        cachingEnabled?: boolean;
        dataTraceEnabled?: boolean;
        loggingLevel?: string;
        metricsEnabled?: boolean;
        requireAuthorizationForCacheControl?: boolean;
        throttlingBurstLimit?: number;
        throttlingRateLimit?: number;
        unauthorizedCacheControlHeaderStrategy?: string;
    }[];
    readonly stageName: string;
}

