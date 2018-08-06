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
     * The Lambda environment's configuration settings.
     */
    environment?: pulumi.Input<{ variables?: pulumi.Input<{[key: string]: pulumi.Input<string>}> }>;
    /**
     * The paths relative to the program folder to include in the Lambda upload.  Default is `[]`.
     */
    includePaths?: string[];
    /**
     * The packages relative to the program folder to include in the Lambda upload.  The version of
     * the package installed in the program folder and it's dependencies will all be included.
     * Default is `[]`.
     */
    includePackages?: string[];
    /**
     * The packages relative to the program folder to not include the Lambda upload. This can be
     * used to override the default serialization logic that includes all packages referenced by
     * project.json (except @pulumi packages).  Default is `[]`.
     */
    excludePackages?: string[];
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
        } else if (options.policies) {
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
        } else {
            throw new Error("One of 'role' or 'policies' must be specified.");
        }

        // Now compile the function text into an asset we can use to create the lambda. Note: to
        // prevent a circularity/deadlock, we list this Function object as something that the
        // serialized closure cannot reference.
        serialize = serialize || (_ => true);
        const finalSerialize = (o: any) => {
            return serialize(o) && o !== this;
        }

        const handlerName = "handler";
        const serializedFileNameNoExtension = "__index";

        let closure = pulumi.runtime.serializeFunction(func, {
            serialize: finalSerialize,
            exportName: handlerName,
        });

        let codePaths = computeCodePaths(
            closure, serializedFileNameNoExtension, options.includePaths, options.excludePackages);

        // Create the Lambda Function.
        this.lambda = new lambda.Function(name, {
            code: new pulumi.asset.AssetArchive(codePaths),
            handler: serializedFileNameNoExtension + "." + handlerName,
            runtime: options.runtime || lambda.NodeJS8d10Runtime,
            environment: options.environment,
            role: this.role.arn,
            timeout: options.timeout === undefined ? 180 : options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig,
            vpcConfig: options.vpcConfig,
        }, { parent: this });
    }
}

// computeCodePaths calculates an AssetMap of files to include in the Lambda package.
async function computeCodePaths(
        closure: Promise<pulumi.runtime.SerializedFunction>,
        serializedFileNameNoExtension: string,
        extraIncludePaths?: string[],
        extraIncludePackages?: string[],
        extraExcludePackages?: string[]): Promise<pulumi.asset.AssetMap> {

    const serializedFunction = await closure;

    // Construct the set of paths to include in the archive for upload.
    let codePaths: pulumi.asset.AssetMap = {
        // Always include the serialized function.
        [serializedFileNameNoExtension + ".js"]: new pulumi.asset.StringAsset(serializedFunction.text),
    };

    // AWS Lambda always provides `aws-sdk`, so skip this.  Do this before processing user-provided
    // extraIncludePackages so that users can force aws-sdk to be included (if they need a specific
    // version).
    extraExcludePackages = extraExcludePackages || [];
    extraExcludePackages.push("aws-sdk");

    let modulePaths = await pulumi.runtime.computeCodePaths(
        extraIncludePaths, extraIncludePackages, extraExcludePackages);

    for (const [path, asset] of modulePaths) {
        codePaths[path] = asset;
    }

    return codePaths;
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
