import * as lumi from "@lumi/lumi";
export declare class KeyPair extends lumi.NamedResource implements KeyPairArgs {
    readonly fingerprint: string;
    readonly keyName: string;
    readonly keyNamePrefix?: string;
    readonly publicKey: string;
    constructor(name: string, args: KeyPairArgs);
}
export interface KeyPairArgs {
    readonly keyName?: string;
    readonly keyNamePrefix?: string;
    readonly publicKey: string;
}

