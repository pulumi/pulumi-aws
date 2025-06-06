// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ActivityArgs, ActivityState } from "./activity";
export type Activity = import("./activity").Activity;
export const Activity: typeof import("./activity").Activity = null as any;
utilities.lazyLoad(exports, ["Activity"], () => require("./activity"));

export { AliasArgs, AliasState } from "./alias";
export type Alias = import("./alias").Alias;
export const Alias: typeof import("./alias").Alias = null as any;
utilities.lazyLoad(exports, ["Alias"], () => require("./alias"));

export { GetActivityArgs, GetActivityResult, GetActivityOutputArgs } from "./getActivity";
export const getActivity: typeof import("./getActivity").getActivity = null as any;
export const getActivityOutput: typeof import("./getActivity").getActivityOutput = null as any;
utilities.lazyLoad(exports, ["getActivity","getActivityOutput"], () => require("./getActivity"));

export { GetAliasArgs, GetAliasResult, GetAliasOutputArgs } from "./getAlias";
export const getAlias: typeof import("./getAlias").getAlias = null as any;
export const getAliasOutput: typeof import("./getAlias").getAliasOutput = null as any;
utilities.lazyLoad(exports, ["getAlias","getAliasOutput"], () => require("./getAlias"));

export { GetStateMachineArgs, GetStateMachineResult, GetStateMachineOutputArgs } from "./getStateMachine";
export const getStateMachine: typeof import("./getStateMachine").getStateMachine = null as any;
export const getStateMachineOutput: typeof import("./getStateMachine").getStateMachineOutput = null as any;
utilities.lazyLoad(exports, ["getStateMachine","getStateMachineOutput"], () => require("./getStateMachine"));

export { GetStateMachineVersionsArgs, GetStateMachineVersionsResult, GetStateMachineVersionsOutputArgs } from "./getStateMachineVersions";
export const getStateMachineVersions: typeof import("./getStateMachineVersions").getStateMachineVersions = null as any;
export const getStateMachineVersionsOutput: typeof import("./getStateMachineVersions").getStateMachineVersionsOutput = null as any;
utilities.lazyLoad(exports, ["getStateMachineVersions","getStateMachineVersionsOutput"], () => require("./getStateMachineVersions"));

export { StateMachineArgs, StateMachineState } from "./stateMachine";
export type StateMachine = import("./stateMachine").StateMachine;
export const StateMachine: typeof import("./stateMachine").StateMachine = null as any;
utilities.lazyLoad(exports, ["StateMachine"], () => require("./stateMachine"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:sfn/activity:Activity":
                return new Activity(name, <any>undefined, { urn })
            case "aws:sfn/alias:Alias":
                return new Alias(name, <any>undefined, { urn })
            case "aws:sfn/stateMachine:StateMachine":
                return new StateMachine(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "sfn/activity", _module)
pulumi.runtime.registerResourceModule("aws", "sfn/alias", _module)
pulumi.runtime.registerResourceModule("aws", "sfn/stateMachine", _module)
