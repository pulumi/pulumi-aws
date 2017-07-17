import * as lumi from "@lumi/lumi";
export declare class Repository extends lumi.NamedResource implements RepositoryArgs {
    readonly arn: string;
    readonly cloneUrlHttp: string;
    readonly cloneUrlSsh: string;
    readonly defaultBranch?: string;
    readonly description?: string;
    readonly repositoryId: string;
    readonly repositoryName: string;
    constructor(name: string, args: RepositoryArgs);
}
export interface RepositoryArgs {
    readonly defaultBranch?: string;
    readonly description?: string;
    readonly repositoryName: string;
}

