import * as lumi from "@lumi/lumi";
export declare class Group extends lumi.NamedResource implements GroupArgs {
    readonly arn: string;
    readonly groupName?: string;
    readonly path?: string;
    readonly uniqueId: string;
    constructor(name: string, args: GroupArgs);
}
export interface GroupArgs {
    readonly groupName?: string;
    readonly path?: string;
}

