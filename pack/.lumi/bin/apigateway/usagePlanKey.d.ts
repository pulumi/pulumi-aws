import * as lumi from "@lumi/lumi";
export declare class UsagePlanKey extends lumi.NamedResource implements UsagePlanKeyArgs {
    readonly keyId: string;
    readonly keyType: string;
    readonly usagePlanKeyName: string;
    readonly usagePlanId: string;
    readonly value: string;
    constructor(name: string, args: UsagePlanKeyArgs);
}
export interface UsagePlanKeyArgs {
    readonly keyId: string;
    readonly keyType: string;
    readonly usagePlanId: string;
}

