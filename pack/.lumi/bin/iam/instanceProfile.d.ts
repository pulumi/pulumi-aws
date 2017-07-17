import * as lumi from "@lumi/lumi";
export declare class InstanceProfile extends lumi.NamedResource implements InstanceProfileArgs {
    readonly arn: string;
    readonly createDate: string;
    readonly instanceProfileName: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly role: string;
    readonly roles: string[];
    readonly uniqueId: string;
    constructor(name: string, args: InstanceProfileArgs);
}
export interface InstanceProfileArgs {
    readonly instanceProfileName?: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly role?: string;
    readonly roles?: string[];
}

