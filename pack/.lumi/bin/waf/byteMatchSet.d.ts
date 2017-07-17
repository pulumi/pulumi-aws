import * as lumi from "@lumi/lumi";
export declare class ByteMatchSet extends lumi.NamedResource implements ByteMatchSetArgs {
    readonly byteMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        positionalConstraint: string;
        targetString?: string;
        textTransformation: string;
    }[];
    readonly byteMatchSetName?: string;
    constructor(name: string, args: ByteMatchSetArgs);
}
export interface ByteMatchSetArgs {
    readonly byteMatchTuples?: {
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        positionalConstraint: string;
        targetString?: string;
        textTransformation: string;
    }[];
    readonly byteMatchSetName?: string;
}

