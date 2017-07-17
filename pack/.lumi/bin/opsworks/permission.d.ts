import * as lumi from "@lumi/lumi";
export declare class Permission extends lumi.NamedResource implements PermissionArgs {
    readonly allowSsh: boolean;
    readonly allowSudo: boolean;
    readonly permissionId: string;
    readonly level: string;
    readonly stackId: string;
    readonly userArn: string;
    constructor(name: string, args: PermissionArgs);
}
export interface PermissionArgs {
    readonly allowSsh?: boolean;
    readonly allowSudo?: boolean;
    readonly level?: string;
    readonly stackId?: string;
    readonly userArn: string;
}

