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
import * as func from "./function";
import * as iam from "../iam";
import * as serverless from "../serverless";
import * as runtime from "./runtimes";
import * as utils from "../utils";

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
 * EntryPoint is the signature for a serverless function that will be invoked each time the AWS
 * Lambda is invoked.
 *
 * It can be a synchronous or asynchronous function that can be converted into an AWS lambda.  Async
 * callbacks are only supported with an AWS lambda runtime of 8.10 or higher.  On those runtimes a
 * Promise can be returned, 'callback' parameter can be ignored, and AWS will appropriately handle
 * things. For AWS lambda pre-8.10, a synchronous function must be provided.  The synchronous
 * function should return nothing, and should instead invoke 'callback' when complete.
 */
export type EntryPoint<E, R> = (event: E, context: Context, callback: (error: any, result: R) => void) => Promise<R> | void;

/**
 * EntryPointFactory is the signature for a function that will be called once to produce the
 * serverless function that AWS Lambda will invoke.  It can be used to initialize expensive state
 * once that can then be used across all invocations of the Lambda (as long as the Lambda is using
 * the same warm node instance).
 */
export type EntryPointFactory<E, R> = () => EntryPoint<E, R>;

/**
 * FunctionOptions provides configuration options for the serverless Function.  It is effectively
 * equivalent to [aws.lambda.FunctionArgs] except with a few important differences documented at the
 * property level.  For example, [role] is an actual iam.Role instance, and not an ARN. Properties
 * like [runtime] are now optional.  And some properties (like [code]) are entirely disallowed.
 */
export type FunctionOptions<E, R> = utils.Overwrite<func.FunctionArgs, {
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
     * The Javascript function instance to use as the entrypoint for the AWS Lambda out of.  Either
     * [func] or [factoryFunc] must be provided.
     */
    func?: EntryPoint<E, R>;

    /**
     * The Javascript function instance that will be called to produce the function that is the
     * entrypoint for the AWS Lambda. Either [func] or [factoryFunc] must be provided.
     *
     * This form is useful when there is expensive initialization work that should only be executed
     * once.  The factory-function will be invoked once when the final AWS Lambda module is loaded.
     * It can run whatever code it needs, and will end by returning the actual function that Lambda
     * will call into each time the Lambda is invoked.
     */
    factoryFunc?: EntryPointFactory<E, R>;

    /**
     * A list of IAM policy ARNs to attach to the Function.  Must provide either [policies] or
     * [role].
     */
    policies?: arn.ARN[];

    /**
     * A pre-created role to use for the Function.  Must provide either [policies] or [role].
     */
    role?: iam.Role;

    /**
     * The Lambda runtime to use.  If not provided, will default to [NodeJS8d10Runtime]
     */
    runtime?: runtime.Runtime;

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
}>;

const defaultComputePolicies = [
    iam.AWSLambdaFullAccess,                 // Provides wide access to "serverless" services (Dynamo, S3, etc.)
];

/**
 * Creates an AWS Lambda from a provided Handler.  If the Handler is already an AWS Lambda, this
 * does nothing and simply returns that instance.  Otherwise, if it is a JavaScript Function
 * instance, this will serialize that Function instance into a usable packaged form that is then
 * exposed through an AWS Lambda.
 *
 * If no [policies] are included in [functionOptions] a default policy of
 * [aws.iam.AWSLambdaFullAccess] will be used.
 */
export function createLambdaFunction<E, R>(
    name: string, functionOptions: FunctionOptions<E, R>, opts?: pulumi.ResourceOptions): func.Function {

    if (!functionOptions.policies) {
        functionOptions.policies = defaultComputePolicies.slice();
    }

    const serverlessFunction = new serverless.Function(
        name, functionOptions, /*handler*/ undefined, opts);

    return serverlessFunction.lambda;
}
