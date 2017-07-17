import * as lumi from "@lumi/lumi";
export declare class User extends lumi.NamedResource implements UserArgs {
    readonly arn: string;
    readonly forceDestroy?: boolean;
    readonly userName?: string;
    readonly path?: string;
    readonly uniqueId: string;
    constructor(name: string, args: UserArgs);
}
export interface UserArgs {
    readonly forceDestroy?: boolean;
    readonly userName?: string;
    readonly path?: string;
}

