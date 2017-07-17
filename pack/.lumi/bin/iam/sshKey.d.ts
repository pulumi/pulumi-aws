import * as lumi from "@lumi/lumi";
export declare class SshKey extends lumi.NamedResource implements SshKeyArgs {
    readonly encoding: string;
    readonly fingerprint: string;
    readonly publicKey: string;
    readonly sshPublicKeyId: string;
    readonly status: string;
    readonly username: string;
    constructor(name: string, args: SshKeyArgs);
}
export interface SshKeyArgs {
    readonly encoding: string;
    readonly publicKey: string;
    readonly status?: string;
    readonly username: string;
}

