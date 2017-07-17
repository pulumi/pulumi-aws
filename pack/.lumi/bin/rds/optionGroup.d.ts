import * as lumi from "@lumi/lumi";
export declare class OptionGroup extends lumi.NamedResource implements OptionGroupArgs {
    readonly arn: string;
    readonly engineName: string;
    readonly majorEngineVersion: string;
    readonly optionGroupName: string;
    readonly namePrefix: string;
    readonly option?: {
        dbSecurityGroupMemberships?: string[];
        optionName: string;
        optionSettings?: {
            name: string;
            value: string;
        }[];
        port?: number;
        vpcSecurityGroupMemberships?: string[];
    }[];
    readonly optionGroupDescription?: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: OptionGroupArgs);
}
export interface OptionGroupArgs {
    readonly engineName: string;
    readonly majorEngineVersion: string;
    readonly optionGroupName?: string;
    readonly namePrefix?: string;
    readonly option?: {
        dbSecurityGroupMemberships?: string[];
        optionName: string;
        optionSettings?: {
            name: string;
            value: string;
        }[];
        port?: number;
        vpcSecurityGroupMemberships?: string[];
    }[];
    readonly optionGroupDescription?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

