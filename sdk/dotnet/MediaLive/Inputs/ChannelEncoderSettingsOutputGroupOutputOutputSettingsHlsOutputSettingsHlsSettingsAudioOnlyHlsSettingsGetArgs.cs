// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("audioGroupId")]
        public Input<string>? AudioGroupId { get; set; }

        [Input("audioOnlyImage")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsAudioOnlyImageGetArgs>? AudioOnlyImage { get; set; }

        [Input("audioTrackType")]
        public Input<string>? AudioTrackType { get; set; }

        [Input("segmentType")]
        public Input<string>? SegmentType { get; set; }

        public ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsGetArgs Empty => new ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsAudioOnlyHlsSettingsGetArgs();
    }
}
