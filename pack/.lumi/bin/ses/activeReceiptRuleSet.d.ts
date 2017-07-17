import * as lumi from "@lumi/lumi";
export declare class ActiveReceiptRuleSet extends lumi.NamedResource implements ActiveReceiptRuleSetArgs {
    readonly ruleSetName: string;
    constructor(name: string, args: ActiveReceiptRuleSetArgs);
}
export interface ActiveReceiptRuleSetArgs {
    readonly ruleSetName: string;
}

