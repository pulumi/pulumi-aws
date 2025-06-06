// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class SpaceSpaceSettingsSpaceStorageSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A collection of EBS storage settings for a space. See `ebs_storage_settings` Block below.
        /// </summary>
        [Input("ebsStorageSettings", required: true)]
        public Input<Inputs.SpaceSpaceSettingsSpaceStorageSettingsEbsStorageSettingsArgs> EbsStorageSettings { get; set; } = null!;

        public SpaceSpaceSettingsSpaceStorageSettingsArgs()
        {
        }
        public static new SpaceSpaceSettingsSpaceStorageSettingsArgs Empty => new SpaceSpaceSettingsSpaceStorageSettingsArgs();
    }
}
