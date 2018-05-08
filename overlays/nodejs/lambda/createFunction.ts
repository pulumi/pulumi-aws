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
export type Handler<E,R> = (event: E, context: Context, callback: (error: any, result: R) => void) => any;

/**
 * CallbackFunctionArgs specify the properties that can be passed in to configure the AWS Lambda
 * created for the provide 'handler' in 'createFunction'.
 */
export type CallbackFunctionArgs = utils.Omit<lambda.FunctionArgs, "code" | "handler">

/**
 * createFunction enables creation of an AWS Lambda out of an actual javascript callback handler.
 * The callback will be appropriately serialized into a form that the AWS Lambda infrastructure
 * can call into.
 */
export function createFunction<E,R>(
    name: string, handler: Handler<E,R>, args: CallbackFunctionArgs,
    serialize?: (obj: any) => boolean, opts?: pulumi.ResourceOptions): lambda.Function<E,R> {

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