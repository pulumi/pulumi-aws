// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ClusterArgs, ClusterState } from "./cluster";
export type Cluster = import("./cluster").Cluster;
export const Cluster: typeof import("./cluster").Cluster = null as any;
utilities.lazyLoad(exports, ["Cluster"], () => require("./cluster"));

export { ClusterEndpointArgs, ClusterEndpointState } from "./clusterEndpoint";
export type ClusterEndpoint = import("./clusterEndpoint").ClusterEndpoint;
export const ClusterEndpoint: typeof import("./clusterEndpoint").ClusterEndpoint = null as any;
utilities.lazyLoad(exports, ["ClusterEndpoint"], () => require("./clusterEndpoint"));

export { ClusterInstanceArgs, ClusterInstanceState } from "./clusterInstance";
export type ClusterInstance = import("./clusterInstance").ClusterInstance;
export const ClusterInstance: typeof import("./clusterInstance").ClusterInstance = null as any;
utilities.lazyLoad(exports, ["ClusterInstance"], () => require("./clusterInstance"));

export { ClusterParameterGroupArgs, ClusterParameterGroupState } from "./clusterParameterGroup";
export type ClusterParameterGroup = import("./clusterParameterGroup").ClusterParameterGroup;
export const ClusterParameterGroup: typeof import("./clusterParameterGroup").ClusterParameterGroup = null as any;
utilities.lazyLoad(exports, ["ClusterParameterGroup"], () => require("./clusterParameterGroup"));

export { ClusterSnapshotArgs, ClusterSnapshotState } from "./clusterSnapshot";
export type ClusterSnapshot = import("./clusterSnapshot").ClusterSnapshot;
export const ClusterSnapshot: typeof import("./clusterSnapshot").ClusterSnapshot = null as any;
utilities.lazyLoad(exports, ["ClusterSnapshot"], () => require("./clusterSnapshot"));

export { EventSubscriptionArgs, EventSubscriptionState } from "./eventSubscription";
export type EventSubscription = import("./eventSubscription").EventSubscription;
export const EventSubscription: typeof import("./eventSubscription").EventSubscription = null as any;
utilities.lazyLoad(exports, ["EventSubscription"], () => require("./eventSubscription"));

export { GetEngineVersionArgs, GetEngineVersionResult, GetEngineVersionOutputArgs } from "./getEngineVersion";
export const getEngineVersion: typeof import("./getEngineVersion").getEngineVersion = null as any;
export const getEngineVersionOutput: typeof import("./getEngineVersion").getEngineVersionOutput = null as any;
utilities.lazyLoad(exports, ["getEngineVersion","getEngineVersionOutput"], () => require("./getEngineVersion"));

export { GetOrderableDbInstanceArgs, GetOrderableDbInstanceResult, GetOrderableDbInstanceOutputArgs } from "./getOrderableDbInstance";
export const getOrderableDbInstance: typeof import("./getOrderableDbInstance").getOrderableDbInstance = null as any;
export const getOrderableDbInstanceOutput: typeof import("./getOrderableDbInstance").getOrderableDbInstanceOutput = null as any;
utilities.lazyLoad(exports, ["getOrderableDbInstance","getOrderableDbInstanceOutput"], () => require("./getOrderableDbInstance"));

export { GlobalClusterArgs, GlobalClusterState } from "./globalCluster";
export type GlobalCluster = import("./globalCluster").GlobalCluster;
export const GlobalCluster: typeof import("./globalCluster").GlobalCluster = null as any;
utilities.lazyLoad(exports, ["GlobalCluster"], () => require("./globalCluster"));

export { ParameterGroupArgs, ParameterGroupState } from "./parameterGroup";
export type ParameterGroup = import("./parameterGroup").ParameterGroup;
export const ParameterGroup: typeof import("./parameterGroup").ParameterGroup = null as any;
utilities.lazyLoad(exports, ["ParameterGroup"], () => require("./parameterGroup"));

export { SubnetGroupArgs, SubnetGroupState } from "./subnetGroup";
export type SubnetGroup = import("./subnetGroup").SubnetGroup;
export const SubnetGroup: typeof import("./subnetGroup").SubnetGroup = null as any;
utilities.lazyLoad(exports, ["SubnetGroup"], () => require("./subnetGroup"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:neptune/cluster:Cluster":
                return new Cluster(name, <any>undefined, { urn })
            case "aws:neptune/clusterEndpoint:ClusterEndpoint":
                return new ClusterEndpoint(name, <any>undefined, { urn })
            case "aws:neptune/clusterInstance:ClusterInstance":
                return new ClusterInstance(name, <any>undefined, { urn })
            case "aws:neptune/clusterParameterGroup:ClusterParameterGroup":
                return new ClusterParameterGroup(name, <any>undefined, { urn })
            case "aws:neptune/clusterSnapshot:ClusterSnapshot":
                return new ClusterSnapshot(name, <any>undefined, { urn })
            case "aws:neptune/eventSubscription:EventSubscription":
                return new EventSubscription(name, <any>undefined, { urn })
            case "aws:neptune/globalCluster:GlobalCluster":
                return new GlobalCluster(name, <any>undefined, { urn })
            case "aws:neptune/parameterGroup:ParameterGroup":
                return new ParameterGroup(name, <any>undefined, { urn })
            case "aws:neptune/subnetGroup:SubnetGroup":
                return new SubnetGroup(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "neptune/cluster", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/clusterEndpoint", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/clusterInstance", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/clusterParameterGroup", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/clusterSnapshot", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/eventSubscription", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/globalCluster", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/parameterGroup", _module)
pulumi.runtime.registerResourceModule("aws", "neptune/subnetGroup", _module)
