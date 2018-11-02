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
//     1) A union type, InstancePlatform, that accepts any valid EC2 platform.
//     2) Individual constants for each such EC2 platform.
//
// These just give a better developer experience and are just sugared strings.

export const LinuxUnixPlatform:                      InstancePlatform = "Linux/UNIX";
export const RedHatEnterpriseLinuxPlatform:          InstancePlatform = "Red Hat Enterprise Linux";
export const SuseLinuxPlatform:                      InstancePlatform = "SUSE Linux";
export const WindowsPlatform:                        InstancePlatform = "Windows";
export const WindowsWithSqlServerPlatform:           InstancePlatform = "Windows with SQL Server";
export const WindowsWithSqlServerEnterprisePlatform: InstancePlatform = "Windows with SQL Server Enterprise";
export const WindowsWithSqlServerStandardPlatform:   InstancePlatform = "Windows with SQL Server Standard";
export const WindowsWithSqlServerWebPlatform:        InstancePlatform = "Windows with SQL Server Web";

export type InstancePlatform =
    "Linux/UNIX"                         |
    "Red Hat Enterprise Linux"           |
    "SUSE Linux"                         |
    "Windows"                            |
    "Windows with SQL Server"            |
    "Windows with SQL Server Enterprise" |
    "Windows with SQL Server Standard"   |
    "Windows with SQL Server Web"        ;

