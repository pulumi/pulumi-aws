import * as lumi from "@lumi/lumi";
export declare class RdsDbInstance extends lumi.NamedResource implements RdsDbInstanceArgs {
    readonly dbPassword: string;
    readonly dbUser: string;
    readonly instanceId: string;
    readonly rdsDbInstanceArn: string;
    readonly stackId: string;
    constructor(name: string, args: RdsDbInstanceArgs);
}
export interface RdsDbInstanceArgs {
    readonly dbPassword: string;
    readonly dbUser: string;
    readonly rdsDbInstanceArn: string;
    readonly stackId: string;
}

