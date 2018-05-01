// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
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
export type Handler<TArg, TResult> = (event: TArg, context: Context, callback: (error: any, result: TResult) => void) => any;

// User sholud not supply 'code' or 'handler' to createFunction.  We will create those
// out of the handler they pass in.
export type CallbackFunctionArgs = utils.Omit<lambda.FunctionArgs, "code" | "handler">

/**
 * Helper to create an aws lambda function out of an actual javascript callback.
 */
export function createFunction<TArg, TResult>(
    name: string, handler: Handler<TArg, TResult>, args: CallbackFunctionArgs,
    serialize?: (obj: any) => boolean, opts?: pulumi.ResourceOptions): lambda.Function<TArg, TResult> {

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

    const argsCopy: lambda.FunctionArgs = {
        ...args,
        code: new pulumi.asset.AssetArchive({
            // TODO[pulumi/pulumi-aws#35] We may want to allow users to control what gets uploaded. Currently, we
            //     upload the entire folder as there may be dependencies on any files here.
            ".": new pulumi.asset.FileArchive("."),
            "__index.js": new pulumi.asset.StringAsset(closure),
        }),
        handler: "__index.handler",
    };

    return new lambda.Function(name, argsCopy, opts);
}