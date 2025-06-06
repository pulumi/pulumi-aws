// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { KeyspaceArgs, KeyspaceState } from "./keyspace";
export type Keyspace = import("./keyspace").Keyspace;
export const Keyspace: typeof import("./keyspace").Keyspace = null as any;
utilities.lazyLoad(exports, ["Keyspace"], () => require("./keyspace"));

export { TableArgs, TableState } from "./table";
export type Table = import("./table").Table;
export const Table: typeof import("./table").Table = null as any;
utilities.lazyLoad(exports, ["Table"], () => require("./table"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:keyspaces/keyspace:Keyspace":
                return new Keyspace(name, <any>undefined, { urn })
            case "aws:keyspaces/table:Table":
                return new Table(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "keyspaces/keyspace", _module)
pulumi.runtime.registerResourceModule("aws", "keyspaces/table", _module)
