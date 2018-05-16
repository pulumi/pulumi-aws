// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as crypto from "crypto";

// sha1hash returns a partial SHA1 hash of the input string.
export function sha1hash(s: string): string {
    const shasum: crypto.Hash = crypto.createHash("sha1");
    shasum.update(s);
    // TODO[pulumi/pulumi#377] Workaround for issue with long names not generating per-deplioyment randomness, leading
    //     to collisions.  For now, limit the size of hashes to ensure we generate shorter/ resource names.
    return shasum.digest("hex").substring(0, 8);
}

// From: https://github.com/Microsoft/TypeScript/issues/12215
// Helpers to create 'subtraction' types.  i.e. a type equivalent to some other object type,
// just with some members removed.

export type Diff<T extends string, U extends string> = ({[P in T]: P } & {[P in U]: never } & { [x: string]: never })[T]

/**
 * Gives you the same types as T, just with the 'K' properties removed.
 */
export type Omit<T, K extends keyof T> = Pick<T, Diff<keyof T, K>>

/**
 * Gives you the same type as T, just with the K properties made optional.
 */
export type Optional<T, K extends keyof T> =
    // Include all the members of T except the K properties
    Omit<T, K> &
    // And combine with the K properties of T that are then made optional.
    Partial<Pick<T, K>>;