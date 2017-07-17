import * as lumi from "@lumi/lumi";
export declare class ResourceGroup extends lumi.NamedResource implements ResourceGroupArgs {
    readonly arn: string;
    readonly tags: {
        [key: string]: any;
    };
    constructor(name: string, args: ResourceGroupArgs);
}
export interface ResourceGroupArgs {
    readonly tags: {
        [key: string]: any;
    };
}

