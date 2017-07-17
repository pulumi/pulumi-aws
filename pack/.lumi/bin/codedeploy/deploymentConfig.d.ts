import * as lumi from "@lumi/lumi";
export declare class DeploymentConfig extends lumi.NamedResource implements DeploymentConfigArgs {
    readonly deploymentConfigId: string;
    readonly deploymentConfigName: string;
    readonly minimumHealthyHosts: {
        type: string;
        value?: number;
    }[];
    constructor(name: string, args: DeploymentConfigArgs);
}
export interface DeploymentConfigArgs {
    readonly deploymentConfigName: string;
    readonly minimumHealthyHosts: {
        type: string;
        value?: number;
    }[];
}

