import * as lumi from "@lumi/lumi";
export declare class AccessKey extends lumi.NamedResource implements AccessKeyArgs {
    readonly encryptedSecret: string;
    readonly keyFingerprint: string;
    readonly pgpKey?: string;
    readonly secret: string;
    readonly sesSmtpPassword: string;
    readonly status: string;
    readonly user: string;
    constructor(name: string, args: AccessKeyArgs);
}
export interface AccessKeyArgs {
    readonly pgpKey?: string;
    readonly user: string;
}

