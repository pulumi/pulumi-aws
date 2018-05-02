// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as crypto from "crypto";
import * as pulumi from "@pulumi/pulumi";
import { Role, RolePolicyAttachment } from "../iam";
import { ARN } from "../arn";
import * as lambda from "../lambda";

export interface FunctionOptions {
    policies: ARN[];
    timeout?: number;
    memorySize?: number;
    runtime?: lambda.Runtime;
    deadLetterConfig?: { targetArn: pulumi.Input<string>; };
    vpcConfig?: {
        securityGroupIds: pulumi.Input<string[]>,
        subnetIds: pulumi.Input<string[]>,
    };
}

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
 * by a Lumi lambda expression and with a set of attached policies.
 */
export class Function<TArg, TResult> extends pulumi.ComponentResource {
    public readonly options: FunctionOptions;
    public readonly lambda: lambda.Function;
    public readonly role: Role;
    public readonly policies: RolePolicyAttachment[];

    constructor(name: string,
                options: FunctionOptions,
                func: lambda.Handler<TArg, TResult>,
                opts?: pulumi.ResourceOptions,
                serialize?: (obj: any) => boolean) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!func) {
            throw new Error("Missing required function callback");
        }

        super("aws:serverless:Function", name, { options: options }, opts);

        // Attach a role and then, if there are policies, attach those too.
        this.role = new Role(name, {
            assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
        }, { parent: this });

        this.policies = [];
        for (let policy of options.policies) {
            // RolePolicyAttachment objects don't have a phyiscal identity, and create/deletes are processed
            // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
            // structural identity by using a name that includes the role name and policyArn.
            let attachment = new RolePolicyAttachment(`${name}-${sha1hash(policy)}`, {
                role: this.role,
                policyArn: policy,
            }, { parent: this });
            this.policies.push(attachment);
        }

        const args: lambda.CallbackFunctionArgs = {
            role: this.role.arn,
            timeout: options.timeout === undefined ? 180 : options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig,
            vpcConfig: options.vpcConfig,
            runtime: options.runtime || lambda.NodeJS8d10Runtime,
        };

        this.lambda = lambda.createFunction(name, func, args, serialize, { parent: this });
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
