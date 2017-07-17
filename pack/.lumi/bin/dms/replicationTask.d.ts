import * as lumi from "@lumi/lumi";
export declare class ReplicationTask extends lumi.NamedResource implements ReplicationTaskArgs {
    readonly cdcStartTime?: string;
    readonly migrationType: string;
    readonly replicationInstanceArn: string;
    readonly replicationTaskArn: string;
    readonly replicationTaskId: string;
    readonly replicationTaskSettings?: string;
    readonly sourceEndpointArn: string;
    readonly tableMappings: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly targetEndpointArn: string;
    constructor(name: string, args: ReplicationTaskArgs);
}
export interface ReplicationTaskArgs {
    readonly cdcStartTime?: string;
    readonly migrationType: string;
    readonly replicationInstanceArn: string;
    readonly replicationTaskId: string;
    readonly replicationTaskSettings?: string;
    readonly sourceEndpointArn: string;
    readonly tableMappings: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly targetEndpointArn: string;
}

