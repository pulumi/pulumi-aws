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
import * as crypto from "crypto";

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