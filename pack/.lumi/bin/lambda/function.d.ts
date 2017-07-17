import * as lumi from "@lumi/lumi";
import { ARN } from "../index";
export declare class Function extends lumi.NamedResource implements FunctionArgs {
    readonly arn: string;
    readonly deadLetterConfig?: {
        targetArn: string;
    }[];
    readonly description?: string;
    readonly environment?: {
        variables?: {
            [key: string]: string;
        };
    }[];
    readonly code?: lumi.asset.Archive;
    readonly functionName?: string;
    readonly handler: string;
    readonly invokeArn: string;
    readonly kmsKeyArn?: string;
    readonly lastModified: string;
    readonly memorySize?: number;
    readonly publish?: boolean;
    readonly qualifiedArn: string;
    readonly role: ARN;
    readonly runtime: string;
    readonly s3Bucket?: string;
    readonly s3Key?: string;
    readonly s3ObjectVersion?: string;
    readonly sourceCodeHash: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly timeout?: number;
    readonly tracingConfig: {
        mode: string;
    }[];
    readonly version: string;
    readonly vpcConfig?: {
        securityGroupIds: string[];
        subnetIds: string[];
        vpcId: string;
    }[];
    constructor(name: string, args: FunctionArgs);
}
export interface FunctionArgs {
    readonly deadLetterConfig?: {
        targetArn: string;
    }[];
    readonly description?: string;
    readonly environment?: {
        variables?: {
            [key: string]: string;
        };
    }[];
    readonly code?: lumi.asset.Archive;
    readonly functionName?: string;
    readonly handler: string;
    readonly kmsKeyArn?: string;
    readonly memorySize?: number;
    readonly publish?: boolean;
    readonly role: ARN;
    readonly runtime: string;
    readonly s3Bucket?: string;
    readonly s3Key?: string;
    readonly s3ObjectVersion?: string;
    readonly sourceCodeHash?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly timeout?: number;
    readonly tracingConfig?: {
        mode: string;
    }[];
    readonly vpcConfig?: {
        securityGroupIds: string[];
        subnetIds: string[];
        vpcId: string;
    }[];
}

