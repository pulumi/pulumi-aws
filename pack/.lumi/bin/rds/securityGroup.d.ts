import * as lumi from "@lumi/lumi";
export declare class SecurityGroup extends lumi.NamedResource implements SecurityGroupArgs {
    readonly arn: string;
    readonly description?: string;
    readonly ingress: {
        cidr?: string;
        securityGroupId: string;
        securityGroupName: string;
        securityGroupOwnerId: string;
    }[];
    readonly securityGroupName?: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: SecurityGroupArgs);
}
export interface SecurityGroupArgs {
    readonly description?: string;
    readonly ingress: {
        cidr?: string;
        securityGroupId: string;
        securityGroupName: string;
        securityGroupOwnerId: string;
    }[];
    readonly securityGroupName?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

