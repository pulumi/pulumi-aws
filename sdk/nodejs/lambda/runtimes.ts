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

/**
 * Runtime is a union type containing all available AWS Lambda runtimes.
 */
export type Runtime =
    "dotnetcore1.0"  |
    "dotnetcore2.0"  |
    "dotnetcore2.1"  |
    "go1.x"          |
    "java8"          |
    "nodejs4.3-edge" |
    "nodejs4.3"      |
    "nodejs6.10"     |
    "nodejs8.10"     |
    "nodejs"         |
    "python2.7"      |
    "python3.6"      ;

export let DotnetCore1d0Runtime: Runtime = "dotnetcore1.0";
export let DotnetCore2d0Runtime: Runtime = "dotnetcore2.0";
export let DotnetCore2d1Runtime: Runtime = "dotnetcore2.1";
export let Go1dxRuntime: Runtime = "go1.x";
export let Java8Runtime: Runtime = "java8";
export let NodeJS4d3EdgeRuntime: Runtime = "nodejs4.3-edge";
export let NodeJS4d3Runtime: Runtime = "nodejs4.3";
export let NodeJS6d10Runtime: Runtime = "nodejs6.10";
export let NodeJS8d10Runtime: Runtime = "nodejs8.10";
export let NodeJSRuntime: Runtime = "nodejs";
export let Python2d7Runtime: Runtime = "python2.7";
export let Python3d6Runtime: Runtime = "python3.6";
