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

module InstanceTypes {
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
    "c5d.18xlarge" |
    "c5.xlarge" |
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


/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const A1Instance2XLarge: InstanceType = "a1.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const A1Instance4XLarge: InstanceType = "a1.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const A1InstanceLarge: InstanceType = "a1.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const A1InstanceMedium: InstanceType = "a1.medium";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const A1InstanceXLarge: InstanceType = "a1.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C3Instance2XLarge: InstanceType = "c3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C3Instance4XLarge: InstanceType = "c3.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C3Instance8XLarge: InstanceType = "c3.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C3InstanceLarge: InstanceType = "c3.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C3InstanceXLarge: InstanceType = "c3.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C4Instance2XLarge: InstanceType = "c4.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C4Instance4XLarge: InstanceType = "c4.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C4Instance8XLarge: InstanceType = "c4.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C4InstanceLarge: InstanceType = "c4.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C4InstanceXLarge: InstanceType = "c4.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5Instance18XLarge: InstanceType = "c5.18xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5Instance2XLarge: InstanceType = "c5.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5Instance4XLarge: InstanceType = "c5.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5Instance9XLarge: InstanceType = "c5.9xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5InstanceLarge: InstanceType = "c5.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5InstanceXLarge: InstanceType = "c5.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstance18XLarge: InstanceType = "c5d.18xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstance2XLarge: InstanceType = "c5d.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstance4XLarge: InstanceType = "c5d.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstance9XLarge: InstanceType = "c5d.9xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstanceLarge: InstanceType = "c5d.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5dInstanceXLarge: InstanceType = "c5d.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstance18XLarge: InstanceType = "c5n.18xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstance2XLarge: InstanceType = "c5n.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstance4XLarge: InstanceType = "c5n.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstance9XLarge: InstanceType = "c5n.9xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstanceLarge: InstanceType = "c5n.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const C5nInstanceXLarge: InstanceType = "c5n.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const D2Instance2XLarge: InstanceType = "d2.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const D2Instance4XLarge: InstanceType = "d2.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const D2Instance8XLarge: InstanceType = "d2.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const D2InstanceXLarge: InstanceType = "d2.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const F1Instance16XLarge: InstanceType = "f1.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const F1Instance2XLarge: InstanceType = "f1.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G2Instance2XLarge: InstanceType = "g2.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G2Instance8XLarge: InstanceType = "g2.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G3Instance16XLarge: InstanceType = "g3.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G3Instance4XLarge: InstanceType = "g3.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G3Instance8XLarge: InstanceType = "g3.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const G3sInstanceXLarge: InstanceType = "g3s.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const H1Instance16XLarge: InstanceType = "h1.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const H1Instance2XLarge: InstanceType = "h1.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const H1Instance4XLarge: InstanceType = "h1.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const H1Instance8XLarge: InstanceType = "h1.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Hs1Instance8XLarge: InstanceType = "hs1.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3Instance16XLarge: InstanceType = "i3.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3Instance2XLarge: InstanceType = "i3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3Instance4XLarge: InstanceType = "i3.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3Instance8XLarge: InstanceType = "i3.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3InstanceLarge: InstanceType = "i3.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3InstanceXLarge: InstanceType = "i3.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const I3InstanceMetal: InstanceType = "i3.metal";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M3Instance2XLarge: InstanceType = "m3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M3InstanceLarge: InstanceType = "m3.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M3InstanceMedium: InstanceType = "m3.medium";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M3InstanceXLarge: InstanceType = "m3.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4Instance10XLarge: InstanceType = "m4.10xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4Instance16XLarge: InstanceType = "m4.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4Instance2XLarge: InstanceType = "m4.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4Instance4XLarge: InstanceType = "m4.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4InstanceLarge: InstanceType = "m4.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M4InstanceXLarge: InstanceType = "m4.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5InstanceLarge: InstanceType = "m5.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5InstanceXLarge: InstanceType = "m5.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5Instance2XLarge: InstanceType = "m5.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5Instance4XLarge: InstanceType = "m5.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5Instance12XLarge: InstanceType = "m5.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5Instance24XLarge: InstanceType = "m5.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstanceLarge: InstanceType = "m5d.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstanceXLarge: InstanceType = "m5d.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstance2XLarge: InstanceType = "m5d.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstance4XLarge: InstanceType = "m5d.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstance12XLarge: InstanceType = "m5d.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5dInstance24XLarge: InstanceType = "m5d.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstance12XLarge: InstanceType = "m5a.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstance24XLarge: InstanceType = "m5a.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstance2XLarge: InstanceType = "m5a.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstance4XLarge: InstanceType = "m5a.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstanceLarge: InstanceType = "m5a.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const M5aInstanceXLarge: InstanceType = "m5a.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P2Instance16XLarge: InstanceType = "p2.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P2Instance8XLarge: InstanceType = "p2.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P2InstanceXLarge: InstanceType = "p2.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P3Instance16XLarge: InstanceType = "p3.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P3Instance2XLarge: InstanceType = "p3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P3Instance8XLarge: InstanceType = "p3.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const P3dnInstance24XLarge: InstanceType = "p3dn.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R3Instance2XLarge: InstanceType = "r3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R3Instance4XLarge: InstanceType = "r3.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R3Instance8XLarge: InstanceType = "r3.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R3InstanceLarge: InstanceType = "r3.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R3InstanceXLarge: InstanceType = "r3.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4Instance16XLarge: InstanceType = "r4.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4Instance2XLarge: InstanceType = "r4.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4Instance4XLarge: InstanceType = "r4.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4Instance8XLarge: InstanceType = "r4.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4InstanceLarge: InstanceType = "r4.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R4InstanceXLarge: InstanceType = "r4.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5Instance12XLarge: InstanceType = "r5.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5Instance24XLarge: InstanceType = "r5.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5Instance2XLarge: InstanceType = "r5.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5Instance4XLarge: InstanceType = "r5.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5InstanceLarge: InstanceType = "r5.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5InstanceXLarge: InstanceType = "r5.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstance12XLarge: InstanceType = "r5a.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstance24XLarge: InstanceType = "r5a.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstance2XLarge: InstanceType = "r5a.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstance4XLarge: InstanceType = "r5a.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstanceLarge: InstanceType = "r5a.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5aInstanceXLarge: InstanceType = "r5a.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstance12XLarge: InstanceType = "r5d.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstance24XLarge: InstanceType = "r5d.24xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstance2XLarge: InstanceType = "r5d.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstance4XLarge: InstanceType = "r5d.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstanceLarge: InstanceType = "r5d.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const R5dInstanceXLarge: InstanceType = "r5d.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2Instance2XLarge: InstanceType = "t2.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceLarge: InstanceType = "t2.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceMedium: InstanceType = "t2.medium";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceMicro: InstanceType = "t2.micro";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceNano: InstanceType = "t2.nano";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceSmall: InstanceType = "t2.small";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T2InstanceXLarge: InstanceType = "t2.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3Instance2XLarge: InstanceType = "t3.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceLarge: InstanceType = "t3.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceMedium: InstanceType = "t3.medium";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceMicro: InstanceType = "t3.micro";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceNano: InstanceType = "t3.nano";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceSmall: InstanceType = "t3.small";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const T3InstanceXLarge: InstanceType = "t3.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const UInstance12tb1Metal: InstanceType = "u-12tb1.metal";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const UInstance6tb1Metal: InstanceType = "u-6tb1.metal";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const UInstance9tb1Metal: InstanceType = "u-9tb1.metal";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1Instance16XLarge: InstanceType = "x1.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1Instance32XLarge: InstanceType = "x1.32xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstance16XLarge: InstanceType = "x1e.16xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstance2XLarge: InstanceType = "x1e.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstance32XLarge: InstanceType = "x1e.32xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstance4XLarge: InstanceType = "x1e.4xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstance8XLarge: InstanceType = "x1e.8xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const X1eInstanceXLarge: InstanceType = "x1e.xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstance12XLarge: InstanceType = "z1d.12xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstance2XLarge: InstanceType = "z1d.2xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstance3XLarge: InstanceType = "z1d.3xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstance6XLarge: InstanceType = "z1d.6xlarge";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstanceLarge: InstanceType = "z1d.large";
/** @deprecated Use the equivalent constant in module `InstanceTypes` instead */ export const Z1dInstanceXLarge: InstanceType = "z1d.xlarge";

