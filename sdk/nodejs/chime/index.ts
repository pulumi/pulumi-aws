// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { SdkvoiceGlobalSettingsArgs, SdkvoiceGlobalSettingsState } from "./sdkvoiceGlobalSettings";
export type SdkvoiceGlobalSettings = import("./sdkvoiceGlobalSettings").SdkvoiceGlobalSettings;
export const SdkvoiceGlobalSettings: typeof import("./sdkvoiceGlobalSettings").SdkvoiceGlobalSettings = null as any;
utilities.lazyLoad(exports, ["SdkvoiceGlobalSettings"], () => require("./sdkvoiceGlobalSettings"));

export { SdkvoiceSipMediaApplicationArgs, SdkvoiceSipMediaApplicationState } from "./sdkvoiceSipMediaApplication";
export type SdkvoiceSipMediaApplication = import("./sdkvoiceSipMediaApplication").SdkvoiceSipMediaApplication;
export const SdkvoiceSipMediaApplication: typeof import("./sdkvoiceSipMediaApplication").SdkvoiceSipMediaApplication = null as any;
utilities.lazyLoad(exports, ["SdkvoiceSipMediaApplication"], () => require("./sdkvoiceSipMediaApplication"));

export { SdkvoiceSipRuleArgs, SdkvoiceSipRuleState } from "./sdkvoiceSipRule";
export type SdkvoiceSipRule = import("./sdkvoiceSipRule").SdkvoiceSipRule;
export const SdkvoiceSipRule: typeof import("./sdkvoiceSipRule").SdkvoiceSipRule = null as any;
utilities.lazyLoad(exports, ["SdkvoiceSipRule"], () => require("./sdkvoiceSipRule"));

export { SdkvoiceVoiceProfileDomainArgs, SdkvoiceVoiceProfileDomainState } from "./sdkvoiceVoiceProfileDomain";
export type SdkvoiceVoiceProfileDomain = import("./sdkvoiceVoiceProfileDomain").SdkvoiceVoiceProfileDomain;
export const SdkvoiceVoiceProfileDomain: typeof import("./sdkvoiceVoiceProfileDomain").SdkvoiceVoiceProfileDomain = null as any;
utilities.lazyLoad(exports, ["SdkvoiceVoiceProfileDomain"], () => require("./sdkvoiceVoiceProfileDomain"));

export { VoiceConnectorArgs, VoiceConnectorState } from "./voiceConnector";
export type VoiceConnector = import("./voiceConnector").VoiceConnector;
export const VoiceConnector: typeof import("./voiceConnector").VoiceConnector = null as any;
utilities.lazyLoad(exports, ["VoiceConnector"], () => require("./voiceConnector"));

export { VoiceConnectorGroupArgs, VoiceConnectorGroupState } from "./voiceConnectorGroup";
export type VoiceConnectorGroup = import("./voiceConnectorGroup").VoiceConnectorGroup;
export const VoiceConnectorGroup: typeof import("./voiceConnectorGroup").VoiceConnectorGroup = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorGroup"], () => require("./voiceConnectorGroup"));

export { VoiceConnectorLoggingArgs, VoiceConnectorLoggingState } from "./voiceConnectorLogging";
export type VoiceConnectorLogging = import("./voiceConnectorLogging").VoiceConnectorLogging;
export const VoiceConnectorLogging: typeof import("./voiceConnectorLogging").VoiceConnectorLogging = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorLogging"], () => require("./voiceConnectorLogging"));

export { VoiceConnectorOrganizationArgs, VoiceConnectorOrganizationState } from "./voiceConnectorOrganization";
export type VoiceConnectorOrganization = import("./voiceConnectorOrganization").VoiceConnectorOrganization;
export const VoiceConnectorOrganization: typeof import("./voiceConnectorOrganization").VoiceConnectorOrganization = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorOrganization"], () => require("./voiceConnectorOrganization"));

export { VoiceConnectorOriginationArgs, VoiceConnectorOriginationState } from "./voiceConnectorOrigination";
export type VoiceConnectorOrigination = import("./voiceConnectorOrigination").VoiceConnectorOrigination;
export const VoiceConnectorOrigination: typeof import("./voiceConnectorOrigination").VoiceConnectorOrigination = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorOrigination"], () => require("./voiceConnectorOrigination"));

export { VoiceConnectorStreamingArgs, VoiceConnectorStreamingState } from "./voiceConnectorStreaming";
export type VoiceConnectorStreaming = import("./voiceConnectorStreaming").VoiceConnectorStreaming;
export const VoiceConnectorStreaming: typeof import("./voiceConnectorStreaming").VoiceConnectorStreaming = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorStreaming"], () => require("./voiceConnectorStreaming"));

export { VoiceConnectorTerminationArgs, VoiceConnectorTerminationState } from "./voiceConnectorTermination";
export type VoiceConnectorTermination = import("./voiceConnectorTermination").VoiceConnectorTermination;
export const VoiceConnectorTermination: typeof import("./voiceConnectorTermination").VoiceConnectorTermination = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorTermination"], () => require("./voiceConnectorTermination"));

export { VoiceConnectorTerminationCredentialsArgs, VoiceConnectorTerminationCredentialsState } from "./voiceConnectorTerminationCredentials";
export type VoiceConnectorTerminationCredentials = import("./voiceConnectorTerminationCredentials").VoiceConnectorTerminationCredentials;
export const VoiceConnectorTerminationCredentials: typeof import("./voiceConnectorTerminationCredentials").VoiceConnectorTerminationCredentials = null as any;
utilities.lazyLoad(exports, ["VoiceConnectorTerminationCredentials"], () => require("./voiceConnectorTerminationCredentials"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:chime/sdkvoiceGlobalSettings:SdkvoiceGlobalSettings":
                return new SdkvoiceGlobalSettings(name, <any>undefined, { urn })
            case "aws:chime/sdkvoiceSipMediaApplication:SdkvoiceSipMediaApplication":
                return new SdkvoiceSipMediaApplication(name, <any>undefined, { urn })
            case "aws:chime/sdkvoiceSipRule:SdkvoiceSipRule":
                return new SdkvoiceSipRule(name, <any>undefined, { urn })
            case "aws:chime/sdkvoiceVoiceProfileDomain:SdkvoiceVoiceProfileDomain":
                return new SdkvoiceVoiceProfileDomain(name, <any>undefined, { urn })
            case "aws:chime/voiceConnector:VoiceConnector":
                return new VoiceConnector(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorGroup:VoiceConnectorGroup":
                return new VoiceConnectorGroup(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorLogging:VoiceConnectorLogging":
                return new VoiceConnectorLogging(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorOrganization:VoiceConnectorOrganization":
                return new VoiceConnectorOrganization(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorOrigination:VoiceConnectorOrigination":
                return new VoiceConnectorOrigination(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorStreaming:VoiceConnectorStreaming":
                return new VoiceConnectorStreaming(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorTermination:VoiceConnectorTermination":
                return new VoiceConnectorTermination(name, <any>undefined, { urn })
            case "aws:chime/voiceConnectorTerminationCredentials:VoiceConnectorTerminationCredentials":
                return new VoiceConnectorTerminationCredentials(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "chime/sdkvoiceGlobalSettings", _module)
pulumi.runtime.registerResourceModule("aws", "chime/sdkvoiceSipMediaApplication", _module)
pulumi.runtime.registerResourceModule("aws", "chime/sdkvoiceSipRule", _module)
pulumi.runtime.registerResourceModule("aws", "chime/sdkvoiceVoiceProfileDomain", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnector", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorGroup", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorLogging", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorOrganization", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorOrigination", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorStreaming", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorTermination", _module)
pulumi.runtime.registerResourceModule("aws", "chime/voiceConnectorTerminationCredentials", _module)
