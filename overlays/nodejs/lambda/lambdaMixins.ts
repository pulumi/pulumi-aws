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
import * as crypto from "crypto";

import * as arn from "../arn";
import * as iam from "../iam";
import * as runtime from "./runtimes";
import * as utils from "../utils";

import * as lambdaFunction from "./function";
import * as permission from "./permission";

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
export type FunctionOptions<E, R> = utils.Overwrite<lambdaFunction.FunctionArgs, {
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

    /**
     * @internal.  TODO(cyrusn): Remove if not needed by higher layers.
     */
    serialize?: (obj: any) => boolean
}>;

/**
 * Base type for all subscription types.  An event subscription represents a connection between some
 * AWS resource an an AWS lambda that will be triggered when something happens to that resource.
 */
export class EventSubscription extends pulumi.ComponentResource {
    public permission: permission.Permission;
    public func: lambdaFunction.Function;

    public constructor(
        type: string, name: string, func: lambdaFunction.Function, props: Record<string, any>, opts?: pulumi.ResourceOptions) {

        super(type, name, props, opts);

        this.func = func;
    }
}

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
    name: string, options: FunctionOptions<E, R>, opts?: pulumi.ResourceOptions): lambdaFunction.Function {

    if (!name) {
        throw new Error("Missing required resource name");
    }

    if (options.func && options.factoryFunc) {
        throw new pulumi.RunError("Cannot provide both [options.func] and [options.factoryFunc]");
    }

    const func = options.func || options.factoryFunc;
    if (!func) {
        throw new Error("Missing required function callback");
    }

    let role: iam.Role;
    if (options.role) {
        role = options.role;
    } else {
        // Attach a role and then, if there are policies, attach those too.
        role = new iam.Role(name, {
            assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
        }, opts);

        if (!options.policies) {
            // Provides wide access to "serverless" services (Dynamo, S3, etc.)
            options.policies = [iam.AWSLambdaFullAccess];
        }

        for (let policy of options.policies) {
            // RolePolicyAttachment objects don't have a physical identity, and create/deletes are processed
            // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
            // structural identity by using a name that includes the role name and policyArn.
            let attachment = new iam.RolePolicyAttachment(`${name}-${sha1hash(policy)}`, {
                role: role,
                policyArn: policy,
            }, opts);
        }
    }

    // Now compile the function text into an asset we can use to create the lambda. Note: to
    // prevent a circularity/deadlock, we list this Function object as something that the
    // serialized closure cannot reference.
    let lambda: lambdaFunction.Function;
    let serialize = options.serialize || (_ => true);
    const finalSerialize = (o: any) => {
        return serialize(o) && o !== lambda;
    }

    const handlerName = "handler";
    const serializedFileNameNoExtension = "__index";

    const closure = pulumi.runtime.serializeFunction(func, {
        serialize: finalSerialize,
        exportName: handlerName,
        isFactoryFunction: !!options.factoryFunc,
    });

    const codePaths = computeCodePaths(
        closure, serializedFileNameNoExtension, options.includePaths, options.excludePackages);

    // Copy over all option values into the function args.  Then overwrite anything we care
    // about with our own values.  This ensures that clients can pass future supported
    // lambda options without us having to know about it.
    const copy = {
        ...options,
        code: new pulumi.asset.AssetArchive(codePaths),
        handler: serializedFileNameNoExtension + "." + handlerName,
        runtime: options.runtime || runtime.NodeJS8d10Runtime,
        role: role.arn,
        timeout: options.timeout === undefined ? 180 : options.timeout,
    };

    // Create the Lambda Function.
    lambda = new lambdaFunction.Function(name, copy, opts);
    lambda.roleInstance = role;
    return lambda;
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

// Mixin the Role we potentially create into the Function instances we return.

declare module "./function" {
    interface Function {
        // Actual Role instance value for this Function.  Will only be set if this function
        // was created from [createLambdaFunction]
        roleInstance?: iam.Role;
    }
}
