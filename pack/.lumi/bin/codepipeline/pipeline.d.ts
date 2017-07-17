import * as lumi from "@lumi/lumi";
export declare class Pipeline extends lumi.NamedResource implements PipelineArgs {
    readonly artifactStore: {
        encryptionKey?: {
            id: string;
            type: string;
        }[];
        location: string;
        type: string;
    }[];
    readonly pipelineName?: string;
    readonly roleArn: string;
    readonly stage: {
        action: {
            category: string;
            configuration?: {
                [key: string]: any;
            };
            inputArtifacts?: string[];
            name: string;
            outputArtifacts?: string[];
            owner: string;
            provider: string;
            roleArn?: string;
            runOrder: number;
            version: string;
        }[];
        name: string;
    }[];
    constructor(name: string, args: PipelineArgs);
}
export interface PipelineArgs {
    readonly artifactStore: {
        encryptionKey?: {
            id: string;
            type: string;
        }[];
        location: string;
        type: string;
    }[];
    readonly pipelineName?: string;
    readonly roleArn: string;
    readonly stage: {
        action: {
            category: string;
            configuration?: {
                [key: string]: any;
            };
            inputArtifacts?: string[];
            name: string;
            outputArtifacts?: string[];
            owner: string;
            provider: string;
            roleArn?: string;
            runOrder: number;
            version: string;
        }[];
        name: string;
    }[];
}

