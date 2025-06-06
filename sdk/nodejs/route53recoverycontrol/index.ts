// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ClusterArgs, ClusterState } from "./cluster";
export type Cluster = import("./cluster").Cluster;
export const Cluster: typeof import("./cluster").Cluster = null as any;
utilities.lazyLoad(exports, ["Cluster"], () => require("./cluster"));

export { ControlPanelArgs, ControlPanelState } from "./controlPanel";
export type ControlPanel = import("./controlPanel").ControlPanel;
export const ControlPanel: typeof import("./controlPanel").ControlPanel = null as any;
utilities.lazyLoad(exports, ["ControlPanel"], () => require("./controlPanel"));

export { RoutingControlArgs, RoutingControlState } from "./routingControl";
export type RoutingControl = import("./routingControl").RoutingControl;
export const RoutingControl: typeof import("./routingControl").RoutingControl = null as any;
utilities.lazyLoad(exports, ["RoutingControl"], () => require("./routingControl"));

export { SafetyRuleArgs, SafetyRuleState } from "./safetyRule";
export type SafetyRule = import("./safetyRule").SafetyRule;
export const SafetyRule: typeof import("./safetyRule").SafetyRule = null as any;
utilities.lazyLoad(exports, ["SafetyRule"], () => require("./safetyRule"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:route53recoverycontrol/cluster:Cluster":
                return new Cluster(name, <any>undefined, { urn })
            case "aws:route53recoverycontrol/controlPanel:ControlPanel":
                return new ControlPanel(name, <any>undefined, { urn })
            case "aws:route53recoverycontrol/routingControl:RoutingControl":
                return new RoutingControl(name, <any>undefined, { urn })
            case "aws:route53recoverycontrol/safetyRule:SafetyRule":
                return new SafetyRule(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "route53recoverycontrol/cluster", _module)
pulumi.runtime.registerResourceModule("aws", "route53recoverycontrol/controlPanel", _module)
pulumi.runtime.registerResourceModule("aws", "route53recoverycontrol/routingControl", _module)
pulumi.runtime.registerResourceModule("aws", "route53recoverycontrol/safetyRule", _module)
