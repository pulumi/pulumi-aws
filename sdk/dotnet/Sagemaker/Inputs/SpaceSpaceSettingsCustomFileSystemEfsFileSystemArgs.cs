// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class SpaceSpaceSettingsCustomFileSystemEfsFileSystemArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of your Amazon EFS file system.
        /// </summary>
        [Input("fileSystemId", required: true)]
        public Input<string> FileSystemId { get; set; } = null!;

        public SpaceSpaceSettingsCustomFileSystemEfsFileSystemArgs()
        {
        }
        public static new SpaceSpaceSettingsCustomFileSystemEfsFileSystemArgs Empty => new SpaceSpaceSettingsCustomFileSystemEfsFileSystemArgs();
    }
}
