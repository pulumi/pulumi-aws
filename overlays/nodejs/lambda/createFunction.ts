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

export type SyncCallback<E,R> = (event: E, context: Context, callback: (error: any, result: R) => void) => void;
export type AsyncCallback<E,R> = (event: E, context?: Context) => Promise<void>;
export type Callback<E,R> = SyncCallback<E,R> | AsyncCallback<E,R>;

/**
 * Handler represents the appropriate type for functions that can take either an AWS lambda function
 * instance, or a JS function object that will then be used to create the AWS lambda function.
 */
export type Handler<E,R> = lambda.Function | Callback<E,R>;

/**
 * CallbackArgs specify the properties that can be passed in to configure the AWS Lambda
 * created for the provided 'Handler' in 'createFunction'.
 */
export type CallbackArgs = utils.Omit<
    // Keep all the properties from FunctionArgs (though make 'role' and 'runtime' optional).
    utils.Optional<lambda.FunctionArgs, "role" | "runtime"> & {
    // Also allow caller to supply the include paths to upload with the lambda
    includePaths?: string[],
    serialize?: (obj: any) => boolean,
    // And do not allow 'code' or 'handler' to be passed in.
}, "code" | "handler">

/**
 * createFunction enables creation of an AWS Lambda out of an actual javascript callback handler.
 * The callback will be appropriately serialized into a form that the AWS Lambda infrastructure
 * can call into.
 */
export function createFunction<E,R>(
    name: string, callback: Callback<E,R>,
    args: CallbackArgs, opts?: pulumi.ResourceOptions): lambda.Function {

    if (!name) {
        throw new Error("Missing required 'name'");
    }
    if (!callback) {
        throw new Error("Missing required 'callback'");
    }
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
