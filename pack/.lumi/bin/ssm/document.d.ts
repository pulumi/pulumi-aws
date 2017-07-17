import * as lumi from "@lumi/lumi";
export declare class Document extends lumi.NamedResource implements DocumentArgs {
    readonly arn: string;
    readonly content: string;
    readonly createdDate: string;
    readonly defaultVersion: string;
    readonly description: string;
    readonly documentType: string;
    readonly hash: string;
    readonly hashType: string;
    readonly latestVersion: string;
    readonly documentName?: string;
    readonly owner: string;
    readonly parameter: {
        defaultValue?: string;
        description?: string;
        name?: string;
        type?: string;
    }[];
    readonly permissions?: {
        [key: string]: {
            accountIds: string;
            type: string;
        };
    };
    readonly platformTypes: string[];
    readonly schemaVersion: string;
    readonly status: string;
    constructor(name: string, args: DocumentArgs);
}
export interface DocumentArgs {
    readonly content: string;
    readonly documentType: string;
    readonly documentName?: string;
    readonly permissions?: {
        [key: string]: {
            accountIds: string;
            type: string;
        };
    };
}

