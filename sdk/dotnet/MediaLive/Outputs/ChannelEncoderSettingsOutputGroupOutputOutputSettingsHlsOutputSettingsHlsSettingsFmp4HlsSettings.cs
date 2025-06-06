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
    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsFmp4HlsSettings
    {
        public readonly string? AudioRenditionSets;
        public readonly string? NielsenId3Behavior;
        public readonly string? TimedMetadataBehavior;

        [OutputConstructor]
        private ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsFmp4HlsSettings(
            string? audioRenditionSets,

            string? nielsenId3Behavior,

            string? timedMetadataBehavior)
        {
            AudioRenditionSets = audioRenditionSets;
            NielsenId3Behavior = nielsenId3Behavior;
            TimedMetadataBehavior = timedMetadataBehavior;
        }
    }
}
