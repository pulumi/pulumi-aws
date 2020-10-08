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

import {Runtime} from ".";

/** @deprecated The DotnetCore2d1Runtime constant is deprecated, use Runtime.DotnetCore2d1 instead. */
export let DotnetCore2d1Runtime: Runtime = "dotnetcore2.1";
/** @deprecated The DotnetCore3d1Runtime constant is deprecated, use Runtime.DotnetCore3d1 instead. */
export let DotnetCore3d1Runtime: Runtime = "dotnetcore3.1";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Go1dxRuntime:         Runtime = "go1.x";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Java8Runtime:         Runtime = "java8";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Java11Runtime:        Runtime = "java11";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Ruby2d5Runtime:       Runtime = "ruby2.5";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Ruby2d7Runtime:       Runtime = "ruby2.7";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let NodeJS10dXRuntime:    Runtime = "nodejs10.x";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let NodeJS12dXRuntime:    Runtime = "nodejs12.x";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Python2d7Runtime:     Runtime = "python2.7";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Python3d6Runtime:     Runtime = "python3.6";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Python3d7Runtime:     Runtime = "python3.7";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let Python3d8Runtime:     Runtime = "python3.8";
/** @deprecated The Go1dxRuntime constant is deprecated, use Runtime.Go1dx instead. */
export let CustomRuntime:        Runtime = "provided";

/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJSRuntime: Runtime = "nodejs";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS4d3EdgeRuntime: Runtime = "nodejs4.3-edge";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS4d3Runtime: Runtime = "nodejs4.3";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS6d10Runtime: Runtime = "nodejs6.10";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let DotnetCore1d0Runtime: Runtime = "dotnetcore1.0";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let DotnetCore2d0Runtime: Runtime = "dotnetcore2.0";
/** @deprecated No longer supported. New lambda functions created using this runtime will fail */
export let NodeJS8d10Runtime: Runtime = "nodejs8.10";
