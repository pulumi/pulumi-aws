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

import * as arn from "../arn";
import * as iam from "../iam";
import * as utils from "../utils";

import { Function as LambdaFunction, FunctionArgs } from "./function";
import * as permission from "./permission";
import * as runtime from "./runtimes";

/**
 * Context is the shape of the context object passed to a Function callback.  For more information,
 * see: https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-context.html
 */
export interface Context {
    /**
     * The default value is true. This property is useful only to modify the default behavior of the
     * callback. By default, the callback will wait until the event loop is empty before freezing
     * the process and returning the results to the caller. You can set this property to false to
     * request AWS Lambda to freeze the process soon after the callback is called, even if there are
     * events in the event loop. AWS Lambda will freeze the process, any state data and the events
     * in the event loop (any remaining events in the event loop processed when the Lambda function
     * is called next and if AWS Lambda chooses to use the frozen process).
     */
    callbackWaitsForEmptyEventLoop: boolean;

    /**
     * Name of the Lambda function that is executing.
     */
    readonly functionName: string;

    /**
     * The Lambda function version that is executing. If an alias is used to invoke the function,
     * then function_version will be the version the alias points to.
     */
    readonly functionVersion: string;

    /**
     * The ARN used to invoke this function. It can be a function ARN or an alias ARN. An
     * unqualified ARN executes the $LATEST version and aliases execute the function version it is
     * pointing to.
     */
    readonly invokedFunctionArn: string;

    /**
     * Memory limit, in MB, you configured for the Lambda function. You set the memory limit at the
     * time you create a Lambda function and you can change it later.
     */
    readonly memoryLimitInMB: string;

    /**
     * AWS request ID associated with the request. This is the ID returned to the client that called
     * the invoke method.
     *
     * If AWS Lambda retries the invocation (for example, in a situation where the Lambda function
     * that is processing Kinesis records throws an exception), the request ID remains the same.
     */
    readonly awsRequestId: string;

    /**
     * The name of the CloudWatch log group where you can find logs written by your Lambda function.
     */
    readonly logGroupName: string;

    /**
     * The name of the CloudWatch log group where you can find logs written by your Lambda function.
     * The log stream may or may not change for each invocation of the Lambda function.
     *
     * The value is null if your Lambda function is unable to create a log stream, which can happen
     * if the execution role that grants necessary permissions to the Lambda function does not
     * include permissions for the CloudWatch actions.
     */
    readonly logStreamName: string;

    /**
     * Information about the Amazon Cognito identity provider when invoked through the AWS Mobile
     * SDK. It can be null.
     */
    readonly identity: any;

    /**
     * Information about the client application and device when invoked through the AWS Mobile SDK.
     * It can be null.
     */
    readonly clientContext: any;

    /**
     * Returns the approximate remaining execution time (before timeout occurs) of the Lambda
     * function that is currently executing. The timeout is one of the Lambda function
     * configuration. When the timeout reaches, AWS Lambda terminates your Lambda function.
     *
     * You can use this method to check the remaining time during your function execution and take
     * appropriate corrective action at run time.
     */
    getRemainingTimeInMillis(): string;
}

/**
 * Callback is the signature for an AWS Lambda function entrypoint.
 *
 * [event] is the data passed in by specific services calling the Lambda (like s3, or kinesis).  The
 * shape of it will be specific to individual services.
 *
 * [context] AWS Lambda uses this parameter to provide details of your Lambda function's execution.
 * For more information, see
 * https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-context.html
 *
 * [callback] See https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html#nodejs-prog-model-handler-callback
 * for details.
 *
 * This function can be synchronous or asynchronous function, though async is only supported with an
 * AWS Lambda runtime of 8.10 or higher.  On those runtimes a Promise can be returned, 'callback'
 * parameter can be ignored, and AWS will appropriately handle things. For AWS lambda pre-8.10, a
 * synchronous function must be provided.  The synchronous function should return nothing, and
 * should instead invoke 'callback' when complete.
 */
export type Callback<E, R> = (event: E, context: Context, callback: (error?: any, result?: R) => void) => Promise<R> | void;

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
     * If neither [role] nor [policies] is provided, a default policy of [iam.AWSLambdaFullAccess]
     * will be used instead.
     */
    policies?: arn.ARN[];

    /**
     * The Lambda runtime to use.  If not provided, will default to [NodeJS8d10Runtime]
     */
    runtime?: runtime.Runtime;

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
 * AWS resource an an AWS lambda that will be triggered when something happens to that resource.
 */
export class EventSubscription extends pulumi.ComponentResource {
    public permission: permission.Permission;
    public func: LambdaFunction;

    public constructor(
        type: string, name: string, opts?: pulumi.ComponentResourceOptions) {

        super(type, name, {}, opts);
    }
}

/* @internal */ export function createFunctionFromEventHandler<E, R>(
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
 * https://github.com/pulumi/docs/blob/master/reference/serializing-functions.md for additional
 * details on this process.
 */
export class CallbackFunction<E, R> extends LambdaFunction {
    public constructor(name: string, args: CallbackFunctionArgs<E, R>, opts?: pulumi.CustomResourceOptions) {
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
                // Provides wide access to "serverless" services (Dynamo, S3, etc.)
                args.policies = [iam.AWSLambdaFullAccess];
            }

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

        // Now compile the function text into an asset we can use to create the lambda. Note: to
        // prevent a circularity/deadlock, we list this Function object as something that the
        // serialized closure cannot reference.
        const handlerName = "handler";
        const serializedFileNameNoExtension = "__index";

        const closure = pulumi.runtime.serializeFunction(func, {
            serialize: _ => true,
            exportName: handlerName,
            isFactoryFunction: !!args.callbackFactory,
        });

        const codePaths = computeCodePaths(
            closure, serializedFileNameNoExtension, args.codePathOptions);

        // Copy over all option values into the function args.  Then overwrite anything we care
        // about with our own values.  This ensures that clients can pass future supported
        // lambda options without us having to know about it.
        const functionArgs = {
            ...args,
            code: new pulumi.asset.AssetArchive(codePaths),
            handler: serializedFileNameNoExtension + "." + handlerName,
            runtime: args.runtime || runtime.NodeJS8d10Runtime,
            role: role.arn,
            timeout: args.timeout === undefined ? 180 : args.timeout,
        };

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
        // Actual Role instance value for this Function.  Will only be set if this function
        // was created from [createFunction]
        roleInstance?: iam.Role;
    }
}
