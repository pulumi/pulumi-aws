import * as lumi from "@lumi/lumi";
export declare class CustomLayer extends lumi.NamedResource implements CustomLayerArgs {
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
    readonly layerId: string;
    readonly installUpdatesOnBoot?: boolean;
    readonly instanceShutdownTimeout?: number;
    readonly customLayerName?: string;
    readonly shortName: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
    constructor(name: string, args: CustomLayerArgs);
}
export interface CustomLayerArgs {
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
    readonly installUpdatesOnBoot?: boolean;
    readonly instanceShutdownTimeout?: number;
    readonly customLayerName?: string;
    readonly shortName: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
}

