import * as lumi from "@lumi/lumi";
export declare class UsagePlan extends lumi.NamedResource implements UsagePlanArgs {
    readonly apiStages?: {
        apiId: string;
        stage: string;
    }[];
    readonly description?: string;
    readonly usagePlanName?: string;
    readonly productCode?: string;
    readonly quotaSettings?: {
        limit: number;
        offset?: number;
        period: string;
    }[];
    readonly throttleSettings?: {
        burstLimit?: number;
        rateLimit?: number;
    }[];
    constructor(name: string, args: UsagePlanArgs);
}
export interface UsagePlanArgs {
    readonly apiStages?: {
        apiId: string;
        stage: string;
    }[];
    readonly description?: string;
    readonly usagePlanName?: string;
    readonly productCode?: string;
    readonly quotaSettings?: {
        limit: number;
        offset?: number;
        period: string;
    }[];
    readonly throttleSettings?: {
        burstLimit?: number;
        rateLimit?: number;
    }[];
}

