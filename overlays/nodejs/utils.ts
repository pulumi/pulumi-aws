// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

// From: https://github.com/Microsoft/TypeScript/issues/12215
// Helpers to create 'subtraction' types.  i.e. a type equivalent to some other object type,
// just with some members removed.

export type Diff<T extends string, U extends string> = ({[P in T]: P } & {[P in U]: never } & { [x: string]: never })[T]
export type Omit<T, K extends keyof T> = Pick<T, Diff<keyof T, K>>
