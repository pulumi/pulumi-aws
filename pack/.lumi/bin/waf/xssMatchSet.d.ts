import * as lumi from "@lumi/lumi";
export declare class XssMatchSet extends lumi.NamedResource implements XssMatchSetArgs {
    readonly xssMatchSetName?: string;
    readonly xssMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        textTransformation: string;
    }[];
    constructor(name: string, args: XssMatchSetArgs);
}
export interface XssMatchSetArgs {
    readonly xssMatchSetName?: string;
    readonly xssMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        textTransformation: string;
    }[];
}

