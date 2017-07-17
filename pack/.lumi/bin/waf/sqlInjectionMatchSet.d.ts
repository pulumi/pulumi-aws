import * as lumi from "@lumi/lumi";
export declare class SqlInjectionMatchSet extends lumi.NamedResource implements SqlInjectionMatchSetArgs {
    readonly sqlInjectionMatchSetName?: string;
    readonly sqlInjectionMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        textTransformation: string;
    }[];
    constructor(name: string, args: SqlInjectionMatchSetArgs);
}
export interface SqlInjectionMatchSetArgs {
    readonly sqlInjectionMatchSetName?: string;
    readonly sqlInjectionMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        textTransformation: string;
    }[];
}

