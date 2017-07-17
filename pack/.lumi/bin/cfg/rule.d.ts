import * as lumi from "@lumi/lumi";
export declare class Rule extends lumi.NamedResource implements RuleArgs {
    readonly arn: string;
    readonly description?: string;
    readonly inputParameters?: string;
    readonly maximumExecutionFrequency?: string;
    readonly ruleName?: string;
    readonly ruleId: string;
    readonly scope?: {
        complianceResourceId?: string;
        complianceResourceTypes?: string[];
        tagKey?: string;
        tagValue?: string;
    }[];
    readonly source: {
        owner: string;
        sourceDetail?: {
            eventSource?: string;
            maximumExecutionFrequency?: string;
            messageType?: string;
        }[];
        sourceIdentifier: string;
    }[];
    constructor(name: string, args: RuleArgs);
}
export interface RuleArgs {
    readonly description?: string;
    readonly inputParameters?: string;
    readonly maximumExecutionFrequency?: string;
    readonly ruleName?: string;
    readonly scope?: {
        complianceResourceId?: string;
        complianceResourceTypes?: string[];
        tagKey?: string;
        tagValue?: string;
    }[];
    readonly source: {
        owner: string;
        sourceDetail?: {
            eventSource?: string;
            maximumExecutionFrequency?: string;
            messageType?: string;
        }[];
        sourceIdentifier: string;
    }[];
}

