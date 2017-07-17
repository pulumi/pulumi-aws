import * as lumi from "@lumi/lumi";
export declare class RepositoryPolicy extends lumi.NamedResource implements RepositoryPolicyArgs {
    readonly policy: string;
    readonly registryId: string;
    readonly repository: string;
    constructor(name: string, args: RepositoryPolicyArgs);
}
export interface RepositoryPolicyArgs {
    readonly policy: string;
    readonly repository: string;
}

