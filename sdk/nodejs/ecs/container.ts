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
import * as pulumi from "@pulumi/pulumi";

export interface ContainerDefinition {
    command?: string[];
    cpu?: number;
    dependsOn?: ContainerDependency[];
    disableNetworking?: boolean;
    dnsSearchDomains?: string[];
    dnsServers?: string[];
    dockerLabels?: { [label: string]: string };
    dockerSecurityOptions?: string[];
    entryPoint?: string[];
    environment?: KeyValuePair[];
    essential?: boolean;
    extraHosts?: HostEntry[];
    firelensConfiguration?: FirelensConfiguration;
    healthCheck?: HealthCheck;
    hostname?: string;
    image?: string;
    interactive?: boolean;
    links?: string[];
    linuxParameters?: LinuxParameters;
    logConfiguration?: LogConfiguration;
    memory?: number;
    memoryReservation?: number;
    mountPoints?: MountPoint[];
    name: string;
    portMappings?: PortMapping[];
    privileged?: boolean;
    pseudoTerminal?: boolean;
    readonlyRootFilesystem?: boolean;
    repositoryCredentials?: RepositoryCredentials;
    resourceRequirements?: ResourceRequirements[];
    secrets?: Secret[];
    startTimeout?: number;
    stopTimeout?: number;
    systemControls?: SystemControl[];
    ulimits?: Ulimit[];
    user?: string;
    volumesFrom?: VolumeFrom[];
    workingDirectory?: string;
}

// https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_ContainerDependency.html
export interface ContainerDependency {
    containerName?: string;
    condition?: string;
}

// https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_KeyValuePair.html
export interface KeyValuePair {
    name: string;
    value: string;
}

// https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_FirelensConfiguration.html
export interface FirelensConfiguration {
    options?: { [key: string]: string};
    type: string;
}

/**
 * The health check command and associated configuration parameters for the container. This
 * parameter maps to HealthCheck in the Create a container section of the Docker Remote API and the
 * HEALTHCHECK parameter of docker run.
 *
 * https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_HealthCheck.html
 */
export interface HealthCheck {
    /**
     * A string array representing the command that the container runs to determine if it is
     * healthy. The string array must start with CMD to execute the command arguments directly, or
     * CMD-SHELL to run the command with the container's default shell. For example:
     *
     * [ "CMD-SHELL", "curl -f http://localhost/ || exit 1" ]
     *
     * An exit code of 0 indicates success, and non-zero exit code indicates failure. For more
     * information, see HealthCheck in the Create a container section of the Docker Remote API.
     */
    command?: string[];

    /**
     * The time period in seconds between each health check execution. You may specify between 5 and
     * 300 seconds. The default value is 30 seconds.
     */
    interval?: number;

    /**
     * The number of times to retry a failed health check before the container is considered
     * unhealthy. You may specify between 1 and 10 retries. The default value is 3.
     */
    retries?: number;

    /**
     * The optional grace period within which to provide containers time to bootstrap before failed
     * health checks count towards the maximum number of retries. You may specify between 0 and 300
     * seconds. The startPeriod is disabled by default.
     *
     * Note:
     * If a health check succeeds within the startPeriod, then the container is considered healthy
     * and any subsequent failures count toward the maximum number of retries.
     */
    startPeriod?: number;

    /**
     * The time period in seconds to wait for a health check to succeed before it is considered a
     * failure. You may specify between 2 and 60 seconds. The default value is 5.
     */
    timeout?: number;
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
export type LogDriver = "json-file" | "syslog" | "journald" | "gelf" | "fluentd" | "awslogs" | "splunk" | "awsfirelens";

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

// See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_RepositoryCredentials.html
export interface RepositoryCredentials {
    credentialsParameter: string;
}

/**
 * The type and amount of a resource to assign to a container. The only supported resource is a GPU.
 * For more information, see [Working with GPUs on Amazon
 * ECS](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ecs-gpu.html) in the Amazon
 * Elastic Container Service Developer Guide.
 * 
 * See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_ResourceRequirement.html.
 */
export interface ResourceRequirements {
    /**
     * The type of resource to assign to a container. The only supported value is GPU.
     */
    type: string;
    /**
     * The number of physical GPUs the Amazon ECS container agent will reserve for the container.
     * The number of GPUs reserved for all containers in a task should not exceed the number of
     * available GPUs on the container instance the task is launched on.
     */
    value: string;
}

/**
 * An object representing the secret to expose to your container. Secrets can be exposed to a
 * container in the following ways:
 *
 * * To inject sensitive data into your containers as environment variables, use the secrets
 *   container definition parameter.
 *
 * * To reference sensitive information in the log configuration of a container, use the
 *   secretOptions container definition parameter.
 *
 * For more information, see [Specifying Sensitive
 * Data](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/specifying-sensitive-data.html)
 * in the Amazon Elastic Container Service Developer Guide.
 * 
 * See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_Secret.html.
 */
export interface Secret {
    /** 
     * The name of the secret.
     */
    name: string;

    /**
     * The secret to expose to the container. The supported values are either the full ARN of the
     * AWS Secrets Manager secret or the full ARN of the parameter in the AWS Systems Manager
     * Parameter Store.
     *
     * Note: If the AWS Systems Manager Parameter Store parameter exists in the same Region as the
     * task you are launching, then you can use either the full ARN or name of the parameter. If the
     * parameter exists in a different Region, then the full ARN must be specified.
     */
    valueFrom: pulumi.Input<string>;
}

/**
 * A list of namespaced kernel parameters to set in the container. This parameter maps to Sysctls in
 * the [Create a container](https://docs.docker.com/engine/api/v1.35/#operation/ContainerCreate)
 * section of the Docker Remote API and the --sysctl option to docker run.
 *
 * It is not recommended that you specify network-related systemControls parameters for multiple
 * containers in a single task that also uses either the awsvpc or host network mode for the
 * following reasons:
 *
 * * For tasks that use the awsvpc network mode, if you set systemControls for any container, it
 *   applies to all containers in the task. If you set different systemControls for multiple
 *   containers in a single task, the container that is started last determines which systemControls
 *   take effect.
 * * For tasks that use the host network mode, the systemControls parameter applies to the container
 *   instance's kernel parameter as well as that of all containers of any tasks running on that
 *   container instance.
 * 
 * See https://docs.aws.amazon.com/AmazonECS/latest/APIReference/API_SystemControl.html.
 */
export interface SystemControl {
    /**
     * The namespaced kernel parameter for which to set a value.
     */
    namespace?: string;
    
    /**
     * The value for the namespaced kernel parameter specified in namespace.
     */
    value?: string;
}
