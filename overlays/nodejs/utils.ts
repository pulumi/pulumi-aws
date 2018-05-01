// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

// From: https://stackoverflow.com/questions/41476063/typescript-remove-key-from-type-subtraction-type
// Helpers to create 'subtraction' types.  i.e. a type equivalent to some other object type,
// just with some members removed.

export type Sub<O extends string, D extends string> = {
    [K in O]: (Record<D, never> & Record<string, K>)[K]
}[O]

export type Omit<O, D extends string> = Pick<O, Sub<keyof O, D>>
