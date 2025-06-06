// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Workspaces.Outputs
{

    [OutputType]
    public sealed class WorkspaceWorkspaceProperties
    {
        /// <summary>
        /// The compute type. For more information, see [Amazon WorkSpaces Bundles](http://aws.amazon.com/workspaces/details/#Amazon_WorkSpaces_Bundles). Valid values are `VALUE`, `STANDARD`, `PERFORMANCE`, `POWER`, `GRAPHICS`, `POWERPRO`, `GRAPHICSPRO`, `GRAPHICS_G4DN`, and `GRAPHICSPRO_G4DN`.
        /// </summary>
        public readonly string? ComputeTypeName;
        /// <summary>
        /// The size of the root volume.
        /// </summary>
        public readonly int? RootVolumeSizeGib;
        /// <summary>
        /// The running mode. For more information, see [Manage the WorkSpace Running Mode](https://docs.aws.amazon.com/workspaces/latest/adminguide/running-mode.html). Valid values are `AUTO_STOP` and `ALWAYS_ON`.
        /// </summary>
        public readonly string? RunningMode;
        /// <summary>
        /// The time after a user logs off when WorkSpaces are automatically stopped. Configured in 60-minute intervals.
        /// </summary>
        public readonly int? RunningModeAutoStopTimeoutInMinutes;
        /// <summary>
        /// The size of the user storage.
        /// </summary>
        public readonly int? UserVolumeSizeGib;

        [OutputConstructor]
        private WorkspaceWorkspaceProperties(
            string? computeTypeName,

            int? rootVolumeSizeGib,

            string? runningMode,

            int? runningModeAutoStopTimeoutInMinutes,

            int? userVolumeSizeGib)
        {
            ComputeTypeName = computeTypeName;
            RootVolumeSizeGib = rootVolumeSizeGib;
            RunningMode = runningMode;
            RunningModeAutoStopTimeoutInMinutes = runningModeAutoStopTimeoutInMinutes;
            UserVolumeSizeGib = userVolumeSizeGib;
        }
    }
}
