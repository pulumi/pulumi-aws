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

// This file contains two categories of exports:
//
//     1) A union type, Tenancy, that accepts any valid EC2 tenancy description.
//     2) Individual constants for each such tenancy description.
//
// These just give a better developer experience and are just sugared strings.

import {Tenancy} from ".";

/** @deprecated Use Tenancy instead. */
export module Tenancies {
    /** @deprecated Use Tenancy.Default instead. */
    export const DefaultTenancy: Tenancy = "default";
    /** @deprecated Use Tenancy.Dedicated instead. */
    export const DedicatedTenancy: Tenancy = "dedicated";
}

/**
 * @deprecated Use Tenancy.Default instead.
 */
export const DefaultTenancy: Tenancy = "default";
/**
 * @deprecated Use Tenancy.Dedicated instead.
 */
export const DedicatedTenancy: Tenancy = "dedicated";
