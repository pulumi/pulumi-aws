import * as lumi from "@lumi/lumi";
export declare class SecurityConfiguration extends lumi.NamedResource implements SecurityConfigurationArgs {
    readonly configuration: string;
    readonly creationDate: string;
    readonly securityConfigurationName: string;
    readonly namePrefix?: string;
    constructor(name: string, args: SecurityConfigurationArgs);
}
export interface SecurityConfigurationArgs {
    readonly configuration: string;
    readonly securityConfigurationName?: string;
    readonly namePrefix?: string;
}

