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
import { Role } from "../iam";
import * as lambda from "../lambda";
import * as utils from "../utils";

/**
 * @deprecated Use [aws.lambda.Context] instead.
 */
export type Context = lambda.Context;

/**
 * [Handler] is the signature for a serverless function that will be invoked each time the AWS
 * Lambda is invoked.
 *
 * @deprecated Use [aws.lambda.Callback] instead.
 */
export type Handler = lambda.Callback<any, any>;

/**
 * HandlerFactory is the signature for a function that will be called once to produce the serverless
 * function that AWS Lambda will invoke.  It can be used to initialize expensive state once that can
 * then be used across all invocations of the Lambda (as long as the Lambda is using the same warm
 * node instance).
 *
 * @deprecated Use [aws.lambda.CallbackFactory] instead.
 */
export type HandlerFactory = () => Handler;

/**
 * FunctionOptions provides configuration options for the serverless Function.  It is effectively
 * equivalent to [aws.lambda.FunctionArgs] except with a few important differences documented at the
 * property level.  For example, [role] is an actual iam.Role instance, and not an ARN. Properties
 * like [runtime] are now optional.  And some properties (like [code]) are entirely disallowed.
 *
 * @deprecated Use [aws.lambda.FunctionOptions] instead.
 */
export type FunctionOptions = utils.Overwrite<lambda.CallbackFunctionArgs<any, any>, {
    /**
     * @deprecated use [callback] instead.
     */
    func?: Handler;

    /**
     * @deprecated use [callbackFactory] instead.
     */
    factoryFunc?: HandlerFactory;

    /**
     * The paths relative to the program folder to include in the Lambda upload.  Default is `[]`.
     *
     * @deprecated Use [codePathOptions] instead.
     */
    includePaths?: string[];

    /**
     * The packages relative to the program folder to include in the Lambda upload.  The version of
     * the package installed in the program folder and it's dependencies will all be included.
     * Default is `[]`.
     *
     * @deprecated Use [codePathOptions] instead.
     */
    includePackages?: string[];

    /**
     * The packages relative to the program folder to not include the Lambda upload. This can be
     * used to override the default serialization logic that includes all packages referenced by
     * project.json (except @pulumi packages).  Default is `[]`.
     *
     * @deprecated Use [codePathOptions] instead.
     */
    excludePackages?: string[];
}>;

/**
 * Function is a higher-level API for creating and managing AWS Lambda Function resources
 * implemented by a Pulumi lambda expression and with a set of attached policies.
 *
 * @deprecated Use [lambda.CallbackFunction] instead.
 */
export class Function extends pulumi.ComponentResource {
    public readonly options: FunctionOptions;
    public readonly lambda: lambda.Function;
    public readonly role: Role;

    /**
     * @param func Deprecated.  Pass the function as [options.func] or [options.factoryFunc] instead.
     */
    constructor(name: string,
                options: FunctionOptions,
                func?: Handler,
                opts?: pulumi.ResourceOptions) {

        super("aws:serverless:Function", name, {}, opts);

        opts = opts || { parent: this };

        // Migrate old aws-serverless.FunctionOptions forward to lambda.FunctionOptions.
        options.callback = options.callback || options.func || func;
        options.callbackFactory = options.callbackFactory || options.factoryFunc;

        if (!options.codePathOptions) {
            options.codePathOptions = {
                extraIncludePaths: options.includePaths,
                extraIncludePackages: options.includePackages,
                extraExcludePackages: options.excludePackages,
            };
        }

        this.lambda = new lambda.CallbackFunction(name, options, { parent: this });
        this.role = this.lambda.roleInstance;
    }
}
