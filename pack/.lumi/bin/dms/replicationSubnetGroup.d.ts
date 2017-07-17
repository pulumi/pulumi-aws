import * as lumi from "@lumi/lumi";
export declare class ReplicationSubnetGroup extends lumi.NamedResource implements ReplicationSubnetGroupArgs {
    readonly replicationSubnetGroupArn: string;
    readonly replicationSubnetGroupDescription: string;
    readonly replicationSubnetGroupId: string;
    readonly subnetIds: string[];
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId: string;
    constructor(name: string, args: ReplicationSubnetGroupArgs);
}
export interface ReplicationSubnetGroupArgs {
    readonly replicationSubnetGroupDescription: string;
    readonly replicationSubnetGroupId: string;
    readonly subnetIds: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

