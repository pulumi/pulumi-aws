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
export let D2Instance2XLarge:   InstanceType = "d2.2xlarge";
export let D2Instance4XLarge:   InstanceType = "d2.4xlarge";
export let D2Instance8XLarge:   InstanceType = "d2.8xlarge";
export let D2InstanceXLarge:    InstanceType = "d2.xlarge";
export let F1Instance16XLarge:  InstanceType = "f1.16xlarge";
export let F1Instance2XLarge:   InstanceType = "f1.2xlarge";
export let G2Instance2XLarge:   InstanceType = "g2.2xlarge";
export let G2Instance8XLarge:   InstanceType = "g2.8xlarge";
export let I3Instance16XLarge:  InstanceType = "i3.16xlarge";
export let I3Instance2XLarge:   InstanceType = "i3.2xlarge";
export let I3Instance4XLarge:   InstanceType = "i3.4xlarge";
export let I3Instance8XLarge:   InstanceType = "i3.8xlarge";
export let I3InstanceLarge:     InstanceType = "i3.large";
export let I3InstanceXLarge:    InstanceType = "i3.xlarge";
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
export let P2Instance16XLarge:  InstanceType = "p2.16xlarge";
export let P2Instance8XLarge:   InstanceType = "p2.8xlarge";
export let P2InstanceXLarge:    InstanceType = "p2.xlarge";
export let P3Instance16XLarge:  InstanceType = "p3.16xlarge";
export let P3Instance2XLarge:   InstanceType = "p3.2xlarge";
export let P3Instance8XLarge:   InstanceType = "p3.8xlarge";
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
export let T2Instance2XLarge:   InstanceType = "t2.2xlarge";
export let T2InstanceLarge:     InstanceType = "t2.large";
export let T2InstanceMedium:    InstanceType = "t2.medium";
export let T2InstanceMicro:     InstanceType = "t2.micro";
export let T2InstanceNano:      InstanceType = "t2.nano";
export let T2InstanceSmall:     InstanceType = "t2.small";
export let T2InstanceXLarge:    InstanceType = "t2.xlarge";
export let X1Instance16XLarge:  InstanceType = "x1.16xlarge";
export let X1Instance32XLarge:  InstanceType = "x1.32xlarge";

export type InstanceType =
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
    "d2.2xlarge"   |
    "d2.4xlarge"   |
    "d2.8xlarge"   |
    "d2.xlarge"    |
    "f1.16xlarge"  |
    "f1.2xlarge"   |
    "g2.2xlarge"   |
    "g2.8xlarge"   |
    "i3.16xlarge"  |
    "i3.2xlarge"   |
    "i3.4xlarge"   |
    "i3.8xlarge"   |
    "i3.large"     |
    "i3.xlarge"    |
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
    "p2.16xlarge"  |
    "p2.8xlarge"   |
    "p2.xlarge"    |
    "p3.16xlarge"  |
    "p3.8xlarge"   |
    "p3.2xlarge"   |
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
    "t2.2xlarge"   |
    "t2.large"     |
    "t2.medium"    |
    "t2.micro"     |
    "t2.nano"      |
    "t2.small"     |
    "t2.xlarge"    |
    "x1.16xlarge"  |
    "x1.32xlarge"  ;

