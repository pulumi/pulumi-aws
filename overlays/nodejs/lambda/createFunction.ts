// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as fs from "fs";
import * as lambda from "./function";
import * as runtimes from "./runtimes";
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
 * Handler is the signature for a callback that be converted into an aws lambda entrypoint.
 */
export type Handler<E,R> = (event: E, context: Context, callback: (error: any, result: R) => void) => any;

/**
 * CallbackFunctionArgs specify the properties that can be passed in to configure the AWS Lambda
 * created for the provide 'handler' in 'createFunction'.
 */
export type CallbackFunctionArgs = utils.Omit<lambda.FunctionArgs & { includePaths?: string[] }, "code" | "handler">

/**
 * createFunction enables creation of an AWS Lambda out of an actual javascript callback handler.
 * The callback will be appropriately serialized into a form that the AWS Lambda infrastructure
 * can call into.
 */
export function createFunction<E,R>(
    name: string, handler: Handler<E,R>, args: CallbackFunctionArgs,
    serialize?: (obj: any) => boolean, opts?: pulumi.ResourceOptions): lambda.Function {

    if (!name) {
        throw new Error("Missing required 'name'");
    }
    if (!handler) {
        throw new Error("Missing required 'handler' callback");
    }
    if (!args.role) {
        throw new Error("Missing 'role' in 'args'");
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
    serialize = serialize || (_ => true);
    const finalSerialize = (o: any) => {
        return serialize(o) && o !== this;
    }

    let closure = pulumi.runtime.serializeFunctionAsync(handler, finalSerialize);
    if (!closure) {
        throw new Error("Failed to serialize function closure");
    }


    // Construct the set of paths to include in the archive for upload.
    let codePaths = {
        // Always include the serialized function.
        "__index.js": new pulumi.asset.StringAsset(closure),
    };

    // Also add each provided path to the archive - or the `node_modules` folder if no includePaths specified.
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

    const argsCopy: lambda.FunctionArgs = {
        ...args,
        code: new pulumi.asset.AssetArchive(codePaths),
        handler: "__index.handler",
    };

    return new lambda.Function(name, argsCopy, opts);
}