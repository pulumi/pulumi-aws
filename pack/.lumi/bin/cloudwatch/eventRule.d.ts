import * as lumi from "@lumi/lumi";
export declare class EventRule extends lumi.NamedResource implements EventRuleArgs {
    readonly arn: string;
    readonly description?: string;
    readonly eventPattern?: string;
    readonly isEnabled?: boolean;
    readonly eventRuleName?: string;
    readonly roleArn?: string;
    readonly scheduleExpression?: string;
    constructor(name: string, args: EventRuleArgs);
}
export interface EventRuleArgs {
    readonly description?: string;
    readonly eventPattern?: string;
    readonly isEnabled?: boolean;
    readonly eventRuleName?: string;
    readonly roleArn?: string;
    readonly scheduleExpression?: string;
}

