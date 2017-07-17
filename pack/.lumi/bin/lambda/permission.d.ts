import * as lumi from "@lumi/lumi";
import { Function } from "./function";
export declare class Permission extends lumi.NamedResource implements PermissionArgs {
    readonly action: string;
    readonly function: Function;
    readonly principal: string;
    readonly qualifier?: string;
    readonly sourceAccount?: string;
    readonly sourceArn?: string;
    readonly statementId?: string;
    constructor(name: string, args: PermissionArgs);
}
export interface PermissionArgs {
    readonly action: string;
    readonly function: Function;
    readonly principal: string;
    readonly qualifier?: string;
    readonly sourceAccount?: string;
    readonly sourceArn?: string;
    readonly statementId?: string;
}

