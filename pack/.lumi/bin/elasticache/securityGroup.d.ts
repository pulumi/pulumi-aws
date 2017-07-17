import * as lumi from "@lumi/lumi";
export declare class SecurityGroup extends lumi.NamedResource implements SecurityGroupArgs {
    readonly description?: string;
    readonly securityGroupName?: string;
    readonly securityGroupNames: string[];
    constructor(name: string, args: SecurityGroupArgs);
}
export interface SecurityGroupArgs {
    readonly description?: string;
    readonly securityGroupName?: string;
    readonly securityGroupNames: string[];
}

