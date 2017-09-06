// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as crypto from "crypto";
import * as fabric from "@pulumi/pulumi-fabric";
import { Role, RolePolicyAttachment } from "../iam";
import * as lambda from "../lambda";
import { ARN } from "../arn";

// Context is the shape of the context object passed to a Function callback.
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

// Handler is the signature for a serverless function.
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

// FuncsForClosure collects all the function defintions needed to
// support serialization of a given Closure object.  Note that
// a Closure object can reference other Closure objects and
// can also have cycles, so we recursively walk the graph and
// cache serialized nodes along the way to avoid cycles.
class FuncsForClosure {
    public funcs: { [hash: string]: FuncEnv };
    public root: string;

    constructor(closure: fabric.runtime.Closure) {
        this.funcs = {};
        this.root = this.createFuncForClosure(closure);
    }

    private createFuncForClosure(closure: fabric.runtime.Closure): string {
        let shasum: crypto.Hash = crypto.createHash("sha1");
        shasum.update(closure.code);
        let hash: string = "__" + shasum.digest("hex");
        if (this.funcs[hash] === undefined) {
            this.funcs[hash] = {
                code: closure.code,
                env: {}, // initialize as empty - update after recursive call
            };
            this.funcs[hash].env = this.envFromEnvObj(closure.environment);
        }
        return hash;
    }

    private envFromEnvObj(env: fabric.runtime.EnvObj): {[key: string]: string} {
        let envObj: {[key: string]: string} = {};
        let keys = Object.keys(env);
        for (let i = 0; i < keys.length; i++) {
            let key = keys[i];
            let envEntry = env[key];
            let val = this.envEntryToString(envEntry);
            if (val !== undefined) {
                envObj[key] = val;
            }
        }
        return envObj;
    }

    private envFromEnvArr(arr: fabric.runtime.EnvEntry[]): (string | undefined)[] {
        let envArr: (string | undefined)[] = [];
        for (let i = 0; i < (<any>arr).length; i++) {
            envArr[i] = this.envEntryToString(arr[i]);
        }
        return envArr;
    }

    private envEntryToString(envEntry: fabric.runtime.EnvEntry): string | undefined {
        if (envEntry.json !== undefined) {
            return JSON.stringify(envEntry.json);
        } else if (envEntry.closure !== undefined) {
            let innerHash = this.createFuncForClosure(envEntry.closure);
            return innerHash;
        } else if (envEntry.obj !== undefined) {
            return envObjToString(this.envFromEnvObj(envEntry.obj));
        } else if (envEntry.arr !== undefined) {
            return envArrToString(this.envFromEnvArr(envEntry.arr));
        } else {
            // TODO[pulumi/pulumi-fabric#239]: For now we will skip serialziing when the captured JSON object is
            // null/undefined. This is not technically correct, as it will cause references to these to
            // fail instead of return undefined.
            return undefined;
        }
    }
}

// Converts an environment object into a string which can be embedded into a serialized
// function body.  Note that this is not JSON serialization, as we may have proeprty
// values which are variable references to other global functions.  In other words,
// there can be free variables in the resulting object literal.
function envObjToString(envObj: { [key: string]: string; }): string {
    let ret = "{";
    let isStart = true;
    let keys = Object.keys(envObj);
    for (let i = 0; i < keys.length; i++) {
        let key = keys[i];
        let val = envObj[key];
        // Lumi generates the special name `.this` for references to `this`.
        // We will rewrite to the name `_this` and then pass that as the
        // receiver to `.apply` later on.
        if (key === ".this") {
            key = "_this";
        }
        if (isStart) {
            ret += " ";
        } else {
            ret += ", ";
        }
        isStart = false;
        ret += key + ": " + val;
    }
    ret += " }";
    return ret;
}

function envArrToString(envArr: (string | undefined)[]): string {
    let ret = "[";
    let isStart = true;
    for (let i = 0; i < (<any>envArr).length; i++) {
        let val = envArr[i];
        if (isStart) {
            ret += " ";
        } else {
            ret += ", ";
        }
        isStart = false;
        ret += val;
    }
    ret += "]";
    return ret;
}

function createJavaScriptLambda(
    functionName: string,
    role: Role,
    closure: fabric.runtime.Closure,
    opts: FunctionOptions): lambda.Function {

    let funcsForClosure = new FuncsForClosure(closure);
    let funcs = funcsForClosure.funcs;
    let str = "exports.handler = " + funcsForClosure.root + ";\n\n";
    let fkeys = Object.keys(funcs);
    for (let i = 0; i < fkeys.length; i++) {
        let name = fkeys[i];
        str +=
            "function " + name + "() {\n" +
            "  var _this;\n" +
            "  with(" + envObjToString(funcs[name].env) + ") {\n" +
            "    return (function() {\n\n" +
            funcs[name].code + "\n" +
            "    }).apply(_this).apply(undefined, arguments);\n" +
            "  }\n" +
            "}\n" +
            "\n";
    }

    let timeout = 180;
    if (opts.timeout !== undefined) {
        timeout = opts.timeout;
    }

    let deadLetterConfig: { targetArn: fabric.MaybeComputed<string>; }[] | undefined;
    if (opts.deadLetterConfig !== undefined) {
        deadLetterConfig = [ opts.deadLetterConfig ];
    }

    return new lambda.Function(functionName, {
        code: new fabric.asset.AssetArchive({
            "node_modules": new fabric.asset.FileAsset("node_modules"),
            "index.js": new fabric.asset.StringAsset(str),
        }),
        handler: "index.handler",
        runtime: lambda.NodeJS6d10Runtime,
        role: role.arn,
        timeout: timeout,
        memorySize: opts.memorySize,
        deadLetterConfig: deadLetterConfig,
    });
}

export interface FunctionOptions {
    policies: ARN[];
    timeout?: number;
    memorySize?: number;
    deadLetterConfig?: { targetArn: fabric.MaybeComputed<string>; };
}

// Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
// by a Lumi lambda expression and with a set of attached policies.
export class Function {
    public readonly lambda: lambda.Function;
    public readonly role: Role;
    public readonly policies: RolePolicyAttachment[];

    constructor(name: string, options: FunctionOptions, func: Handler) {
        if (name === undefined) {
            throw new Error("Missing required resource name");
        }
        if (func === undefined) {
            throw new Error("Missing required function callback");
        }
        let closure = fabric.runtime.serializeClosure(func);
        if (closure === undefined) {
            throw new Error("Failed to serialize function.");
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

        switch (closure.runtime) {
            case "nodejs":
                this.lambda = createJavaScriptLambda(name, this.role, closure, options);
                break;
            default:
                throw new Error(`Runtime '${closure.runtime}' not yet supported (currently only 'nodejs')`);
        }
    }
}

