// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

// Runtime is a union type containing all available AWS Lambda runtimes.
export type Runtime =
    "dotnetcore1.0"  |
    "java8"          |
    "nodejs4.3-edge" |
    "nodejs4.3"      |
    "nodejs6.10"     |
    "nodejs"         |
    "python2.7"      ;

export let DotnetCore1d0Runtime: Runtime = "dotnetcore1.0";
export let Java8Runtime: Runtime = "java8";
export let NodeJS4d3EdgeRuntime: Runtime = "nodejs4.3-edge";
export let NodeJS4d3Runtime: Runtime = "nodejs4.3";
export let NodeJS6d10Runtime: Runtime = "nodejs6.10";
export let NodeJSRuntime: Runtime = "nodejs";
export let Python2d7Runtime: Runtime = "python2.7";

