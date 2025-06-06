// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { CollectionArgs, CollectionState } from "./collection";
export type Collection = import("./collection").Collection;
export const Collection: typeof import("./collection").Collection = null as any;
utilities.lazyLoad(exports, ["Collection"], () => require("./collection"));

export { ProjectArgs, ProjectState } from "./project";
export type Project = import("./project").Project;
export const Project: typeof import("./project").Project = null as any;
utilities.lazyLoad(exports, ["Project"], () => require("./project"));

export { StreamProcessorArgs, StreamProcessorState } from "./streamProcessor";
export type StreamProcessor = import("./streamProcessor").StreamProcessor;
export const StreamProcessor: typeof import("./streamProcessor").StreamProcessor = null as any;
utilities.lazyLoad(exports, ["StreamProcessor"], () => require("./streamProcessor"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:rekognition/collection:Collection":
                return new Collection(name, <any>undefined, { urn })
            case "aws:rekognition/project:Project":
                return new Project(name, <any>undefined, { urn })
            case "aws:rekognition/streamProcessor:StreamProcessor":
                return new StreamProcessor(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "rekognition/collection", _module)
pulumi.runtime.registerResourceModule("aws", "rekognition/project", _module)
pulumi.runtime.registerResourceModule("aws", "rekognition/streamProcessor", _module)
