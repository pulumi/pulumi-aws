// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as fs from "fs";
import * as lambda from "./function";
import * as runtimes from "./runtimes";
import * as utils from "../utils";
import * as iam from "../iam";
import * as shared from "../shared";

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
 * Shape of callbacks used for synchronous AWS lambda functions.  If a Node 6.x runtime is chosen
 * for the AWS lambda, these are the only callback shapes allowed.
 */
export type SyncCallback<E,R> = (event: E, context: Context, callback: (error: any, result: R) => void) => void;

/**
 * Shape of callbacks used for asynchronous AWS lambda functions.  These are supported on AWS lambda
 * if a node runtime of 8.10 (the default runtime) or higher is used.
 */
export type AsyncCallback<E,R> = (event: E, context?: Context) => Promise<void>;

/**
 * A synchronous or asynchronous callback.
 */
export type Callback<E,R> = SyncCallback<E,R> | AsyncCallback<E,R>;

/**
 * Handler represents the appropriate type for functions that can take either an AWS lambda function
 * instance, or a JS function object that will then be used to create the AWS lambda function.
 */
export type Handler<E,R> = lambda.Function | Callback<E,R>;

/**
 * CallbackArgs specify the properties that can be passed in to configure the AWS Lambda created for
 * the provided 'callback' in 'createFunction'.  Note: this type is nearly the same as
 * lambda.FunctionArgs, however:
 *
 * 1. 'code' and 'handler' are not allowed.  They will be created exactly from the 'callback'
 *    function passed in.
 * 2. 'role' is optional.  If 'role' is not a provided a default one will be created for this use.
 * 3. 'runtime' is optiona.  If 'runtime' is not provided. Node 8.10 will be chosen.  Because of
 *    this, 'AsyncCallbacks' are legal to pass by default without needing any special arguments.
 * 4. An optional 'includePaths' property can be provided to customize which folders are uploaded
 *    with the lambda. By default, the ./node_modules folder is included.  However, this may be
 *    very large and may include more than what is desired.
 */
export type CallbackArgs =
    // Remove 'code' and 'handler' (we'll generate those ourselves), and make 'role' and 'runtime'
    // optional).
    utils.Optional<utils.Omit<lambda.FunctionArgs, "code" | "handler">, "role" | "runtime"> &
    {
        // Also allow caller to supply the include paths to upload with the lambda
        includePaths?: string[],
        serialize?: (obj: any) => boolean,
    }

/**
 * createFunction enables creation of an AWS Lambda out of an actual javascript callback. The
 * callback will be appropriately serialized into a form that the AWS Lambda infrastructure can call
 * into.
 */
export function createFunction<E,R>(
    name: string, callback: Callback<E,R>,
    args?: CallbackArgs, opts?: pulumi.ResourceOptions): lambda.Function {

    if (!name) {
        throw new Error("Missing required 'name'");
    }
    if (!callback) {
        throw new Error("Missing required 'callback'");
    }

    args = args || {};
    if ((<any>args).code) {
        throw new Error("'code' property should not be provided in 'args'");
    }
    if ((<any>args).handler) {
        throw new Error("'handler' property should not be provided in 'args'");
    }

    // Now compile the function text into an asset we can use to create the lambda. Note: to
    // prevent a circularity/deadlock, we list this Function object as something that the
    // serialized closure cannot reference.
    const serialize = args.serialize || (_ => true);
    const finalSerialize = (o: any) => {
        return serialize(o) && o !== this;
    }

    let closure = pulumi.runtime.serializeFunctionAsync(callback, finalSerialize);
    if (!closure) {
        throw new Error("Failed to serialize function closure");
    }

    // Construct the set of paths to include in the archive for upload.
    let codePaths = {
        // Always include the serialized function.
        "__index.js": new pulumi.asset.StringAsset(closure),
    };

    const includePaths = args.includePaths || ["./node_modules/"];
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

    const argsCopy = <lambda.FunctionArgs>{
        ...args,
        code: new pulumi.asset.AssetArchive(codePaths),
        handler: "__index.handler",
        timeout: args.timeout === undefined ? 180 : args.timeout,
        runtime: args.runtime || runtimes.NodeJS8d10Runtime,
        role: args.role ? args.role : shared.getDefaultLambdaRole().arn,
    };

    return new lambda.Function(name, argsCopy, opts);
}
