import * as lumi from "@lumi/lumi";
export declare class ListenerRule extends lumi.NamedResource implements ListenerRuleArgs {
    readonly action: {
        targetGroupArn: string;
        type: string;
    }[];
    readonly arn: string;
    readonly condition: {
        field?: string;
        values?: string[];
    }[];
    readonly listenerArn: string;
    readonly priority: number;
    constructor(name: string, args: ListenerRuleArgs);
}
export interface ListenerRuleArgs {
    readonly action: {
        targetGroupArn: string;
        type: string;
    }[];
    readonly condition: {
        field?: string;
        values?: string[];
    }[];
    readonly listenerArn: string;
    readonly priority: number;
}

