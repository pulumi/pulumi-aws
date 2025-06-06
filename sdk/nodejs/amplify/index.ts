// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { AppArgs, AppState } from "./app";
export type App = import("./app").App;
export const App: typeof import("./app").App = null as any;
utilities.lazyLoad(exports, ["App"], () => require("./app"));

export { BackendEnvironmentArgs, BackendEnvironmentState } from "./backendEnvironment";
export type BackendEnvironment = import("./backendEnvironment").BackendEnvironment;
export const BackendEnvironment: typeof import("./backendEnvironment").BackendEnvironment = null as any;
utilities.lazyLoad(exports, ["BackendEnvironment"], () => require("./backendEnvironment"));

export { BranchArgs, BranchState } from "./branch";
export type Branch = import("./branch").Branch;
export const Branch: typeof import("./branch").Branch = null as any;
utilities.lazyLoad(exports, ["Branch"], () => require("./branch"));

export { DomainAssociationArgs, DomainAssociationState } from "./domainAssociation";
export type DomainAssociation = import("./domainAssociation").DomainAssociation;
export const DomainAssociation: typeof import("./domainAssociation").DomainAssociation = null as any;
utilities.lazyLoad(exports, ["DomainAssociation"], () => require("./domainAssociation"));

export { WebhookArgs, WebhookState } from "./webhook";
export type Webhook = import("./webhook").Webhook;
export const Webhook: typeof import("./webhook").Webhook = null as any;
utilities.lazyLoad(exports, ["Webhook"], () => require("./webhook"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:amplify/app:App":
                return new App(name, <any>undefined, { urn })
            case "aws:amplify/backendEnvironment:BackendEnvironment":
                return new BackendEnvironment(name, <any>undefined, { urn })
            case "aws:amplify/branch:Branch":
                return new Branch(name, <any>undefined, { urn })
            case "aws:amplify/domainAssociation:DomainAssociation":
                return new DomainAssociation(name, <any>undefined, { urn })
            case "aws:amplify/webhook:Webhook":
                return new Webhook(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "amplify/app", _module)
pulumi.runtime.registerResourceModule("aws", "amplify/backendEnvironment", _module)
pulumi.runtime.registerResourceModule("aws", "amplify/branch", _module)
pulumi.runtime.registerResourceModule("aws", "amplify/domainAssociation", _module)
pulumi.runtime.registerResourceModule("aws", "amplify/webhook", _module)
