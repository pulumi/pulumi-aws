// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsStandardHlsSettingsM3u8SettingsArgs : global::Pulumi.ResourceArgs
    {
        [Input("audioFramesPerPes")]
        public Input<int>? AudioFramesPerPes { get; set; }

        [Input("audioPids")]
        public Input<string>? AudioPids { get; set; }

        [Input("ecmPid")]
        public Input<string>? EcmPid { get; set; }

        [Input("nielsenId3Behavior")]
        public Input<string>? NielsenId3Behavior { get; set; }

        [Input("patInterval")]
        public Input<int>? PatInterval { get; set; }

        [Input("pcrControl")]
        public Input<string>? PcrControl { get; set; }

        [Input("pcrPeriod")]
        public Input<int>? PcrPeriod { get; set; }

        [Input("pcrPid")]
        public Input<string>? PcrPid { get; set; }

        [Input("pmtInterval")]
        public Input<int>? PmtInterval { get; set; }

        [Input("pmtPid")]
        public Input<string>? PmtPid { get; set; }

        [Input("programNum")]
        public Input<int>? ProgramNum { get; set; }

        [Input("scte35Behavior")]
        public Input<string>? Scte35Behavior { get; set; }

        /// <summary>
        /// PID from which to read SCTE-35 messages.
        /// </summary>
        [Input("scte35Pid")]
        public Input<string>? Scte35Pid { get; set; }

        [Input("timedMetadataBehavior")]
        public Input<string>? TimedMetadataBehavior { get; set; }

        [Input("timedMetadataPid")]
        public Input<string>? TimedMetadataPid { get; set; }

        [Input("transportStreamId")]
        public Input<int>? TransportStreamId { get; set; }

        [Input("videoPid")]
        public Input<string>? VideoPid { get; set; }

        public ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsStandardHlsSettingsM3u8SettingsArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsStandardHlsSettingsM3u8SettingsArgs Empty => new ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsHlsSettingsStandardHlsSettingsM3u8SettingsArgs();
    }
}
