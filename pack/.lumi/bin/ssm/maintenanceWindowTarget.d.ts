import * as lumi from "@lumi/lumi";
export declare class MaintenanceWindowTarget extends lumi.NamedResource implements MaintenanceWindowTargetArgs {
    readonly ownerInformation?: string;
    readonly resourceType: string;
    readonly targets: {
        key: string;
        values: string[];
    }[];
    readonly windowId: string;
    constructor(name: string, args: MaintenanceWindowTargetArgs);
}
export interface MaintenanceWindowTargetArgs {
    readonly ownerInformation?: string;
    readonly resourceType: string;
    readonly targets: {
        key: string;
        values: string[];
    }[];
    readonly windowId: string;
}

