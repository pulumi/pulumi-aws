import * as lumi from "@lumi/lumi";
export declare class MaintenanceWindowTask extends lumi.NamedResource implements MaintenanceWindowTaskArgs {
    readonly loggingInfo?: {
        s3BucketName: string;
        s3BucketPrefix?: string;
        s3Region: string;
    }[];
    readonly maxConcurrency: string;
    readonly maxErrors: string;
    readonly priority?: number;
    readonly serviceRoleArn: string;
    readonly targets: {
        key: string;
        values: string[];
    }[];
    readonly taskArn: string;
    readonly taskParameters?: {
        name: string;
        values: string[];
    }[];
    readonly taskType: string;
    readonly windowId: string;
    constructor(name: string, args: MaintenanceWindowTaskArgs);
}
export interface MaintenanceWindowTaskArgs {
    readonly loggingInfo?: {
        s3BucketName: string;
        s3BucketPrefix?: string;
        s3Region: string;
    }[];
    readonly maxConcurrency: string;
    readonly maxErrors: string;
    readonly priority?: number;
    readonly serviceRoleArn: string;
    readonly targets: {
        key: string;
        values: string[];
    }[];
    readonly taskArn: string;
    readonly taskParameters?: {
        name: string;
        values: string[];
    }[];
    readonly taskType: string;
    readonly windowId: string;
}

