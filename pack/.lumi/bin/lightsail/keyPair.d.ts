import * as lumi from "@lumi/lumi";
export declare class KeyPair extends lumi.NamedResource implements KeyPairArgs {
    readonly arn: string;
    readonly encryptedFingerprint: string;
    readonly encryptedPrivateKey: string;
    readonly fingerprint: string;
    readonly keyPairName: string;
    readonly namePrefix?: string;
    readonly pgpKey?: string;
    readonly privateKey: string;
    readonly publicKey: string;
    constructor(name: string, args: KeyPairArgs);
}
export interface KeyPairArgs {
    readonly keyPairName?: string;
    readonly namePrefix?: string;
    readonly pgpKey?: string;
    readonly publicKey?: string;
}

