// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Outputs
{

    [OutputType]
    public sealed class ChannelEncoderSettingsCaptionDescriptionDestinationSettingsTtmlDestinationSettings
    {
        /// <summary>
        /// This field is not currently supported and will not affect the output styling. Leave the default value.
        /// </summary>
        public readonly string StyleControl;

        [OutputConstructor]
        private ChannelEncoderSettingsCaptionDescriptionDestinationSettingsTtmlDestinationSettings(string styleControl)
        {
            StyleControl = styleControl;
        }
    }
}
