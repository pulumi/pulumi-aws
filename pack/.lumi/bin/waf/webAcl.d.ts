import * as lumi from "@lumi/lumi";
export declare class WebAcl extends lumi.NamedResource implements WebAclArgs {
    readonly defaultAction: {
        type: string;
    }[];
    readonly metricName: string;
    readonly webAclName?: string;
    readonly rules?: {
        action: {
            type: string;
        }[];
        priority: number;
        ruleId: string;
    }[];
    constructor(name: string, args: WebAclArgs);
}
export interface WebAclArgs {
    readonly defaultAction: {
        type: string;
    }[];
    readonly metricName: string;
    readonly webAclName?: string;
    readonly rules?: {
        action: {
            type: string;
        }[];
        priority: number;
        ruleId: string;
    }[];
}

