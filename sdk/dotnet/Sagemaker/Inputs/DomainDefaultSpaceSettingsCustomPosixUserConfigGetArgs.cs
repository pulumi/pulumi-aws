// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DomainDefaultSpaceSettingsCustomPosixUserConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The POSIX group ID.
        /// </summary>
        [Input("gid", required: true)]
        public Input<int> Gid { get; set; } = null!;

        /// <summary>
        /// The POSIX user ID.
        /// </summary>
        [Input("uid", required: true)]
        public Input<int> Uid { get; set; } = null!;

        public DomainDefaultSpaceSettingsCustomPosixUserConfigGetArgs()
        {
        }
        public static new DomainDefaultSpaceSettingsCustomPosixUserConfigGetArgs Empty => new DomainDefaultSpaceSettingsCustomPosixUserConfigGetArgs();
    }
}
