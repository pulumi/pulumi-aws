// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ClusterArgs, ClusterState } from "./cluster";
export type Cluster = import("./cluster").Cluster;
export const Cluster: typeof import("./cluster").Cluster = null as any;
utilities.lazyLoad(exports, ["Cluster"], () => require("./cluster"));

export { ClusterPeeringArgs, ClusterPeeringState } from "./clusterPeering";
export type ClusterPeering = import("./clusterPeering").ClusterPeering;
export const ClusterPeering: typeof import("./clusterPeering").ClusterPeering = null as any;
utilities.lazyLoad(exports, ["ClusterPeering"], () => require("./clusterPeering"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:dsql/cluster:Cluster":
                return new Cluster(name, <any>undefined, { urn })
            case "aws:dsql/clusterPeering:ClusterPeering":
                return new ClusterPeering(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "dsql/cluster", _module)
pulumi.runtime.registerResourceModule("aws", "dsql/clusterPeering", _module)
