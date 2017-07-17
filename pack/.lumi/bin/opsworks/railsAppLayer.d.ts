import * as lumi from "@lumi/lumi";
export declare class RailsAppLayer extends lumi.NamedResource implements RailsAppLayerArgs {
    readonly appServer?: string;
    readonly autoAssignElasticIps?: boolean;
    readonly autoAssignPublicIps?: boolean;
    readonly autoHealing?: boolean;
    readonly bundlerVersion?: string;
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
    readonly manageBundler?: boolean;
    readonly railsAppLayerName?: string;
    readonly passengerVersion?: string;
    readonly rubyVersion?: string;
    readonly rubygemsVersion?: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
    constructor(name: string, args: RailsAppLayerArgs);
}
export interface RailsAppLayerArgs {
    readonly appServer?: string;
    readonly autoAssignElasticIps?: boolean;
    readonly autoAssignPublicIps?: boolean;
    readonly autoHealing?: boolean;
    readonly bundlerVersion?: string;
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
    readonly manageBundler?: boolean;
    readonly railsAppLayerName?: string;
    readonly passengerVersion?: string;
    readonly rubyVersion?: string;
    readonly rubygemsVersion?: string;
    readonly stackId: string;
    readonly systemPackages?: string[];
    readonly useEbsOptimizedInstances?: boolean;
}

