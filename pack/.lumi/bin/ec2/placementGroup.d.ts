import * as lumi from "@lumi/lumi";
export declare class PlacementGroup extends lumi.NamedResource implements PlacementGroupArgs {
    readonly placementGroupName?: string;
    readonly strategy: string;
    constructor(name: string, args: PlacementGroupArgs);
}
export interface PlacementGroupArgs {
    readonly placementGroupName?: string;
    readonly strategy: string;
}

