import * as lumi from "@lumi/lumi";
export declare class UserProfile extends lumi.NamedResource implements UserProfileArgs {
    readonly allowSelfManagement?: boolean;
    readonly profileId: string;
    readonly sshPublicKey?: string;
    readonly sshUsername: string;
    readonly userArn: string;
    constructor(name: string, args: UserProfileArgs);
}
export interface UserProfileArgs {
    readonly allowSelfManagement?: boolean;
    readonly sshPublicKey?: string;
    readonly sshUsername: string;
    readonly userArn: string;
}

