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
//     1) A union type, InstanceType, that accepts any valid RDS instance type.
//     2) Individual constants for each such RDS instance type.
//
// These give a better developer experience and are just sugared strings.
// Based from https://aws.amazon.com/rds/instance-types/

import {InstanceType} from ".";

/** @deprecated Use InstanceType instead. */
export module InstanceTypes {
    /** @deprecated Use InstanceType.T3_Micro instead. */
    export const T3_Micro: InstanceType = "db.t3.micro";
    /** @deprecated Use InstanceType.T3_Small instead. */
    export const T3_Small: InstanceType = "db.t3.small";
    /** @deprecated Use InstanceType.T3_Medium instead. */
    export const T3_Medium: InstanceType = "db.t3.medium";
    /** @deprecated Use InstanceType.T3_Large instead. */
    export const T3_Large: InstanceType = "db.t3.large";
    /** @deprecated Use InstanceType.T3_XLarge instead. */
    export const T3_XLarge: InstanceType = "db.t3.xlarge";
    /** @deprecated Use InstanceType.T3_2XLarge instead. */
    export const T3_2XLarge: InstanceType = "db.t3.2xlarge";
    /** @deprecated Use InstanceType.T2_Micro instead. */
    export const T2_Micro: InstanceType = "db.t2.micro";
    /** @deprecated Use InstanceType.T2_Small instead. */
    export const T2_Small: InstanceType = "db.t2.small";
    /** @deprecated Use InstanceType.T2_Medium instead. */
    export const T2_Medium: InstanceType = "db.t2.medium";
    /** @deprecated Use InstanceType.T2_Large instead. */
    export const T2_Large: InstanceType = "db.t2.large";
    /** @deprecated Use InstanceType.T2_XLarge instead. */
    export const T2_XLarge: InstanceType = "db.t2.xlarge";
    /** @deprecated Use InstanceType.T2_2XLarge instead. */
    export const T2_2XLarge: InstanceType = "db.t2.2xlarge";
    /** @deprecated Use InstanceType.M1_Small instead. */
    export const M1_Small: InstanceType = "db.m1.small";
    /** @deprecated Use InstanceType.M1_Medium instead. */
    export const M1_Medium: InstanceType = "db.m1.medium";
    /** @deprecated Use InstanceType.M1_Large instead. */
    export const M1_Large: InstanceType = "db.m1.large";
    /** @deprecated Use InstanceType.M1_XLarge instead. */
    export const M1_XLarge: InstanceType = "db.m1.xlarge";
    /** @deprecated Use InstanceType.M2_XLarge instead. */
    export const M2_XLarge: InstanceType = "db.m2.xlarge";
    /** @deprecated Use InstanceType.M2_2XLarge instead. */
    export const M2_2XLarge: InstanceType = "db.m2.2xlarge";
    /** @deprecated Use InstanceType.M2_4XLarge instead. */
    export const M2_4XLarge: InstanceType = "db.m2.4xlarge";
    /** @deprecated Use InstanceType.M3_Medium instead. */
    export const M3_Medium: InstanceType = "db.m3.medium";
    /** @deprecated Use InstanceType.M3_Large instead. */
    export const M3_Large: InstanceType = "db.m3.large";
    /** @deprecated Use InstanceType.M3_XLarge instead. */
    export const M3_XLarge: InstanceType = "db.m3.xlarge";
    /** @deprecated Use InstanceType.M3_2XLarge instead. */
    export const M3_2XLarge: InstanceType = "db.m3.2xlarge";
    /** @deprecated Use InstanceType.M4_Large instead. */
    export const M4_Large: InstanceType = "db.m4.large";
    /** @deprecated Use InstanceType.M4_XLarge instead. */
    export const M4_XLarge: InstanceType = "db.m4.xlarge";
    /** @deprecated Use InstanceType.M4_2XLarge instead. */
    export const M4_2XLarge: InstanceType = "db.m4.2xlarge";
    /** @deprecated Use InstanceType.M4_4XLarge instead. */
    export const M4_4XLarge: InstanceType = "db.m4.4xlarge";
    /** @deprecated Use InstanceType.M4_10XLarge instead. */
    export const M4_10XLarge: InstanceType = "db.m4.10xlarge";
    /** @deprecated Use InstanceType.M4_16XLarge instead. */
    export const M4_16XLarge: InstanceType = "db.m4.10xlarge";
    /** @deprecated Use InstanceType.M5_Large instead. */
    export const M5_Large: InstanceType = "db.m5.large";
    /** @deprecated Use InstanceType.M5_XLarge instead. */
    export const M5_XLarge: InstanceType = "db.m5.xlarge";
    /** @deprecated Use InstanceType.M5_2XLarge instead. */
    export const M5_2XLarge: InstanceType = "db.m5.2xlarge";
    /** @deprecated Use InstanceType.M5_4XLarge instead. */
    export const M5_4XLarge: InstanceType = "db.m5.4xlarge";
    /** @deprecated Use InstanceType.M5_12XLarge instead. */
    export const M5_12XLarge: InstanceType = "db.m5.12xlarge";
    /** @deprecated Use InstanceType.M5_24XLarge instead. */
    export const M5_24XLarge: InstanceType = "db.m5.24xlarge";
    /** @deprecated Use InstanceType.R3_Large instead. */
    export const R3_Large: InstanceType = "db.r3.large";
    /** @deprecated Use InstanceType.R3_XLarge instead. */
    export const R3_XLarge: InstanceType = "db.r3.xlarge";
    /** @deprecated Use InstanceType.R3_2XLarge instead. */
    export const R3_2XLarge: InstanceType = "db.r3.2xlarge";
    /** @deprecated Use InstanceType.R3_4XLarge instead. */
    export const R3_4XLarge: InstanceType = "db.r3.4xlarge";
    /** @deprecated Use InstanceType.R3_8XLarge instead. */
    export const R3_8XLarge: InstanceType = "db.r3.8xlarge";
    /** @deprecated Use InstanceType.R4_Large instead. */
    export const R4_Large: InstanceType = "db.r4.large";
    /** @deprecated Use InstanceType.R4_XLarge instead. */
    export const R4_XLarge: InstanceType = "db.r4.xlarge";
    /** @deprecated Use InstanceType.R4_2XLarge instead. */
    export const R4_2XLarge: InstanceType = "db.r4.2xlarge";
    /** @deprecated Use InstanceType.R4_4XLarge instead. */
    export const R4_4XLarge: InstanceType = "db.r4.4xlarge";
    /** @deprecated Use InstanceType.R4_8XLarge instead. */
    export const R4_8XLarge: InstanceType = "db.r4.8xlarge";
    /** @deprecated Use InstanceType.R4_16XLarge instead. */
    export const R4_16XLarge: InstanceType = "db.r4.16xlarge";
    /** @deprecated Use InstanceType.R5_Large instead. */
    export const R5_Large: InstanceType = "db.r5.large";
    /** @deprecated Use InstanceType.R5_XLarge instead. */
    export const R5_XLarge: InstanceType = "db.r5.xlarge";
    /** @deprecated Use InstanceType.R5_2XLarge instead. */
    export const R5_2XLarge: InstanceType = "db.r5.2xlarge";
    /** @deprecated Use InstanceType.R5_4XLarge instead. */
    export const R5_4XLarge: InstanceType = "db.r5.4xlarge";
    /** @deprecated Use InstanceType.R5_12XLarge instead. */
    export const R5_12XLarge: InstanceType = "db.r5.12xlarge";
    /** @deprecated Use InstanceType.R5_24XLarge instead. */
    export const R5_24XLarge: InstanceType = "db.r5.24xlarge";
    /** @deprecated Use InstanceType.X1_16XLarge instead. */
    export const X1_16XLarge: InstanceType = "db.x1.16xlarge";
    /** @deprecated Use InstanceType.X1_32XLarge instead. */
    export const X1_32XLarge: InstanceType = "db.x1.32xlarge";
    /** @deprecated Use InstanceType.X1E_XLarge instead. */
    export const X1E_XLarge: InstanceType = "db.x1e.xlarge";
    /** @deprecated Use InstanceType.X1E_2XLarge instead. */
    export const X1E_2XLarge: InstanceType = "db.x1e.2xlarge";
    /** @deprecated Use InstanceType.X1E_4XLarge instead. */
    export const X1E_4XLarge: InstanceType = "db.x1e.4xlarge";
    /** @deprecated Use InstanceType.X1E_8XLarge instead. */
    export const X1E_8XLarge: InstanceType = "db.x1e.8xlarge";
    /** @deprecated Use InstanceType.X1E_32XLarge instead. */
    export const X1E_32XLarge: InstanceType = "db.x1e.32xlarge";
}
