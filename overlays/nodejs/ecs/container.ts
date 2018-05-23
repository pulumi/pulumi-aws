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

// This file defines interfaces that match the structure of ECS Container definitions used in task definitions to
// describe the different containers that are launched as part of a task.

// See http://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_ContainerDefinition.html
export interface ContainerDefinition {
    command?: string[];
    cpu?: number;
    disableNetworking?: boolean;
    dnsSearchDomains?: string[];
    dnsServers?: string[];
    dockerLabels?: { [label: string]: string };
    dockerSecurityOptions?: string[];
    entryPoint?: string[];
    environment?: KeyValuePair[];
    essential?: boolean;
    extraHosts?: HostEntry[];
    hostname?: string;
    image?: string;
    links?: string[];
    linuxParameters?: LinuxParameters;
    logConfiguration?: LogConfiguration;
    memory?: number;
    memoryReservation?: number;
    mountPoints?: MountPoint[];
    name: string;
    portMappings?: PortMapping[];
    privileged?: boolean;
    readonlyRootFilesystem?: boolean;
    ulimits?: Ulimit[];
    user?: string;
    volumesFrom?: VolumeFrom[];
    workingDirectory?: string;
}

// https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_KeyValuePair.html
export interface KeyValuePair {
    name: string;
    value: string;
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_HostEntry.html
export interface HostEntry {
    hostname: string;
    ipAddress: string;
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_LinuxParameters.html
export interface LinuxParameters {
    capabilities?: KernelCapabilities;
    devices?: Device[];
    initProcessEnabled?: boolean;
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_KernelCapabilities.html
export interface KernelCapabilities {
    add?: KernelCapability[];
    drop?: KernelCapability[];
}

// See http://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_KernelCapabilities.html
export type KernelCapability = "ALL" | "AUDIT_CONTROL" | "AUDIT_WRITE" | "BLOCK_SUSPEND" | "CHOWN" | "DAC_OVERRIDE" |
    "DAC_READ_SEARCH" | "FOWNER" | "FSETID" | "IPC_LOCK" | "IPC_OWNER" | "KILL" | "LEASE" | "LINUX_IMMUTABLE" |
    "MAC_ADMIN" | "MAC_OVERRIDE" | "MKNOD" | "NET_ADMIN" | "NET_BIND_SERVICE" | "NET_BROADCAST" | "NET_RAW" |
    "SETFCAP" | "SETGID" | "SETPCAP" | "SETUID" | "SYS_ADMIN" | "SYS_BOOT" | "SYS_CHROOT" | "SYS_MODULE" |
    "SYS_NICE" | "SYS_PACCT" | "SYS_PTRACE" | "SYS_RAWIO" | "SYS_RESOURCE" | "SYS_TIME" | "SYS_TTY_CONFIG" |
    "SYSLOG" | "WAKE_ALARM";

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_Device.html
export interface Device {
    containerPath?: string;
    hostPath: string;
    permissions?: string[];
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_LogConfiguration.html
export interface LogConfiguration {
    logDriver:  LogDriver;
    options?: { [key: string]: string };
}

// See `logdriver` at http://docs.aws.amazon.com/AmazonECS/latest/developerguide/task_definition_parameters.html
export type LogDriver = "json-file" | "syslog" | "journald" | "gelf" | "fluentd" | "awslogs" | "splunk";

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_MountPoint.html
export interface MountPoint {
    containerPath?: string;
    readOnly?: boolean;
    sourceVolume?: string
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_PortMapping.html
export interface PortMapping {
    containerPort?: number;
    hostPort?: number;
    protocol?: Protocol;
}

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_PortMapping.html
export type Protocol = "tcp" | "udp";

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_Ulimit.html
export interface Ulimit {
    name: UlimitName;
    hardLimit: number;
    softLimit: number;
}

// See http://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_Ulimit.html
export type UlimitName = "core" | "cpu" | "data" | "fsize" | "locks" | "memlock" | "msgqueue" | "nice" |
    "nofile" | "nproc" | "rss" | "rtprio" | "rttime" | "sigpending" | "stack";

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_VolumeFrom.html
export interface VolumeFrom {
    sourceContainer?: string;
    readOnly?: boolean
}
