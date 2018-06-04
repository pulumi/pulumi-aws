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

import * as crypto from "crypto";
import * as filepath from "path";
import * as fs from "fs";
import * as pulumi from "@pulumi/pulumi";
import { Role, RolePolicyAttachment } from "../iam";
import * as lambda from "../lambda";
import { ARN } from "../arn";
import * as readPackageTree from 'read-package-tree';

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

/**
 * FunctionOptions provides configuration options for the serverless Function.
 */
export interface FunctionOptions {
    /**
     * A list of IAM policy ARNs to attach to the Function.  Must provide either [policies] or [role].
     */
    policies?: ARN[];
    /**
     * A pre-created role to use for the Function.  Must provide either [policies] or [role].
     */
    role?: Role;
    /**
     * A timout, in seconds, to apply to the Function.
     */
    timeout?: number;
    /**
     * The memory size limit to use for execution of the Function.
     */
    memorySize?: number;
    /**
     * The Lambda runtime to use.
     */
    runtime?: lambda.Runtime;
    /**
     * A dead letter target ARN to send function invocation failures to.
     */
    deadLetterConfig?: { targetArn: pulumi.Input<string>; };
    /**
     * Configuration for a VPC to run the Function within.
     */
    vpcConfig?: {
        securityGroupIds: pulumi.Input<string[]>,
        subnetIds: pulumi.Input<string[]>,
    };
    /**
     * The paths relative to the program folder to include in the Lambda upload.  Default is `[]`.
     */
    includePaths?: string[];
    /**
     * The packages relative to the program folder to include in the Lambda upload.  The version of the package
     * installed in the program folder and it's dependencies will all be included. Default is `[]`.
     */
    includePackages?: string[];
}

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources implemented
 * by a Lumi lambda expression and with a set of attached policies.
 */
export class Function extends pulumi.ComponentResource {
    public readonly options: FunctionOptions;
    public readonly lambda: lambda.Function;
    public readonly role: Role;

    constructor(name: string,
                options: FunctionOptions,
                func: Handler,
                opts?: pulumi.ResourceOptions,
                serialize?: (obj: any) => boolean) {
        if (!name) {
            throw new Error("Missing required resource name");
        }
        if (!func) {
            throw new Error("Missing required function callback");
        }

        super("aws:serverless:Function", name, { options: options }, opts);

        if (options.role) {
            this.role = options.role;
        } else if (options.policies) {
            // Attach a role and then, if there are policies, attach those too.
            this.role = new Role(name, {
                assumeRolePolicy: JSON.stringify(lambdaRolePolicy),
            }, { parent: this });

            for (let policy of options.policies) {
                // RolePolicyAttachment objects don't have a phyiscal identity, and create/deletes are processed
                // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
                // structural identity by using a name that includes the role name and policyArn.
                let attachment = new RolePolicyAttachment(`${name}-${sha1hash(policy)}`, {
                    role: this.role,
                    policyArn: policy,
                }, { parent: this });
            }
        } else {
            throw new Error("One of 'role' or 'policies' must be specified.");
        }

        // Now compile the function text into an asset we can use to create the lambda. Note: to
        // prevent a circularity/deadlock, we list this Function object as something that the
        // serialized closure cannot reference.
        serialize = serialize || (_ => true);
        const finalSerialize = (o: any) => {
            return serialize(o) && o !== this;
        }

        const handlerName = "handler";
        const serializedFileName = "__index";

        let closure = pulumi.runtime.serializeFunction(func, {
            serialize: finalSerialize,
            exportName: handlerName,
        });

        let codePaths = computeCodePaths(closure, serializedFileName, options.includePaths, options.includePackages);
        
        // Create the Lambda Function.
        this.lambda = new lambda.Function(name, {
            code: new pulumi.asset.AssetArchive(codePaths),
            handler: serializedFileName + "." + handlerName,
            runtime: options.runtime || lambda.NodeJS8d10Runtime,
            role: this.role.arn,
            timeout: options.timeout === undefined ? 180 : options.timeout,
            memorySize: options.memorySize,
            deadLetterConfig: options.deadLetterConfig,
            vpcConfig: options.vpcConfig,
        }, { parent: this });
    }
}

// computeCodePaths calculates an AssetMap of files to include in the Lambda package.
async function computeCodePaths(
        closure: Promise<pulumi.runtime.SerializedFunction>, 
        serializedFileName: string,
        extraIncludePaths?: string[], 
        extraPackages?: string[]): Promise<pulumi.asset.AssetMap> {

    const serializedFunction = await closure;

    // Construct the set of paths to include in the archive for upload.
    let codePaths: pulumi.asset.AssetMap = {
        // Always include the serialized function.
        [serializedFileName]: new pulumi.asset.StringAsset(serializedFunction.text),
    };

    // Compute the set of required packages
    const packages = removeBuiltins(serializedFunction.requiredPackages);
    
    // AWS Lambda always provides `aws-sdk`, so skip this.  Do this before processing user-provided extraPackages so
    // that users can force aws-sdk to be incldued (if they need a specific version).
    packages.delete("aws-sdk")
    
    // Add user-defined extraPackages
    for (const p of (extraPackages || [])) {
        packages.add(p);
    }

    // Find folders for all packages requested by the user
    const pathSet = await allFoldersForPackages(".", [...packages]);
    
    // Add all paths explciitly requested by the user
    for (const path of (extraIncludePaths || [])) {
        pathSet.add(path);
    }

    // For each of the required paths, add the corresponding FileArchive or FileAsset to the AssetMap.
    for (const path of pathSet.values()) {
        // The Asset model does not support a consistent way to embed a file-or-directory into an `AssetArchive`, so
        // we stat the path to figure out which it is and use the appropriate Asset constructor.
        const stats = fs.lstatSync(path);
        if (stats.isDirectory()) {
            codePaths[path] = new pulumi.asset.FileArchive(path);
        } else {
            codePaths[path] = new pulumi.asset.FileAsset(path);
        }
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

// Package is a node in the package tree returned by readPackageTree.
interface Package {
    name: string;
    path: string;
    package: {
        dependencies: { [key: string]: string;};
    };
    parent?: Package
    children: Package[];
}

// allFolders computes the set of package folders that are transitively required by the given list of package
// dependencies rooted in a package at the provided path.
function allFoldersForPackages(path: string, packages: string[]): Promise<Set<string>> {
    console.log(`allFoldersForPackages: ${path} ${packages}`)
    return new Promise((resolve, reject) => {
        readPackageTree(path, undefined, (err: any, root: Package) => {
            if (err) {
                return reject(err);
            }
            const s = new Set<string>();
            for (var pkg of packages) {
                if (pkg[0] == '.') {
                    // Relative path, we can include the file itself, but we cannot deterministically find the
                    // transitive dependencies, so the user may need to explicitly include those.  We use
                    // `require.resolve` to get the resolved path to the file/folder in case a reference like `./foo` is
                    // used to refer to `./foo.js`.
                    try {
                        const resolvedPath = require.resolve(pkg, { paths: [path] });
                        const relativePath = filepath.relative(path, resolvedPath);
                        s.add(relativePath);
                    } catch (err) {
                        console.warn(`Could not find module for relative path '${pkg}' in '${root.path}'.`)    
                    }
                } else if (pkg[0] == '/') {
                    // Absolute path, this won't work, so warn and move on.
                    console.warn(`Could not include module for absolute path '${pkg}' in '${root.path}'.`)
                } else {
                    // Neither relative nor aboslute path, so expected to be a name that resovles to `node_modules` (or
                    // to a builtin, but those were removed).  We can add the package and all its transitive
                    // dependencies.
                    addPackageAndDependenciesToSet(s, root, pkg);
                }
            }
            console.log(`allFoldersForPackages return: ${[...s]}`)
            resolve(s);
        });
    });
}

// addPackageAndDependenciesToSet adds all required dependencies for the requested pkg name from the given root package
// into the set.  It will recurse into all dependencies of the package.
function addPackageAndDependenciesToSet(s: Set<string>, root: Package, pkg: string) {
    console.log(`addPackageAndDependenciesToSet: ${[...s]} ${root} ${pkg}`)
    var child = findDependency(root, pkg);
    if (!child) {
        console.warn(`Could not include required dependency '${pkg}' in '${root.path}'.`)
        return;
    }
    s.add(child.path);
    if (child.package.dependencies) {
        for (let dep of Object.keys(child.package.dependencies) ) {
            addPackageAndDependenciesToSet(s, child, dep);
        }
    }
}

// findDependency searches the package tree starting at a root node (possibly a child) for a match for the given name.
// It is assumed that the tree was correctly construted such that dependencies are resolved to compatible versions in
// the closest available match starting at the provided root and walking up to the head of the tree.
function findDependency(root: Package, name: string) {
    console.log(`findDependency: ${root} ${name}`)
    for(;root;root = root.parent) {
        for (var child of root.children) {
            if(child.name == name) {
                console.log(`findDependency return: ${child}`)
                return child;
            }
        }
    }
}

// removeBuiltins removes any builtin packages from the set of package names, as these will be available at runtime
// ambiently. Currently this is computed based on the known built-in packages in the deployment context, which may be
// slightly different than that target environment, but due to Node versioning requirements, this should be
// conservative.
function removeBuiltins(packages: Set<string>): Set<string> {
    console.log(`removeBuiltins: ${[...packages]}`)
    const ret = new Set<string>();
    const builtIns = new Set(require("module").builtinModules);
    for(const p of packages) {
        if (!builtIns.has(p)) {
            ret.add(p);
        }
    }
    console.log(`removeBuiltins return: ${[...ret]}`)
    return ret;
}
