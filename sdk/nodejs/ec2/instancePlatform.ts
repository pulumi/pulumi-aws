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

// This file contains individual constants for each EC2 Instance platform.
//
// These constants will not be updated with new values.
// It is recommended to use InstancePlatform.[Value] instead.

import {InstancePlatform} from ".";

/** Use InstancePlatform instead. */
export module InstancePlatforms {
    /** Use InstancePlatform.LinuxUnix instead. */
    export const LinuxUnixPlatform: InstancePlatform = "Linux/UNIX";
    /** Use InstancePlatform.RedHatEnterpriseLinux instead. */
    export const RedHatEnterpriseLinuxPlatform: InstancePlatform = "Red Hat Enterprise Linux";
    /** Use InstancePlatform.SuseLinux instead. */
    export const SuseLinuxPlatform: InstancePlatform = "SUSE Linux";
    /** Use InstancePlatform.Windows instead. */
    export const WindowsPlatform: InstancePlatform = "Windows";
    /** Use InstancePlatform.WindowsWithSqlServer instead. */
    export const WindowsWithSqlServerPlatform: InstancePlatform = "Windows with SQL Server";
    /** Use InstancePlatform.WindowsWithSqlServerEnterprise instead. */
    export const WindowsWithSqlServerEnterprisePlatform: InstancePlatform = "Windows with SQL Server Enterprise";
    /** Use InstancePlatform.WindowsWithSqlServerStandard instead. */
    export const WindowsWithSqlServerStandardPlatform: InstancePlatform = "Windows with SQL Server Standard";
    /** Use InstancePlatform.WindowsWithSqlServerWeb instead. */
    export const WindowsWithSqlServerWebPlatform: InstancePlatform = "Windows with SQL Server Web";
}

/**
 * @deprecated Use InstancePlatform.LinuxUnix instead.
 */
export const LinuxUnixPlatform: InstancePlatform = "Linux/UNIX";
/**
 *@deprecated Use InstancePlatform.RedHatEnterpriseLinux instead.
 */
export const RedHatEnterpriseLinuxPlatform: InstancePlatform = "Red Hat Enterprise Linux";
/**
 *@deprecated Use InstancePlatform.SuseLinux instead.
 */
export const SuseLinuxPlatform: InstancePlatform = "SUSE Linux";
/**
 *@deprecated Use InstancePlatform.Windows instead.
 */
export const WindowsPlatform: InstancePlatform = "Windows";
/**
 *@deprecated Use InstancePlatform.WindowsWithSqlServer instead.
 */
export const WindowsWithSqlServerPlatform: InstancePlatform = "Windows with SQL Server";
/**
 *@deprecated Use InstancePlatform.WindowsWithSqlServerEnterprise instead.
 */
export const WindowsWithSqlServerEnterprisePlatform: InstancePlatform = "Windows with SQL Server Enterprise";
/**
 *@deprecated Use InstancePlatform.WindowsWithSqlServerStandard instead.
 */
export const WindowsWithSqlServerStandardPlatform: InstancePlatform = "Windows with SQL Server Standard";
/**
 *@deprecated Use InstancePlatform.WindowsWithSqlServerWeb instead.
 */
export const WindowsWithSqlServerWebPlatform: InstancePlatform = "Windows with SQL Server Web";
