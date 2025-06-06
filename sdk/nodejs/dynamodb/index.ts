// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { ContributorInsightsArgs, ContributorInsightsState } from "./contributorInsights";
export type ContributorInsights = import("./contributorInsights").ContributorInsights;
export const ContributorInsights: typeof import("./contributorInsights").ContributorInsights = null as any;
utilities.lazyLoad(exports, ["ContributorInsights"], () => require("./contributorInsights"));

export * from "./dynamodbMixins";
export { GetTableArgs, GetTableResult, GetTableOutputArgs } from "./getTable";
export const getTable: typeof import("./getTable").getTable = null as any;
export const getTableOutput: typeof import("./getTable").getTableOutput = null as any;
utilities.lazyLoad(exports, ["getTable","getTableOutput"], () => require("./getTable"));

export { GetTableItemArgs, GetTableItemResult, GetTableItemOutputArgs } from "./getTableItem";
export const getTableItem: typeof import("./getTableItem").getTableItem = null as any;
export const getTableItemOutput: typeof import("./getTableItem").getTableItemOutput = null as any;
utilities.lazyLoad(exports, ["getTableItem","getTableItemOutput"], () => require("./getTableItem"));

export { GetTablesResult } from "./getTables";
export const getTables: typeof import("./getTables").getTables = null as any;
export const getTablesOutput: typeof import("./getTables").getTablesOutput = null as any;
utilities.lazyLoad(exports, ["getTables","getTablesOutput"], () => require("./getTables"));

export { GlobalTableArgs, GlobalTableState } from "./globalTable";
export type GlobalTable = import("./globalTable").GlobalTable;
export const GlobalTable: typeof import("./globalTable").GlobalTable = null as any;
utilities.lazyLoad(exports, ["GlobalTable"], () => require("./globalTable"));

export { KinesisStreamingDestinationArgs, KinesisStreamingDestinationState } from "./kinesisStreamingDestination";
export type KinesisStreamingDestination = import("./kinesisStreamingDestination").KinesisStreamingDestination;
export const KinesisStreamingDestination: typeof import("./kinesisStreamingDestination").KinesisStreamingDestination = null as any;
utilities.lazyLoad(exports, ["KinesisStreamingDestination"], () => require("./kinesisStreamingDestination"));

export { ResourcePolicyArgs, ResourcePolicyState } from "./resourcePolicy";
export type ResourcePolicy = import("./resourcePolicy").ResourcePolicy;
export const ResourcePolicy: typeof import("./resourcePolicy").ResourcePolicy = null as any;
utilities.lazyLoad(exports, ["ResourcePolicy"], () => require("./resourcePolicy"));

export { TableArgs, TableState } from "./table";
export type Table = import("./table").Table;
export const Table: typeof import("./table").Table = null as any;
utilities.lazyLoad(exports, ["Table"], () => require("./table"));

export { TableExportArgs, TableExportState } from "./tableExport";
export type TableExport = import("./tableExport").TableExport;
export const TableExport: typeof import("./tableExport").TableExport = null as any;
utilities.lazyLoad(exports, ["TableExport"], () => require("./tableExport"));

export { TableItemArgs, TableItemState } from "./tableItem";
export type TableItem = import("./tableItem").TableItem;
export const TableItem: typeof import("./tableItem").TableItem = null as any;
utilities.lazyLoad(exports, ["TableItem"], () => require("./tableItem"));

export { TableReplicaArgs, TableReplicaState } from "./tableReplica";
export type TableReplica = import("./tableReplica").TableReplica;
export const TableReplica: typeof import("./tableReplica").TableReplica = null as any;
utilities.lazyLoad(exports, ["TableReplica"], () => require("./tableReplica"));

export { TagArgs, TagState } from "./tag";
export type Tag = import("./tag").Tag;
export const Tag: typeof import("./tag").Tag = null as any;
utilities.lazyLoad(exports, ["Tag"], () => require("./tag"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:dynamodb/contributorInsights:ContributorInsights":
                return new ContributorInsights(name, <any>undefined, { urn })
            case "aws:dynamodb/globalTable:GlobalTable":
                return new GlobalTable(name, <any>undefined, { urn })
            case "aws:dynamodb/kinesisStreamingDestination:KinesisStreamingDestination":
                return new KinesisStreamingDestination(name, <any>undefined, { urn })
            case "aws:dynamodb/resourcePolicy:ResourcePolicy":
                return new ResourcePolicy(name, <any>undefined, { urn })
            case "aws:dynamodb/table:Table":
                return new Table(name, <any>undefined, { urn })
            case "aws:dynamodb/tableExport:TableExport":
                return new TableExport(name, <any>undefined, { urn })
            case "aws:dynamodb/tableItem:TableItem":
                return new TableItem(name, <any>undefined, { urn })
            case "aws:dynamodb/tableReplica:TableReplica":
                return new TableReplica(name, <any>undefined, { urn })
            case "aws:dynamodb/tag:Tag":
                return new Tag(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "dynamodb/contributorInsights", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/globalTable", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/kinesisStreamingDestination", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/resourcePolicy", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/table", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/tableExport", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/tableItem", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/tableReplica", _module)
pulumi.runtime.registerResourceModule("aws", "dynamodb/tag", _module)
