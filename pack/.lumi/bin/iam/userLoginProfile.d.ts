import * as lumi from "@lumi/lumi";
export declare class UserLoginProfile extends lumi.NamedResource implements UserLoginProfileArgs {
    readonly encryptedPassword: string;
    readonly keyFingerprint: string;
    readonly passwordLength?: number;
    readonly passwordResetRequired?: boolean;
    readonly pgpKey: string;
    readonly user: string;
    constructor(name: string, args: UserLoginProfileArgs);
}
export interface UserLoginProfileArgs {
    readonly passwordLength?: number;
    readonly passwordResetRequired?: boolean;
    readonly pgpKey: string;
    readonly user: string;
}

