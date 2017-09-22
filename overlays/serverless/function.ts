// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as crypto from "crypto";
import * as fabric from "@pulumi/pulumi-fabric";
import { Role, RolePolicyAttachment } from "../iam";
import * as lambda from "../lambda";
import { ARN } from "../arn";

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
 * Handler is the signature for a serverless function.
 */
export type Handler = (event: any, context: Context, callback: (error: any, result: any) => void) => any;

let policy = {
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

interface FuncEnv {
    code: string;
    env: { [key: string]: string; };
}

/**
 * FuncsForClosure collects all the function defintions needed to support serialization of a given Closure object.
 * Context is the shape of the context object passed to a Function callback.
 * Note that a Closure object can reference other Closure objects and can also have cycles, so we recursively walk the
 * graph and cache serialized nodes along the way to avoid cycles.
 */ 
class FuncsForClosure {
    public funcs: { [hash: string]: FuncEnv }; // a cache of functions.
    public root: string;                       // the root closure hash.

    constructor(closure: fabric.runtime.Closure) {
        this.funcs = {};
        this.root = this.createFuncForClosure(closure);
    }

    private createFuncForClosure(closure: fabric.runtime.Closure): string {
        // Produce a hash to identify the function.
        let shasum: crypto.Hash = crypto.createHash("sha1");
        shasum.update(closure.code);
        let hash: string = "__" + shasum.digest("hex");

        // Now only store if this function hasn't already been hashed.
        if (this.funcs[hash] === undefined) {
            this.funcs[hash] = {
                code: closure.code,
                env: {}, // initialize as empty - update after recursive call
            };
            this.funcs[hash].env = this.envFromEnvObj(closure.environment);
        }

        return hash;
    }

    private envFromEnvObj(env: fabric.runtime.Environment): {[key: string]: string} {
        let envObj: {[key: string]: string} = {};
        for (let key of Object.keys(env)) {
            let val = this.envEntryToString(env[key]);
            if (val !== undefined) {
                envObj[key] = val;
            }
        }
        return envObj;
    }

    private envFromEnvArr(arr: fabric.runtime.EnvironmentEntry[]): (string | undefined)[] {
        let envArr: (string | undefined)[] = [];
        for (let i = 0; i < arr.length; i++) {
            envArr[i] = this.envEntryToString(arr[i]);
        }
        return envArr;
    }

    private envEntryToString(envEntry: fabric.runtime.EnvironmentEntry): string | undefined {
        if (envEntry.json !== undefined) {
            return JSON.stringify(envEntry.json);
        }
        else if (envEntry.closure !== undefined) {
            let innerHash = this.createFuncForClosure(envEntry.closure);
            return innerHash;
        }
        else if (envEntry.obj !== undefined) {
            return envObjToString(this.envFromEnvObj(envEntry.obj));
        }
        else if (envEntry.arr !== undefined) {
            return envArrToString(this.envFromEnvArr(envEntry.arr));
        }
        else {
            return undefined;
        }
    }
}

/**
 * Converts an environment object into a string which can be embedded into a serialized function body.  Note that this
 * is not JSON serialization, as we may have proeprty values which are variable references to other global functions.
 * In other words, there can be free variables in the resulting object literal.
 *
 * @param envObj The environment object to convert to a string.
 */
function envObjToString(envObj: { [key: string]: string; }): string {
    let result = "";
    let first = true;
    for (let key of Object.keys(envObj)) {
        let val = envObj[key];

        // Rewrite references to `this` to the special name `_this`.  This will get rewritten to use `.apply` later.
        if (key === "this") {
            key = "_this";
        }

        if (!first) {
            result += ", ";
        }

        result += key + ": " + val;
        first = false;
    }
    return "{ " + result + " }";
}

function envArrToString(envArr: (string | undefined)[]): string {
    let result = "";
    let first = true;
    for (let i = 0; i < envArr.length; i++) {
        if (!first) {
            result += ", ";
        }
        result += envArr[i];
        first = false;
    }
    return "[ " + result + " ]";
}

function serializeClosureText(closure: Promise<fabric.runtime.Closure>): fabric.asset.StringAsset {
    return new fabric.asset.StringAsset(closure.then((c: fabric.runtime.Closure) => {
        // Ensure the closure is targeting a supported runtime.
        if (c.runtime !== "nodejs") {
            throw new Error(`Runtime '${c.runtime}' not yet supported (currently only 'nodejs')`);
        }

        // Now produce a textual representation of the closure and its serialized captured environment.
        let funcsForClosure = new FuncsForClosure(c);
        let funcs = funcsForClosure.funcs;
        let text = "exports.handler = " + funcsForClosure.root + ";\n\n";
        for (let name of Object.keys(funcs)) {
            text +=
                "function " + name + "() {\n" +
                "  var _this;\n" +
                "  with(" + envObjToString(funcs[name].env) + ") {\n" +
                "    return (function() {\n\n" +
                "return " + funcs[name].code + "\n" +
                "    }).apply(_this).apply(undefined, arguments);\n" +
                "  }\n" +
                "}\n" +
                "\n";
        }
        return text;
    }));
}

function createJavaScriptLambda(
    functionName: string, role: Role,
    closure: Promise<fabric.runtime.Closure>, opts: FunctionOptions): lambda.Function {
    return new lambda.Function(functionName, {
        code: new fabric.asset.AssetArchive({
            "node_modules": new fabric.asset.FileAsset("node_modules"),
            "index.js": serializeClosureText(closure),
        }),
        handler: "index.handler",
        runtime: lambda.NodeJS6d10Runtime,
        role: role.arn,
        timeout: opts.timeout === undefined ? 180 : opts.timeout,
        memorySize: opts.memorySize,
        deadLetterConfig: opts.deadLetterConfig === undefined ? undefined : [ opts.deadLetterConfig ],
    });
}

export interface FunctionOptions {
    policies: ARN[];
    timeout?: number;
    memorySize?: number;
    deadLetterConfig?: { targetArn: fabric.Computed<string>; };
}

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
 * by a Lumi lambda expression and with a set of attached policies.
 */
export class Function {
    public readonly lambda: lambda.Function;
    public readonly role: Role;
    public readonly policies: RolePolicyAttachment[];

    constructor(name: string, options: FunctionOptions, func: Handler) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!func) {
            throw new Error("Missing required function callback");
        }
        let closure: Promise<fabric.runtime.Closure> = fabric.runtime.serializeClosure(func);
        if (!closure) {
            throw new Error("Failed to serialize function closure");
        }

        // Attach a role and then, if there are policies, attach those too.
        this.role = new Role(name + "-iamrole", {
            assumeRolePolicy: JSON.stringify(policy),
        });
        this.policies = [];
        for (let i = 0; i < options.policies.length; i++) {
            this.policies.push(new RolePolicyAttachment(name + "-iampolicy-" + i, {
                role: this.role,
                policyArn: options.policies[i],
            }));
        }

        // Now compile the function text into an asset we can use to create the lambda.
        this.lambda = createJavaScriptLambda(name, this.role, closure, options);
    }
}

