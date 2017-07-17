import * as lumi from "@lumi/lumi";
import { RestApi } from "./restApi";
export declare class Deployment extends lumi.NamedResource implements DeploymentArgs {
    readonly createdDate: string;
    readonly description?: string;
    readonly executionArn: string;
    readonly invokeUrl: string;
    readonly restApi: RestApi;
    readonly stageDescription?: string;
    readonly stageName: string;
    readonly variables?: {
        [key: string]: string;
    };
    constructor(name: string, args: DeploymentArgs);
}
export interface DeploymentArgs {
    readonly description?: string;
    readonly restApi: RestApi;
    readonly stageDescription?: string;
    readonly stageName: string;
    readonly variables?: {
        [key: string]: string;
    };
}

