// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Setting to allow self signed or verified RTMP certificates.
        /// </summary>
        [Input("certificateMode")]
        public Input<string>? CertificateMode { get; set; }

        /// <summary>
        /// Number of seconds to wait before retrying connection to the flash media server if the connection is lost.
        /// </summary>
        [Input("connectionRetryInterval")]
        public Input<int>? ConnectionRetryInterval { get; set; }

        /// <summary>
        /// The RTMP endpoint excluding the stream name. See Destination for more details.
        /// </summary>
        [Input("destination", required: true)]
        public Input<Inputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsDestinationArgs> Destination { get; set; } = null!;

        /// <summary>
        /// Number of retry attempts.
        /// </summary>
        [Input("numRetries")]
        public Input<int>? NumRetries { get; set; }

        public ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsArgs Empty => new ChannelEncoderSettingsOutputGroupOutputOutputSettingsRtmpOutputSettingsArgs();
    }
}
