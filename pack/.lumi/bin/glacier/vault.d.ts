import * as lumi from "@lumi/lumi";
export declare class Vault extends lumi.NamedResource implements VaultArgs {
    readonly accessPolicy?: string;
    readonly arn: string;
    readonly location: string;
    readonly vaultName?: string;
    readonly notification?: {
        events: string[];
        snsTopic: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: VaultArgs);
}
export interface VaultArgs {
    readonly accessPolicy?: string;
    readonly vaultName?: string;
    readonly notification?: {
        events: string[];
        snsTopic: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
}

