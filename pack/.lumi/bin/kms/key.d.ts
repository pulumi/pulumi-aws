import * as lumi from "@lumi/lumi";
export declare class Key extends lumi.NamedResource implements KeyArgs {
    readonly arn: string;
    readonly deletionWindowInDays?: number;
    readonly description: string;
    readonly enableKeyRotation?: boolean;
    readonly isEnabled?: boolean;
    readonly keyId: string;
    readonly keyUsage: string;
    readonly policy: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: KeyArgs);
}
export interface KeyArgs {
    readonly deletionWindowInDays?: number;
    readonly description?: string;
    readonly enableKeyRotation?: boolean;
    readonly isEnabled?: boolean;
    readonly keyUsage?: string;
    readonly policy?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

