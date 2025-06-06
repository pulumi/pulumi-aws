// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ResiliencyPolicyArgs, ResiliencyPolicyState } from "./resiliencyPolicy";
export type ResiliencyPolicy = import("./resiliencyPolicy").ResiliencyPolicy;
export const ResiliencyPolicy: typeof import("./resiliencyPolicy").ResiliencyPolicy = null as any;
utilities.lazyLoad(exports, ["ResiliencyPolicy"], () => require("./resiliencyPolicy"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:resiliencehub/resiliencyPolicy:ResiliencyPolicy":
                return new ResiliencyPolicy(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "resiliencehub/resiliencyPolicy", _module)
