// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// UDP output buffering in milliseconds.
        /// </summary>
        [Input("bufferMsec")]
        public Input<int>? BufferMsec { get; set; }

        /// <summary>
        /// UDP container settings. See Container Settings for more details.
        /// </summary>
        [Input("containerSettings", required: true)]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsContainerSettingsGetArgs> ContainerSettings { get; set; } = null!;

        /// <summary>
        /// Destination address and port number for RTP or UDP packets. See Destination for more details.
        /// </summary>
        [Input("destination", required: true)]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsDestinationGetArgs> Destination { get; set; } = null!;

        [Input("fecOutputSettings")]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsFecOutputSettingsGetArgs>? FecOutputSettings { get; set; }

        public ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsGetArgs Empty => new ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsGetArgs();
    }
}
