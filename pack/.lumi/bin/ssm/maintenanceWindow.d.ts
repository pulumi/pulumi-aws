import * as lumi from "@lumi/lumi";
export declare class MaintenanceWindow extends lumi.NamedResource implements MaintenanceWindowArgs {
    readonly allowUnassociatedTargets?: boolean;
    readonly cutoff: number;
    readonly duration: number;
    readonly enabled?: boolean;
    readonly maintenanceWindowName?: string;
    readonly schedule: string;
    constructor(name: string, args: MaintenanceWindowArgs);
}
export interface MaintenanceWindowArgs {
    readonly allowUnassociatedTargets?: boolean;
    readonly cutoff: number;
    readonly duration: number;
    readonly enabled?: boolean;
    readonly maintenanceWindowName?: string;
    readonly schedule: string;
}

