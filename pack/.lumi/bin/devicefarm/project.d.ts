import * as lumi from "@lumi/lumi";
export declare class Project extends lumi.NamedResource implements ProjectArgs {
    readonly arn: string;
    readonly projectName?: string;
    constructor(name: string, args: ProjectArgs);
}
export interface ProjectArgs {
    readonly projectName?: string;
}

