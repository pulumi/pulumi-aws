// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { AliasArgs, AliasState } from "./alias";
export type Alias = import("./alias").Alias;
export const Alias: typeof import("./alias").Alias = null as any;
utilities.lazyLoad(exports, ["Alias"], () => require("./alias"));

export { BuildArgs, BuildState } from "./build";
export type Build = import("./build").Build;
export const Build: typeof import("./build").Build = null as any;
utilities.lazyLoad(exports, ["Build"], () => require("./build"));

export { FleetArgs, FleetState } from "./fleet";
export type Fleet = import("./fleet").Fleet;
export const Fleet: typeof import("./fleet").Fleet = null as any;
utilities.lazyLoad(exports, ["Fleet"], () => require("./fleet"));

export { GameServerGroupArgs, GameServerGroupState } from "./gameServerGroup";
export type GameServerGroup = import("./gameServerGroup").GameServerGroup;
export const GameServerGroup: typeof import("./gameServerGroup").GameServerGroup = null as any;
utilities.lazyLoad(exports, ["GameServerGroup"], () => require("./gameServerGroup"));

export { GameSessionQueueArgs, GameSessionQueueState } from "./gameSessionQueue";
export type GameSessionQueue = import("./gameSessionQueue").GameSessionQueue;
export const GameSessionQueue: typeof import("./gameSessionQueue").GameSessionQueue = null as any;
utilities.lazyLoad(exports, ["GameSessionQueue"], () => require("./gameSessionQueue"));

export { MatchmakingConfigurationArgs, MatchmakingConfigurationState } from "./matchmakingConfiguration";
export type MatchmakingConfiguration = import("./matchmakingConfiguration").MatchmakingConfiguration;
export const MatchmakingConfiguration: typeof import("./matchmakingConfiguration").MatchmakingConfiguration = null as any;
utilities.lazyLoad(exports, ["MatchmakingConfiguration"], () => require("./matchmakingConfiguration"));

export { MatchmakingRuleSetArgs, MatchmakingRuleSetState } from "./matchmakingRuleSet";
export type MatchmakingRuleSet = import("./matchmakingRuleSet").MatchmakingRuleSet;
export const MatchmakingRuleSet: typeof import("./matchmakingRuleSet").MatchmakingRuleSet = null as any;
utilities.lazyLoad(exports, ["MatchmakingRuleSet"], () => require("./matchmakingRuleSet"));

export { ScriptArgs, ScriptState } from "./script";
export type Script = import("./script").Script;
export const Script: typeof import("./script").Script = null as any;
utilities.lazyLoad(exports, ["Script"], () => require("./script"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:gamelift/alias:Alias":
                return new Alias(name, <any>undefined, { urn })
            case "aws:gamelift/build:Build":
                return new Build(name, <any>undefined, { urn })
            case "aws:gamelift/fleet:Fleet":
                return new Fleet(name, <any>undefined, { urn })
            case "aws:gamelift/gameServerGroup:GameServerGroup":
                return new GameServerGroup(name, <any>undefined, { urn })
            case "aws:gamelift/gameSessionQueue:GameSessionQueue":
                return new GameSessionQueue(name, <any>undefined, { urn })
            case "aws:gamelift/matchmakingConfiguration:MatchmakingConfiguration":
                return new MatchmakingConfiguration(name, <any>undefined, { urn })
            case "aws:gamelift/matchmakingRuleSet:MatchmakingRuleSet":
                return new MatchmakingRuleSet(name, <any>undefined, { urn })
            case "aws:gamelift/script:Script":
                return new Script(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "gamelift/alias", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/build", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/fleet", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/gameServerGroup", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/gameSessionQueue", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/matchmakingConfiguration", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/matchmakingRuleSet", _module)
pulumi.runtime.registerResourceModule("aws", "gamelift/script", _module)
