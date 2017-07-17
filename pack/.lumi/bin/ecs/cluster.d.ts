import * as lumi from "@lumi/lumi";
export declare class Cluster extends lumi.NamedResource implements ClusterArgs {
    readonly clusterName?: string;
    constructor(name: string, args: ClusterArgs);
}
export interface ClusterArgs {
    readonly clusterName?: string;
}

