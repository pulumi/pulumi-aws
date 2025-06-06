// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { EncryptionConfigArgs, EncryptionConfigState } from "./encryptionConfig";
export type EncryptionConfig = import("./encryptionConfig").EncryptionConfig;
export const EncryptionConfig: typeof import("./encryptionConfig").EncryptionConfig = null as any;
utilities.lazyLoad(exports, ["EncryptionConfig"], () => require("./encryptionConfig"));

export { GroupArgs, GroupState } from "./group";
export type Group = import("./group").Group;
export const Group: typeof import("./group").Group = null as any;
utilities.lazyLoad(exports, ["Group"], () => require("./group"));

export { ResourcePolicyArgs, ResourcePolicyState } from "./resourcePolicy";
export type ResourcePolicy = import("./resourcePolicy").ResourcePolicy;
export const ResourcePolicy: typeof import("./resourcePolicy").ResourcePolicy = null as any;
utilities.lazyLoad(exports, ["ResourcePolicy"], () => require("./resourcePolicy"));

export { SamplingRuleArgs, SamplingRuleState } from "./samplingRule";
export type SamplingRule = import("./samplingRule").SamplingRule;
export const SamplingRule: typeof import("./samplingRule").SamplingRule = null as any;
utilities.lazyLoad(exports, ["SamplingRule"], () => require("./samplingRule"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:xray/encryptionConfig:EncryptionConfig":
                return new EncryptionConfig(name, <any>undefined, { urn })
            case "aws:xray/group:Group":
                return new Group(name, <any>undefined, { urn })
            case "aws:xray/resourcePolicy:ResourcePolicy":
                return new ResourcePolicy(name, <any>undefined, { urn })
            case "aws:xray/samplingRule:SamplingRule":
                return new SamplingRule(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "xray/encryptionConfig", _module)
pulumi.runtime.registerResourceModule("aws", "xray/group", _module)
pulumi.runtime.registerResourceModule("aws", "xray/resourcePolicy", _module)
pulumi.runtime.registerResourceModule("aws", "xray/samplingRule", _module)
