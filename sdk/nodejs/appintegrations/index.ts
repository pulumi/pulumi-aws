// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { DataIntegrationArgs, DataIntegrationState } from "./dataIntegration";
export type DataIntegration = import("./dataIntegration").DataIntegration;
export const DataIntegration: typeof import("./dataIntegration").DataIntegration = null as any;
utilities.lazyLoad(exports, ["DataIntegration"], () => require("./dataIntegration"));

export { GetEventIntegrationArgs, GetEventIntegrationResult, GetEventIntegrationOutputArgs } from "./getEventIntegration";
export const getEventIntegration: typeof import("./getEventIntegration").getEventIntegration = null as any;
export const getEventIntegrationOutput: typeof import("./getEventIntegration").getEventIntegrationOutput = null as any;
utilities.lazyLoad(exports, ["getEventIntegration","getEventIntegrationOutput"], () => require("./getEventIntegration"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:appintegrations/dataIntegration:DataIntegration":
                return new DataIntegration(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "appintegrations/dataIntegration", _module)
