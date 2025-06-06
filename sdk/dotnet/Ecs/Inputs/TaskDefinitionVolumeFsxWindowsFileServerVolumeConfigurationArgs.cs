// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for authorization for the Amazon FSx for Windows File Server file system detailed below.
        /// </summary>
        [Input("authorizationConfig", required: true)]
        public Input<Inputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs> AuthorizationConfig { get; set; } = null!;

        /// <summary>
        /// The Amazon FSx for Windows File Server file system ID to use.
        /// </summary>
        [Input("fileSystemId", required: true)]
        public Input<string> FileSystemId { get; set; } = null!;

        /// <summary>
        /// The directory within the Amazon FSx for Windows File Server file system to mount as the root directory inside the host.
        /// </summary>
        [Input("rootDirectory", required: true)]
        public Input<string> RootDirectory { get; set; } = null!;

        public TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs()
        {
        }
        public static new TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs Empty => new TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs();
    }
}
