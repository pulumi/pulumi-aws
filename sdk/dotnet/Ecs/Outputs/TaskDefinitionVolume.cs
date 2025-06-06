// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class TaskDefinitionVolume
    {
        /// <summary>
        /// Whether the volume should be configured at launch time. This is used to create Amazon EBS volumes for standalone tasks or tasks created as part of a service. Each task definition revision may only have one volume configured at launch in the volume configuration.
        /// </summary>
        public readonly bool? ConfigureAtLaunch;
        /// <summary>
        /// Configuration block to configure a docker volume. Detailed below.
        /// </summary>
        public readonly Outputs.TaskDefinitionVolumeDockerVolumeConfiguration? DockerVolumeConfiguration;
        /// <summary>
        /// Configuration block for an EFS volume. Detailed below.
        /// </summary>
        public readonly Outputs.TaskDefinitionVolumeEfsVolumeConfiguration? EfsVolumeConfiguration;
        /// <summary>
        /// Configuration block for an FSX Windows File Server volume. Detailed below.
        /// </summary>
        public readonly Outputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfiguration? FsxWindowsFileServerVolumeConfiguration;
        /// <summary>
        /// Path on the host container instance that is presented to the container. If not set, ECS will create a nonpersistent data volume that starts empty and is deleted after the task has finished.
        /// </summary>
        public readonly string? HostPath;
        /// <summary>
        /// Name of the volume. This name is referenced in the `sourceVolume`
        /// parameter of container definition in the `mountPoints` section.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private TaskDefinitionVolume(
            bool? configureAtLaunch,

            Outputs.TaskDefinitionVolumeDockerVolumeConfiguration? dockerVolumeConfiguration,

            Outputs.TaskDefinitionVolumeEfsVolumeConfiguration? efsVolumeConfiguration,

            Outputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfiguration? fsxWindowsFileServerVolumeConfiguration,

            string? hostPath,

            string name)
        {
            ConfigureAtLaunch = configureAtLaunch;
            DockerVolumeConfiguration = dockerVolumeConfiguration;
            EfsVolumeConfiguration = efsVolumeConfiguration;
            FsxWindowsFileServerVolumeConfiguration = fsxWindowsFileServerVolumeConfiguration;
            HostPath = hostPath;
            Name = name;
        }
    }
}
