// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { FirewallArgs, FirewallState } from "./firewall";
export type Firewall = import("./firewall").Firewall;
export const Firewall: typeof import("./firewall").Firewall = null as any;
utilities.lazyLoad(exports, ["Firewall"], () => require("./firewall"));

export { FirewallPolicyArgs, FirewallPolicyState } from "./firewallPolicy";
export type FirewallPolicy = import("./firewallPolicy").FirewallPolicy;
export const FirewallPolicy: typeof import("./firewallPolicy").FirewallPolicy = null as any;
utilities.lazyLoad(exports, ["FirewallPolicy"], () => require("./firewallPolicy"));

export { GetFirewallArgs, GetFirewallResult, GetFirewallOutputArgs } from "./getFirewall";
export const getFirewall: typeof import("./getFirewall").getFirewall = null as any;
export const getFirewallOutput: typeof import("./getFirewall").getFirewallOutput = null as any;
utilities.lazyLoad(exports, ["getFirewall","getFirewallOutput"], () => require("./getFirewall"));

export { GetFirewallPolicyArgs, GetFirewallPolicyResult, GetFirewallPolicyOutputArgs } from "./getFirewallPolicy";
export const getFirewallPolicy: typeof import("./getFirewallPolicy").getFirewallPolicy = null as any;
export const getFirewallPolicyOutput: typeof import("./getFirewallPolicy").getFirewallPolicyOutput = null as any;
utilities.lazyLoad(exports, ["getFirewallPolicy","getFirewallPolicyOutput"], () => require("./getFirewallPolicy"));

export { GetResourcePolicyArgs, GetResourcePolicyResult, GetResourcePolicyOutputArgs } from "./getResourcePolicy";
export const getResourcePolicy: typeof import("./getResourcePolicy").getResourcePolicy = null as any;
export const getResourcePolicyOutput: typeof import("./getResourcePolicy").getResourcePolicyOutput = null as any;
utilities.lazyLoad(exports, ["getResourcePolicy","getResourcePolicyOutput"], () => require("./getResourcePolicy"));

export { LoggingConfigurationArgs, LoggingConfigurationState } from "./loggingConfiguration";
export type LoggingConfiguration = import("./loggingConfiguration").LoggingConfiguration;
export const LoggingConfiguration: typeof import("./loggingConfiguration").LoggingConfiguration = null as any;
utilities.lazyLoad(exports, ["LoggingConfiguration"], () => require("./loggingConfiguration"));

export { ResourcePolicyArgs, ResourcePolicyState } from "./resourcePolicy";
export type ResourcePolicy = import("./resourcePolicy").ResourcePolicy;
export const ResourcePolicy: typeof import("./resourcePolicy").ResourcePolicy = null as any;
utilities.lazyLoad(exports, ["ResourcePolicy"], () => require("./resourcePolicy"));

export { RuleGroupArgs, RuleGroupState } from "./ruleGroup";
export type RuleGroup = import("./ruleGroup").RuleGroup;
export const RuleGroup: typeof import("./ruleGroup").RuleGroup = null as any;
utilities.lazyLoad(exports, ["RuleGroup"], () => require("./ruleGroup"));

export { TlsInspectionConfigurationArgs, TlsInspectionConfigurationState } from "./tlsInspectionConfiguration";
export type TlsInspectionConfiguration = import("./tlsInspectionConfiguration").TlsInspectionConfiguration;
export const TlsInspectionConfiguration: typeof import("./tlsInspectionConfiguration").TlsInspectionConfiguration = null as any;
utilities.lazyLoad(exports, ["TlsInspectionConfiguration"], () => require("./tlsInspectionConfiguration"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:networkfirewall/firewall:Firewall":
                return new Firewall(name, <any>undefined, { urn })
            case "aws:networkfirewall/firewallPolicy:FirewallPolicy":
                return new FirewallPolicy(name, <any>undefined, { urn })
            case "aws:networkfirewall/loggingConfiguration:LoggingConfiguration":
                return new LoggingConfiguration(name, <any>undefined, { urn })
            case "aws:networkfirewall/resourcePolicy:ResourcePolicy":
                return new ResourcePolicy(name, <any>undefined, { urn })
            case "aws:networkfirewall/ruleGroup:RuleGroup":
                return new RuleGroup(name, <any>undefined, { urn })
            case "aws:networkfirewall/tlsInspectionConfiguration:TlsInspectionConfiguration":
                return new TlsInspectionConfiguration(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "networkfirewall/firewall", _module)
pulumi.runtime.registerResourceModule("aws", "networkfirewall/firewallPolicy", _module)
pulumi.runtime.registerResourceModule("aws", "networkfirewall/loggingConfiguration", _module)
pulumi.runtime.registerResourceModule("aws", "networkfirewall/resourcePolicy", _module)
pulumi.runtime.registerResourceModule("aws", "networkfirewall/ruleGroup", _module)
pulumi.runtime.registerResourceModule("aws", "networkfirewall/tlsInspectionConfiguration", _module)
