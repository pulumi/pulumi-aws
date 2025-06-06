// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Archive output settings. See Archive Output Settings for more details.
        /// </summary>
        [Input("archiveOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsArchiveOutputSettingsArgs>? ArchiveOutputSettings { get; set; }

        [Input("frameCaptureOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsFrameCaptureOutputSettingsArgs>? FrameCaptureOutputSettings { get; set; }

        [Input("hlsOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsHlsOutputSettingsArgs>? HlsOutputSettings { get; set; }

        /// <summary>
        /// Media package output settings. This can be set as an empty block.
        /// </summary>
        [Input("mediaPackageOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsMediaPackageOutputSettingsArgs>? MediaPackageOutputSettings { get; set; }

        [Input("msSmoothOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsMsSmoothOutputSettingsArgs>? MsSmoothOutputSettings { get; set; }

        /// <summary>
        /// Multiplex output settings. See Multiplex Output Settings for more details.
        /// </summary>
        [Input("multiplexOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsMultiplexOutputSettingsArgs>? MultiplexOutputSettings { get; set; }

        /// <summary>
        /// RTMP output settings. See RTMP Output Settings for more details.
        /// </summary>
        [Input("rtmpOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsArgs>? RtmpOutputSettings { get; set; }

        /// <summary>
        /// UDP output settings. See UDP Output Settings for more details.
        /// </summary>
        [Input("udpOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsArgs>? UdpOutputSettings { get; set; }

        public ChannelEncoderSettingsOutputGroupOutputOutputSettingsArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputOutputSettingsArgs Empty => new ChannelEncoderSettingsOutputGroupOutputOutputSettingsArgs();
    }
}
