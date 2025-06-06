// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { KxClusterArgs, KxClusterState } from "./kxCluster";
export type KxCluster = import("./kxCluster").KxCluster;
export const KxCluster: typeof import("./kxCluster").KxCluster = null as any;
utilities.lazyLoad(exports, ["KxCluster"], () => require("./kxCluster"));

export { KxDatabaseArgs, KxDatabaseState } from "./kxDatabase";
export type KxDatabase = import("./kxDatabase").KxDatabase;
export const KxDatabase: typeof import("./kxDatabase").KxDatabase = null as any;
utilities.lazyLoad(exports, ["KxDatabase"], () => require("./kxDatabase"));

export { KxDataviewArgs, KxDataviewState } from "./kxDataview";
export type KxDataview = import("./kxDataview").KxDataview;
export const KxDataview: typeof import("./kxDataview").KxDataview = null as any;
utilities.lazyLoad(exports, ["KxDataview"], () => require("./kxDataview"));

export { KxEnvironmentArgs, KxEnvironmentState } from "./kxEnvironment";
export type KxEnvironment = import("./kxEnvironment").KxEnvironment;
export const KxEnvironment: typeof import("./kxEnvironment").KxEnvironment = null as any;
utilities.lazyLoad(exports, ["KxEnvironment"], () => require("./kxEnvironment"));

export { KxScalingGroupArgs, KxScalingGroupState } from "./kxScalingGroup";
export type KxScalingGroup = import("./kxScalingGroup").KxScalingGroup;
export const KxScalingGroup: typeof import("./kxScalingGroup").KxScalingGroup = null as any;
utilities.lazyLoad(exports, ["KxScalingGroup"], () => require("./kxScalingGroup"));

export { KxUserArgs, KxUserState } from "./kxUser";
export type KxUser = import("./kxUser").KxUser;
export const KxUser: typeof import("./kxUser").KxUser = null as any;
utilities.lazyLoad(exports, ["KxUser"], () => require("./kxUser"));

export { KxVolumeArgs, KxVolumeState } from "./kxVolume";
export type KxVolume = import("./kxVolume").KxVolume;
export const KxVolume: typeof import("./kxVolume").KxVolume = null as any;
utilities.lazyLoad(exports, ["KxVolume"], () => require("./kxVolume"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:finspace/kxCluster:KxCluster":
                return new KxCluster(name, <any>undefined, { urn })
            case "aws:finspace/kxDatabase:KxDatabase":
                return new KxDatabase(name, <any>undefined, { urn })
            case "aws:finspace/kxDataview:KxDataview":
                return new KxDataview(name, <any>undefined, { urn })
            case "aws:finspace/kxEnvironment:KxEnvironment":
                return new KxEnvironment(name, <any>undefined, { urn })
            case "aws:finspace/kxScalingGroup:KxScalingGroup":
                return new KxScalingGroup(name, <any>undefined, { urn })
            case "aws:finspace/kxUser:KxUser":
                return new KxUser(name, <any>undefined, { urn })
            case "aws:finspace/kxVolume:KxVolume":
                return new KxVolume(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "finspace/kxCluster", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxDatabase", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxDataview", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxEnvironment", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxScalingGroup", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxUser", _module)
pulumi.runtime.registerResourceModule("aws", "finspace/kxVolume", _module)
