import * as lumi from "@lumi/lumi";
export declare class AmiLaunchPermission extends lumi.NamedResource implements AmiLaunchPermissionArgs {
    readonly accountId: string;
    readonly imageId: string;
    constructor(name: string, args: AmiLaunchPermissionArgs);
}
export interface AmiLaunchPermissionArgs {
    readonly accountId: string;
    readonly imageId: string;
}

