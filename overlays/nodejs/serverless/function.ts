// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as crypto from "crypto";
import * as fs from "fs";
import * as pulumi from "@pulumi/pulumi";
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

/**
 * FunctionOptions provides configuration options for the serverless Function.
 */
export interface FunctionOptions {
    /**
     * A list of IAM policy ARNs to attach to the Function.  Must provide either [policies] or [role].
     */
    policies?: ARN[];
    /**
     * A pre-created role to use for the Function.  Must provide either [policies] or [role].
     */
    role?: Role;
    /**
     * A timout, in seconds, to apply to the Function.
     */
    timeout?: number;
    /**
     * The memory size limit to use for execution of the Function.
     */
    memorySize?: number;
    /**
     * The Lambda runtime to use.
     */
    runtime?: lambda.Runtime;
    /**
     * A dead letter target ARN to send function invocation failures to.
     */
    deadLetterConfig?: { targetArn: pulumi.Input<string>; };
    /**
     * Configuration for a VPC to run the Function within.
     */
    vpcConfig?: {
        securityGroupIds: pulumi.Input<string[]>,
        subnetIds: pulumi.Input<string[]>,
    };
    /**
     * The paths relative to the program folder to include in the Lambda upload.  Default is `["node_modules"]`.
     */
    includePaths?: string[];
}

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
 * by a Lumi lambda expression and with a set of attached policies.
 */
export class Function extends pulumi.ComponentResource {
    public readonly options: FunctionOptions;
    public readonly lambda: lambda.Function;
    public readonly role: Role;

    constructor(name: string,
                options: FunctionOptions,
                func: Handler,
                opts?: pulumi.ResourceOptions,
                serialize?: (obj: any) => boolean) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!func) {
            throw new Error("Missing required function callback");
        }

        super("aws:serverless:Function", name, { options: options }, opts);

        if (options.role) {
            this.role = options.role;
        } else {
            // Attach a role and then, if there are policies, attach those too.
            this.role = new Role(name, {
                assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
            }, { parent: this });

            for (let policy of options.policies) {
                // RolePolicyAttachment objects don't have a phyiscal identity, and create/deletes are processed
                // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
                // structural identity by using a name that includes the role name and policyArn.
                let attachment = new RolePolicyAttachment(`${name}-${sha1hash(policy)}`, {
                    role: this.role,
                    policyArn: policy,
                }, { parent: this });
            }
        }

        // Now compile the function text into an asset we can use to create the lambda. Note: to
        // prevent a circularity/deadlock, we list this Function object as something that the
        // serialized closure cannot reference.
        serialize = serialize || (_ => true);
        const finalSerialize = (o: any) => {
            return serialize(o) && o !== this;
        }

        let closure = pulumi.runtime.serializeFunctionAsync(func, finalSerialize);
        if (!closure) {
            throw new Error("Failed to serialize function closure");
        }
        
        // Construct the set of paths to include in the archive for upload.
        let codePaths = {
            // Always include the serialized function.
            "__index.js": new pulumi.asset.StringAsset(closure),
        };
        // Also add each provided path to the archive - or the `node_modules` folder if no includePaths specified.
        const includePaths = options.includePaths || ["./node_modules/"];
        for (const path of includePaths) {
            // The Asset model does not support a consistent way to embed a file-or-directory into an `AssetArchive`, so
            // we stat the path to figure out which it is and use the appropriate Asset constructor.
            const stats = fs.lstatSync(path);
            if (stats.isDirectory()) {
                codePaths[path] = new pulumi.asset.FileArchive(path);
            } else {
                codePaths[path] = new pulumi.asset.FileAsset(path);
            }
        }

        // Create the Lambda Function.
        this.lambda = new lambda.Function(name, {
            code: new pulumi.asset.AssetArchive(codePaths),
            handler: "__index.handler",
            runtime: options.runtime || lambda.NodeJS8d10Runtime,
            role: this.role.arn,
            timeout: options.timeout === undefined ? 180 : options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig,
            vpcConfig: options.vpcConfig,
        }, { parent: this });
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

// sha1hash returns a partial SHA1 hash of the input string.
function sha1hash(s: string): string {
    const shasum: crypto.Hash = crypto.createHash("sha1");
    shasum.update(s);
    return shasum.digest("hex").substring(0, 8);
}
