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

export module InstanceTypes {
    export const T2_Micro: InstanceType = "db.t2.micro";
    export const T2_Small: InstanceType = "db.t2.small";
    export const T2_Medium: InstanceType = "db.t2.medium";
    export const T2_Large: InstanceType = "db.t2.large";
    export const T2_XLarge: InstanceType = "db.t2.xlarge";
    export const T2_2XLarge: InstanceType = "db.t2.2xlarge";
    export const M1_Small: InstanceType = "db.m1.small";
    export const M1_Medium: InstanceType = "db.m1.medium";
    export const M1_Large: InstanceType = "db.m1.large";
    export const M1_XLarge: InstanceType = "db.m1.xlarge";
    export const M2_XLarge: InstanceType = "db.m2.xlarge";
    export const M2_2XLarge: InstanceType = "db.m2.2xlarge";
    export const M2_4XLarge: InstanceType = "db.m2.4xlarge";
    export const M3_Medium: InstanceType = "db.m3.medium";
    export const M3_Large: InstanceType = "db.m3.large";
    export const M3_XLarge: InstanceType = "db.m3.xlarge";
    export const M3_2XLarge: InstanceType = "db.m3.2xlarge";
    export const M4_Large: InstanceType = "db.m4.large";
    export const M4_XLarge: InstanceType = "db.m4.xlarge";
    export const M4_2XLarge: InstanceType = "db.m4.2xlarge";
    export const M4_4XLarge: InstanceType = "db.m4.4xlarge";
    export const M4_10XLarge: InstanceType = "db.m4.10xlarge";
    export const M4_16XLarge: InstanceType = "db.m4.10xlarge";
    export const M5_Large: InstanceType = "db.m5.large";
    export const M5_XLarge: InstanceType = "db.m5.xlarge";
    export const M5_2XLarge: InstanceType = "db.m5.2xlarge";
    export const M5_4XLarge: InstanceType = "db.m5.4xlarge";
    export const M5_12XLarge: InstanceType = "db.m5.12xlarge";
    export const M5_24XLarge: InstanceType = "db.m5.24xlarge";
    export const R3_Large: InstanceType = "db.r3.large";
    export const R3_XLarge: InstanceType = "db.r3.xlarge";
    export const R3_2XLarge: InstanceType = "db.r3.2xlarge";
    export const R3_4XLarge: InstanceType = "db.r3.4xlarge";
    export const R3_8XLarge: InstanceType = "db.r3.8xlarge";
    export const R4_Large: InstanceType = "db.r4.large";
    export const R4_XLarge: InstanceType = "db.r4.xlarge";
    export const R4_2XLarge: InstanceType = "db.r4.2xlarge";
    export const R4_4XLarge: InstanceType = "db.r4.4xlarge";
    export const R4_8XLarge: InstanceType = "db.r4.8xlarge";
    export const R4_16XLarge: InstanceType = "db.r4.16xlarge";
    export const R5_Large: InstanceType = "db.r5.large";
    export const R5_XLarge: InstanceType = "db.r5.xlarge";
    export const R5_2XLarge: InstanceType = "db.r5.2xlarge";
    export const R5_4XLarge: InstanceType = "db.r5.4xlarge";
    export const R5_12XLarge: InstanceType = "db.r5.12xlarge";
    export const R5_24XLarge: InstanceType = "db.r5.24xlarge";
    export const X1_16XLarge: InstanceType = "db.x1.16xlarge";
    export const X1_32XLarge: InstanceType = "db.x1.32xlarge";
    export const X1E_XLarge: InstanceType = "db.x1e.xlarge";
    export const X1E_2XLarge: InstanceType = "db.x1e.2xlarge";
    export const X1E_4XLarge: InstanceType = "db.x1e.4xlarge";
    export const X1E_8XLarge: InstanceType = "db.x1e.8xlarge";
    export const X1E_32XLarge: InstanceType = "db.x1e.32xlarge";
}

export type InstanceType =
    "db.t2.micro" |
    "db.t2.small" |
    "db.t2.medium" |
    "db.t2.large" |
    "db.t2.xlarge" |
    "db.t2.2xlarge" |
    "db.m1.small" |
    "db.m1.medium" |
    "db.m1.large" |
    "db.m1.xlarge" |
    "db.m2.xlarge" |
    "db.m2.2xlarge" |
    "db.m2.4xlarge" |
    "db.m3.medium" |
    "db.m3.large" |
    "db.m3.xlarge" |
    "db.m3.2xlarge" |
    "db.m4.large" |
    "db.m4.xlarge" |
    "db.m4.2xlarge" |
    "db.m4.4xlarge" |
    "db.m4.10xlarge" |
    "db.m4.16xlarge" |
    "db.m5.large" |
    "db.m5.xlarge" |
    "db.m5.2xlarge" |
    "db.m5.4xlarge" |
    "db.m5.12xlarge" |
    "db.m5.24xlarge" |
    "db.r3.large" |
    "db.r3.xlarge" |
    "db.r3.2xlarge" |
    "db.r3.4xlarge" |
    "db.r3.8xlarge" |
    "db.r4.large" |
    "db.r4.xlarge" |
    "db.r4.2xlarge" |
    "db.r4.4xlarge" |
    "db.r4.8xlarge" |
    "db.r4.16xlarge" |
    "db.r5.large" |
    "db.r5.xlarge" |
    "db.r5.2xlarge" |
    "db.r5.4xlarge" |
    "db.r5.12xlarge" |
    "db.r5.24xlarge" |
    "db.x1.16xlarge" |
    "db.x1.32xlarge" |
    "db.x1e.xlarge" |
    "db.x1e.2xlarge" |
    "db.x1e.4xlarge" |
    "db.x1e.8xlarge" |
    "db.x1e.32xlarge" ;


