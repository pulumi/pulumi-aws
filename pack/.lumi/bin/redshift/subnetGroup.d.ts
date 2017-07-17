import * as lumi from "@lumi/lumi";
export declare class SubnetGroup extends lumi.NamedResource implements SubnetGroupArgs {
    readonly description?: string;
    readonly subnetGroupName?: string;
    readonly subnetIds: string[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: SubnetGroupArgs);
}
export interface SubnetGroupArgs {
    readonly description?: string;
    readonly subnetGroupName?: string;
    readonly subnetIds: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

