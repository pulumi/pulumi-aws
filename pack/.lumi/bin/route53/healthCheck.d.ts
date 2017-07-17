import * as lumi from "@lumi/lumi";
export declare class HealthCheck extends lumi.NamedResource implements HealthCheckArgs {
    readonly childHealthThreshold?: number;
    readonly childHealthchecks?: string[];
    readonly cloudwatchAlarmName?: string;
    readonly cloudwatchAlarmRegion?: string;
    readonly enableSni: boolean;
    readonly failureThreshold?: number;
    readonly fqdn?: string;
    readonly insufficientDataHealthStatus?: string;
    readonly invertHealthcheck?: boolean;
    readonly ipAddress?: string;
    readonly measureLatency?: boolean;
    readonly port?: number;
    readonly referenceName?: string;
    readonly requestInterval?: number;
    readonly resourcePath?: string;
    readonly searchString?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
    constructor(name: string, args: HealthCheckArgs);
}
export interface HealthCheckArgs {
    readonly childHealthThreshold?: number;
    readonly childHealthchecks?: string[];
    readonly cloudwatchAlarmName?: string;
    readonly cloudwatchAlarmRegion?: string;
    readonly enableSni?: boolean;
    readonly failureThreshold?: number;
    readonly fqdn?: string;
    readonly insufficientDataHealthStatus?: string;
    readonly invertHealthcheck?: boolean;
    readonly ipAddress?: string;
    readonly measureLatency?: boolean;
    readonly port?: number;
    readonly referenceName?: string;
    readonly requestInterval?: number;
    readonly resourcePath?: string;
    readonly searchString?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly type: string;
}

