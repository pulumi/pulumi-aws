// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as crypto from "crypto";
import * as fs from "fs";
import * as pulumi from "@pulumi/pulumi";
import { Role, RolePolicyAttachment } from "../iam";
import { ARN } from "../arn";
import * as lambda from "../lambda";
import * as shared from "../shared";
import * as utils from "../utils";

// Kept around for back compat as this is where we originally exported this type from.
export type Context = lambda.Context;

/**
 * FunctionOptions provides configuration options for the serverless Function.
 */
export interface FunctionOptions {
    /**
     * A pre-created role to use for the Function.  If provided, 'policies' will be ignored.  If not
     * provided 'policies' will be examined to determine how to create the rol.e
     */
    role?: Role;
    /**
     * A list of IAM policy ARNs to attach to the Function.  Only used if 'role' is not provided.
     * If role is not provided, and policies are not provided.  A 'default' role will be created.
     * for this function.
     */
    policies?: ARN[];
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
                callback: lambda.Callback<any, any>,
                opts?: pulumi.ResourceOptions,
                serialize?: (obj: any) => boolean) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!callback) {
            throw new Error("Missing required function callback");
        }

        super("aws:serverless:Function", name, { options: options }, opts);

        if (options.role) {
            // If the caller provided a role, use it directly.
            this.role = options.role;
        } else if (options.policies) {
            // Otherwise, if they provided policies, create a default role with those policies attached.
            this.role = new Role(name, {
                assumeRolePolicy: JSON.stringify(shared.defaultLambdaRolePolicy),
            }, { parent: this });

            for (let policy of options.policies) {
                // RolePolicyAttachment objects don't have a phyiscal identity, and create/deletes are processed
                // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
                // structural identity by using a name that includes the role name and policyArn.
                let attachment = new RolePolicyAttachment(`${name}-${utils.sha1hash(policy)}`, {
                    role: this.role,
                    policyArn: policy,
                }, { parent: this });
            }
        } else {
            // Otherwise, just use get default lambda role and use that.
            this.role = shared.getDefaultLambdaRole();
        }

        const args: lambda.CallbackArgs = {
            role: this.role.arn,
            timeout: options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig,
            vpcConfig: options.vpcConfig,
            runtime: options.runtime,
            includePaths: options.includePaths,
            serialize: serialize,
        };

        this.lambda = lambda.createFunction(name, callback, args, { parent: this });
    }
}