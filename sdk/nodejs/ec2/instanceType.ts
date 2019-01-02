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

export let A1Instance2XLarge:   InstanceType = "a1.2xlarge";
export let A1Instance4XLarge:   InstanceType = "a1.4xlarge";
export let A1InstanceLarge:     InstanceType = "a1.large";
export let A1InstanceMedium:    InstanceType = "a1.medium";
export let A1InstanceXLarge:    InstanceType = "a1.xlarge";
export let C3Instance2XLarge:   InstanceType = "c3.2xlarge";
export let C3Instance4XLarge:   InstanceType = "c3.4xlarge";
export let C3Instance8XLarge:   InstanceType = "c3.8xlarge";
export let C3InstanceLarge:     InstanceType = "c3.large";
export let C3InstanceXLarge:    InstanceType = "c3.xlarge";
export let C4Instance2XLarge:   InstanceType = "c4.2xlarge";
export let C4Instance4XLarge:   InstanceType = "c4.4xlarge";
export let C4Instance8XLarge:   InstanceType = "c4.8xlarge";
export let C4InstanceLarge:     InstanceType = "c4.large";
export let C4InstanceXLarge:    InstanceType = "c4.xlarge";
export let C5Instance18XLarge:  InstanceType = "c5.18xlarge";
export let C5Instance2XLarge:   InstanceType = "c5.2xlarge";
export let C5Instance4XLarge:   InstanceType = "c5.4xlarge";
export let C5Instance9XLarge:   InstanceType = "c5.9xlarge";
export let C5InstanceLarge:     InstanceType = "c5.large";
export let C5InstanceXLarge:    InstanceType = "c5.xlarge";
export let C5dInstance18XLarge: InstanceType = "c5d.18xlarge";
export let C5dInstance2XLarge:  InstanceType = "c5d.2xlarge";
export let C5dInstance4XLarge:  InstanceType = "c5d.4xlarge";
export let C5dInstance9XLarge:  InstanceType = "c5d.9xlarge";
export let C5dInstanceLarge:    InstanceType = "c5d.large";
export let C5dInstanceXLarge:   InstanceType = "c5d.xlarge";
export let C5nInstance18XLarge: InstanceType = "c5n.18xlarge";
export let C5nInstance2XLarge:  InstanceType = "c5n.2xlarge";
export let C5nInstance4XLarge:  InstanceType = "c5n.4xlarge";
export let C5nInstance9XLarge:  InstanceType = "c5n.9xlarge";
export let C5nInstanceLarge:    InstanceType = "c5n.large";
export let C5nInstanceXLarge:   InstanceType = "c5n.xlarge";
export let D2Instance2XLarge:   InstanceType = "d2.2xlarge";
export let D2Instance4XLarge:   InstanceType = "d2.4xlarge";
export let D2Instance8XLarge:   InstanceType = "d2.8xlarge";
export let D2InstanceXLarge:    InstanceType = "d2.xlarge";
export let F1Instance16XLarge:  InstanceType = "f1.16xlarge";
export let F1Instance2XLarge:   InstanceType = "f1.2xlarge";
export let G2Instance2XLarge:   InstanceType = "g2.2xlarge";
export let G2Instance8XLarge:   InstanceType = "g2.8xlarge";
export let G3Instance16XLarge:  InstanceType = "g3.16xlarge";
export let G3Instance4XLarge:   InstanceType = "g3.4xlarge";
export let G3Instance8XLarge:   InstanceType = "g3.8xlarge";
export let G3sInstanceXLarge:   InstanceType = "g3s.xlarge";
export let H1Instance16XLarge:  InstanceType = "h1.16xlarge";
export let H1Instance2XLarge:   InstanceType = "h1.2xlarge";
export let H1Instance4XLarge:   InstanceType = "h1.4xlarge";
export let H1Instance8XLarge:   InstanceType = "h1.8xlarge";
export let Hs1Instance8XLarge:  InstanceType = "hs1.8xlarge";
export let I3Instance16XLarge:  InstanceType = "i3.16xlarge";
export let I3Instance2XLarge:   InstanceType = "i3.2xlarge";
export let I3Instance4XLarge:   InstanceType = "i3.4xlarge";
export let I3Instance8XLarge:   InstanceType = "i3.8xlarge";
export let I3InstanceLarge:     InstanceType = "i3.large";
export let I3InstanceXLarge:    InstanceType = "i3.xlarge";
export let I3InstanceMetal:     InstanceType = "i3.metal";
export let M3Instance2XLarge:   InstanceType = "m3.2xlarge";
export let M3InstanceLarge:     InstanceType = "m3.large";
export let M3InstanceMedium:    InstanceType = "m3.medium";
export let M3InstanceXLarge:    InstanceType = "m3.xlarge";
export let M4Instance10XLarge:  InstanceType = "m4.10xlarge";
export let M4Instance16XLarge:  InstanceType = "m4.16xlarge";
export let M4Instance2XLarge:   InstanceType = "m4.2xlarge";
export let M4Instance4XLarge:   InstanceType = "m4.4xlarge";
export let M4InstanceLarge:     InstanceType = "m4.large";
export let M4InstanceXLarge:    InstanceType = "m4.xlarge";
export let M5InstanceLarge:     InstanceType = "m5.large";
export let M5InstanceXLarge:    InstanceType = "m5.xlarge";
export let M5Instance2XLarge:   InstanceType = "m5.2xlarge";
export let M5Instance4XLarge:   InstanceType = "m5.4xlarge";
export let M5Instance12XLarge:  InstanceType = "m5.12xlarge";
export let M5Instance24XLarge:  InstanceType = "m5.24xlarge";
export let M5dInstanceLarge:    InstanceType = "m5d.large";
export let M5dInstanceXLarge:   InstanceType = "m5d.xlarge";
export let M5dInstance2XLarge:  InstanceType = "m5d.2xlarge";
export let M5dInstance4XLarge:  InstanceType = "m5d.4xlarge";
export let M5dInstance12XLarge: InstanceType = "m5d.12xlarge";
export let M5dInstance24XLarge: InstanceType = "m5d.24xlarge";
export let M5aInstance12XLarge: InstanceType = "m5a.12xlarge";
export let M5aInstance24XLarge: InstanceType = "m5a.24xlarge";
export let M5aInstance2XLarge:  InstanceType = "m5a.2xlarge";
export let M5aInstance4XLarge:  InstanceType = "m5a.4xlarge";
export let M5aInstanceLarge:    InstanceType = "m5a.large";
export let M5aInstanceXLarge:   InstanceType = "m5a.xlarge";
export let P2Instance16XLarge:  InstanceType = "p2.16xlarge";
export let P2Instance8XLarge:   InstanceType = "p2.8xlarge";
export let P2InstanceXLarge:    InstanceType = "p2.xlarge";
export let P3Instance16XLarge:  InstanceType = "p3.16xlarge";
export let P3Instance2XLarge:   InstanceType = "p3.2xlarge";
export let P3Instance8XLarge:   InstanceType = "p3.8xlarge";
export let P3dnInstance24XLarge:InstanceType = "p3dn.24xlarge";
export let R3Instance2XLarge:   InstanceType = "r3.2xlarge";
export let R3Instance4XLarge:   InstanceType = "r3.4xlarge";
export let R3Instance8XLarge:   InstanceType = "r3.8xlarge";
export let R3InstanceLarge:     InstanceType = "r3.large";
export let R3InstanceXLarge:    InstanceType = "r3.xlarge";
export let R4Instance16XLarge:  InstanceType = "r4.16xlarge";
export let R4Instance2XLarge:   InstanceType = "r4.2xlarge";
export let R4Instance4XLarge:   InstanceType = "r4.4xlarge";
export let R4Instance8XLarge:   InstanceType = "r4.8xlarge";
export let R4InstanceLarge:     InstanceType = "r4.large";
export let R4InstanceXLarge:    InstanceType = "r4.xlarge";
export let R5Instance12XLarge:  InstanceType = "r5.12xlarge";
export let R5Instance24XLarge:  InstanceType = "r5.24xlarge";
export let R5Instance2XLarge:   InstanceType = "r5.2xlarge";
export let R5Instance4XLarge:   InstanceType = "r5.4xlarge";
export let R5InstanceLarge:     InstanceType = "r5.large";
export let R5InstanceXLarge:    InstanceType = "r5.xlarge";
export let R5aInstance12XLarge: InstanceType = "r5a.12xlarge";
export let R5aInstance24XLarge: InstanceType = "r5a.24xlarge";
export let R5aInstance2XLarge:  InstanceType = "r5a.2xlarge";
export let R5aInstance4XLarge:  InstanceType = "r5a.4xlarge";
export let R5aInstanceLarge:    InstanceType = "r5a.large";
export let R5aInstanceXLarge:   InstanceType = "r5a.xlarge";
export let R5dInstance12XLarge: InstanceType = "r5d.12xlarge";
export let R5dInstance24XLarge: InstanceType = "r5d.24xlarge";
export let R5dInstance2XLarge:  InstanceType = "r5d.2xlarge";
export let R5dInstance4XLarge:  InstanceType = "r5d.4xlarge";
export let R5dInstanceLarge:    InstanceType = "r5d.large";
export let R5dInstanceXLarge:   InstanceType = "r5d.xlarge";
export let T2Instance2XLarge:   InstanceType = "t2.2xlarge";
export let T2InstanceLarge:     InstanceType = "t2.large";
export let T2InstanceMedium:    InstanceType = "t2.medium";
export let T2InstanceMicro:     InstanceType = "t2.micro";
export let T2InstanceNano:      InstanceType = "t2.nano";
export let T2InstanceSmall:     InstanceType = "t2.small";
export let T2InstanceXLarge:    InstanceType = "t2.xlarge";
export let T3Instance2XLarge:   InstanceType = "t3.2xlarge";
export let T3InstanceLarge:     InstanceType = "t3.large";
export let T3InstanceMedium:    InstanceType = "t3.medium";
export let T3InstanceMicro:     InstanceType = "t3.micro";
export let T3InstanceNano:      InstanceType = "t3.nano";
export let T3InstanceSmall:     InstanceType = "t3.small";
export let T3InstanceXLarge:    InstanceType = "t3.xlarge";
export let UInstance12tb1Metal: InstanceType = "u-12tb1.metal";
export let UInstance6tb1Metal:  InstanceType = "u-6tb1.metal";
export let UInstance9tb1Metal:  InstanceType = "u-9tb1.metal";
export let X1Instance16XLarge:  InstanceType = "x1.16xlarge";
export let X1Instance32XLarge:  InstanceType = "x1.32xlarge";
export let X1eInstance16XLarge: InstanceType = "x1e.16xlarge";
export let X1eInstance2XLarge:  InstanceType = "x1e.2xlarge";
export let X1eInstance32XLarge: InstanceType = "x1e.32xlarge";
export let X1eInstance4XLarge:  InstanceType = "x1e.4xlarge";
export let X1eInstance8XLarge:  InstanceType = "x1e.8xlarge";
export let X1eInstanceXLarge:   InstanceType = "x1e.xlarge";
export let Z1dInstance12XLarge: InstanceType = "z1d.12xlarge";
export let Z1dInstance2XLarge:  InstanceType = "z1d.2xlarge";
export let Z1dInstance3XLarge:  InstanceType = "z1d.3xlarge";
export let Z1dInstance6XLarge:  InstanceType = "z1d.6xlarge";
export let Z1dInstanceLarge:    InstanceType = "z1d.large";
export let Z1dInstanceXLarge:   InstanceType = "z1d.xlarge";

export type InstanceType =
    "a1.2xlarge"   |
    "a1.4xlarge"   |
    "a1.large"     |
    "a1.medium"    |
    "a1.xlarge"    |
    "c3.2xlarge"   |
    "c3.4xlarge"   |
    "c3.8xlarge"   |
    "c3.large"     |
    "c3.xlarge"    |
    "c4.2xlarge"   |
    "c4.4xlarge"   |
    "c4.8xlarge"   |
    "c4.large"     |
    "c4.xlarge"    |
    "c5.18xlarge"  |
    "c5.4xlarge"   |
    "c5.2xlarge"   |
    "c5.large"     |
    "c5.9xlarge"   |
    "c5d.18xlarge" |
    "c5.xlarge"    |
    "c5d.4xlarge"  |
    "c5d.2xlarge"  |
    "c5d.large"    |
    "c5d.9xlarge"  |
    "c5n.18xlarge" |
    "c5d.xlarge"   |
    "c5n.4xlarge"  |
    "c5n.2xlarge"  |
    "c5n.9xlarge"  |
    "c5n.large"    |
    "c5n.xlarge"   |
    "d2.2xlarge"   |
    "d2.4xlarge"   |
    "d2.8xlarge"   |
    "d2.xlarge"    |
    "f1.16xlarge"  |
    "f1.2xlarge"   |
    "g2.2xlarge"   |
    "g2.8xlarge"   |
    "g3.16xlarge"  |
    "g3.4xlarge"   |
    "g3.8xlarge"   |
    "g3s.xlarge"   |
    "h1.16xlarge"  |
    "h1.2xlarge"   |
    "h1.4xlarge"   |
    "h1.8xlarge"   |
    "hs1.8xlarge"  |
    "i3.16xlarge"  |
    "i3.2xlarge"   |
    "i3.4xlarge"   |
    "i3.8xlarge"   |
    "i3.large"     |
    "i3.xlarge"    |
    "i3.metal"     |
    "m3.2xlarge"   |
    "m3.large"     |
    "m3.medium"    |
    "m3.xlarge"    |
    "m4.10xlarge"  |
    "m4.16xlarge"  |
    "m4.2xlarge"   |
    "m4.4xlarge"   |
    "m4.large"     |
    "m4.xlarge"    |
    "m5.large"     |
    "m5.xlarge"    |
    "m5.2xlarge"   |
    "m5.4xlarge"   |
    "m5.12xlarge"  |
    "m5.24xlarge"  |
    "m5d.large"    |
    "m5d.xlarge"   |
    "m5d.2xlarge"  |
    "m5d.4xlarge"  |
    "m5d.12xlarge" |
    "m5d.24xlarge" |
    "m5a.12xlarge" |
    "m5a.24xlarge" |
    "m5a.2xlarge"  |
    "m5a.4xlarge"  |
    "m5a.large"    |
    "m5a.xlarge"   |
    "p2.16xlarge"  |
    "p2.8xlarge"   |
    "p2.xlarge"    |
    "p3.16xlarge"  |
    "p3.8xlarge"   |
    "p3.2xlarge"   |
    "p3dn.24xlarge"|
    "r3.2xlarge"   |
    "r3.4xlarge"   |
    "r3.8xlarge"   |
    "r3.large"     |
    "r3.xlarge"    |
    "r4.16xlarge"  |
    "r4.2xlarge"   |
    "r4.4xlarge"   |
    "r4.8xlarge"   |
    "r4.large"     |
    "r4.xlarge"    |
    "r5.12xlarge"  |
    "r5.24xlarge"  |
    "r5.2xlarge"   |
    "r5.4xlarge"   |
    "r5.large"     |
    "r5.xlarge"    |
    "r5a.12xlarge" |
    "r5a.24xlarge" |
    "r5a.2xlarge"  |
    "r5a.4xlarge"  |
    "r5a.large"    |
    "r5a.xlarge"   |
    "r5d.12xlarge" |
    "r5d.24xlarge" |
    "r5d.2xlarge"  |
    "r5d.4xlarge"  |
    "r5d.large"    |
    "r5d.xlarge"   |
    "t2.2xlarge"   |
    "t2.large"     |
    "t2.medium"    |
    "t2.micro"     |
    "t2.nano"      |
    "t2.small"     |
    "t2.xlarge"    |
    "t3.2xlarge"   |
    "t3.large"     |
    "t3.medium"    |
    "t3.micro"     |
    "t3.nano"      |
    "t3.small"     |
    "t3.xlarge"    |
    "u-12tb1.metal"|
    "u-6tb1.metal" |
    "u-9tb1.metal" |
    "x1.16xlarge"  |
    "x1.32xlarge"  |
    "x1e.16xlarge" |
    "x1e.2xlarge"  |
    "x1e.32xlarge" |
    "x1e.4xlarge"  |
    "x1e.8xlarge"  |
    "x1e.xlarge"   |
    "z1d.12xlarge" |
    "z1d.2xlarge"  |
    "z1d.3xlarge"  |
    "z1d.6xlarge"  |
    "z1d.large"    |
    "z1d.xlarge"   ;

