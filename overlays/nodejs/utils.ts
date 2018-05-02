// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

// From: https://github.com/Microsoft/TypeScript/issues/12215
// Helpers to create 'subtraction' types.  i.e. a type equivalent to some other object type,
// just with some members removed.

export type Omit<T, K extends keyof T> = Pick<T, Exclude<keyof T, K>>
