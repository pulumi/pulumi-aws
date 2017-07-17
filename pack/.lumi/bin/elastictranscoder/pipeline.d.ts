import * as lumi from "@lumi/lumi";
export declare class Pipeline extends lumi.NamedResource implements PipelineArgs {
    readonly arn: string;
    readonly awsKmsKeyArn?: string;
    readonly contentConfig: {
        bucket: string;
        storageClass?: string;
    }[];
    readonly contentConfigPermissions?: {
        access?: string[];
        grantee?: string;
        granteeType?: string;
    }[];
    readonly inputBucket: string;
    readonly pipelineName: string;
    readonly notifications?: {
        completed?: string;
        error?: string;
        progressing?: string;
        warning?: string;
    }[];
    readonly outputBucket: string;
    readonly role: string;
    readonly thumbnailConfig: {
        bucket: string;
        storageClass?: string;
    }[];
    readonly thumbnailConfigPermissions?: {
        access?: string[];
        grantee?: string;
        granteeType?: string;
    }[];
    constructor(name: string, args: PipelineArgs);
}
export interface PipelineArgs {
    readonly awsKmsKeyArn?: string;
    readonly contentConfig?: {
        bucket: string;
        storageClass?: string;
    }[];
    readonly contentConfigPermissions?: {
        access?: string[];
        grantee?: string;
        granteeType?: string;
    }[];
    readonly inputBucket: string;
    readonly pipelineName?: string;
    readonly notifications?: {
        completed?: string;
        error?: string;
        progressing?: string;
        warning?: string;
    }[];
    readonly outputBucket?: string;
    readonly role: string;
    readonly thumbnailConfig?: {
        bucket: string;
        storageClass?: string;
    }[];
    readonly thumbnailConfigPermissions?: {
        access?: string[];
        grantee?: string;
        granteeType?: string;
    }[];
}

