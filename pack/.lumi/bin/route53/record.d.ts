import * as lumi from "@lumi/lumi";
export declare class Record extends lumi.NamedResource implements RecordArgs {
    readonly alias?: {
        evaluateTargetHealth: boolean;
        name: string;
        zoneId: string;
    }[];
    readonly failoverRoutingPolicy?: {
        type: string;
    }[];
    readonly fqdn: string;
    readonly geolocationRoutingPolicy?: {
        continent?: string;
        country?: string;
        subdivision?: string;
    }[];
    readonly healthCheckId?: string;
    readonly latencyRoutingPolicy?: {
        region: string;
    }[];
    readonly recordName?: string;
    readonly records?: string[];
    readonly setIdentifier?: string;
    readonly ttl?: number;
    readonly type: string;
    readonly weightedRoutingPolicy?: {
        weight: number;
    }[];
    readonly zoneId: string;
    constructor(name: string, args: RecordArgs);
}
export interface RecordArgs {
    readonly alias?: {
        evaluateTargetHealth: boolean;
        name: string;
        zoneId: string;
    }[];
    readonly failoverRoutingPolicy?: {
        type: string;
    }[];
    readonly geolocationRoutingPolicy?: {
        continent?: string;
        country?: string;
        subdivision?: string;
    }[];
    readonly healthCheckId?: string;
    readonly latencyRoutingPolicy?: {
        region: string;
    }[];
    readonly recordName?: string;
    readonly records?: string[];
    readonly setIdentifier?: string;
    readonly ttl?: number;
    readonly type: string;
    readonly weightedRoutingPolicy?: {
        weight: number;
    }[];
    readonly zoneId: string;
}

