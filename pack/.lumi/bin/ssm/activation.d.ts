import * as lumi from "@lumi/lumi";
export declare class Activation extends lumi.NamedResource implements ActivationArgs {
    readonly description?: string;
    readonly expirationDate?: string;
    readonly expired: string;
    readonly iamRole: string;
    readonly activationName?: string;
    readonly registrationCount: number;
    readonly registrationLimit?: number;
    constructor(name: string, args: ActivationArgs);
}
export interface ActivationArgs {
    readonly description?: string;
    readonly expirationDate?: string;
    readonly iamRole: string;
    readonly activationName?: string;
    readonly registrationLimit?: number;
}

