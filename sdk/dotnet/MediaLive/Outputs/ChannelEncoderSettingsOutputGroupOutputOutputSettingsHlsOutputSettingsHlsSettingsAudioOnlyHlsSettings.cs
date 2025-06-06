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
    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettings
    {
        public readonly string? AudioGroupId;
        public readonly Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsAudioOnlyImage? AudioOnlyImage;
        public readonly string? AudioTrackType;
        public readonly string? SegmentType;

        [OutputConstructor]
        private ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettings(
            string? audioGroupId,

            Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsAudioOnlyImage? audioOnlyImage,

            string? audioTrackType,

            string? segmentType)
        {
            AudioGroupId = audioGroupId;
            AudioOnlyImage = audioOnlyImage;
            AudioTrackType = audioTrackType;
            SegmentType = segmentType;
        }
    }
}
