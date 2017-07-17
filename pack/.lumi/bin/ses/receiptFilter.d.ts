import * as lumi from "@lumi/lumi";
export declare class ReceiptFilter extends lumi.NamedResource implements ReceiptFilterArgs {
    readonly cidr: string;
    readonly receiptFilterName?: string;
    readonly policy: string;
    constructor(name: string, args: ReceiptFilterArgs);
}
export interface ReceiptFilterArgs {
    readonly cidr: string;
    readonly receiptFilterName?: string;
    readonly policy: string;
}

