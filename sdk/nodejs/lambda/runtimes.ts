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

// This file contains individual constants for each Lambda Runtime type.
//
// These constants will not be updated with new values.
// It is recommended to use Runtime.[Value] instead.

import {Runtime} from ".";

/** The DotnetCore2d1Runtime constant is deprecated, use Runtime.DotnetCore2d1 instead. */
export let DotnetCore2d1Runtime: Runtime = "dotnetcore2.1";
/** The DotnetCore3d1Runtime constant is deprecated, use Runtime.DotnetCore3d1 instead. */
export let DotnetCore3d1Runtime: Runtime = "dotnetcore3.1";
/** The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Go1dxRuntime:         Runtime = "go1.x";
/** The Java8Runtime constant is deprecated, use Runtime.Java8 instead. */
export let Java8Runtime:         Runtime = "java8";
/** The Java11Runtime constant is deprecated, use Runtime.Java11 instead. */
export let Java11Runtime:        Runtime = "java11";
/** The Ruby2d5Runtime constant is deprecated, use Runtime.Ruby2d5 instead. */
export let Ruby2d5Runtime:       Runtime = "ruby2.5";
/** The Ruby2d7Runtime constant is deprecated, use Runtime.Ruby2d7 instead. */
export let Ruby2d7Runtime:       Runtime = "ruby2.7";
/** The NodeJS10dXRuntime constant is deprecated, use Runtime.NodeJS10dX instead. */
export let NodeJS10dXRuntime:    Runtime = "nodejs10.x";
/** The NodeJS12dXRuntime constant is deprecated, use Runtime.NodeJS12dX instead. */
export let NodeJS12dXRuntime:    Runtime = "nodejs12.x";
/** The Python2d7Runtime constant is deprecated, use Runtime.Python2d7 instead. */
export let Python2d7Runtime:     Runtime = "python2.7";
/** The Python3d6Runtime constant is deprecated, use Runtime.Python3d6 instead. */
export let Python3d6Runtime:     Runtime = "python3.6";
/** The Python3d7Runtime constant is deprecated, use Runtime.Python3d7 instead. */
export let Python3d7Runtime:     Runtime = "python3.7";
/** The Python3d8Runtime constant is deprecated, use Runtime.Python3d8 instead. */
export let Python3d8Runtime:     Runtime = "python3.8";
/** The CustomRuntime constant is deprecated, use Runtime.Custom instead. */
export let CustomRuntime:        Runtime = "provided";

/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJSRuntime = "nodejs" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS4d3EdgeRuntime = "nodejs4.3-edge" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS4d3Runtime = "nodejs4.3" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS6d10Runtime = "nodejs6.10" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let DotnetCore1d0Runtime = "dotnetcore1.0" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let DotnetCore2d0Runtime = "dotnetcore2.0" as Runtime;
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS8d10Runtime = "nodejs8.10" as Runtime;
