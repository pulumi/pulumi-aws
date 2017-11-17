// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "pulumi";
import { Role, RolePolicyAttachment } from "../iam";
import * as lambda from "../lambda";
import { ARN } from "../arn";

/**
 * Context is the shape of the context object passed to a Function callback.
 */
export interface Context {
    callbackWaitsForEmptyEventLoop: boolean;
    readonly functionName: string;
    readonly functionVersion: string;
    readonly invokedFunctionArn: string;
    readonly memoryLimitInMB: string;
    readonly awsRequestId: string;
    readonly logGroupName: string;
    readonly logStreamName: string;
    readonly identity: any;
    readonly clientContext: any;
    getRemainingTimeInMillis(): string;
}

/** 
 * Handler is the signature for a serverless function.
 */
export type Handler = (event: any, context: Context, callback: (error: any, result: any) => void) => any;

export interface FunctionOptions {
    policies: ARN[];
    timeout?: number;
    memorySize?: number;
    deadLetterConfig?: { targetArn: pulumi.Computed<string>; };
    vpcConfig?: { 
        securityGroupIds: pulumi.ComputedValue<string>[], 
        subnetIds: pulumi.ComputedValue<string>[], 
    };
}

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
 * by a Lumi lambda expression and with a set of attached policies.
 */
export class Function extends pulumi.ComponentResource {
    public readonly options: FunctionOptions;
    public readonly lambda: lambda.Function;
    public readonly role: Role;
    public readonly policies: RolePolicyAttachment[];

    constructor(name: string, options: FunctionOptions, func: Handler,
                parent?: pulumi.Resource, dependsOn?: pulumi.Resource[]) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!func) {
            throw new Error("Missing required function callback");
        }

        super("aws:serverless:Function", name, { options: options }, parent, dependsOn);

        // Attach a role and then, if there are policies, attach those too.
        this.role = new Role(name + "-iamrole", {
            assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
        }, this);

        this.policies = [];
        for (let i = 0; i < options.policies.length; i++) {
            let attachment = new RolePolicyAttachment(name + "-iampolicy-" + i, {
                role: this.role,
                policyArn: options.policies[i],
            }, this);
            this.policies.push(attachment);
        }

        // Now compile the function text into an asset we can use to create the lambda.
        let closure: Promise<pulumi.runtime.Closure> = pulumi.runtime.serializeClosure(func);
        if (!closure) {
            throw new Error("Failed to serialize function closure");
        }
        this.lambda = new lambda.Function(name, {
            code: new pulumi.asset.AssetArchive({
                // TODO[pulumi/pulumi-aws#35] We may want to allow users to control what gets uploaded. Currently, we
                //     upload the entire folder as there may be dependencies on any files here.
                ".": new pulumi.asset.FileArchive("."),
                "__index.js": new pulumi.asset.StringAsset(closure.then(pulumi.runtime.serializeJavaScriptText)),
            }),
            handler: "__index.handler",
            runtime: lambda.NodeJS6d10Runtime,
            role: this.role.arn,
            timeout: options.timeout === undefined ? 180 : options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig === undefined ? undefined : [ options.deadLetterConfig ],
            vpcConfig: options.vpcConfig === undefined ? undefined : [ options.vpcConfig ],
        }, this);
    }
}

const lambdaRolePolicy = {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": "sts:AssumeRole",
            "Principal": {
                "Service": "lambda.amazonaws.com",
            },
            "Effect": "Allow",
            "Sid": "",
        },
    ],
};
