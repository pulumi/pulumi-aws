import * as lumi from "@lumi/lumi";
export declare class Repository extends lumi.NamedResource implements RepositoryArgs {
    readonly arn: string;
    readonly repositoryName?: string;
    readonly registryId: string;
    readonly repositoryUrl: string;
    constructor(name: string, args: RepositoryArgs);
}
export interface RepositoryArgs {
    readonly repositoryName?: string;
}

