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
    public sealed class DirectorySelfServicePermissions
    {
        /// <summary>
        /// Whether WorkSpaces directory users can change the compute type (bundle) for their workspace. Default `false`.
        /// </summary>
        public readonly bool? ChangeComputeType;
        /// <summary>
        /// Whether WorkSpaces directory users can increase the volume size of the drives on their workspace. Default `false`.
        /// </summary>
        public readonly bool? IncreaseVolumeSize;
        /// <summary>
        /// Whether WorkSpaces directory users can rebuild the operating system of a workspace to its original state. Default `false`.
        /// </summary>
        public readonly bool? RebuildWorkspace;
        /// <summary>
        /// Whether WorkSpaces directory users can restart their workspace. Default `true`.
        /// </summary>
        public readonly bool? RestartWorkspace;
        /// <summary>
        /// Whether WorkSpaces directory users can switch the running mode of their workspace. Default `false`.
        /// </summary>
        public readonly bool? SwitchRunningMode;

        [OutputConstructor]
        private DirectorySelfServicePermissions(
            bool? changeComputeType,

            bool? increaseVolumeSize,

            bool? rebuildWorkspace,

            bool? restartWorkspace,

            bool? switchRunningMode)
        {
            ChangeComputeType = changeComputeType;
            IncreaseVolumeSize = increaseVolumeSize;
            RebuildWorkspace = rebuildWorkspace;
            RestartWorkspace = restartWorkspace;
            SwitchRunningMode = switchRunningMode;
        }
    }
}
