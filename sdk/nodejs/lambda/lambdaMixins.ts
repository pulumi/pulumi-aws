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

import * as pulumi from "@pulumi/pulumi";
import * as awslambda from "aws-lambda";

import * as arn from "../arn";
import * as iam from "../iam";
import * as utils from "../utils";

import { Function as LambdaFunction, FunctionArgs } from "./function";
import * as permission from "./permission";
import { Runtime } from ".";

export type Context = awslambda.Context;
export type Callback<E, R> = awslambda.Handler<E, R>;

/**
 * CallbackFactory is the signature for a function that will be called once to produce the
 * entrypoint function that AWS Lambda will invoke.  It can be used to initialize expensive state
 * once that can then be used across all invocations of the Lambda (as long as the Lambda is using
 * the same warm node instance).
 */
export type CallbackFactory<E, R> = () => Callback<E, R>;

/**
 * An EventHandler is either a JavaScript callback or an aws.lambda.Function that can be used to
 * handle an event triggered by some resource.  If just a JavaScript callback is provided the AWS
 * Lambda will be created by calling [createCallbackFunction] on it.  If more control over the
 * resultant AWS Lambda is required, clients can call [createCallbackFunction] directly and pass the
 * result of that to any code that needs an EventHandler.
 */
export type EventHandler<E, R> = Callback<E, R> | LambdaFunction;

/**
 * BaseCallbackFunctionArgs provides configuration options for the serverless Function.  It is
 * effectively equivalent to [aws.lambda.FunctionArgs] except with a few important differences
 * documented at the property level.  For example, [role] is an actual iam.Role instance, and not an
 * ARN. Properties like [runtime] are now optional.  And some properties (like [code]) are entirely
 * disallowed.
 */
export type BaseCallbackFunctionArgs = utils.Overwrite<FunctionArgs, {
    /**
     * Not allowed when creating an aws.serverless.Function.  The [code] will be generated from the
     * passed in JavaScript callback.
     */
    code?: never;

    /**
     * Not allowed when creating an aws.serverless.Function.  The [code] will be generated from the
     * passed in JavaScript callback.
     */
    handler?: never;

    /**
     * A pre-created role to use for the Function. If not provided, [policies] will be used.
     */
    role?: iam.Role;

    /**
     * A list of IAM policy ARNs to attach to the Function.  Will be used if [role] is not provide.
     * If neither [role] nor [policies] is provided, a default policy of [iam.AWSLambda_FullAccess]
     * will be used instead.
     */
    policies?: arn.ARN[];

    /**
     * The Lambda runtime to use.  If not provided, will default to [NodeJS8d10Runtime]
     */
    runtime?: Runtime;

    /**
     * Options to control which paths/packages should be included or excluded in the zip file containing
     * the code for the AWS lambda.
     */
    codePathOptions?: pulumi.runtime.CodePathOptions;
}>;

/**
 * CallbackFunctionArgs provides configuration options for the serverless Function.  It is
 * effectively equivalent to [aws.lambda.FunctionArgs] except with a few important differences
 * documented at the property level.  For example, [role] is an actual iam.Role instance, and not an
 * ARN. Properties like [runtime] are now optional.  And some properties (like [code]) are entirely
 * disallowed.
 */
export interface CallbackFunctionArgs<E, R> extends BaseCallbackFunctionArgs {
    /**
     * The Javascript callback to use as the entrypoint for the AWS Lambda out of.  Either
     * [callback] or [callbackFactory] must be provided.
     */
    callback?: Callback<E, R>;

    /**
     * The Javascript function instance that will be called to produce the callback function that is
     * the entrypoint for the AWS Lambda. Either [callback] or [callbackFactory] must be
     * provided.
     *
     * This form is useful when there is expensive initialization work that should only be executed
     * once.  The factory-function will be invoked once when the final AWS Lambda module is loaded.
     * It can run whatever code it needs, and will end by returning the actual function that Lambda
     * will call into each time the Lambda is invoked.
     */
    callbackFactory?: CallbackFactory<E, R>;
};

/**
 * Base type for all subscription types.  An event subscription represents a connection between some
 * AWS resource and an AWS lambda that will be triggered when something happens to that resource.
 */
export class EventSubscription extends pulumi.ComponentResource {
    public permission!: permission.Permission;
    public func!: LambdaFunction;

    public constructor(
        type: string, name: string, opts?: pulumi.ComponentResourceOptions) {

        super(type, name, {}, opts);
    }
}

export function isEventHandler(obj: any): obj is EventHandler<any, any> {
    return LambdaFunction.isInstance(obj) || obj instanceof Function;
}

export function createFunctionFromEventHandler<E, R>(
    name: string, handler: EventHandler<E, R>, opts?: pulumi.ResourceOptions): LambdaFunction {

    if (handler instanceof Function) {
        return new CallbackFunction(name, { callback: handler }, opts);
    }
    else {
        return handler;
    }
}

/**
 * A CallbackFunction is a special type of aws.lambda.Function that can be created out of an actual
 * JavaScript function instance.  The function instance will be analyzed and packaged up (including
 * dependencies) into a form that can be used by AWS Lambda.  See
 * https://www.pulumi.com/docs/tutorials/aws/serializing-functions/ for additional
 * details on this process.
 * If no IAM Role is specified, CallbackFunction will automatically use the following managed policies:
 * `AWSLambda_FullAccess`
 * `CloudWatchFullAccess`
 * `CloudWatchEventsFullAccess`
 * `AmazonS3FullAccess`
 * `AmazonDynamoDBFullAccess`
 * `AmazonSQSFullAccess`
 * `AmazonKinesisFullAccess`
 * `AWSCloudFormationReadOnlyAccess`
 * `AmazonCognitoPowerUser`
 * `AWSXrayWriteOnlyAccess`
 */
export class CallbackFunction<E, R> extends LambdaFunction {
    public constructor(name: string, args: CallbackFunctionArgs<E, R>, opts: pulumi.CustomResourceOptions = {}) {
        if (!name) {
            throw new Error("Missing required resource name");
        }

        if (args.callback && args.callbackFactory) {
            throw new pulumi.RunError("Cannot provide both [callback] and [callbackFactory]");
        }

        const func = args.callback || args.callbackFactory;
        if (!func) {
            throw new Error("One of [callback] or [callbackFactory] must be provided.");
        }

        let role: iam.Role;
        if (args.role) {
            role = args.role;
        } else {
            // Attach a role and then, if there are policies, attach those too.
            role = new iam.Role(name, {
                assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
            }, opts);

            if (!args.policies) {

                const policies = [iam.ManagedPolicy.LambdaFullAccess, iam.ManagedPolicy.CloudWatchFullAccess,
                    iam.ManagedPolicy.CloudWatchEventsFullAccess, iam.ManagedPolicy.AmazonS3FullAccess,
                    iam.ManagedPolicy.AmazonDynamoDBFullAccess, iam.ManagedPolicy.AmazonSQSFullAccess,
                    iam.ManagedPolicy.AmazonKinesisFullAccess, iam.ManagedPolicy.AmazonCognitoPowerUser,
                    iam.ManagedPolicy.AWSXrayWriteOnlyAccess,
                ]

                for (const policy of policies) {
                    const attachment = new iam.RolePolicyAttachment(`${name}-${utils.sha1hash(policy)}`, {
                        role: role,
                        policyArn: policy,
                    }, opts);
                }
            }

            if (args.policies) {
                for (const policy of args.policies) {
                    // RolePolicyAttachment objects don't have a physical identity, and create/deletes are processed
                    // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
                    // structural identity by using a name that includes the role name and policyArn.
                    const attachment = new iam.RolePolicyAttachment(`${name}-${utils.sha1hash(policy)}`, {
                        role: role,
                        policyArn: policy,
                    }, opts);
                }
            }
        }

        // Now compile the function text into an asset we can use to create the lambda. Note: to
        // prevent a circularity/deadlock, we list this Function object as something that the
        // serialized closure cannot reference.
        const handlerName = "handler";
        const serializedFileNameNoExtension = "__index";

        const closure = pulumi.runtime.serializeFunction(func, {
            serialize: _ => true,
            exportName: handlerName,
            isFactoryFunction: !!args.callbackFactory,
            allowSecrets: true,
        });

        const codePaths = computeCodePaths(
            closure, serializedFileNameNoExtension, args.codePathOptions);

        const code = pulumi.output(new pulumi.asset.AssetArchive(codePaths));
        (<any>code).isSecret = closure.then(c => c.containsSecrets);

        // Copy over all option values into the function args.  Then overwrite anything we care
        // about with our own values.  This ensures that clients can pass future supported
        // lambda options without us having to know about it.
        // The default version for Lambda functions now is NodeJS16. As of April 30 2022, Node12
        // is EOL/ nodeJS 14 is only in maintenance mode so it's best to upgrade to Node16
        const functionArgs = {
            ...args,
            code: code,
            handler: serializedFileNameNoExtension + "." + handlerName,
            runtime: args.runtime || Runtime.NodeJS16dX,
            role: role.arn,
            timeout: args.timeout === undefined ? 180 : args.timeout,
        };

        // If there is no custom Runtime argument being passed to the user
        // then we should add "runtime" to the ignoreChanges of the CustomResourceOptions
        // This is because as of 12/16/19, we upgraded the default NodeJS version from 8.x to 12.x as 12.x is latest LTS
        // We don't want to force recreation of user defined Lambdas because of this change
        if (!args.runtime) {
            pulumi.mergeOptions(opts, { ignoreChanges: ["runtime"] })
        }

        super(name, functionArgs, opts);
        this.roleInstance = role;
    }
}

// computeCodePaths calculates an AssetMap of files to include in the Lambda package.
async function computeCodePaths(
        closure: Promise<pulumi.runtime.SerializedFunction>,
        serializedFileNameNoExtension: string,
        codePathOptions: pulumi.runtime.CodePathOptions | undefined): Promise<pulumi.asset.AssetMap> {

    const serializedFunction = await closure;

    // Construct the set of paths to include in the archive for upload.
    let codePaths: pulumi.asset.AssetMap = {
        // Always include the serialized function.
        [serializedFileNameNoExtension + ".js"]: new pulumi.asset.StringAsset(serializedFunction.text),
    };

    // AWS Lambda always provides `aws-sdk`, so skip this.  Do this before processing user-provided
    // extraIncludePackages so that users can force aws-sdk to be included (if they need a specific
    // version).
    codePathOptions = codePathOptions || {};
    codePathOptions.extraExcludePackages = codePathOptions.extraExcludePackages || [];
    codePathOptions.extraExcludePackages.push("aws-sdk");

    const modulePaths = await pulumi.runtime.computeCodePaths(codePathOptions);

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
// Mixin the Role we potentially create into the Function instances we return.

declare module "./function" {
    interface Function {
        /**
         * Actual Role instance value for this Function.  Will only be set if this function was
         * created from [createFunction]
         */
        roleInstance?: iam.Role;
    }
}
