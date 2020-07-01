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
//     1) A union type, InstanceType, that accepts any valid EC2 instance type.
//     2) Individual constants for each such EC2 instance type.
//
// These just give a better developer experience and are just sugared strings.

/* tslint:disable:max-line-length ordered-imports variable-name */

export module InstanceTypes {
    export const A1_2XLarge: InstanceType = "a1.2xlarge";
    export const A1_4XLarge: InstanceType = "a1.4xlarge";
    export const A1_Large: InstanceType = "a1.large";
    export const A1_Medium: InstanceType = "a1.medium";
    export const A1_XLarge: InstanceType = "a1.xlarge";
    export const C3_2XLarge: InstanceType = "c3.2xlarge";
    export const C3_4XLarge: InstanceType = "c3.4xlarge";
    export const C3_8XLarge: InstanceType = "c3.8xlarge";
    export const C3_Large: InstanceType = "c3.large";
    export const C3_XLarge: InstanceType = "c3.xlarge";
    export const C4_2XLarge: InstanceType = "c4.2xlarge";
    export const C4_4XLarge: InstanceType = "c4.4xlarge";
    export const C4_8XLarge: InstanceType = "c4.8xlarge";
    export const C4_Large: InstanceType = "c4.large";
    export const C4_XLarge: InstanceType = "c4.xlarge";
    export const C5_18XLarge: InstanceType = "c5.18xlarge";
    export const C5_2XLarge: InstanceType = "c5.2xlarge";
    export const C5_4XLarge: InstanceType = "c5.4xlarge";
    export const C5_9XLarge: InstanceType = "c5.9xlarge";
    export const C5_Large: InstanceType = "c5.large";
    export const C5_XLarge: InstanceType = "c5.xlarge";
    export const C5a_12XLarge: InstanceType = "c5a.12xlarge";
    export const C5a_16XLarge: InstanceType = "c5a.16xlarge";
    export const C5a_2XLarge: InstanceType = "c5a.2xlarge";
    export const C5a_24XLarge: InstanceType = "c5a.24xlarge";
    export const C5a_4XLarge: InstanceType = "c5a.4xlarge";
    export const C5a_8XLarge: InstanceType = "c5a.8xlarge";
    export const C5a_Large: InstanceType = "c5a.large";
    export const C5a_XLarge: InstanceType = "c5a.xlarge";
    export const C5d_18XLarge: InstanceType = "c5d.18xlarge";
    export const C5d_2XLarge: InstanceType = "c5d.2xlarge";
    export const C5d_4XLarge: InstanceType = "c5d.4xlarge";
    export const C5d_9XLarge: InstanceType = "c5d.9xlarge";
    export const C5d_Large: InstanceType = "c5d.large";
    export const C5d_XLarge: InstanceType = "c5d.xlarge";
    export const C5n_18XLarge: InstanceType = "c5n.18xlarge";
    export const C5n_2XLarge: InstanceType = "c5n.2xlarge";
    export const C5n_4XLarge: InstanceType = "c5n.4xlarge";
    export const C5n_9XLarge: InstanceType = "c5n.9xlarge";
    export const C5n_Large: InstanceType = "c5n.large";
    export const C5n_XLarge: InstanceType = "c5n.xlarge";
    export const D2_2XLarge: InstanceType = "d2.2xlarge";
    export const D2_4XLarge: InstanceType = "d2.4xlarge";
    export const D2_8XLarge: InstanceType = "d2.8xlarge";
    export const D2_XLarge: InstanceType = "d2.xlarge";
    export const F1_16XLarge: InstanceType = "f1.16xlarge";
    export const F1_2XLarge: InstanceType = "f1.2xlarge";
    export const G2_2XLarge: InstanceType = "g2.2xlarge";
    export const G2_8XLarge: InstanceType = "g2.8xlarge";
    export const G3_16XLarge: InstanceType = "g3.16xlarge";
    export const G3_4XLarge: InstanceType = "g3.4xlarge";
    export const G3_8XLarge: InstanceType = "g3.8xlarge";
    export const G3s_XLarge: InstanceType = "g3s.xlarge";
    export const H1_16XLarge: InstanceType = "h1.16xlarge";
    export const H1_2XLarge: InstanceType = "h1.2xlarge";
    export const H1_4XLarge: InstanceType = "h1.4xlarge";
    export const H1_8XLarge: InstanceType = "h1.8xlarge";
    export const Hs1_8XLarge: InstanceType = "hs1.8xlarge";
    export const I3_16XLarge: InstanceType = "i3.16xlarge";
    export const I3_2XLarge: InstanceType = "i3.2xlarge";
    export const I3_4XLarge: InstanceType = "i3.4xlarge";
    export const I3_8XLarge: InstanceType = "i3.8xlarge";
    export const I3_Large: InstanceType = "i3.large";
    export const I3_XLarge: InstanceType = "i3.xlarge";
    export const I3_Metal: InstanceType = "i3.metal";
    export const M3_2XLarge: InstanceType = "m3.2xlarge";
    export const M3_Large: InstanceType = "m3.large";
    export const M3_Medium: InstanceType = "m3.medium";
    export const M3_XLarge: InstanceType = "m3.xlarge";
    export const M4_10XLarge: InstanceType = "m4.10xlarge";
    export const M4_16XLarge: InstanceType = "m4.16xlarge";
    export const M4_2XLarge: InstanceType = "m4.2xlarge";
    export const M4_4XLarge: InstanceType = "m4.4xlarge";
    export const M4_Large: InstanceType = "m4.large";
    export const M4_XLarge: InstanceType = "m4.xlarge";
    export const M5_Large: InstanceType = "m5.large";
    export const M5_XLarge: InstanceType = "m5.xlarge";
    export const M5_2XLarge: InstanceType = "m5.2xlarge";
    export const M5_4XLarge: InstanceType = "m5.4xlarge";
    export const M5_12XLarge: InstanceType = "m5.12xlarge";
    export const M5_24XLarge: InstanceType = "m5.24xlarge";
    export const M5d_Large: InstanceType = "m5d.large";
    export const M5d_XLarge: InstanceType = "m5d.xlarge";
    export const M5d_2XLarge: InstanceType = "m5d.2xlarge";
    export const M5d_4XLarge: InstanceType = "m5d.4xlarge";
    export const M5d_12XLarge: InstanceType = "m5d.12xlarge";
    export const M5d_24XLarge: InstanceType = "m5d.24xlarge";
    export const M5a_12XLarge: InstanceType = "m5a.12xlarge";
    export const M5a_24XLarge: InstanceType = "m5a.24xlarge";
    export const M5a_2XLarge: InstanceType = "m5a.2xlarge";
    export const M5a_4XLarge: InstanceType = "m5a.4xlarge";
    export const M5a_Large: InstanceType = "m5a.large";
    export const M5a_XLarge: InstanceType = "m5a.xlarge";
    export const P2_16XLarge: InstanceType = "p2.16xlarge";
    export const P2_8XLarge: InstanceType = "p2.8xlarge";
    export const P2_XLarge: InstanceType = "p2.xlarge";
    export const P3_16XLarge: InstanceType = "p3.16xlarge";
    export const P3_2XLarge: InstanceType = "p3.2xlarge";
    export const P3_8XLarge: InstanceType = "p3.8xlarge";
    export const P3dn_24XLarge: InstanceType = "p3dn.24xlarge";
    export const R3_2XLarge: InstanceType = "r3.2xlarge";
    export const R3_4XLarge: InstanceType = "r3.4xlarge";
    export const R3_8XLarge: InstanceType = "r3.8xlarge";
    export const R3_Large: InstanceType = "r3.large";
    export const R3_XLarge: InstanceType = "r3.xlarge";
    export const R4_16XLarge: InstanceType = "r4.16xlarge";
    export const R4_2XLarge: InstanceType = "r4.2xlarge";
    export const R4_4XLarge: InstanceType = "r4.4xlarge";
    export const R4_8XLarge: InstanceType = "r4.8xlarge";
    export const R4_Large: InstanceType = "r4.large";
    export const R4_XLarge: InstanceType = "r4.xlarge";
    export const R5_12XLarge: InstanceType = "r5.12xlarge";
    export const R5_24XLarge: InstanceType = "r5.24xlarge";
    export const R5_2XLarge: InstanceType = "r5.2xlarge";
    export const R5_4XLarge: InstanceType = "r5.4xlarge";
    export const R5_Large: InstanceType = "r5.large";
    export const R5_XLarge: InstanceType = "r5.xlarge";
    export const R5a_12XLarge: InstanceType = "r5a.12xlarge";
    export const R5a_24XLarge: InstanceType = "r5a.24xlarge";
    export const R5a_2XLarge: InstanceType = "r5a.2xlarge";
    export const R5a_4XLarge: InstanceType = "r5a.4xlarge";
    export const R5a_Large: InstanceType = "r5a.large";
    export const R5a_XLarge: InstanceType = "r5a.xlarge";
    export const R5d_12XLarge: InstanceType = "r5d.12xlarge";
    export const R5d_24XLarge: InstanceType = "r5d.24xlarge";
    export const R5d_2XLarge: InstanceType = "r5d.2xlarge";
    export const R5d_4XLarge: InstanceType = "r5d.4xlarge";
    export const R5d_Large: InstanceType = "r5d.large";
    export const R5d_XLarge: InstanceType = "r5d.xlarge";
    export const T2_2XLarge: InstanceType = "t2.2xlarge";
    export const T2_Large: InstanceType = "t2.large";
    export const T2_Medium: InstanceType = "t2.medium";
    export const T2_Micro: InstanceType = "t2.micro";
    export const T2_Nano: InstanceType = "t2.nano";
    export const T2_Small: InstanceType = "t2.small";
    export const T2_XLarge: InstanceType = "t2.xlarge";
    export const T3_2XLarge: InstanceType = "t3.2xlarge";
    export const T3_Large: InstanceType = "t3.large";
    export const T3_Medium: InstanceType = "t3.medium";
    export const T3_Micro: InstanceType = "t3.micro";
    export const T3_Nano: InstanceType = "t3.nano";
    export const T3_Small: InstanceType = "t3.small";
    export const T3_XLarge: InstanceType = "t3.xlarge";
    export const T3a_2XLarge: InstanceType = "t3a.2xlarge";
    export const T3a_Large: InstanceType = "t3a.large";
    export const T3a_Medium: InstanceType = "t3a.medium";
    export const T3a_Micro: InstanceType = "t3a.micro";
    export const T3a_Nano: InstanceType = "t3a.nano";
    export const T3a_Small: InstanceType = "t3a.small";
    export const T3a_XLarge: InstanceType = "t3a.xlarge";
    export const U_12tb1Metal: InstanceType = "u-12tb1.metal";
    export const U_6tb1Metal: InstanceType = "u-6tb1.metal";
    export const U_9tb1Metal: InstanceType = "u-9tb1.metal";
    export const X1_16XLarge: InstanceType = "x1.16xlarge";
    export const X1_32XLarge: InstanceType = "x1.32xlarge";
    export const X1e_16XLarge: InstanceType = "x1e.16xlarge";
    export const X1e_2XLarge: InstanceType = "x1e.2xlarge";
    export const X1e_32XLarge: InstanceType = "x1e.32xlarge";
    export const X1e_4XLarge: InstanceType = "x1e.4xlarge";
    export const X1e_8XLarge: InstanceType = "x1e.8xlarge";
    export const X1e_XLarge: InstanceType = "x1e.xlarge";
    export const Z1d_12XLarge: InstanceType = "z1d.12xlarge";
    export const Z1d_2XLarge: InstanceType = "z1d.2xlarge";
    export const Z1d_3XLarge: InstanceType = "z1d.3xlarge";
    export const Z1d_6XLarge: InstanceType = "z1d.6xlarge";
    export const Z1d_Large: InstanceType = "z1d.large";
    export const Z1d_XLarge: InstanceType = "z1d.xlarge";
}

export type InstanceType =
    "a1.2xlarge" |
    "a1.4xlarge" |
    "a1.large" |
    "a1.medium" |
    "a1.xlarge" |
    "c3.2xlarge" |
    "c3.4xlarge" |
    "c3.8xlarge" |
    "c3.large" |
    "c3.xlarge" |
    "c4.2xlarge" |
    "c4.4xlarge" |
    "c4.8xlarge" |
    "c4.large" |
    "c4.xlarge" |
    "c5.18xlarge" |
    "c5.4xlarge" |
    "c5.2xlarge" |
    "c5.large" |
    "c5.9xlarge" |
    "c5.xlarge" |
    "c5a.12xlarge" |
    "c5a.16xlarge" |
    "c5a.2xlarge" |
    "c5a.24xlarge" |
    "c5a.4xlarge" |
    "c5a.8xlarge" |
    "c5a.large" |
    "c5a.xlarge" |
    "c5d.18xlarge" |
    "c5d.4xlarge" |
    "c5d.2xlarge" |
    "c5d.large" |
    "c5d.9xlarge" |
    "c5n.18xlarge" |
    "c5d.xlarge" |
    "c5n.4xlarge" |
    "c5n.2xlarge" |
    "c5n.9xlarge" |
    "c5n.large" |
    "c5n.xlarge" |
    "d2.2xlarge" |
    "d2.4xlarge" |
    "d2.8xlarge" |
    "d2.xlarge" |
    "f1.16xlarge" |
    "f1.2xlarge" |
    "g2.2xlarge" |
    "g2.8xlarge" |
    "g3.16xlarge" |
    "g3.4xlarge" |
    "g3.8xlarge" |
    "g3s.xlarge" |
    "h1.16xlarge" |
    "h1.2xlarge" |
    "h1.4xlarge" |
    "h1.8xlarge" |
    "hs1.8xlarge" |
    "i3.16xlarge" |
    "i3.2xlarge" |
    "i3.4xlarge" |
    "i3.8xlarge" |
    "i3.large" |
    "i3.xlarge" |
    "i3.metal" |
    "m3.2xlarge" |
    "m3.large" |
    "m3.medium" |
    "m3.xlarge" |
    "m4.10xlarge" |
    "m4.16xlarge" |
    "m4.2xlarge" |
    "m4.4xlarge" |
    "m4.large" |
    "m4.xlarge" |
    "m5.large" |
    "m5.xlarge" |
    "m5.2xlarge" |
    "m5.4xlarge" |
    "m5.12xlarge" |
    "m5.24xlarge" |
    "m5d.large" |
    "m5d.xlarge" |
    "m5d.2xlarge" |
    "m5d.4xlarge" |
    "m5d.12xlarge" |
    "m5d.24xlarge" |
    "m5a.12xlarge" |
    "m5a.24xlarge" |
    "m5a.2xlarge" |
    "m5a.4xlarge" |
    "m5a.large" |
    "m5a.xlarge" |
    "p2.16xlarge" |
    "p2.8xlarge" |
    "p2.xlarge" |
    "p3.16xlarge" |
    "p3.8xlarge" |
    "p3.2xlarge" |
    "p3dn.24xlarge" |
    "r3.2xlarge" |
    "r3.4xlarge" |
    "r3.8xlarge" |
    "r3.large" |
    "r3.xlarge" |
    "r4.16xlarge" |
    "r4.2xlarge" |
    "r4.4xlarge" |
    "r4.8xlarge" |
    "r4.large" |
    "r4.xlarge" |
    "r5.12xlarge" |
    "r5.24xlarge" |
    "r5.2xlarge" |
    "r5.4xlarge" |
    "r5.large" |
    "r5.xlarge" |
    "r5a.12xlarge" |
    "r5a.24xlarge" |
    "r5a.2xlarge" |
    "r5a.4xlarge" |
    "r5a.large" |
    "r5a.xlarge" |
    "r5d.12xlarge" |
    "r5d.24xlarge" |
    "r5d.2xlarge" |
    "r5d.4xlarge" |
    "r5d.large" |
    "r5d.xlarge" |
    "t2.2xlarge" |
    "t2.large" |
    "t2.medium" |
    "t2.micro" |
    "t2.nano" |
    "t2.small" |
    "t2.xlarge" |
    "t3.2xlarge" |
    "t3.large" |
    "t3.medium" |
    "t3.micro" |
    "t3.nano" |
    "t3.small" |
    "t3.xlarge" |
    "t3a.2xlarge" |
    "t3a.large" |
    "t3a.medium" |
    "t3a.micro" |
    "t3a.nano" |
    "t3a.small" |
    "t3a.xlarge" |
    "u-12tb1.metal" |
    "u-6tb1.metal" |
    "u-9tb1.metal" |
    "x1.16xlarge" |
    "x1.32xlarge" |
    "x1e.16xlarge" |
    "x1e.2xlarge" |
    "x1e.32xlarge" |
    "x1e.4xlarge" |
    "x1e.8xlarge" |
    "x1e.xlarge" |
    "z1d.12xlarge" |
    "z1d.2xlarge" |
    "z1d.3xlarge" |
    "z1d.6xlarge" |
    "z1d.large" |
    "z1d.xlarge";
