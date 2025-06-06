// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { AssetTypeArgs, AssetTypeState } from "./assetType";
export type AssetType = import("./assetType").AssetType;
export const AssetType: typeof import("./assetType").AssetType = null as any;
utilities.lazyLoad(exports, ["AssetType"], () => require("./assetType"));

export { DomainArgs, DomainState } from "./domain";
export type Domain = import("./domain").Domain;
export const Domain: typeof import("./domain").Domain = null as any;
utilities.lazyLoad(exports, ["Domain"], () => require("./domain"));

export { EnvironmentArgs, EnvironmentState } from "./environment";
export type Environment = import("./environment").Environment;
export const Environment: typeof import("./environment").Environment = null as any;
utilities.lazyLoad(exports, ["Environment"], () => require("./environment"));

export { EnvironmentBlueprintConfigurationArgs, EnvironmentBlueprintConfigurationState } from "./environmentBlueprintConfiguration";
export type EnvironmentBlueprintConfiguration = import("./environmentBlueprintConfiguration").EnvironmentBlueprintConfiguration;
export const EnvironmentBlueprintConfiguration: typeof import("./environmentBlueprintConfiguration").EnvironmentBlueprintConfiguration = null as any;
utilities.lazyLoad(exports, ["EnvironmentBlueprintConfiguration"], () => require("./environmentBlueprintConfiguration"));

export { EnvironmentProfileArgs, EnvironmentProfileState } from "./environmentProfile";
export type EnvironmentProfile = import("./environmentProfile").EnvironmentProfile;
export const EnvironmentProfile: typeof import("./environmentProfile").EnvironmentProfile = null as any;
utilities.lazyLoad(exports, ["EnvironmentProfile"], () => require("./environmentProfile"));

export { FormTypeArgs, FormTypeState } from "./formType";
export type FormType = import("./formType").FormType;
export const FormType: typeof import("./formType").FormType = null as any;
utilities.lazyLoad(exports, ["FormType"], () => require("./formType"));

export { GetDomainArgs, GetDomainResult, GetDomainOutputArgs } from "./getDomain";
export const getDomain: typeof import("./getDomain").getDomain = null as any;
export const getDomainOutput: typeof import("./getDomain").getDomainOutput = null as any;
utilities.lazyLoad(exports, ["getDomain","getDomainOutput"], () => require("./getDomain"));

export { GetEnvironmentBlueprintArgs, GetEnvironmentBlueprintResult, GetEnvironmentBlueprintOutputArgs } from "./getEnvironmentBlueprint";
export const getEnvironmentBlueprint: typeof import("./getEnvironmentBlueprint").getEnvironmentBlueprint = null as any;
export const getEnvironmentBlueprintOutput: typeof import("./getEnvironmentBlueprint").getEnvironmentBlueprintOutput = null as any;
utilities.lazyLoad(exports, ["getEnvironmentBlueprint","getEnvironmentBlueprintOutput"], () => require("./getEnvironmentBlueprint"));

export { GlossaryArgs, GlossaryState } from "./glossary";
export type Glossary = import("./glossary").Glossary;
export const Glossary: typeof import("./glossary").Glossary = null as any;
utilities.lazyLoad(exports, ["Glossary"], () => require("./glossary"));

export { GlossaryTermArgs, GlossaryTermState } from "./glossaryTerm";
export type GlossaryTerm = import("./glossaryTerm").GlossaryTerm;
export const GlossaryTerm: typeof import("./glossaryTerm").GlossaryTerm = null as any;
utilities.lazyLoad(exports, ["GlossaryTerm"], () => require("./glossaryTerm"));

export { ProjectArgs, ProjectState } from "./project";
export type Project = import("./project").Project;
export const Project: typeof import("./project").Project = null as any;
utilities.lazyLoad(exports, ["Project"], () => require("./project"));

export { UserProfileArgs, UserProfileState } from "./userProfile";
export type UserProfile = import("./userProfile").UserProfile;
export const UserProfile: typeof import("./userProfile").UserProfile = null as any;
utilities.lazyLoad(exports, ["UserProfile"], () => require("./userProfile"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:datazone/assetType:AssetType":
                return new AssetType(name, <any>undefined, { urn })
            case "aws:datazone/domain:Domain":
                return new Domain(name, <any>undefined, { urn })
            case "aws:datazone/environment:Environment":
                return new Environment(name, <any>undefined, { urn })
            case "aws:datazone/environmentBlueprintConfiguration:EnvironmentBlueprintConfiguration":
                return new EnvironmentBlueprintConfiguration(name, <any>undefined, { urn })
            case "aws:datazone/environmentProfile:EnvironmentProfile":
                return new EnvironmentProfile(name, <any>undefined, { urn })
            case "aws:datazone/formType:FormType":
                return new FormType(name, <any>undefined, { urn })
            case "aws:datazone/glossary:Glossary":
                return new Glossary(name, <any>undefined, { urn })
            case "aws:datazone/glossaryTerm:GlossaryTerm":
                return new GlossaryTerm(name, <any>undefined, { urn })
            case "aws:datazone/project:Project":
                return new Project(name, <any>undefined, { urn })
            case "aws:datazone/userProfile:UserProfile":
                return new UserProfile(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "datazone/assetType", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/domain", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/environment", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/environmentBlueprintConfiguration", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/environmentProfile", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/formType", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/glossary", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/glossaryTerm", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/project", _module)
pulumi.runtime.registerResourceModule("aws", "datazone/userProfile", _module)
