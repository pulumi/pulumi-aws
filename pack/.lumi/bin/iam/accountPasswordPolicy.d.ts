import * as lumi from "@lumi/lumi";
export declare class AccountPasswordPolicy extends lumi.NamedResource implements AccountPasswordPolicyArgs {
    readonly allowUsersToChangePassword?: boolean;
    readonly expirePasswords: boolean;
    readonly hardExpiry: boolean;
    readonly maxPasswordAge: number;
    readonly minimumPasswordLength?: number;
    readonly passwordReusePrevention: number;
    readonly requireLowercaseCharacters: boolean;
    readonly requireNumbers: boolean;
    readonly requireSymbols: boolean;
    readonly requireUppercaseCharacters: boolean;
    constructor(name: string, args: AccountPasswordPolicyArgs);
}
export interface AccountPasswordPolicyArgs {
    readonly allowUsersToChangePassword?: boolean;
    readonly hardExpiry?: boolean;
    readonly maxPasswordAge?: number;
    readonly minimumPasswordLength?: number;
    readonly passwordReusePrevention?: number;
    readonly requireLowercaseCharacters?: boolean;
    readonly requireNumbers?: boolean;
    readonly requireSymbols?: boolean;
    readonly requireUppercaseCharacters?: boolean;
}

