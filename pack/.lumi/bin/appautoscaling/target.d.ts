import * as lumi from "@lumi/lumi";
export declare class Target extends lumi.NamedResource implements TargetArgs {
    readonly maxCapacity: number;
    readonly minCapacity: number;
    readonly resourceId: string;
    readonly roleArn: string;
    readonly scalableDimension: string;
    readonly serviceNamespace: string;
    constructor(name: string, args: TargetArgs);
}
export interface TargetArgs {
    readonly maxCapacity: number;
    readonly minCapacity: number;
    readonly resourceId: string;
    readonly roleArn: string;
    readonly scalableDimension: string;
    readonly serviceNamespace: string;
}

