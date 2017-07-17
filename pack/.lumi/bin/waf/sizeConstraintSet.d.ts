import * as lumi from "@lumi/lumi";
export declare class SizeConstraintSet extends lumi.NamedResource implements SizeConstraintSetArgs {
    readonly sizeConstraintSetName?: string;
    readonly sizeConstraints?: {
        comparisonOperator: string;
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        size: number;
        textTransformation: string;
    }[];
    constructor(name: string, args: SizeConstraintSetArgs);
}
export interface SizeConstraintSetArgs {
    readonly sizeConstraintSetName?: string;
    readonly sizeConstraints?: {
        comparisonOperator: string;
        fieldToMatch: {
            data?: string;
            type: string;
        }[];
        size: number;
        textTransformation: string;
    }[];
}

