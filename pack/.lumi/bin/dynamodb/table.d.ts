import * as lumi from "@lumi/lumi";
export declare class Table extends lumi.NamedResource implements TableArgs {
    readonly arn: string;
    readonly attribute: {
        name: string;
        type: string;
    }[];
    readonly globalSecondaryIndex?: {
        hashKey: string;
        name: string;
        nonKeyAttributes?: string[];
        projectionType: string;
        rangeKey?: string;
        readCapacity: number;
        writeCapacity: number;
    }[];
    readonly hashKey: string;
    readonly localSecondaryIndex?: {
        name: string;
        nonKeyAttributes?: string[];
        projectionType: string;
        rangeKey: string;
    }[];
    readonly tableName?: string;
    readonly rangeKey?: string;
    readonly readCapacity: number;
    readonly streamArn: string;
    readonly streamEnabled: boolean;
    readonly streamLabel: string;
    readonly streamViewType: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly ttl?: {
        attributeName: string;
        enabled: boolean;
    }[];
    readonly writeCapacity: number;
    constructor(name: string, args: TableArgs);
}
export interface TableArgs {
    readonly attribute: {
        name: string;
        type: string;
    }[];
    readonly globalSecondaryIndex?: {
        hashKey: string;
        name: string;
        nonKeyAttributes?: string[];
        projectionType: string;
        rangeKey?: string;
        readCapacity: number;
        writeCapacity: number;
    }[];
    readonly hashKey: string;
    readonly localSecondaryIndex?: {
        name: string;
        nonKeyAttributes?: string[];
        projectionType: string;
        rangeKey: string;
    }[];
    readonly tableName?: string;
    readonly rangeKey?: string;
    readonly readCapacity: number;
    readonly streamEnabled?: boolean;
    readonly streamViewType?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly ttl?: {
        attributeName: string;
        enabled: boolean;
    }[];
    readonly writeCapacity: number;
}

