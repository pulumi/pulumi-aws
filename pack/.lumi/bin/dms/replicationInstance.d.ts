import * as lumi from "@lumi/lumi";
export declare class ReplicationInstance extends lumi.NamedResource implements ReplicationInstanceArgs {
    readonly allocatedStorage: number;
    readonly applyImmediately?: boolean;
    readonly autoMinorVersionUpgrade: boolean;
    readonly availabilityZone: string;
    readonly engineVersion: string;
    readonly kmsKeyArn: string;
    readonly multiAz: boolean;
    readonly preferredMaintenanceWindow: string;
    readonly publiclyAccessible: boolean;
    readonly replicationInstanceArn: string;
    readonly replicationInstanceClass: string;
    readonly replicationInstanceId: string;
    readonly replicationInstancePrivateIps: string[];
    readonly replicationInstancePublicIps: string[];
    readonly replicationSubnetGroupId: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds: string[];
    constructor(name: string, args: ReplicationInstanceArgs);
}
export interface ReplicationInstanceArgs {
    readonly allocatedStorage?: number;
    readonly applyImmediately?: boolean;
    readonly autoMinorVersionUpgrade?: boolean;
    readonly availabilityZone?: string;
    readonly engineVersion?: string;
    readonly kmsKeyArn?: string;
    readonly multiAz?: boolean;
    readonly preferredMaintenanceWindow?: string;
    readonly publiclyAccessible?: boolean;
    readonly replicationInstanceClass: string;
    readonly replicationInstanceId: string;
    readonly replicationSubnetGroupId?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcSecurityGroupIds?: string[];
}

