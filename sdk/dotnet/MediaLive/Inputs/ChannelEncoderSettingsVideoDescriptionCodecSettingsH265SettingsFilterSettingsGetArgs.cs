// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsFilterSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("temporalFilterSettings")]
        public Input<Inputs.ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsFilterSettingsTemporalFilterSettingsGetArgs>? TemporalFilterSettings { get; set; }

        public ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsFilterSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsFilterSettingsGetArgs Empty => new ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsFilterSettingsGetArgs();
    }
}
