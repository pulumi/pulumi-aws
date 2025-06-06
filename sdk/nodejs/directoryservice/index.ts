// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ConditionalForwaderArgs, ConditionalForwaderState } from "./conditionalForwader";
export type ConditionalForwader = import("./conditionalForwader").ConditionalForwader;
export const ConditionalForwader: typeof import("./conditionalForwader").ConditionalForwader = null as any;
utilities.lazyLoad(exports, ["ConditionalForwader"], () => require("./conditionalForwader"));

export { ConditionalForwarderArgs, ConditionalForwarderState } from "./conditionalForwarder";
export type ConditionalForwarder = import("./conditionalForwarder").ConditionalForwarder;
export const ConditionalForwarder: typeof import("./conditionalForwarder").ConditionalForwarder = null as any;
utilities.lazyLoad(exports, ["ConditionalForwarder"], () => require("./conditionalForwarder"));

export { DirectoryArgs, DirectoryState } from "./directory";
export type Directory = import("./directory").Directory;
export const Directory: typeof import("./directory").Directory = null as any;
utilities.lazyLoad(exports, ["Directory"], () => require("./directory"));

export { GetDirectoryArgs, GetDirectoryResult, GetDirectoryOutputArgs } from "./getDirectory";
export const getDirectory: typeof import("./getDirectory").getDirectory = null as any;
export const getDirectoryOutput: typeof import("./getDirectory").getDirectoryOutput = null as any;
utilities.lazyLoad(exports, ["getDirectory","getDirectoryOutput"], () => require("./getDirectory"));

export { LogServiceArgs, LogServiceState } from "./logService";
export type LogService = import("./logService").LogService;
export const LogService: typeof import("./logService").LogService = null as any;
utilities.lazyLoad(exports, ["LogService"], () => require("./logService"));

export { LogSubscriptionArgs, LogSubscriptionState } from "./logSubscription";
export type LogSubscription = import("./logSubscription").LogSubscription;
export const LogSubscription: typeof import("./logSubscription").LogSubscription = null as any;
utilities.lazyLoad(exports, ["LogSubscription"], () => require("./logSubscription"));

export { RadiusSettingsArgs, RadiusSettingsState } from "./radiusSettings";
export type RadiusSettings = import("./radiusSettings").RadiusSettings;
export const RadiusSettings: typeof import("./radiusSettings").RadiusSettings = null as any;
utilities.lazyLoad(exports, ["RadiusSettings"], () => require("./radiusSettings"));

export { ServiceRegionArgs, ServiceRegionState } from "./serviceRegion";
export type ServiceRegion = import("./serviceRegion").ServiceRegion;
export const ServiceRegion: typeof import("./serviceRegion").ServiceRegion = null as any;
utilities.lazyLoad(exports, ["ServiceRegion"], () => require("./serviceRegion"));

export { SharedDirectoryArgs, SharedDirectoryState } from "./sharedDirectory";
export type SharedDirectory = import("./sharedDirectory").SharedDirectory;
export const SharedDirectory: typeof import("./sharedDirectory").SharedDirectory = null as any;
utilities.lazyLoad(exports, ["SharedDirectory"], () => require("./sharedDirectory"));

export { SharedDirectoryAccepterArgs, SharedDirectoryAccepterState } from "./sharedDirectoryAccepter";
export type SharedDirectoryAccepter = import("./sharedDirectoryAccepter").SharedDirectoryAccepter;
export const SharedDirectoryAccepter: typeof import("./sharedDirectoryAccepter").SharedDirectoryAccepter = null as any;
utilities.lazyLoad(exports, ["SharedDirectoryAccepter"], () => require("./sharedDirectoryAccepter"));

export { TrustArgs, TrustState } from "./trust";
export type Trust = import("./trust").Trust;
export const Trust: typeof import("./trust").Trust = null as any;
utilities.lazyLoad(exports, ["Trust"], () => require("./trust"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:directoryservice/conditionalForwader:ConditionalForwader":
                return new ConditionalForwader(name, <any>undefined, { urn })
            case "aws:directoryservice/conditionalForwarder:ConditionalForwarder":
                return new ConditionalForwarder(name, <any>undefined, { urn })
            case "aws:directoryservice/directory:Directory":
                return new Directory(name, <any>undefined, { urn })
            case "aws:directoryservice/logService:LogService":
                return new LogService(name, <any>undefined, { urn })
            case "aws:directoryservice/logSubscription:LogSubscription":
                return new LogSubscription(name, <any>undefined, { urn })
            case "aws:directoryservice/radiusSettings:RadiusSettings":
                return new RadiusSettings(name, <any>undefined, { urn })
            case "aws:directoryservice/serviceRegion:ServiceRegion":
                return new ServiceRegion(name, <any>undefined, { urn })
            case "aws:directoryservice/sharedDirectory:SharedDirectory":
                return new SharedDirectory(name, <any>undefined, { urn })
            case "aws:directoryservice/sharedDirectoryAccepter:SharedDirectoryAccepter":
                return new SharedDirectoryAccepter(name, <any>undefined, { urn })
            case "aws:directoryservice/trust:Trust":
                return new Trust(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "directoryservice/conditionalForwader", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/conditionalForwarder", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/directory", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/logService", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/logSubscription", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/radiusSettings", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/serviceRegion", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/sharedDirectory", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/sharedDirectoryAccepter", _module)
pulumi.runtime.registerResourceModule("aws", "directoryservice/trust", _module)
