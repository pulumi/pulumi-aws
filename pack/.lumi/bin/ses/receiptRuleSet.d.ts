import * as lumi from "@lumi/lumi";
export declare class ReceiptRuleSet extends lumi.NamedResource implements ReceiptRuleSetArgs {
    readonly ruleSetName: string;
    constructor(name: string, args: ReceiptRuleSetArgs);
}
export interface ReceiptRuleSetArgs {
    readonly ruleSetName: string;
}

