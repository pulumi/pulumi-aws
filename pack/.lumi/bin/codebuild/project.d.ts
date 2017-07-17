import * as lumi from "@lumi/lumi";
export declare class Project extends lumi.NamedResource implements ProjectArgs {
    readonly artifacts: {
        location?: string;
        name?: string;
        namespaceType?: string;
        packaging?: string;
        path?: string;
        type: string;
    }[];
    readonly buildTimeout?: number;
    readonly description: string;
    readonly encryptionKey: string;
    readonly environment: {
        computeType: string;
        environmentVariable: {
            name: string;
            value: string;
        }[];
        image: string;
        privilegedMode?: boolean;
        type: string;
    }[];
    readonly projectName?: string;
    readonly serviceRole: string;
    readonly source: {
        auth?: {
            resource?: string;
            type: string;
        }[];
        buildspec?: string;
        location?: string;
        type: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: ProjectArgs);
}
export interface ProjectArgs {
    readonly artifacts: {
        location?: string;
        name?: string;
        namespaceType?: string;
        packaging?: string;
        path?: string;
        type: string;
    }[];
    readonly buildTimeout?: number;
    readonly description?: string;
    readonly encryptionKey?: string;
    readonly environment: {
        computeType: string;
        environmentVariable: {
            name: string;
            value: string;
        }[];
        image: string;
        privilegedMode?: boolean;
        type: string;
    }[];
    readonly projectName?: string;
    readonly serviceRole?: string;
    readonly source: {
        auth?: {
            resource?: string;
            type: string;
        }[];
        buildspec?: string;
        location?: string;
        type: string;
    }[];
    readonly tags?: {
        [key: string]: any;
    };
}

