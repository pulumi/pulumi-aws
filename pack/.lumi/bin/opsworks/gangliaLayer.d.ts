import * as lumi from "@lumi/lumi";
export declare class GangliaLayer extends lumi.NamedResource implements GangliaLayerArgs {
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
    readonly gangliaLayerName?: string;
    readonly password: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly url?: string;
    readonly useEbsOptimizedInstances?: boolean;
    readonly username?: string;
    constructor(name: string, args: GangliaLayerArgs);
}
export interface GangliaLayerArgs {
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
    readonly gangliaLayerName?: string;
    readonly password: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly url?: string;
    readonly useEbsOptimizedInstances?: boolean;
    readonly username?: string;
}

