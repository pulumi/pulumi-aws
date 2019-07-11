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

export module StorageTypes {
    export const Standard: StorageType = "standard";
    export const GP2:      StorageType = "gp2";
    export const Io1:      StorageType = "io1";
}

export type StorageType =
    "standard" |
    "gp2"      |
    "io1"      ;


