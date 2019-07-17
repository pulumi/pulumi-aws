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

// Directly import awsMixins.  We want to execute the code within it, but we don't want to import or
// export any values from it.  Specifically, awsMixins adds a *getter* property (called "runtime")
// to this @pulumi/aws module. If we actually *import* or *export* that property, the getter will
// execute, which is not what we want at all.  Instead, we want to really just expose that we have
// this "runtime" property on the typing, and we want to execute the code that jams the getter on.

import "./awsMixins";

import * as pulumi from "@pulumi/pulumi";
import * as crypto from "crypto";
import * as deasync from "deasync";

type Diff<T extends string | number | symbol, U extends string | number | symbol> =
  ({ [P in T]: P } & { [P in U]: never } & { [x: string]: never })[T];

// Overwrite allows you to take an existing type, and then overwrite existing properties in it
// with properties of the same name, but with entirely different types.
export type Overwrite<T, U> = Pick<T, Diff<keyof T, keyof U>> & U;

// sha1hash returns a partial SHA1 hash of the input string.
/** @internal */
export function sha1hash(s: string): string {
  const shasum: crypto.Hash = crypto.createHash("sha1");
  shasum.update(s);
  return shasum.digest("hex").substring(0, 8);
}

/** @internal */
export function ifUndefined<T>(input: pulumi.Input<T> | undefined, value: pulumi.Input<T>) {
  return pulumi.all([input, value])
               .apply(([input, value]) => input !== undefined ? input : value);
}

interface HasAliases { aliases?: pulumi.Input<pulumi.URN | pulumi.Alias>[] };

/** @internal */
export function withAlias<T extends HasAliases>(opts: T, alias: pulumi.Input<pulumi.URN | pulumi.Alias>): T {
  return withAliases(opts, [alias]);
}

/** @internal */
export function withAliases<T extends HasAliases>(opts: T, aliases: pulumi.Input<pulumi.URN | pulumi.Alias>[]): T {
    const allAliases: pulumi.Input<pulumi.URN | pulumi.Alias>[] = [];
    if (opts.aliases) {
        for (const alias of opts.aliases) {
            allAliases.push(alias);
        }
    }

    for (const alias of aliases) {
        allAliases.push(alias);
    }

    return { ...opts, aliases };
}

/**
 * Synchronously blocks until the result of this promise is computed.  If the promise is rejected,
 * this will throw the error the promise was rejected with.  If this promise does not complete this
 * will block indefinitely.
 *
 * Be very careful with this function.  Only wait on a promise if you are certain it is safe to do
 * so.
 *
 * This is an advanced compat function for libraries and should not generally be used by normal
 * Pulumi application.
 */
export function promiseResult<T>(promise: Promise<T>): T {
    enum State {
        running,
        finishedSuccessfully,
        finishedWithError,
    }

    let result: T;
    let error = undefined;
    let state = <State>State.running;

    promise.then(
        val => {
            result = val;
            state = State.finishedSuccessfully;
        },
        err => {
            error = err;
            state = State.finishedWithError;
        });

    deasync.loopWhile(() => state === State.running);
    if (state === State.finishedWithError) {
        throw error;
    }

    return result!;
}