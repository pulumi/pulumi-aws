import * as lumi from "@lumi/lumi";
export declare class Rule extends lumi.NamedResource implements RuleArgs {
    readonly metricName: string;
    readonly ruleName?: string;
    readonly predicates?: {
        dataId?: string;
        negated: boolean;
        type: string;
    }[];
    constructor(name: string, args: RuleArgs);
}
export interface RuleArgs {
    readonly metricName: string;
    readonly ruleName?: string;
    readonly predicates?: {
        dataId?: string;
        negated: boolean;
        type: string;
    }[];
}

