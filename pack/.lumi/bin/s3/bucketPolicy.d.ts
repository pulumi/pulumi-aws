import * as lumi from "@lumi/lumi";
export declare class BucketPolicy extends lumi.NamedResource implements BucketPolicyArgs {
    readonly bucket: string;
    readonly policy: string;
    constructor(name: string, args: BucketPolicyArgs);
}
export interface BucketPolicyArgs {
    readonly bucket: string;
    readonly policy: string;
}

