import * as lumi from "@lumi/lumi";
export declare class HaproxyLayer extends lumi.NamedResource implements HaproxyLayerArgs {
    readonly autoAssignElasticIps?: boolean;
    readonly autoAssignPublicIps?: boolean;
    readonly autoHealing?: boolean;
    readonly customConfigureRecipes?: string[];
    readonly customDeployRecipes?: string[];
    readonly customInstanceProfileArn?: string;
    readonly customJson?: string;
    readonly customSecurityGroupIds?: string[];
    readonly customSetupRecipes?: string[];
    readonly customShutdownRecipes?: string[];
    readonly customUndeployRecipes?: string[];
    readonly drainElbOnShutdown?: boolean;
    readonly ebsVolume?: {
        iops?: number;
        mountPoint: string;
        numberOfDisks: number;
        raidLevel?: string;
        size: number;
        type?: string;
    }[];
    readonly elasticLoadBalancer?: string;
    readonly healthcheckMethod?: string;
    readonly healthcheckUrl?: string;
    readonly layerId: string;
    readonly installUpdatesOnBoot?: boolean;
    readonly instanceShutdownTimeout?: number;
    readonly haproxyLayerName?: string;
    readonly stackId: string;
    readonly statsEnabled?: boolean;
    readonly statsPassword: string;
    readonly statsUrl?: string;
    readonly statsUser?: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
    constructor(name: string, args: HaproxyLayerArgs);
}
export interface HaproxyLayerArgs {
    readonly autoAssignElasticIps?: boolean;
    readonly autoAssignPublicIps?: boolean;
    readonly autoHealing?: boolean;
    readonly customConfigureRecipes?: string[];
    readonly customDeployRecipes?: string[];
    readonly customInstanceProfileArn?: string;
    readonly customJson?: string;
    readonly customSecurityGroupIds?: string[];
    readonly customSetupRecipes?: string[];
    readonly customShutdownRecipes?: string[];
    readonly customUndeployRecipes?: string[];
    readonly drainElbOnShutdown?: boolean;
    readonly ebsVolume?: {
        iops?: number;
        mountPoint: string;
        numberOfDisks: number;
        raidLevel?: string;
        size: number;
        type?: string;
    }[];
    readonly elasticLoadBalancer?: string;
    readonly healthcheckMethod?: string;
    readonly healthcheckUrl?: string;
    readonly installUpdatesOnBoot?: boolean;
    readonly instanceShutdownTimeout?: number;
    readonly haproxyLayerName?: string;
    readonly stackId: string;
    readonly statsEnabled?: boolean;
    readonly statsPassword: string;
    readonly statsUrl?: string;
    readonly statsUser?: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
}

