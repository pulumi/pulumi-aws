// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class SpaceSpaceSettingsSpaceStorageSettings
    {
        /// <summary>
        /// A collection of EBS storage settings for a space. See `ebs_storage_settings` Block below.
        /// </summary>
        public readonly Outputs.SpaceSpaceSettingsSpaceStorageSettingsEbsStorageSettings EbsStorageSettings;

        [OutputConstructor]
        private SpaceSpaceSettingsSpaceStorageSettings(Outputs.SpaceSpaceSettingsSpaceStorageSettingsEbsStorageSettings ebsStorageSettings)
        {
            EbsStorageSettings = ebsStorageSettings;
        }
    }
}
