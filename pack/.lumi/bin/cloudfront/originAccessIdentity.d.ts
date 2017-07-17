import * as lumi from "@lumi/lumi";
export declare class OriginAccessIdentity extends lumi.NamedResource implements OriginAccessIdentityArgs {
    readonly callerReference: string;
    readonly cloudfrontAccessIdentityPath: string;
    readonly comment?: string;
    readonly etag: string;
    readonly iamArn: string;
    readonly s3CanonicalUserId: string;
    constructor(name: string, args: OriginAccessIdentityArgs);
}
export interface OriginAccessIdentityArgs {
    readonly comment?: string;
}

